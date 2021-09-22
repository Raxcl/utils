package my.util.one;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceWithNameAndModel {

    //批量处理脚本
    public static void main(String[] args) {
        //1. 字符串定义
        //请将要输入的文本粘贴在下方（目前没有想到什么输入的好方法，后续优化.....）
        String str = "{\n" +
                "label: intl.get(`.model.startDate`).d('开始日期'),\n" +
                "name: 'startDate',\n" +
                "type: 'dateTime',\n" +
                "},\n" +
                "{\n" +
                "label: intl.get(`.model.endDate`).d('结束日期'),\n" +
                "name: 'endDate',\n" +
                "type: 'dateTime',\n" +
                "},";
        //2.字符串修改
        //2.1定义匹配规则 获取需要的数据
        Pattern pattern =Pattern.compile("(?<=model.).*(?=`)");
        Matcher matcher = pattern.matcher(str);
        ArrayList list = new ArrayList();
        //字符串查找
        while (matcher.find()){
            list.add(matcher.group());
        }

        //2.2定义匹配规则 修改数据
        //贪婪匹配不可，需要改为懒惰
        Pattern pattern1 = Pattern.compile("(?<=name: ').*?(?=')");
        Matcher matcher1 = pattern1.matcher(str);
        int i=0;
        StringBuffer result = new StringBuffer();

        while (matcher1.find()){
            //依次替换
            matcher1.appendReplacement(result, (String)list.get(i));
            i++;
        }
        System.out.println(result);
    }

}
