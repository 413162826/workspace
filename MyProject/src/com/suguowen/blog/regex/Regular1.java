package com.suguowen.blog.regex;

public class Regular1 {
	
	public static void p(Object o) {
		System.out.println(o);
	}
	
	public static void main(String[] args) {
		//数量词
//		p("aadfsa".matches(".*"));//'.'任何字符,'*'任何数量
//		p("".matches("a?"));//'?'出现0次或1次
//		p("aa".matches("a+"));//'+'出现1次或多次
//		p("123".matches("\\d{3}"));//'\d'任何数字,'\d{x}'出现x次数字,可以有两个参数，为上下限
//		p("aabcdaa".matches("a*"));//'*'零个或多个,'a*'是a出现零个或多个，但如果出现非a字符不在零个和多个范围，返回false
//		p("192.168.1.100".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}.\\d{1,3}"));//'\\.'表示'.'，\转义
	
//		//字符类
//		p("ab".matches("[a,ab,c][a,b]"));//一个'[]'匹配一个字符，第一个'[ab]'并不会被匹配成功，'[a][b]'成功
//		p("a".matches("[^abc]"));//'[^*]'表示不再'[]'范围内的字符！！不能是数字！！ps:'^'有两种方法，方法一
//		p("K".matches("[a-zA-Z]"));//方法一:'a-z'代表a~z所有任何字符
//		p("K".matches("[a-z[A-Z]]"));//方法二:文字同上
//		p("K".matches("[a-z]|[A-Z]"));//方法三:文字同上,'|'(或)取两个规则任意一个
//		p("K".matches("[KBG&&[A-Z]]"));//'&'代表且,取交集
		
		//预定义字符类
//		p(" \n\r\t".matches("\\s{4}"));//'\s'代表space,空格回车换行等等的space类型
//		p("e1_a".matches("\\w{4}"));//'\w'代表word,任何字符斜杠数字都可以
//		p("e".matches("\\W"));//'\W'代表非word,任何字符斜杠数字都不可以！！ps:这里说明小写代表可以***，大写代表不可以***
//		p("\\".matches("\\\\"));//前面的'\\'代表'\',后面的'\\\\'代表Java的'\\',然后'\\'在正则表达式里面会变成'\'
		
		p("hello".matches("^h.*"));//'^'方法二，指定字符串开头,'^h'代表以h开头的字符串,ps:正则表达式并没有明确的一对一规则，除了[]
		p("hello".matches(".*lo$"));//'$'指定字符串结尾,'lo$'以lo结尾,ps:只要字符串匹配完规则就会true,而不需要所有规则都匹配
		p("hello sir".matches(".*o\\b (sir)"));
	}
}
