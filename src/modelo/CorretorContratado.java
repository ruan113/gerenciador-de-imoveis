//BRUNO GUILHERME LUNARDI - 2016003830
//IAN MARCEL TOBAR - 2016001693 
//RUAN MICHEL ADABO - 2016015278 

package modelo;

import java.io.Serializable;
import java.util.*;

public class CorretorContratado extends Corretor  implements Serializable {//abre classeCorretorContratado

    private double aSalarioFixo;
    private Calendar aDataAdmissao;
    
    //falta adicionar a venda!!!
    
    //construtor
    public CorretorContratado( String pNome, int pCreci, double pSalario, Calendar pDataAdmissao )throws Exception{//abre construtor 01

        
        //chama construtor da classe abstrata Corretor.java
        super(pNome, pCreci);
        
        setaSalarioFixo(pSalario);//valida salário
        
        this.aDataAdmissao = pDataAdmissao;
        
    }//fecha construtor 01
    
    //GETTERS E SETTERS

    public double getaSalarioFixo() {
        return aSalarioFixo;
    }

    public void setaSalarioFixo(double aSalarioFixo) throws Exception{//abre setaSalarioFixo

        if(aSalarioFixo > 0){
            this.aSalarioFixo = aSalarioFixo;
        }else{
            throw new Exception("Salario não pode ter valor negativo ou zerado!!!");
        }
         
        
    }//fecha setaSalarioFixo

    public Calendar getaDataAdmissao() {
        return aDataAdmissao;
    }

    public void setaDataAdmissao(Calendar aDataAdmissao) {
        this.aDataAdmissao = aDataAdmissao;
    }

    //retorna o rendimento
    @Override
    public double calculaRenda() {
        
        return aSalarioFixo; // + 1% valor da venda de cada imóvel vendido
                
    }
    
    //sobreescreve o metodo toString
    @Override
    public String toString(){//abre toString
        
        return "Nome: " + super.getaNome() + " CRECI: " + super.getaCreci() + 
                " Renda: " + this.calculaRenda();//retornar dados
        
    }//fecha toString 
    
}