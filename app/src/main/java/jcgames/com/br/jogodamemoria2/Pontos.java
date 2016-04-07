package jcgames.com.br.jogodamemoria2;

/**
 * Created by Aluno on 07/04/2016.
 */
public class Pontos {
    private int pontos = 0;
    private long inicioJogo;
    private long fimJogo;

    public Pontos(){
        pontos = 0;
    }

    public void inicaJogo(){ this.inicioJogo = System.currentTimeMillis(); }


    public void finalJogo() { this.fimJogo = System.currentTimeMillis(); }


    public int getPontos(){ return  this.pontos; }


    public void setPontos(int pt){ this.pontos+=pt; }


    public int calculaPontos(){
        int totalPontos = 0;
        //converte o tempo de jogo para segundos.
        long diferenca = inicioJogo - fimJogo;


        int segundos = (int)(diferenca / 1000);


        setPontos(segundos);


        return totalPontos;
    }
}
