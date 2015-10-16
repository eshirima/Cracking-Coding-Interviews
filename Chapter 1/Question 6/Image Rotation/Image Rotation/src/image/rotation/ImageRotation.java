package image.rotation;

import java.util.Arrays;

/**
 *
 * @author Bonaparte
 */

public class ImageRotation {
    
    public static int[][] initializeMatrix(int[][]initialMatrix)
{
	int count = 1;
 
	for(int i = 0; i < initialMatrix.length; ++i)
	{
		for(int j = 0; j < initialMatrix.length; ++j)
		{
			if(count == 10)
			{
				count = 0;
			}
			initialMatrix[i][j] = count;
			++count;
		}
	}
        
        return initialMatrix;
}
    
    public static int[][] transposeMatrix(int[][]numbers)
{
	for(int row = 0; row <= numbers.length - 2; ++row)
	{
		for(int column = row + 1; column <= numbers.length - 1; ++column)
		{
			int temp = numbers[row][column];
			numbers[row][column] = numbers[column][row];
			numbers[column][row] = temp;
		}
	}
	return numbers;
}
    
    
    public static int[][] rotateBy90Degress(int[][]numbers)
    {
        int row = 0;
        while(row < numbers.length)
        {
            int start = 0, end = numbers.length - 1;
            while(start < end)
            {
                int temp = numbers[row][start];
                numbers[row][start] = numbers[row][end];
                numbers[row][end] = temp;
                ++start;
                --end;
            }
            ++row;
        }
        
        return numbers;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[][] matrix = new int[4][4];
        matrix = initializeMatrix(matrix);
        System.out.println(Arrays.deepToString(matrix));
        System.out.println("Transposed Array");
        System.out.println(Arrays.deepToString(transposeMatrix(matrix)));
        System.out.println("Rotated Array");
        System.out.println(Arrays.deepToString(rotateBy90Degress(matrix)));
        
        
    }
    
}