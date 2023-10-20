/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    public ProdutosDAO() {
        this.con = new conectaDAO().connectDB();
    }
    Connection con;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){        
        
        String sql = "insert into produtos(nome, valor, status)" + "values(?,?,?);";

        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, produto.getNome());
            
            ps.setInt(2, produto.getValor());
            // ...
            ps.setString(3, produto.getStatus());
            
            
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "O produto foi cadastrado com sucesso!");
        } 
            catch (Exception e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "ERRO. O produto não foi cadastrado!");
            }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        String sql = "SELECT * FROM produtos";
            
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ProdutosDTO p = new ProdutosDTO();
                p.setId(rs.getInt("id")); // Se a tabela possui uma coluna "id"
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getInt("valor"));
                p.setStatus(rs.getString("status"));
                listagem.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listagem;
    }
}

