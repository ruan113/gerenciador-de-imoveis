//BRUNO GUILHERME LUNARDI - 2016003830
//IAN MARCEL TOBAR - 2016001693 
//RUAN MICHEL ADABO - 2016015278 
package controle;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;

import java.util.*;

import javax.swing.JOptionPane;

import limite.*;

import modelo.*;

public class ControleVenda {

    //limite
    public LimiteVenda lmtVenda;

    //controlador
    public ControlePrincipal ctrPrincipal;

    //Array de vendas
    private ArrayList<Venda> listaVendasRealizadas = new ArrayList<Venda>();

    public ControleVenda(ControlePrincipal ctrPrincipal) {

        //controlador
        this.ctrPrincipal = ctrPrincipal;

        //limite
        lmtVenda = new LimiteVenda(this);

        try {
            this.desserializaVenda();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao abrir arquivo", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void mostraFormulario() {

        //chama formulario para venda, passando este controlador
        new CadastraVenda(this);

    }

    /*

    public void mostraListaVendedor() {

        //chama formulario para venda, passando este controlador

        new LimiteVenda(this);

    }    

     */
    public void cadastraVenda(String nomeComprador, Calendar dataVenda, Corretor corretorResponsavel, double valorNegociado, Imovel objImovel) throws Exception {//abre cadastraVenda

        //adiciona no ArrayList
        listaVendasRealizadas.add(new Venda(nomeComprador, dataVenda, corretorResponsavel, valorNegociado, objImovel));

        //grava em arquivo
        this.serializaImovel();

    }//fecha cadastraVenda

    //metodo para listar os imóveis
    //recebe o pTipo da ComboBox cbTipo, da classe LimiteImovel.java
    public ArrayList<String> listarVendas() {//abre listarImoveis
        ArrayList<String> lista = new ArrayList<String>();
        String aux;

        //listar todos os tipos de imoveis cadastrados
        for (Venda ven : listaVendasRealizadas) {//abre for 01
            //verifica se o tipo do imÃ³vel selecionado no LimitiImovel.listarImoveis existe
            Calendar data = ven.getDataVenda();

            aux = "Nome do comprador: " + ven.getNomeComprador() + "\nData Venda: " + data.get(Calendar.DAY_OF_MONTH)
                    + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR)
                    + "\nCorretor: " + ven.getCorretorResponsavel().getaNome() + "\nValor Real: " + ven.getObjImovel().getPrecoSolicitado()
                    + "\nValor Negociado: " + ven.getValorNegociado()
                    + "\nNome do vendedor: " + ven.getObjImovel().getNomeVendedor()
                    + "\nCodigo imovel: " + ven.getObjImovel().getCodigo()
                    + "\nTipo: " + ven.getObjImovel().getTipo()
                    + "\nDescricao: " + ven.getObjImovel().getDescricao();
            lista.add(aux);//adiciona imovel no ArrayList lita

        }//fecha for 01

        return lista;

    }//fecha listarImoveis

    //GETTERS E SETTERS
    public ArrayList<Venda> getListaVendas() {
        return listaVendasRealizadas;
    }

    public void setListaVendas(ArrayList<Venda> listaVendas) {

        this.listaVendasRealizadas = listaVendas;

    }

    //metodo para serializa as vendas, para salvar em arquivo
    private void serializaImovel() throws Exception {//abre serializaImovel

        //Stream de gravação
        FileOutputStream objFileOS = new FileOutputStream("vendas.dat");

        //Stream de gravação
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);

        //grava o Array no arquivo
        objOS.writeObject(listaVendasRealizadas);

        //limpa objOS
        objOS.flush();

        //fecha stream
        objOS.close();

    }//fecha serializaImovel    

    private void desserializaVenda() throws Exception {//abre desserializaDisciplina

        //nome do arquivo que será lido
        File objFile = new File("vendas.dat");

        //se o arquivo existir
        if (objFile.exists()) {//abre if 01

            //objeto de stream de bytes
            FileInputStream objFileIS = new FileInputStream("vendas.dat");

            //objeto de stream de bytes
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);

            //converte o objeto lido do arquivo para o tipo ArrayList e atribui ao Array listaCorretor
            listaVendasRealizadas = (ArrayList<Venda>) objIS.readObject();

            //fecha stream
            objIS.close();

        }//fecha if 01

    }//fecha desserializaDisciplina    

    //metodo para desserializar as vendas armazenadas em arquivos
}
