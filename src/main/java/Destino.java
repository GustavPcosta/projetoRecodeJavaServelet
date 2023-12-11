

public class Destino {
	 private int id;
	    private String nome;
	    private String sobrenome;
	    private String email;
	    private float pagamento;
	    private String estado;
	    private String cep;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getSobrenome() {
			return sobrenome;
		}
		public void setSobrenome(String sobrenome) {
			this.sobrenome = sobrenome;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public float getPagamento() {
			return pagamento;
		}
		public void setPagamento(float pagamento) {
			this.pagamento = pagamento;
		}
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}
		public String getCep() {
			return cep;
		}
		public void setCep(String cep) {
			this.cep = cep;
		}
		public Destino(int id, String nome, String sobrenome, String email, float pagamento, String estado,
				String cep) {
			super();
			this.id = id;
			this.nome = nome;
			this.sobrenome = sobrenome;
			this.email = email;
			this.pagamento = pagamento;
			this.estado = estado;
			this.cep = cep;
		}
		public Destino() {
			super();
			
		}
	    
	    
	    
}
