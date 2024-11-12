package br.com.arq.model;

public class Medico {
	private String nome;
	private String senha;
	private String crm;
	private String hospital;
	private String email;
	private String especialidade;

	public Medico(String nome, String senha, String crm, String hospital, String email, String especialidade) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.crm = crm;
		this.hospital = hospital;
		this.email = email;
		this.especialidade = especialidade;
	}

	public Medico() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	@Override
	public String toString() {
		return "Medico [nome=" + nome + ", senha=" + senha + ", crm=" + crm + ", hospital=" + hospital + ", email="
				+ email + ", especialidade=" + especialidade + "]";
	}
	
	

}
