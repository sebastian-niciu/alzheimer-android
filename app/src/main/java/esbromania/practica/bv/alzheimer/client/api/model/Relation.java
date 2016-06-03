package esbromania.practica.bv.alzheimer.client.api.model;

/**
 * Created by Noemi95 on 2016.05.27..
 */
public class Relation {


    private String pacient;
    private String careTaker;

    public String getPacient() {
        return pacient;
    }

    public String getCareTaker() {
        return careTaker;
    }

    public void setPacient(String pacient) {
        this.pacient = pacient;
    }

    public void setCareTaker(String careTaker) {
        this.careTaker = careTaker;
    }
}
