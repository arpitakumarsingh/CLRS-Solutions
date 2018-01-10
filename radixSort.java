package RadixSort;

import java.util.*;

public class radixSort {

	static int getMax(int arr[],int n){
		int max = arr[0];
		for (int i=1; i<n; i++){
			if (arr[i] > max)
				max = arr[i];
			}
		return max;
	}
	
	static void countSort(int arr[], int n, int x){
		int []count = new int[10];
		int i;
		int output[] = new int[n];
		
		//Count the occurrence of elements
		for(i=0; i<n; i++){
			count[(arr[i]/x) % 10]++;
		}
		
		//Count the position for output
		for(i=1; i<10; i++){
			count[i] +=count[i-1];
		}
		
		//Put data to output
		for(i = n-1; i>= 0; i--){
			output[--count[ (arr[i]/x) % 10]] = arr[i];
		}
		
		for(i=0; i<n; i++){
			arr[i] = output[i];
		}
	}

	static void radix(int a[],int n){
		//Find the maximum element of Array
		int max = getMax(a,n);
		System.out.println("Max element: " + max);
		
		//Perform the count sort on Least Significant Digit.
		for(int x=1; max/x > 0; x=x*10){
			countSort(a,n,x);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n,i;
		System.out.println("Enter number of integers elements");
		n=scan.nextInt();
		int arr[] = new int[n];

		System.out.println("\n Enter " + n + " integer elements");
		for (i=0; i<n; i++){
			arr[i] = scan.nextInt();
		}
		
		radix(arr,n);
		
		System.out.println("\nElements after sorting ");
		for(i=0; i<n; i++){
			System.out.println(arr[i] + " ");
		}
		
		System.out.println();
		scan.close();
	}
}
