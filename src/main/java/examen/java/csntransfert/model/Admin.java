package examen.java.csntransfert.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 13, nullable = false)
    private int cni;
    @Column(length = 10, nullable = false)
    private int matricule;
    @Column(length = 50, nullable = false)
    private String prenom;
    @Column(length = 50, nullable = false)
    private String nom;
    @Column(length = 50,nullable = false)
    private String date_naissance;
    @Column(length = 50, nullable = false)
    private String lieu_naissance;
    @Column(length = 50, nullable = false)
    private String adresse;
    @Column(length = 9, nullable = false)
    private int tel;
    @Column(length = 50, nullable = false)
    private String email;
    @Column(length = 255, nullable = false)
    private String photo;
    @Column(length = 50, nullable = true)
    private String mot_passe;
    @Column(length = 50, nullable = true)
    private String username;
    @Column(length = 50,nullable = true)
    private String date_creation;
    @ManyToOne
    @JoinColumn(name ="idSuperAdmin", nullable = true)
    private SuperAdmin superAdmin;
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Caissier> caissiers;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    public Admin()
    {
        super();
    }

    public Admin(int cni, int matricule, String prenom, String nom, String date_naissance, String lieu_naissance, String adresse, int tel, String email, String photo, String mot_passe, String date_creation) {
        this.cni = cni;
        this.matricule = matricule;
        this.prenom = prenom;
        this.nom = nom;
        this.date_naissance = date_naissance;
        this.lieu_naissance = lieu_naissance;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
        this.photo = photo;
        this.mot_passe = mot_passe;
        this.date_creation = date_creation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCni() {
        return cni;
    }

    public void setCni(int cni) {
        this.cni = cni;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getLieu_naissance() {
        return lieu_naissance;
    }

    public void setLieu_naissance(String lieu_naissance) {
        this.lieu_naissance = lieu_naissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMot_passe() {
        return mot_passe;
    }

    public void setMot_passe(String mot_passe) {
        this.mot_passe = mot_passe;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public SuperAdmin getSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(SuperAdmin superAdmin) {
        this.superAdmin = superAdmin;
    }

    public List<Caissier> getCaissiers() {
        return caissiers;
    }

    public void setCaissiers(List<Caissier> caissiers) {
        this.caissiers = caissiers;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
