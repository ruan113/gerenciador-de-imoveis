package controle;

import Model.Vendedor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import javax.swing.JOptionPane;
import limite.LimiteVendedor;

public class ControleVendedor {

    public ControlePrincipal ctrPrincipal;

    public LimiteVendedor lmtVendedor;
    private ArrayList<Vendedor> listaVendedores = new ArrayList<Vendedor>();

    public ControleVendedor(ControlePrincipal ctrPrincipal) {

        this.ctrPrincipal = ctrPrincipal;
        this.lmtVendedor = new LimiteVendedor(this);
        try {
            this.desserializaVendedor();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao abrir arquivo", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void cadastrarVendedor(Vendedor novoVendedor) {
        this.listaVendedores.add(novoVendedor);

        //Grava edição em arquivo
        try {
            this.serializaVendedor();
            JOptionPane.showMessageDialog(null, "Vendedor cadastrado com sucesso!!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao gravar arquivo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Vendedor> getListAll() {
        return this.listaVendedores;
    }

    public Vendedor getVendedorByCpf(String cpf) {
        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.getCpf().equals(cpf)) {
                return vendedor;
            }
        }
        return null;
    }

    public Vendedor getVendedorByNome(String nome) {
        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.getNome().equals(nome)) {
                return vendedor;
            }
        }
        return null;
    }

    //metodo para serializa os imoveis, para salvar em arquivo
    private void serializaVendedor() throws Exception {
        //Stream de gravação
        FileOutputStream objFileOS = new FileOutputStream("vendedores.dat");
        //Stream de gravação
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        //grava o Array no arquivo
        objOS.writeObject(this.listaVendedores);
        //limpa objOS
        objOS.flush();
        //fecha stream
        objOS.close();
    }

    //metodo para desserializar o arquivo de imoveis
    private void desserializaVendedor() throws Exception {
        //nome do arquivo que será lido
        File objFile = new File("vendedores.dat");
        //se o arquivo existir
        if (objFile.exists()) {
            //objeto de stream de bytes
            FileInputStream objFileIS = new FileInputStream("vendedores.dat");
            //objeto de stream de bytes
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            //converte o objeto lido do arquivo para o tipo ArrayList e atribui ao Array listaCorretor
            this.listaVendedores = (ArrayList<Vendedor>) objIS.readObject();
            //fecha stream
            objIS.close();
        }

    }
}
