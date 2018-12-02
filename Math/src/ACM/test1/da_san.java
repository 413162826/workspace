package ACM.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

public class da_san {
	/*
	 * 3x师兄离职归来，在宿舍挺无聊的。
	 * 情人节那天，3x逛了个交友网站，注册了个账号，
	 * 填了super多有关他的那个她的标准。那网站超级给力的显示了n(1 <= n <= 100000)
	 * 个妹子出来，n个妹子排成一排，每个妹子3x都给对她们有个 feeling value, 
	 * 哇哇哇，3x瞬间眼睛大亮，在少林待了那么多年都没找到符合3x标准的妹子，
	 * 终于在网站看到了。3x觉得对于妹子i， 如果对于妹子i  feeling value 
	 * 大于旁边（i - 1 / i+ 1）的妹子，那搭讪的时间必须得大于搭讪旁边妹子的时间，
	 * 而且每个妹子搭讪的时间最起码是1。 
	 * 告诉3x，认识全部妹子最少需要多少时间。。
	 */
	
	public static void main(String[] args) {
		//首先，女孩子的位置是固定的，我们可以先给他们排序，然后给他们按顺序赋值，相加就可以了。
		//但这不是最优的！！，因为如果你一个很高的数，旁边两个都是1，那你其实只要是2就可以了。
		//改进:先找出所有最小的数赋值1(这是一定的),已经赋值的元素相当于一堵墙,两边边界也是墙
		//	     然后在墙里面又找最小值附1(这个1)
		
		//首先第一轮全部赋值1,allTime+N
		//然后判断第一个数是否《大于》第二个数，是的话allTime+1,把第一个数存进栈,
		//把第二个数跟第三个数比,如果继续《大于》,allTime+2,把第二个数存进栈,...
		//allTime+栈里面数量,直到出现《小于》,allTime不加,把小于的那个数当做第一个数，直到最后一个数Ending
		//(永远加1，小的数加一他也加一),
		//如果《小于》，第一个数不变，删掉第一个数(无视),然后把第二个数当第一个数循环,直到最后一个数Ending
		//
		//方案三:考虑五种情况,全部升序，全部降序，先升后降，先降后升，平序
		//
		//
		int[] question = {2,1};
		int allTime = question.length;//基础值
		int upStack = 0;//升序栈
		int downStack = 0;//降序栈
		List<Integer> list = new ArrayList<>();
		//初值
		for(int i = 0; i < question.length; i++) {
			list.add(0);
		}
		//增长
		for (int i = 0; i < question.length; i++) {
			//i不是最后一位，可以找下一个！！
			if(i!=question.length-1) {
				//降序
				if(question[i]>question[i+1]) {
					upStack = 0;
					list.set(i, list.get(i)+1);
					downStack++;
				}
				//升序
				else if(question[i]<question[i+1]){
					downStack = 0;
					allTime = allTime+upStack;
					upStack++;
				}
			}
			//i是最后一位	
			else {
				//降序
				if(question[i-1]>question[i]) {
					allTime = allTime+downStack;
				}
				//升序
				if(question[i-1]<question[i]){
					allTime = allTime+upStack;
				}
			}	
		}
		System.out.println(allTime);
	}
}
