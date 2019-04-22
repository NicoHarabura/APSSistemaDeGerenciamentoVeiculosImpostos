package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Automotor;
import entities.Carro;
import entities.Moto;
import entities.Picape;

public class GerenciarAutomotores {

	public static List<Automotor> automotores = new ArrayList<>();

	public static void adicionar(Automotor auto) {
		System.out.println("\nAUTOMOTOR ADICIONADO");
		System.out.println("--------------------------------------------");
		automotores.add(auto);
		buscarPorPlaca(auto.getPlaca());
	}

	public static boolean remover(String placa) {
		for (Automotor a : automotores) {
			if (a.getPlaca().equalsIgnoreCase(placa)) {
				System.out.println("\nAUTOMOTOR REMOVIDO");
				System.out.println("--------------------------------------------");
				return automotores.remove(a);
			}
		}
		System.out.println("\nAUTOMOTOR NÃO ENCONTRADO");
		System.out.println("--------------------------------------------");
		return false;
	}

	public static Automotor buscarPorPlaca(String placa) {
		for (Automotor a : automotores) {
			if (a.getPlaca().equalsIgnoreCase(placa)) {
				System.out.println("AUTOMOTOR ENCONTRADO");
				System.out.println(a);
				return a;
			}
		}
		System.out.println("AUTOMOTOR NÃO ENCONTRADO");
		return null;
	}

	public static String listarCarros() {
		for (Automotor a : automotores) {
			if (a instanceof Carro) {
				System.out.println(a);
				System.out.println("--------------------------------------------");
			}
		}
		return "";
	}

	public static String listarMotocicletas() {
		for (Automotor a : automotores) {
			if (a instanceof Moto) {
				System.out.println(a);
				System.out.println("--------------------------------------------");
			}
		}
		return "";
	}

	public static String listarPicape() {
		for (Automotor a : automotores) {
			if (a instanceof Picape) {
				System.out.println(a);
				System.out.println("--------------------------------------------");
			}
		}
		return "";
	}

	public static Double obetValorImposto(String placa) {
		for (Automotor a : automotores) {
			if (a.getPlaca().equalsIgnoreCase(placa)) {
				System.out.printf("Valor do imposto é de : R$%.2f", a.calcularImposto());
				return a.calcularImposto();
			}
		}
		System.out.println("AUTOMOTOR NÃO ENCONTRADO");
		return -1.00;
	}

	public static String listarCarroPorCombustível(String combustivel) {
		System.out.println("CARROS MOVIDOS À " + combustivel + ":");
		for (Automotor a : automotores) {
			if (a instanceof Carro && ((Carro) a).getCombustivel().equalsIgnoreCase(combustivel)) {
				System.out.println(a);
			}
		}
		automotores.size();
		return "";
	}

	public static String listarTudo() {
		for (Automotor a : automotores) {
			System.out.println(a.toString());
			System.out.println("--------------------------------------------");
		}
		return "";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("------------------BEM VINDO AO APS TAX SYSTEM------------------");
		System.out.println("---------------------------------------------------------------");
		int op = 9;
		while (op != 0) {
			// MENU PRINCIPAL
			System.out.println();
			System.out.println("Digite o número correspondente a opção desejada: ");
			System.out.println("1 - Cadastrar um novo automotor");
			System.out.println("2 - Remover um automotor");
			System.out.println("3 - Buscar pela placa");
			System.out.println("4 - Listar todos os Carros");
			System.out.println("5 - Listar todas as Motocicletas");
			System.out.println("6 - Listar todas as Picapes");
			System.out.println("7 - Calcular imposto sobre valor de mercado");
			System.out.println("8 - Filtrar carros por um determinado combustivél");
			System.out.println();
			System.out.println("Ou 0 - Para sair do sistema");
			op = sc.nextInt();
			while (op < 0 || op > 8) {
				System.out.println();
				System.out.println("-------------------OPÇÃO INVÁLIDA-------------------------");
				System.out.println();
				System.out.println("Digite o número correspondente a opção desejada: ");
				System.out.println("1 - Cadastrar um novo automotor");
				System.out.println("2 - Remover um automotor");
				System.out.println("3 - Buscar pela placa");
				System.out.println("4 - Listar todos os Carros");
				System.out.println("5 - Listar todas as Motocicletas");
				System.out.println("6 - Listar todas as Picapes");
				System.out.println("7 - Calcular imposto sobre valor de mercado");
				System.out.println("8 - Filtrar carros por um determinado combustivél");
				System.out.println();
				System.out.println("Ou 0 - Para sair do sistema");
				op = sc.nextInt();
			}
			
			// MENU FILTRAR POR COMBUSTIVEL
			while (op == 8){
				System.out.println("Digite o combustível desejado: ");
				sc.nextLine();
				String combustivel = sc.nextLine();
				listarCarroPorCombustível(combustivel);
				System.out.println();
				System.out.println("Gostaria de filtrar por outro tipo de combustível?\ns/n?");
				char sn = sc.next().charAt(0);
				if (sn == 's') {
					op = 8;
				} else {
					op = 9;
				}
			}

			// MENU CALCULAR IMPOSTO
			while (op == 7){
				System.out.println();
				System.out.println("Digite a placa: ");
				sc.nextLine();
				String placa = sc.nextLine();
				obetValorImposto(placa);
				System.out.println();
				System.out.println("Gostaria de buscar mais um automotor?\ns/n?");
				char sn = sc.next().charAt(0);
				if (sn == 's') {
					op = 7;
				} else {
					op = 9;
				}
			}
			
			// MENU LISTAR PICAPES
			if (op == 6) {
				listarPicape();
				op = 9;
			}

			// MENU LISTAR MOTOS
			if (op == 5) {
				listarMotocicletas();
				op = 9;
			}

			// MENU LISTAR CARROS
			if (op == 4) {
				listarCarros();
				op = 9;
			}

			// MENU BUSCAR PELA PLACA
			while (op == 3) {
				System.out.println();
				System.out.println("Digite a placa do Automotor: ");
				sc.nextLine();
				String placa = sc.nextLine();
				buscarPorPlaca(placa);
				System.out.println();
				System.out.println("Gostaria de buscar mais um automotor?\ns/n?");
				char sn = sc.next().charAt(0);
				if (sn == 's') {
					op = 3;
				} else {
					op = 9;
				}
			}

			// MENU REMOVER
			while (op == 2) {
				System.out.println();
				System.out.println("Digite a placa do Automotor: ");
				sc.nextLine();
				String placa = sc.nextLine();
				remover(placa);
				System.out.println();
				System.out.println("Gostaria de remover mais um automotor?\ns/n?");
				char sn = sc.next().charAt(0);
				if (sn == 's') {
					op = 2;
				} else {
					op = 9;
				}
			}

			// MENU ADICIONAR AUTO
			while (op == 1) {
				System.out.println();
				System.out.println("Digite o número correspondente a opção desejada: ");
				System.out.println("1 - Adicionar Carro: ");
				System.out.println("2 - Adicionar Motocicleta: ");
				System.out.println("3 - Adicionar Picape: ");
				System.out.println();
				System.out.println("Ou 0 - Para sair do sistema");
				op = sc.nextInt();
				while (op < 0 || op > 3) {
					System.out.println();
					System.out.println("-------------------OPÇÃO INVÁLIDA-------------------------");
					System.out.println();
					System.out.println("Digite o número correspondente a opção desejada: ");
					System.out.println("1 - Adicionar Carro: ");
					System.out.println("2 - Adicionar Motocicleta: ");
					System.out.println("3 - Adicionar Picape: ");
					System.out.println();
					System.out.println("Ou 0 - Para sair do sistema");
					op = sc.nextInt();
				}
				if (op == 1) {
					System.out.println();
					System.out.println("DIGITE OS DADOS DO CARRO---");
					System.out.println("Ano de fabricação: ");
					int anoDeFabricacao = sc.nextInt();
					System.out.println("Modelo: ");
					sc.nextLine();
					String modelo = sc.nextLine();
					System.out.println("Marca: ");
					String marca = sc.nextLine();
					System.out.println("Valor de mercado: ");
					double precoDeMercado = sc.nextDouble();
					System.out.println("Placa: ");
					sc.nextLine();
					String placa = sc.nextLine();
					System.out.println("Tipo de combustível: ");
					String combustivel = sc.nextLine();
					adicionar(new Carro(anoDeFabricacao, modelo, marca, precoDeMercado, placa, combustivel));
					System.out.println();
					System.out.println("Gostaria de adicionar mais um automotor?\ns/n?");
					char sn = sc.next().charAt(0);
					if (sn == 's') {
						op = 1;
					} else {
						op = 0;
					}
				}
				if (op == 2) {
					System.out.println();
					System.out.println("DIGITE OS DADOS DA MOTOCICLETA---");
					System.out.println("Ano de fabricação: ");
					int anoDeFabricacao = sc.nextInt();
					System.out.println("Modelo: ");
					sc.nextLine();
					String modelo = sc.nextLine();
					System.out.println("Marca: ");
					String marca = sc.nextLine();
					System.out.println("Valor de mercado: ");
					double precoDeMercado = sc.nextDouble();
					System.out.println("Placa: ");
					sc.nextLine();
					String placa = sc.nextLine();
					adicionar(new Moto(anoDeFabricacao, modelo, marca, precoDeMercado, placa));
					System.out.println();
					System.out.println("Gostaria de adicionar mais um automotor?\ns/n?");
					char sn = sc.next().charAt(0);
					if (sn == 's') {
						op = 1;
					} else {
						op = 0;
					}
				}
				if (op == 3) {
					System.out.println();
					System.out.println("DIGITE OS DADOS DA MOTOCICLETA---");
					System.out.println("Ano de fabricação: ");
					int anoDeFabricacao = sc.nextInt();
					System.out.println("Modelo: ");
					sc.nextLine();
					String modelo = sc.nextLine();
					System.out.println("Marca: ");
					String marca = sc.nextLine();
					System.out.println("Valor de mercado: ");
					double precoDeMercado = sc.nextDouble();
					System.out.println("Placa: ");
					sc.nextLine();
					String placa = sc.nextLine();
					System.out.println("Tipo de cabine (dupla ou simples): ");
					String cabine = sc.nextLine();
					adicionar(new Picape(anoDeFabricacao, modelo, marca, precoDeMercado, placa, cabine));
					System.out.println();
					System.out.println("Gostaria de adicionar mais um automotor?\ns/n?");
					char sn = sc.next().charAt(0);
					if (sn == 's') {
						op = 1;
					} else {
						op = 0;
					}
				}
				if (op == 0) {
					op = 9;
				}
			}
		}

		System.out.println("--------------OBRIGADO POR USAR O APS TAX SYSTEM----------------");
		sc.close();
	}
}
