package br.edu.udc.comandosMouse;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ComandosMouse extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private Painel mousePanel;
	private String message;
	private String origin;
	private double r;
	private int originX, originY;
	private int radiusX, radiusY;
	
	/* Getters and Setters */
	
	public int getOriginX() {
		return originX;
	}

	public void setOriginX(int originX) {
		this.originX = originX;
	}

	public int getOriginY() {
		return originY;
	}

	public void setOriginY(int originY) {
		this.originY = originY;
	}

	public int getRadiusX() {
		return radiusX;
	}

	public void setRadiusX(int radiusX) {
		this.radiusX = radiusX;
	}

	public int getRadiusY() {
		return radiusY;
	}

	public void setRadiusY(int radiusY) {
		this.radiusY = radiusY;
	}
	
	/* Construtor */
	
	public ComandosMouse() {
		super("Tratamento dos eventos de mouse");
		
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		
		/* Menu Settings */
		
		JMenuBar menu = new JMenuBar();
		add(menu, BorderLayout.NORTH);
		
		JMenu desenhos = new JMenu("Desenhos");
		menu.add(desenhos);
		
		JMenuItem circulo = new JMenuItem("Circulo");
		desenhos.add(circulo);
		
		JMenuItem retangulo = new JMenuItem("Retangulo");
		desenhos.add(retangulo);
		

		/* Mensagens de Rodap� */
		
		JLabel status = new JLabel("Mensagens de evento do mouse");
		add(status, BorderLayout.SOUTH);
		
		
		/* Painel de Desenho */
		
		mousePanel = new Painel();
		add(mousePanel, BorderLayout.CENTER);
		mousePanel.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				originX = arg0.getX();
				originY = arg0.getY();
				origin = String.format("Origem: [%d; %d]", originX, originY);
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				mousePanel.setOriginX(originX);
				mousePanel.setOriginY(originY);
				mousePanel.setRadiusX(radiusX);
				mousePanel.setRadiusY(radiusY);
				mousePanel.setRadius((int) Math.abs(r));
				
				mousePanel.repaint();
				
			}
			
			
		});
		mousePanel.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent arg0) {
				radiusX = arg0.getX();
				radiusY = arg0.getY();
				
				int x = Math.abs(originX - radiusX);
				int y = Math.abs(originY - radiusY);
				
				r = Math.sqrt((x*x) + (y*y));
		
				double area = Math.PI * Math.sqrt(r*r);
						
				double circ = Math.PI * 2 * r;
				
				message = origin + " - " + String.format("Raio: [%d; %d][%.2f]", radiusX, radiusY, r)  + " - " + 
						String.format("Area: [%.2f]", area) + " - " + String.format("Circunferencia: [%.2f]", circ);
				
				status.setText(message);
				
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				message = String.format("Mouse na posi��o [%d; %d]", arg0.getX(), arg0.getY());
				status.setText(message);
				
			}
			
		});
		
		circulo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mousePanel.setOpcao(1);
				
			}
			
		});
		
		retangulo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mousePanel.setOpcao(2);
				
			}
			
		});

		
		setVisible(true);
	}
	
}

class Painel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private int originX, originY, radiusX, radiusY, radius;
	private int opcao;
	
	
	
	public int getOpcao() {
		return opcao;
	}



	public void setOpcao(int opcao) {
		this.opcao = opcao;
	}



	public int getOriginX() {
		return originX;
	}



	public void setOriginX(int originX) {
		this.originX = originX;
	}



	public int getOriginY() {
		return originY;
	}



	public void setOriginY(int originY) {
		this.originY = originY;
	}



	public int getRadiusX() {
		return radiusX;
	}



	public void setRadiusX(int radiusX) {
		this.radiusX = radiusX;
	}



	public int getRadiusY() {
		return radiusY;
	}



	public void setRadiusY(int radiusY) {
		this.radiusY = radiusY;
	}

	

	public int getRadius() {
		return radius;
	}



	public void setRadius(int radius) {
		this.radius = radius;
	}



	public void paint(Graphics g) {
		super.paintComponent(g);
		
		switch(opcao){
			/* C�rculo */
			case 1:{
				int x = originX - radius;
				int y = originY - radius;
				
				g.drawOval(x, y, radius*2, radius*2);
				break;
			}
			/* Ret�ngulo */
			case 2:{
				if (originX < radiusX){
					if (originY < radiusY)
						g.drawRect(originX, originY, radiusX-originX, radiusY-originY);
					
					else 
						g.drawRect(originX, radiusY, radiusX-originX, originY-radiusY);
				}
				else{
					if (originY < radiusY)
						g.drawRect(radiusX, originY, originX-radiusX, radiusY-originY);
					
					else 
						g.drawRect(radiusX, radiusY, originX-radiusX, originY-radiusY);
				}
				break;
			}
		}
		
		
		
		//g.drawLine(originX, originY, radiusX, radiusY);
		//
		
	}
}