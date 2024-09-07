package leiloestdsat2;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Conexao {
    
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    
    
    public Connection getConexao() {
        if (conn == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/produtos";
                String user = "root";
                String password = "oooo";
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Conexão estabelecida com sucesso.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erro ao estabelecer conexão: " + e.getMessage()); } }
        return conn; }
   
    
    
    public boolean conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11","root", "oooo");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false; } }
    
    
    
    public void desconectar(){
        try {conn.close();} catch (SQLException ex) { } }
    
    
    
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
    
    
    
    public static List<ProdutosDTO> listarTodos() {
        //Declaração da variável lista que será retornada
        List<ProdutosDTO> lista = new ArrayList<ProdutosDTO>();

        try {
            //Conectar ao banco
            Conexao c = new Conexao();
            c.conectar();

            //Instrução SQL
            String sql = "SELECT * FROM produtos";
            PreparedStatement consulta = c.getConexao().prepareStatement(sql);

            //Executar a instrução SQL e pegar os resultados
            //ResultSet -> Classe do Java que armazena os resultados de uma QUERY (busca) feita em SQL
            ResultSet resposta = consulta.executeQuery();

            while (resposta.next()) {
                ProdutosDTO v = new ProdutosDTO();

                v.setId(resposta.getInt("Id"));
                v.setNome(resposta.getString("Nome"));
                v.setValor(resposta.getInt("Valor"));
                v.setStatus(resposta.getString("Status"));
                
                lista.add(v);}
            //Desconectar do banco
            c.desconectar();
         }catch (SQLException e) {
            System.out.println("Erro ao listar os registros do banco de dados!"); } return lista; }
    
}
