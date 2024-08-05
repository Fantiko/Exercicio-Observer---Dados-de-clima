/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;

import dado.DadoClima;
import Presenter.EstacaoClimatica;
import Observer.Observer;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author kaios
 */
public class TelaDadosTempo extends javax.swing.JInternalFrame implements Observer {
    EstacaoClimatica estacao;
    /**
     * Creates new form TelaDadosTempo
     */

    public TelaDadosTempo(EstacaoClimatica estacao) {
        this.estacao = estacao;
        initComponents();
        setVisible(true);
    }

    @Override
    public void atualizar(List<DadoClima> dadoClimaList) {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dataCampo = new javax.swing.JTextField();
        temperaturaCampo = new javax.swing.JTextField();
        umidadeCampo = new javax.swing.JTextField();
        pressaoCampo = new javax.swing.JTextField();
        Incluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setResizable(true);
        setTitle("Dados do Tempo");

        jLabel1.setText("Data:");

        jLabel2.setText("Temperatura:");

        jLabel3.setText("Umidade:");

        jLabel4.setText("Pressão");

        dataCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataCampoActionPerformed(evt);
            }
        });

        Incluir.setText("Incluir");
        Incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IncluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dataCampo)
                    .addComponent(temperaturaCampo)
                    .addComponent(umidadeCampo)
                    .addComponent(pressaoCampo, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Incluir)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(temperaturaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(umidadeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pressaoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Incluir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dataCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataCampoActionPerformed

    private void IncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IncluirActionPerformed
        // TODO add your handling code here:
        if(dataCampo.getText().isEmpty() || temperaturaCampo.getText().isEmpty() || umidadeCampo.getText().isEmpty() || pressaoCampo.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Preencha todas informações");
        }else{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(dataCampo.getText(), formatter);
            DadoClima dados = new DadoClima(Float.parseFloat(temperaturaCampo.getText()), Float.parseFloat(umidadeCampo.getText()), Float.parseFloat(pressaoCampo.getText()), date);

            estacao.adicionarDado(dados);

            temperaturaCampo.setText("");
            umidadeCampo.setText("");
            pressaoCampo.setText("");
            dataCampo.setText("");

            
        }
    }//GEN-LAST:event_IncluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Incluir;
    private javax.swing.JTextField dataCampo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField pressaoCampo;
    private javax.swing.JTextField temperaturaCampo;
    private javax.swing.JTextField umidadeCampo;


    // End of variables declaration//GEN-END:variables




}
