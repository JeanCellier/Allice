package phenotypage.model.JsonResponse;

/**
 * Created by nicolas on 16/03/17.
 */

public class JsonResponse {
    private Boolean succes;
    private String message;
    private Object objet;

    public JsonResponse() {
    }

    public Boolean getSucces() {
        return succes;
    }

    public void setSucces(Boolean succes) {
        this.succes = succes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObjet() {
        return objet;
    }

    public void setObjet(Object objet) {
        this.objet = objet;
    }
}
