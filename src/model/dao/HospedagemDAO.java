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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.pojo.Hospedagem;

/**
 *
 * @author Ebner
 */
public class HospedagemDAO {
    //MÉTODO QUE LÊ TODOS AS HOSPEDAGENS DO BANCO DE DADOS
    public ArrayList<Hospedagem> ReadHospInnerQuartos(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Hospedagem> lista_de_hospedagens = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM hospedagens INNER JOIN quartos ON hospedagens.id_quarto = quartos.id_quarto WHERE id_status_hospedagem = 2 ORDER BY id_hospedagem;");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Hospedagem hospedagem = new Hospedagem();
                
                hospedagem.setId_hospedagem(rs.getInt("id_hospedagem"));
                hospedagem.setId_cliente(rs.getInt("id_cliente"));
                hospedagem.setId_quarto(rs.getInt("id_quarto"));
                hospedagem.setPeriodo_ini(rs.getString("periodo_ini"));
                hospedagem.setPeriodo_fim(rs.getString("periodo_fim"));
                hospedagem.setPeriodo_fim(rs.getString("periodo_fim"));
                hospedagem.setId_status_hospedagem(rs.getInt("id_status_hospedagem"));
                hospedagem.setQuarto_descricao(rs.getString("quarto_descricao"));
                hospedagem.setQuarto_andar(rs.getInt("quarto_andar"));
                hospedagem.setQuarto_val_diaria(rs.getDouble("quarto_val_diaria"));
                
                lista_de_hospedagens.add(hospedagem);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista_de_hospedagens;
    }
    
    //MÉTODO QUE LÊ TODOS AS HOSPEDAGENS EM ANDAMENTO NO BANCO DE DADOS
    public ArrayList<Hospedagem> ReadHospEmAndamento(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Hospedagem> lista_de_hospedagens = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM hospedagens INNER JOIN quartos ON hospedagens.id_quarto = quartos.id_quarto WHERE id_status_hospedagem = 2 ORDER BY id_hospedagem;");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Hospedagem hospedagem = new Hospedagem();
                
                hospedagem.setId_hospedagem(rs.getInt("id_hospedagem"));
                hospedagem.setId_cliente(rs.getInt("id_cliente"));
                hospedagem.setId_quarto(rs.getInt("id_quarto"));
                hospedagem.setPeriodo_ini(rs.getString("periodo_ini"));
                hospedagem.setPeriodo_fim(rs.getString("periodo_fim"));
                hospedagem.setPeriodo_fim(rs.getString("periodo_fim"));
                hospedagem.setId_status_hospedagem(rs.getInt("id_status_hospedagem"));
                hospedagem.setQuarto_descricao(rs.getString("quarto_descricao"));
                hospedagem.setQuarto_andar(rs.getInt("quarto_andar"));
                hospedagem.setQuarto_val_diaria(rs.getDouble("quarto_val_diaria"));
                
                lista_de_hospedagens.add(hospedagem);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista_de_hospedagens;
    }
    
    //MÉTODO QUE LÊ TODOS AS HOSPEDAGENS CANCELADAS NO BANCO DE DADOS
    public ArrayList<Hospedagem> ReadHospCanceladas(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Hospedagem> lista_de_hospedagens = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM hospedagens INNER JOIN quartos ON hospedagens.id_quarto = quartos.id_quarto WHERE id_status_hospedagem = 3 ORDER BY id_hospedagem;");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Hospedagem hospedagem = new Hospedagem();
                
                hospedagem.setId_hospedagem(rs.getInt("id_hospedagem"));
                hospedagem.setId_cliente(rs.getInt("id_cliente"));
                hospedagem.setId_quarto(rs.getInt("id_quarto"));
                hospedagem.setPeriodo_ini(rs.getString("periodo_ini"));
                hospedagem.setPeriodo_fim(rs.getString("periodo_fim"));
                hospedagem.setPeriodo_fim(rs.getString("periodo_fim"));
                hospedagem.setId_status_hospedagem(rs.getInt("id_status_hospedagem"));
                hospedagem.setQuarto_descricao(rs.getString("quarto_descricao"));
                hospedagem.setQuarto_andar(rs.getInt("quarto_andar"));
                hospedagem.setQuarto_val_diaria(rs.getDouble("quarto_val_diaria"));
                
                lista_de_hospedagens.add(hospedagem);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista_de_hospedagens;
    }

    //MÉTODO QUE LÊ TODOS AS HOSPEDAGENS FINALIZADAS NO BANCO DE DADOS
    public ArrayList<Hospedagem> ReadHospFinalizadas(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Hospedagem> lista_de_hospedagens = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM hospedagens INNER JOIN quartos ON hospedagens.id_quarto = quartos.id_quarto WHERE id_status_hospedagem = 1 ORDER BY id_hospedagem;");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Hospedagem hospedagem = new Hospedagem();
                
                hospedagem.setId_hospedagem(rs.getInt("id_hospedagem"));
                hospedagem.setId_cliente(rs.getInt("id_cliente"));
                hospedagem.setId_quarto(rs.getInt("id_quarto"));
                hospedagem.setPeriodo_ini(rs.getString("periodo_ini"));
                hospedagem.setPeriodo_fim(rs.getString("periodo_fim"));
                hospedagem.setPeriodo_fim(rs.getString("periodo_fim"));
                hospedagem.setId_status_hospedagem(rs.getInt("id_status_hospedagem"));
                hospedagem.setQuarto_descricao(rs.getString("quarto_descricao"));
                hospedagem.setQuarto_andar(rs.getInt("quarto_andar"));
                hospedagem.setQuarto_val_diaria(rs.getDouble("quarto_val_diaria"));
                
                lista_de_hospedagens.add(hospedagem);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista_de_hospedagens;
    }
    
    //MÉTODO QUE CRIA UM NOVO QUARTO NO BANCO DE DADOS
    public void create(Hospedagem h){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO hospedagens (id_cliente,id_quarto,periodo_ini,periodo_fim,id_status_hospedagem) VALUES (?,?,?,?,?)");
            stmt.setInt(1,h.getId_cliente());
            stmt.setInt(2,h.getId_quarto());
            stmt.setString(3,h.getPeriodo_ini());
            stmt.setString(4,h.getPeriodo_fim());
            stmt.setInt(5,h.getId_status_hospedagem());
       
            stmt.executeUpdate();
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
