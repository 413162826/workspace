package ACM.plus_one;

import java.util.Arrays;

/*
 * 问题:传入一个数，加一
 * 算法思路：数组满9进1，位数改变
 */
public class plusOne {
	public int[] plusOne(int[] digits) {
		/*
		 * //判断首位是否为0, if(digits[0] == 0) { return digits; }
		 */
		int[] retult = digits;
		//循环n次
		for (int i = digits.length-1; i >= 0; i--) {			
			//尾数加1
			digits[i] = digits[i] + 1;
			if(digits[i]!=10) {
				//不进一结，束
				retult = digits;
				return retult;
			}else {
				//进一，判断是否首位，是则数组扩容,此位变10变0，扩容为变1
				if(i == 0) {
					int[] array2 = Arrays.copyOf(digits, digits.length+1);
					array2[0] = 1;array2[1] = 0;
					for(int j = 2;j<array2.length;j++) {
						array2[j] = digits[j-1];
					}
					retult = array2;
					return retult;
				}else {
					digits[i] = 0;
				}
			}
		}
		return retult;
	}

	// 方法二
	// 困难：如何根据位数乘10000...
	// 报错，整型超出范围2的32次方，值大概2的10位数
	public int[] plusOne2(int[] digits) {
		String number = "";
		for (int i = 0; i < digits.length; i++) {
			number = number + String.valueOf(digits[i]);
		}
		int int_number = Integer.parseInt(number);
		int_number++;
		number = String.valueOf(int_number);
		int[] array = new int[number.length()];
		for (int i = 0; i < number.length(); i++) {
			array[i] = Integer.parseInt(number.substring(i, i + 1));
		}
		return array;

	}

}
