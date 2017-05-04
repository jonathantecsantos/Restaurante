package Logica;

/**
 * 
 * @author Abimael e Jonathan
 * Classe responsavel pelo cadastro do Garcom
 */
public class Garcom {
	private String nome;
        private Integer codigo;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

	/**
	 * Metodo construtor da classe Garcon
	 */
        
	public Garcom(String nome) {
		this.nome = nome;
	}

    public Garcom() {
    }

	/**
	 * Metodo get para buscar o nome do garcom
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo set para o nome do garcom
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

}
