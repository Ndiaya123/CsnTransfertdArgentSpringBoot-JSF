package examen.java.csntransfert.service;

import examen.java.csntransfert.model.Utilisateur;
import examen.java.csntransfert.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
//ou @Component
public class CustumUserDetailsService implements UserDetailsService
{
    @Autowired
    private UtilisateurRepository userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        // TODO Auto-generated method stub
        Utilisateur user = userDAO.findByLogin(username);
        return user;
    }

}
