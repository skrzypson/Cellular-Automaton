import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CellularAutoFrame extends JFrame{
	
	int count = 0;
	boolean start = false;
			
	public CellularAutoFrame(int a, int b, String label){
		
		int[][] matrix = new int[a][b];
		JFrame window = new JFrame();
		window.setSize(new Dimension(a,b));
		window.setTitle(label);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		
		CellularAuto_board mainPanel = new CellularAuto_board(matrix);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); //<-- NOT IN USE
		mainPanel.setSize(a,b);
		window.setContentPane(mainPanel);
		window.setVisible(true);
		mainPanel.setVisible(true);
		window.setResizable(false);
		
		
	}
	
	
}
