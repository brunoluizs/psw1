package br.edu.udc.gui;

import javax.swing.JFrame;

public class AplicacaoJanela {

	public static void main(String[] args) {
		Janela janela = new Janela();
		
		/* esses três comandos podem ser colocados dentro do construtor, caso contrário é necessário determinar
		o tamanho sempre. */
		janela.setSize(300, 300); // determina o tamanho da janela
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // botão para fechar a janela
		janela.setVisible(true); //habilita a janela para ser visivel

	}

}