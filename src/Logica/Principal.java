package Logica;

import java.util.Scanner;
import visual.MenuPrincipal;

public class Principal {

	/**
	 * M�todo main - Com chamadas de Menu
	 * @param args
	 */
	public static void main(String[] args) {
             //   MenuPrincipal menu = new MenuPrincipal();
         
                
		Scanner sc = new Scanner(System.in);
		Gerenciador gerenciador = new Gerenciador();
		gerenciador.criaMesas(10);
		
		
		boolean programaFuncionando = true;
		int opcaoMenuPrincipal;
		do{
			menuPrincipal();
			validaInteiros(sc);
			opcaoMenuPrincipal = sc.nextInt();
			switch (opcaoMenuPrincipal) {
			case 1:
				gerenciador.cadastrarGarcom();
				break;
				
			case 2:
				try{
				gerenciador.adicionarPratoAoCardapio();
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
				break;
				
			case 3:
				gerenciador.verCardapio();
				
				break;
				
			case 4:
				try{
				gerenciador.adicionaPedido();
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
				break;
				
			case 5:
				gerenciador.listarPedidosEmAberto();
				break;
			case 6:
				gerenciador.adicionarPratoAPedidoEmAberto();
				break;
			case 7:
				gerenciador.verConsumoDePedidoEmAberto();
				break;
			case 8:
				gerenciador.fecharPedido();
				break;
			case 9:
				gerenciador.verificarMesasDisponiveis();
				break;
			case 0:
				programaFuncionando = false;
				System.out.println("Programa Encerrado!");
				break;
			default:
				System.out.println("Digite uma opcao v�lida!");
				break;
			}
			
		}while(programaFuncionando);
	}

	/**
	 * M�todo para validar entrada de usu�rio do tipo inteiro
	 * @param sc Recebe entrada do usu�rio
	 */
	private static void validaInteiros(Scanner sc) {
		while (!sc.hasNextInt()){
			System.out.println("Digite um numero valido");
			sc.next();
		}
	}
	
	/**
	 * M�todo para chamada do Menu Principal
	 */
	private static void menuPrincipal(){
		System.out.println("1 - CADASTRAR GAR�OM"+System.lineSeparator() 
				+"2 - ADICIONAR PRATO AO CARDAPIO" +System.lineSeparator() 
				+"3 - VER CARDAPIO"+System.lineSeparator()
				+"4 - REGISTRAR PEDIDOS"+System.lineSeparator()
				+"5 - LISTAR PEDIDOS EM ABERTO"+System.lineSeparator()
				+"6 - ADICIONAR PRATOS A  PEDIDOS EM ABERTO"+System.lineSeparator()
				+"7 - VER CONSUMO DE UM PEDIDO EM ABERTO"+System.lineSeparator()
				+"8 - FECHAR PEDIDO" + System.lineSeparator()
				+"9 - LISTAR MESAS DISPONIVEIS" + System.lineSeparator()
				+"0 - SAIR DO SISTEMA"+System.lineSeparator());
				
	}

}