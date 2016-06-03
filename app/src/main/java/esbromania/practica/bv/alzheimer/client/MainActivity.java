package esbromania.practica.bv.alzheimer.client;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import esbromania.practica.bv.alzheimer.client.api.model.Greeting;
import esbromania.practica.bv.alzheimer.client.connector.HttpRequestTask;
import esbromania.practica.bv.alzheimer.client.connector.OnOperationCompleted;
import esbromania.practica.bv.alzheimer.client.fragment.LocationRequestActivity;
import esbromania.practica.bv.alzheimer.client.fragment.PlaceholderFragment;

public class MainActivity extends AppCompatActivity implements OnOperationCompleted  {

//   private static  Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // onClickButtonListener();
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.add(R.id.container, new PlaceholderFragment());
            fragmentTransaction.commit();
       // button2 = (Button) findViewById(R.id.button2);
        }
    }
public  void onClickButton(View v){
    Intent intent = new Intent(this,RelationActivity.class);
            startActivity(intent);
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }


//public void onClickButtonListener(){
//    button2 = (Button) findViewById(R.id.button2);
//    button2.setOnClickListener(new View.OnClickListener(){
//        public void onClick(View v){
//            Intent intent = new Intent("esbromania.practica.bv.alzheimer.client.RelationActivity");
//            startActivity(intent);
//        }
//    });





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_menu) {
            new HttpRequestTask(this).execute();
            return true;
        }
//        if( id == R.id.menu_register){
//            Intent intent = new Intent (this, RelationActivity.class); //RegisterActivity
//            startActivity(intent);
//            return  true;
//        }else
        if (id == R.id.menu_relation) {
            Intent intent = new Intent(this,RelationActivity.class);
            startActivity(intent);
            return true;
        }
        else
        if(id == R.id.menu_location){
            Intent intent = new Intent(this, LocationRequestActivity.class); //LocationRequestActivity
            startActivity(intent);
            return true;
        }


            return super.onOptionsItemSelected(item);


    }

    @Override
    public void onGetResponse(String message) {

    }
    @Override
    public void onGetResponse(Greeting greeting) {

    }


}
