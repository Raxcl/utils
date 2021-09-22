package my.util.four;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceWithView {
    public String startReplace(String needRuleLeft, String needRuleRight, String replaceRuleLeft, String replaceRuleRight, String needTxt, String replaceTxt) {
        //定义需求匹配规则
        String needRule = "(?<="+needRuleLeft+").*?(?="+needRuleRight+")";
        //定义替换匹配规则
        String replaceRule = "(?<="+replaceRuleLeft+").*?(?="+replaceRuleRight+")";
        return replace(needRule,replaceRule,needTxt,replaceTxt);

    }

    //批量处理脚本
    //把第一个String里面的name后字符串替换成第二个String里面的name
    public String replace(String needRule,String replaceRule,String needTxt,String replaceTxt){
        //1.字符串修改
        //1.1定义匹配规则 获取需要的数据
        Pattern pattern = Pattern.compile(needRule);
        Matcher matcher = pattern.matcher(needTxt);
        List<String> list = new ArrayList<>();
        //字符串查找
        while (matcher.find()) {
            list.add(matcher.group());
        }
        //目标文
        //1.2定义匹配规则 修改数据
        //贪婪匹配不可，需要改为懒惰
        Pattern pattern1 = Pattern.compile(replaceRule);
        Matcher matcher1 = pattern1.matcher(replaceTxt);
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher1.find() && i <= list.size()) {
            //依次替换
            matcher1.appendReplacement(stringBuffer, list.get(i));
            i++;
        }
        //bug点，无法显示最后一个匹配项之后的内容*（已解决）
        matcher1.appendTail(stringBuffer);
        return new String(stringBuffer);
    }
}
