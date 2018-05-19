/**
2018
 Banu
 * 
 */
package edu.bcas.array;

import java.util.Arrays;

/**
 * @author Banu
 *
 */
public class ArrayElementRemove {

	static int removeElement(int[]arr,int elem) {
			int length = 0;
			System.out.println(Arrays.toString(arr));
			public static void main(String[] args){
			for (int i =0; i<arr.length;i++) {
			if(arr[i]!= elem) arr[length++]=arr[i];
			}
			
			System.out.println(Arrays.toString(Arrays.copyOf(arr, length)));
			return length;
			}

	}
}
