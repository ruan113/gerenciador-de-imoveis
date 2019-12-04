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
import java.util.Calendar;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class LimiteVisita {
    //controlador

    ControleVisita ctrVisita;
    //Panel
    JPanel panel;
    //Botões
    JButton btCadastrar;
    JButton btConsultar;
    //labels
    JLabel lbOpcoes;
    //sera usado para editar ou excluir imóvel
    Visita selectedVisita = null;

    //contrutor
    public LimiteVisita(ControleVisita ctrVisita) {
        this.ctrVisita = ctrVisita;//Armazena o controlador Principal numa variavel
    }

    //metodo para exibir o formulário de cadastro de porpostas
    void cadastraVisita(int codigo) {
        //Inicializa Tela
        JFrame frCadastra = new JFrame();
        //Inicializa Painel
        JPanel pCadastro = new JPanel();

        //ComboBox
        JComboBox cbComprador = new JComboBox();
        ArrayList<Comprador> listaCompradores = this.ctrVisita.ctrPrincipal.ctrComprador.getListaAll();
        if (listaCompradores.size() > 0) {
            for (Comprador comprador : listaCompradores) {
                cbComprador.addItem(comprador.getNome());
            }
        } else {
            cbComprador.addItem("Nenhum Comprador Cadastrado");
        }

        //ComboBox
        JComboBox cbCorretor = new JComboBox();
        ArrayList<Corretor> listaCorretores = this.ctrVisita.ctrPrincipal.ctrCorretor.getListaAll();
        if (listaCompradores.size() > 0) {
            for (Corretor corretor : listaCorretores) {
                cbCorretor.addItem(corretor.getNome());
            }
        } else {
            cbCorretor.addItem("Nenhum Corretor Cadastrado");
        }

        //Inicializa TextFields 
        JTextField tfData = new JTextField("");

        //Inicializa Labels
        JLabel lbLogo = new JLabel("DADOS DA VISITA");
        JLabel lbData = new JLabel("Data*:");
        JLabel lbComprador = new JLabel("Comprador*:");
        JLabel lbCorretor = new JLabel("Corretor*:");

        //Inicializa Botões
        JButton btSubmit = new JButton("Cadastrar");
        JButton btCancelar = new JButton("Cancelar");
        //seta Layout de pCadastro
        pCadastro.setLayout(null);
        //Listener dos botões
        btSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //verifica se tem campo em branco, se tiver não deixa cadastrar
                if (tfData.getText().equals("")) {
                    if (((String) cbComprador.getSelectedItem()).equals("Nenhum Comprador Cadastrado")
                            || ((String) cbCorretor.getSelectedItem()).equals("Nenhum Corretor Cadastrado")) {
                        JOptionPane.showMessageDialog(null,
                                "Deve haver pelomenos um Corretor e um Comprador "
                                + "para realizar o cadastro!", "Error!",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos os campos "
                                + "devem ser preenchidos antes da conclusão do "
                                + "cadastro", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    //chama o metodo para cadastrar visita, que esta no ControleVisita
                    ctrVisita.ctrPrincipal.ctrImovel.addVisita(codigo, ctrVisita.cadastraVisita(
                            tfData.getText(),
                            (String) cbComprador.getSelectedItem(),
                            (String) cbCorretor.getSelectedItem()
                    ));
                    frCadastra.dispose();
                }
            }
        });
        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frCadastra.dispose();
            }
        });
        //-Posicao dos elementos -// (x, y, largura, altura)
        lbLogo.setBounds(200, 0, 125, 25);

        lbData.setBounds(0, 150, 500, 25);
        lbCorretor.setBounds(0, 50, 500, 25);
        lbComprador.setBounds(0, 100, 500, 25);

        cbComprador.setBounds(0, 75, 485, 25);
        cbCorretor.setBounds(0, 125, 485, 25);

        tfData.setBounds(0, 175, 500, 25);

        btSubmit.setBounds(200, 375, 100, 25);
        btCancelar.setBounds(200, 425, 100, 25);
        //adicao dos elementos no painel-//
        pCadastro.add(tfData);
        pCadastro.add(cbCorretor);
        pCadastro.add(cbComprador);

        pCadastro.add(lbLogo);
        pCadastro.add(lbData);
        pCadastro.add(lbCorretor);
        pCadastro.add(lbComprador);

        pCadastro.add(btSubmit);
        pCadastro.add(btCancelar);
        //Ajustes no frame
        frCadastra.setSize(500, 500);
        frCadastra.getContentPane().add(pCadastro);
        frCadastra.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frCadastra.setVisible(true);
    }

    public void listaVisita(Imovel imovel, String estado) {
        JFrame frConsultar = new JFrame();

        JPanel pMain = new JPanel();//Painel principal
        JPanel pLabel = new JPanel();//Painel para Armazenar o label inicial
        JPanel pButtons = new JPanel();//Painel pra guardar os botÃµes de Editar, Excluir e Cadastrar um novo Visita
        //pMain especificações
        pMain.setLayout(null);
        //pLabel especificações
        pLabel.setLayout(new BorderLayout());
        pLabel.add(new JLabel("LISTA DE VISITAS (IMOVEL: " + imovel.getCodigo() + ")"), BorderLayout.CENTER);
        //ComboBox
        JComboBox cbEstado = new JComboBox();
        /////////////////
        //Evitar repetições no JComboBox
        ////////////////
        //Array para pegar os tipos de porpostas já cadastrados
        ArrayList<String> auxString = new ArrayList<String>();
        //inicializa ComboBox
        cbEstado.addItem("Todos");
        cbEstado.addItem(Util.SUBMEDITA);//adiciona item no comboBox
        cbEstado.addItem(Util.REJEITADA);//adiciona item no comboBox
        cbEstado.addItem(Util.ACEITA);//adiciona item no comboBox
        cbEstado.setSelectedItem(0);
        //pButtons especificações
        pButtons.setLayout(new GridLayout(1, 4, 5, 0));
        //Adição dos botões
        JButton bRealiza = new JButton("Realizar Visita");
        JButton bCancela = new JButton("Cancelar Visita");

        cbEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frConsultar.dispose();
                listaVisita(imovel, (String) cbEstado.getSelectedItem());
            }
        });
        bRealiza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedVisita != null) {
                    frConsultar.dispose();
                    ctrVisita.ctrPrincipal.ctrImovel.realizarVisita(imovel.getCodigo(), selectedVisita);
                    listaVisita(imovel, estado);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Selecione pelomenos um item na lista!",
                            "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        bCancela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedVisita != null) {
                    frConsultar.dispose();
                    ctrVisita.ctrPrincipal.ctrImovel.cancelarVisita(imovel.getCodigo(), selectedVisita);
                    listaVisita(imovel, estado);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Selecione pelomenos um item na lista!",
                            "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        pButtons.add(bRealiza);
        pButtons.add(bCancela);
        pButtons.add(cbEstado);

        JPanel pLista = new JPanel();
        pLista.setLayout(new BoxLayout(pLista, BoxLayout.Y_AXIS));

        pLista.add(pLabel);
        pLista.add(pButtons);

        ButtonGroup grp = new ButtonGroup();

        int i = 1;
        int y = 110;
        if (imovel.getListaVisitas().size() != 0) {
            for (Visita p : imovel.getListaVisitas()) {
                if (estado.equals(p.getEstado()) || estado.equals("Todos")) {
                    JRadioButton rb = new JRadioButton(String.valueOf(i));
                    pLista.setBounds(0, y, 50, 100);
                    rb.setBounds(0, y, 50, 50);
                    rb.addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            JToggleButton button = (JToggleButton) e.getSource();
                            if (e.getStateChange() == ItemEvent.SELECTED) {
                                selectedVisita = p;
                                System.out.println(p.getEstado());
                                if(p.getEstado().equals(Util.AGENDADA)){
                                    bRealiza.setEnabled(true);                                    
                                    bCancela.setEnabled(true);
                                }else{
                                    bRealiza.setEnabled(false);                                    
                                    bCancela.setEnabled(false);
                                }
                            }
                        }
                    });
                    grp.add(rb);
                    pLista.add(rb);

                    JTextArea text = new JTextArea(
                            "Comprador: " + p.getComprador().getNome()
                            + "\nCorretor: " + p.getCorretor().getNome()
                            + "\nEstado: " + p.getEstado()
                            + "\nData: " + p.getData().get(Calendar.DAY_OF_MONTH)
                            + "/" + (p.getData().get(Calendar.MONTH) + 1) + "/"
                            + p.getData().get(Calendar.YEAR));
                    text.setBounds(50, y, 500, 100);

                    pLista.add(text);
                    i++;
                    y += 110;
                }
            }
        }

        pLabel.setBounds(0, 0, 500, 50);
        pButtons.setBounds(0, 50, 500, 50);
        //pLista.setPreferredSize(new Dimension(500, 600));
        JScrollPane scroll = new JScrollPane(pLista, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        frConsultar.setPreferredSize(new Dimension(550, 600));
        frConsultar.setLayout(new BorderLayout());
        frConsultar.add(scroll, BorderLayout.CENTER);
        frConsultar.pack();
        //frConsultar.getContentPane().add(scroll);
        frConsultar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frConsultar.setSize(900, 600);
        frConsultar.setVisible(true);

    }
}
