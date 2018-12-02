package 算法设计与分析.整数划分;

public class Main {
	/**
	 * 
	 * @Title: equationCount   
	 * @Description: TODO(統計數量)       
	 * @return: int
	 */
	public static int equationCount(int n,int m) {
		if(n==1||m==1)
			return 1;
			else if(n<m)
			return equationCount(n,n);
			else if(n==m)
			return 1+equationCount(n,n-1);
			    else
			return equationCount(n,m-1)+equationCount(n-m,m);
	}
	
	public static void main(String[] args) {
		int n = 9;//填需要整數劃分的值
		System.out.println(equationCount(n,n));
	}
}