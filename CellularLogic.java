
public class CellularLogic {

	public static int[][] calculateMatrix(int[][] matrix){
		
		System.out.println("calculating matrix... ");
		int[][] newMatrix = new int[matrix.length][matrix[0].length];
		
		for(int i=0; i<matrix.length; i++){
			
			for(int j=0; j<matrix[i].length; j++){
				
				if(checkNeighborhood(i, j, matrix) == true){
					newMatrix[i][j] = 1;
				}
				else if (checkNeighborhood(i, j, matrix) != true){
					newMatrix[i][j] = 0;				
				}
			}
		}
		
		System.out.println("calculations finished!");
		return newMatrix;
	}
	
	// checks how many neighboring cells are populated and returns a boolean accordingly
	// x - x-axis location of cell; y - y-axis location of cell
	public static boolean checkNeighborhood(int x, int y, int u[][]){
		int[][] neighborhood = new int[3][3];
		int sum = 0;
		
		//if(x >= 1 && x <= u.length - 2 && y >= 1 && y < u.length - 2){
		
		
		for(int i = 0; i<neighborhood.length; i++){
				
			for(int j = 0; j<neighborhood[i].length; j++){
				
				try{
					neighborhood[i][j] = u[x-1+i][y-1+j];
					sum += neighborhood[i][j];
				}
				catch(ArrayIndexOutOfBoundsException e){
					continue;
				}
				
			}
		}
		
		return (sum == 1 || sum == 2) ? true : false;
		
	}
}
