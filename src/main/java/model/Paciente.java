/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author matheusnascimento
 */
public class Paciente {
    private String cpf;
    private String nome;
    private float altura;
    private float peso;
    private String freqCardiaca;
    private float temperatura; 
    private int idade;

    public Paciente(String cpf, String nome, float altura, float peso, String freqCardiaca, float temperatura) {
        this.cpf = cpf;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.freqCardiaca = freqCardiaca;
        this.temperatura = temperatura;
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
                + " \"idade\": \"" + idade + "\" }";
    }
    
    
    
}
