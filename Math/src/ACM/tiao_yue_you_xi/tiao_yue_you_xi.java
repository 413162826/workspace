package ACM.tiao_yue_you_xi;

public class tiao_yue_you_xi {
	/*
	 * title： 从第一个数出发，判断能否跳到最后一个数 regular： 步骤一：判断其他数跟最后一个数的距离this_long，如果this_long >
	 * array[i].val 不能到达 步骤二：
	 */
	static int[] array;
	static boolean judge = false;

	public static void main(String[] args) {

		tiao_yue_you_xi this_class = new tiao_yue_you_xi();
		int[] test = {3,2,1,0,4};
		System.out.println(this_class.canJump(test));
	}

	public boolean canJump(int[] nums) {
        //从倒数第二个开始往前看，能到达最后一位的话，它的值一定大于最后一位的下标减去它的下标，然后删除把它变成最后一位，重复这个动作
		array = nums;
		pack_for(array.length);
		return judge;

    }
	
	// a rray_length数组长度
	public static void pack_for(int array_length) {
		// 循环n-1次
		for (int i = array_length - 1; i > 0; i--) {
			int length = array_length - i;
			int array_index = array_length - length - 1;
			if (array[array_index] < length) {
				// 无法到达，继续for循环
			} else {
				// 判断是否第一位
				if (array_index == 0) {
					// 成功
					judge = true;
				} else {
					// 继续判断
					pack_for(array_length - length);
				}
			}
		}
	}
}
/*
 * //循环n-1次 for (int i = array.length-1; i > 0; i--) { //各点到最后一点的距离 int length =
 * array.length - i;
 * 
 * if(array[i] < length) { //无法到达，继续for循环 }else { //可以到达，判断其他点能否到达这个点 //循环i-1次
 * for(int j = i-1; j>0; j--) { //i+1是这个点对应数组的长度，这里应该是(i+1-1)-j int length_next
 * = i-j; if(array[j] < length_next) { //无法到达，继续for循环 }else { //同理.... .... } }
 * } }
 */
