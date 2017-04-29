// Input:
// n = 3
// pairs[] = {1->3, 2->6, 4->5} // 1 is partner of 3 and so on
// arr[] = {3, 5, 6, 4, 1, 2}

// Output: 2
// We can get {3, 1, 5, 4, 6, 2} by swapping 5 & 6, and 6 & 1

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.io.FileInputStream;


public class MinSwapPairs {
    Map<Integer, Integer> pairs = new HashMap();
	Map<Integer, Integer> indexs = new HashMap();
	private void swap(int[] nums, int x, int y){
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
	private int DFS(int s, int len, int[] nums) {
		if ( s >= len ) return 0;
		int ret = Integer.MAX_VALUE;
		int num0 = nums[s], num1 = nums[s+1];
		int p0 = pairs.get(num0), p1 = pairs.get(num1);
		int p0_i = indexs.get(p0), p1_i = indexs.get(p1);
		if ( (num1 == p0) || (num0 == p1) ) return DFS(s+2, len, nums);
		swap(nums, s+1, p0_i);
		indexs.put(num1, p0_i);
		indexs.put(p0, s+1);
		ret = Math.min(ret, DFS(s+2, len, nums) );
		swap(nums, s+1, p0_i);
		indexs.put(num1, s+1);
		indexs.put(p0, p0_i);

		swap(nums, s, p1_i);
		indexs.put(num0, p1_i);
		indexs.put(p1, s);
		ret = Math.min(ret, DFS(s+2, len, nums) );
		swap(nums, s, p1_i);
		indexs.put(num0, s);
		indexs.put(p1, p1_i);
		return ret+1;
	}
	public int minSwapPairs(int[][] pars, int[] nums, int n ){
		if (pars == null || nums == null || pars.length == 0 
				|| nums.length ==0 || n == 0) return 0;
		for (int[] par : pars) {
			pairs.put(par[0], par[1]);
			pairs.put(par[1], par[0]);
		}
		for (int i=0; i< (2*n); i++) {
			indexs.put(nums[i], i);
		}
		return DFS(0, 2*n, nums);
	}
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int[][] pairs = {{1,3},{2,6},{4,5}};
		int[] nums = {1, 2, 3, 4, 5, 6};
		MinSwapPairs sol = new MinSwapPairs();
		System.out.println(sol.minSwapPairs(pairs, nums, pairs.length));
	}
}


// Input (stdin)
// 4
// 2 5 3 1
// Your Output (stdout)
// 2
// Expected Output
// 2
