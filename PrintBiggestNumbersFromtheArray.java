// This is the basic program to print biggest number from the array, but if in the right side of the array is big number 
// from our current number skip it from printing ,else in the right no number is bigger then current number so print it.

// Ex : 3,5203,3,6,7,8,1,2,23,54,232,554,879,0

// in this array we need to start comparing numbers from 3 and we will go till 0, 
// if we found any bigger number then 3 in right side we will skip it and move to next element.

// Output : 5203,879,0

// it printing 0 also because there is no number in the right side of 0 so its the biggest.


public class PrintBiggest {
	public static void main(String[] args) {
		int[] arr = {3,5203,3,6,7,8,1,2,23,54,232,554,879,0};
		boolean flag;
		for(int i = 0; i < arr.length; i++) {
			flag = true;
			for(int j = i; j < arr.length; j++) {
				if(arr[i] < arr[j]) {
					flag = false;
					break;
				}
			}
			if(flag)System.out.println(arr[i]);
		}
	}
}