package esbromania.practica.bv.alzheimer.client;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import esbromania.practica.bv.alzheimer.client.api.model.Greeting;
import esbromania.practica.bv.alzheimer.client.api.model.Relation;
import esbromania.practica.bv.alzheimer.client.connector.OnOperationCompleted;
import esbromania.practica.bv.alzheimer.client.connector.RelationHttpRequestTask;

public class RelationActivity extends AppCompatActivity implements OnOperationCompleted{

    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relation);
    }

    public void onClickButton(View v){
        EditText edit =  (EditText) findViewById(R.id.pacient);
        String pacient = edit.getText().toString();
        edit =  (EditText) findViewById(R.id.careTaker);
        String careTaker =  edit.getText().toString();
        Relation rel= new Relation();
         rel.setPacient(pacient);
         rel.setCareTaker(careTaker);
      new RelationHttpRequestTask(this).execute(rel);
    }



    @Override
    public void onGetResponse(String message) {
     TextView mes = (TextView) findViewById(R.id.message);
        mes.setText(message);

    }
    public void onGetResponse(Greeting greeting) {


    }
}
