package Logica;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Jonathan e Abimael
 * Classe responsável pelos pedidos do restaurante
 */
public class Pedido {
	private static int geradorId=0;
	private List<Prato> pratos = new ArrayList<Prato>();
	private Double contaFinal=0.0;
	private int id;
	private String nome;
	
	/**
	 * Metodo construtor da classe Pedido
	 * @param nome
	 */
	public Pedido(String nome){
		this.nome = nome;
		geradorId++;
		this.id = geradorId; 
	}
	/**
	 * Metodo get para identificador do pedido
	 * @return id do pedido
	 */
	public int getId(){
		return this.id;
	}
	/**
	 * Metodo get para nome do pedido
	 * @return nome do pedido
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo set para nome do pedido
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo para adicionar um novo prato ao pedido.
	 * @param prato
	 */
	public void adicionaPrato(Prato prato){
		pratos.add(prato);
		this.contaFinal = contaFinal + prato.getPreco();
	}
	/**
	 * Metodo para retornar o valor total do pedido.
	 * @return
	 */
	public Double fecharPedido(){
		return this.contaFinal;
	}
	/**
	 * Metodo get para valor da conta final do pedido
	 * @return
	 */
	public Double getContaFinal() {
		return contaFinal;
	}
	/**
	 * Metodo toString para imprimir pratos e precos do pedido
	 */
	@Override
	public String toString() {
		String resultado = "";
		for (Prato prato : pratos) {
			resultado = resultado +"Prato consumido: "+ prato.getNome()+" Preço do prato: "+prato.getPreco()+ "\n"; 
		}
		resultado = resultado + "NOME DO PEDIDO: "+ this.nome+ "\n"+ "TOTAL CONSUMIDO ATE O MOMENTO: "+ fecharPedido()+"\n";
		
		return resultado;
	}
	
	
	
	
	
	

}
