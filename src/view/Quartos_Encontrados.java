/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Conversões.Data_p_Mysql;
import ds.desktop.notify.DesktopNotify;
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
public class Quartos_Encontrados extends javax.swing.JInternalFrame {
Nova_Reserva nova_reserva;
Double dataini,datafim;
static String datainiString,datafimString;
/**
     * Creates new form Clientes_Encontrados
     */
    public Quartos_Encontrados() {
        initComponents();
        initCustom();
    }

    private void initCustom(){
        SetaLargura_Jtable();
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
                Logger.getLogger(Quartos_Encontrados.class.getName()).log(Level.SEVERE, null, ex);
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
        QuartoDAO quartodao = new QuartoDAO();     
        //FOR DE PESQUISA NO BANCO CONTENDO DESCRICAO DO QUARTO
        for(Quarto quarto: quartodao.readNotInHosp()){
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

        painelTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblPeriodoFim = new javax.swing.JLabel();
        lbla = new javax.swing.JLabel();
        lblPeriodoIni = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuartos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnSelecionar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setTitle("Clientes Encontrados");

        painelTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTitulo.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lblTitulo.setText("Quartos Disponíveis");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.gray), "Período Escolhido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Light", 0, 12))); // NOI18N

        lblPeriodoFim.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N

        lbla.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lbla.setText("a");

        lblPeriodoIni.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblPeriodoIni, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPeriodoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPeriodoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbla)
                        .addComponent(lblPeriodoIni, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelTituloLayout = new javax.swing.GroupLayout(painelTitulo);
        painelTitulo.setLayout(painelTituloLayout);
        painelTituloLayout.setHorizontalGroup(
            painelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        painelTituloLayout.setVerticalGroup(
            painelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTituloLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTituloLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblQuartos.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        tblQuartos.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        tblQuartos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num. Ap.", "Descrição", "Andar", "Val. Diária"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQuartos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblQuartos.setMaximumSize(new java.awt.Dimension(100, 0));
        tblQuartos.setMinimumSize(new java.awt.Dimension(100, 0));
        jScrollPane1.setViewportView(tblQuartos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSelecionar.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        btnSelecionar.setText("Selecionar");
        btnSelecionar.setOpaque(false);
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setOpaque(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSelecionar)
                .addGap(5, 5, 5)
                .addComponent(btnCancelar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        int linha_selecionada = tblQuartos.getSelectedRow();
        int coluna = 0;
        
        if(linha_selecionada>-1){
            int id = (int) tblQuartos.getValueAt(linha_selecionada,coluna);
            this.dispose();
            nova_reserva.retornaQuarto(id);
        }else{
             DesktopNotify.showDesktopMessage("Atenção!", "É necessário selecionar um quarto para continuar!",DesktopNotify.ERROR,5000L);
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Quartos_Encontrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quartos_Encontrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quartos_Encontrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quartos_Encontrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quartos_Encontrados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    static javax.swing.JLabel lblPeriodoFim;
    static javax.swing.JLabel lblPeriodoIni;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lbla;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JTable tblQuartos;
    // End of variables declaration//GEN-END:variables
}
