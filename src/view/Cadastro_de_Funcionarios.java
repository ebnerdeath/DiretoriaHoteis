/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Web_Service_CEP.WebServiceCep;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.dao.EstadoDAO;
import model.dao.FuncionarioDAO;
import model.pojo.Estado;
import model.pojo.Funcionario;

/**
 *
 * @author Usuario
 */
public class Cadastro_de_Funcionarios extends javax.swing.JInternalFrame {
    int flag = -1;
    /**
     * Creates new form Cadastro_de_Funcionarios
     */
    public Cadastro_de_Funcionarios() {
        initComponents();
        seta_Botoes();
        readJTable();
        readComboUf();
        desativa_Campos();
    }

    
    //MÉTODO QUE LIMPA TODOS OS CAMPOS DA TELA DE CADASTRO
    public void Limpa_Campos(){
        txtNome.setText("");
        jftxtData_Nasc.setText("");
        jftxtRg.setText("");
        jftxtCpf.setText("");
        ComboSexo.setSelectedItem("Selecione");
        jftxtTelFixo.setText("");
        jftxtTelCel.setText("");
        txtEmail.setText("");
        jftxtCep.setText("");
        txtEndereco.setText("");
        txtNumero.setText("");
        ComboUF.setSelectedItem("Selecione");
        txtCidade.setText("");
        txtBairro.setText("");
        txtComplemento.setText("");
        txtLogin.setText("");
        jptxtSenha.setText("");
    }
    
    //MÉTODO PARA HABILITAR OU DESABILITAR BOTÕES
    public void seta_Botoes(){
        btnSalvar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnCancelar.setEnabled(false);
    }
    
    //MÉTODO QUE POPULA A TABELA DE CLIENTES COM OS DADOS DO BANCO DE DADOS
    public void readJTable(){
        DefaultTableModel modelo = (DefaultTableModel) tblFunc.getModel();
        modelo.setNumRows(0);
        FuncionarioDAO funcionariodao = new FuncionarioDAO();
        
        for(Funcionario funcionario: funcionariodao.read()){
            modelo.addRow(new Object[]{
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getTel_fixo(),
                funcionario.getTel_cel()
            });
        }
        SetaLargura_Jtable();
    }
    
    //MÉTODO QUE SETA A LARGURA DOS CAMPOS DA TABELA DOS CLIENTES
    public void SetaLargura_Jtable(){
        tblFunc.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblFunc.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblFunc.getColumnModel().getColumn(1).setPreferredWidth(304);
        tblFunc.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblFunc.getColumnModel().getColumn(3).setPreferredWidth(110);
    }
    
    //MÉTODO QUE POPULA A COMBOBOX COM OS DADOS DO BANCO DE DADOS
    public void readComboUf(){
        EstadoDAO estadodao = new EstadoDAO();
        for(Estado estado: estadodao.read()){         
            ComboUF.addItem(estado.getUf());
        };
    }
    
    //MÉTODO QUE VERIFICA O CEP E SE TIVER NO WEBSERVICE PREENCHE OS CAMPOS
    public void Verifica_Cep(){
        if(txtEndereco.requestFocus(true)){
             WebServiceCep webservicecep = WebServiceCep.searchCep(jftxtCep.getText());
            
             if(webservicecep.wasSuccessful()){
                ComboUF.setSelectedItem(webservicecep.getUf());
                txtCidade.setText(webservicecep.getCidade());
                txtEndereco.setText(webservicecep.getLogradouro());
            }else{

            }
        }
    }
    
    //MÉTODO QUE DESATIVA TODOS OS CAMPOS DA TELA
    public void desativa_Campos(){
        txtNome.setEnabled(false);
        jftxtData_Nasc.setEnabled(false);
        jftxtRg.setEnabled(false);
        jftxtCpf.setEnabled(false);
        ComboSexo.setEnabled(false);
        jftxtTelFixo.setEnabled(false);
        jftxtTelCel.setEnabled(false);
        txtEmail.setEnabled(false);
        jftxtCep.setEnabled(false);
        txtEndereco.setEnabled(false);
        txtNumero.setEnabled(false);
        ComboUF.setEnabled(false);
        txtCidade.setEnabled(false);
        txtBairro.setEnabled(false);
        txtComplemento.setEnabled(false);
        txtLogin.setEnabled(false);
        jptxtSenha.setEnabled(false);
    }
    
    //MÉTODO QUE ATIVA TODOS OS CAMPOS DA TELA
    public void ativa_Campos(){
        txtNome.setEnabled(true);
        jftxtData_Nasc.setEnabled(true);
        jftxtRg.setEnabled(true);
        jftxtCpf.setEnabled(true);
        ComboSexo.setEnabled(true);
        jftxtTelFixo.setEnabled(true);
        jftxtTelCel.setEnabled(true);
        txtEmail.setEnabled(true);
        jftxtCep.setEnabled(true);
        txtEndereco.setEnabled(true);
        txtNumero.setEnabled(true);
        ComboUF.setEnabled(true);
        txtCidade.setEnabled(true);
        txtBairro.setEnabled(true);
        txtComplemento.setEnabled(true);
        txtLogin.setEnabled(true);
        jptxtSenha.setEnabled(true);
    }
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
        pnlGuias = new javax.swing.JTabbedPane();
        painelDadosp = new javax.swing.JPanel();
        btnAvançar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblData_Nasc = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblRg = new javax.swing.JLabel();
        jftxtData_Nasc = new javax.swing.JFormattedTextField();
        jftxtCpf = new javax.swing.JFormattedTextField();
        jftxtRg = new javax.swing.JFormattedTextField();
        ComboSexo = new javax.swing.JComboBox<>();
        lblSexo = new javax.swing.JLabel();
        lblTelFixo = new javax.swing.JLabel();
        jftxtTelFixo = new javax.swing.JFormattedTextField();
        lblTelCel = new javax.swing.JLabel();
        jftxtTelCel = new javax.swing.JFormattedTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        painelDadosr = new javax.swing.JPanel();
        btnVoltar = new javax.swing.JButton();
        lblCep = new javax.swing.JLabel();
        jftxtCep = new javax.swing.JFormattedTextField();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        lblUF = new javax.swing.JLabel();
        ComboUF = new javax.swing.JComboBox<>();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lblComplemento = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        btnAvançar1 = new javax.swing.JButton();
        lblBairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        painelDadospr = new javax.swing.JPanel();
        btnVoltar2 = new javax.swing.JButton();
        txtLogin = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        jptxtSenha = new javax.swing.JPasswordField();
        painelTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFunc = new javax.swing.JTable();
        lblFuncionariosCadastrados = new javax.swing.JLabel();
        painelBotoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro de Funcionários");

        painelTitulo.setBackground(new java.awt.Color(204, 204, 204));
        painelTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelTitulo.setOpaque(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lblTitulo.setText("Cadastro de Funcionários");

        javax.swing.GroupLayout painelTituloLayout = new javax.swing.GroupLayout(painelTitulo);
        painelTitulo.setLayout(painelTituloLayout);
        painelTituloLayout.setHorizontalGroup(
            painelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTituloLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelTituloLayout.setVerticalGroup(
            painelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTituloLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblTitulo))
        );

        pnlGuias.setBackground(new java.awt.Color(204, 204, 204));
        pnlGuias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlGuias.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N

        painelDadosp.setBackground(new java.awt.Color(204, 204, 204));
        painelDadosp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelDadosp.setOpaque(false);
        painelDadosp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAvançar.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        btnAvançar.setText("Avançar");
        btnAvançar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvançarActionPerformed(evt);
            }
        });
        painelDadosp.add(btnAvançar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, -1, 30));

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblNome.setText("Nome");
        painelDadosp.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        txtNome.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        txtNome.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        painelDadosp.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 520, 30));

        lblData_Nasc.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblData_Nasc.setText("Nascimento");
        painelDadosp.add(lblData_Nasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        lblCpf.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblCpf.setText("Cpf: ");
        painelDadosp.add(lblCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        lblRg.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblRg.setText("Rg:  ");
        painelDadosp.add(lblRg, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        jftxtData_Nasc.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        try {
            jftxtData_Nasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**/**/****")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftxtData_Nasc.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        jftxtData_Nasc.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        painelDadosp.add(jftxtData_Nasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 80, 30));

        jftxtCpf.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        try {
            jftxtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftxtCpf.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        jftxtCpf.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        painelDadosp.add(jftxtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 100, 30));

        jftxtRg.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        try {
            jftxtRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**.***.***-**")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftxtRg.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        jftxtRg.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        painelDadosp.add(jftxtRg, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 100, 30));

        ComboSexo.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        ComboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Masculino", "Feminino" }));
        ComboSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboSexoActionPerformed(evt);
            }
        });
        painelDadosp.add(ComboSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 100, 30));

        lblSexo.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblSexo.setText("Sexo: ");
        painelDadosp.add(lblSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        lblTelFixo.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblTelFixo.setText("Tel. Fixo:  ");
        painelDadosp.add(lblTelFixo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jftxtTelFixo.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        try {
            jftxtTelFixo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(**)****-****")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftxtTelFixo.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        jftxtTelFixo.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        painelDadosp.add(jftxtTelFixo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 100, 30));

        lblTelCel.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblTelCel.setText("Tel. Celular:  ");
        painelDadosp.add(lblTelCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));

        jftxtTelCel.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        try {
            jftxtTelCel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(**)*****-****")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftxtTelCel.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        jftxtTelCel.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        painelDadosp.add(jftxtTelCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 110, 30));

        lblEmail.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblEmail.setText("Email: ");
        painelDadosp.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        txtEmail.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        painelDadosp.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 420, 30));

        pnlGuias.addTab("Dados Pessoais", painelDadosp);

        painelDadosr.setBackground(new java.awt.Color(204, 204, 204));
        painelDadosr.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelDadosr.setOpaque(false);
        painelDadosr.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVoltar.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.setMaximumSize(new java.awt.Dimension(79, 23));
        btnVoltar.setMinimumSize(new java.awt.Dimension(79, 23));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        painelDadosr.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 80, 30));

        lblCep.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblCep.setText("Cep");
        painelDadosr.add(lblCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jftxtCep.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        try {
            jftxtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("*****-***")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftxtCep.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        jftxtCep.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        jftxtCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftxtCepFocusLost(evt);
            }
        });
        jftxtCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftxtCepActionPerformed(evt);
            }
        });
        jftxtCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jftxtCepKeyPressed(evt);
            }
        });
        painelDadosr.add(jftxtCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, 30));

        lblEndereco.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblEndereco.setText("Endereço");
        painelDadosr.add(lblEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        txtEndereco.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        txtEndereco.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });
        painelDadosr.add(txtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 410, 30));

        lblNumero.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblNumero.setText("Numero");
        painelDadosr.add(lblNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtNumero.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        txtNumero.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        painelDadosr.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 80, 30));

        lblUF.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblUF.setText("UF");
        painelDadosr.add(lblUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        ComboUF.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        ComboUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        ComboUF.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        painelDadosr.add(ComboUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 90, 30));

        lblCidade.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblCidade.setText("Cidade");
        painelDadosr.add(lblCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, -1));

        txtCidade.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        txtCidade.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });
        painelDadosr.add(txtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 290, 30));

        lblComplemento.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblComplemento.setText("Complemento");
        painelDadosr.add(lblComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        txtComplemento.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        txtComplemento.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        txtComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComplementoActionPerformed(evt);
            }
        });
        painelDadosr.add(txtComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 330, 30));

        btnAvançar1.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        btnAvançar1.setText("Avançar");
        btnAvançar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvançar1ActionPerformed(evt);
            }
        });
        painelDadosr.add(btnAvançar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, -1, 30));

        lblBairro.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblBairro.setText("Bairro");
        painelDadosr.add(lblBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txtBairro.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        txtBairro.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        txtBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBairroActionPerformed(evt);
            }
        });
        painelDadosr.add(txtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 160, 30));

        pnlGuias.addTab("Dados Residenciais", painelDadosr);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelDadospr.setBackground(new java.awt.Color(204, 204, 204));
        painelDadospr.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelDadospr.setOpaque(false);
        painelDadospr.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVoltar2.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        btnVoltar2.setText("Voltar");
        btnVoltar2.setMaximumSize(new java.awt.Dimension(79, 23));
        btnVoltar2.setMinimumSize(new java.awt.Dimension(79, 23));
        btnVoltar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar2ActionPerformed(evt);
            }
        });
        painelDadospr.add(btnVoltar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 70, 30));

        txtLogin.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        txtLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });
        painelDadospr.add(txtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 210, 30));

        lblLogin.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblLogin.setText("Login: ");
        painelDadospr.add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        lblSenha.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblSenha.setText("Senha: ");
        painelDadospr.add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        jptxtSenha.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        jptxtSenha.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        painelDadospr.add(jptxtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 210, 30));

        jPanel1.add(painelDadospr, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 250));

        pnlGuias.addTab("Dados de Acesso", jPanel1);

        painelTabela.setBackground(new java.awt.Color(204, 204, 204));
        painelTabela.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelTabela.setOpaque(false);

        tblFunc.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        tblFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Telefone Fixo", "Telefone Celular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFunc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFuncMouseClicked(evt);
            }
        });
        tblFunc.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tblFuncInputMethodTextChanged(evt);
            }
        });
        tblFunc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblFuncKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblFunc);

        lblFuncionariosCadastrados.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        lblFuncionariosCadastrados.setText("Funcionários Cadastrados");

        javax.swing.GroupLayout painelTabelaLayout = new javax.swing.GroupLayout(painelTabela);
        painelTabela.setLayout(painelTabelaLayout);
        painelTabelaLayout.setHorizontalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblFuncionariosCadastrados))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        painelTabelaLayout.setVerticalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lblFuncionariosCadastrados)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        painelBotoes.setBackground(new java.awt.Color(204, 204, 204));
        painelBotoes.setOpaque(false);

        btnNovo.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelBotoesLayout = new javax.swing.GroupLayout(painelBotoes);
        painelBotoes.setLayout(painelBotoesLayout);
        painelBotoesLayout.setHorizontalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btnNovo)
                .addGap(5, 5, 5)
                .addComponent(btnExcluir)
                .addGap(5, 5, 5)
                .addComponent(btnSalvar)
                .addGap(5, 5, 5)
                .addComponent(btnCancelar)
                .addGap(5, 5, 5)
                .addComponent(btnSair))
        );
        painelBotoesLayout.setVerticalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovo)
                    .addComponent(btnExcluir)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar)
                    .addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlGuias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(painelTabela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlGuias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblFuncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncMouseClicked
        if(tblFunc.getSelectedRow() != -1){
            Limpa_Campos();
            FuncionarioDAO funcionariodao = new FuncionarioDAO();

            flag = 2;

            ativa_Campos();

            int id = (int) tblFunc.getValueAt(tblFunc.getSelectedRow(),0);

            for(Funcionario funcionario: funcionariodao.read_Method(id)){

                txtNome.setText(funcionario.getNome());
                jftxtData_Nasc.setText(funcionario.getData_nasc());
                jftxtRg.setText(funcionario.getRg());
                jftxtCpf.setText(funcionario.getCpf());
                ComboSexo.setSelectedItem(String.valueOf(funcionario.getSexo()));
                jftxtTelFixo.setText(funcionario.getTel_fixo());
                jftxtTelCel.setText(funcionario.getTel_cel());
                txtEmail.setText(funcionario.getEmail());
                jftxtCep.setText(funcionario.getCep());
                txtEndereco.setText(funcionario.getEndereco());
                txtNumero.setText(String.valueOf(funcionario.getNumero()));
                ComboUF.setSelectedItem(String.valueOf(funcionario.getUf()));
                txtCidade.setText(funcionario.getCidade());
                txtBairro.setText(funcionario.getBairro());
                txtComplemento.setText(funcionario.getComplemento());
                txtLogin.setText(funcionario.getLogin());
                jptxtSenha.setText(funcionario.getSenha());

            }
            btnNovo.setEnabled(false);
            btnSalvar.setEnabled(true);
            btnExcluir.setEnabled(true);
            btnCancelar.setEnabled(true);

        }

    }//GEN-LAST:event_tblFuncMouseClicked

    private void tblFuncInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tblFuncInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tblFuncInputMethodTextChanged

    private void tblFuncKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblFuncKeyPressed
        if(tblFunc.getSelectedRow() != -1){
            Limpa_Campos();

            FuncionarioDAO funcionariodao = new FuncionarioDAO();
            flag = 2;

            ativa_Campos();

            int id = (int) tblFunc.getValueAt(tblFunc.getSelectedRow(),0);

            for(Funcionario funcionario: funcionariodao.read_Method(id)){

                txtNome.setText(funcionario.getNome());
                jftxtData_Nasc.setText(funcionario.getData_nasc());
                jftxtRg.setText(funcionario.getRg());
                jftxtCpf.setText(funcionario.getCpf());
                ComboSexo.setSelectedItem(String.valueOf(funcionario.getSexo()));
                jftxtTelFixo.setText(funcionario.getTel_fixo());
                jftxtTelCel.setText(funcionario.getTel_cel());
                txtEmail.setText(funcionario.getEmail());
                jftxtCep.setText(funcionario.getCep());
                txtEndereco.setText(funcionario.getEndereco());
                txtNumero.setText(String.valueOf(funcionario.getNumero()));
                ComboUF.setSelectedItem(String.valueOf(funcionario.getUf()));
                txtCidade.setText(funcionario.getCidade());
                txtBairro.setText(funcionario.getBairro());
                txtComplemento.setText(funcionario.getComplemento());
                txtLogin.setText(funcionario.getLogin());
                jptxtSenha.setText(funcionario.getSenha());

            }
            btnNovo.setEnabled(false);
            btnSalvar.setEnabled(true);
            btnExcluir.setEnabled(true);
            btnCancelar.setEnabled(true);

        }
    }//GEN-LAST:event_tblFuncKeyPressed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        Funcionario funcionario = new Funcionario();
        FuncionarioDAO funcionariodao = new FuncionarioDAO();

        ativa_Campos();
        txtNome.requestFocus();
        flag = 1;
        btnSalvar.setEnabled(true);
        btnExcluir.setEnabled(false);
        tblFunc.setVisible(false);
        btnCancelar.setEnabled(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if((tblFunc.getSelectedRow() != -1)){
            Funcionario funcionario = new Funcionario();
            FuncionarioDAO funcionariodao = new FuncionarioDAO();

            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?",getTitle(),+ JOptionPane.YES_NO_OPTION);

            if(resposta==JOptionPane.YES_OPTION){
                funcionario.setId((int)tblFunc.getValueAt(tblFunc.getSelectedRow(),0));

                funcionariodao.delete(funcionario);
                readJTable();
                Limpa_Campos();
                tblFunc.clearSelection();
                btnExcluir.setEnabled(false);
                btnSalvar.setEnabled(false);
                btnCancelar.setEnabled(false);
            }else{
                tblFunc.clearSelection();
                btnExcluir.setEnabled(false);
                btnSalvar.setEnabled(false);
                btnCancelar.setEnabled(false);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Selecione um funcionário!");
        }
        btnNovo.setEnabled(true);
        desativa_Campos();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if(flag == 2){//SE NA BANDEIRA ESTIVER MARCADO 2 SIGNIFICA QUE O USUÁRIO ESTÁ ALTERANDO DADOS DOS FUNCIONÁRIOS
            if((tblFunc.getSelectedRow() != -1)){
                Funcionario funcionario = new Funcionario();
                FuncionarioDAO funcionariodao = new FuncionarioDAO();

                //VALIDA SE O NOME É ESPAÇO EM BRANCO SE FOR ELE DA A MENSAGEM QUE O CAMPO NOME PRECISA SER PREENCHIDO
                if(txtNome.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "O Campo nome precisa ser preenchido!");

                    if(pnlGuias.getSelectedIndex()==1||pnlGuias.getSelectedIndex()==2){
                        pnlGuias.setSelectedIndex(0);
                        txtNome.requestFocus();
                    }else{
                        txtNome.requestFocus();
                    }
                }
                else if(txtLogin.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"O campo Login necessita ser preenchido!");

                    if(pnlGuias.getSelectedIndex()==0||pnlGuias.getSelectedIndex()==1){
                        pnlGuias.setSelectedIndex(2);
                        txtLogin.requestFocus();
                    }else{
                        txtLogin.requestFocus();
                    }
                }
                else if(jptxtSenha.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"O campo Senha necessita ser preenchido!");

                    if(pnlGuias.getSelectedIndex()==0||pnlGuias.getSelectedIndex()==1){
                        pnlGuias.setSelectedIndex(2);
                        jptxtSenha.requestFocus();
                    }else{
                        jptxtSenha.requestFocus();
                    }
                }
                else{
                    funcionario.setNome(txtNome.getText());
                    funcionario.setData_nasc(jftxtData_Nasc.getText());
                    funcionario.setCpf(jftxtCpf.getText());
                    funcionario.setRg(jftxtRg.getText());

                    //VALIDANDO SE O SEXO É MASCULINO OU FEMININO - SE NAO FOR NENHUM DOS DOIS ELE GRAVA NO BANCO UM ESPAÇO NULO
                    if((ComboSexo.getSelectedIndex()==0)){
                        funcionario.setSexo("");
                    }else{
                        funcionario.setSexo(String.valueOf(ComboSexo.getSelectedItem()));
                    }

                    funcionario.setTel_fixo(jftxtTelFixo.getText());
                    funcionario.setTel_cel(jftxtTelCel.getText());
                    funcionario.setEmail(txtEmail.getText());
                    funcionario.setCep(jftxtCep.getText());
                    funcionario.setEndereco(txtEndereco.getText());

                    //VALIDANDO SE O NÚMERO FOR NULL ELE GRAVA NO BANCO NUMERO 0
                    if(txtNumero.getText().equals("")){
                        txtNumero.setText("0");
                    }else{
                        funcionario.setNumero(Integer.parseInt(txtNumero.getText()));
                    }

                    //VALIDANDO QUAL É O ESTADO - SE NAO FOR NENHUM DOS ESTADOS ELE GRAVA NO BANCO UM ESPAÇO NULO
                    if((ComboUF.getSelectedIndex()==0)){
                        funcionario.setUf("");
                    }else{
                        funcionario.setUf(String.valueOf(ComboUF.getSelectedItem()));
                    }

                    funcionario.setCidade(txtCidade.getText());
                    funcionario.setBairro(txtBairro.getText());
                    funcionario.setComplemento(txtComplemento.getText());
                    funcionario.setLogin(txtLogin.getText());
                    funcionario.setSenha(jptxtSenha.getText());
                    funcionario.setId((int)tblFunc.getValueAt(tblFunc.getSelectedRow(),0));

                    funcionariodao.update(funcionario); //CHAMA O MÉTODO QUE FAZ O UPDATE NO BANCO DE DADOS
                    readJTable();
                    Limpa_Campos();
                    btnNovo.setEnabled(true);
                    btnSalvar.setEnabled(false);
                    btnExcluir.setEnabled(false);
                    btnCancelar.setEnabled(false);
                    tblFunc.clearSelection();//RETIRA A SELEÇÃO DA TABELA
                    desativa_Campos();//DESATIVA OS CAMPOS DA TABELA
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Selecione um funcionário!");
            }
        }else{//SE NA BANDEIRA ESTIVER MARCADO 1 SIGNIFICA QUE O USUÁRIO ESTÁ INSERINDO NO BANCO DE DADOS UM NOVO FUNCIONÁRIO
            Funcionario funcionario = new Funcionario();
            FuncionarioDAO funcionariodao = new FuncionarioDAO();
            //VALIDA SE O NOME É ESPAÇO EM BRANCO SE FOR ELE DA A MENSAGEM QUE O CAMPO NOME PRECISA SER PREENCHIDO
            if(txtNome.getText().equals("")){
                JOptionPane.showMessageDialog(null, "O Campo nome precisa ser preenchido!");

                if(pnlGuias.getSelectedIndex()==1||pnlGuias.getSelectedIndex()==2){
                    pnlGuias.setSelectedIndex(0);
                    txtNome.requestFocus();
                }else{
                    txtNome.requestFocus();
                }
            }
            else if(txtLogin.getText().equals("")){
                JOptionPane.showMessageDialog(null,"O campo Login necessita ser preenchido!");

                if(pnlGuias.getSelectedIndex()==0||pnlGuias.getSelectedIndex()==1){
                    pnlGuias.setSelectedIndex(2);
                    txtLogin.requestFocus();
                }else{
                    txtLogin.requestFocus();
                }
            }
            else if(jptxtSenha.getText().equals("")){
                JOptionPane.showMessageDialog(null,"O campo Senha necessita ser preenchido!");

                if(pnlGuias.getSelectedIndex()==0||pnlGuias.getSelectedIndex()==1){
                    pnlGuias.setSelectedIndex(2);
                    jptxtSenha.requestFocus();
                }else{
                    jptxtSenha.requestFocus();
                }
            }
            else{
                funcionario.setNome(txtNome.getText());
                funcionario.setData_nasc(jftxtData_Nasc.getText());
                funcionario.setRg(jftxtRg.getText());
                funcionario.setCpf(jftxtCpf.getText());

                //VALIDANDO SE O SEXO É MASCULINO OU FEMININO - SE NAO FOR NENHUM DOS DOIS ELE GRAVA NO BANCO UM ESPAÇO NULO
                if((ComboSexo.getSelectedIndex()==0)){
                    funcionario.setSexo("");
                }else{
                    funcionario.setSexo(String.valueOf(ComboSexo.getSelectedItem()));
                }

                funcionario.setTel_fixo(jftxtTelFixo.getText());
                funcionario.setTel_cel(jftxtTelCel.getText());
                funcionario.setEmail(txtEmail.getText());
                funcionario.setCep(jftxtCep.getText());
                funcionario.setEndereco(txtEndereco.getText());

                //VALIDANDO SE O NÚMERO FOR NULL ELE GRAVA NO BANCO NUMERO 0
                if(txtNumero.getText().equals("")){
                    txtNumero.setText("0");
                }else{
                    funcionario.setNumero(Integer.parseInt(txtNumero.getText()));
                }

                //VALIDANDO QUAL É O ESTADO - SE NAO FOR NENHUM DOS ESTADOS ELE GRAVA NO BANCO UM ESPAÇO NULO
                if((ComboUF.getSelectedIndex()==0)){
                    funcionario.setUf("");
                }else{
                    funcionario.setUf(String.valueOf(ComboUF.getSelectedItem()));
                }

                funcionario.setCidade(txtCidade.getText());
                funcionario.setBairro(txtBairro.getText());
                funcionario.setComplemento(txtComplemento.getText());
                funcionario.setLogin(txtLogin.getText());
                funcionario.setSenha(jptxtSenha.getText());

                funcionariodao.create(funcionario);//CHAMA O MÉTODO QUE FAZ A INSERÇÃO NO BANCO DE DADOS
                Limpa_Campos();
                readJTable();
                btnNovo.setEnabled(true);
                btnSalvar.setEnabled(false);
                btnExcluir.setEnabled(false);
                btnCancelar.setEnabled(false);
                tblFunc.setVisible(true);
                tblFunc.clearSelection();//RETIRA A SELEÇÃO DA TABELA
                desativa_Campos();//DESATIVA OS CAMPOS DA TABELA
            }
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Limpa_Campos();
        desativa_Campos();
        btnExcluir.setEnabled(true);
        flag = -1;
        tblFunc.setVisible(true);
        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnCancelar.setEnabled(false);
        tblFunc.clearSelection();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void txtBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairroActionPerformed

    private void btnAvançar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvançar1ActionPerformed
        pnlGuias.setSelectedIndex(2);
    }//GEN-LAST:event_btnAvançar1ActionPerformed

    private void txtComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComplementoActionPerformed

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void jftxtCepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftxtCepKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            WebServiceCep webservicecep = WebServiceCep.searchCep(jftxtCep.getText());
            if(webservicecep.wasSuccessful()){
                ComboUF.setSelectedItem(webservicecep.getUf());
                txtCidade.setText(webservicecep.getCidade());
                txtEndereco.setText(webservicecep.getLogradouro());
                txtNumero.requestFocus();
            }else{
                txtEndereco.requestFocus();
            }
        }
    }//GEN-LAST:event_jftxtCepKeyPressed

    private void jftxtCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftxtCepActionPerformed

    }//GEN-LAST:event_jftxtCepActionPerformed

    private void jftxtCepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftxtCepFocusLost

        WebServiceCep webservicecep = WebServiceCep.searchCep(jftxtCep.getText());
        if(webservicecep.wasSuccessful()){
            ComboUF.setSelectedItem(webservicecep.getUf());
            txtCidade.setText(webservicecep.getCidade());
            txtEndereco.setText(webservicecep.getLogradouro());
            txtNumero.requestFocus();
        }else{
            txtEndereco.requestFocus();
        }
    }//GEN-LAST:event_jftxtCepFocusLost

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        pnlGuias.setSelectedIndex(0);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void ComboSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboSexoActionPerformed

    private void btnAvançarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvançarActionPerformed
        pnlGuias.setSelectedIndex(1);
    }//GEN-LAST:event_btnAvançarActionPerformed

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginActionPerformed

    private void btnVoltar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar2ActionPerformed
        pnlGuias.setSelectedIndex(1);
    }//GEN-LAST:event_btnVoltar2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboSexo;
    private javax.swing.JComboBox<String> ComboUF;
    private javax.swing.JButton btnAvançar;
    private javax.swing.JButton btnAvançar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnVoltar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField jftxtCep;
    private javax.swing.JFormattedTextField jftxtCpf;
    private javax.swing.JFormattedTextField jftxtData_Nasc;
    private javax.swing.JFormattedTextField jftxtRg;
    private javax.swing.JFormattedTextField jftxtTelCel;
    private javax.swing.JFormattedTextField jftxtTelFixo;
    private javax.swing.JPasswordField jptxtSenha;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblData_Nasc;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblFuncionariosCadastrados;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblRg;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelCel;
    private javax.swing.JLabel lblTelFixo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUF;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelDadosp;
    private javax.swing.JPanel painelDadospr;
    private javax.swing.JPanel painelDadosr;
    private javax.swing.JPanel painelTabela;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JTabbedPane pnlGuias;
    private javax.swing.JTable tblFunc;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
