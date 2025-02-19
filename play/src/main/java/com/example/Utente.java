package com.example;

public class Utente {
    String nome;
    String password; 
    public Utente(){
       
    }
    public  void setNome(String s ){
        this.nome = s;
    }
    public  String getNome(){
        return this.nome;
    }
    public  void setPassword(String s ){
        this.password = s;
    }
    public  String getPassword(){
        return this.password; 
    }
}
