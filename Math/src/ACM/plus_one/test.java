package ACM.plus_one;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		/*
		plusOne thisClass = new plusOne();
		int[] a = {9,9,9};
		int[] result = thisClass.plusOne(a);
		System.out.println(Arrays.toString(result));
		*/
		test this_test = new test();
		int[] a = {9,8,9};
		this_test.plusOne(a);
		
	}
	
	public void test() {
		int[] a = {1,2,3};
		int length = a.length;
		int[] b = new int[length+1];
		b[0] = 1;
		System.out.println(Arrays.toString(b));
	}
	public int[] plusOne(int[] digits) {
        
	    int n = digits.length;
	    //循环n次，从后往前
	    for(int i=n-1; i>=0; i--) {
	        if(digits[i] < 9) {
	        	//当前值小于9，直接+1结束
	            digits[i]++;
	            return digits;
	        }
	        //不是9，此位变零后，循环，然后下一位要么小于9，加一；
	        //要么等于9变零；再不然，执行了n次，还是9，结束for循环，出去就是一个扩容，因为前面都是9进一变0
	        //所以只要在首位加1就可以了
	        digits[i] = 0;
	    }
	    //数组扩容，结果总是10000....
	    int[] newNumber = new int [n+1];
	    newNumber[0] = 1;
	    
	    return newNumber;
	}
}
