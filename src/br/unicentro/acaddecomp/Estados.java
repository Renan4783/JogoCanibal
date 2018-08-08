package br.unicentro.acaddecomp;

import java.util.*;

public class Estados {

	//Atributos
	private int qtdeMissionariosLadoEsquerdo;
	private int qtdeCanibaisLadoEsquerdo;
	private int qtdeMissionariosLadoDireito;
	private int qtdeCanibaisLadoDireito;
	private boolean embarcacaoLadoEsquerdo = true;
	private Estados pai = null;

	// Construtor para os nós
	public Estados(Estados pai, int qtdeMissionariosLE, int qtdeCanibaisLE, int qtdeMissionariosLD, int qtdeCanibalLD, boolean lado) {
		this.qtdeMissionariosLadoEsquerdo = qtdeMissionariosLE;
		this.qtdeCanibaisLadoEsquerdo = qtdeCanibaisLE;
		this.qtdeMissionariosLadoDireito = qtdeMissionariosLD;
		this.qtdeCanibaisLadoDireito = qtdeCanibalLD;
		this.embarcacaoLadoEsquerdo = lado;
		this.pai = pai;
	}

	// Objetivo da busca
	public static boolean isEqual(Estados noatual) {
		if ((noatual.getQtdeMissionariosLadoEsquerdo() == 0) 
				&& (noatual.getQtdeCanibaisLadoEsquerdo() == 0) 
				&& (noatual.getQtdeMissionariosLadoDireito() == 3) 
				&& (noatual.getQtdeCanibaisLadoDireito() == 3)) {
			return true;
		} 
		return false;
	}

	// getters and setters
	public int getQtdeMissionariosLadoEsquerdo() {
		return qtdeMissionariosLadoEsquerdo;
	}

	public void setQtdeMissionariosLadoEsquerdo(int qtdeMissionariosLadoEsquerdo) {
		this.qtdeMissionariosLadoEsquerdo = qtdeMissionariosLadoEsquerdo;
	}

	public int getQtdeCanibaisLadoEsquerdo() {
		return qtdeCanibaisLadoEsquerdo;
	}

	public void setQtdeCanibaisLadoEsquerdo(int qtdeCanibaisLadoEsquerdo) {
		this.qtdeCanibaisLadoEsquerdo = qtdeCanibaisLadoEsquerdo;
	}

	public int getQtdeMissionariosLadoDireito() {
		return qtdeMissionariosLadoDireito;
	}

	public void setQtdeMissionariosLadoDireito(int qtdeMissionariosLadoDireito) {
		this.qtdeMissionariosLadoDireito = qtdeMissionariosLadoDireito;
	}

	public int getQtdeCanibaisLadoDireito() {
		return qtdeCanibaisLadoDireito;
	}

	public void setQtdeCanibaisLadoDireito(int qtdeCanibaisLadoDireito) {
		this.qtdeCanibaisLadoDireito = qtdeCanibaisLadoDireito;
	}

	public boolean isEmbarcacaoLadoEsquerdo() {
		return embarcacaoLadoEsquerdo;
	}

	public void setEmbarcacaoLadoEsquerdo(boolean embarcacaoLadoEsquerdo) {
		this.embarcacaoLadoEsquerdo = embarcacaoLadoEsquerdo;
	}

	public Estados getPai() {
		return pai;
	}

	public void setPai(Estados pai) {
		this.pai = pai;
	}

	// Mensagens
	public String toString() {
		return ("\n"
				+ "\n Missionarios esquerda = " + this.getQtdeMissionariosLadoEsquerdo() + 
				"\n Canibais esquerda = " + this.getQtdeCanibaisLadoEsquerdo() + 
				"\n Missionarios direita = " + this.getQtdeMissionariosLadoDireito() + 
				"\n Canibais direita = " + this.getQtdeCanibaisLadoDireito() + 
				"\n O barco está na margem Esquerda? " + this.isEmbarcacaoLadoEsquerdo());

	}

	//Papel de barco
	private Estados levar(Estados pai, int qtdeMissionarios, int qtdeCabinais){

		if (pai.isEmbarcacaoLadoEsquerdo()) {
			Estados novo = new Estados(pai, 
	                  			  pai.getQtdeMissionariosLadoEsquerdo() - qtdeMissionarios,
				                  pai.getQtdeCanibaisLadoEsquerdo() - qtdeCabinais,
								  pai.getQtdeMissionariosLadoDireito()  + qtdeMissionarios,
				                  pai.getQtdeCanibaisLadoDireito()  + qtdeCabinais,
								  !pai.isEmbarcacaoLadoEsquerdo());
		
			return novo;
		} else {
			Estados novo = new Estados(pai, 
	                  pai.getQtdeMissionariosLadoEsquerdo() + qtdeMissionarios,
	                  pai.getQtdeCanibaisLadoEsquerdo() + qtdeCabinais,
					  pai.getQtdeMissionariosLadoDireito()  - qtdeMissionarios,
	                  pai.getQtdeCanibaisLadoDireito()  - qtdeCabinais,
					  !pai.isEmbarcacaoLadoEsquerdo());
			return novo;
			
		}
	}
	
	//gera todos os filhos de X
	public List<Estados> gerarFilhos() {
		List<Estados> filhos = new LinkedList<>();
		filhos.add(levar(this, 1, 1));
		filhos.add(levar(this, 0, 1));
		filhos.add(levar(this, 1, 0));
		filhos.add(levar(this, 0, 2));
		filhos.add(levar(this, 2, 0));
		filhos = avaliarFilhos(filhos);
		//System.out.println("Ficaram...");
		//for (int i = 0; i < filhos.size(); i++) {
		//	Estados objeto = filhos.get(i);
		//	System.out.println(objeto);
		//}
		return filhos;
	}
	
	//Avalia os nós válidos e descarta os inválidos
	private List<Estados> avaliarFilhos(List<Estados> filhos) {
		for (int i = 0; i < filhos.size(); i++) {
			Estados objeto = filhos.get(i);

			if (objeto.getQtdeMissionariosLadoEsquerdo() < 0) {
				filhos.remove(i);
				i --;
			} else if (objeto.getQtdeCanibaisLadoEsquerdo() < 0) {
				filhos.remove(i);
				i --;
			} else if (objeto.getQtdeMissionariosLadoDireito() < 0) {
				filhos.remove(i);
			} else if (objeto.getQtdeCanibaisLadoDireito() < 0) {
				filhos.remove(i);
				i --;
			} else if ((objeto.getQtdeCanibaisLadoDireito() > objeto.getQtdeMissionariosLadoDireito()) 
					&& (objeto.getQtdeMissionariosLadoDireito() > 0)) {
				filhos.remove(i);
				i --;
			} else if ((objeto.getQtdeCanibaisLadoEsquerdo() > objeto.getQtdeMissionariosLadoEsquerdo()) 
					&& (objeto.getQtdeMissionariosLadoEsquerdo() > 0)){
				filhos.remove(i);
				i --;
			}
		}
		return filhos;
	}
	
}