package controle;

import Model.*;
import controle.*;
import limite.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import javax.swing.JOptionPane;

public class ControleProposta {

    //limite
    public LimiteProposta lmtProposta;
    //controlador
    public ControlePrincipal ctrPrincipal;
    //Array de vendas
    private ArrayList<Proposta> listaPropostas = new ArrayList<Proposta>();

    public ControleProposta(ControlePrincipal ctrPrincipal) {
        //controlador
        this.ctrPrincipal = ctrPrincipal;
        //limite
        lmtProposta = new LimiteProposta(this);
        try {
            this.desserializaProposta();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao abrir arquivo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cadastraProposta(String dataString, String compradorNome,
            String corretorNome, double valor) {
        //Formata data
        Calendar data = Calendar.getInstance();
        if (!dataString.isEmpty()) {
            String[] aux = dataString.split("/"); //separa a string em partes
            //para coloca-las na posicao ideal
            data.set(Calendar.DAY_OF_MONTH, Integer.parseInt(aux[0]));
            data.set(Calendar.MONTH, Integer.parseInt(aux[1]) - 1);
            data.set(Calendar.YEAR, Integer.parseInt(aux[2]));
        }

        //adiciona no ArrayList
        listaPropostas.add(new Proposta(
                data,
                ctrPrincipal.ctrComprador.getCompradorByNome(compradorNome),
                ctrPrincipal.ctrCorretor.getCorretorByNome(corretorNome),
                valor));
        //grava em arquivo
        try {
            this.serializaProposta();
            JOptionPane.showMessageDialog(null, "Proposta cadastrada com sucesso!!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao gravar arquivo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void removeFromLista(int index) {
        listaPropostas.remove(index);
        //Grava edição em arquivo
        try {
            this.serializaProposta();
            JOptionPane.showMessageDialog(null, "Proposta removida com sucesso!!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao gravar arquivo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editaProposta(int index, Proposta p) {
        listaPropostas.remove(index);
        listaPropostas.add(index, p);
        //Grava edição em arquivo
        try {
            this.serializaProposta();
            JOptionPane.showMessageDialog(null, "Proposta editada com sucesso!!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao gravar arquivo", JOptionPane.ERROR_MESSAGE);
        }
    }

    //metodo para listar os imóveis
    //recebe o pTipo da ComboBox cbTipo, da classe LimiteProposta.java
    public ArrayList<String> getInfoList(String estado) {
        ArrayList<String> lista = new ArrayList<String>();
        String aux;
        //listar todos os tipos de imoveis cadastrados
        if (estado.equals("Todos")) {
            for (Proposta p : this.listaPropostas) {
                //verifica se o tipo do imóvel selecionado no LimitiImovel.listarImoveis existe
                aux = "Comprador: " + p.getComprador().getNome()
                        + "\nCorretor: " + p.getCorretor().getNome()
                        + "\nValor: " + p.getValor()
                        + "\nEstado: " + p.getEstado()
                        + "\nData: " + p.getData().get(Calendar.DAY_OF_MONTH)
                        + "/" + (p.getData().get(Calendar.MONTH) + 1) + "/"
                        + p.getData().get(Calendar.YEAR);
                lista.add(aux);//adiciona imovel no ArrayList lita
            }
        } else //se não for todos o tipo selecionado
        {
            //for para percorrer toda a lista de imovel
            for (Proposta p : this.listaPropostas) {
                //verifica se o tipo do imóvel selecionado no LimitiImovel.listarImoveis existe
                if (estado.equals(p.getEstado())) {
                    aux = "Comprador: " + p.getComprador().getNome()
                            + "\nCorretor: " + p.getCorretor().getNome()
                            + "\nValor: " + p.getValor()
                            + "\nEstado: " + p.getEstado()
                            + "\nData: " + p.getData().get(Calendar.DAY_OF_MONTH)
                            + "/" + (p.getData().get(Calendar.MONTH) + 1) + "/"
                            + p.getData().get(Calendar.YEAR);
                    lista.add(aux);//adiciona imovel no ArrayList lita
                }
            }
        }
        return lista;
    }

    //GETTERS E SETTERS
    public ArrayList<Proposta> getListaPropostas() {
        return listaPropostas;
    }

    public void setListaPropostas(ArrayList<Proposta> listaPropostas) {
        this.listaPropostas = listaPropostas;
    }

    //metodo para serializa as vendas, para salvar em arquivo
    private void serializaProposta() throws Exception {
        //Stream de gravação
        FileOutputStream objFileOS = new FileOutputStream("propostas.dat");
        //Stream de gravação
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        //grava o Array no arquivo
        objOS.writeObject(listaPropostas);
        //limpa objOS
        objOS.flush();
        //fecha stream
        objOS.close();
    }

    private void desserializaProposta() throws Exception {
        //nome do arquivo que será lido
        File objFile = new File("propostas.dat");
        //se o arquivo existir
        if (objFile.exists()) {
            //objeto de stream de bytes
            FileInputStream objFileIS = new FileInputStream("propostas.dat");
            //objeto de stream de bytes
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            //converte o objeto lido do arquivo para o tipo ArrayList e atribui ao Array listaCorretor
            listaPropostas = (ArrayList<Proposta>) objIS.readObject();
            //fecha stream
            objIS.close();
        }
    }
    //metodo para desserializar as vendas armazenadas em arquivos
}
