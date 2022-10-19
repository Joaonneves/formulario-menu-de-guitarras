package entidades;

import java.io.Serializable;


//classe abstrata para servir "modelo" para as subs (Superstrato)

public abstract class Strato implements Serializable, Calculos
{

    protected String  nome;
    protected double preco;
    
    

    public Strato(String n, double p)
    {
       this.nome = n;
       this.preco = p;
       
    }
   
   
    
    public double calc()
    {return preco;}
    
    
    //getters
    public String getNome() {return nome;}
    public double getPreco() {return preco;}
    
    
    //setters
    public void setNome(String nome) {this.nome = nome;}
    public void setPreco(double preco) {this.preco = preco;}
    
    

}
