package jcgames.com.br.jogodamemoria2;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.Executor;


/**
 * Created by Jefferson on 06/04/2016.
 */
public class ChangeImageTask extends AsyncTask<Void, Void, Void> {
    private TextView txtPontos;

    public ChangeImageTask(TextView txtPt) {
        this.txtPontos = txtPt;
    }


    @Override
    protected Void doInBackground(Void... params) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        try {
            if (CartasControler.cartasViradas.get(0).getIdImagem() == CartasControler.cartasViradas.get(1).getIdImagem()) {
                CartasControler.cartasViradas.clear();
                CartasControler.qtdCartasViradas = 0;
                CartasControler.pontos += 5;
                txtPontos.setText("Pontos: " + CartasControler.pontos);
            } else {
                CartasControler.cartasViradas.get(0).voltaImg();
                CartasControler.cartasViradas.get(1).voltaImg();
                CartasControler.cartasViradas.clear();
                CartasControler.qtdCartasViradas = 0;
            }
        } catch (Exception e) {
            Log.i("ERRO", "ERRO: " + e.toString());
        }
    }
}
