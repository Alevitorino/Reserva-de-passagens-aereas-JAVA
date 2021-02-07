package modelo;

public class Passagem {
	private int idPassagem;
	private String tipo;
	private String dtida;
	private String dtvolta;
	private String desconto;
	private String bagagens;
	private String origem;
	private String destino;
	
	public Passagem() {}
	
	public Passagem(int idPassagem, String tipo, String dtida, String dtvolta, String desconto, String bagagens,
			String origem, String destino) {
		super();
		this.idPassagem = idPassagem;
		this.tipo = tipo;
		this.dtida = dtida;
		this.dtvolta = dtvolta;
		this.desconto = desconto;
		this.bagagens = bagagens;
		this.origem = origem;
		this.destino = destino;
	}

	public int getIdPassagem() {
		return idPassagem;
	}

	public void setIdPassagem(int idPassagem) {
		this.idPassagem = idPassagem;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDtida() {
		return dtida;
	}

	public void setDtida(String dtida) {
		this.dtida = dtida;
	}

	public String getDtvolta() {
		return dtvolta;
	}

	public void setDtvolta(String dtvolta) {
		this.dtvolta = dtvolta;
	}

	public String getDesconto() {
		return desconto;
	}

	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}

	public String getBagagens() {
		return bagagens;
	}

	public void setBagagens(String bagagens) {
		this.bagagens = bagagens;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	
	
}
