package br.edu.udc.guiFrames;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class JanelaEntrada extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JTextField nome;
	JPasswordField password;

	public JanelaEntrada() {
		/* WINDOW CONFIGS */
		
		super("Janela com campos de entrada");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		
		setLayout(new FlowLayout());
		
				
		/* NOME */	
		add(new JLabel("Usuario: "));
		nome = new JTextField(20);
		nome.setEditable(true);
		
			/* Implementa��o de classe an�nima */
		nome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = new String(((JTextField)e.getSource()).getText());
				
				JOptionPane.showMessageDialog(null, "Ol� " + str + ", como vai?");
			}
		});
		add(nome);
		
		
		/* PASSWORD */		
		add(new JLabel("Senha:"));
		password = new JPasswordField(20);
		password.setToolTipText("Senha Secreta");
		
			/* Implementa��o de classe an�nima */
		password.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = new String(((JPasswordField)e.getSource()).getPassword());
				
				JOptionPane.showMessageDialog(null, str);
			}
		});
		add(password);
		
		
		/* SEND BUTTON */
		JButton button = new JButton("Enviar");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, 
						"Usuario: " + nome.getText() + 
						"Senha: " + new String(password.getPassword()));
			}
		});
		add(button);
	
		
		/* SETVISIBLE */
		setVisible(true);
	}
	
}
