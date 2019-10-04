/******************************************
*Universidade Federal da Paraíba - UFPB
*Centro de Informática - CI
*
*Sistemas Operacionais 1 - 2016.2
*
*Aluno: Matheus Maranhão Rêgo Praxedes
*Matrícula: 11403744
*
*Trabalho 2
*Data de entrega: 21/05/2017
*******************************************/

import java.util.ArrayList;

public class Entradas{

	private int valor;

	public Entradas(int valor){

		this.valor = valor;
	}

	public void setValor(int valor){

		this.valor = valor;
	}
	
	public int getValor(){

		return valor;
	}

	public boolean equals(Object o){

		return ((Entradas)o).getValor() == this.valor; 
	}

}
