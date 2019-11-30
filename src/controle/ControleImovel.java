package controle;

import Model.Imovel;
import java.util.*;

import controle.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

import limite.*;

public class ControleImovel {

    public ControlePrincipal ctrPrincipal;

    public LimiteImovel lmtImovel;

    private ArrayList<Imovel> listaImoveis = new ArrayList<Imovel>();

    //construtor 01
    public ControleImovel(ControlePrincipal ctrPrincipal) {

        this.ctrPrincipal = ctrPrincipal;
        lmtImovel = new LimiteImovel(this);

        try {
            this.desserializaImovel();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao abrir arquivo", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void cadastraImovel(int codigo, String tipo,
            String descricao, String arquivoFoto, double preco, 
            String comissao, String dataInclusao, String vendedor_cpf) {

        //Formata data
        Calendar data = Calendar.getInstance();

        if (!dataInclusao.isEmpty()) {
            String[] aux = dataInclusao.split("/"); //separa a string em partes
            //para coloca-las na posicao ideal
            data.set(Calendar.DAY_OF_MONTH, Integer.parseInt(aux[0]));
            data.set(Calendar.MONTH, Integer.parseInt(aux[1]));
            data.set(Calendar.YEAR, Integer.parseInt(aux[2]));
        }

        //Formata comissao
        comissao.replace("%", ""); 
        
        listaImoveis.add(
                new Imovel(
                        codigo,
                        tipo,
                        descricao,
                        arquivoFoto,
                        preco,
                        Double.parseDouble(comissao),
                        data,
                        this.ctrPrincipal.ctrVendedor.getVendedorByCpf(vendedor_cpf)
                )
        );

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
    public ArrayList<String> getInfoList(String pTipo) {
        ArrayList<String> lista = new ArrayList<String>();
        String aux;
        //listar todos os tipos de imoveis cadastrados
        if (pTipo.equals("Todos")) {
            for (Imovel i : listaImoveis) {
                //verifica se o tipo do imóvel selecionado no LimitiImovel.listarImoveis existe
                aux = "Codigo: " + i.getCodigo() + "\nTipo: " + i.getTipo()
                        + "\nDescrição: " + i.getDescricao() + "\nNome Do Proprietário: "
                        + i.getVendedor().getNome() + "\nPreço: " + i.getPreco()
                        + "\nData de Cadastro: " + i.getDataInclusao().get(Calendar.DAY_OF_MONTH)
                        + "/" + i.getDataInclusao().get(Calendar.MONTH) + "/"
                        + i.getDataInclusao().get(Calendar.YEAR);
                lista.add(aux);//adiciona imovel no ArrayList lita
            }
        }
        else //se não for todos o tipo selecionado
        {
            //for para percorrer toda a lista de imovel
            for (Imovel i : listaImoveis) {
                //verifica se o tipo do imóvel selecionado no LimitiImovel.listarImoveis existe
                if (pTipo.equals(i.getTipo())) {
                    aux = "Codigo: " + i.getCodigo() + "\nTipo: " + i.getTipo()
                            + "\nDescrição: " + i.getDescricao() + "\nNome Do Proprietário: "
                            + i.getVendedor().getNome() + "\nPreço: " + i.getPreco()
                            + "\nData de Cadastro: " + i.getDataInclusao().get(Calendar.DAY_OF_MONTH)
                            + "/" + i.getDataInclusao().get(Calendar.MONTH) + "/"
                            + i.getDataInclusao().get(Calendar.YEAR);
                    lista.add(aux);//adiciona imovel no ArrayList lita
                }
            }
        }
        return lista;

    }

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
    private void serializaImovel() throws Exception {
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
    }

    //metodo para desserializar o arquivo de imoveis
    private void desserializaImovel() throws Exception {
        //nome do arquivo que será lido
        File objFile = new File("imoveis.dat");
        //se o arquivo existir
        if (objFile.exists()) {
            //objeto de stream de bytes
            FileInputStream objFileIS = new FileInputStream("imoveis.dat");
            //objeto de stream de bytes
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            //converte o objeto lido do arquivo para o tipo ArrayList e atribui ao Array listaCorretor
            listaImoveis = (ArrayList<Imovel>) objIS.readObject();
            //fecha stream
            objIS.close();
        }

    }

}
