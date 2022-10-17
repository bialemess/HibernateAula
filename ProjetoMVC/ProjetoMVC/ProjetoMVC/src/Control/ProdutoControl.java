/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.DAO.ProdutoDAO;
import Model.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProdutoControl {
    private ArrayList <Produto> listaP;

    public ProdutoControl() {
        listaP = new ArrayList<>();
    }
    
    public void cadastrarProduto(int cod, String desc, float preco){
        Produto p = new Produto(cod,desc,preco);
        ProdutoDAO pdao = new ProdutoDAO();
        try{
            pdao.inserirProduto(p);
        }
        catch(SQLException ex){
            Logger.getLogger(ProdutoControl.class.getName()).log(Level.SEVERE,null,ex);
        }
        listaP.add(p);
   
        
    }
    

   public void excluirProduto(int cod) throws SQLException
    {
        ProdutoDAO alDao = new ProdutoDAO();
        alDao.excluir(cod);
    }
   
   public ArrayList<Produto>buscar() throws SQLException{
       ProdutoDAO alDao = new ProdutoDAO();
       return (alDao.BuscarProduto());
       
   }
   
   /*public ArrayList<Produto>buscarN(String desc) throws SQLException{
       ProdutoDAO alDao = new ProdutoDAO();
       return (alDao.buscarPorNome(desc));
       
   }  */

    public ArrayList<Produto> buscarN(String desc)throws SQLException{
        ProdutoDAO alDao = new ProdutoDAO();
       return (alDao.buscarPorNome(desc));
        
    }
   
    
    
}
