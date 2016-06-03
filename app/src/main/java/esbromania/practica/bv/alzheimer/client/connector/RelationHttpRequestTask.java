package esbromania.practica.bv.alzheimer.client.connector;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import esbromania.practica.bv.alzheimer.client.api.model.Relation;

/**
 * Created by Noemi95 on 2016.05.27..
 */
public class RelationHttpRequestTask extends AsyncTask<Relation, Void,Void> {

    private OnOperationCompleted listener;

    public RelationHttpRequestTask(OnOperationCompleted listener) {
        this.listener = listener;
    }


    @Override
    protected Void doInBackground(Relation... params) {
        try {

            final String baseurl = "http://192.168.43.175:8080/alzheimer-server/";
            Relation rel = params[0];
           String url =baseurl +"caretakers/"+rel.getCareTaker()+"/patients/"+rel.getPacient();
         RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            // restTemplate.getForObject(url, Greeting.class);
          restTemplate.put(url,null);
       } catch (Exception e) {
          Log.e("RelativeActivity", e.getMessage(), e);
        }

     return null;
      //  return "S-a inserat cu succes: "+params[0]+" "+params[1];
    }


}

