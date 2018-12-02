package ACM.tiao_yue_you_xi;

/*
 * Solution的一种变形，算法一样，这个为了提交加改了一些代码
 */
public class Solution2 {
    public boolean canJump(int[] nums) {
        //从倒数第二个开始往前看，能到达最后一位的话，它的值一定大于最后一位的下标减去它的下标，然后删除把它变成最后一位，重复这个动作
		boolean judge = false;
		try {
			pack_for(nums,nums.length,judge);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			judge = true;
		}
		return judge;
    }
	
	// a rray_length数组长度
	public static void pack_for(int[] array,int array_length,boolean judge) throws Exception {
        if(array_length == 1) {
			throw new Exception();
		}
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
					throw new Exception();
				} else {
					// 继续判断
					pack_for(array,array_length - length,judge);
				}
			}
		}
	}	
}