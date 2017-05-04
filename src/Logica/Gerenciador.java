
package Logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Excecoes.MesaNaoEncontradaException;
import Excecoes.MesaOcupadaException;
import Excecoes.PedidoNaoEncontradoException;
import Excecoes.PrecoMenorQueZeroException;
import Excecoes.PratoNaoEncontradoException;

/**
 * 
 * @author Abimael e Jonathan 
 * Classe resonsavel pelo gerenciamento do restaurante
 */
public class Gerenciador {
	private List<Garcom> garcons = new ArrayList<Garcom>();
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	private Cardapio cardapio = new Cardapio();
	private List<Mesa> mesas = new ArrayList<Mesa>();

	/**
	 * Metodo responsavel pelo cadastro do Gar�on
	 */
	public void cadastrarGarcom() {
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite o nome do novo gar�om:\n");
		String nome = leitor.nextLine();
		Garcom garcomNovo = new Garcom(nome);
		this.garcons.add(garcomNovo);
		System.out.println("Gar�om cadastrado com sucesso!");
	}

	/**
	 * Metodo responsavel pela criacao de Mesas Recebe a quantidade de mesas
	 * desejada por parametro
	 * 
	 * @param quantidadeDeMesas
	 */
	public void criaMesas(int quantidadeDeMesas) {
		for (int i = 0; i < quantidadeDeMesas; i++) {
			Mesa mesa = new Mesa("Mesa " + i + 1);
			mesas.add(mesa);
		}
	}

	/**
	 * Metodo responsavel por adiconar pratos ao cardapio Lanca execessao caso o
	 * preco do prato seja menor que zero
	 * 
	 * @throws PrecoMenorQueZeroException
	 */
	public void adicionarPratoAoCardapio() throws PrecoMenorQueZeroException {
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite o nome do novo prato:\n");
		String nome = leitor.nextLine();
		// Autentica se o nome do prato nao esta vazio
		String nomePrato = validaEntradaDeTexto(nome);
		System.out.println("Digite o descricao do novo prato:\n");
		String descricao = leitor.nextLine();
		// Autentica se a descricao do prato nao esta vazia
		String descricaoPrato = validaEntradaDeTexto(descricao);
		System.out.println("Digite o pre�o do novo prato:\n");
		Double preco = Double.parseDouble(leitor.nextLine());
		if (preco < 0) {
			throw new PrecoMenorQueZeroException();
		}
		Prato novoPrato = new Prato(nomePrato, descricaoPrato, preco);
		this.cardapio.adicionaPrato(novoPrato);
		System.out.println("Prato adionado ao cardapio com sucesso!");

	}

	/**
	 * Metodo responsavel por apresentar os pratos cadastrados no cardapio
	 */
	public void verCardapio() {
		System.out.println(this.cardapio.toString());
	}

	/**
	 * Metodo responsavel por adicionar pedido do cliente Verificar mesas
	 * disponiveis e aloca a mesa vaga para o cliente Lanca excessao caso a mesa
	 * esteja ocupada
	 * 
	 * @throws MesaOcupadaException
	 */
	public void adicionaPedido() throws MesaOcupadaException {
		verificarMesasDisponiveis();
		Scanner leitor = new Scanner(System.in);
		Scanner leitor2 = new Scanner(System.in);
		System.out.println("DIGITE O ID DA MESA: ");
		int idMesa = leitor2.nextInt();
		try {
			Mesa mesa = buscarMesa(idMesa);
			if (!(mesa.isDisponivel())) {
				throw new MesaOcupadaException();
			}
			System.out.println("DIGITE O NOME DO PEDIDO (COLOCAR O NOME DO CLIENTE): ");
			String nomeDoPedido = leitor.nextLine();
			Pedido novoPedido = new Pedido(nomeDoPedido);
			System.out.println("DIGITE O ID DO PRATO A SER ADICIONADO NO NOVO PEDIDO: ");
			int id = leitor.nextInt();
			Prato novoPratoDoPedido = buscarPrato(id);
			novoPedido.adicionaPrato(novoPratoDoPedido);
			this.pedidos.add(novoPedido);
			mesa.setDisponivel(false);
			mesa.setPedido(novoPedido);
			System.out.println("NOVO PEDIDO REGISTRADO COM SUCESSO!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Metodo para adicionar prato a pedido em aberto
	 */
	public void adicionarPratoAPedidoEmAberto() {
		Scanner leitor = new Scanner(System.in);
		try {
			System.out.println("DIGITE O ID DO PEDIDO QUE DESEJA ADICIONAR UM NOVO PRATO: ");
			int idPedido = leitor.nextInt();
			Pedido pedido = buscarPedido(idPedido);
			System.out.println("DIGITE O ID DO PRATO QUE DESEJA ADICIONAR AO PEDIDO: ");
			int idPrato = leitor.nextInt();
			Prato prato = buscarPrato(idPrato);
			pedido.adicionaPrato(prato);
			System.out.println("PRATO ADICIONADO AO PEDIDO COM SUCESSO!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Metodo para listar pedidos em aberto
	 */
	public void listarPedidosEmAberto() {
		String resultado = "";
		for (Pedido pedido : pedidos) {
			resultado = resultado + "NOME DO PEDIDO: " + pedido.getNome() + " ID DO PEDIDO: " + pedido.getId() + "\n";
		}
		System.out.println(resultado);
	}

	/**
	 * Metodo para visualizar consumo de pedido em aberto
	 */

	public void verConsumoDePedidoEmAberto() {
		Scanner leitor = new Scanner(System.in);
		System.out.println("DIGITE O ID DO PEDIDO QUE DESEJA VER O CONSUMO ATE O MOMENTO: ");
		int idPedido = leitor.nextInt();
		try {
			Pedido pedido = buscarPedido(idPedido);
			System.out.println(pedido.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Metodo para buscar prato cadastrado
	 * 
	 * @param id
	 * @return
	 * @throws PratoNaoEncontradoException
	 */
	public Prato buscarPrato(int id) throws PratoNaoEncontradoException {
		for (Prato prato : cardapio.getCardapio()) {
			if (prato.getId() == id) {
				return prato;
			}
		}
		throw new PratoNaoEncontradoException();
	}

	/**
	 * Metodo para verificar mesas disponiveis para o cliente
	 */
	public void verificarMesasDisponiveis() {
		String resultado = "";
		for (Mesa mesa : mesas) {
			if (mesa.isDisponivel()) {
				resultado = resultado + mesa.getId() + System.lineSeparator();
			}
		}
		System.out.println("ID'S DAS MESAS DISPONIVEIS: " + System.lineSeparator());
		System.out.println(resultado);
	}

	/**
	 * Metodo para buscar mesa
	 * 
	 * @param id
	 * @return
	 * @throws MesaNaoEncontradaException
	 */
	public Mesa buscarMesa(int id) throws MesaNaoEncontradaException {
		for (Mesa mesa : mesas) {
			if (mesa.getId() == id) {
				return mesa;
			}
		}
		throw new MesaNaoEncontradaException();
	}

	/**
	 * Metodo para buscar pedido do cliente
	 * 
	 * @param id
	 * @return
	 * @throws PedidoNaoEncontradoException
	 */
	public Pedido buscarPedido(int id) throws PedidoNaoEncontradoException {
		for (Pedido pedido : pedidos) {
			if (pedido.getId() == id) {
				return pedido;
			}
		}
		throw new PedidoNaoEncontradoException();
	}

	/**
	 * Metodo para validar entrada de texto em branco
	 * 
	 * @param ent
	 * @return
	 */
	public static String validaEntradaDeTexto(String ent) {
		Scanner leitor = new Scanner(System.in);
		String entrada = ent;
		while (entrada.isEmpty()) {
			System.out.println("Entrada inv�lida. Digite novamente: \n");
			entrada = leitor.nextLine();
		}
		return entrada;
	}

	/**
	 * Metodo para validar prato Enquanto a entrada for invalida, solicita um
	 * nome valido
	 * 
	 * @param entradaNome
	 * @param entradaDescricao
	 * @param entradaPreco
	 */
	public static void validaPrato(String entradaNome, String entradaDescricao, double entradaPreco) {
		String nome = entradaNome;
		String descricao = entradaDescricao;
		Double preco = entradaPreco;
		while (nome.isEmpty() && descricao.isEmpty()) {
			System.out.println("Entrada invalida, digite novamente:");
		}
	}

	/**
	 * Metodo para fechar pedido do cliente Mostra conta final do cliente e seta
	 * mesa como disponivel
	 */
	public void fecharPedido() {
		Scanner leitor = new Scanner(System.in);
		System.out.println("DIGITE O ID DO PEDIDO QUE DESEJA FECHAR: ");
		int idPedido = leitor.nextInt();
		try {
			Pedido pedido = buscarPedido(idPedido);
			System.out.println("TOTAL A PAGAR R$: " + pedido.getContaFinal());
			Mesa mesa = buscaMesaPorPedido(pedido.getId());
			mesa.setDisponivel(true);
			pedidos.remove(pedido);
			System.out.println("OBRIGADO. PEDIDO ENCERRADO!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Metodo para buscar mesa pelo identificador do pedido
	 * 
	 * @param idPedido
	 * @return
	 * @throws MesaNaoEncontradaException
	 */
	public Mesa buscaMesaPorPedido(int idPedido) throws MesaNaoEncontradaException {
		for (Mesa mesa : mesas) {
			if (mesa.getPedido().getId() == idPedido) {
				return mesa;
			}
		}
		throw new MesaNaoEncontradaException();
	}

}
