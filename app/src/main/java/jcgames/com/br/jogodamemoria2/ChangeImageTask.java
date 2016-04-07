package jcgames.com.br.jogodamemoria2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;


/**
 * Created by Jefferson on 06/04/2016.
 */
public class ChangeImageTask extends AsyncTask<Void, Void, Void> {

    private TextView txtPontos;
    private Activity act;
    private Pontos pts;
    boolean cartasIguais;


    public ChangeImageTask(TextView txtPt, Activity ac, Pontos pt) {
        this.txtPontos = txtPt;
        this.act = ac;
        this.pts = pt;
    }


    @Override
    protected Void doInBackground(Void... params) {
        try {
            Thread.sleep(500);
            cartasIguais = (CartasControler.cartasViradas.get(0).getIdImagem() == CartasControler.cartasViradas.get(1).getIdImagem());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    protected void onPostExecute(Void result) {
        try {
           // if (CartasControler.cartasViradas.get(0).getIdImagem() == CartasControler.cartasViradas.get(1).getIdImagem()) {

            if(cartasIguais){
                CartasControler.cartasViradas.clear();
                CartasControler.qtdCartasViradas = 0;
                pts.setPontos(5);
                txtPontos.setText("Pontos: " + pts.getPontos());
            } else {
                CartasControler.cartasViradas.get(0).voltaImg();
                CartasControler.cartasViradas.get(1).voltaImg();
                CartasControler.cartasViradas.clear();
                CartasControler.qtdCartasViradas = 0;
            }

            if(CartasControler.gameOver){
                //o jogo acabou, mostra o menu de fim de jogo.

                LayoutInflater inflater = (LayoutInflater) this.act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view  = inflater.inflate(R.layout.menu_final, null, false);
                TextView ed = (TextView)view.findViewById(R.id.txtPontosFinal);
                Button btn = (Button)view.findViewById(R.id.btnVoltaMenuInicio);



                ed.setText(""+pts.getPontos());
                btn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        Intent irMenuInicio = new Intent(act, MainActivity.class);
                        act.startActivity(irMenuInicio);
                    }
                });



                PopupWindow pw = new PopupWindow(view,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT, true);

                LinearLayout layout = new LinearLayout(act);

                pw.showAtLocation(layout, Gravity.CENTER, 0, 0);



            }
        } catch (Exception e) {
            Log.i("ERRO", "ERRO: " + e.toString());
        }
    }


}