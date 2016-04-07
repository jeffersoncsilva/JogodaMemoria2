package jcgames.com.br.jogodamemoria2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Aluno on 31/03/2016.
 */
public class MedioActivity extends Activity {
    private CartasControler controlador;
    TextView txtPontos;

    @Override
    protected void onCreate(Bundle savedInstaceBundle){
        super.onCreate(savedInstaceBundle);
        setContentView(R.layout.mediu_activity);

        txtPontos = (TextView)findViewById(R.id.txtPontos);
        txtPontos.setText("Pontos: 0");


        controlador = new CartasControler(12, getBaseContext(), txtPontos, this);
    }


    @Override
    protected void onDestroy(){
        super.onDestroy();
        destroyObjetos();

    }


    public void destroyObjetos(){
        controlador = null;
        System.gc();
    }



    public void cliqueImg(View v){
        this.controlador.imgClicada(v);
    }
}
