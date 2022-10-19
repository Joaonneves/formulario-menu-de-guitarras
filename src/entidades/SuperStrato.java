package entidades;

import java.text.NumberFormat;

public class SuperStrato extends Strato {
    

    public SuperStrato(String n, double p)
    {
        super(n, p);
    }
    
    //sobreposição
    public double calc()
    {return super.calc() * 2;}
    
    
    public String toString(){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        
        return "Guitarra: " + getNome() + 
                "\n-Preço: " + nf.format(getPreco()) + "\n";
    }
    
    
    
  
    
}
