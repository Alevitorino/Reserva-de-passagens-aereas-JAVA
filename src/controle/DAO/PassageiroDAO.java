package controle.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controle.FabricaDeConexoes;
import modelo.Passageiro;
import modelo.Passagem;
import modelo.Reserva;


public class PassageiroDAO {
	private Connection conn;
	
	public PassageiroDAO() {
		conn = new FabricaDeConexoes().getConnection();
	}
	public void inserirPassageiro(Passageiro cliente) throws SQLException{
		String sql = "insert into passageiros (nome,endereco,datanasc,cpf,rg,telefone) values (?,?,?,?,?,?);";
	
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getEndereco());
		stmt.setString(3, cliente.getDtnasc());
		stmt.setString(5, cliente.getRg());
		stmt.setInt(6, cliente.getTelefone());
		
		stmt.execute();
		stmt.close();
		conn.close();
		
	}
	public void excluirPassageiro (String cpf) throws SQLException {
		String sql = "delete from passageiros where cpf = ?;";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, cpf);
		
		stmt.execute();
		stmt.close();
		conn.close();
	}
	public void alterarPassageiro(Passageiro cliente, int idPassageiro) throws SQLException {
		String sql = "uptade passageiros set nome= ?,endereco=?,dtnasc=?,cpf=?,rg=?,telefone=? where idPassageiro = ?;";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getEndereco());
		stmt.setString(4, cliente.getRg());
		stmt.setInt(5, cliente.getTelefone());
		
		stmt.setInt(7, idPassageiro);
		
		
		stmt.execute();
		stmt.close();
		conn.close();
		
	}
	public List<Passageiro> consultarPassageiro(int idPassageiro) throws SQLException {

		String sql = "select * from passageiro where idPassageiro = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1,idPassageiro);

		ResultSet rs = stmt.executeQuery();

		List<Passageiro> passageiro = new ArrayList<Passageiro>();

		while (rs.next()) {
			Reserva rv = new Reserva();
			Passagem pg = new Passagem();
			Passageiro pr = new Passageiro();
			
			pr.setIdPassageiro(rs.getInt("idPassageiro"));
			pr.setNome(rs.getString("nome"));
			pr.setEndereco(rs.getString("endereco"));
			pr.setRg(rs.getString("rg"));
			pr.setTelefone(rs.getInt("telefone"));
			
			rv.setIdReserva(rs.getInt("idReserva"));
			pg.setIdPassagem(rs.getInt("idPassagem"));
			
			
			passageiro.add(pr);

		}
		
		
		
		rs.close();
		stmt.close();
		conn.close();
		return passageiro;

	}
}
