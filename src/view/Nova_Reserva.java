/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Conversões.Data_p_Mysql;
import Util.Data;
import ds.desktop.notify.DesktopNotify;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import model.dao.ClienteDAO;
import model.dao.HospedagemDAO;
import model.dao.QuartoDAO;
import model.pojo.Cliente;
import model.pojo.Hospedagem;
import model.pojo.Quarto;

/**
 *
 * @author Usuario
 */
public class Nova_Reserva extends javax.swing.JInternalFrame {
int id_cliente, id_quarto;
ArrayList<Hospedagem> lista_de_hospedagens = new ArrayList<Hospedagem>();
    /**
     * Creates new form Nova_Reserva
     */
    public Nova_Reserva() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblDadosHospede = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        lblCliente = new javax.swing.JLabel();
        lblQuarto = new javax.swing.JLabel();
        txtQuarto = new javax.swing.JTextField();
        lblCliente1 = new javax.swing.JLabel();
        jftxtCpf = new javax.swing.JFormattedTextField();
        txtCalendIni = new com.toedter.calendar.JDateChooser();
        txtCalendFim = new com.toedter.calendar.JDateChooser();
        lblPeriodoIni = new javax.swing.JLabel();
        lblPeriodoFim = new javax.swing.JLabel();
        lblPeriodoEstadia = new javax.swing.JLabel();
        lblSelecQuarto = new javax.swing.JLabel();
        btnBuscarQuartos = new javax.swing.JButton();
        btnIncluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        painelTitulo.setBackground(new java.awt.Color(204, 204, 204));
        painelTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelTitulo.setOpaque(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lblTitulo.setText("Nova Reserva");

        javax.swing.GroupLayout painelTituloLayout = new javax.swing.GroupLayout(painelTitulo);
        painelTitulo.setLayout(painelTituloLayout);
        painelTituloLayout.setHorizontalGroup(
            painelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTituloLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblTitulo)
                .addContainerGap(530, Short.MAX_VALUE))
        );
        painelTituloLayout.setVerticalGroup(
            painelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTituloLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblDadosHospede.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        lblDadosHospede.setText("Dados do Hóspede");

        txtCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClienteKeyPressed(evt);
            }
        });

        lblCliente.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblCliente.setText("Cliente: ");

        lblQuarto.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblQuarto.setText("Quarto: ");

        txtQuarto.setToolTipText("Aperte o Enter para buscar os quartos livres!");
        txtQuarto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQuartoKeyPressed(evt);
            }
        });

        lblCliente1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblCliente1.setText("Cpf: ");

        try {
            jftxtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("***.***.***-**")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftxtCpf.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        jftxtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftxtCpfActionPerformed(evt);
            }
        });
        jftxtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jftxtCpfKeyPressed(evt);
            }
        });

        lblPeriodoIni.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblPeriodoIni.setText("Período Inicial: ");

        lblPeriodoFim.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblPeriodoFim.setText("Período Final: ");

        lblPeriodoEstadia.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblPeriodoEstadia.setText("Período de Estadia: ");

        lblSelecQuarto.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblSelecQuarto.setText("Seleção de Quarto: ");

        btnBuscarQuartos.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        btnBuscarQuartos.setText("Buscar Quartos");
        btnBuscarQuartos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarQuartosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblQuarto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuarto)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCliente1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jftxtCpf))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDadosHospede)
                                    .addComponent(lblPeriodoEstadia)
                                    .addComponent(lblSelecQuarto))
                                .addGap(0, 554, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPeriodoIni)
                        .addGap(5, 5, 5)
                        .addComponent(txtCalendIni, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(lblPeriodoFim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCalendFim, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarQuartos)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(lblDadosHospede)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblCliente))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCliente1)
                        .addComponent(jftxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(lblPeriodoEstadia)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCalendIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPeriodoIni)
                    .addComponent(txtCalendFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPeriodoFim)
                    .addComponent(btnBuscarQuartos))
                .addGap(16, 16, 16)
                .addComponent(lblSelecQuarto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuarto))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        btnIncluir.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIncluir)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //MÉTODO UTILIZADO PARA SETAR O NOME E CPF DO CLIENTE NOS CAMPOS DE ACORDO COM O CLIENTE SELECIONADO NA TELA DE CLIENTES ENCONTRADOS
    public void retornaCliente(int id_cliente){
        ClienteDAO clientedao = new ClienteDAO();
        this.id_cliente = id_cliente;
        for(Cliente cliente:clientedao.read()){        
            if(cliente.getId()==id_cliente){
                txtCliente.setText(cliente.getNome());
                jftxtCpf.setText(cliente.getCpf());
            }
        }
    }
    
    //MÉTODO UTILIZADO PARA SETAR O NOME E CPF DO CLIENTE NOS CAMPOS DE ACORDO COM O CLIENTE SELECIONADO NA TELA DE CLIENTES ENCONTRADOS
    public void retornaQuarto(int id_quarto){
        QuartoDAO quartodao = new QuartoDAO();
        this.id_quarto = id_quarto;
        for(Quarto quarto:quartodao.read()){        
            if(quarto.getId_quarto()==id_quarto){
                txtQuarto.setText(quarto.getDescricao());
            }
        }
    }
    
    private boolean validaPeriodos(){
        boolean retorno = false;
        Data_p_Mysql converte_data_mysql = new Data_p_Mysql();
        DateFormat df = DateFormat.getDateInstance();

        Data data = new Data();
        System.out.println(data.read());        
        
        try {
            
            
            if(txtCalendIni.getDate() != null && txtCalendFim.getDate() != null){
                String data_inicial = df.format(txtCalendIni.getDate());
                String data_final = df.format(txtCalendFim.getDate());
                Calendar dataini = converte_data_mysql.StringCalendarioParaCalendar(data_inicial);
                Calendar datafim = converte_data_mysql.StringCalendarioParaCalendar(data_final);
                retorno = true;
            }else{
                DesktopNotify.showDesktopMessage("Atenção!", "Os campos de Período Inicial e Período Final necessitam ser preenchidos!",DesktopNotify.ERROR,5000L);
        }
            
            
        } catch (Exception e) {
        }
        return retorno;
    }
    
    private boolean validaCliente(){
        boolean retorno = false;
        if(!txtCliente.getText().equals("")){
            retorno = true;
        }else{
            DesktopNotify.showDesktopMessage("Atenção!", "Os campos Cliente e Cpf necessitam ser preenchidos!",DesktopNotify.ERROR,5000L);
        }
        return retorno;
    }
    
    private void acaoBtnBuscarQuartos(){
        Quartos_Encontrados quartos_encontrados = new Quartos_Encontrados();
        DateFormat df = DateFormat.getDateInstance();
            
            if(validaPeriodos() == true && validaCliente() == true){
                String data_inicial = df.format(txtCalendIni.getDate());
                String data_final = df.format(txtCalendFim.getDate());

                //SETANDO O PERÍODO ESCOLHIDO PELO CLIENTE NA TELA DE QUARTOS ENCONTRADOS
                Quartos_Encontrados.lblPeriodoIni.setText(data_inicial);
                Quartos_Encontrados.lblPeriodoFim.setText(data_final);

                Tela_Inicial.dskPaneFundo.add(quartos_encontrados);
                quartos_encontrados.show();
                quartos_encontrados.pesquisaQuartosLivres(data_inicial, data_final);
                quartos_encontrados.enviaFrame(this);
                Tela_Inicial.centralizaForm(quartos_encontrados);
            } 
    }
    
    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        if(validaPeriodos()==true && validaCliente() == true){
        Hospedagem hospedagem = new Hospedagem();
        HospedagemDAO hospedagemdao = new HospedagemDAO();
        DateFormat df = DateFormat.getDateInstance();
        Data_p_Mysql data_para_mysql = new Data_p_Mysql();
        
        String data_inicial = df.format(txtCalendIni.getDate());
        String data_final = df.format(txtCalendFim.getDate());
        
        hospedagem.setId_cliente(id_cliente);
        hospedagem.setPeriodo_ini(data_para_mysql.Data_p_Mysql(data_inicial));
        hospedagem.setPeriodo_fim(data_para_mysql.Data_p_Mysql(data_final));
        hospedagem.setId_quarto(id_quarto);
        hospedagem.setId_status_hospedagem(2);
        
        if(validaCliente() == true && validaPeriodos() == true){
            hospedagemdao.create(hospedagem);
        }
        dispose();
        }
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER){
            Clientes_Encontrados clientes_encontrados = new Clientes_Encontrados();
            Tela_Inicial.dskPaneFundo.add(clientes_encontrados);
            clientes_encontrados.show();
            clientes_encontrados.readJTableCliNome(txtCliente.getText());
            clientes_encontrados.enviaFrame(this);
            Tela_Inicial.centralizaForm(clientes_encontrados);
        }
    }//GEN-LAST:event_txtClienteKeyPressed

    private void txtQuartoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuartoKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER){
            acaoBtnBuscarQuartos();
        }
    }//GEN-LAST:event_txtQuartoKeyPressed

    private void jftxtCpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftxtCpfKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER){
            Clientes_Encontrados clientes_encontrados = new Clientes_Encontrados();
            Tela_Inicial.dskPaneFundo.add(clientes_encontrados);
            clientes_encontrados.show();
            clientes_encontrados.readJTableCliCpf(jftxtCpf.getText());
            clientes_encontrados.enviaFrame(this);
            Tela_Inicial.centralizaForm(clientes_encontrados);
        }
    }//GEN-LAST:event_jftxtCpfKeyPressed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void jftxtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftxtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jftxtCpfActionPerformed

    private void btnBuscarQuartosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarQuartosActionPerformed
        acaoBtnBuscarQuartos();
    }//GEN-LAST:event_btnBuscarQuartosActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarQuartos;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField jftxtCpf;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCliente1;
    private javax.swing.JLabel lblDadosHospede;
    private javax.swing.JLabel lblPeriodoEstadia;
    private javax.swing.JLabel lblPeriodoFim;
    private javax.swing.JLabel lblPeriodoIni;
    private javax.swing.JLabel lblQuarto;
    private javax.swing.JLabel lblSelecQuarto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painelTitulo;
    private com.toedter.calendar.JDateChooser txtCalendFim;
    private com.toedter.calendar.JDateChooser txtCalendIni;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtQuarto;
    // End of variables declaration//GEN-END:variables
}
