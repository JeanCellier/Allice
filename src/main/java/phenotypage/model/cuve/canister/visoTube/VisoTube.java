package phenotypage.model.cuve.canister.visoTube;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by nicolas on 20/05/17.
 */
@MappedSuperclass
public abstract class VisoTube {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String couleur;

    public VisoTube() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}
