package Testes;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import Excecoes.PedidoNaoEncontradoException;
import Logica.Cardapio;
import Logica.Garcom;
import Logica.Gerenciador;
import Logica.Pedido;
import Logica.Prato;

public class TestGerenciador {

	@Test
	public void testDescricaoPratoVazio() {
		// Arange
		String nomeDoPrato = "";
		String descricaoPrato = "Frango Grelhado com Batatas";
		Double preco = 18.50;
		// Act
		String descricaoValidada = Gerenciador.validaEntradaDeTexto(descricaoPrato);

		// Assert
		assertEquals(false, descricaoValidada.isEmpty());
	}

	@Test(expected = NumberFormatException.class)
	public void testValorPratoNulo() {

		new Prato("Peixe", "Peixe com batata", null);
	}

	@Test(expected = NumberFormatException.class)
	public void testPrecoDoPratoMenorQueZero() {
		new Prato("Peixe", "Peixe com batata", -1.0);
	}

	@Test(expected = PedidoNaoEncontradoException.class)
	public void testBuscarPedidoForaDaLista() throws PedidoNaoEncontradoException {
		Gerenciador gerenciador = new Gerenciador();
		Prato prato = new Prato("Peixe", "Peixe com batata", 2.5);
		Cardapio cardapio = new Cardapio();
		cardapio.adicionaPrato(prato);
		Pedido pedido = new Pedido("Pedido 1");
		pedido.adicionaPrato(prato);
		try {
			gerenciador.buscarPedido(5);
		} catch (Exception e) {
			throw new PedidoNaoEncontradoException();
		}
	}

}
