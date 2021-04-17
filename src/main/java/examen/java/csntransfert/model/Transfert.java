package examen.java.csntransfert.model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Transfert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long e_id;
    @Column(length = 10, nullable = false)
    private int t_numero_transfert;
    @Column(length = 10, nullable = false)
    private int t_code_transfert;
    @Column(length = 10, nullable = false)
    private int t_montant;
    @Column(length = 1, nullable = false)
    private int t_etat;
    @Column(nullable = false)
    private Date t_date_creation;
    @Column(nullable = false)
    private Date  t_date_retrait;
    @Column(length = 10,nullable = false)
    private int  t_commission_systeme;
    @Column(length = 10,nullable = false)
    private int t_commission_taxe_etat;
    @Column(length = 10,nullable = false)
    private int t_commission_caissier;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="idEnvoyeur", nullable = true)
    private Envoyeur envoyeur;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="idBeneficiaire", nullable = true)
    private Beneficiaire beneficiaire;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="idCaissier", nullable = true)
    private Caissier caissier;

  public Transfert()
  {
      super();
  }

    public Transfert(int t_numero_transfert, int t_code_transfert, int t_montant, int t_etat, Date t_date_creation, Date t_date_retrait, int t_commission_systeme, int t_commission_taxe_etat, int t_commission_caissier, Envoyeur envoyeur, Beneficiaire beneficiaire, Caissier caissier) {
        this.t_numero_transfert = t_numero_transfert;
        this.t_code_transfert = t_code_transfert;
        this.t_montant = t_montant;
        this.t_etat = t_etat;
        this.t_date_creation = t_date_creation;
        this.t_date_retrait = t_date_retrait;
        this.t_commission_systeme = t_commission_systeme;
        this.t_commission_taxe_etat = t_commission_taxe_etat;
        this.t_commission_caissier = t_commission_caissier;
        this.envoyeur = envoyeur;
        this.beneficiaire = beneficiaire;
        this.caissier = caissier;
    }

    public Long getE_id() {
        return e_id;
    }

    public void setE_id(Long e_id) {
        this.e_id = e_id;
    }

    public int getT_numero_transfert() {
        return t_numero_transfert;
    }

    public void setT_numero_transfert(int t_numero_transfert) {
        this.t_numero_transfert = t_numero_transfert;
    }

    public int getT_code_transfert() {
        return t_code_transfert;
    }

    public void setT_code_transfert(int t_code_transfert) {
        this.t_code_transfert = t_code_transfert;
    }

    public int getT_montant() {
        return t_montant;
    }

    public void setT_montant(int t_montant) {
        this.t_montant = t_montant;
    }

    public int getT_etat() {
        return t_etat;
    }

    public void setT_etat(int t_etat) {
        this.t_etat = t_etat;
    }

    public Date getT_date_creation() {
        return t_date_creation;
    }

    public void setT_date_creation(Date t_date_creation) {
        this.t_date_creation = t_date_creation;
    }

    public Date getT_date_retrait() {
        return t_date_retrait;
    }

    public void setT_date_retrait(Date t_date_retrait) {
        this.t_date_retrait = t_date_retrait;
    }

    public int getT_commission_systeme() {
        return t_commission_systeme;
    }

    public void setT_commission_systeme(int t_commission_systeme) {
        this.t_commission_systeme = t_commission_systeme;
    }

    public int getT_commission_taxe_etat() {
        return t_commission_taxe_etat;
    }

    public void setT_commission_taxe_etat(int t_commission_taxe_etat) {
        this.t_commission_taxe_etat = t_commission_taxe_etat;
    }

    public int getT_commission_caissier() {
        return t_commission_caissier;
    }

    public void setT_commission_caissier(int t_commission_caissier) {
        this.t_commission_caissier = t_commission_caissier;
    }

    public Envoyeur getEnvoyeur() {
        return envoyeur;
    }

    public void setEnvoyeur(Envoyeur envoyeur) {
        this.envoyeur = envoyeur;
    }

    public Beneficiaire getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(Beneficiaire beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public Caissier getCaissier() {
        return caissier;
    }

    public void setCaissier(Caissier caissier) {
        this.caissier = caissier;
    }
}
