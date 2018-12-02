package com.suguowen.myblog;

public class NameImpl extends AbstractNameTest implements Name{
/*
	1.【强制】代码中的命名均不能以下划线或美元符号开始，也不能以下划线或美元符号结束。
	反例：_name / __name / $name / name_ / name$ / name__
	
	2. 【强制】代码中的命名严禁使用拼音与英文混合的方式，更不允许直接使用中文的方式。
	说明：正确的英文拼写和语法可以让阅读者易于理解，避免歧义。注意，即使纯拼音命名方式
	也要避免采用。
	正例：alibaba / taobao / youku / hangzhou 等国际通用的名称，可视同英文。
	反例：DaZhePromotion [打折] / getPingfenByName() [评分] / int 某变量 = 3

	3.杜绝完全不规范的缩写，避免望文不知义。

	4. 【推荐】为了达到代码自解释的目标，任何自定义编程元素在命名时，使用尽量完整的单词
	组合来表达其意。
	正例：从远程仓库拉取代码的类命名为 PullCodeFromRemoteRepository。
	反例：变量 int a; 的随意命名方式。

	5. 【推荐】如果模块、接口、类、方法使用了设计模式，在命名时体现出具体模式。
	说明：将设计模式体现在名字中，有利于阅读者快速理解架构设计理念。
	正例：public class OrderFactory;
	public class LoginProxy;
	public class ResourceObserver;

	6. 接口和实现类的命名有两套规则：
	1）【强制】对于 Service 和 DAO 类，基于 SOA 的理念，暴露出来的服务一定是接口，内部
	的实现类用 Impl 的后缀与接口区别。
	正例：CacheServiceImpl 实现 CacheService 接口。
	2）【推荐】如果是形容能力的接口名称，取对应的形容词为接口名（通常是–able 的形式）。
	正例：AbstractTranslator 实现 Translatable。
	
	7. 【参考】枚举类名建议带上 Enum 后缀，枚举成员名称需要全大写，单词间用下划线隔开。
	说明：枚举其实就是特殊的常量类，且构造方法被默认强制是私有。
	正例：枚举名字为 ProcessStatusEnum 的成员名称：SUCCESS / UNKNOWN_REASON。
	
	8. 【参考】各层命名规约：
	A) Service/DAO 层方法命名规约
	1） 获取单个对象的方法用 get 作前缀。
	2） 获取多个对象的方法用 list 作前缀。
	3） 获取统计值的方法用 count 作前缀。
	4） 插入的方法用 save/insert 作前缀。
	5） 删除的方法用 remove/delete 作前缀。
	6） 修改的方法用 update 作前缀。
	B) 领域模型命名规约
	1） 数据对象：xxxDO，xxx 即为数据表名。
	2） 数据传输对象：xxxDTO，xxx 为业务领域相关的名称。
	3） 展示对象：xxxVO，xxx 一般为网页名称。
	4） POJO 是 DO/DTO/BO/VO 的统称，禁止命名成 xxxPOJO。
	


	1. 【强制】不允许任何魔法值（即未经预先定义的常量）直接出现在代码中。
	反例：String key = "Id#taobao_" + tradeId;
	cache.put(key, value);
	反例： String key = "Id#taobao_" + tradeId; cache.put(key, value);
	魔法数字的例子
	int priceTable[] = new int[16]； //ERROR：这个16究竟有何含义呢？
	使用了带名字的数值的例子
	static final int PRICE_TABLE_MAX = 16； //OK：带名字
	int price Table[] = new int [PRICE_TABLE_MAX]； //OK：名字的含义是很清楚的

	/3. 【推荐】不要使用一个常量类维护所有常量，按常量功能进行归类，分开维护。
	说明：大而全的常量类，非得使用查找功能才能定位到修改的常量，不利于理解和维护。
	正例：缓存相关常量放在类 CacheConsts 下；系统配置相关常量放在类 ConfigConsts 下。

	4. 【推荐】常量的复用层次有五层：跨应用共享常量、应用内共享常量、子工程内共享常量、包
	内共享常量、类内共享常量。
	1） 跨应用共享常量：放置在二方库中，通常是 client.jar 中的 constant 目录下。
	2） 应用内共享常量：放置在一方库中，通常是子模块中的 constant 目录下。
	反例：易懂变量也要统一定义成应用内共享常量，两位攻城师在两个类中分别定义了表示
	“是”的变量：
	类 A 中：public static final String YES = "yes";
	阿里巴巴 Java 开发手册
	 4/36
	类 B 中：public static final String YES = "y";
	A.YES.equals(B.YES)，预期是 true，但实际返回为 false，导致线上问题。
	3） 子工程内部共享常量：即在当前子工程的 constant 目录下。
	4） 包内共享常量：即在当前包下单独的 constant 目录下。
	5） 类内共享常量：直接在类内部 private static final 定义。
*/

	String myNameType;
	final String DEFAULT_NAME = "default Name";//常量命名全部大写,单词用下划线分隔,力求语义明确标准
	int[] array;//】类型与中括号紧挨
	boolean flag;//定义boolean类型不能在名字前加is，否则有可能与框架序列化错误
	Long longName = 2L;//赋值L要大写，小写l任意与数字1混淆
	
	public void nameTest(String oneNameType) {
		myNameType = oneNameType;
	}
	
	public enum colorEnum {
		RED,GREEN,BLANK
	}
	
	@Override
	public void print(Object object) {
		System.out.println(object);
	}

	@Override
	public void setName() {
	}

	@Override
	public void getName() {
	}
	
	public static void main(String[] args) {
		System.out.println(colorEnum.RED);
	}
}
