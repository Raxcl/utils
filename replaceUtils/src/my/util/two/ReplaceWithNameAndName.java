package my.util.two;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceWithNameAndName {

    //批量处理脚本
    //把第一个String里面的name后字符串替换成第二个String里面的name
    public static void main(String[] args) {
        //1. 字符串定义
        //请将要输入的文本粘贴在下方（目前没有想到什么输入的好方法，后续优化.....）
        //原文
        StringDemoOne str = new StringDemoOne();
        //2.字符串修改
        //2.1定义匹配规则 获取需要的数据
        Pattern pattern =Pattern.compile("(?<=name: ').*?(?=')");
        Matcher matcher = pattern.matcher(str.strDemo);
        ArrayList list = new ArrayList();
        //字符串查找
        while (matcher.find()){
            list.add(matcher.group());
        }

        //目标文
        StringDemoTwo str1 = new StringDemoTwo();


        //2.2定义匹配规则 修改数据
        //贪婪匹配不可，需要改为懒惰
        Pattern pattern1 = Pattern.compile("(?<=name: ').*?(?=')");
        Matcher matcher1 = pattern1.matcher(str1.strDemo);
        int i=0;
        StringBuffer result = new StringBuffer();

        while (matcher1.find() && i<list.size()){
            //依次替换
            matcher1.appendReplacement(result, (String)list.get(i));
            i++;
        }
        System.out.println(result);
    }

}
