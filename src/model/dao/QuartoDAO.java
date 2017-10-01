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
import model.pojo.Quarto;

/**
 *
 * @author Usuario
 */
public class QuartoDAO {
    //MÉTODO QUE CRIA UM NOVO QUARTO NO BANCO DE DADOS
    public void create(Quarto q){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO quartos (quarto_descricao,quarto_andar,quarto_val_diaria) VALUES (?,?,?)");
            stmt.setString(1,q.getDescricao());
            stmt.setInt(2,q.getAndar());
            stmt.setDouble(3,q.getVal_diaria());
       
            stmt.executeUpdate();
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    //MÉTODO QUE LÊ TODOS OS QUARTOS DO BANCO DE DADOS
    public ArrayList<Quarto> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Quarto> lista_de_quartos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM quartos ORDER BY id_quarto ASC");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Quarto quarto = new Quarto();
                
                quarto.setId_quarto(rs.getInt("id_quarto"));
                quarto.setDescricao(rs.getString("quarto_descricao"));
                quarto.setAndar(rs.getInt("quarto_andar"));
                quarto.setVal_diaria(rs.getDouble("quarto_val_diaria"));
                quarto.setQuarto_status(rs.getInt("quarto_status"));
                
                lista_de_quartos.add(quarto);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista_de_quartos;
    }
    
    //MÉTODO QUE LÊ TODOS OS QUARTOS DO BANCO DE DADOS
    public ArrayList<Quarto> readNotInHosp(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Quarto> lista_de_quartos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM quartos WHERE quarto_val_diaria >0 AND quarto_status =1 AND id_quarto NOT IN (SELECT id_quarto FROM hospedagens WHERE id_status_hospedagem = 2);");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Quarto quarto = new Quarto();
                
                quarto.setId_quarto(rs.getInt("id_quarto"));
                quarto.setDescricao(rs.getString("quarto_descricao"));
                quarto.setAndar(rs.getInt("quarto_andar"));
                quarto.setVal_diaria(rs.getDouble("quarto_val_diaria"));
                quarto.setQuarto_status(rs.getInt("quarto_status"));
                
                lista_de_quartos.add(quarto);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista_de_quartos;
    }
    
    //MÉTODO PARA FAZER A ATUALIZAÇÃO DE UM DADO NO BANCO DE DADOS
    public void update(Quarto q){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE quartos SET quarto_descricao = ?,quarto_andar = ?,quarto_val_diaria = ?,quarto_status = ? WHERE id_quarto = ?");
            stmt.setString(1,q.getDescricao());
            stmt.setInt(2,q.getAndar());
            stmt.setDouble(3,q.getVal_diaria());
            stmt.setInt(4,q.getQuarto_status());
            stmt.setInt(5,q.getId_quarto());
            
            
            stmt.executeUpdate();          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }  
    }
    
    //MÉTODO PARA DELETAR UM QUARTO NO BANCO DE DADOS
    public void delete(Quarto q){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE from quartos WHERE id_quarto = ?");
            stmt.setInt(1,q.getId_quarto());
            
            stmt.executeUpdate();          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }  
    }

    //MÉTODO QUE LÊ NO BANCO DE DADOS DE ACORDO COM UMA ID
    public ArrayList<Quarto> read_Method(int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Quarto> lista_de_quartos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM quartos WHERE id_quarto = ? ORDER BY id_quarto ASC");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Quarto quarto = new Quarto();
                
                quarto.setId_quarto(rs.getInt("id_quarto"));
                quarto.setDescricao(rs.getString("quarto_descricao"));
                quarto.setAndar(rs.getInt("quarto_andar"));
                quarto.setVal_diaria(rs.getDouble("quarto_val_diaria"));
                quarto.setQuarto_status(rs.getInt("quarto_status"));
                
                lista_de_quartos.add(quarto);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista_de_quartos;
    }
    
    //MÉTODO QUE LÊ NO BANCO DE DADOS DE ACORDO COM UMA DESCRIÇÃO
    public ArrayList<Quarto> read_Descricao(String descricao){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Quarto> lista_de_quartos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM quartos WHERE quarto_descricao like'%"+descricao+"%' ORDER BY id_quarto ASC");
            rs = stmt.executeQuery();
            while(rs.next()){
                Quarto quarto = new Quarto();
                
                quarto.setId_quarto(rs.getInt("id_quarto"));
                quarto.setDescricao(rs.getString("quarto_descricao"));
                quarto.setAndar(rs.getInt("quarto_andar"));
                quarto.setVal_diaria(rs.getDouble("quarto_val_diaria"));
                
                lista_de_quartos.add(quarto);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista_de_quartos;
    }

    //MÉTODO QUE CRIA AUTOMATICAMENTE OS QUARTOS NO BANCO DE DADOS DEPOIS DA PRIMEIRA TELA INICIAL
    public void createAutomatic(int andar,int quarto_por_andar){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            for(int a=1;a<=andar;a++){
                for(int qpa = 1;qpa<=quarto_por_andar;qpa++){
                        Quarto quarto = new Quarto();
                        int numero_quarto = Integer.parseInt(a-1+""+qpa);

                        stmt = con.prepareStatement("INSERT INTO quartos (quarto_descricao,quarto_andar,quarto_val_diaria,quarto_status) VALUES (?,?,?,?)");
                        stmt.setString(1,"SEM DESCRIÇÃO");
                        stmt.setInt(2,a);
                        stmt.setDouble(3,0.0);
                        stmt.setInt(4, 1);
                       
                        stmt.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        } 
    }
    
    
}
