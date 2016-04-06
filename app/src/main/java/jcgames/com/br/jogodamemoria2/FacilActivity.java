package jcgames.com.br.jogodamemoria2;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Aluno on 31/03/2016.
 */
public class FacilActivity extends Activity {
    CartasControler controlador;
    TextView txtPontos;
    LinearLayout layoutFinal;


    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.facil_activity);


        txtPontos = (TextView)findViewById(R.id.txtPontos);
        txtPontos.setText("Pontos: 0");


       // layoutFinal = (LinearLayout)findViewById(R.id.menuFinal);
       // layoutFinal.setEnabled(false);


        controlador = new CartasControler(8, getBaseContext(), txtPontos);
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
