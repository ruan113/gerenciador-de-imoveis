package limite;

import Model.*;
import controle.*;
import limite.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

public class LimiteVenda {
    //controlador
    ControleVenda ctrVenda;
    int index = 0;
    //Construtor
    public LimiteVenda(ControleVenda ctrVenda) {
        //controle
        this.ctrVenda = ctrVenda;
    }
    //metodo para listar vendas
    public void listaVendas() {
        //janela
        JFrame frConsultar = new JFrame();
        JPanel pMain = new JPanel();//Painel principal
        JPanel pLabel = new JPanel();//Painel para Armazenar o label inicial
        JPanel pButtons = new JPanel();//Painel pra guardar os botões
        //pMain especificações
        pMain.setLayout(null);
        //pLabel especificações
        pLabel.setLayout(new BorderLayout());
        pLabel.add(new JLabel("LISTA DE VENDAS"), BorderLayout.CENTER);
        //pButtons especificações
        pButtons.setLayout(new GridLayout(1, 4, 5, 0));
        //Adição dos botões
        JButton bCadastrar = new JButton("Cadastrar Nova Venda");
        //listener para o botão
        bCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frConsultar.dispose();
                //chama limite responsavel por cadastrar vendas (CadatraVenda.java)
                CadastraVenda lmtVenda = new CadastraVenda(ctrVenda);
                //torna o limitevisivel
                lmtVenda.setVisible(true);
            }
        });
        //adiciona o botão cadastrar no painel pButtons
        pButtons.add(bCadastrar);
        //array de string que recebe o array de string retornado pelo metodo listarVendas()
        ArrayList<String> lista = ctrVenda.listarVendas();
        //paniel para Listar os dados
        JPanel pLista = new JPanel();
        //seta layout como BoxLayout, pegando do eixo Y
        pLista.setLayout(new BoxLayout(pLista, BoxLayout.Y_AXIS));
        //adiciona o painel pLabel ao painel pLista
        pLista.add(pLabel);
        //adiciona painel pButtons no painel pLista
        pLista.add(pButtons);
        int i = 1;//indicar o numero da venda
        int y = 110;
        if (lista.size() != 0) {
            for (String s : lista) {
                //painel pLista (int x, int y, int largura, int altura)
                pLista.setBounds(0, y, 50, 100);
                //JTextArea para listar os imóveis vendidos
                JTextArea text = new JTextArea(s);
                //define JTextArea(int x, int y, largura, altura)
                text.setBounds(50, y, 500, 100);
                //JLabel
                JLabel lbNumeroVenda = new JLabel(String.valueOf(i));
                lbNumeroVenda.setBounds(0, y, 50, 50);
                //adiciona label no painel
                pLista.add(lbNumeroVenda);                
                //adiciona o JTextFidl no painel pLista
                pLista.add(text);
                //incrementa o valor de Y
                //pois assim quando adicionar um novo texto ele ficará inserido abaixo do anterior
                y += 110;
                i++;//incrementa i, número da venda
            }
        }
        pLabel.setBounds(0, 0, 500, 50);
        pButtons.setBounds(0, 50, 500, 50);
        JScrollPane scroll = new JScrollPane(pLista, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        frConsultar.setPreferredSize(new Dimension(550, 600));
        frConsultar.setLayout(new BorderLayout());
        frConsultar.add(scroll, BorderLayout.CENTER);
        frConsultar.pack();
        frConsultar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frConsultar.setSize(900, 600);
        frConsultar.setVisible(true);
    }
}
