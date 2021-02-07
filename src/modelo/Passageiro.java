package modelo;

public class Passageiro {
	
	private int idPassageiro;
	private String nome;
	private String dtnasc;
	private String endereco;
	private String rg;
	private int telefone;
	
	
	public Passageiro() {
		
	}
	public Passageiro(int idPassageiro, String nome, String dtnasc, String endereco, String rg,
			int telefone) {
		super();
		this.idPassageiro = idPassageiro;
		this.nome = nome;
		this.dtnasc = dtnasc;
		this.endereco = endereco;
		
		this.rg = rg;
		this.telefone = telefone;
	}

	public int getIdPassageiro() {
		return idPassageiro;
	}

	public void setIdPassageiro(int idPassageiro) {
		this.idPassageiro = idPassageiro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDtnasc() {
		return dtnasc;
	}

	public void setDtnasc(String dtnasc) {
		this.dtnasc = dtnasc;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	
	
	
	
}
