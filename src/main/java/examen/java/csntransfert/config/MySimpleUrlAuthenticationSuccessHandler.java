package examen.java.csntransfert.config;

import examen.java.csntransfert.model.Admin;
import examen.java.csntransfert.model.Caissier;
import examen.java.csntransfert.model.SuperAdmin;
import examen.java.csntransfert.model.Utilisateur;
import examen.java.csntransfert.repository.SuperAdminRepository;
import examen.java.csntransfert.repository.UtilisateurRepository;
import examen.java.csntransfert.service.CustumUserDetailsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

@SuppressWarnings("unused")
public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{

    protected Log logger = LogFactory.getLog(this.getClass());

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private Utilisateur u;
    private SuperAdmin sp;
    private Caissier c;
    private Admin a;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException
    {

        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }

    protected void handle(HttpServletRequest request,
                          HttpServletResponse response, Authentication authentication)
            throws IOException
    {

        String targetUrl = determineTargetUrl(authentication);

        request.getSession().setAttribute("connectedUser", sp);
        if (response.isCommitted())
        {
            logger.debug(
                    "Response has already been committed. Unable to redirect to "
                            + targetUrl);
            return;
        }


        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    @Autowired
    private UtilisateurRepository iUtilisateur;

    @Autowired
    private SuperAdminRepository superAdminRepository;

    @Autowired
    private CustumUserDetailsService userDetailsService;

    protected String determineTargetUrl(Authentication authentication)
    {
        boolean isSuperAdmin = false;
        boolean isAdmin = false;
        boolean isUser = false;
        Collection<? extends GrantedAuthority> authorities
                = authentication.getAuthorities();
        String role = "";
        for (GrantedAuthority grantedAuthority : authorities)
        {
            if (grantedAuthority.getAuthority().equals("ROLE_SUPERADMIN"))
            {
                role = grantedAuthority.getAuthority();
                isSuperAdmin = true;
                break;
            }
            else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN"))
            {
                role = grantedAuthority.getAuthority();
                isAdmin = true;
                break;
            }else if(grantedAuthority.getAuthority().equals("ROLE_ADMIN"))
            {
                role = grantedAuthority.getAuthority();
                isUser = true;
                break;
            }
            System.out.println("role : " + role);
        }


        u = new Utilisateur();
        sp = new SuperAdmin();
        a = new Admin();
        c = new Caissier();

        if (isSuperAdmin)
            return "/superAdmin/login.xhtml";
        else if(isAdmin)
            return "/admin/login.xhtml";
        else if(isUser)
            return "/caissier/login.xhtml";
        else
            return "/acceuil";


    }

    protected void clearAuthenticationAttributes(HttpServletRequest request)
    {
        HttpSession session = request.getSession(false);
        if (session == null)
        {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy)
    {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy()
    {
        return redirectStrategy;
    }

}