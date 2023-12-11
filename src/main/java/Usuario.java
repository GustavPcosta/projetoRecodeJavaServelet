

import java.util.Date;
public class Usuario {
	private int id;
    private String email;
    private String senha;
    private Date dataCadastro;
    
    
    public Usuario() {
		super();
    }
	
	public Usuario(int id, String email, String senha, Date dataCadastro, String nome) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.dataCadastro = dataCadastro;
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	private String nome;
}
