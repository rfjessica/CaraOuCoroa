package com.delllead.caraoucoroa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/* Projeto desenvolvido por Jessica Rangel Freire
 * Rio de Janeiro, RJ - Brasil
 * Agosto de 2020*/

public class SegundaActivity extends Activity {

    private Button btn_voltar;
    private String usu_escolha, resposta_jogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Intent minha_intent = getIntent(); //Obtém dados da intent principal
        usu_escolha = minha_intent.getStringExtra("ESCOLHA");  //Representa dados de MainActivity

        Random random = new Random();
        TextView respostaJogo = findViewById(R.id.respJogo); //Escolha aleatória de cara ou coroa

        if(random.nextBoolean()==true){ //CARA
            resposta_jogo = "Cara";
            respostaJogo.setText("O resultado é: CARA");
        }else{ //COROA
            resposta_jogo = "Coroa";
            respostaJogo.setText("O resultado é: COROA");
        }

        if(usu_escolha.equals(resposta_jogo)){ //Opção escolhida é igual ao sorteio?
            Toast.makeText(getBaseContext(), "Parabéns! Você ganhou.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getBaseContext(), "Você perdeu, infelizmente.", Toast.LENGTH_SHORT).show();
        }

        btn_voltar = findViewById(R.id.btnVoltar);
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaInicio(view);
            }
        });
    }

    public void retornaInicio(View view){ //Retorna à activity principal
        Intent my_intent = new Intent(this, MainActivity.class);
        startActivity(my_intent);
        finish();
    }
}