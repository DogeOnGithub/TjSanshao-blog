package cn.tjsanshao.blogserver.utils;

import java.util.List;

/**
 * tools
 *
 * @author TjSanshao
 * @date 2020-05-09 17:07
 */
public class ExUtils {
    public static String analyseListToString(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(t -> {
            stringBuilder.append(t);
            stringBuilder.append(";");
        });
        // consider to use string.substring during high concurrency
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
