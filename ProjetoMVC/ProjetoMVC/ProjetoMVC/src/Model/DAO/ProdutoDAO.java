/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Conection.Conexao;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class ProdutoDAO {
    Connection con;
    
    public void inserirProduto(Produto p) throws SQLException
    { 
            con = new Conexao().getConnection();
            String sql = "Insert into ProdutoMVC (Codigo,Descricao,Preco) values (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, p.getCod());
            stmt.setString(2, p.getDesc());
            stmt.setFloat(3, p.getPreco());
            //stmt.setString(3, p.getPreco());
            stmt.execute();
            stmt.close();
            con.close();    
    }

    public void excluir(int cod) throws SQLException {
           con = new Conexao().getConnection();
        String sql = "DELETE FROM ProdutoMVC WHERE Codigo = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
       
        stmt.setInt(1,cod);
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    
    public ArrayList <Produto> BuscarProduto() throws SQLException{
        ResultSet rs;
        ArrayList<Produto> listaP = new ArrayList();
         con = new Conexao().getConnection();
        String sql = "SELECT * FROM ProdutoMVC ";
        PreparedStatement stmt = con.prepareStatement(sql);
        rs = stmt.executeQuery();
        while(rs.next()){
            int cod = rs.getInt("Codigo");
            String desc = rs.getString("Descricao");
            float preco = rs.getFloat("Preco");
            Produto pl = new Produto (cod, desc,preco);
            listaP.add(pl);
        }
        
        stmt.close();
        con.close();
        return listaP;
       
        
    }
    public ArrayList <Produto> buscarPorNome(String descP) throws SQLException{
        ResultSet rs;
        ArrayList<Produto> lista = new ArrayList();
        con = new Conexao().getConnection();
        String sql = "SELECT * FROM ProdutoMVC WHERE Descricao like ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1,descP);
        rs = stmt.executeQuery();
        while(rs.next()){
            int cod = rs.getInt("Codigo");
            String desc = rs.getString("Descricao");
            float preco = rs.getFloat("Preco");
            Produto pl = new Produto (cod, desc,preco);
            lista.add(pl);
        }
        
        stmt.close();
        con.close();
        
        return lista;
    }
    
}
