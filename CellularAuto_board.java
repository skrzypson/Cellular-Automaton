import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CellularAuto_board extends JPanel{
	
	static int[][] matrix;
	static int[][] prevMatrix;
	int count;
	public CellularAuto_board(int[][] matrix){
		
		CellularAuto_board.matrix = matrix;
		prevMatrix = matrix;
		
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				int q1 = 0; int q2 = 0;
				
				if (SwingUtilities.isLeftMouseButton(e)){
					
					q1 = e.getX();
					q2 = e.getY();
					//CellularAuto_board.matrix[q1][q2] = 1;
					for(int i = 0; i<3; i++){
						
						for(int j = 0; j<3; j++){
							
							try{
								CellularAuto_board.matrix[q1-1+i][q2-1+j] = 1;
							}
							catch(ArrayIndexOutOfBoundsException y){
								continue;
							}
							
						}
					}
					repaint();
				}
				if (SwingUtilities.isRightMouseButton(e)){
					System.out.println("GROWTH INITIATED");
					count = 0;
			        while (count < 5){		
						
						try{
							CellularAuto_board.matrix = CellularLogic.calculateMatrix(CellularAuto_board.matrix);
							paintJob();
							count++;
							System.out.println("pause" + count);
							Thread.sleep(0);
								
						}
						catch(InterruptedException i){
							
						}
					
						prevMatrix = CellularAuto_board.matrix;
						
					}
			        
				}
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			});
				
	}
	
	public void paintJob(){
		this.paint(this.getGraphics());
	}
	
	public void paint(Graphics g){
		
		for(int i = 0; i<CellularAuto_board.matrix.length; i++){
					
			for(int j = 0; j<CellularAuto_board.matrix[i].length; j++){
					
				if (CellularAuto_board.matrix[i][j] == 0 && prevMatrix[i][j] == 1){
							
					g.setColor(Color.YELLOW);
					g.drawLine(i, j, i, j);

				}
						
				else if (CellularAuto_board.matrix[i][j] == 1 && prevMatrix[i][j] == 0){
							
					g.setColor(Color.BLACK);
					g.drawLine(i, j, i, j);
				}
			}
		}
				
		System.out.print("yo");
	}
	
}
