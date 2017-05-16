package Logica;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Abimael e Jonathan 
 * Classe responsavel pelo cardapio do restaurante
 * Nesta classe he agrupado uma lista de pratos
 */
// Macedo
public class Cardapio {

	private List<Prato> cardapio = new ArrayList<Prato>();
        private Integer codigo;

    

	/**
	 * Metodo para adicionar prato ao cardapio
	 * 
	 * @param prato
	 */
	public void adicionaPrato(Prato prato) {

		cardapio.add(prato);
	}

	/**
	 * Metodo do tipo toString responsavel por imprimir os itens de um cardapio
	 */
	@Override
	public String toString() {
		String resultado = "";
		int contador = 1;
		for (Prato prato : cardapio) {
			resultado = resultado + contador + " Prato: " + prato.getNome() + "  Pre�o: " + prato.getPreco()
					+ " ID DO PRATO: " + prato.getId() + "\n";
			contador++;
		}

		return resultado;
	}

	/**
	 *Metodo get para buscar os itens do cardapio 
	 * @return
	 */
	public List<Prato> getCardapio() {
		return cardapio;
	}

	/**
	 * Metodo responsavel pelo set na lista de pratos do cardapio
	 * @param cardapio
	 */
	public void setCardapio(List<Prato> cardapio) {
		this.cardapio = cardapio;
	}
        public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

}
