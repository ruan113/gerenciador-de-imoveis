/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limite.relatorios;

import Model.Corretor;
import Model.Imovel;
import Model.Proposta;
import Model.Util;
import Model.Visita;
import controle.ControlePrincipal;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JComboBox;

/**
 *
 * @author hyper
 */
public class formValorPorCorretorPeriodo extends javax.swing.JPanel {

    ControlePrincipal ctrPrincipal;

    /**
     * Creates new form formImoveisVendedor
     */
    public formValorPorCorretorPeriodo(ControlePrincipal ctrPrincipal) {
        this.ctrPrincipal = ctrPrincipal;
        initComponents();

        this.taResultado.setText("Escolha um periodo de tempo usando as opções acima!");
        //------------Inicializa comboboxes das datas------------
        inicializaDatas();
        //------------Inicializa combobox dos imoveis------------
        cbCorretores.removeAllItems();
        for (Corretor c : this.ctrPrincipal.ctrCorretor.getListaAll()) {
            cbCorretores.addItem(c.getNome());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btSearch = new javax.swing.JButton();
        cbDiaInicial = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        taResultado = new javax.swing.JTextArea();
        cbMesInicial = new javax.swing.JComboBox<>();
        cbAnoInicial = new javax.swing.JComboBox<>();
        cbDiaFinal = new javax.swing.JComboBox<>();
        cbMesFinal = new javax.swing.JComboBox<>();
        cbAnoFinal = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbCorretores = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(500, 500));

        btSearch.setText("Procurar");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        cbDiaInicial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDiaInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDiaInicialActionPerformed(evt);
            }
        });

        taResultado.setColumns(20);
        taResultado.setLineWrap(true);
        taResultado.setRows(5);
        jScrollPane1.setViewportView(taResultado);

        cbMesInicial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMesInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMesInicialActionPerformed(evt);
            }
        });

        cbAnoInicial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbAnoInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAnoInicialActionPerformed(evt);
            }
        });

        cbDiaFinal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDiaFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDiaFinalActionPerformed(evt);
            }
        });

        cbMesFinal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMesFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMesFinalActionPerformed(evt);
            }
        });

        cbAnoFinal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbAnoFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAnoFinalActionPerformed(evt);
            }
        });

        jLabel1.setText("Data Inicial");

        jLabel2.setText("Data Final");

        jLabel3.setText("Escolha uma data para gerar o relatório:");

        jLabel4.setText("Escolha uns dos corretores cadastrados:");

        cbCorretores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCorretores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCorretoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCorretores, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(cbDiaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addComponent(cbMesInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbAnoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(cbMesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(cbAnoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(cbDiaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(142, 142, 142))))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDiaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMesInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAnoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDiaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAnoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addComponent(cbCorretores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void inicializaDatas() {
        //Remove itens existentes
        this.cbDiaInicial.removeAllItems();
        this.cbMesInicial.removeAllItems();
        this.cbAnoInicial.removeAllItems();
        this.cbDiaFinal.removeAllItems();
        this.cbMesFinal.removeAllItems();
        this.cbAnoFinal.removeAllItems();

        for (int ano = this.ctrPrincipal.ctrImovel.getMenorAno();
                ano <= this.ctrPrincipal.ctrImovel.getMaiorAno() + 1;
                ano++) {
            cbAnoFinal.addItem(String.valueOf(ano));
            cbAnoInicial.addItem(String.valueOf(ano));
        }

        for (int mes = 1; mes <= 12; mes++) {
            cbMesFinal.addItem(String.valueOf(mes));
            cbMesInicial.addItem(String.valueOf(mes));
        }

        for (int dia = 1; dia <= 31; dia++) {
            cbDiaFinal.addItem(String.valueOf(dia));
            cbDiaInicial.addItem(String.valueOf(dia));
        }
    }

    public void ajustaDatas(JComboBox cbDia, JComboBox cbMes) {
        if (cbDia.getSelectedIndex() == -1 || cbMes.getSelectedIndex() == -1) {
            return;
        }
        //Recebe por referencia o que deve ser mudado
        cbDia.removeAllItems();
        int aux = Integer.parseInt((String) cbMes.getSelectedItem());

        int diaMax = 31;
        if (aux == 1 || aux == 3 || aux == 5 || aux == 7 || aux == 8 || aux == 10 || aux == 12) {
            diaMax = 31;
        } else {
            if (aux == 2) {
                diaMax = 28;
            } else {
                diaMax = 30;
            }
        }

        for (int dia = 1; dia <= diaMax; dia++) {
            cbDia.addItem(String.valueOf(dia));
        }
    }

    private void geraResultados() {
        Corretor corretor = this.ctrPrincipal.ctrCorretor.getCorretorByNome(
            (String) cbCorretores.getSelectedItem()
        );
        
        Calendar dataInicial = Calendar.getInstance();
        dataInicial.set(Calendar.DAY_OF_MONTH, Integer.parseInt((String) cbDiaInicial.getSelectedItem()));
        dataInicial.set(Calendar.MONTH, Integer.parseInt((String) cbMesInicial.getSelectedItem()));
        dataInicial.set(Calendar.YEAR, Integer.parseInt((String) cbAnoInicial.getSelectedItem()));

        Calendar dataFinal = Calendar.getInstance();
        dataFinal.set(Calendar.DAY_OF_MONTH, Integer.parseInt((String) cbDiaFinal.getSelectedItem()));
        dataFinal.set(Calendar.MONTH, Integer.parseInt((String) cbMesFinal.getSelectedItem()));
        dataFinal.set(Calendar.YEAR, Integer.parseInt((String) cbAnoFinal.getSelectedItem()));

        double valorTotal = 0;

        for (Imovel i : this.ctrPrincipal.ctrImovel.getLista()) {
            if (i.getEstado().equals(Util.VENDIDO)) {
                for (Proposta p : i.getListaPropostas()) {
                    if (p.getEstado().equals(Util.ACEITA)
                            && p.getCorretor().getNome().equals(
                                    (String) cbCorretores.getSelectedItem()
                            )
                            && p.getData().after(dataInicial)
                            && p.getData().before(dataFinal)) {
                        valorTotal += p.getValor() * (corretor.getPercCorretagem()/100);
                    }
                }
            }
        }

        if (valorTotal == 0) {
            taResultado.setText("O corretor "
                    + ((String) cbCorretores.getSelectedItem())
                    + " não obteve ganhos durante este periodo!");
            return;
        }

        taResultado.setText("O rendimento total do corretor ("
                + corretor.getPercCorretagem()+"% de corretagem) "
                + ((String) cbCorretores.getSelectedItem())
                + " foi de "
                + valorTotal
                + " reais durante o periodo selecionado.");
    }

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        geraResultados();
    }//GEN-LAST:event_btSearchActionPerformed

    private void cbDiaInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDiaInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDiaInicialActionPerformed

    private void cbMesInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMesInicialActionPerformed
        ajustaDatas(cbDiaInicial, cbMesInicial);
    }//GEN-LAST:event_cbMesInicialActionPerformed

    private void cbAnoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAnoInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAnoInicialActionPerformed

    private void cbDiaFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDiaFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDiaFinalActionPerformed

    private void cbMesFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMesFinalActionPerformed
        ajustaDatas(cbDiaFinal, cbMesFinal);
    }//GEN-LAST:event_cbMesFinalActionPerformed

    private void cbAnoFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAnoFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAnoFinalActionPerformed

    private void cbCorretoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCorretoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCorretoresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSearch;
    private javax.swing.JComboBox<String> cbAnoFinal;
    private javax.swing.JComboBox<String> cbAnoInicial;
    private javax.swing.JComboBox<String> cbCorretores;
    private javax.swing.JComboBox<String> cbDiaFinal;
    private javax.swing.JComboBox<String> cbDiaInicial;
    private javax.swing.JComboBox<String> cbMesFinal;
    private javax.swing.JComboBox<String> cbMesInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taResultado;
    // End of variables declaration//GEN-END:variables
}
