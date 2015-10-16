package image.rotation;

import java.util.Arrays;

/**
 * PROGRAM ANALYSIS:
 * Runtime O(n^2)
 * Space O(n)
 * Out-Of-Place
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
//    Given a NXN matrix, each row's element is reversed
//    PRE: The matrix should not be empty
//    POST: Returned matrix is of NXN size with swaped row contents
    public static int[][] reverseRow(int[][]numbers)
    {
        int row = 0;
            while(row < numbers.length)
            {
                int start = 0, end = numbers.length - 1;
                while(start < end)
                {
                    // swaps contents pretty much
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
//    Given a NXN matrix, each column's element is reversed
//    PRE: The matrix should not be empty
//    POST: Returned matrix is of NXN size with swaped column contents
    public static int[][] reverseColumn(int[][]numbers)
    {
         int column = 0;
         while(column < numbers.length)
         {
             int start = 0, end = numbers.length - 1;
             while(start < end)
             {
                 int temp = numbers[start][column];
                 numbers[start][column] = numbers[end][column];
                 numbers[end][column] = temp;
                 ++start;
                 --end;
             }
             ++column;
         }
        return numbers;
    }
//    Given a NXN matrix, each row becomes a column and each column becomes a row
//    PRE: The matrix should not be empty
//    POST: Returned matrix is of NXN size with swaped columns and rows respectively
    
    public static int[][] transposeMatrix(int[][]numbers)
{
	for(int row = 0; row < numbers.length; ++row)
	{
		for(int column = row + 1; column < numbers.length; ++column)
		{
			int temp = numbers[row][column];
			numbers[row][column] = numbers[column][row];
			numbers[column][row] = temp;
		}
	}
	return numbers;
}
    
//    PRE: The array is not empty
//    POST: Return a NXN matrix rotated 90 Degress anti-clockwise
//    PSEUDO: Transpose given array first, then reverse each row
    public static int[][] rotateBy90Degress(int[][]numbers, int numberOfRotations)
    {
        while(numberOfRotations > 0) // handles the number of times to rotate the matrix
        {
            numbers = transposeMatrix(numbers);
            numbers = reverseRow(numbers);
            --numberOfRotations; 
        }
        
        return numbers;
    }
    
//    PRE: The array is not empty
//    POST: Return a NXN matrix rotated 90 Degress clockwise
//    PSEUDO: Transpose given array first, then reverse each column
    public static int[][] rotateByNeg90Degress(int[][]numbers, int numberOfRotations)
    {
        while(numberOfRotations > 0) // handles number of times to rotate by -90 degrees
        {
            numbers = transposeMatrix(numbers);
            numbers = reverseColumn(numbers);
            --numberOfRotations;  
        }
        return numbers;
    }
    
//    PRE: The array is not empty
//    POST: Return a NXN matrix rotated 90 Degress anti-clockwise
//    METHODS: 1: Rotate matrix by 90 Degress twice
//             2: Reverse each row FIRST then column
    public static int[][] rotateBy180Degrees(int[][]numbers)
    {
        numbers = rotateBy90Degress(numbers, 2);
        
        // METHOD 2 IMPLEMENTATION
//        numbers = reverseRow(numbers);
//        numbers = reverseColumn(numbers);
        
        return numbers;
    }
    
//    PRE: The array is not empty
//    POST: Return a NXN matrix rotated 90 Degress anti-clockwise
//    METHODS: 1: Rotate matrix by -90 Degress twice
//             2: Reverse each column FIRST then row
//             3: Finally reverse by 180
    public static int[][] rotateByNeg180Degrees(int[][]numbers)
    {
        numbers = rotateByNeg90Degress(numbers, 2);
        
//        METHOD 2 IMPLEMENTATION
//        numbers = reverseColumn(numbers);
//        numbers = reverseRow(numbers);
        
//        METHOD 3 IMPLEMENTATION
//        numbers = rotateBy180Degrees(numbers);
        return numbers;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[][] matrix = new int[4][4];
        matrix = initializeMatrix(matrix);
        System.out.println(Arrays.deepToString(matrix));
        
        System.out.println("Rotated by 90");
        System.out.println(Arrays.deepToString(rotateBy90Degress(matrix, 1)));
        
        // EXTRA EXERCISE RUNS. NOT QUESTION RELATED
        System.out.println("Rotated by -90");
        System.out.println(Arrays.deepToString(rotateByNeg90Degress(matrix,1)));
        
        System.out.println("Rotated by 180");
        System.out.println(Arrays.deepToString(rotateBy180Degrees(matrix)));
        
        System.out.println("Rotate by -180");
        System.out.println(Arrays.deepToString(rotateByNeg180Degrees(matrix)));
    }
}