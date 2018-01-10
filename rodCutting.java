package RodCutting;

/* Rod cutting problem can be stated as:

Given a rod of length n inches and a table of prices Pi for
i = 1,2,......,n, determine the maximum revenue rn obtainable
by cutting up the rod and selling the pieces.
Note: if the price pn for a rod of length n is large enough, an
optimal solution may require no cutting at all. */

import java.util.Scanner;

public class rodCutting {
	//Function uses the bottom-up approach
	static int rodCut(int p[], int n){
		//Let r[] be new array
		int r[] = new int [n+1];
		r[0] = 0;
		
		for(int j=1; j<=n; j++){
			int q = Integer.MIN_VALUE;
			for (int i=1; i<=j; i++){
				q = Math.max(q, p[i] + r[j-i]);
			}
			r[j] = q;
		}
		return r[n];
	}

	//Main function
	public static void main(String[] args) {
		
		//Ask for input from user
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of entries in price array: ");
		int m = scan.nextInt();
		int p[] = new int[m];
		
		System.out.println("\nEnter price for " + m + " elements.");
		for (int i=0; i<m; i++){
			p[i] = scan.nextInt();
		}
		
		System.out.println("Enter the length of rod which should be less than size of price array: ");
		int n = scan.nextInt();
		
		//Print the maximum revenue
		System.out.println("\nMaximum revenue obtainable is: " + rodCut(p,n));
		scan.close();
	}
}
