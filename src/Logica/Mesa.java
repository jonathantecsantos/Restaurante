package Logica;

/**
 * 
 * @author Jonathan e Abimael Classe responavel pelas mesas do restaurante
 */
public class Mesa {

	private boolean disponivel;
	private static int geradorId = 0;
	private int id;
	Pedido pedido;
	private String nomeMesa;

	/**
	 * Metodo construtor da classe Mesa
	 */
	public Mesa(String nomeMesa) {

		this.disponivel = true;
		geradorId++;
		this.id = geradorId;
		this.nomeMesa = nomeMesa;
	}

	/**
	 * Metodo get para pedido da mesa
	 * 
	 * @return
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * Metodo set para pedido da mesa
	 * 
	 * @param pedido
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
		this.disponivel = false;

	}

	/**
	 * Metodo responsavel pela disponibilidade das mesas
	 * 
	 * @return
	 */
	public boolean isDisponivel() {
		return disponivel;
	}

	/**
	 * Metodo responsavel por setar a disponibilidade das mesas
	 */
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	/**
	 * Metodo get para identificador da mesa
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo set para o identificador da mesa
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

}
