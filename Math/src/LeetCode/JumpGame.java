package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class JumpGame {

/*	public static List<Integer> transfer(int[] nums) {
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			int j = nums[i];
			Integer jInteger = j;
			list.add(jInteger);
		}
		System.out.println(list.size());
		return list;
	}*/
	
	public static int check(int[] a,int n) {
		int i = 0;
		int p = 0;
		if(n>0) {
			for(i=n-1;i>=0;i--) {
				if (a[i]<n-1) {
					if (a[i]==0) {
						return 0;
					}else {
						check(a, i);
					}
				}else {
					p++;
				}
			}
		}else {
			p++;
		}
		return p;
	}
	
	
	public static void main(String[] args) {
		int[] a = {3,2,1,0,4};
		for (int i = 0; i < a.length; i++) {
			if (check(a, i+1) > 0) {
				System.out.println("true");
			}else {
				System.out.println("false");
			}
		}
	}
}
