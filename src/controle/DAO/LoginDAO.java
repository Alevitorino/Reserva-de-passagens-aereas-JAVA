package controle.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controle.FabricaDeConexoes;
import modelo.Login;


public class LoginDAO {
	private Connection conn;
	
	public LoginDAO() {
		conn = new FabricaDeConexoes().getConnection();
	}
	public void inserirLogin(Login cliente) throws SQLException {
		String sql = "insert into usuario (user,senha) values (?,?);";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, cliente.getUsuario());
		stmt.setString(2, cliente.getSenha());
		
		stmt.execute();
		stmt.close();
		conn.close();
	}
	public void excluirLogin (String usuario) throws SQLException {
		String sql = "delete from usuario where user = ?;";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, usuario);
		
		stmt.execute();
		stmt.close();
		conn.close();
	}
	 public boolean logarSistema(String user,String senha) throws SQLException  {
         boolean status;
         String sql = "select * from usuario where user = ? and senha = ?";

         PreparedStatement stmt = conn.prepareStatement(sql);
		
         stmt.setString(1,user);
         stmt.setString(2,senha);

         ResultSet rs = stmt.executeQuery();

         if(rs.next()) {
              status = true;
         }else{
             status = false;
         }
         rs.close();
         stmt.close();
         conn.close();
	
         return status;    
	 }
	
}
