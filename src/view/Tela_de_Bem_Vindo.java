/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Web_Service_CEP.WebServiceCep;
import ds.desktop.notify.DesktopNotify;
import javax.swing.JOptionPane;
import model.dao.BemVindoDAO;
import model.dao.QuartoDAO;
import model.pojo.BemVindo;
import model.pojo.Quarto;

/**
 *
 * @author Usuario
 */
public class Tela_de_Bem_Vindo extends javax.swing.JFrame {
int var = 0;
    /**
     * Creates new form BemVind
     */
    public Tela_de_Bem_Vindo() {
        initComponents();
    }
    
    public void buscaCep() {
        WebServiceCep webServiceCep = WebServiceCep.searchCep(jftxtCep.getText());
        //A ferramenta de busca ignora qualquer caracter que n?o seja n?mero.

        //caso a busca ocorra bem, imprime os resultados.
            if (webServiceCep.wasSuccessful()) {
                txtEndereco.setText(webServiceCep.getLogradouroFull());
                txtCidade.setText(webServiceCep.getCidade());
                txtBairro.setText(webServiceCep.getBairro());
                txtEstado.setText(webServiceCep.getUf());
                txtNumero.requestFocus();
            } else {
                //JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());

                //JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            }
        }

    public boolean verificaDados(){
        boolean retorno = false;
        String mascara_cnpj = "  .   .   /    -  ";
        String mascara_telefone_fixo = "(  )    -    ";
        String mascara_telefone_celular = "(  )     -    ";
        String mascara_cep = "  .   -   ";
        
        if(txtNomeFantasia.getText().equals("")){
            //JOptionPane.showMessageDialog(null, "O Campo Nome Fantasia não pode ficar em branco!");
            DesktopNotify.showDesktopMessage("Atenção!", "O Campo Nome Fantasia não pode ficar em branco!",DesktopNotify.ERROR,5000L);
            txtNomeFantasia.requestFocus();
        }
            else if(txtRazaoSocial.getText().equals("")){
            //JOptionPane.showMessageDialog(null, "O Campo Razão Social não pode ficar em branco!");
            DesktopNotify.showDesktopMessage("Atenção!", "O Campo Razão Social não pode ficar em branco!",DesktopNotify.ERROR,5000L);
            txtRazaoSocial.requestFocus();
            }   
                else if(jftxtCnpj.getText().equals(mascara_cnpj)){
                    //JOptionPane.showMessageDialog(null, "O Campo CNPJ não pode ficar em branco!");
                    DesktopNotify.showDesktopMessage("Atenção!", "O Campo CNPJ não pode ficar em branco!",DesktopNotify.ERROR,5000L);
                    jftxtCnpj.requestFocus();
                }
                    else if(jftxtTelFixo.getText().equals(mascara_telefone_fixo)){
                        //JOptionPane.showMessageDialog(null, "O Campo Telefone Fixo não pode ficar em branco!");
                        DesktopNotify.showDesktopMessage("Atenção!", "O Campo Telefone Fixo não pode ficar em branco!",DesktopNotify.ERROR,5000L);
                        jftxtTelFixo.requestFocus();
                    }
                        else if(jftxtCep.getText().equals(mascara_cep)){
                            //JOptionPane.showMessageDialog(null, "O Campo CEP não pode ficar em branco!");
                            DesktopNotify.showDesktopMessage("Atenção!", "O Campo CEP não pode ficar em branco!",DesktopNotify.ERROR,5000L);
                            jftxtCep.requestFocus();
                        }
                            else if(txtEndereco.getText().equals("")){
                                //JOptionPane.showMessageDialog(null, "O Campo Endereço não pode ficar em branco!");
                                DesktopNotify.showDesktopMessage("Atenção!", "O Campo Endereço não pode ficar em branco!",DesktopNotify.ERROR,5000L);
                                txtEndereco.requestFocus();
                            }
                                else if(txtNumero.getText().equals("")){
                                    //JOptionPane.showMessageDialog(null, "O Campo Número não pode ficar em branco!");
                                    DesktopNotify.showDesktopMessage("Atenção!", "O Campo Número não pode ficar em branco!",DesktopNotify.ERROR,5000L);
                                    txtNumero.requestFocus();
                                }
                                    else if(txtBairro.getText().equals("")){
                                        //JOptionPane.showMessageDialog(null, "O Campo Cidade não pode ficar em branco!");
                                        DesktopNotify.showDesktopMessage("Atenção!", "O Campo Bairro não pode ficar em branco!",DesktopNotify.ERROR,5000L);
                                        txtBairro.requestFocus();
                                    }
                                    else if(txtCidade.getText().equals("")){
                                        //JOptionPane.showMessageDialog(null, "O Campo Cidade não pode ficar em branco!");
                                            DesktopNotify.showDesktopMessage("Atenção!", "O Campo Cidade não pode ficar em branco!",DesktopNotify.ERROR,5000L);
                                        txtBairro.requestFocus();
                                    }
                                    else if(txtEstado.getText().equals("")){
                                        //JOptionPane.showMessageDialog(null, "O Campo Estado não pode ficar em branco!");
                                        DesktopNotify.showDesktopMessage("Atenção!", "O Campo Estado não pode ficar em branco!",DesktopNotify.ERROR,5000L);
                                        txtEstado.requestFocus();
                                    }
                                else if(txtNumAndar.getText().equals("")){
                                    //JOptionPane.showMessageDialog(null, "O Campo Nº de andares não pode ficar em branco!");
                                    DesktopNotify.showDesktopMessage("Atenção!", "O Campo Nº de andares não pode ficar em branco!",DesktopNotify.ERROR,5000L);
                                    txtNumAndar.requestFocus();
                                }
                            else if(txtNumApAndar.getText().equals("Selecione")){
                                //JOptionPane.showMessageDialog(null, "É necessário selecionar um valor na combobox Nº de Apartamentos Andar!");
                                DesktopNotify.showDesktopMessage("Atenção!", "O Campo Nº de apartamentos por andar não pode ficar em branco!",DesktopNotify.ERROR,5000L);
                                txtNumApAndar.requestFocus();
                            }
                        else if(txtNome.getText().equals("")){
                            //JOptionPane.showMessageDialog(null, "O Campo Nome não pode ficar em branco!");
                            DesktopNotify.showDesktopMessage("Atenção!", "O Campo Nome não pode ficar em branco!",DesktopNotify.ERROR,5000L);
                            txtNome.requestFocus();
                        }
                    else if(txtUsuario.getText().equals("")){
                        //JOptionPane.showMessageDialog(null, "O Campo Usuário não pode ficar em branco!");
                        DesktopNotify.showDesktopMessage("Atenção!", "O Campo Usuário não pode ficar em branco!",DesktopNotify.ERROR,5000L);
                        txtUsuario.requestFocus();
                    }
                else if(jfpwdSenha.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "O Campo Senha não pode ficar em branco!");
                    DesktopNotify.showDesktopMessage("Atenção!", "O Campo Senha não pode ficar em branco!",DesktopNotify.ERROR,5000L);
                    jfpwdSenha.requestFocus();
                }
        else{
           retorno = true;                                                     
        }
        return retorno;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelBemVindo = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        painelDados = new javax.swing.JPanel();
        lblTituloDadosEmpresa = new javax.swing.JLabel();
        lblNomeFantasia = new javax.swing.JLabel();
        lblRazaoSocial = new javax.swing.JLabel();
        lblCnpj = new javax.swing.JLabel();
        txtNomeFantasia = new javax.swing.JTextField();
        txtRazaoSocial = new javax.swing.JTextField();
        lblTelFixo = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lblCep = new javax.swing.JLabel();
        ckbxConcordo = new javax.swing.JCheckBox();
        btnComplete = new java.awt.Button();
        jSeparator1 = new javax.swing.JSeparator();
        lblTelCel = new javax.swing.JLabel();
        txtContato = new javax.swing.JTextField();
        lblContato = new javax.swing.JLabel();
        lblNumAndares = new javax.swing.JLabel();
        lblNumApAndar = new javax.swing.JLabel();
        jftxtCnpj = new javax.swing.JFormattedTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        lblTituloDadosAcesso = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jfpwdSenha = new javax.swing.JPasswordField();
        jftxtTelFixo = new javax.swing.JFormattedTextField();
        jftxtTelCel = new javax.swing.JFormattedTextField();
        jftxtCep = new javax.swing.JFormattedTextField();
        btnAvancar = new java.awt.Button();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtNumAndar = new javax.swing.JTextField();
        txtNumApAndar = new javax.swing.JTextField();
        lblBairro = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bem Vindo ao Diretoria Hotéis - V1.0");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        painelBemVindo.setBackground(new java.awt.Color(49, 58, 115));

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Olá, ");

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Seja Bem-Vindo ao Diretoria Hotéis");

        jLabel14.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Primeiro cadastre ao lado os");

        jLabel15.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Bom Vamos lá...");

        jLabel16.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("dados do seu hotel...");

        jLabel17.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("... e clique em avançar!");

        javax.swing.GroupLayout painelBemVindoLayout = new javax.swing.GroupLayout(painelBemVindo);
        painelBemVindo.setLayout(painelBemVindoLayout);
        painelBemVindoLayout.setHorizontalGroup(
            painelBemVindoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBemVindoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelBemVindoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelBemVindoLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16))
                    .addGroup(painelBemVindoLayout.createSequentialGroup()
                        .addGroup(painelBemVindoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelBemVindoLayout.setVerticalGroup(
            painelBemVindoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBemVindoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelBemVindoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel14))
                .addGap(215, 215, 215)
                .addComponent(jLabel17)
                .addGap(85, 85, 85))
        );

        painelDados.setBackground(new java.awt.Color(255, 255, 255));

        lblTituloDadosEmpresa.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblTituloDadosEmpresa.setText("Dados da Empresa");

        lblNomeFantasia.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblNomeFantasia.setText("Nome Fantasia *");

        lblRazaoSocial.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblRazaoSocial.setText("Razão Social *");

        lblCnpj.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblCnpj.setText("CNPJ *");

        txtNomeFantasia.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        txtNomeFantasia.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        txtRazaoSocial.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        txtRazaoSocial.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        lblTelFixo.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblTelFixo.setText("Telefone Fixo *");

        txtEndereco.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        txtEndereco.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        lblEndereco.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblEndereco.setText("Endereço *");

        txtEstado.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        txtEstado.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        lblEstado.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblEstado.setText("Estado");

        lblCidade.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblCidade.setText("Cidade");

        txtBairro.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        txtBairro.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        lblCep.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblCep.setText("CEP *");

        ckbxConcordo.setSelected(true);
        ckbxConcordo.setText("Eu concordo com os termos de contrato do Diretoria Hotéis!");

        btnComplete.setActionCommand("btnCancelar");
        btnComplete.setBackground(new java.awt.Color(204, 204, 204));
        btnComplete.setForeground(new java.awt.Color(51, 51, 51));
        btnComplete.setLabel("Cancelar");
        btnComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });

        lblTelCel.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblTelCel.setText("Telefone Celular");

        txtContato.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        txtContato.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        lblContato.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblContato.setText("Contato");

        lblNumAndares.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblNumAndares.setText("Nº de Andares");

        lblNumApAndar.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblNumApAndar.setText("Nº de Apartamentos por andar");

        jftxtCnpj.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        try {
            jftxtCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftxtCnpj.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        jftxtCnpj.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N

        lblTituloDadosAcesso.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblTituloDadosAcesso.setText("Dados de Acesso - Administração");

        lblUsuario.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblUsuario.setText("Usuário");

        lblSenha.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblSenha.setText("Senha");

        txtUsuario.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        txtUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        jfpwdSenha.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jfpwdSenha.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        jfpwdSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfpwdSenhaActionPerformed(evt);
            }
        });

        jftxtTelFixo.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        try {
            jftxtTelFixo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftxtTelFixo.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        jftxtTelFixo.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N

        jftxtTelCel.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        try {
            jftxtTelCel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftxtTelCel.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        jftxtTelCel.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N

        jftxtCep.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        try {
            jftxtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftxtCep.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        jftxtCep.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jftxtCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftxtCepFocusLost(evt);
            }
        });

        btnAvancar.setActionCommand("btnAvancar");
        btnAvancar.setBackground(new java.awt.Color(36, 193, 93));
        btnAvancar.setForeground(new java.awt.Color(255, 255, 255));
        btnAvancar.setLabel("Avançar");
        btnAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancarActionPerformed(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblNome.setText("Nome ");

        txtNome.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        txtNome.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        lblNumero.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblNumero.setText("Número *");

        txtNumero.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        txtNumero.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        txtNumAndar.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        txtNumAndar.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        txtNumApAndar.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        txtNumApAndar.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        lblBairro.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblBairro.setText("Bairro");

        txtCidade.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        txtCidade.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addComponent(jSeparator1)
            .addComponent(jSeparator4)
            .addComponent(jSeparator5)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblTituloDadosEmpresa)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(lblNumAndares)
                        .addGap(165, 165, 165)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumApAndar)
                            .addComponent(txtNumApAndar, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTelFixo)
                                    .addComponent(jftxtTelFixo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jftxtTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTelCel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtContato)
                                    .addGroup(painelDadosLayout.createSequentialGroup()
                                        .addComponent(lblContato)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelDadosLayout.createSequentialGroup()
                                        .addComponent(txtNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(painelDadosLayout.createSequentialGroup()
                                        .addComponent(lblNomeFantasia)
                                        .addGap(88, 88, 88)
                                        .addComponent(lblRazaoSocial)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCnpj)
                                    .addComponent(jftxtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(btnComplete, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsuario)
                                    .addGroup(painelDadosLayout.createSequentialGroup()
                                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTituloDadosAcesso)
                                            .addComponent(lblNome)
                                            .addComponent(lblUsuario))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSenha)
                                    .addComponent(jfpwdSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelDadosLayout.createSequentialGroup()
                                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblCep)
                                            .addComponent(jftxtCep, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                            .addComponent(lblBairro)
                                            .addComponent(txtBairro))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(painelDadosLayout.createSequentialGroup()
                                                .addComponent(txtCidade)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(painelDadosLayout.createSequentialGroup()
                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblEndereco)
                                                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(painelDadosLayout.createSequentialGroup()
                                                .addComponent(lblCidade)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblEstado)
                                                .addGap(84, 84, 84))))
                                    .addComponent(ckbxConcordo)
                                    .addComponent(txtNumAndar, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNumero)
                                    .addComponent(txtNumero)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))))
                        .addContainerGap())))
        );

        painelDadosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jftxtTelCel, jftxtTelFixo});

        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTituloDadosEmpresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeFantasia)
                    .addComponent(lblRazaoSocial)
                    .addComponent(lblCnpj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jftxtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelFixo)
                    .addComponent(lblTelCel)
                    .addComponent(lblContato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jftxtTelFixo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftxtTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEndereco)
                            .addComponent(lblNumero))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jftxtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                        .addComponent(lblCep)
                        .addGap(35, 35, 35)))
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(lblBairro)
                        .addGap(35, 35, 35))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstado)
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(lblCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addGap(7, 7, 7)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumAndares)
                    .addComponent(lblNumApAndar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumAndar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumApAndar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTituloDadosAcesso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(lblSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jfpwdSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ckbxConcordo)
                .addGap(9, 9, 9)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnComplete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelBemVindo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelBemVindo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCompleteActionPerformed

    private void jfpwdSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfpwdSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jfpwdSenhaActionPerformed

    private void btnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarActionPerformed
        BemVindo bemvindo = new BemVindo();
        BemVindoDAO bemvindodao = new BemVindoDAO();
        QuartoDAO quartodao = new QuartoDAO();
        
        if(verificaDados()==true){
            bemvindo.setHotel_nome_fantasia(txtNomeFantasia.getText());
            bemvindo.setHotel_razao_social(txtRazaoSocial.getText());
            bemvindo.setHotel_cnpj(jftxtCnpj.getText());
            bemvindo.setHotel_tel_fixo(jftxtTelFixo.getText());
            bemvindo.setHotel_tel_cel(jftxtTelCel.getText());
            bemvindo.setHotel_contato(txtContato.getText());
            bemvindo.setHotel_cep(jftxtCep.getText());
            bemvindo.setHotel_endereco(txtEndereco.getText());
            bemvindo.setHotel_numero(Integer.parseInt(txtNumero.getText()));
            bemvindo.setHotel_bairro(txtBairro.getText());
            bemvindo.setHotel_cidade(txtBairro.getText());
            bemvindo.setHotel_estado(txtEstado.getText());
            bemvindo.setHotel_num_andares(Integer.parseInt(txtNumAndar.getText()));
            bemvindo.setHotel_num_ap_andar(Integer.parseInt(txtNumApAndar.getText()));
            bemvindo.setHotel_acesso_adm_nome(txtNome.getText());
            bemvindo.setHotel_acesso_adm_login(txtUsuario.getText());
            bemvindo.setHotel_acesso_adm_senha(jfpwdSenha.getText());
            bemvindo.setHotel_status(1);
        
            bemvindodao.create(bemvindo);
            quartodao.createAutomatic(bemvindo.getHotel_num_andares(),bemvindo.getHotel_num_ap_andar());
            

            Tela_de_Login tela_login = new Tela_de_Login();
            tela_login.setVisible(true);
            this.dispose();
        }
        
        
    }//GEN-LAST:event_btnAvancarActionPerformed

    private void jftxtCepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftxtCepFocusLost
        buscaCep();
    }//GEN-LAST:event_jftxtCepFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jftxtCep.setText("");
        txtEndereco.setText("");
        txtNumero.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtEstado.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_de_Bem_Vindo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_de_Bem_Vindo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_de_Bem_Vindo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_de_Bem_Vindo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_de_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnAvancar;
    private java.awt.Button btnComplete;
    private javax.swing.JCheckBox ckbxConcordo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JPasswordField jfpwdSenha;
    private javax.swing.JFormattedTextField jftxtCep;
    private javax.swing.JFormattedTextField jftxtCnpj;
    private javax.swing.JFormattedTextField jftxtTelCel;
    private javax.swing.JFormattedTextField jftxtTelFixo;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblContato;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeFantasia;
    private javax.swing.JLabel lblNumAndares;
    private javax.swing.JLabel lblNumApAndar;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblRazaoSocial;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTelCel;
    private javax.swing.JLabel lblTelFixo;
    private javax.swing.JLabel lblTituloDadosAcesso;
    private javax.swing.JLabel lblTituloDadosEmpresa;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel painelBemVindo;
    private javax.swing.JPanel painelDados;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtContato;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeFantasia;
    private javax.swing.JTextField txtNumAndar;
    private javax.swing.JTextField txtNumApAndar;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRazaoSocial;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
