package esbromania.practica.bv.alzheimer.client;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import esbromania.practica.bv.alzheimer.client.api.model.Greeting;
import esbromania.practica.bv.alzheimer.client.connector.HttpRequestTask;
import esbromania.practica.bv.alzheimer.client.connector.OnOperationCompleted;
import esbromania.practica.bv.alzheimer.client.fragment.PlaceholderFragment;

public class MainActivity extends Activity implements OnOperationCompleted {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.add(R.id.container, new PlaceholderFragment());
            fragmentTransaction.commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        new HttpRequestTask(this).execute();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            new HttpRequestTask(this).execute();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onGetResponse(Greeting greeting) {
        TextView greetingIdText = (TextView) findViewById(R.id.id_value);
        TextView greetingContentText = (TextView) findViewById(R.id.content_value);
        greetingIdText.setText(greeting.getId());
        greetingContentText.setText(greeting.getContent());
    }
}
