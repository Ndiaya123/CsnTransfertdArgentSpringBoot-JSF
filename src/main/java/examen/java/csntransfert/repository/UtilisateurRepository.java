package examen.java.csntransfert.repository;

import examen.java.csntransfert.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer>
{
    public Utilisateur findByLogin(String email);
}
