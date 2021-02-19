package com.delllead.caraoucoroa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/* Projeto desenvolvido por Jessica Rangel Freire
* Rio de Janeiro, RJ - Brasil
* Agosto de 2020*/

public class MainActivity extends Activity {
    private RadioGroup rg_opcoes;
    private RadioButton opc_cara, opc_coroa;
    private Button btn_enviar, btn_limpar;
    private String escolha_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_opcoes = findViewById(R.id.minhasOpcoes);
        opc_cara = findViewById(R.id.opcCara);
        opc_coroa = findViewById(R.id.opcCoroa);

        btn_enviar = findViewById(R.id.btnEnviar);
        btn_limpar = findViewById(R.id.btnLimpar);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            int idEscolha = rg_opcoes.getCheckedRadioButtonId();
            if (idEscolha == -1) { //Nenhuma opção escolhida
                Toast.makeText(getBaseContext(), "Você não escolheu nada. Tente novamente.", Toast.LENGTH_SHORT).show();
            } else { //O usuário escolheu CARA ou COROA
                findRadioButton(idEscolha); //Identifica a opção escolhida
                proximaTela(view); //Segue para a próxima página
            }
            }
        });

        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rg_opcoes.clearCheck();
            }
        });

        rg_opcoes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int idEscolha) {
            findRadioButton(idEscolha);
            }
        });
    }

    private void findRadioButton(int idEscolha) {
        switch (idEscolha){
            case R.id.opcCara:
                escolha_user = "Cara";
                break;
            case R.id.opcCoroa:
                escolha_user = "Coroa";
                break;
        }

    }

    public void proximaTela(View view){
        Intent minha_intent = new Intent(this, SegundaActivity.class);
        minha_intent.putExtra("ESCOLHA", escolha_user);
        startActivity(minha_intent);
        finish();
    }
}