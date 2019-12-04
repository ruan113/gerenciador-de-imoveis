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

    public ControleProposta(ControlePrincipal ctrPrincipal) {
        //controlador
        this.ctrPrincipal = ctrPrincipal;
        //limite
        lmtProposta = new LimiteProposta(this);
    }

    public Proposta cadastraProposta(String dataString, String compradorNome,
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

        return new Proposta(
                data,
                ctrPrincipal.ctrComprador.getCompradorByNome(compradorNome),
                ctrPrincipal.ctrCorretor.getCorretorByNome(corretorNome),
                valor);
    }

    //metodo para listar os imóveis
    //recebe o pTipo da ComboBox cbTipo, da classe LimiteProposta.java
    public ArrayList<String> getInfoList(String estado) {
        ArrayList<String> lista = new ArrayList<String>();
        String aux;
        //listar todos os tipos de imoveis cadastrados
        if (estado.equals("Todos")) {
            for (Imovel i : this.ctrPrincipal.ctrImovel.getLista()) {
                for (Proposta p : i.getListaPropostas()) {
                    aux = "Código do Imóvel: " + i.getCodigo()
                            + "\nComprador: " + p.getComprador().getNome()
                            + "\nCorretor: " + p.getCorretor().getNome()
                            + "\nValor: " + p.getValor()
                            + "\nEstado: " + p.getEstado()
                            + "\nData: " + p.getData().get(Calendar.DAY_OF_MONTH)
                            + "/" + (p.getData().get(Calendar.MONTH) + 1) + "/"
                            + p.getData().get(Calendar.YEAR);
                    lista.add(aux);//adiciona imovel no ArrayList lita
                }
            }
        } else //se não for todos o tipo selecionado
        {
            //for para percorrer toda a lista de imovel
            for (Imovel i : this.ctrPrincipal.ctrImovel.getLista()) {
                for (Proposta p : i.getListaPropostas()) {
                    if (estado.equals(p.getEstado())) {
                        aux = "Código do Imóvel: " + i.getCodigo()
                                + "\nComprador: " + p.getComprador().getNome()
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
        }
        return lista;
    }
}
