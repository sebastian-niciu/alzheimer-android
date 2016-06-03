package esbromania.practica.bv.alzheimer.client.connector;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import esbromania.practica.bv.alzheimer.client.api.model.MyLocation;


/**
 * @author Sebastian Niciu
 */
public class LocationHttpPostTask extends AsyncTask<MyLocation, Void, Void> {



    @Override
    protected Void doInBackground(MyLocation... params) {
        try {
            final String baseurl = "http://192.168.43.187:8080/alzheimer-server/locations/patients/1";


            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            restTemplate.postForObject(baseurl, params[0],Void.class );



        } catch (Exception e) {
            Log.e("LocationRequestActivity", e.getMessage(), e);
        }
        return null;


    }

}
