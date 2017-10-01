/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Conversões.Data_p_Mysql;
import java.text.ParseException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.dao.HospedagemDAO;
import model.dao.QuartoDAO;
import model.pojo.Hospedagem;
import model.pojo.Quarto;

/**
 *
 * @author Usuario
 */
public class Hospedagens_Encontradas extends javax.swing.JInternalFrame {
Nova_Reserva nova_reserva;
Double dataini,datafim;
static String datainiString,datafimString;
/**
     * Creates new form Clientes_Encontrados
     */
    public Hospedagens_Encontradas() {
        initComponents();
        initCustom();
    }

    private void initCustom(){
        SetaLargura_Jtable();
    }
    
    //MÉTODO QUE ATUALIZA A TABELA DE ACORDO COM A CHECKBOX QUE ESTÁ SELECIONADA PARA MOSTRAR AS HOSPEDAGENS CANCELADAS, FINALIZADAS OU EM ANDAMENTO
    public void atualizaTabela(){
        DefaultTableModel modelo = (DefaultTableModel) tblQuartos.getModel();
        modelo.setNumRows(0);
        HospedagemDAO hospedagemdao = new HospedagemDAO();     
        
        if(chbHospAnd.isSelected()){
            //FOR DE PESQUISA NO BANCO CONTENDO DESCRICAO DO QUARTO
            for(Hospedagem hospedagem: hospedagemdao.ReadHospEmAndamento()){
                modelo.addRow(new Object[]{
                    hospedagem.getId_quarto(),
                    hospedagem.getQuarto_descricao(),
                    hospedagem.getQuarto_andar(),
                    hospedagem.getPeriodo_ini(),
                    hospedagem.getPeriodo_fim(),
                    hospedagem.getQuarto_val_diaria()
                });   
            SetaLargura_Jtable();
            Centraliza_Dados();
            }
        }else if(chbHospCanc.isSelected()){
            //FOR DE PESQUISA NO BANCO CONTENDO DESCRICAO DO QUARTO
            for(Hospedagem hospedagem: hospedagemdao.ReadHospCanceladas()){
                modelo.addRow(new Object[]{
                    hospedagem.getId_quarto(),
                    hospedagem.getQuarto_descricao(),
                    hospedagem.getQuarto_andar(),
                    hospedagem.getPeriodo_ini(),
                    hospedagem.getPeriodo_fim(),
                    hospedagem.getQuarto_val_diaria()
                });   
            SetaLargura_Jtable();
            Centraliza_Dados();
            }
        }else if(chbHospFin.isSelected()){
            //FOR DE PESQUISA NO BANCO CONTENDO DESCRICAO DO QUARTO
            for(Hospedagem hospedagem: hospedagemdao.ReadHospFinalizadas()){
                modelo.addRow(new Object[]{
                    hospedagem.getId_quarto(),
                    hospedagem.getQuarto_descricao(),
                    hospedagem.getQuarto_andar(),
                    hospedagem.getPeriodo_ini(),
                    hospedagem.getPeriodo_fim(),
                    hospedagem.getQuarto_val_diaria()
                });   
            SetaLargura_Jtable();
            Centraliza_Dados();
            }
        }
    }
    
    //RECEBE O OBJETO DO FRAME TELA INICIAL PARA CONSEGUIR RETORNAR O VALOR DA ID DO CLIENTE SELECIONADO
    public void enviaFrame(Nova_Reserva nova_reserva){
        this.nova_reserva = nova_reserva;
    }
    
    //METODO QUE SETA A LARGURA DOS CAMPOS DA JTABLE    
    public void SetaLargura_Jtable(){                       
        tblQuartos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        //COLUNA1
        tblQuartos.getColumnModel().getColumn(0).setMinWidth(100);
        tblQuartos.getColumnModel().getColumn(0).setMaxWidth(100);
       
        //COLUNA2
        tblQuartos.getColumnModel().getColumn(1).setMinWidth(400);
        tblQuartos.getColumnModel().getColumn(1).setMaxWidth(400);

        Centraliza_Dados();
    }
    
    public void pesquisaQuartosLivres(String data_ini_cliente,String data_fim_cliente){
        HospedagemDAO hospedagemdao = new HospedagemDAO();
        Data_p_Mysql converte_data_myqsl = new Data_p_Mysql();
        QuartoDAO quartodao = new QuartoDAO();
        Calendar data_ini_banco;
        Calendar data_fim_banco;
        Calendar dataini;
        Calendar datafim;
        boolean validafor = false;
        
        DefaultTableModel modelo = (DefaultTableModel) tblQuartos.getModel();
        modelo.setNumRows(0);
        
        for(Hospedagem hospedagem:hospedagemdao.ReadHospInnerQuartos()){
            try {
                data_ini_banco = converte_data_myqsl.StringMysqlParaCalendar(hospedagem.getPeriodo_ini());//PRIMEIRO PEGAMOS A STRING DO BANCO DE DADOS E CONVERTEMOS PARA CALENDAR DO JAVA NO FORMATO dd-MM-yyy
                data_fim_banco = converte_data_myqsl.StringMysqlParaCalendar(hospedagem.getPeriodo_fim());
                
                dataini = converte_data_myqsl.StringCalendarioParaCalendar(data_ini_cliente);
                datafim = converte_data_myqsl.StringCalendarioParaCalendar(data_fim_cliente);

                
                if(data_ini_banco.getTime().after(dataini.getTime()) && data_fim_banco.getTime().before(datafim.getTime())){
                    //System.out.println("\nPrimeiro IF | QUARTO: "+hospedagem.getId_quarto()+" OCUPADO!");
                }else if(data_ini_banco.getTime().before(dataini.getTime()) && dataini.getTime().before(data_fim_banco.getTime()) && data_fim_banco.getTime().before(datafim.getTime())){
                    //System.out.println("\nSegundo IF | QUARTO: "+hospedagem.getId_quarto()+" OCUPADO!");
                }else if(data_ini_banco.getTime().before(dataini.getTime()) && data_fim_banco.getTime().after(datafim.getTime())){
                    //System.out.println("\nTerceiro IF | QUARTO: "+hospedagem.getId_quarto()+" OCUPADO!");
                }else if(data_ini_banco.getTime().after(dataini.getTime())&& datafim.getTime().before(data_fim_banco.getTime()) && datafim.getTime().after(data_ini_banco.getTime())){
                    //System.out.println("\nQuarto IF | QUARTO: "+hospedagem.getId_quarto()+" OCUPADO!");
                }else if(data_ini_banco.getTime().equals(dataini.getTime())||data_fim_banco.getTime().equals(datafim.getTime())){// SE O PERÍDO INCIAL OU FINAL FOR IGUALO AO PERÍODO DO BANCO O QUARTO NÃO É VÁLIDO
                    //System.out.println("\nQuinto IF | QUARTO: "+hospedagem.getId_quarto()+" OCUPADO!");
                }else if(data_ini_banco.getTime().equals(datafim.getTime())||data_fim_banco.getTime().equals(dataini.getTime())){// SE O PERÍDO INCIAL OU FINAL FOR IGUALO AO PERÍODO DO BANCO O QUARTO NÃO É VÁLIDO
                    //System.out.println("\nSexto IF | QUARTO: "+hospedagem.getId_quarto()+" OCUPADO!");
                }
                else{//SE NÃO O SISTEMA ADICIONA O QUARTO NA TABELA
                    modelo.addRow(new Object[]{
                    hospedagem.getId_quarto(),
                    hospedagem.getQuarto_descricao(),
                    hospedagem.getQuarto_andar(),
                    hospedagem.getQuarto_val_diaria()
                    });
                }
            } catch (ParseException ex) {
                Logger.getLogger(Hospedagens_Encontradas.class.getName()).log(Level.SEVERE, null, ex);
            }
            validafor = true;//SETA O VALOR TRUE NA VARIÁVEL DIZENDO QUE TEM HOSPEDAGENS CRIADAS
        }
        
        for(Quarto quarto:quartodao.readNotInHosp()){
            modelo.addRow(new Object[]{
                    quarto.getId_quarto(),
                    quarto.getDescricao(),
                    quarto.getAndar(),
                    quarto.getVal_diaria()
            });
        }
        
        if(validafor == false){//SE NÃO TEM HOSPEDAGENS EFETUADAS MOSTRA TODOS OS QUARTOS LIVRES
            readJTable();
        }
    }
    
    //MÉTODO QUE POPULA A TABELA DE QUARTOS
    public void readJTable(){
        DefaultTableModel modelo = (DefaultTableModel) tblQuartos.getModel();
        modelo.setNumRows(0);
        HospedagemDAO hospedagemdao = new HospedagemDAO();     
        //FOR DE PESQUISA NO BANCO CONTENDO DESCRICAO DO QUARTO
        for(Hospedagem hospedagem: hospedagemdao.ReadHospInnerQuartos()){
                modelo.addRow(new Object[]{
                    hospedagem.getId_quarto(),
                    hospedagem.getQuarto_descricao(),
                    hospedagem.getQuarto_andar(),
                    hospedagem.getPeriodo_ini(),
                    hospedagem.getPeriodo_fim(),
                    hospedagem.getQuarto_val_diaria()
                });   
            SetaLargura_Jtable();
            Centraliza_Dados();
        }
    }    
    
      
    //MÉTODO QUE POPULA A TABELA DE CLIENTES DE ACORDO COM A DESCRIÇÃO
    /*public void readJTableDescricao(String descricao_quarto){
        DefaultTableModel modelo = (DefaultTableModel) tblQuartos.getModel();
        modelo.setNumRows(0);
        QuartoDAO quartodao = new QuartoDAO();
        //FOR DE PESQUISA NO BANCO CONTENDO NOME DO QUARTO
        for(Quarto quarto: quartodao.read_Descricao(descricao_quarto)){
                modelo.addRow(new Object[]{
                quarto.getId_quarto(),
                quarto.getDescricao(),
                quarto.getAndar(),
                quarto.getVal_diaria(),
                });   
            SetaLargura_Jtable();
            Centraliza_Dados();
        }
    }
    */
    
    //MÉTODO QUE CENTRALIZA OU NÃO OS DADOS NA TABELA
    public void Centraliza_Dados(){
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        
        tblQuartos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tblQuartos.getColumnModel().getColumn(1).setCellRenderer(esquerda);
        tblQuartos.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        tblQuartos.getColumnModel().getColumn(3).setCellRenderer(centralizado);  
    }
    
   /* //MÉTODO QUE AJUSTA LARGURA DA TABELA
    public void SetaLargura_Jtable(){
        tblQuartos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblQuartos.getColumnModel().getColumn(0).setPreferredWidth(55);
        tblQuartos.getColumnModel().getColumn(1).setPreferredWidth(383);
        tblQuartos.getColumnModel().getColumn(2).setPreferredWidth(120);
        tblQuartos.getColumnModel().getColumn(3).setPreferredWidth(120);
    }*/
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoChbHosp = new javax.swing.ButtonGroup();
        painelTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        chbHospAnd = new javax.swing.JCheckBox();
        chbHospCanc = new javax.swing.JCheckBox();
        chbHospFin = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuartos = new javax.swing.JTable();
        lblPesquisa = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnSair = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setTitle("Hospedagens Encontradas");

        painelTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTitulo.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lblTitulo.setText("Hospedagens");

        GrupoChbHosp.add(chbHospAnd);
        chbHospAnd.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        chbHospAnd.setText("Hospedagens Em Andamento");
        chbHospAnd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chbHospAndMouseClicked(evt);
            }
        });

        GrupoChbHosp.add(chbHospCanc);
        chbHospCanc.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        chbHospCanc.setText("Hospedagens Canceladas");
        chbHospCanc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chbHospCancMouseClicked(evt);
            }
        });
        chbHospCanc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                chbHospCancKeyPressed(evt);
            }
        });

        GrupoChbHosp.add(chbHospFin);
        chbHospFin.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        chbHospFin.setText("Hospedagens Finalizadas");
        chbHospFin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chbHospFinMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelTituloLayout = new javax.swing.GroupLayout(painelTitulo);
        painelTitulo.setLayout(painelTituloLayout);
        painelTituloLayout.setHorizontalGroup(
            painelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(95, 95, 95)
                .addComponent(chbHospAnd)
                .addGap(18, 18, 18)
                .addComponent(chbHospCanc)
                .addGap(18, 18, 18)
                .addComponent(chbHospFin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelTituloLayout.setVerticalGroup(
            painelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTituloLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(painelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(chbHospAnd)
                    .addComponent(chbHospCanc)
                    .addComponent(chbHospFin))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblQuartos.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        tblQuartos.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        tblQuartos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num. Ap.", "Descrição", "Andar", "Periodo Inicial", "Periodo Final", "Val. Diária", "Valor Total", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQuartos.setToolTipText("");
        tblQuartos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblQuartos.setMaximumSize(new java.awt.Dimension(100, 0));
        tblQuartos.setMinimumSize(new java.awt.Dimension(100, 0));
        jScrollPane1.setViewportView(tblQuartos);

        lblPesquisa.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblPesquisa.setText("Pesquisa: ");

        txtPesquisa.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisa)
                    .addComponent(lblPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSair.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        btnSair.setText("Sair");
        btnSair.setOpaque(false);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Accept.png"))); // NOI18N
        jButton2.setText("Finalizar Hospedagem");

        jButton1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Delete.png"))); // NOI18N
        jButton1.setText("Cancelar Hospedagem");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void chbHospAndMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chbHospAndMouseClicked
        atualizaTabela();
    }//GEN-LAST:event_chbHospAndMouseClicked

    private void chbHospCancKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chbHospCancKeyPressed
        atualizaTabela();
    }//GEN-LAST:event_chbHospCancKeyPressed

    private void chbHospFinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chbHospFinMouseClicked
        atualizaTabela();
    }//GEN-LAST:event_chbHospFinMouseClicked

    private void chbHospCancMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chbHospCancMouseClicked
        atualizaTabela();
    }//GEN-LAST:event_chbHospCancMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Hospedagens_Encontradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hospedagens_Encontradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hospedagens_Encontradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hospedagens_Encontradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hospedagens_Encontradas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoChbHosp;
    private javax.swing.JButton btnSair;
    private javax.swing.JCheckBox chbHospAnd;
    private javax.swing.JCheckBox chbHospCanc;
    private javax.swing.JCheckBox chbHospFin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JTable tblQuartos;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
