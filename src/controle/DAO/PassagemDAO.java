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

public class PassagemDAO {
	private Connection conn;
	
	public PassagemDAO() {
		conn = new FabricaDeConexoes().getConnection();
	}
	public void inserirPassagem(Passagem cliente) throws SQLException{
		String sql = "insert into passagem (tipo,dtida,dtvolta,desconto,bagagens,origem,destino) values (?,?,?,?,?,?,?);";
		
			PreparedStatement stmt = conn.prepareStatement(sql);
		
			stmt.setString(1, cliente.getTipo());
			stmt.setString(2, cliente.getDtida());
			stmt.setString(3, cliente.getDtvolta());
			stmt.setString(4, cliente.getDesconto());
			stmt.setString(5, cliente.getBagagens());
			stmt.setString(6, cliente.getOrigem());
			stmt.setString(7, cliente.getDestino());
		
			stmt.execute();
			stmt.close();
			conn.close();
	}
	public void excluirPassagem(int idPassagem) throws SQLException{
		String sql = "delete from Passagem where idPassagem ;";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,idPassagem);
		
		stmt.execute();
		stmt.close();
		conn.close();
	}
	public void alterarPassagem(Passagem cliente, int idPassagem) throws SQLException{
		String sql ="update passagem set tipo=?,dtida=?,dtvolta=?,desconto=?,bagagens=?,origem=?,destino=? where idPassagem = ?;";
	
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, cliente.getTipo());
		stmt.setString(2, cliente.getDtida());
		stmt.setString(3, cliente.getDtvolta());
		stmt.setString(4, cliente.getDesconto());
		stmt.setString(5, cliente.getBagagens());
		stmt.setString(5, cliente.getOrigem());
		
		
		stmt.setInt(7, idPassagem);
		
		
		stmt.execute();
		stmt.close();
		conn.close();
	}
	public List<Passagem> consultarPassagem(int idPassagem) throws SQLException {

		String sql = "select * from passagem where idPassagem = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1,idPassagem);

		ResultSet rs = stmt.executeQuery();

		List<Passagem> passagem = new ArrayList<Passagem>();

		while (rs.next()) {
			Reserva rv = new Reserva();
			Passagem pg = new Passagem();
			Passageiro pr = new Passageiro();
			
			pg.setIdPassagem(rs.getInt("idPassagem"));
			pg.setTipo(rs.getString("tipo"));
			pg.setDtida(rs.getString("dtida"));
			pg.setDtvolta(rs.getString("dtvolta"));
			pg.setDesconto(rs.getString("desconto"));
			pg.setBagagens(rs.getString("Bagagens"));
			pg.setOrigem(rs.getString("origem"));
			
			rv.setIdReserva(rs.getInt("idReserva"));
			pg.setIdPassagem(rs.getInt("idPassagem"));
			pr.setIdPassageiro(rs.getInt("idPassageiro"));
			
		
			
			
			passagem.add(pg);

		}
		
		
		
		rs.close();
		stmt.close();
		conn.close();
		return passagem;

	}
}
