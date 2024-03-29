package guiMouseFrame;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JPanel mousePanel;
	
	public MouseFrame() {
		super("Tratamento dos eventos de mouse");
		
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		JLabel status = new JLabel("Mensagens de evento do mouse");
		add(status, BorderLayout.SOUTH);
		
		/* �REA DE USO DO MOUSE */
		mousePanel = new JPanel();
		add(mousePanel, BorderLayout.CENTER);
		mousePanel.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				status.setText(String.format("Click identificado no ponto [%d, %d]", arg0.getX(), arg0.getY() ));
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				status.setText("Mouse na tela");
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				status.setText("Mouse fora da tela");
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
			
			
		});
		mousePanel.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				
				
			}
			
		});
		

		
		setVisible(true);		
	}
}
