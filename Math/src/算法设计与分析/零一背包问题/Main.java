package 算法设计与分析.零一背包问题;

public class Main {

	public static void main(String[] args) {
		//背包容量
		int pakBig = 13;
		//背包容量+1（这里的容量是12，0，1,2,3....12  一共13数组容量，但是其实背包容量是12）
		pakBig++;
		//物品的价值和重量（默认第0个没有价值，方便客官查看）
		int[] v = {0,4,6,4,5,4,6}; 
		int[] w = {0,3,2,2,6,5,4}; 
		//背包每个阶段的价值
		int[][] m = new int[v.length][pakBig];
		
		for(int i=1;i<v.length;i++)  
	    {  //每个阶段的大小都考虑有没有装
	        for(int j=1;j<pakBig;j++)
	        {  
	            if(j>=w[i])  {
	            	//物品能放进去
	            	m[i][j]=max(m[i-1][j],m[i-1][j-w[i]]+v[i]);  
	            }
	            else  {
	            	//物品太大，放不进
	                m[i][j]=m[i-1][j];  
	            }
	        }  
	    }  
	  
	    for(int i=1;i<v.length;i++)  
	    {  
	        for(int j=1;j<pakBig;j++)  
	        {  
	        	System.out.print(m[i][j]+" ");
	        }  
	        System.out.println();
	    }
	}
	public static int max(int a, int b) {
		int result = 0;
		if(a > b) {
			result = a;
		}else {
			result = b;
		}
		return result;
	}
}
