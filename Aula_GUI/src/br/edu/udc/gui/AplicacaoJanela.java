package br.edu.udc.gui;

import javax.swing.JFrame;

public class AplicacaoJanela {

	public static void main(String[] args) {
		Janela janela = new Janela();
		
		/* esses tr�s comandos podem ser colocados dentro do construtor, caso contr�rio � necess�rio determinar
		o tamanho sempre. */
		janela.setSize(300, 300); // determina o tamanho da janela
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // bot�o para fechar a janela
		janela.setVisible(true); //habilita a janela para ser visivel

	}

}