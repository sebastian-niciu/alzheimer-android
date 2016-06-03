package esbromania.practica.bv.alzheimer.client.api.model;

/**
 * Created by adi on 5/30/16.
 */
public class MyLocation {
    private String latitude;
    private String longitude;
    private Long timestamp;

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
