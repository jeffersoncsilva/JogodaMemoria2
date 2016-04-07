package jcgames.com.br.jogodamemoria2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by Aluno on 31/03/2016.
 */
public class Card {
    //private static final Bitmap facedDown = BitmapFactory.decodeResource(getResources(), R.drawable.img_0);

    private int idImagem;
    private String nomeImgView;
    private Bitmap facedUp;
    private Bitmap facedDown;
    private boolean isFacedUp;
    private ImageView img;

    public Card(int id, Context context){
        //carrega a img da card
        isFacedUp = false;
        this.idImagem = id;
        this.facedUp = BitmapFactory.decodeResource(context.getResources(), id);
        this.facedDown = BitmapFactory.decodeResource(context.getResources(), R.drawable.img_0);
        Log.i("idcard", "ID: " + id);
    }


    public void voltaImg(){
        setIsFacedUp(false);
        img.setImageBitmap(getBitmap());
    }


    public Bitmap getBitmap() {
        if (isFacedUp)
            return this.facedUp;
        else
            return this.facedDown;
    }




    public void setImageView(ImageView im){this.img = im;}

    public int getIdImagem(){return  this.idImagem;}
    public boolean getFaced(){ return this.isFacedUp; }
    public void setIsFacedUp(boolean value){this.isFacedUp = value;}
    public String getNomeImgView() {return this.nomeImgView;}
    public void setNomeImgView(String nome){this.nomeImgView = nome;}
}
