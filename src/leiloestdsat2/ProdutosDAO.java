package leiloestdsat2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import leiloestdsat2.Telas.ListagemView;
import leiloestdsat2.Conexao;
import leiloestdsat2.ProdutosDTO;

public class ProdutosDAO {
    
    public List<ProdutosDTO> readForStatus(String Status) {

        Connection con = Conexao.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ProdutosDTO> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE Status LIKE ?");
            stmt.setString(1, "%"+Status+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                ProdutosDTO produto = new ProdutosDTO();

                produto.setID(rs.getInt("Id"));
                produto.setNome(rs.getString("Nome"));
                produto.setValor(rs.getInt("Valor"));
                produto.setStatus(rs.getString("Status"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs); }
        return produtos;
    }
    
    
}
