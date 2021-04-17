package examen.java.csntransfert.repository;

import examen.java.csntransfert.model.SuperAdmin;
import examen.java.csntransfert.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperAdminRepository extends JpaRepository<SuperAdmin,Long> {
    public SuperAdmin findByUsername(String username);
}

