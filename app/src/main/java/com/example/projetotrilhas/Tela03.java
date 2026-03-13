package com.example.projetotrilhas;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class Tela03 extends AppCompatActivity implements View.OnClickListener {
    private ImageView img1, img2, img3, img4, imgPrimeiroToque, imgSegundoToque;
    private int imagemPrimeiroToque, imagemSegundoToque, contaToque;
    private TextView texto;
    private ArrayList<Integer> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela03);

        texto = findViewById(R.id.textView3);
        Intent i = new Intent();
        i = getIntent();
        if(i != null){
            //significa que não veio corrompido
            Bundle caixa = new Bundle();
            caixa = i.getExtras();
            if(caixa != null){
                //significa que a caixa não veio corrompida
                String x = caixa.getString("nome");
                texto.setText(x);
            }
        }
        img1 = findViewById(R.id.imageView2);
        img2 = findViewById(R.id.imageView3);
        img3 = findViewById(R.id.imageView4);
        img4 = findViewById(R.id.imageView5);
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img1.setEnabled(false);
        img2.setEnabled(false);
        img3.setEnabled(false);
        img4.setEnabled(false);

        lista = new ArrayList<Integer>();
        lista.add(R.drawable.ic_action_name_3);
        lista.add(R.drawable.ic_action_name_3);
        lista.add(R.drawable.ic_action_name_4);
        lista.add(R.drawable.ic_action_name_4);
        Collections.shuffle(lista);
        img1.setImageResource(lista.get(0));
        img2.setImageResource(lista.get(1));
        img3.setImageResource(lista.get(2));
        img4.setImageResource(lista.get(3));
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                img1.setImageResource(R.drawable.ic_action_name_2);
                img2.setImageResource(R.drawable.ic_action_name_2);
                img3.setImageResource(R.drawable.ic_action_name_2);
                img4.setImageResource(R.drawable.ic_action_name_2);
                img1.setEnabled(true);
                img2.setEnabled(true);
                img3.setEnabled(true);
                img4.setEnabled(true);


            }
        }, 3000);
        imgPrimeiroToque = new ImageView(this);
        imgSegundoToque = new ImageView(this);
        contaToque = 0;
    }
    public void compara(int imagem1, int imagem2){
        contaToque=0;
        if(imagem1 == imagem2){
              imgPrimeiroToque.setEnabled(false);
              imgPrimeiroToque.setBackgroundColor(Color.GREEN);
              imgSegundoToque.setEnabled(false);
              imgSegundoToque.setBackgroundColor(Color.GREEN);
    }else
        {
            imgPrimeiroToque.setBackgroundColor(Color.RED);
            imgSegundoToque.setBackgroundColor(Color.RED);
            Handler h = new Handler();
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    imgPrimeiroToque.setImageResource(R.drawable.ic_action_name_2);
                    imgSegundoToque.setImageResource(R.drawable.ic_action_name_2);
                    imgPrimeiroToque.setBackgroundColor(Color.WHITE);
                    imgSegundoToque.setBackgroundColor(Color.WHITE);
                }
            }, 2000);
        }
    }


    @Override
    public void onClick(View v) {
        contaToque++;

        if(v == img1){
            img1.setImageResource(lista.get(0));
            if(contaToque==1){
                imgPrimeiroToque = img1;
                imagemPrimeiroToque = lista.get(0);
            }else{
                imgSegundoToque = img1;
                imagemSegundoToque = lista.get(0);
                compara(imagemPrimeiroToque, imagemSegundoToque);
            }
        }
        if(v == img2){
            img2.setImageResource(lista.get(1));
            if(contaToque==1){
                imgPrimeiroToque = img2;
                imagemPrimeiroToque = lista.get(1);
            }else{
                imgSegundoToque = img2;
                imagemSegundoToque = lista.get(1);
                compara(imagemPrimeiroToque, imagemSegundoToque);

            }
        }
        if(v == img3){
            img3.setImageResource(lista.get(2));
            if(contaToque==1){
                imgPrimeiroToque = img3;
                imagemPrimeiroToque = lista.get(2);
            }else{
                imgSegundoToque = img3;
                imagemSegundoToque = lista.get(2);
                compara(imagemPrimeiroToque, imagemSegundoToque);

            }
        }
        if(v == img4){
            img4.setImageResource(lista.get(3));
            if(contaToque==1){
                imgPrimeiroToque = img4;
                imagemPrimeiroToque = lista.get(3);
            }else{
                imgSegundoToque = img4;
                imagemSegundoToque = lista.get(3);
                compara(imagemPrimeiroToque, imagemSegundoToque);

            }
        }
    }
}