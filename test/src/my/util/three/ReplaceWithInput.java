package my.util.three;

import my.util.two.StringDemoOne;
import my.util.two.StringDemoTwo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceWithInput {

    public static void main(String[] args) {
        demo();
    }

    //批量处理脚本
    //把第一个String里面的name后字符串替换成第二个String里面的name
    public static void demo(){
        //1. 字符串定义
        //输入需要批量提取字符串的内容
        System.out.println("请输入需要提取文本内容：");
        String str = moreLineInput();
        //2.字符串修改
        //2.1定义匹配规则 获取需要的数据
        Pattern pattern = Pattern.compile("(?<=name: ').*?(?=')");
        Matcher matcher = pattern.matcher(str);
        ArrayList list = new ArrayList();
        //字符串查找
        while (matcher.find()) {
            list.add(matcher.group());
        }

        //目标文
        System.out.println("请输入需要被替换的内容：");
        String str1 = moreLineInput();


        //2.2定义匹配规则 修改数据
        //贪婪匹配不可，需要改为懒惰
        Pattern pattern1 = Pattern.compile("(?<=name: ').*?(?=')");
        Matcher matcher1 = pattern1.matcher(str1);
        int i = 0;
        StringBuffer result = new StringBuffer();

        while (matcher1.find() && i < list.size()) {
            //依次替换
            matcher1.appendReplacement(result, (String) list.get(i));
            i++;
        }
        System.out.println(result);
    }




    public static String moreLineInput() {
        StringBuffer stringBuffer = new StringBuffer();
        Scanner scanner = new Scanner(System.in);
        String strTxt = new String();
        //输入一行为空结束循环
        while (!(strTxt = scanner.nextLine()).isEmpty()) {
            stringBuffer.append(strTxt);
            stringBuffer.append("\n");
        }
        //不可在此处执行关闭方法，多次执行此方法时会出错
        //scanner.close();
        //将stringBuffer进行转换
        String strInput = new String(stringBuffer);
        return strInput;
    }

}
