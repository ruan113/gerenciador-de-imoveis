package controle;

import Model.*;
import controle.*;
import limite.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class ControleComprador {

    public ControlePrincipal ctrPrincipal;
    public LimiteComprador lmtComprador;//variavel de instancia responsavel pelo limite dos compradores
    private ArrayList<Comprador> listaComprador = new ArrayList<Comprador>();//array para Comprador
    //construtor

    public ControleComprador(ControlePrincipal ctrPrincipal) {
        this.ctrPrincipal = ctrPrincipal;
        lmtComprador = new LimiteComprador(this);
        //new LimiteComprador(this);
        try {
            this.desserializaComprador();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Erro ao abrir arquivo", JOptionPane.ERROR_MESSAGE);
        }
    }

    //metodo para inserir comprador 
    public void insereComprador(String cpf, String nome, String email,
            String fone, String contatoPref) throws Exception {
        //cria um obejto do modelo CompradorContratado e aciona o seu construtor
        Comprador comprador = new Comprador(
                cpf,
                nome,
                email,
                fone,
                contatoPref);//cria objeto contratado
        this.listaComprador.add(comprador);//adiciona o contratado no array list de comprador
        //grava em arquivo o comprador inserido
        try {
            this.serializaComprador();
            JOptionPane.showMessageDialog(null, "Comprador cadastrado com sucesso!!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao gravar arquivo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editaComprador(int index, Comprador i) {
        this.listaComprador.remove(index);
        this.listaComprador.add(index, i);
        //Grava edição em arquivo
        try {
            JOptionPane.showMessageDialog(null, "Comprador editado com sucesso!!!");//mensagem de confirmação
            this.serializaComprador();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao gravar arquivo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void excluiComprador(int index) throws Exception {
        if ((index >= 0) && (getListaAll().size() > 0)) {
            //remove elemento da lista, através do indice passado pelo LimiteListaComprador.java
            getListaAll().remove(index);
            //grava remoção no arquivo
            try {
                this.serializaComprador();
                JOptionPane.showMessageDialog(null, "Comprador removido com sucesso!!!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao gravar arquivo", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            throw new Exception("Operação inválida!!!\nVerifique se foi selecionado algum comprador!!!");
        }
    }

    //metodo para listar os corretoes
    public ArrayList<String> getInfoList() {
        ArrayList<String> lista = new ArrayList<String>();
        String aux;
        for (Comprador c : listaComprador) {
            //retorna informações do comprador 
            aux = "\nNome: " + c.getNome()
                    + "\nCPF: " + c.getCpf()
                    + "\nEmail: " + c.getEmail()
                    + "\nFone: " + c.getFone()
                    + "\nContato Preferêncial: " + c.getContatoPref();
            lista.add(aux);
        }
        return lista;
    }

    //GETTERS E SETTERS
    public ArrayList<Comprador> getListaAll() {
        return this.listaComprador;
    }

    public void setListaComprador(ArrayList<Comprador> listaComprador) {
        listaComprador = listaComprador;
    }

     public Comprador getCompradorByNome(String nome) {
        for (Comprador comprador : listaComprador) {
            if (comprador.getNome().equals(nome)) {
                return comprador;
            }
        }
        return null;
    } 
    
    //metodo para serializa a o comprador, para salvar em arquivo
    private void serializaComprador() throws Exception {
        //Stream de gravação
        FileOutputStream objFileOS = new FileOutputStream("compradores.dat");
        //Stream de gravação
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        //grava o vetor no arquivo
        objOS.writeObject(this.listaComprador);
        //limpa objOS
        objOS.flush();
        //fecha stream
        objOS.close();
    }

    //metodo para desserializar o arquivo de compradores
    private void desserializaComprador() throws Exception {
        //nome do arquivo que será lido
        File objFile = new File("compradores.dat");
        //se o arquivo existir
        if (objFile.exists()) {
            //objeto de stream de bytes
            FileInputStream objFileIS = new FileInputStream("compradores.dat");
            //objeto de stream de bytes
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            //converte o objeto lido do arquivo para o tipo ArrayList e atribui ao Array listaComprador
            this.listaComprador = (ArrayList<Comprador>) objIS.readObject();
            //fecha stream
            objIS.close();
        }
    }
}
