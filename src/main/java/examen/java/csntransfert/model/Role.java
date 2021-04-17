package examen.java.csntransfert.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String libRole;

    @OneToMany(mappedBy = "role")
    private List<Utilisateur> utilisateurs;

    @OneToMany(mappedBy = "role")
    private List<SuperAdmin> superAdmins;

    @OneToMany(mappedBy = "role")
    private List<Caissier> caissiers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibRole() {
        return libRole;
    }

    public void setLibRole(String libRole) {
        this.libRole = libRole;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public List<SuperAdmin> getSuperAdmins() {
        return superAdmins;
    }

    public void setSuperAdmins(List<SuperAdmin> superAdmins) {
        this.superAdmins = superAdmins;
    }

    public List<Caissier> getCaissiers() {
        return caissiers;
    }

    public void setCaissiers(List<Caissier> caissiers) {
        this.caissiers = caissiers;
    }
}
