package examen.java.csntransfert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuperAdmincontroller {


    @GetMapping({"/SuperAdminLogin"})
    public String SuperAdminLogin()
    {
        return "superadmin/login.xhtml";
    }
}
