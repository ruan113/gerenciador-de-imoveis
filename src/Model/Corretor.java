//BRUNO GUILHERME LUNARDI - 2016003830
//IAN MARCEL TOBAR - 2016001693 
//RUAN MICHEL ADABO - 2016015278 

package Model;

//classe abstrata dos corretores

import java.io.Serializable;

public abstract class Corretor implements Serializable  {
    
    private String aNome;
    private int aCreci;
    
    //construtor 
    public Corretor( String pNome, int pCreci ) throws Exception {

        setaNome(pNome);
        setaCreci(pCreci);
        
    }
   
    //GETTERS E SETTERS

    public String getaNome() {
        return aNome;
    }

    public void setaNome(String aNome) throws Exception {
        if(aNome.equals("")){
            throw new Exception("Nome inválido!!!");
        }
        else{
            this.aNome = aNome;
        }
        
    }

    public int getaCreci() {
        return aCreci;
    }

    public void setaCreci(int aCreci)throws Exception {
        if(aCreci >= 0){
            this.aCreci = aCreci;
        }
        else{
            throw new Exception("Valor inválido para o CRECI!");
        }
    }
    
    //retorna a representação de String do objeto Corretor
    @Override
    public String toString(){
		
    	return String.format("Nome: %s \nCreci: %d", getaNome(), getaCreci());//retorna dado
		
    }
    
    //metodo abstrato, que será implementado nas classes concretas
    public abstract double calculaRenda();
    
}