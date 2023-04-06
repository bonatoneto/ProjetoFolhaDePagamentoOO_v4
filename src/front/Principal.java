package front;

import java.util.ArrayList;
import java.util.List;

import entidades.Folha;
import negocio.FolhaNegocio;
import persistencia.DadosFolha;

public class Principal {
	public static void main(String[] args) {
		int opcao;
		float bruto, ir, inss, fgts, salarioLiquido, total;
		Folha folha = null;
		do {
			System.out.println("****MENU****");
			System.out.println("1 - Cadastro da folha");
			System.out.println("2 - Consultar folha");
			System.out.println("3 - Listar folha");
			System.out.println("4 - Sair");
			opcao = Console.readInt("Informe a opcao desejedada: ");
			System.out.println("------------------------------------");
			switch (opcao) {
			case 1: 
				folha = new Folha();
				System.out.println("****CADASTRO DE FOLHA****");
				folha.setNomeFuncionario(Console.readString("Infome o nome do funcionario: "));
				folha.setAno(Console.readInt("Infome o ano: "));
				folha.setMes(Console.readInt("Infome o mes: "));
				if (DadosFolha.buscarFolha(folha) == null) {
					folha.setNumHorasTrabalhadas(Console.readInt("Informe o numero de horas trabalhadas: "));
					folha.setValorHora(Console.readFloat("Informe o valor da hora: "));
					DadosFolha.incluirFolha(folha);
					System.out.println("------------------------------------");
				} else {
					System.out.println("Folha ja cadastrada!!");
					System.out.println("------------------------------------");
					}
				break;
			case 2:
				System.out.println("****CONSULTAR FOLHA****");
				folha = new Folha();
				folha.setNomeFuncionario(Console.readString("Infome o nome do funcionario que deseja consultar: "));
				folha.setAno(Console.readInt("Infome o ano: "));
				folha.setMes(Console.readInt("Infome o mes: "));
				System.out.println("------------------------------------");
				folha = DadosFolha.buscarFolha(folha);
				if (folha != null) {
					System.out.println("Nome: " + folha.getNomeFuncionario());
					System.out.println("Mes: " +folha.getMes());
					System.out.println("Ano: " + folha.getAno());
					System.out.println("Horas trabalhadas: " + folha.getNumHorasTrabalhadas());
					System.out.println("Valor hora: " + folha.getValorHora());
					bruto = FolhaNegocio.calculaSalarioBruto(folha);
					System.out.println("Salario bruto: " + bruto);
					ir = FolhaNegocio.calculaIR(bruto);
					System.out.println("Imposto de renda: " + ir);
					inss = FolhaNegocio.calculaINSS(bruto);
					System.out.println("INSS: " + inss);
					fgts = FolhaNegocio.calculaFGTS(bruto);
					System.out.println("FGTS: " + fgts);
					salarioLiquido = FolhaNegocio.calculaSalarioLiquido(bruto, ir, inss);
					System.out.println("Salario liquido: " + salarioLiquido);
					System.out.println("------------------------------------");
				} else {
					System.out.println("Para consultar a folha e necessario ter informado os dados anteriormente!");
					System.out.println("------------------------------------");
				}
				break;
			case 3:
				List<Folha> resultadoBusca = new ArrayList<Folha>();
				folha = new Folha();
				folha.setAno(Console.readInt("informe o ano: "));
				folha.setMes(Console.readInt("Informe o mes: "));
				total = 0;
				resultadoBusca = DadosFolha.listarFolhasMesAno(folha);
				System.out.println("------------------------------------");
				for(Folha itemFolha: resultadoBusca) {
					System.out.println("Nome do Funcionario: " + itemFolha.getNomeFuncionario());
					bruto = FolhaNegocio.calculaSalarioBruto(itemFolha);
					ir = FolhaNegocio.calculaIR(bruto);
					inss = FolhaNegocio.calculaINSS(bruto);
					salarioLiquido = FolhaNegocio.calculaSalarioLiquido(bruto, ir, inss);
					System.out.println("Salario liquido: " + salarioLiquido);
					total += salarioLiquido;
					System.out.println("------------------------------------");
				}
				System.out.println("Total: " + total);
				System.out.println("------------------------------------");
			}	
		} while (opcao != 4);
	}
}