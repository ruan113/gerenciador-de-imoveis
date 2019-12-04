package limite;

import Model.*;
import controle.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;

public class LimiteComprador extends JFrame implements ActionListener {

    //controlador
    ControleComprador ctrComprador;
    //Panel
    JPanel panel;
    //Botões
    JButton btCadastrar;
    JButton btConsultar;
    //sera usado para editar ou excluir imóvel
    int index = 0;

    //contrutor
    public LimiteComprador(ControleComprador ctrComprador) {
        this.ctrComprador = ctrComprador;//Armazena o controlador Principal numa variavel
    }

    //listener para os botões cadastrar e consultar
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btCadastrar)) {
//            cadastraComprador();
        }
        if (e.getSource().equals(btConsultar)) {
        }
    }

    //metodo para exibir o formulário de cadastro de imóveis
    void cadastraComprador() {
        //Inicializa Tela
        JFrame frCadastra = new JFrame();
        //Inicializa Painel
        JPanel pCadastro = new JPanel();
        //Inicializa TextFields 
        JTextField tfNome = new JTextField("");
        JTextField tfCpf = new JTextField("");
        JTextField tfEmail = new JTextField("");
        JTextField tfFone = new JTextField("");
        JTextField tfContatoPref = new JTextField("");
        //Inicializa Labels
        JLabel lbLogo = new JLabel("DADOS DO COMPRADOR");
        JLabel lbNome = new JLabel("Nome*:");
        JLabel lbCpf = new JLabel("CPF*:");
        JLabel lbEmail = new JLabel("Email*:");
        JLabel lbFone = new JLabel("Telefone*:");
        JLabel lbContatoPref = new JLabel("Contato Preferencial*:");
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
                if (tfNome.getText().equals("")
                        || tfCpf.getText().equals("") || tfEmail.getText().equals("")
                        || tfFone.getText().equals("") || tfContatoPref.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos antes da conclusÃ£o do cadastro", "Error!", JOptionPane.ERROR_MESSAGE);
                } else {
                    //chama o metodo para cadastrar comprador, que esta no ControleComprador
                    try {
                        ctrComprador.insereComprador(
                                tfCpf.getText(),
                                tfNome.getText(),
                                tfEmail.getText(),
                                tfFone.getText(),
                                tfContatoPref.getText()
                        );
                    } catch (Exception err) {
                        JOptionPane.showMessageDialog(null,
                                "Erro ao cadastrar comprador!",
                                "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    //limpar os campos do formulario
                    tfCpf.setText("");
                    tfNome.setText("");
                    tfEmail.setText("");
                    tfFone.setText("");
                    tfContatoPref.setText("");
                }
            }
        });
        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frCadastra.dispose();
            }
        });
        //-PosiÃ§Ãµes dos elementos-// (x, y, largura, altura)
        lbLogo.setBounds(200, 0, 125, 25);
        lbNome.setBounds(0, 50, 500, 25);
        lbCpf.setBounds(0, 100, 500, 25);
        lbEmail.setBounds(0, 150, 500, 25);
        lbFone.setBounds(0, 200, 500, 25);
        lbContatoPref.setBounds(0, 250, 100, 25);

        tfNome.setBounds(0, 75, 500, 25);
        tfCpf.setBounds(0, 125, 500, 25);
        tfEmail.setBounds(0, 175, 500, 25);
        tfFone.setBounds(0, 225, 500, 25);
        tfContatoPref.setBounds(0, 275, 500, 25);

        btSubmit.setBounds(200, 375, 100, 25);
        btCancelar.setBounds(200, 425, 100, 25);
        //-AdiÃ§Ã£o dos elementos no painel-//
        pCadastro.add(lbLogo);
        pCadastro.add(lbNome);
        pCadastro.add(lbCpf);
        pCadastro.add(lbEmail);
        pCadastro.add(lbFone);
        pCadastro.add(lbContatoPref);

        pCadastro.add(tfNome);
        pCadastro.add(tfCpf);
        pCadastro.add(tfEmail);
        pCadastro.add(tfFone);
        pCadastro.add(tfContatoPref);

        pCadastro.add(btSubmit);
        pCadastro.add(btCancelar);
        //Ajustes no frame
        frCadastra.setSize(500, 500);
        frCadastra.getContentPane().add(pCadastro);
        frCadastra.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frCadastra.setVisible(true);
    }

    public void listaCompradores() {
        JFrame frConsultar = new JFrame();
        JPanel pMain = new JPanel();//Painel principal
        JPanel pLabel = new JPanel();//Painel para Armazenar o label inicial
        JPanel pButtons = new JPanel();//Painel pra guardar os botÃµes de Editar, Excluir e Cadastrar um novo Comprador
        //pMain especificações
        pMain.setLayout(null);
        //pLabel especificações
        pLabel.setLayout(new BorderLayout());
        pLabel.add(new JLabel("LISTA DE COMPRADORES"), BorderLayout.CENTER);
        /////////////////
        //Evitar repetições no JComboBox
        ////////////////
        //pButtons especificações
        pButtons.setLayout(new GridLayout(1, 4, 5, 0));
        //Adição dos botões
        JButton bCadastrar = new JButton("Cadastrar Novo Comprador");
        JButton bEditar = new JButton("Editar Comprador");
        JButton bExcluir = new JButton("Excluir Comprador");

        bCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index != -1) {
                    frConsultar.dispose();
                    cadastraComprador();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Selecione pelomenos um item na lista!",
                            "Error!", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        bEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index != -1) {
                    frConsultar.dispose();
                    editaComprador(index);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Selecione pelomenos um item na lista!",
                            "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        bExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frConsultar.dispose();
                try {
                    ctrComprador.excluiComprador(index);
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null,
                            err,
                            "Error!", JOptionPane.ERROR_MESSAGE);
                }
                listaCompradores();
            }
        });

        pButtons.add(bCadastrar);
        pButtons.add(bEditar);
        pButtons.add(bExcluir);

        ArrayList<String> lista = ctrComprador.getInfoList();

        JPanel pLista = new JPanel();
        pLista.setLayout(new BoxLayout(pLista, BoxLayout.Y_AXIS));

        pLista.add(pLabel);
        pLista.add(pButtons);

        ButtonGroup grp = new ButtonGroup();

        int i = 1;
        int y = 110;
        if (lista.size() != 0) {
            for (String comprador : lista) {
                JRadioButton rb = new JRadioButton(String.valueOf(i));
                pLista.setBounds(0, y, 50, 100);
                rb.setBounds(0, y, 50, 50);

                rb.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        JToggleButton button = (JToggleButton) e.getSource();
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            index = Integer.parseInt(button.getText()) - 1;
                        }
                    }
                });
                grp.add(rb);
                pLista.add(rb);

                JTextArea text = new JTextArea(comprador);
                text.setBounds(50, y, 500, 100);

                pLista.add(text);
                i++;
                y += 110;
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

    public void editaComprador(int index) {
        //Inicializa Tela
        JFrame frEdita = new JFrame();
        //Inicializa Painel
        JPanel pEdita = new JPanel();
        Comprador v = ctrComprador.getListaAll().get(index);
        //Inicializa TextFields 
        JTextField tfNome = new JTextField(v.getNome());
        JTextField tfCpf = new JTextField(v.getCpf());
        JTextField tfEmail = new JTextField(v.getEmail());
        JTextField tfFone = new JTextField(v.getFone());
        JTextField tfContatoPref = new JTextField(v.getContatoPref());

        //Inicializa Labels
        JLabel lbLogo = new JLabel("DADOS DO COMPRADOR");
        JLabel lbNome = new JLabel("Nome*:");
        JLabel lbCpf = new JLabel("CPF*:");
        JLabel lbEmail = new JLabel("E-mail*:");
        JLabel lbFone = new JLabel("Fone*:");
        JLabel lbContatoPref = new JLabel("Contato Preferencial*:");

        //Inicializa Botões
        JButton btSubmit = new JButton("Cadastrar");
        JButton btCancelar = new JButton("Cancelar");
        //seta Layout de pCadastro
        pEdita.setLayout(null);
        //Listener dos botÃµes
        btSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfNome.getText().equals("")
                        || tfCpf.getText().equals("")
                        || tfEmail.getText().equals("")
                        || tfFone.getText().equals("")
                        || tfContatoPref.getText().equals("")) {

                } else {
                    Comprador novoComprador
                            = new Comprador(
                                    tfNome.getText(),
                                    tfCpf.getText(),
                                    tfEmail.getText(),
                                    tfFone.getText(),
                                    tfContatoPref.getText()
                            );
                    ctrComprador.editaComprador(index, novoComprador);
                    frEdita.dispose();
                    listaCompradores();
                    //frCadastra.dispose();
                }
            }
        });
        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frEdita.dispose();
                listaCompradores();
            }
        });
        //-PosiÃ§Ãµes dos elementos-// (x, y, largura, altura)
        lbLogo.setBounds(200, 0, 125, 25);
        lbNome.setBounds(0, 50, 500, 25);
        lbCpf.setBounds(0, 100, 500, 25);
        lbEmail.setBounds(0, 150, 500, 25);
        lbFone.setBounds(0, 200, 500, 25);
        lbContatoPref.setBounds(0, 250, 100, 25);

        tfNome.setBounds(0, 75, 500, 25);
        tfCpf.setBounds(0, 125, 500, 25);
        tfEmail.setBounds(0, 175, 500, 25);
        tfFone.setBounds(0, 225, 500, 25);
        tfContatoPref.setBounds(0, 275, 500, 25);

        btSubmit.setBounds(200, 375, 100, 25);
        btCancelar.setBounds(200, 425, 100, 25);
        //-AdiÃ§Ã£o dos elementos no painel-//
        pEdita.add(tfNome);
        pEdita.add(tfCpf);
        pEdita.add(tfEmail);
        pEdita.add(tfFone);
        pEdita.add(tfContatoPref);

        pEdita.add(lbLogo);
        pEdita.add(lbNome);
        pEdita.add(lbCpf);
        pEdita.add(lbEmail);
        pEdita.add(lbFone);
        pEdita.add(lbContatoPref);

        pEdita.add(btSubmit);
        pEdita.add(btCancelar);
        //Inicializa textos ja cadastrados
        //Ajustes no frame
        frEdita.setSize(500, 500);
        frEdita.getContentPane().add(pEdita);
        frEdita.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frEdita.setVisible(true);
    }
}
