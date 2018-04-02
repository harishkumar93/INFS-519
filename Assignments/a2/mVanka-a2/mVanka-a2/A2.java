/**
 * @author V.M.Harish Kumar		G# : G01029523
 * INFS 519
 * Spring 2017
 */

import java.io.*;
import java.util.*;
/**
 * Assignment 2 : Program on Asymptotic Notations like O(LogN), O(N), O(NLogN), O(N^2).
 */
public class A2
{
	/**
	 *@param takes an array of numbers as input.
	 *Method that performs Log(N) Operation.
	 */
	public static void opLogN(int[] n)
	{
		int x = 0, k = 0;
		int y = n.length - 1;
		int z = (x + y) / 2;
		while (x <= y) {
			if (k <= n[z]) {
				y = z - 1;
				z--;
			} else {
				x = z + 1;
				z++;
			}
		}	
	}
	
	/**
	 *@param takes an array of numbers as input.
	 *Method that performs (N) Operation.
	 */
	public static void opN(int[] n)
	{
		int count = 0;
		for (int i = 0; i < n.length; i++) {
			if (n[i] == count) {
				count += i;
				count++;
			}
		}
	}
	
	/**
	 *@param takes an array of numbers as input.
	 *Method that performs NLogN) Operation.
	 */
	public static void opNlogN(int[] n)
	{
		/* Algorithm Citation : http://softwareengineering.stackexchange.com/questions/297160/why-is-mergesort-olog-n */
		int size = n.length;
		if (size < 2) {
			return  ;
		}
		int mid = size / 2;
		int lSize = mid;
		int rSize = size - mid;
		/* Create temp arrays */
		int[] left = new int[lSize];
		int[] right = new int[rSize];
		/*Copy data to temp arrays*/
		for (int i = 0; i < mid; i++) {
			left[i] = n[i];
		}
		for (int i = mid; i < size; i++) {
			right[i - mid] = n[i];
		}
		opNlogN(left);
		opNlogN(right);
		merge(left, right, n);
	}
	public static void merge(int[] left, int[] right, int[] n) {
		int lSize = left.length;
		int rSize = right.length;
		int i = 0, j = 0, k = 0;
		while (i < lSize && j < rSize) {
			if (left[i] <= right[j]) {
				n[k++] = left[i++];
			} else {
				n[k++] = right[j++];
			}
		}
		while (i < lSize) {
			n[k++] = left[i++];
		}
		while (j < lSize) {
			n[k++] = right[j++];
		}
	}

	/**
	 *@param takes an array of numbers as input.
	 *Method that performs (N^2) Operation.
	 */
	public static void opNSquared(int[] n)
	{
		/* Algorithm Citation : https://en.wikipedia.org/wiki/Insertion_sort */
		int num = n.length;
		for (int j = 1; j < num; j++) {
			int key = n[j];
			int i = j - 1;
			while ((i > -1) && (n[i] > key)) {
				n[i + 1] = n[i];
				i--;
			}
			n[i + 1] = key;
		}

	}
	
	/**
	 *@throws IOException when you do not pass a filename. 
	 */
	public static void main(String[] args) throws IOException 
	{
	try {
			int[] numbers = null;
			List<Integer> list = new ArrayList<>();
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String temp = "";
			while ((temp = br.readLine()) != null) {
				list.add(Integer.parseInt(temp));
			}
			br.close();
			numbers = new int[list.size()];
			int k = 0;
			for (Integer i : list) {
				numbers[k] = i;
				k++;
			}
			System.out.println("Numbers : " + numbers.length);
			/* creating variables for calculating "Poor Man's Timer" Method. */
			long start = 0, end = 0, duration = 0; 

			// log(n)
			start = System.currentTimeMillis();
			opLogN(numbers);
			end = System.currentTimeMillis();
			duration = end - start;
			System.out.println("log(n) : " + duration + "ms");

			// n
			start = System.currentTimeMillis();
			opN(numbers);
			end = System.currentTimeMillis();
			duration = end - start;
			System.out.println("n : " + duration + "ms");

			// n log n
			start = System.currentTimeMillis();
			opNlogN(numbers);
			end = System.currentTimeMillis();
			duration = end - start;
			System.out.println("nlog(n) : " + duration + "ms");

			// n^2
			start = System.currentTimeMillis(); 
			opNSquared(numbers);
			end = System.currentTimeMillis();
			duration = end - start;
			System.out.println("n^2 : " + duration + "ms");

			// leave this in - using the array at the end
			System.out.println(numbers[0]);
		} 
		
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
}
