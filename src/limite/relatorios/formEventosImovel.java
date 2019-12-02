
package limite.relatorios;

import Model.Imovel;
import Model.Proposta;
import Model.Visita;
import controle.ControlePrincipal;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JComboBox;

public class formEventosImovel extends javax.swing.JPanel {
    ControlePrincipal ctrPrincipal;
    public formEventosImovel(ControlePrincipal ctrPrincipal) {
        this.ctrPrincipal = ctrPrincipal;
        initComponents();

        this.taResultado.setText("Escolha um periodo de tempo usando as opções acima!");
        //------------Inicializa comboboxes das datas------------
        inicializaDatas();
        //------------Inicializa combobox dos imoveis------------
        cbImoveis.removeAllItems();
        for (Imovel i : this.ctrPrincipal.ctrImovel.getLista()) {
            cbImoveis.addItem(String.valueOf(i.getCodigo()));
        }
    }

    public void inicializaDatas() {
        //Remove itens existentes
        this.cbDiaInicial.removeAllItems();
        this.cbMesInicial.removeAllItems();
        this.cbAnoInicial.removeAllItems();
        this.cbDiaFinal.removeAllItems();
        this.cbMesFinal.removeAllItems();
        this.cbAnoFinal.removeAllItems();

        for (int ano = this.ctrPrincipal.ctrImovel.getMenorAno();
                ano <= this.ctrPrincipal.ctrImovel.getMaiorAno();
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

    private void buscaPorEventos() {
        Imovel imovel = this.ctrPrincipal.ctrImovel.getByCodigo(Integer.parseInt((String) cbImoveis.getSelectedItem()));
        ArrayList<Proposta> propostas = imovel.getListaPropostas();
        ArrayList<Visita> visitas = imovel.getListaVisitas();

        Calendar dataInicial = Calendar.getInstance();
        dataInicial.set(Calendar.DAY_OF_MONTH, Integer.parseInt((String) cbDiaInicial.getSelectedItem()));
        dataInicial.set(Calendar.MONTH, Integer.parseInt((String) cbMesInicial.getSelectedItem()));
        dataInicial.set(Calendar.YEAR, Integer.parseInt((String) cbAnoInicial.getSelectedItem()));

        Calendar dataFinal = Calendar.getInstance();
        dataFinal.set(Calendar.DAY_OF_MONTH, Integer.parseInt((String) cbDiaFinal.getSelectedItem()));
        dataFinal.set(Calendar.MONTH, Integer.parseInt((String) cbMesFinal.getSelectedItem()));
        dataFinal.set(Calendar.YEAR, Integer.parseInt((String) cbAnoFinal.getSelectedItem()));

        ArrayList<String> resultado = new ArrayList<String>();

        resultado.add("\n----------Visitas----------");
        for (Visita v : visitas) {
            if (v.getData().after(dataInicial) && v.getData().before(dataFinal)) {
                String aux = "Comprador: " + v.getComprador().getNome()
                        + "\nCorretor: " + v.getCorretor().getNome()
                        + "\nEstado: " + v.getEstado()
                        + "\nData: " + v.getData().get(Calendar.DAY_OF_MONTH)
                        + "/" + (v.getData().get(Calendar.MONTH) + 1) + "/"
                        + v.getData().get(Calendar.YEAR);
                resultado.add(aux);
            }
        }

        resultado.add("\n----------Propostas----------");
        for (Proposta p : propostas) {
            if (p.getData().after(dataInicial) && p.getData().before(dataFinal)) {
                String aux = "\nComprador: " + p.getComprador().getNome()
                        + "\nCorretor: " + p.getCorretor().getNome()
                        + "\nValor: " + p.getValor()
                        + "\nEstado: " + p.getEstado()
                        + "\nData: " + p.getData().get(Calendar.DAY_OF_MONTH)
                        + "/" + (p.getData().get(Calendar.MONTH) + 1) + "/"
                        + p.getData().get(Calendar.YEAR);
                resultado.add(aux);//adiciona imovel no ArrayList lita
            }
        }

        String result = "";
        for (String s : resultado) {
            result += s;
        }

        taResultado.setText(result);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbMesFinal = new javax.swing.JComboBox<>();
        cbAnoFinal = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btProcurar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbDiaInicial = new javax.swing.JComboBox<>();
        cbImoveis = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbMesInicial = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        taResultado = new javax.swing.JTextArea();
        cbAnoInicial = new javax.swing.JComboBox<>();
        cbDiaFinal = new javax.swing.JComboBox<>();

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

        jLabel5.setText("Data Inicial");

        jLabel6.setText("Data Final");

        btProcurar.setText("Procurar");
        btProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcurarActionPerformed(evt);
            }
        });

        jLabel7.setText("Escolha uma data para gerar o relatório:");

        cbDiaInicial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDiaInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDiaInicialActionPerformed(evt);
            }
        });

        cbImoveis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbImoveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbImoveisActionPerformed(evt);
            }
        });

        jLabel8.setText("Escolha o codigo do Imovel desejado");

        cbMesInicial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMesInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMesInicialActionPerformed(evt);
            }
        });

        taResultado.setColumns(20);
        taResultado.setRows(5);
        jScrollPane2.setViewportView(taResultado);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cbDiaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbMesInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbAnoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cbDiaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbMesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbAnoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(cbImoveis, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btProcurar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDiaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMesInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAnoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDiaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAnoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbImoveis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbMesFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMesFinalActionPerformed
        ajustaDatas(cbDiaFinal, cbMesFinal);
    }//GEN-LAST:event_cbMesFinalActionPerformed

    private void cbAnoFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAnoFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAnoFinalActionPerformed

    private void btProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcurarActionPerformed
        buscaPorEventos();
    }//GEN-LAST:event_btProcurarActionPerformed

    private void cbDiaInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDiaInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDiaInicialActionPerformed

    private void cbImoveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbImoveisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbImoveisActionPerformed

    private void cbMesInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMesInicialActionPerformed
        ajustaDatas(cbDiaInicial, cbMesInicial);
    }//GEN-LAST:event_cbMesInicialActionPerformed

    private void cbAnoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAnoInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAnoInicialActionPerformed

    private void cbDiaFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDiaFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDiaFinalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btProcurar;
    private javax.swing.JComboBox<String> cbAnoFinal;
    private javax.swing.JComboBox<String> cbAnoInicial;
    private javax.swing.JComboBox<String> cbDiaFinal;
    private javax.swing.JComboBox<String> cbDiaInicial;
    private javax.swing.JComboBox<String> cbImoveis;
    private javax.swing.JComboBox<String> cbMesFinal;
    private javax.swing.JComboBox<String> cbMesInicial;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taResultado;
    // End of variables declaration//GEN-END:variables
}
