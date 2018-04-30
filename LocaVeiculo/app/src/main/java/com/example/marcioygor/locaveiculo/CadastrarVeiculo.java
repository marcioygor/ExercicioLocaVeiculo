package com.example.marcioygor.locaveiculo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class CadastrarVeiculo extends AppCompatActivity implements View.OnClickListener {


    private NestedScrollView nestedScrollView;

    private TextInputEditText textInputEditTextVeiculo;
    private TextInputEditText textInputEditTextAno;
    private TextInputEditText textInputEditTextCor;
    private TextInputEditText textInputEditTextKM;



    private TextInputLayout textInputLayoutVeiculo;
    private TextInputLayout textInputLayoutAno;
    private TextInputLayout textInputLayoutCor;
    private TextInputLayout textInputLayoutKM;
            ;
    private AppCompatButton appCompatButtonCadastrar;
    private AppCompatTextView appCompatTextViewListar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_veiculo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        IniciarViews();
        IniciartListeners();




    }


    private void IniciarViews() {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputLayoutVeiculo = (TextInputLayout) findViewById(R.id.textInputLayoutVeiculo);
        textInputLayoutAno = (TextInputLayout) findViewById(R.id.textInputLayoutAno);
        textInputLayoutCor = (TextInputLayout) findViewById(R.id.textInputLayoutCor);
        textInputLayoutKM= (TextInputLayout) findViewById(R.id.textInputLayoutKM);

        textInputEditTextVeiculo = (TextInputEditText) findViewById(R.id.textInputEditTextVeiculo);
        textInputEditTextAno = (TextInputEditText) findViewById(R.id.textInputEditTextAno);
        textInputEditTextCor = (TextInputEditText) findViewById(R.id.textInputEditTextCor);
        textInputEditTextKM = (TextInputEditText) findViewById(R.id.textInputEditTextKM);

        appCompatButtonCadastrar = (AppCompatButton) findViewById(R.id.appCompatButtonCadastrarV);

        appCompatTextViewListar = (AppCompatTextView) findViewById(R.id.appCompatTextViewListar);




    }


    private void IniciartListeners() {
        appCompatButtonCadastrar.setOnClickListener(this);
        appCompatTextViewListar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.appCompatButtonCadastrarV:
                CadastrarVeiculo();

                break;

            case R.id.appCompatTextViewListar:
                finish();
                break;
        }

    }


    public void CadastrarVeiculo(){

        Veiculo veiculo=new Veiculo();

        veiculo.setVeiculo(textInputEditTextVeiculo.getText().toString().trim());
        veiculo.setAno(textInputEditTextAno.getText().toString().trim());
        veiculo.setCor(textInputEditTextCor.getText().toString().trim());
        veiculo.setKM(textInputEditTextKM.getText().toString().trim());


        DataH dataH=new DataH(this);

        dataH.CadastrarVeiculo(veiculo);
        LimparCampos();



    }

    private void LimparCampos() {
        textInputEditTextVeiculo.setText(null);
        textInputEditTextAno.setText(null);
        textInputEditTextCor.setText(null);
        textInputEditTextKM.setText(null);
    }
}
