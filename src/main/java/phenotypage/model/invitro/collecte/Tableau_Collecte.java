package phenotypage.model.invitro.collecte;

import phenotypage.model.vache.Vache;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class Tableau_Collecte {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String race_Ovaires;

    @Column
    private int nombre_Ovaires;

    @Column
    private int nombre_Ovocytes;

    @Column
    private float taux_Collecte;

    @ManyToOne
    private Vache vache;

    @Column
    private Time heureDebutMaturation;

    @Column
    private Time heureFiv;

    @Column
    private boolean pool;

    public Tableau_Collecte() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRace_Ovaires() {
        return race_Ovaires;
    }

    public void setRace_Ovaires(String race_Ovaires) {
        this.race_Ovaires = race_Ovaires;
    }

    public int getNombre_Ovaires() {
        return nombre_Ovaires;
    }

    public void setNombre_Ovaires(int nombre_Ovaires) {
        this.nombre_Ovaires = nombre_Ovaires;
    }

    public int getNombre_Ovocytes() {
        return nombre_Ovocytes;
    }

    public void setNombre_Ovocytes(int nombre_Ovocytes) {
        this.nombre_Ovocytes = nombre_Ovocytes;
    }

    public float getTaux_Collecte() {
        return taux_Collecte;
    }

    public void setTaux_Collecte(float taux_Collecte) {
        this.taux_Collecte = taux_Collecte;
    }

    public Vache getVache() {
        return vache;
    }

    public void setVache(Vache vache) {
        this.vache = vache;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public Time getHeureDebutMaturation() {
        return heureDebutMaturation;
    }

    public void setHeureDebutMaturation(Time heureDebutMaturation) {
        this.heureDebutMaturation = heureDebutMaturation;
    }

    public Time getHeureFiv() {
        return heureFiv;
    }

    public void setHeureFiv(Time heureFiv) {
        this.heureFiv = heureFiv;
    }
}
