package ACM.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * 现在，有一行括号序列，请你检查这行括号是否配对。
 */
public class kuohaopeidui {
	/*
	 * 从做到右读取
	 * 读到'(','['存在key堆里面
	 * 读到')',']'判断能否跟堆第一个配堆,能则消除
	 */
	public static String judge(String str) {
		System.out.println("====进入程序===");
		Stack<String> s = new Stack<>();
		Map<String, String> map = new HashMap<>();
		
		//定义map规则
		map.put("(", ")");
		map.put("[", "]");
		
		//长度为单数,必定有不匹配
		if(str.length()%2 != 0) {
			//System.out.println("长度单数错误！！！");
			return "No";
		}
		for(int i =0;i<str.length();i++) {
			//堆储存([
			if (str.substring(i, i+1).equals("(") || str.substring(i, i+1).equals("[")) {
				s.push(str.substring(i, i+1));
			}
			//判断配对情况，成功配对pop一个出来，失败return
			if (str.substring(i, i+1).equals(")") || str.substring(i, i+1).equals("]")) {
				String stack_pop = s.pop();
				String stack_pop_map = map.get(stack_pop);
				if(!str.substring(i, i+1).equals(stack_pop_map)) {
					//不匹配
					//System.out.println("栈顶匹配错误！！！");
					return "No";
				}
			}
		}
		//System.out.println("successful!!");
		return "Yes";
	}
	
	
	
	public static void main(String[] args) {
		judge("(([()])([()]))");
	
	}
}
