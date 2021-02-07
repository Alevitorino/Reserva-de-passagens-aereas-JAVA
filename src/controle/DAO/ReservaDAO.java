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

public class ReservaDAO {
	private Connection conn;
	
	public ReservaDAO(){
		conn = new FabricaDeConexoes().getConnection();
	}
	public void inserirReserva(Reserva cliente) throws SQLException{
		String sql = "insert into reserva (assento) values(?);";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, cliente.getAssento());
	
		stmt.execute();
		stmt.close();
		conn.close();
	}
	public void alterarReserva(Reserva cliente, int idReserva) throws SQLException{
		String sql = "update reserva set assento=? where idReserva = ?;";
		
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, cliente.getAssento());
		stmt.setInt(2, idReserva);
		
		
		stmt.execute();
		stmt.close();
		conn.close();
	}
	public void excluirReserva(int idReserva) throws SQLException{
		String sql = "delete from reserva where idReserva=?;";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, idReserva);
		
		stmt.execute();
		stmt.close();
		conn.close();
	}
	
	public List<Reserva> consultarReserva(int idReserva) throws SQLException {

		String sql = "select * from reserva where idReserva = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1,idReserva);

		ResultSet rs = stmt.executeQuery();

		List<Reserva> reserva = new ArrayList<Reserva>();

		while (rs.next()) {
			Reserva rv = new Reserva();
			Passagem pg = new Passagem();
			Passageiro pr = new Passageiro();
			
			rv.setAssento(rs.getInt("Assento"));
			rv.setIdReserva(rs.getInt("idReserva"));
			
			pg.setIdPassagem(rs.getInt("idPassagem"));
			pr.setIdPassageiro(rs.getInt("idPassageiro"));
			
			rv.setIdPassageiro(pr);
			rv.setIdPassagem(pg);
			
			reserva.add(rv);

		}
		
		
		
		rs.close();
		stmt.close();
		conn.close();
		return reserva;

	}
}
