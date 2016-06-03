package esbromania.practica.bv.alzheimer.client.connector;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import esbromania.practica.bv.alzheimer.client.api.model.Greeting;

/**
 * @author Sebastian Niciu
 */
public class HttpRequestTask extends AsyncTask<Void, Void, Greeting> {

    private OnOperationCompleted listener;

    public HttpRequestTask(OnOperationCompleted listener) {
        this.listener = listener;
    }

    @Override
    protected Greeting doInBackground(Void... params) {
        try {
            final String url = "http://rest-service.guides.spring.io/greeting";

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            restTemplate.getForObject(url, Greeting.class);

            return restTemplate.getForObject(url, Greeting.class);
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }


}
