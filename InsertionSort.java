package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sort {
	
	
	//@SuppressWarnings("unused")
	public static int[] insertion_sort (int[] array) {
		int i;
		for(int j = 1; j < array.length; j++) {
			int key = array[j];
			i = j - 1;
			while(i > 0 && (array[i] > key)) {
				array[i + 1] = array[i];
				i = i - 1;		
			}
			array[i] = key;
		}
		return array;
	}
	
	
	/*
	 * n: the size of the output array
	 * k: the maximum value in the array
	 */
	@SuppressWarnings("deprecation")
	public static int[] generate_random_array (int n, int k) {
		List<Integer> list;
		int[] array;
		Random rnd;
		
		rnd = new Random(System.currentTimeMillis());
		
		list = new ArrayList<Integer> ();
		for (int i = 1; i <= n; i++) 
			list.add(new Integer(rnd.nextInt(k+1)));
		
		Collections.shuffle(list, rnd);
		
		array = new int[n];
		for (int i = 0; i < n; i++) 
			array[i] = list.get(i).intValue();
		
		return array;
	}
	
	/*
	 * n: the size of the output array
	 */
	//@SuppressWarnings("deprecation")
	@SuppressWarnings("deprecation")
	public static int[] generate_random_array (int n) {
		List<Integer> list;
		int[] array;
		
		list = new ArrayList<Integer> ();
		for (int i = 1; i <= n; i++) 
			list.add(new Integer(i));
		
		Collections.shuffle(list, new Random(System.currentTimeMillis()));
		
		array = new int[n];
		for (int i = 0; i < n; i++) 
			array[i] = list.get(i).intValue();
		
		return array;
	}
	
	/*
	 * Input: an integer array
	 * Output: true if the array is acsendingly sorted, otherwise return false
	 */
	public static boolean check_sorted (int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i-1] > array[i])
				return false;
		}
		return true;
	}
	
	public static void print_array (int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + ", ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Insertion sort starts ------------------");
		for (int n = 100000; n <= 1000000; n=n+100000) {
			int[] array = Sort.generate_random_array(n);
			long t1 = System.currentTimeMillis();
			array = Sort.insertion_sort(array);
			long t2 = System.currentTimeMillis();
			long t = t2 - t1;
			boolean flag = Sort.check_sorted(array);
			System.out.println(n + "," + t + "," + flag);
		}
		System.out.println("Insertion sort ends ------------------");
	}

}
