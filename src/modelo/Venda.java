/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */
package modelo;

import java.io.Serializable;

import java.util.*;

/**
 *
 *
 *
 * @author Ruan
 *
 */
public class Venda implements Serializable {

    double valorReal;//Valor real da venda

    double valorNegociado;//Valor negociado da venda

    String nomeComprador;//Nome do comprador do imovel

    Calendar dataVenda;//Data da venda

    Corretor corretorResponsavel;

    Imovel objImovel;

    public Venda(String nomeComprador, Calendar dataVenda, Corretor corretorResponsavel, double valorNegociado, Imovel objImovel) {

        this.valorReal = valorReal;

        this.nomeComprador = nomeComprador;

        this.dataVenda = dataVenda;

        this.corretorResponsavel = corretorResponsavel;

        this.valorNegociado = valorNegociado;

        this.objImovel = objImovel;

    }

    public double getValorReal() {

        return valorReal;

    }

    public void setValorReal(double valorReal) {

        this.valorReal = valorReal;

    }

    public String getNomeComprador() {

        return nomeComprador;

    }

    public void setNomeComprador(String nomeComprador) {

        this.nomeComprador = nomeComprador;

    }

    public Calendar getDataVenda() {

        return dataVenda;

    }

    public void setDataVenda(Calendar dataVenda) {

        this.dataVenda = dataVenda;

    }

    public double getValorNegociado() {

        return valorNegociado;

    }

    public void setValorNegociado(double valorNegociado) {

        this.valorNegociado = valorNegociado;

    }

    public Corretor getCorretorResponsavel() {
        return corretorResponsavel;
    }

    public void setCorretorResponsavel(Corretor corretorResponsavel) {
        this.corretorResponsavel = corretorResponsavel;
    }

    public Imovel getObjImovel() {

        return objImovel;

    }

    public void setObjImovel(Imovel objImovel) {

        this.objImovel = objImovel;

    }

}
