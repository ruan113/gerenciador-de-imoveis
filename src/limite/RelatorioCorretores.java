//BRUNO GUILHERME LUNARDI
//RUAN MICHEL ADABO
//IAN MARCELO TOBAR
package limite;

import controle.ControlePrincipal;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Model.Corretor;
import Model.CorretorComissionado;
import Model.CorretorContratado;
import Model.Venda;

public class RelatorioCorretores extends javax.swing.JFrame {

    //controlador
    ControlePrincipal ctrPrincipal;

    /**
     * Creates new form RelatorioCorretores
     */
    public RelatorioCorretores(ControlePrincipal ctrPrincipal) {
        //inicia controlador
        this.ctrPrincipal = ctrPrincipal;
        //inicia os componentes        
        initComponents();
        //configura esta janela
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbMes = new javax.swing.JLabel();
        lbAno = new javax.swing.JLabel();
        tfMesPesquisa = new javax.swing.JTextField();
        tfAnoPesquisa = new javax.swing.JTextField();
        lbResultado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taResultadoPesquisa = new javax.swing.JTextArea();
        lbCorretorMes = new javax.swing.JLabel();
        lbResultNomeCorretorMes = new javax.swing.JLabel();
        btCancelar = new javax.swing.JButton();
        btOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relatório Corretores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lbMes.setText("Digite o Mês:");

        lbAno.setText("Digite o Ano:");

        lbResultado.setText("Resultado:");

        taResultadoPesquisa.setColumns(20);
        taResultadoPesquisa.setRows(5);
        jScrollPane1.setViewportView(taResultadoPesquisa);

        lbCorretorMes.setText("Corretor do Mês:");

        lbResultNomeCorretorMes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbResultNomeCorretorMes.setText("Nome do Corretor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfMesPesquisa))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfAnoPesquisa)))
                            .addComponent(lbResultado)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbCorretorMes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbResultNomeCorretorMes)))
                        .addGap(0, 170, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMes)
                    .addComponent(lbAno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMesPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAnoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbResultado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCorretorMes)
                    .addComponent(lbResultNomeCorretorMes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btOk.setText("OK");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addGap(18, 18, 18))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCancelar, btOk});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btOk))
                .addGap(0, 27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed
        String output = "";
        String nomeCorretorMes = "";
        //verifica se foi digitado ano e mês
        if (tfAnoPesquisa.equals("") || tfMesPesquisa.equals("")) {
            JOptionPane.showMessageDialog(null, "Ano e Mês são obrigatórios!!!");
        }
        else {
            //pega mes e ano digitado
            int pMes = Integer.parseInt(tfMesPesquisa.getText());
            int pAno = Integer.parseInt(tfAnoPesquisa.getText());
            double vendas;
            double salario = 0.0;
            double maiorVenda = 0.0;
            
            
            //for para percorrer a lista de corretores
            //pega todos os corretores cadastrados no sistema
            for (Corretor c : ctrPrincipal.ctrCorretor.getListaCorretor()) {
                //inicializa vendas
                vendas = 0.0;//pega o valor total da venda de cada corretor

                output += "Nome Corretor: " + c.getaNome() + "\n";

                //for para percorrer a lista de vendas
                //atraves do nome do corretor da variavel c acha as vendas
                for (Venda v : ctrPrincipal.ctrVenda.getListaVendas()) {
                    //if para pegar as vendas da data digitada
                    if ((v.getDataVenda().get(Calendar.MONTH) == pMes)
                            && (v.getDataVenda().get(Calendar.YEAR) == pAno)
                            && (v.getCorretorResponsavel().getaNome().equals(c.getaNome()))) {

                            vendas = vendas + v.getValorNegociado();

                    }
                }

                output += "Faturamento: " + vendas + "\n";
                
                //verifica quem vendeu mais
                if(vendas > maiorVenda){
                    maiorVenda = vendas;
                    nomeCorretorMes = c.getaNome();
                }

                //verifica o tipo de corretor
                if (c instanceof CorretorComissionado) {
                    vendas = vendas * 0.03;
                    output += "Valor pago ao Corretor Comissionado: " + String.valueOf(vendas) + "\n";
                }
                else {
                    //variavel auxiliar para pegar o salario do corretor contratado
                    CorretorContratado auxContratado = (CorretorContratado)c;//converte para contratado
                    vendas = vendas * 0.01;
                    vendas = vendas + auxContratado.getaSalarioFixo();
                    output += "Valor pago ao Corretor Comissionado: " + String.valueOf(vendas) + "\n";
                }

                output += "\n-----------------------------------------------------------------------\n";
                
            }

        }
        lbResultNomeCorretorMes.setText(nomeCorretorMes);
        taResultadoPesquisa.setEditable(false);
        taResultadoPesquisa.setText(output);

    }//GEN-LAST:event_btOkActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        //fecha tela
        this.dispose();

    }//GEN-LAST:event_btCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btOk;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAno;
    private javax.swing.JLabel lbCorretorMes;
    private javax.swing.JLabel lbMes;
    private javax.swing.JLabel lbResultNomeCorretorMes;
    private javax.swing.JLabel lbResultado;
    private javax.swing.JTextArea taResultadoPesquisa;
    private javax.swing.JTextField tfAnoPesquisa;
    private javax.swing.JTextField tfMesPesquisa;
    // End of variables declaration//GEN-END:variables
}
