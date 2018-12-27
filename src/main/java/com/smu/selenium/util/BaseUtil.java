package com.smu.selenium.util;

import org.apache.commons.lang3.StringUtils;
import java.util.*;

public class BaseUtil {

    /**
     * 生成树状路径
     * cpx
     *
     * @param pathLen
     * @param addVal
     * @return
     */
    public static String createTreePath(String pathLen, int addVal) {
        java.text.DecimalFormat df = new java.text.DecimalFormat(pathLen);
        return df.format(pathLen);
    }

    /**
     * cpx
     * 数字排重(只支持数字)
     *
     * @param str
     * @return
     */
    public static String noRepeat(String str) {
        char[] chars = new char[255];
        char[] input = str.toCharArray();

        int temp;
        for (int i = 0; i < input.length; i++) {
            temp = input[i];
            if (chars[temp] == 0)
                chars[temp] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 1)
                sb.append((char) i);
        }
        return sb.toString();
    }

    /**
     * 判断对象或对象数组中每一个对象是否为空: 对象为null，字符序列长度为0，集合类、Map为empty
     *
     * @param obj
     * @return
     */
    public static boolean isNullOrEmpty(Object obj) {
        if (obj == null)
            return true;

        if (obj instanceof CharSequence)
            return StringUtils.isBlank((CharSequence) obj);

        if (obj instanceof Collection)
            return ((Collection) obj).isEmpty();

        if (obj instanceof Map)
            return ((Map) obj).isEmpty();

        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                return true;
            }
            boolean empty = true;
            for (int i = 0; i < object.length; i++) {
                if (!isNullOrEmpty(object[i])) {
                    empty = false;
                    break;
                }
            }
            return empty;
        }
        return false;
    }

    /**
     * 判断是否null 则返回空对象
     *
     * @param o
     * @return
     */
    public static Object returnNullObject(Object o) {
        return isNullOrEmpty(o) ? new HashMap<String, Object>() : o;
    }

    /**
     * 判断是否null 则返回空对象MapList
     *
     * @param o
     * @return
     */
    public static Object returnNullListObject(List<Map<String, Object>> o) {
        for (int i = 0; i < o.size(); i++) {
            return isNullOrEmpty(o.get(0)) ? new ArrayList<HashMap<String, Object>>() : o;
        }
        return o;
    }

    /**
     * 去除数组中重复的记录   cpx
     *
     * @param a
     * @return
     */
    public static String[] array_unique(String[] a) {
        // array_unique
        List<String> list = new LinkedList<String>();
        for (int i = 0; i < a.length; i++) {
            if (!list.contains(a[i])) {
                list.add(a[i]);
            }
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    public static boolean Object2Boolean(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return Boolean.parseBoolean(toString(obj));
        } catch (Exception e) {
        }
        return false;
    }

    public static String toString(Object value) {
        if (value == null) {
            return "";
        }
        return value.toString().trim();
    }

}
