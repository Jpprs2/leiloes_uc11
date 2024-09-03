package leiloestdsat2;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
    
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    
    
    public boolean conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11","root", "oooo");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false; } }
    
    public int salvar(ProdutosDTO func){
        int status;
        try {
            st = conn.prepareStatement("INSERT INTO produtos VALUES(?, ?, ?, ?)");
            st.setInt(1,func.getId());
            st.setString(2,func.getNome());
            st.setInt(3,func.getValor());
            st.setString(4,func.getStatus());
            
            
            status = st.executeUpdate();
            return status; //retornar 1
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode(); } }
    
    
    public void desconectar(){
        try {conn.close();} catch (SQLException ex) { } }

    
    
    
}
