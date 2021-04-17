package examen.java.csntransfert.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Envoyeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long e_id;
    @Column(length = 13, nullable = false)
    private int e_cni;
    @Column(length = 50, nullable = false)
    private String e_prenom;
    @Column(length = 50, nullable = false)
    private String e_nom;
    @Column(length = 50, nullable = false)
    private String e_adresse;
    @Column(nullable = false)
    private LocalDate e_date_naissance;
    @Column(length = 50, nullable = false)
    private String e_lieu_naissance;
    @Column(length = 9, nullable = false)
    private int e_tel;
    @Column(length = 50, nullable = false)
    private String e_email;
    @Column(length = 255, nullable = false)
    private String e_photo;
    @Column(nullable = false)
    private Date e_date_creation;
    @OneToMany(mappedBy = "envoyeur", cascade = CascadeType.ALL)
    private List<Transfert> transferts;

    public Envoyeur()
    {
        super();
    }

    public Envoyeur(int e_cni, String e_prenom, String e_nom, String e_adresse, LocalDate e_date_naissance, String e_lieu_naissance, int e_tel, String e_email, String e_photo, Date e_date_creation) {
        this.e_cni = e_cni;
        this.e_prenom = e_prenom;
        this.e_nom = e_nom;
        this.e_adresse = e_adresse;
        this.e_date_naissance = e_date_naissance;
        this.e_lieu_naissance = e_lieu_naissance;
        this.e_tel = e_tel;
        this.e_email = e_email;
        this.e_photo = e_photo;
        this.e_date_creation = e_date_creation;
    }

    public int getE_cni() {
        return e_cni;
    }

    public void setE_cni(int e_cni) {
        this.e_cni = e_cni;
    }

    public String getE_prenom() {
        return e_prenom;
    }

    public void setE_prenom(String e_prenom) {
        this.e_prenom = e_prenom;
    }

    public String getE_nom() {
        return e_nom;
    }

    public void setE_nom(String e_nom) {
        this.e_nom = e_nom;
    }

    public String getE_adresse() {
        return e_adresse;
    }

    public void setE_adresse(String e_adresse) {
        this.e_adresse = e_adresse;
    }

    public LocalDate getE_date_naissance() {
        return e_date_naissance;
    }

    public void setE_date_naissance(LocalDate e_date_naissance) {
        this.e_date_naissance = e_date_naissance;
    }

    public String getE_lieu_naissance() {
        return e_lieu_naissance;
    }

    public void setE_lieu_naissance(String e_lieu_naissance) {
        this.e_lieu_naissance = e_lieu_naissance;
    }

    public int getE_tel() {
        return e_tel;
    }

    public void setE_tel(int e_tel) {
        this.e_tel = e_tel;
    }

    public String getE_email() {
        return e_email;
    }

    public void setE_email(String e_email) {
        this.e_email = e_email;
    }

    public String getE_photo() {
        return e_photo;
    }

    public void setE_photo(String e_photo) {
        this.e_photo = e_photo;
    }

    public Date getE_date_creation() {
        return e_date_creation;
    }

    public void setE_date_creation(Date e_date_creation) {
        this.e_date_creation = e_date_creation;
    }
}
