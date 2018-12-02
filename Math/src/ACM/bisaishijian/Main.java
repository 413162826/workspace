package ACM.bisaishijian;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	/*
	 * 计算两个时间差的用了多少分钟
	 */
	public static void main(String[] args) {
		
		Main thisClass = new Main();
		List<Integer> list = new ArrayList<>();
		Scanner s = new Scanner(System.in);

		// 输入结束时间
		int a1 = 0;
		int b1 = 0;
		int c1 = 0;

			
		a1 = s.nextInt();
		b1 = s.nextInt();
		c1 = s.nextInt();
		list.add(thisClass.getTime(a1, b1, c1));
			
		
		/*int day = 0;
		int hour = 0;
		int min = 0;
		for (int i = 11; i <= 14; i++) {
			day = i;
			for (int j = 0; j <= 23; j++) {
				hour = j;
				for (int k = 0; k <= 59; k++) {
					min = k;
					System.out.print(day+" "+ hour+" "+min+"       ");
					System.out.println(thisClass.getTime(day, hour, min));
					
				}
			}
		}*/
		
			
		for (Integer integer : list) {
			System.out.println(integer);
		}
		s.close();
		
	}

	public int getTime(int a1, int b1, int c1) {
		// 输入开始时间
		final int a = 11;
		final int b = 11;
		final int c = 11;

		int result = 0;

		final int ONE_DAY_MIN = 1440;

		// 处理开始时间的余下时间
		// 开始时间的分钟形式
		int startTime = b * 60 + c;
		int startSurplusTime = ONE_DAY_MIN - startTime;
		// 结束时间用时
		int endTime = b1 * 60 + c1;
		// 日子差
		int dayDifferent = a1 - a;
		// 根据天数计算时间差
		if (a1 > a) {
			// 两天上
			result = (dayDifferent - 1) * ONE_DAY_MIN + startSurplusTime + endTime;
		}
		else {
			if (a1 == a && endTime >= startTime) {
				// 当天完成
				result = endTime - startTime;
			}else{
				// 提前结束
				result = -1;
			}
		}
		return result;
	}
	
	public static void test() {
		int day = 0;
		int hour = 0;
		int min = 0;
		for (int i = 11; i <= 14; i++) {
			day = i;
			for (int j = 0; j <= 23; j++) {
				hour = j;
				for (int k = 0; k <= 59; k++) {
					min = k;
					System.out.println(day+" "+ hour+" "+min);
				}
			}
		}
	}
}
