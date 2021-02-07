package modelo;

public class Reserva {
	private int idReserva;
	private Passageiro idPassageiro;
	private Passagem idPassagem;
	private int assento;
	
	public Reserva() {}
	
	
	public Reserva(int idReserva, Passageiro idPassageiro, Passagem idPassagem, int assento) {
		super();
		this.idReserva = idReserva;
		this.idPassageiro = idPassageiro;
		this.idPassagem = idPassagem;
		this.assento = assento;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public int getIdPassageiro() {
		return idPassageiro.getIdPassageiro();
	}

	public void setIdPassageiro(Passageiro idPassageiro) {
		this.idPassageiro = idPassageiro;
	}

	public int getIdPassagem() {
		return idPassagem.getIdPassagem();
	}

	public void setIdPassagem(Passagem idPassagem) {
		this.idPassagem = idPassagem;
	}

	public int getAssento() {
		return assento;
	}

	public void setAssento(int assento) {
		this.assento = assento;
	}
	
	

}
