package jcgames.com.br.jogodamemoria2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class DificioActivity extends Activity {

    private CartasControler controlador;
    private TextView txtPontos;
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.dificio_activity);


        txtPontos = (TextView)findViewById(R.id.txtPontos);
        txtPontos.setText("Pontos: 0");


        controlador = new CartasControler(24, getBaseContext(), txtPontos);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        controlador = null;
        System.gc();
    }


    public void cliqueImg(View v){
        this.controlador.imgClicada(v);
    }

}
