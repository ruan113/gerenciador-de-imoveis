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

public class ControleVisita {

    //limite
    public LimiteVisita lmtVisita;
    //controlador
    public ControlePrincipal ctrPrincipal;
    //Array de vendas
    private ArrayList<Visita> listaVisitas = new ArrayList<Visita>();

    public ControleVisita(ControlePrincipal ctrPrincipal) {
        //controlador
        this.ctrPrincipal = ctrPrincipal;
        //limite
        lmtVisita = new LimiteVisita(this);
        try {
            this.desserializaVisita();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao abrir arquivo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Visita cadastraVisita(String dataString, String compradorNome,
            String corretorNome) {
        //Formata data
        Calendar data = Calendar.getInstance();
        if (!dataString.isEmpty()) {
            String[] aux = dataString.split("/"); //separa a string em partes
            //para coloca-las na posicao ideal
            data.set(Calendar.DAY_OF_MONTH, Integer.parseInt(aux[0]));
            data.set(Calendar.MONTH, Integer.parseInt(aux[1]) - 1);
            data.set(Calendar.YEAR, Integer.parseInt(aux[2]));
        }
        
        Visita novaVisita = new Visita(
                data,
                ctrPrincipal.ctrComprador.getCompradorByNome(compradorNome),
                ctrPrincipal.ctrCorretor.getCorretorByNome(corretorNome));
        
        //adiciona no ArrayList
        listaVisitas.add(novaVisita);
        //grava em arquivo
        try {
            this.serializaVisita();
            JOptionPane.showMessageDialog(null, "Corretor cadastrado com sucesso!!!");
            return novaVisita;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao gravar arquivo", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

     public void removeFromLista(int index) {
        listaVisitas.remove(index);
        //Grava edição em arquivo
        try {
            this.serializaVisita();
            JOptionPane.showMessageDialog(null, " removido com sucesso!!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao gravar arquivo", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    //metodo para listar os imóveis
    //recebe o pTipo da ComboBox cbTipo, da classe LimiteVisita.java
    public ArrayList<String> getInfoList(String estado) {
        ArrayList<String> lista = new ArrayList<String>();
        String aux;
        //listar todos os tipos de imoveis cadastrados
        if (estado.equals("Todos")) {
            for (Visita v : this.listaVisitas) {
                //verifica se o tipo do imóvel selecionado no LimitiImovel.listarImoveis existe
                aux = "Comprador: " + v.getComprador().getNome()
                        + "\nCorretor: " + v.getCorretor().getNome()
                        + "\nEstado: " + v.getEstado()
                        + "\nData: " + v.getData().get(Calendar.DAY_OF_MONTH)
                        + "/" + (v.getData().get(Calendar.MONTH) + 1) + "/"
                        + v.getData().get(Calendar.YEAR);
                lista.add(aux);//adiciona imovel no ArrayList lita
            }
        } else //se não for todos o tipo selecionado
        {
            //for para percorrer toda a lista de imovel
            for (Visita v : this.listaVisitas) {
                //verifica se o tipo do imóvel selecionado no LimitiImovel.listarImoveis existe
                if (estado.equals(v.getEstado())) {
                    aux = "Comprador: " + v.getComprador().getNome()
                            + "\nCorretor: " + v.getCorretor().getNome()
                            + "\nEstado: " + v.getEstado()
                            + "\nData: " + v.getData().get(Calendar.DAY_OF_MONTH)
                            + "/" + (v.getData().get(Calendar.MONTH) + 1) + "/"
                            + v.getData().get(Calendar.YEAR);
                    lista.add(aux);//adiciona imovel no ArrayList lita
                }
            }
        }
        return lista;
    }

    public void editaVisita(int index, Visita v) {
        listaVisitas.remove(index);
        listaVisitas.add(index, v);
        //Grava edição em arquivo
        try {
            this.serializaVisita();
            JOptionPane.showMessageDialog(null, "Imóvel editado com sucesso!!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao gravar arquivo", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //GETTERS E SETTERS
    public ArrayList<Visita> getListaVisitas() {
        return listaVisitas;
    }
    
    public void setListaVisitas(ArrayList<Visita> listaVisitas) {
        this.listaVisitas = listaVisitas;
    }

    //metodo para serializa as vendas, para salvar em arquivo
    private void serializaVisita() throws Exception {
        //Stream de gravação
        FileOutputStream objFileOS = new FileOutputStream("visitas.dat");
        //Stream de gravação
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        //grava o Array no arquivo
        objOS.writeObject(listaVisitas);
        //limpa objOS
        objOS.flush();
        //fecha stream
        objOS.close();
    }

    private void desserializaVisita() throws Exception {
        //nome do arquivo que será lido
        File objFile = new File("visitas.dat");
        //se o arquivo existir
        if (objFile.exists()) {
            //objeto de stream de bytes
            FileInputStream objFileIS = new FileInputStream("visitas.dat");
            //objeto de stream de bytes
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            //converte o objeto lido do arquivo para o tipo ArrayList e atribui ao Array listaCorretor
            listaVisitas = (ArrayList<Visita>) objIS.readObject();
            //fecha stream
            objIS.close();
        }
    }
    //metodo para desserializar as vendas armazenadas em arquivos
}
