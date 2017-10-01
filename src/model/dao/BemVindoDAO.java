/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.pojo.BemVindo;
import view.Tela_Inicial;

/**
 *
 * @author Usuario
 */
public class BemVindoDAO {
    
    //MÉTODO QUE CRIA UM NOVO CLIENTE NO BANCO DE DADOS
    public void create(BemVindo b){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO dados_hotel "
                    + "(hotel_nome_fantasia,hotel_razao_social,hotel_cnpj,hotel_tel_fixo,hotel_tel_celular,hotel_contato,hotel_cep,"
                    + "hotel_endereco,hotel_numero,hotel_bairro,hotel_cidade,hotel_estado,hotel_n_andares,hotel_n_ap_andar,hotel_acesso_adm_nome,"
                    + "hotel_acesso_adm_login,hotel_acesso_adm_senha,hotel_status)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            stmt.setString(1,b.getHotel_nome_fantasia());
            stmt.setString(2,b.getHotel_razao_social());
            stmt.setString(3,b.getHotel_cnpj());
            stmt.setString(4,b.getHotel_tel_fixo());
            stmt.setString(5,b.getHotel_tel_cel());
            stmt.setString(6,b.getHotel_contato());
            stmt.setString(7,b.getHotel_cep());
            stmt.setString(8,b.getHotel_endereco());
            stmt.setInt(9,b.getHotel_numero());
            stmt.setString(10,b.getHotel_bairro());
            stmt.setString(11,b.getHotel_cidade());
            stmt.setString(12,b.getHotel_estado());
            stmt.setInt(13,b.getHotel_num_andares());
            stmt.setInt(14,b.getHotel_num_ap_andar());
            stmt.setString(15,b.getHotel_acesso_adm_nome());
            stmt.setString(16,b.getHotel_acesso_adm_login());
            stmt.setString(17,b.getHotel_acesso_adm_senha());
            stmt.setInt(18,b.getHotel_status());
            
            stmt.executeUpdate();
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    //MÉTODO QUE LÊ O STATUS DO HOTEL NO BANCO DE DADOS
    public int readStatusHotel(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int status = -1;
        try {
            stmt = con.prepareStatement("SELECT * FROM dados_hotel ORDER BY id_dado_hotel ASC");
            rs = stmt.executeQuery();
            while(rs.next()){
                status = rs.getInt("hotel_status");
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return status;
    }
    
    //MÉTODO PARA VERIFICAR O LOGIN RETORNANDO TRUE OU FALSE
    public boolean read_Login(String usuario,String senha){
        BemVindo bemvindo = new BemVindo();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean retorno = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM dados_hotel");
            rs = stmt.executeQuery();
            
            while(rs.next()){             
                bemvindo.setHotel_acesso_adm_nome(rs.getString("hotel_acesso_adm_nome"));
                bemvindo.setHotel_acesso_adm_login(rs.getString("hotel_acesso_adm_login"));
                bemvindo.setHotel_acesso_adm_senha(rs.getString("hotel_acesso_adm_senha"));
            } 

            if(bemvindo.getHotel_acesso_adm_login().equals(usuario)&&bemvindo.getHotel_acesso_adm_senha().equals(senha)){
                retorno = true;
                Tela_Inicial.setId_func(0);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return retorno;
    }
    
    
    
}
