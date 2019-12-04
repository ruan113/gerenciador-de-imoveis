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

        return new Visita(
                data,
                ctrPrincipal.ctrComprador.getCompradorByNome(compradorNome),
                ctrPrincipal.ctrCorretor.getCorretorByNome(corretorNome));
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
}
