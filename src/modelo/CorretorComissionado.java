//BRUNO GUILHERME LUNARDI - 2016003830
//IAN MARCEL TOBAR - 2016001693 
//RUAN MICHEL ADABO - 2016015278 

package modelo;

import java.io.Serializable;

public class CorretorComissionado extends Corretor  implements Serializable {//abre classe CorretorComissionado

    private double aComissao;
    
    /////////////////falta adicionar as vendas
    
    //construtor
    public CorretorComissionado( String pNome, int pCreci, double pComissao ) throws Exception{//abre construtor 01
        
        //chama construtor da classe Corretor.java
        super(pNome, pCreci);
        
        setaComissao(pComissao);//valida comissão
        
    }//fecha construtor 01

    //GETTERS E SETTERS

    public double getaComissao() {
        return aComissao;
    }

    public void setaComissao(double aComissao) throws Exception {//abre setaComissao
        if( (aComissao < 1) || (aComissao > 3)){
            throw new Exception("Comissão inválida!");
        }
        else{
            this.aComissao = aComissao;
        }
        
    }//fecha setaComissao
    
    
    //calcula a renda do corretor
    @Override
    public double calculaRenda() {
        
        return aComissao;//de 1% a 3% da venda realizada (aComissao * venda)
        
    }
    
    //sobreescreve o metodo toString
    @Override
    public String toString(){//abre toString
        
        return "Nome: " + super.getaNome() + " CRECI: " + super.getaCreci() + 
                " Comissao: " + this.calculaRenda();//retornar dados
        
    }//fecha toString
    
}//fecha classe CorretorComissionado