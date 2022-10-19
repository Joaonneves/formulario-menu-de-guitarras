package dados;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.io.IOException;
import java.io.EOFException;

import java.util.ArrayList;
import java.util.Iterator;

import entidades.*;



public class Menu {
      
    private ArrayList menu;
    
    public Menu (){
        menu = new ArrayList();
    }
   
    
    public void inserirMenu(SuperStrato ss)
    {   menu.add(ss);}
    
    
    public String listarTodos()
    {
        StringBuilder lista = new StringBuilder ();
        
        
        Iterator i = menu.iterator();
        while (i.hasNext())
        {
                SuperStrato ss = (SuperStrato) i.next();
                
                lista.append(ss);
                
        }
        
        return lista.toString();
        
    }
    
    //ARQUIVO
    private ObjectOutputStream gravacao;
    private final String dir = "src/dados/";
    
    public ObjectOutputStream abreArquivoGravacao(){
        try{
                setGravacao(new ObjectOutputStream(
                        new FileOutputStream (dir+"menu.ser")));
                
        }
        catch(IOException e){
            System.err.println("\nErro de abertura de arquivo:\n"+e);
            
        }
        
        return getGravacao();
        
    }
    
    public void gravarObjetos(){
        try
        {
                Iterator it = menu.iterator();
                while(it.hasNext())
                    gravacao.writeObject((SuperStrato)it.next());
                
        }
        
        catch(IOException e){
            System.err.println("\nErro na gravação do obj no arq:\n"+e);
        }
    }
    
    public void fechaArquivoGravacao(){
        try{
            if(gravacao != null)
                gravacao.close();
        }
        catch(IOException e){
            System.out.println("Erro fechar arquivo");
            
        }
    }
    
    //abertura e leitura arq
    private ObjectInputStream leitura;
    
    public ObjectInputStream abreArquivoLeitura(){
        try{
            setLeitura(new ObjectInputStream(
                    new FileInputStream(dir+"menu.ser")));
            
        }
        catch(IOException e){
            System.err.println("\nErro na abertura do arq:\n"+e);
        }
        
        return leitura;
         
    }
    
    public void leRegistro()
    {
        SuperStrato ss;
        
        try
        {
            menu.clear();
            while(true)
            {
                   ss = (SuperStrato) leitura.readObject();
                   menu.add(ss); 
                   
            }
        }
        catch(EOFException e)
                {
                    return;
                
                }
        catch (ClassNotFoundException e)
                {
                    System.err.println("Não foi possivel criar objeto.");
                
                }
        catch(IOException e)
                {
                    System.err.println("\nErro de leitura do arquivo:\n"+e);
                
                }
    }
    
    public void fechaArquivoLeitura()
    {
        try{if(leitura != null)
                leitura.close();
        
            }
        catch(IOException e){
            System.out.println("\nErro fechar arquivo:\n"+e);
        }
    }

    public ArrayList getMenu() {
        return menu;
    }

    public void setMenu(ArrayList menu) {
        this.menu = menu;
    }

    public ObjectOutputStream getGravacao() {
        return gravacao;
    }

    public void setGravacao(ObjectOutputStream gravacao) {
        this.gravacao = gravacao;
    }

    public ObjectInputStream getLeitura() {
        return leitura;
    }

    public void setLeitura(ObjectInputStream leitura) {
        this.leitura = leitura;
    }

   
    
    
   
    
    
    
}
