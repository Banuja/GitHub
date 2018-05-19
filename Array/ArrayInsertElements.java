/**
2018
 Banu
 * 
 */
package edu.bcas.array;

import java.util.Scanner;

/**
 * @author Banu
 *
 */
public class ArrayInsertElements {
	public static void main(String[] args) {
		int x,y,z;
		Scanner s = new Scanner(System.in);
		System.out.println("enter elements to add in array :");
		x=s.nextInt();
		int a[]=new int[x+1];
		System.out.println("enter all the elements:");
		for(int i = 0;i <x;i++) {
			a[i]=s.nextInt();
		}
		System.out.println("enterwhere you want to insert:");
		y=s.nextInt();
		System.out.println("enter the elemet you want to insert");
		z=s.nextInt();
		for(int i = (x-1);i>=(y-1);i--) {
			a[i+1] = a[i];
		}
		a[y-1]=x;
		System.out.println("after inserting");
		for(int i = 0; i<x;i++) {
			System.out.println(a[i]+",");
		}
		System.out.println(a[x]);
	}

}
