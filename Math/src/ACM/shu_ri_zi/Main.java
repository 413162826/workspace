package ACM.shu_ri_zi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main thisClass = new Main();
		List<Integer> list = new ArrayList<Integer>();
		
		Scanner s=new Scanner(System.in);
		String test_count = s.nextLine();
		int test_count_int = Integer.parseInt(test_count);
		for(int i =0;i<test_count_int;i++) {
			int day = thisClass.getDay(s);
			list.add(day);
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public int getDay(Scanner s) {
		int dd[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
		
		int days=0;
		String str=s.nextLine();
		String[] date=str.split("/");
		int y=Integer.parseInt(date[0]);
		int m=Integer.parseInt(date[1]);
		int d=Integer.parseInt(date[2]);
		if((y%400 == 0 || (y%4 == 0 && y%100 !=0)) && m>2) days ++; 
		days += d; 
		for(int i=0;i<m;i++){
		days += dd[i]; 
		} 
		return days; 
		
	}
}
