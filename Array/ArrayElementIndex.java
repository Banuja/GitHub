/**
2018
 Banu
 * 
 */
package edu.bcas.array;

/**
 * @author Banu
 *
 */
public class ArrayElementIndex {
	public static void main(String[] args) {
		char list[] = {'A','B','C','D'};
		int index =0;
		for (int i = 0; (i < list.length) && (index == 1); i++) {
			if(list[i]=='H') {
				index = i;
			}
		}
			System.out.println(index);
	}

}
