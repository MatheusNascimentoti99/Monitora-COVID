/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;

/**
 *
 * @author matheusnascimento
 */
public class Paciente implements Comparable<Paciente>, Comparator<Object>{
    private String cpf;
    private String nome;
    private float altura;
    private float peso;
    private String freqCardiaca;
    private float temperatura; 
    private int idade;
    private int gravidade;

    public Paciente(String cpf, String nome, float altura, float peso, String freqCardiaca, float temperatura) {
        this.cpf = cpf;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.freqCardiaca = freqCardiaca;
        this.temperatura = temperatura;
        this.gravidade = 0;
    }
    
    public Paciente(String cpf, String nome, float altura, float peso, String freqCardiaca, float temperatura, int statusAlert) {
        this.cpf = cpf;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.freqCardiaca = freqCardiaca;
        this.temperatura = temperatura;
        this.gravidade = statusAlert;
    }

    public Paciente(String cpf){
        this.cpf = cpf;
    }
    public Paciente() {
        this.nome = "Anonimo";
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getStatusAlert() {
        return gravidade;
    }

    public void setStatusAlert(int statusAlert) {
        this.gravidade = statusAlert;
    }
    
    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getFreqCardiaca() {
        return freqCardiaca;
    }

    public void setFreqCardiaca(String freqCardiaca) {
        this.freqCardiaca = freqCardiaca;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "{" + "\"cpf\": \"" + cpf + "\" , "
                + "\"nome\": \"" + nome + "\" ,"
                + " \"altura\": \"" + altura + "\","
                + " \"peso\": \"" + peso + "\","
                + " \"freqCardiaca\": \"" + freqCardiaca + "\" , "
                + "\"temperatura\": \"" + temperatura + "\","
                + " \"idade\": \"" + idade + "\","
                + " \"statusAlert\": \"" + gravidade + "\" }";
    }

    public int compareTo(Paciente o) {
        return o.gravidade - this.gravidade;
    }

    public int compare(Object o1, Object o2) {
        return ((Paciente)o2).gravidade - ((Paciente)o1).gravidade;
    }
    
    
    
}
