//RandomUtil
package com.lp.utils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
public class RandomUtil {
    /**
     *生成验证码
     */
    public static String code() {
        Set<Integer> set = GetRandomNumber();
        Iterator<Integer> iterator = set.iterator();
        String temp = "";
        while (iterator.hasNext()) {
            temp += iterator.next();
        }
        return temp;
    }
    public static Set<Integer> GetRandomNumber() {
        Set<Integer> set = new HashSet<Integer>();
        Random random = new Random();
        while (set.size() < 6) {
            set.add(random.nextInt(10));
        }
        return set;
    }
}
