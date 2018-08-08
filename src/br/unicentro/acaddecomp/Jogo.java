package br.unicentro.acaddecomp;

import java.util.*;

public class Jogo {
	
	public boolean BuscaAmplitude(List<Estados> abertos, List<Estados> fechados, Estados inicial) {
		Estados noAtual;
		List<Estados> filhos;
		abertos.add(inicial);
		while (abertos.size() > 0) {
			noAtual = abertos.get(0);
			abertos.remove(0);
			if (Estados.isEqual(noAtual) == true) {
				return true;
			} else {
				filhos = noAtual.gerarFilhos();
				for (int i = 0; i<filhos.size(); i++){ 
					abertos.add(filhos.get(i));
				}
				fechados.add(noAtual);
				System.out.println("Nós abertos: " + abertos.size());
				System.out.println("Nós fechados: " + fechados.size());
			}
		}
		return false;
	}
	
	public boolean BuscaProfundidade(Stack<Estados> abertos, List<Estados> fechados, Estados inicial) {
		Estados noAtual;
		List<Estados> filhos;
		abertos.add(inicial);
		while (abertos.size() > 0) {
			noAtual = abertos.get(0);
			abertos.remove(0);
			if (Estados.isEqual(noAtual) == true) {
				return true;
			} else {
				filhos = noAtual.gerarFilhos();
				for (int i = 0; i<filhos.size(); i++){ 
					abertos.add(filhos.get(i));
				}
				fechados.add(noAtual);
				System.out.println("Nós abertos: " + abertos.size());
				System.out.println("Nós fechados: " + fechados.size());
			}
		}
		return false;
	}
}
