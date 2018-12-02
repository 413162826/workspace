package ACM.tiao_yue_you_xi;

public class Solution3 {
	/*public boolean canJump(int[] A) {
	    int max = 0;
	    for(int i=0;i<A.length;i++){
	        if(i>max) {return false;}
	        max = Math.max(A[i]+i,max);
	    }
	    return true;
	}*/

    
	public boolean canJump(int[] A) {
		//max:代表i前面的所有点能够走的最远距离
		int max = 0;
		//循环n次，判断前面的点能否到达驿站
		//i:代表第一个点到第i个点的距离
	    for (int i = 0; i < A.length; i++) {
			if(i>max) {
				return false;
			}
			max = Math.max(max, A[i]+i);
		}
	    return true;
	}
}
