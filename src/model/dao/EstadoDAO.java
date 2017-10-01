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
import model.pojo.Estado;

/**
 *
 * @author Usuario
 */
public class EstadoDAO {
    
    public ArrayList<Estado> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Estado> lista_de_estados = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM estados");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Estado estado = new Estado();
                
                estado.setNome(rs.getString("nome"));
                estado.setUf(rs.getString("uf"));
                
                lista_de_estados.add(estado);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista_de_estados;
    }
    
}
