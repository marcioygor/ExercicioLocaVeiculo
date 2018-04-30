package com.example.marcioygor.locaveiculo;

/**
 * Created by Marcio Ygor on 28/04/2018.
 */

public class Veiculo {

    private int id;
    private String Veiculo;
    private String Cor;
    private String ano;
    private String KM;

    public Veiculo(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVeiculo() {

        return Veiculo;
    }

    public void setVeiculo(String veiculo) {

        this.Veiculo = veiculo;
    }


    public String getCor() {

        return Cor;
    }

    public void setCor(String cor) {

        this.Cor = cor;
    }


    public String getKM() {

        return KM;
    }

    public void setKM(String KM) {

        this.KM = KM;
    }

    public String getAno() {

        return ano;
    }

    public void setAno(String ano) {

        this.ano = ano;
    }



}
