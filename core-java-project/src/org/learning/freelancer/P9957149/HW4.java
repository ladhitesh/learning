package org.learning.freelancer.P9957149;

import java.util.Scanner;

public class HW4 {

	private static int n;

	public static boolean[][] ReadValues(int n) {
		// create an array of booleans , read the values from System.in and
		// return the array
		boolean[][] input = new boolean[n][n];
		return input;
	}

	public static void PrintValues(boolean[][] a) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.format("%s ",a[i][j]);
			}
			System.out.format("%n");
		}
	}

	public static boolean[][] BoolOr(boolean[][] a, boolean[][] b) {
		// create a new boolean array and perform an element-element logical OR
		// between the a and b arrays .

		boolean[][] sum = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum[i][j] = a[i][j] || b[i][j];
			}

		}

		return sum;

	}

	//public static boolean[][] BoolAnd(boolean[][] a, boolean[][] b) {
	//	// Similar to BoolOr except a logical and is performed
	//}

	public static boolean[][] BoolMultiply(boolean[][] a, boolean[][] b) {
		// Just like multiplying two square matrices , except using logical or
		// in place of addition and a logical and in place of multiplication
		boolean[][] multiply = new boolean[n][n];
		boolean sum = true;
		 for ( int i = 0 ; i < n ; i++ )
         {
            for ( int j = 0 ; j < n ; j++ )
            {   
               for ( int k = 0 ; k < n ; k++ )
               {
                  sum = (k==0?(a[i][k]&&b[k][j]):sum || (a[i][k]&&b[k][j]));
               }
 
               multiply[i][j] = sum;
               sum = true;
            }
         }
		 return multiply;

	}

	public static void main(String[] args) {
		n= 4;
		boolean graph[][] = new boolean[][] { {true, true, false, true }, { false, true, true, false },
				{ false, false, true, true }, { false, false, false, true } };
		
		boolean[][] result = new boolean[n][n];
		boolean[][] multiply = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				multiply[i][j]=graph[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j]=graph[i][j];
			}
		}
		
		for (int i = 1; i <= n; i++) {
			
			for (int j = 2; j < i; j++) {
				multiply = BoolMultiply(multiply, graph);
			}
			
			result = BoolOr(result, multiply);
		}
		
		PrintValues(result);
	}
}