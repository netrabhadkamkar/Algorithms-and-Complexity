/*Implements Significant Inversion Problem
 * Reference: Section 5.3 Algorithm and Design by Jon Kleinberg and Eva Tardos.pdf*/
import java.util.*;

public class NetraBhadkamkarInversion {
	
public static int inversions=0;
	
public int[] sortAndCount(int[] L) {
	  int n = L.length;
	  if(n == 1) {
	    return L;
	  }
	  int half = n/2;
	  int[] A = new int[half];
	  int[] B = new int[n - half];
	  int k=0;
	  
	  for(int i=0; i<A.length; i++)
	  {
		  A[i] = L[i];
	  }
	  
	  System.arraycopy(L, A.length, B, 0, B.length);
	  sortAndCount(A);
	  sortAndCount(B);
	  mergeAndCount(A, B, L);
	  return L;
	}

public void mergeAndCount(int[] A, int[] B, int[] sorted)
	{
		
	  int ALength = A.length;
	  int BLength = B.length;
	  int i = 0;
	  int j = 0;
	  int k = 0;
	  while(i < ALength && j < BLength) {
	    if(A[i] < B[j]) {
	      sorted[k] = A[i];
	      i++;
	    } else {
	      sorted[k] = B[j];
	      j++;
	      inversions+= (A.length-i);
	    }
	    k++;
	  }
	  
	 while(i < ALength) {
	    sorted[k] = A[i];
	    i++;
	    k++;
	  }
	  while(j < BLength) {
	    sorted[k] = B[j];
	    j++;
	    k++;
	  }
	}

public static void main(String args[])
		{
			
			int[] SortedArray;
			Scanner s=new Scanner(System.in);
			System.out.println("Enter number of Elements: ");
			int n=s.nextInt();
			int arr[]=new int[n];
			
			System.out.println("Enter Elements: ");
			for(int i=0;i<n;i++)
			{
		        arr[i]=s.nextInt();
		    }
			
		    NetraBhadkamkarInversion nb = new NetraBhadkamkarInversion();
		    SortedArray = nb.sortAndCount(arr);
		    System.out.println("Sorted Array: " );
			for(int i=0;i<SortedArray.length;i++)
			{
				System.out.println(SortedArray[i]+" ");
			}
			System.out.println("Number of Significant inversions = "+inversions);
		}
}
	


