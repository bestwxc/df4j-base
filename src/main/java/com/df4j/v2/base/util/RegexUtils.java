package com.df4j.v2.base.util;

import com.df4j.v2.base.exception.DfException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则匹配异常
 */
public class RegexUtils {

    /**
     * 从文本中匹配出符合条件的字符串
     * @param content
     * @param regex
     * @return
     */
    public static List<String> getMatch(CharSequence content, String regex){
        try {
            Matcher matcher = Pattern.compile(regex).matcher(content);
            List<String> result = new ArrayList<>();
            while (matcher.find()) {
                result.add(matcher.group());
            }
            return result;
        }catch (Exception e){
            throw new DfException("正则匹配异常",e);
        }
    }

    /**
     * 检验字符串是否满足匹配
     * @param content
     * @param regex
     * @return
     */
    public static boolean match(CharSequence content, String regex){
        return Pattern.matches(regex, content);
    }

    /**
     * 匹配一条记录
     * @param content
     * @param regex
     * @return
     */
    public static String getOneMatch(CharSequence content, String regex){
        List<String> matches = getMatch(content, regex);
        if(ValidatorUtils.isEmpty(matches) || matches.size() > 1){
            throw new DfException("匹配一条记录失败");
        }
        return matches.get(0);
    }

    public static void main(String[] args) {
        String m = "com.df4j.module.test.service";
        String regex = "(?<=module\\.).+(?=\\.service)";
        System.out.println(getOneMatch(m, regex));
    }
}
