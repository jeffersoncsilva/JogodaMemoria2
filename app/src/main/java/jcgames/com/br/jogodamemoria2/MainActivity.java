package jcgames.com.br.jogodamemoria2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    Button facil;
    Button medio;
    Button dificio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        facil  = (Button)findViewById(R.id.btnFacil);
        facil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent telaFacil = new Intent(MainActivity.this, FacilActivity.class);
                startActivity(telaFacil);
            }
        });
        */

    }


    public void escolhaDificuldade(View v){
        Button btn = (Button)v;
        switch (btn.getId()){
            case R.id.btnFacil:
                Intent telaFacil = new Intent(MainActivity.this, FacilActivity.class);
                startActivity(telaFacil);
                break;

            case R.id.btMedio:
                Intent telaMedio = new Intent(MainActivity.this, MedioActivity.class);
                startActivity(telaMedio);
                break;

            case R.id.brDificil:
                Intent telaDificio = new Intent(MainActivity.this, DificioActivity.class);
                startActivity(telaDificio);
                break;
        }

    }


}
