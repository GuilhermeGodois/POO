package THINGSTODO;

public class Things {
	private int id;
	private String Nome;
	private String Descricao;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String Nome) {
		this.Nome = Nome;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String Descricao) {
		this.Descricao = Descricao;
	}
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", Nome=" + Nome + ", Descricao=" + Descricao + "]";
	}

}

