package examen.java.csntransfert.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Beneficiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long b_id;
    @Column(length = 13, nullable = false)
    private int b_cni;
    @Column(length = 50, nullable = false)
    private String b_prenom;
    @Column(length = 50, nullable = false)
    private String b_nom;
    @Column(length = 50, nullable = false)
    private String b_adresse;
    @Column(length = 50, nullable = true)
    private String b_email;
    @Column(length = 9, nullable = false)
    private int b_tel;
    @OneToMany(mappedBy = "beneficiaire", cascade = CascadeType.ALL)
    private List<Transfert> transferts;

    public Beneficiaire()
    {
        super();
    }

    public Beneficiaire(int b_cni, String b_prenom, String b_nom, String b_adresse, String b_email, int b_tel) {
        this.b_cni = b_cni;
        this.b_prenom = b_prenom;
        this.b_nom = b_nom;
        this.b_adresse = b_adresse;
        this.b_email = b_email;
        this.b_tel = b_tel;
    }

    public Long getB_id() {
        return b_id;
    }

    public void setB_id(Long b_id) {
        this.b_id = b_id;
    }

    public int getB_cni() {
        return b_cni;
    }

    public void setB_cni(int b_cni) {
        this.b_cni = b_cni;
    }

    public String getB_prenom() {
        return b_prenom;
    }

    public void setB_prenom(String b_prenom) {
        this.b_prenom = b_prenom;
    }

    public String getB_nom() {
        return b_nom;
    }

    public void setB_nom(String b_nom) {
        this.b_nom = b_nom;
    }

    public String getB_adresse() {
        return b_adresse;
    }

    public void setB_adresse(String b_adresse) {
        this.b_adresse = b_adresse;
    }

    public String getB_email() {
        return b_email;
    }

    public void setB_email(String b_email) {
        this.b_email = b_email;
    }

    public int getB_tel() {
        return b_tel;
    }

    public void setB_tel(int b_tel) {
        this.b_tel = b_tel;
    }
}
