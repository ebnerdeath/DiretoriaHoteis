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
import model.pojo.Cliente;



/**
 *
 * @author Usuario
 */
public class ClienteDAO {
    
    //MÉTODO QUE CRIA UM NOVO CLIENTE NO BANCO DE DADOS
    public void create(Cliente c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO clientes (cli_nome,cli_tipo,cli_data_nasc,cli_rg,cli_cpf,cli_cnpj,cli_sexo,cli_tel_fix,cli_tel_cel,cli_contato,cli_email,cli_cep,cli_endereco,cli_numero,cli_uf,cli_cidade,cli_complemento) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,c.getNome());
            stmt.setString(2,c.getTipoPessoa());
            stmt.setString(3,c.getData_nasc());
            stmt.setString(4,c.getRg());
            stmt.setString(5,c.getCpf());
            stmt.setString(6,c.getCnpj());
            stmt.setString(7,c.getSexo());
            stmt.setString(8,c.getTel_fixo());
            stmt.setString(9,c.getTel_cel());
            stmt.setString(10,c.getContato());
            stmt.setString(11,c.getEmail());
            stmt.setString(12,c.getCep());
            stmt.setString(13,c.getEndereco());
            stmt.setInt(14, c.getNumero());
            stmt.setString(15,c.getUf());
            stmt.setString(16,c.getCidade());
            stmt.setString(17,c.getComplemento());
            
            stmt.executeUpdate();
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    //MÉTODO QUE LÊ TODOS OS CLIENTES DO BANCO DE DADOS
    public ArrayList<Cliente> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Cliente> lista_de_clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM clientes ORDER BY id_cliente ASC");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setData_nasc(rs.getString("cli_data_nasc"));
                cliente.setRg(rs.getString("cli_rg"));
                cliente.setCpf(rs.getString("cli_cpf"));
                cliente.setCnpj(rs.getString("cli_cnpj"));
                cliente.setSexo(rs.getString("cli_sexo"));
                cliente.setTel_fixo(rs.getString("cli_tel_fix"));
                cliente.setTel_cel(rs.getString("cli_tel_cel"));
                cliente.setEmail(rs.getString("cli_email"));
                cliente.setCep(rs.getString("cli_cep"));
                cliente.setEndereco(rs.getString("cli_endereco"));
                cliente.setNumero(rs.getInt("cli_numero"));
                cliente.setUf(rs.getString("cli_uf"));
                cliente.setCidade(rs.getString("cli_cidade"));
                cliente.setComplemento(rs.getString("cli_complemento"));
                
                lista_de_clientes.add(cliente);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista_de_clientes;
    }
    
    //MÉTODO PARA FAZER A ATUALIZAÇÃO DE UM DADO NO BANCO DE DADOS
    public void update(Cliente c){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE clientes SET cli_nome = ?,cli_data_nasc = ?,cli_rg = ?,cli_cpf = ?,cli_cnpj = ?,cli_sexo = ?,cli_tel_fix = ?,cli_tel_cel = ?,cli_email = ?,cli_cep = ?,cli_endereco = ?,cli_numero = ?,cli_uf = ?,cli_cidade = ?,cli_complemento = ? WHERE id_cliente = ?");
            stmt.setString(1,c.getNome());
            stmt.setString(2,c.getData_nasc());
            stmt.setString(3,c.getRg());
            stmt.setString(4,c.getCpf());
            stmt.setString(5,c.getCnpj());
            stmt.setString(6,c.getSexo());
            stmt.setString(7,c.getTel_fixo());
            stmt.setString(8,c.getTel_cel());
            stmt.setString(9,c.getEmail());
            stmt.setString(10,c.getCep());
            stmt.setString(11,c.getEndereco());
            stmt.setInt(12,c.getNumero());
            stmt.setString(13,c.getUf());
            stmt.setString(14,c.getCidade());
            stmt.setString(15,c.getComplemento());
            stmt.setInt(16,c.getId());
            
            stmt.executeUpdate();          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }  
    }
    
    //MÉTODO QUE LÊ NO BANCO DE DADOS DE ACORDO COM UMA ID
    public ArrayList<Cliente> read_Method(int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Cliente> lista_de_clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM clientes WHERE id_cliente = ? ORDER BY id_cliente ASC");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("id_cliente"));                            
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setTipoPessoa(rs.getString("cli_tipo"));
                cliente.setData_nasc(rs.getString("cli_data_nasc")); 
                cliente.setRg(rs.getString("cli_rg"));  
                cliente.setCpf(rs.getString("cli_cpf"));
                cliente.setCnpj(rs.getString("cli_cnpj"));
                cliente.setSexo(rs.getString("cli_sexo"));
                cliente.setTel_fixo(rs.getString("cli_tel_fix"));
                cliente.setTel_cel(rs.getString("cli_tel_cel"));
                cliente.setEmail(rs.getString("cli_email"));
                cliente.setCep(rs.getString("cli_cep"));
                cliente.setEndereco(rs.getString("cli_endereco"));
                cliente.setNumero(rs.getInt("cli_numero"));
                cliente.setUf(rs.getString("cli_uf"));
                cliente.setCidade(rs.getString("cli_cidade"));
                cliente.setComplemento(rs.getString("cli_complemento"));
                
                lista_de_clientes.add(cliente);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista_de_clientes;
    }
    
    //MÉTODO QUE LÊ NO BANCO DE DADOS DE ACORDO COM O NOME
    public ArrayList<Cliente> read_Method(String nome){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Cliente> lista_de_clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM clientes WHERE cli_nome like '%"+nome+"%'ORDER BY id_cliente ASC");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("id_cliente"));                            
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setTipoPessoa(rs.getString("cli_tipo"));
                cliente.setData_nasc(rs.getString("cli_data_nasc")); 
                cliente.setRg(rs.getString("cli_rg"));  
                cliente.setCpf(rs.getString("cli_cpf"));
                cliente.setCnpj(rs.getString("cli_cnpj"));
                cliente.setSexo(rs.getString("cli_sexo"));
                cliente.setTel_fixo(rs.getString("cli_tel_fix"));
                cliente.setTel_cel(rs.getString("cli_tel_cel"));
                cliente.setEmail(rs.getString("cli_email"));
                cliente.setCep(rs.getString("cli_cep"));
                cliente.setEndereco(rs.getString("cli_endereco"));
                cliente.setNumero(rs.getInt("cli_numero"));
                cliente.setUf(rs.getString("cli_uf"));
                cliente.setCidade(rs.getString("cli_cidade"));
                cliente.setComplemento(rs.getString("cli_complemento"));
                
                lista_de_clientes.add(cliente);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista_de_clientes;
    }
    
    //MÉTODO QUE LÊ NO BANCO DE DADOS DE ACORDO COM O CPF DO CLIENTE
    public ArrayList<Cliente> read_Cli_Cpf(String cpf){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Cliente> lista_de_clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM clientes WHERE cli_cpf ='"+cpf+"' ORDER BY id_cliente ASC");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("id_cliente"));                            
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setTipoPessoa(rs.getString("cli_tipo"));
                cliente.setData_nasc(rs.getString("cli_data_nasc")); 
                cliente.setRg(rs.getString("cli_rg"));  
                cliente.setCpf(rs.getString("cli_cpf"));
                cliente.setCnpj(rs.getString("cli_cnpj"));
                cliente.setSexo(rs.getString("cli_sexo"));
                cliente.setTel_fixo(rs.getString("cli_tel_fix"));
                cliente.setTel_cel(rs.getString("cli_tel_cel"));
                cliente.setEmail(rs.getString("cli_email"));
                cliente.setCep(rs.getString("cli_cep"));
                cliente.setEndereco(rs.getString("cli_endereco"));
                cliente.setNumero(rs.getInt("cli_numero"));
                cliente.setUf(rs.getString("cli_uf"));
                cliente.setCidade(rs.getString("cli_cidade"));
                cliente.setComplemento(rs.getString("cli_complemento"));
                
                lista_de_clientes.add(cliente);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista_de_clientes;
    }
    
    //MÉTODO PARA DELETAR UM CLIENTE NO BANCO DE DADOS
    public void delete(Cliente c){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE from clientes WHERE id_cliente = ?");
            stmt.setInt(1,c.getId());
            
            stmt.executeUpdate();          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }  
    }
}
