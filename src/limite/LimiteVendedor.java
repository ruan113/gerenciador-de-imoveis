//BRUNO GUILHERME LUNARDI - 2016003830
//IAN MARCEL TOBAR - 2016001693 
//RUAN MICHEL ADABO - 2016015278 
package limite;

import Model.*;
import controle.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;

public class LimiteVendedor extends JFrame implements ActionListener {

    //controlador
    ControleVendedor ctrVendedor;
    //Panel
    JPanel panel;
    //Botões
    JButton btCadastrar;
    JButton btConsultar;
    //labels
    JLabel lbOpcoes;
    //sera usado para editar ou excluir imóvel
    int index = 0;

    //contrutor
    public LimiteVendedor(ControleVendedor ctrVendedor) {

        this.ctrVendedor = ctrVendedor;//Armazena o controlador Principal numa variavel

    }

    //listener para os botões cadastrar e consultar
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btCadastrar)) {
//            cadastraImovel();
        }
        if (e.getSource().equals(btConsultar)) {

        }

    }

    //metodo para exibir o formulário de cadastro de imóveis
    void cadastraVendedor() {
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
        JLabel lbLogo = new JLabel("DADOS DO VENDEDOR");
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
                    //chama o metodo para cadastrar imovel, que esta no ControleImovel
                    ctrVendedor.cadastrarVendedor(new Vendedor(
                            tfCpf.getText(),
                            tfNome.getText(),
                            tfEmail.getText(),
                            tfFone.getText(),
                            tfContatoPref.getText()
                    ));

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
        tfContatoPref.setBounds(0, 275, 100, 25);

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

    public void listaVendedores() {

        JFrame frConsultar = new JFrame();

        JPanel pMain = new JPanel();//Painel principal
        JPanel pLabel = new JPanel();//Painel para Armazenar o label inicial
        JPanel pButtons = new JPanel();//Painel pra guardar os botÃµes de Editar, Excluir e Cadastrar um novo Imovel

        //pMain especificações
        pMain.setLayout(null);

        //pLabel especificações
        pLabel.setLayout(new BorderLayout());
        pLabel.add(new JLabel("LISTA DE VENDEDORES"), BorderLayout.CENTER);

        //ComboBox
        JComboBox cbTipo = new JComboBox();

        /////////////////
        //Evitar repetições no JComboBox
        ////////////////
       
        //pButtons especificações
        pButtons.setLayout(new GridLayout(1, 4, 5, 0));
        //Adição dos botões
        JButton bCadastrar = new JButton("Cadastrar Novo Imovel");
        JButton bEditar = new JButton("Editar Imovel");
        JButton bExcluir = new JButton("Excluir Imovel");

        cbTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctrImovel.getInfoList((String) cbTipo.getSelectedItem());
                frConsultar.dispose();
                listaImoveis((String) cbTipo.getSelectedItem());
            }
        });

        bCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frConsultar.dispose();
                cadastraImovel();
            }
        });
        bEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frConsultar.dispose();
                editaImovel(index);
            }
        });
        bExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frConsultar.dispose();
                ctrImovel.removeLista(index);
                listaImoveis(pTipo);

            }
        });

        pButtons.add(bCadastrar);
        pButtons.add(bEditar);
        pButtons.add(bExcluir);
        pButtons.add(cbTipo);

        ArrayList<String> lista = ctrImovel.getInfoList(pTipo);

        JPanel pLista = new JPanel();
        pLista.setLayout(new BoxLayout(pLista, BoxLayout.Y_AXIS));

        pLista.add(pLabel);
        pLista.add(pButtons);

        ButtonGroup grp = new ButtonGroup();

        int i = 1;
        int y = 110;
        if (lista.size() != 0) {
            for (String imovel : lista) {
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

                JTextArea text = new JTextArea(imovel);
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

    public void editaImovel(int index) {
        //Inicializa Tela
        JFrame frEdita = new JFrame();

        //Inicializa Painel
        JPanel pEdita = new JPanel();

        Imovel i = ctrImovel.getLista().get(index);

        //Inicializa TextFields 
        JTextField tfCodigo = new JTextField(i.getCodigo());
        JTextField tfDescricao = new JTextField(i.getDescricao());
        JTextField tfProprietario = new JTextField("");
        JTextField tfPreco = new JTextField(String.valueOf(i.getPreco()));
        JTextField tfData = new JTextField(
                i.getDataInclusao().DATE
                + "/"
                + i.getDataInclusao().MONTH
                + "/"
                + i.getDataInclusao().YEAR
        );
        //ComboBox
        JComboBox cbTipo = new JComboBox();
        //adiciona os 5 tipos de imóveis no JComboBox
        cbTipo.addItem(Util.LOTE);
        cbTipo.addItem(Util.CASA);
        cbTipo.addItem(Util.APTO);
        cbTipo.addItem(Util.SALA);
        cbTipo.addItem(Util.RURAL);

        cbTipo.setSelectedItem(i.getTipo());

        //ComboBox
        JComboBox cbComissao = new JComboBox();
        //adiciona os 5 tipos de imóveis no JComboBox
        cbComissao.addItem("1%");
        cbComissao.addItem("2%");
        cbComissao.addItem("3%");
        cbComissao.addItem("4%");
        cbComissao.addItem("5%");

        cbComissao.setSelectedItem(i.getComissao());

        //ComboBox
        JComboBox cbVendedor = new JComboBox();
        ArrayList<Vendedor> listaVendedores = this.ctrImovel.ctrPrincipal.ctrVendedor.getListAll();
        if (!listaVendedores.isEmpty()) {
            for (Vendedor vendedor : listaVendedores) {
                cbTipo.addItem(vendedor.getNome());
            }
        } else {
            cbTipo.addItem("Nenhum Vendedor Cadastrado");
        }

        cbTipo.setSelectedItem(i.getVendedor());

        //Inicializa Labels
        JLabel lbLogo = new JLabel("DADOS DO IMOVEL");
        JLabel lbCodigo = new JLabel("Código*:");
        JLabel lbTipo = new JLabel("Tipo*:");
        JLabel lbDescricao = new JLabel("Descrição*:");
        JLabel lbProprietario = new JLabel("Proprietário do Imóvel*:");
        JLabel lbPreco = new JLabel("Preço*:");
        JLabel lbComissao = new JLabel("Comissao*:");
        JLabel lbData = new JLabel("Data (dd/mm/yyyy):");
        JLabel lbVendedor = new JLabel("Vendedor:");
        //Inicializa Botões
        JButton btSubmit = new JButton("Cadastrar");
        JButton btCancelar = new JButton("Cancelar");
        //seta Layout de pCadastro
        pEdita.setLayout(null);

        //Listener dos botÃµes
        btSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfCodigo.getText().equals("")
                        || tfDescricao.getText().equals("") || tfProprietario.getText().equals("")
                        || tfPreco.getText().equals("")) {
                    if (((String) cbVendedor.getSelectedItem())
                            .equals("Nenhum Vendedor Cadastrado")) {
                        JOptionPane.showMessageDialog(null, "Cadastre primeiro um vendedor!", "Error!", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos antes da conclusÃ£o do cadastro", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    Calendar data = Calendar.getInstance();
                    String[] aux = tfData.getText().split("/");
                    data.set(
                            Integer.parseInt(aux[2]),
                            Integer.parseInt(aux[1]),
                            Integer.parseInt(aux[0])
                    );

                    Imovel novoImovel = new Imovel(
                            Integer.parseInt(tfCodigo.getText()),
                            (String) cbTipo.getSelectedItem(),
                            tfDescricao.getText(),
                            "",
                            Double.valueOf(tfPreco.getText()),
                            Double.parseDouble(
                                    ((String) cbComissao.getSelectedItem()).replace("%", "")
                            ),
                            data,
                            ctrImovel.ctrPrincipal.ctrVendedor.getVendedorByNome(
                                    (String) cbVendedor.getSelectedItem()
                            ));

                    ctrImovel.editaLista(index, novoImovel);
                    frEdita.dispose();
                    listaImoveis("Todos");
                    //frCadastra.dispose();
                }
            }
        });
        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frEdita.dispose();
                listaImoveis("Todos");
            }
        });

        //-PosiÃ§Ãµes dos elementos-// (x, y, largura, altura)
        lbLogo.setBounds(200, 0, 125, 25);
        lbCodigo.setBounds(0, 50, 500, 25);
        lbTipo.setBounds(0, 100, 500, 25);
        lbDescricao.setBounds(0, 150, 500, 25);
        lbProprietario.setBounds(0, 200, 500, 25);
        lbPreco.setBounds(0, 250, 100, 25);
        lbData.setBounds(0, 305, 125, 25);
        lbComissao.setBounds(150, 250, 100, 25);
        lbVendedor.setBounds(150, 305, 75, 25);

        cbTipo.setBounds(0, 125, 485, 25);

        tfCodigo.setBounds(0, 75, 500, 25);
        tfDescricao.setBounds(0, 175, 500, 25);
        tfProprietario.setBounds(0, 225, 500, 25);
        tfPreco.setBounds(0, 275, 100, 25);
        tfData.setBounds(0, 330, 100, 25);
        cbComissao.setBounds(150, 275, 50, 25);
        cbVendedor.setBounds(150, 330, 325, 25);

        btSubmit.setBounds(200, 375, 100, 25);
        btCancelar.setBounds(200, 425, 100, 25);

        //-AdiÃ§Ã£o dos elementos no painel-//
        pEdita.add(tfCodigo);
        pEdita.add(cbTipo);
        pEdita.add(tfDescricao);
        pEdita.add(tfProprietario);
        pEdita.add(tfPreco);
        pEdita.add(tfData);
        pEdita.add(cbComissao);
        pEdita.add(cbVendedor);

        pEdita.add(lbLogo);
        pEdita.add(lbCodigo);
        pEdita.add(lbTipo);
        pEdita.add(lbDescricao);
        pEdita.add(lbProprietario);
        pEdita.add(lbPreco);
        pEdita.add(lbData);
        pEdita.add(lbComissao);
        pEdita.add(lbVendedor);

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
