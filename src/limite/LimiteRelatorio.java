/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limite;

import controle.ControlePrincipal;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import limite.relatorios.formEventosImovel;
import limite.relatorios.formImoveisVendedor;
import limite.relatorios.formValorPorCorretorPeriodo;
import limite.relatorios.formValorTotalPeriodo;
import limite.relatorios.formVendasPeriodo;
import limite.relatorios.formVisitasCorretorPeriodo;

/**
 *
 * @author hyper
 */
public class LimiteRelatorio {
    
    JTabbedPane tabPanel = new JTabbedPane();
    
    public void showRelatorio(JPanel panel) {
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setSize(510, 500);
        frame.setVisible(true);
    }
 
}
