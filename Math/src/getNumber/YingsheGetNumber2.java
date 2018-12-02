package getNumber;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
/*
 * 盒子码：每次调用get方法，+1
 * 原始值：一千万取一
 * 乱码：第一次加密值
 * increateCode：每生成一个原始码，附加生成顺序码，每次+1
 * Code:二次加密值
 */
public class YingsheGetNumber2 {
	static long k = 1000000000L; // 随机数的数量：10亿
	static HashSet<String> hs = new HashSet<>(); // 定义一个set用来存储防伪码
	static ArrayList<String> list = new ArrayList<>(); // 定义一个array用来存储防伪码
	static long a = getSession(); // 上区间
	static long b = getSession() + 10000000 - 1; // 下区间
	
	static long count = getCount();//获取上一次盒子码,在此加1+++++++++++++++++++++
	static long increateCode = getIncreateNumber();//获得顺序码++++++++++++++++
	
	/*
	 * 此方法不能在主方法直接调用,只能通过盒子码方法调用
	 */
	public static void get(long n) throws IOException { // n为本次需要的防伪码数
		if (n <= 0) {
			System.out.println("请输入正整数"); // 数量不能为0，负数
			return;
		}

		long h = 10000000000000000L / k; // 步长，即10^16个数中选10^9 （10亿），其区间长度

		for (long i = 0; i < n; i++) // 迭代选防伪码过程
		{				
			long randomNumber = (long) (Math.random() * h + a); // 防伪码随机部分
			DecimalFormat df = new DecimalFormat("0000000000000000"); // 前缀补0函数
			String entireRandomNumber = df.format(randomNumber); // 前缀补0补到16位

			String mappingNum1 = mapping1(entireRandomNumber);// 第一层加密

			String mappingNum2 = mapping2(mappingNum1);// 第二层加密
			
			String m_2 = mapping2逆(mappingNum2);
			String m_1 = mapping1逆(m_2);
			
//			System.out.println("上区间：" + a + "          " + "下区间：" + b + "             " 
//			+ "原始值：" + entireRandomNumber+"             "+"第一层加密值："+mappingNum1
//					+ "             " + "二层加密值" + mappingNum2+"             "+"第二层解密值："+m_2+"             "+"第一层解密值："+m_1); // 输出到控制台
/*			System.out.print("上区间：" + a);
			System.out.print("          ");
			System.out.print("下区间：" + b);
			System.out.print("          ");*/
			System.out.print("原始值：" + entireRandomNumber);
			System.out.print("          ");
			System.out.print("乱码："+mappingNum1);//++++++++++
			System.out.print("             ");
			System.out.print("increateCode：" + increateCode);	//+++++++++++++
			System.out.print("             ");
			System.out.println("Code：" + mappingNum2);//+++++++++++
			
			increateCode++;//++++++++++++++++++
			setIncreateNumber(increateCode);//++++++++++++

			a = a + h; // 上区间调整到下一个
			b = b + h; // 下区间调整到下一个
			hs.add(mappingNum2); // 添加到哈希集合
			list.add(mappingNum2); // 添加到树集合
			if (b >= 10000000000000000l) {
				System.out.println("区间爆炸"); // 随机数将超出16位
				return;
			}
		}

		System.out.println("集合长度：" + hs.size()); // 对比集合列表，判断是否重复
		System.out.println("列表长度：" + list.size());

		setSession(b); // 把下区间保留为下次迭代的上区间
	}

	/*
	 * maaping1:从properties读取匹配信息进行第一次加密 num传进来后，分隔成16位，每一位都进行判断然后加密
	 */
	public static String mapping1(String num) throws IOException {

		StringBuffer sBuffer = new StringBuffer(); // 储存
		Properties properties = new Properties();
		properties.load(YingsheGetNumber2.class.getResourceAsStream("/getNumber/mapping1.properties"));

		// 循环，剪切，加密，拼接
		for (int i = 0; i < num.length(); i++) {
			String numtest = num.substring(i, i + 1);
			// System.out.println(numtest);//剪切成功
			numtest = properties.getProperty(numtest);
			// System.out.println(numtest);//加密成功
			sBuffer.append(numtest);
		}
		// System.out.println(sBuffer.toString());//拼接成功

		return sBuffer.toString();
	}

	/*
	 * mapping2： 根据最后一位的数字作映射 eg：最后一位3 则第一位3映射，第二位4映射，第5位... 就是第一位使用---第（最后一位）个规则
	 * 之后位数使用---第（前一位+1）个规则 无0规则10规则变成0规则
	 */
	public static String mapping2(String num) { // 获取16位数
		StringBuffer sBuffer = new StringBuffer(); // 储存
		String lastNum = num.substring(9, num.length()); // 9~末尾（保留完全无规律数）
		String theLastNum = num.substring(num.length() - 1, num.length()); // 最后一位规则数
		int theLastNumInt = Integer.parseInt(theLastNum); // 规则数的整形

		for (int i = 0; i < 9; i++) {
			String preNum = num.substring(i, i + 1); // 截取第i位数字

			if (theLastNumInt + i > 9) {
				theLastNumInt = -i; // 使映射满10回0
			}
			int result = Integer.parseInt(preNum) + i + theLastNumInt; // 第i位按照i+1的规则进行映射
			if (result > 9) {
				result = result % 10; // 满10的映射值其实是余数
			}
			sBuffer.append(Integer.toString(result)); // 存入缓存区域
		}
		sBuffer.append(lastNum);
		return sBuffer.toString();
	}

	/*
	 * maaping1:mapping2逆得到的num是参数 因为无法用value得到key所以只能测试出key，value再反向存在map里面
	 */
	public static String mapping1逆(String num) throws IOException {

		StringBuffer returnNum = new StringBuffer(); // 储存
		Properties properties = new Properties();
		properties.load(YingsheGetNumber2.class.getResourceAsStream("/getNumber/mapping1.properties"));
		Map<String, String> m = new HashMap<>();
		String key = null;

		// 健值交换表
		for (int i = 0; i < 10; i++) {
			key = properties.getProperty(String.valueOf(i));// 硬性获取properties的key&value
			m.put(key, String.valueOf(i));// 反向储存，健值交换
		}

		// 循环，剪切，加密，拼接
		for (int i = 0; i < num.length(); i++) {
			String numtest = num.substring(i, i + 1);
			// System.out.println(numtest);//剪切成功
			numtest = (String) m.get(numtest);
			// System.out.println(numtest);//加密成功
			returnNum.append(numtest);
		}
		// System.out.println(sBuffer.toString());//拼接成功

		return returnNum.toString();
	}

	/*
	 * mapping2的逆映射
	 */
	public static String mapping2逆(String num) {
		StringBuffer sBuffer = new StringBuffer(); // 储存
		String lastNum = num.substring(9, num.length()); // 9~末尾（保留完全无规律数）
		String theLastNum = num.substring(num.length() - 1, num.length()); // 最后一位规则数
		int theLastNumInt = Integer.parseInt(theLastNum); // 规则数的整形

		for (int i = 0; i < 9; i++) {
			String preNum = num.substring(i, i + 1); // 截取第i位数字
			if (theLastNumInt + i > 9) {
				theLastNumInt = -i; // 使映射满10回0
			}
			int result = Integer.parseInt(preNum) - i - theLastNumInt; // 第i位按照i+1的规则进行映射
			if (result < 0) {
				result = 10 + result; // 少于0的映射其实是与10的补数（这里的result是负数哦）
			}
			sBuffer.append(Integer.toString(result)); // 存入缓存区域
		}
		sBuffer.append(lastNum);
		return sBuffer.toString();//返回密2
	}

	/*
	 * 读取区间，读取为这次的上区间
	 */
	public static long getSession() {
		long session;
		String content = null;
		try {
			int size = 0;
			// 定义一个字节缓冲区,该缓冲区的大小根据需要来定义
			byte[] buffer = new byte[1024];
			FileInputStream fis = new FileInputStream("C:\\Users\\Gwen\\workspace2.0\\Math\\src\\getNumber\\abc.txt");
			// 循环来读取该文件中的数据
			while ((size = fis.read(buffer)) != -1) {
				content = new String(buffer, 0, size);
				// System.out.println(content);
			}
			// 关闭此文件输入流并释放与此流有关的所有系统资源。
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session = Long.parseLong(content);
		return session;
	}

	/*
	 * 设定区间，区间下次的上区间
	 */
	public static void setSession(long session) {
		try {
			// 向文件中写入字节数组
			String font = Long.toString(session);
			FileOutputStream fos = new FileOutputStream("C:\\Users\\Gwen\\workspace2.0\\Math\\src\\getNumber\\abc.txt");
			fos.write(font.getBytes());
			// 关闭此文件输出流并释放与此流有关的所有系统资源。此文件输出流不能再用于写入字节。 如果此流有一个与之关联的通道，则关闭该通道。
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 读取盒子码+++++++++++++++++++
	 */
	public static long getCount() {
		long count;
		String content = null;
		try {
			int size = 0;
			// 定义一个字节缓冲区,该缓冲区的大小根据需要来定义
			byte[] buffer = new byte[1024];
			FileInputStream fis = new FileInputStream("C:\\Users\\Gwen\\workspace2.0\\Math\\src\\getNumber\\boxNumber.txt");
			// 循环来读取该文件中的数据
			while ((size = fis.read(buffer)) != -1) {
				content = new String(buffer, 0, size);
				// System.out.println(content);
			}
			// 关闭此文件输入流并释放与此流有关的所有系统资源。
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		count = Long.parseLong(content);
		return count;
	}
	
	/*
	 * 储存盒子码+++++++++++++++++
	 */
	public static void setCount(long count) {
		try {
			// 向文件中写入字节数组
			String font = Long.toString(count);
			FileOutputStream fos = new FileOutputStream("C:\\Users\\Gwen\\workspace2.0\\Math\\src\\getNumber\\boxNumber.txt");
			fos.write(font.getBytes());
			// 关闭此文件输出流并释放与此流有关的所有系统资源。此文件输出流不能再用于写入字节。 如果此流有一个与之关联的通道，则关闭该通道。
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 读取顺序码++++++++++++++++
	 */
	public static long getIncreateNumber() {
		long increateCode;
		String content = null;
		try {
			int size = 0;
			// 定义一个字节缓冲区,该缓冲区的大小根据需要来定义
			byte[] buffer = new byte[1024];
			FileInputStream fis = new FileInputStream("C:\\Users\\Gwen\\workspace2.0\\Math\\src\\getNumber\\IncreateNumber.txt");
			// 循环来读取该文件中的数据
			while ((size = fis.read(buffer)) != -1) {
				content = new String(buffer, 0, size);
				// System.out.println(content);
			}
			// 关闭此文件输入流并释放与此流有关的所有系统资源。
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		increateCode = Long.parseLong(content);
		
		return increateCode;
		
	}

	/*
	 * 设置顺序码+++++++++++++++++
	 */
	public static void setIncreateNumber(long increateCode) {
		
		try {
			// 向文件中写入字节数组
			String font = Long.toString(increateCode);
			FileOutputStream fos = new FileOutputStream("C:\\Users\\Gwen\\workspace2.0\\Math\\src\\getNumber\\IncreateNumber.txt");
			fos.write(font.getBytes());
			fos.flush();
			// 关闭此文件输出流并释放与此流有关的所有系统资源。此文件输出流不能再用于写入字节。 如果此流有一个与之关联的通道，则关闭该通道。
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	/*
	 * 随机防伪码程序文档 ①防伪码总数已经定好10亿个，累计取出10亿个程序报废 ②可以分多次取出随机码，且随机码必定不重复且没规律 ③每次输入的数量必须为正数
	 */
	public static void main(String[] args) throws IOException {
//		String num = "543213435414351";
//		System.out.println("初始值：" + num);
//		String m1 = mapping1(num);
//		System.out.println("加密1：" + m1);
//		String m2 = mapping2(m1);
//		System.out.println("加密2:" + m2);
//		String m_2 = mapping2逆(m2);
//		System.out.println("逆2:" + m_2);
//		String m_1 = mapping1逆(m_2);
//		System.out.println("逆1："+m_1);
//		get(10);
		
		boxCode(5);//输出一盒数据++++++++++++++++

	}
	
	//盒子码(联动get方法使用)++++++++++++++++++++
	//运行一次get(),count++
	//返回count+1
	public static long boxCode(long n) throws IOException {
		System.out.println("盒子码:"+count);
		get(n);//调用获取n个Code
		count++;//盒子序号+1
		setCount(count);//存进数据库
		return count;//返回boxCode值(就是count)
	}

}
