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
import model.pojo.Funcionario;
import view.Tela_Inicial;

/**
 *
 * @author Usuario
 */
public class FuncionarioDAO {
    
    
    public void create(Funcionario f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO funcionarios (func_nome,func_data_nasc,func_rg,func_cpf,func_sexo,func_tel_fix,func_tel_cel,func_email,func_cep,func_endereco,func_numero,func_uf,func_cidade,func_bairro,func_complemento,func_data_admissao,func_funcao,func_login,func_senha) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,f.getNome());
            stmt.setString(2,f.getData_nasc());
            stmt.setString(3,f.getRg());
            stmt.setString(4,f.getCpf());
            stmt.setString(5,f.getSexo());
            stmt.setString(6,f.getTel_fixo());
            stmt.setString(7,f.getTel_cel());
            stmt.setString(8,f.getEmail());
            stmt.setString(9,f.getCep());
            stmt.setString(10,f.getEndereco());
            stmt.setInt(11, f.getNumero());
            stmt.setString(12,f.getUf());
            stmt.setString(13,f.getCidade());
            stmt.setString(14,f.getBairro());
            stmt.setString(15,f.getComplemento());
            stmt.setString(16,f.getData_admissao());
            stmt.setString(17,f.getFuncao());
            stmt.setString(18,f.getLogin());
            stmt.setString(19,f.getSenha());
            
            stmt.executeUpdate();
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<Funcionario> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Funcionario> lista_de_funcionarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionarios ORDER BY id_funcionario ASC");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionario funcionario = new Funcionario();
                
                funcionario.setId(rs.getInt("id_funcionario"));
                funcionario.setNome(rs.getString("func_nome"));
                funcionario.setData_nasc(rs.getString("func_data_nasc"));
                funcionario.setRg(rs.getString("func_rg"));
                funcionario.setCpf(rs.getString("func_cpf"));
                funcionario.setSexo(rs.getString("func_sexo"));
                funcionario.setTel_fixo(rs.getString("func_tel_fix"));
                funcionario.setTel_cel(rs.getString("func_tel_cel"));
                funcionario.setEmail(rs.getString("func_email"));
                funcionario.setCep(rs.getString("func_cep"));
                funcionario.setEndereco(rs.getString("func_endereco"));
                funcionario.setNumero(rs.getInt("func_numero"));
                funcionario.setUf(rs.getString("func_uf"));
                funcionario.setCidade(rs.getString("func_cidade"));
                funcionario.setBairro(rs.getString("func_bairro"));
                funcionario.setComplemento(rs.getString("func_complemento"));
                funcionario.setData_admissao(rs.getString("func_data_admissao"));
                funcionario.setFuncao(rs.getString("func_funcao"));
                funcionario.setLogin(rs.getString("func_login"));
                funcionario.setSenha(rs.getString("func_senha"));
                
                
                lista_de_funcionarios.add(funcionario);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista_de_funcionarios;
    }
    
    public void update(Funcionario f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE funcionarios SET func_nome = ?,func_data_nasc = ?,func_rg = ?,func_cpf = ?,func_sexo = ?,func_tel_fix = ?,func_tel_cel = ?,"
                    + "func_email = ?,func_cep = ?,func_endereco = ?,func_numero = ?,func_uf = ?,func_cidade = ?,func_bairro = ?,func_complemento = ?,func_data_admissao = ?,"
                    + "func_funcao = ?,func_login = ?,func_senha = ? WHERE id_funcionario = ?");
            
            stmt.setString(1,f.getNome());
            stmt.setString(2,f.getData_nasc());
            stmt.setString(3,f.getRg());
            stmt.setString(4,f.getCpf());
            stmt.setString(5,f.getSexo());
            stmt.setString(6,f.getTel_fixo());
            stmt.setString(7,f.getTel_cel());
            stmt.setString(8,f.getEmail());
            stmt.setString(9,f.getCep());
            stmt.setString(10,f.getEndereco());
            stmt.setInt(11, f.getNumero());
            stmt.setString(12,f.getUf());
            stmt.setString(13,f.getCidade());
            stmt.setString(14,f.getBairro());
            stmt.setString(15,f.getComplemento());
            stmt.setString(16,f.getData_admissao());
            stmt.setString(17,f.getFuncao());
            stmt.setString(18,f.getLogin());
            stmt.setString(19,f.getSenha());
            stmt.setInt(20,f.getId());
            
            
            stmt.executeUpdate();          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }  
    }
    
    public ArrayList<Funcionario> read_Method(int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Funcionario> lista_de_funcionarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM funcionarios WHERE id_funcionario = ? ORDER BY id_funcionario ASC");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionario funcionario = new Funcionario();
                
                funcionario.setId(rs.getInt("id_funcionario"));
                funcionario.setNome(rs.getString("func_nome"));
                funcionario.setData_nasc(rs.getString("func_data_nasc"));
                funcionario.setRg(rs.getString("func_rg"));
                funcionario.setCpf(rs.getString("func_cpf"));
                funcionario.setSexo(rs.getString("func_sexo"));
                funcionario.setTel_fixo(rs.getString("func_tel_fix"));
                funcionario.setTel_cel(rs.getString("func_tel_cel"));
                funcionario.setEmail(rs.getString("func_email"));
                funcionario.setCep(rs.getString("func_cep"));
                funcionario.setEndereco(rs.getString("func_endereco"));
                funcionario.setNumero(rs.getInt("func_numero"));
                funcionario.setUf(rs.getString("func_uf"));
                funcionario.setCidade(rs.getString("func_cidade"));
                funcionario.setBairro(rs.getString("func_bairro"));
                funcionario.setComplemento(rs.getString("func_complemento"));
                funcionario.setData_admissao(rs.getString("func_data_admissao"));
                funcionario.setFuncao(rs.getString("func_funcao"));
                funcionario.setLogin(rs.getString("func_login"));
                funcionario.setSenha(rs.getString("func_senha"));
                
                lista_de_funcionarios.add(funcionario);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista_de_funcionarios;
    }
    
    public void delete(Funcionario f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE from funcionarios WHERE id_funcionario = ?");
            stmt.setInt(1,f.getId());
            
            stmt.executeUpdate();          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }  
    }

    //MÉTODO PARA VERIFICAR O LOGIN RETORNANDO TRUE OU FALSE
    public boolean read_Login(String usuario,String senha){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean retorno = false;
        
        ArrayList<Funcionario> lista_de_funcionarios = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionarios ORDER BY id_funcionario ASC");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionario funcionario = new Funcionario();
                
                funcionario.setId(rs.getInt("id_funcionario"));
                funcionario.setFuncao(rs.getString("func_funcao"));
                funcionario.setLogin(rs.getString("func_login"));
                funcionario.setSenha(rs.getString("func_senha"));
                lista_de_funcionarios.add(funcionario);
            } 
            for(int i=0;i<lista_de_funcionarios.size();i++){
                if((lista_de_funcionarios.get(i).getLogin().equals(usuario))&&(lista_de_funcionarios.get(i).getSenha().equals(senha))){
                    retorno = true;
                    Tela_Inicial.setId_func(lista_de_funcionarios.get(i).getId());
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return retorno;
    }    
}
