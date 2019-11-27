//BRUNO GUILHERME LUNARDI - 2016003830
//IAN MARCEL TOBAR - 2016001693 
//RUAN MICHEL ADABO - 2016015278 

package modelo;

import java.io.Serializable;
import java.util.Calendar;

public class Imovel implements Serializable {//abre classe Imovel
    
    int codigo;//Codigo do imovel
    String tipo;//Tipo do imovel
    String descricao;//Descrição do imovel
    String nomeVendedor;//Nome do vendedor que esta vendendo o imovel
    double precoSolicitado;//Preço proposto pelo vendedor
    Calendar data;//Data de cadastro

    //construtor
    public Imovel(int codigo, String tipo, String descricao, String nomeVendedor, 
            double precoSolicitado, Calendar data) {//abre construtor 01
        
        this.codigo = codigo;
        this.tipo = tipo;
        this.descricao = descricao;
        this.nomeVendedor = nomeVendedor;
        this.precoSolicitado = precoSolicitado;
        this.data = data;
        
    }//fecha construtor 01

    //GETTERS E SETTERS

    //valida preço
    public void setPrecoSolicitado(double precoSolicitado) {//abre setPrecoSolicitado
        
        this.precoSolicitado = precoSolicitado < 0.0 ? 0.0 : precoSolicitado;
        
    }//fecha setPrecoSolicitado

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public double getPrecoSolicitado() {
        return precoSolicitado;
    }

    public Calendar getData() {
        return data;
    }
    
}//fecha classe Imovel