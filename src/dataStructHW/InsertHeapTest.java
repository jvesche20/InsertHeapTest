package dataStructHW;

import java.util.*;
import java.util.Scanner;



public class InsertHeapTest{
	public static void main(String[] args){
		Scanner filter = new Scanner(System.in);
	
		System.out.println("Enter the size of Binary Heap ");
		
		InsertHeap bh = new InsertHeap(filter.nextInt());
		
		
		char choicee;
		
		do {
			System.out.println("1. insert the one for inserting the element ");
			
			int choice = filter.nextInt();
			switch(choice)
			
			{
			case 1:	
				try{
					System.out.println("Insert the heap key value");
					bh.buildheapInsert(filter.nextInt());
				}
				catch (Exception f){
					System.out.println(f.getMessage());
				}
				break;
				default:
				System.out.println("Please enter right entry \n");
				
				break;
			}
			bh.DisplayHeap();
			
			System.out.println("\nStill Continue: y or n\n");
			
			choicee = filter.next().charAt(0);
		}while (choicee =='Y' || choicee == 'y');
	
	}
	
}


class InsertHeap{
	int builh = 2;
	int hlength;
	int[] lH;
	public InsertHeap(int size){
		
		hlength = 0;
		lH = new int[size + 1];
		Arrays.fill(lH, -1);
	}
	public boolean overflow(){
		return hlength == lH.length;
		
	}
		
	private int Proot(int b){
		
		return (b-1)/builh;
	}
		
	private int leaf(int b, int key){
		return builh * b + key;
	}
	
	public void buildheapInsert(int Ins){
		if (overflow())
			throw new NoSuchElementException("no place to data insert in the buldheap");
		lH[hlength++] = Ins;
		Buildupheap(hlength - 1);
	}
	
	private void Buildupheap(int c_leaf){
		
		int X = lH[c_leaf];
		
		while(c_leaf > 0 && X < lH[Proot(c_leaf)]){
			lH[c_leaf] = lH[Proot(c_leaf)];
			c_leaf = Proot(c_leaf);
		}
		lH[c_leaf] = X;
	}
	
	private void Builddownheap(int c_hdown){
		int child;
		int X = lH[c_hdown];
		
		int child1;
		int X1 = lH[c_hdown];
		
		
		
		while(leaf(c_hdown, 1) < hlength){
			
			child1 = smallestleaf(c_hdown);
			if(lH[child1] < X1)
				lH[c_hdown = lH[child1];
			else
				break;
			c_hdown = child1;
		}
		lH[c_hdown] = X1;
	}
	
	private int smallestleaf(int c_hdown){
		int B_leaf = leaf(c_hdown, 1);
		int key = 2;
		int pos = leaf(c_hdown, key);
		while((key <= builh) && (pos < hlength)){
		
		
			if(lH[pos] < lH[B_leaf])
				B_leaf = pos;
			pos = leaf(c_hdown, key++);
			
		}
		
		return B_leaf;
	}
	
	public void	DisplayHeap(){
		
		System.out.print("\nInsertbuildheap = ");
		
		for (int b = 0; b < hlength; b++)
			System.out.print(lH[b] + " ");
		System.out.println();
	}
}
