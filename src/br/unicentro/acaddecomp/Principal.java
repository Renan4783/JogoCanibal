package br.unicentro.acaddecomp;

import java.util.*;

public class Principal {
	public static void main(String[] args) {
		Stack<Estados> abertos = new Stack<>();
		List<Estados> fechados = new LinkedList<>();
		Estados inicial = new Estados(null, 3, 3, 0, 0, true);
		Jogo jogo1 = new Jogo();
		System.out.println(jogo1.BuscaProfundidade(abertos, fechados, inicial));
	}
}	
		/*
		 		List<Estados> abertos = new LinkedList<>();
		 
		List<Estados> fechados = new LinkedList<>();
		List<Estados> caminho = new Stack<>();
		
		Estados inicial = new Estados(3, 3, 0, 0);
		Estados no;
		
		inicial.BuscaAmplitude(abertos, fechados, inicial);
		
		
		if (inicial.BuscaAmplitude(abertos, fechados, inicial) == true){
			no = abertos.get(1);
			caminho.add(no);
			while (no.getPai() != null){
				caminho.add(no.getPai());
			}
		}
		
	}
}


public Estados getPai() {
	return pai;
}


private static boolean possoAdicionar(List<Estados> abertos, List<Estados> fechados, Estados ax) {
	Estados aux1, aux2;
	for (int i = 0; i < abertos.size();) {
		aux1 = abertos.get(i);
		//aux2 = fechados.get(i);
		if (aux1.missionario1 == ax.missionario1 && aux1.canibal1 == ax.canibal1) {
			return true;
		} else if (aux1.missionario2 == ax.missionario2 && aux1.canibal2 == ax.canibal2) {
			return true;
		} else {
			return false;
		}
	}
	return false;
}
*/