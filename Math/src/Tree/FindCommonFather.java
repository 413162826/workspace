package Tree;

public class FindCommonFather {
	/*
	 * 在满二叉树，找出a和b的共同父亲，且取深度最大的父亲
	 * 环境：给二叉树编号，1,2,3,4,5...
	 * 算法：这道题因为说了是满二叉树，所以父节点的编号是孩子节点的编号除以2，
	 * 		两个节点的编号那个大就除2，直到有一个时刻两个节点的编号第一次相等，这就是最近的公共祖先编号。
	 */
	public static int findFather(int a, int b ) {
		System.out.println("====进入方法====");
		//必须大于，不然不能除2
		while(a>=1 && b>=1) {
			//如果相同，则得到目标祖先
			if(a==b) {
				System.out.println("节点a和节点b的最深公共祖先:"+a);
				return a;
			}
			//让较大的先数除2,除完比较a==b
			if(a>b) {
				a = a/2;
			}else if(a<b) {
				b = b/2;
			}
		}
		System.out.println("节点a和节点b的最深公共祖先:"+a);
		return a;
	}
	public static void main(String[] args) {
		//随意输入两个正整数
		findFather(12,15);
	}
}
