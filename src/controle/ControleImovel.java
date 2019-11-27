//BRUNO GUILHERME LUNARDI
//RUAN MICHEL ADABO
//IAN MARCELO TOBAR
package controle;

import java.util.*;

import controle.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

import limite.*;

import modelo.*;

public class ControleImovel {//abre classe ControleImovel

    public ControlePrincipal ctrPrincipal;

    public LimiteImovel lmtImovel;

    private ArrayList<Imovel> listaImoveis = new ArrayList<Imovel>();

    //construtor 01
    public ControleImovel(ControlePrincipal ctrPrincipal) {//abre construtor 01

        this.ctrPrincipal = ctrPrincipal;
        lmtImovel = new LimiteImovel(this);

        try {
            this.desserializaImovel();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao abrir arquivo", JOptionPane.ERROR_MESSAGE);
        }

    }//fecha construtor 01

    public void cadastraImovel(int codigo, String tipo, String descricao, String nomeProprietario, double precoSolicitado, Calendar data) {

        listaImoveis.add(new Imovel(codigo, tipo, descricao, nomeProprietario, precoSolicitado, data));

        //Grava edição em arquivo
        try {
            this.serializaImovel();
            JOptionPane.showMessageDialog(null, "Imóvel cadastrado com sucesso!!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao gravar arquivo", JOptionPane.ERROR_MESSAGE);
        }

    }

    //metodo para listar os imóveis
    //recebe o pTipo da ComboBox cbTipo, da classe LimiteImovel.java
    public ArrayList<String> listarImoveis(String pTipo) {//abre listarImoveis
        ArrayList<String> lista = new ArrayList<String>();
        String aux;
        //listar todos os tipos de imoveis cadastrados
        if (pTipo.equals("Todos")) {//abre if 01
            for (Imovel i : listaImoveis) {//abre for 01
                //verifica se o tipo do imóvel selecionado no LimitiImovel.listarImoveis existe
                aux = "Codigo: " + i.getCodigo() + "\nTipo: " + i.getTipo() + "\nDescrição: " + i.getDescricao() + "\nNome Do Proprietário: "
                        + i.getNomeVendedor() + "\nPreço: " + i.getPrecoSolicitado() + "\nData de Cadastro: " + i.getData().get(Calendar.DAY_OF_MONTH) + "/"
                        + i.getData().get(Calendar.MONTH) + "/" + i.getData().get(Calendar.YEAR);
                lista.add(aux);//adiciona imovel no ArrayList lita
            }//fecha for 01
        }//fecha if 01 
        else //se não for todos o tipo selecionado
        {//abre else do if 01
            //for para percorrer toda a lista de imovel
            for (Imovel i : listaImoveis) {//abre for 02
                //verifica se o tipo do imóvel selecionado no LimitiImovel.listarImoveis existe
                if (pTipo.equals(i.getTipo())) {//abre if 02
                    aux = "Codigo: " + i.getCodigo() + "\nTipo: " + i.getTipo() + "\nDescrição: " + i.getDescricao() + "\nNome Do Proprietário: "
                            + i.getNomeVendedor() + "\nPreço: " + i.getPrecoSolicitado() + "\nData de Cadastro: " + i.getData().get(Calendar.DAY_OF_MONTH) + "/"
                            + i.getData().get(Calendar.MONTH) + "/" + i.getData().get(Calendar.YEAR);
                    lista.add(aux);//adiciona imovel no ArrayList lita
                }//fecha if 02
            }//fecha for 02
        }//fecha else do if 01
        return lista;

    }//fecha listarImoveis

    public ArrayList<Imovel> getLista() {

        return listaImoveis;

    }

    public void editaLista(int index, Imovel i) {

        listaImoveis.remove(index);

        listaImoveis.add(index, i);

        //Grava edição em arquivo
        try {
            this.serializaImovel();
            JOptionPane.showMessageDialog(null, "Imóvel editado com sucesso!!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao gravar arquivo", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void removeLista(int index) {

        listaImoveis.remove(index);

        //Grava edição em arquivo
        try {
            this.serializaImovel();
            JOptionPane.showMessageDialog(null, "Imóvel removido com sucesso!!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao gravar arquivo", JOptionPane.ERROR_MESSAGE);
        }

    }

    //metodo para serializa os imoveis, para salvar em arquivo
    private void serializaImovel() throws Exception {//abre serializaImovel
        //Stream de gravação
        FileOutputStream objFileOS = new FileOutputStream("imoveis.dat");
        //Stream de gravação
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        //grava o Array no arquivo
        objOS.writeObject(listaImoveis);
        //limpa objOS
        objOS.flush();
        //fecha stream
        objOS.close();
    }//fecha serializaImovel

    //metodo para desserializar o arquivo de imoveis
    private void desserializaImovel() throws Exception {//abre desserializaDisciplina
        //nome do arquivo que será lido
        File objFile = new File("imoveis.dat");
        //se o arquivo existir
        if (objFile.exists()) {//abre if 01
            //objeto de stream de bytes
            FileInputStream objFileIS = new FileInputStream("imoveis.dat");
            //objeto de stream de bytes
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            //converte o objeto lido do arquivo para o tipo ArrayList e atribui ao Array listaCorretor
            listaImoveis = (ArrayList<Imovel>) objIS.readObject();
            //fecha stream
            objIS.close();
        }//fecha if 01

    }//fecha desserializaDisciplina

}//fecha classe ControleImovel
