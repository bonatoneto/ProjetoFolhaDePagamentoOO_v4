package persistencia;

import java.util.ArrayList;
import java.util.List;

import entidades.Folha;

public class DadosFolha {

    private static List<Folha> folhas = new ArrayList<Folha>();

    public static void incluirFolha(Folha folha) {
		folhas.add(folha);
	}
	
	public static Folha buscarFolha(Folha folha) {
		for(Folha itemFolha: folhas) {
			if(itemFolha.getNomeFuncionario().equals(folha.getNomeFuncionario()) && itemFolha.getAno() == folha.getAno() && itemFolha.getMes() == folha.getMes()) {
				return itemFolha;
			}
		}
		return null;
	}

	public static ArrayList<Folha> listarFolhasMesAno(Folha folha){
		List<Folha> folhasMesAno = new ArrayList<Folha>(); 
			for(Folha itemFolha: folhas) {
				if(itemFolha.getMes() == folha.getMes() && itemFolha.getAno() == folha.getAno()) {
					folhasMesAno.add(itemFolha);
				}
			} 
			return (ArrayList<Folha>) folhasMesAno;
	}
}