package jcgames.com.br.jogodamemoria2;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class CartasControler {
    static final int QTD_IMAGENS_JOGO = 15;
    static final int[] IMGS = new int[]{ R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5, R.drawable.img_6,
            R.drawable.img_7, R.drawable.img_8, R.drawable.img_9, R.drawable.img_10, R.drawable.img_11, R.drawable.img_12,
            R.drawable.img_13, R.drawable.img_14, R.drawable.img_15};

    private int pontos = 0;
    private int qtdCartasEmJogo;
    private int qtdCartasViradas;

    private Context context;
    private ArrayList<Card> cards;
    private ArrayList<Card> cartasViradas;
    private TextView txtPontos;

    private Timer timer;

    public CartasControler(int qtdCartas, Context context, TextView txtPt){
        this.txtPontos = txtPt;
        this.qtdCartasEmJogo = qtdCartas;
        this.context = context;
        this.cards = new ArrayList<Card>();
        this.cartasViradas = new ArrayList<>();

        criaCartas(getCartas());

        this.qtdCartasViradas = 0;

        timer = new Timer();
    }

    //para saber quantas e quais cartas serão carregadas.
    private int[] getCartas(){
        int[] cards = new int[qtdCartasEmJogo / 2];

        for(int i = 0; i < cards.length; i++){
            int a = (int)(Math.random() * QTD_IMAGENS_JOGO);
            boolean tem = false;

            for(int j = 0; j < i; j++){
                if(cards[j]==a){
                    tem = true;
                    break;
                }
            }

            if(!tem)
                cards[i] = a;
            else
                i--;
        }

        int[] cartas = new int[qtdCartasEmJogo];
        for(int i = 0; i < cartas.length; i++){
            int c = cards[(int)(Math.random() * cards.length)];
            int aux = 0;
            for(int j= 0; j < i; j++){
                if(cartas[j] == c)
                    aux+=1;
            }

            if(aux < 2)
                cartas[i] = c;
            else
                i--;
        }

        return cartas;
    }

    //para criar as cartas no jogo, para então desenhalas na tela.
    private void criaCartas(int[] cartas){
        String n = "card_";
        int id = 1;
        for(int i = 0; i < cartas.length; i++){
            Card card = new Card(IMGS[cartas[i]], this.context);
            card.setNomeImgView(n+id);
            id++;
            this.cards.add(card);
        }

    }


    public void imgClicada(View v){
        if(qtdCartasViradas<2)
            mudaImgTela((ImageView)v);

        if(qtdCartasViradas == 2){
            timer.scheduleAtFixedRate(new TimerTask(){
                public void run(){
                    verificaCartasIguais();
                    
                }
            },2,2);
        }
    }


    private void mudaImgTela(ImageView img){
        for (Card card : cards) {
            if(card.getNomeImgView().equals(img.getTag().toString())){
                card.setIsFacedUp(true);
                card.setImageView(img);
                img.setImageBitmap(card.getBitmap());
                cartasViradas.add(card);
                qtdCartasViradas++;
                break;
            }
        }
    }


    private void verificaCartasIguais(){
        //cartas iguais.
        if(cartasViradas.get(0).getIdImagem() == cartasViradas.get(1).getIdImagem()){
            cartasViradas.clear();
            qtdCartasViradas = 0;
            pontos += 5;
            qtdCartasViradas = 0;
            this.txtPontos.setText("Pontos: " + pontos);
        }else{
            cartasViradas.get(0).voltaImg();
            cartasViradas.get(1).voltaImg();
            cartasViradas.clear();
            qtdCartasViradas = 0;
        }
    }


}
