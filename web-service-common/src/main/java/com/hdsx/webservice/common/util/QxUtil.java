package com.hdsx.webservice.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QxUtil {

    public static List<String> getQxXzqhs(String xzqhList) {
        if (xzqhList == null || "".equals(xzqhList)) {
            return null;
        }

        List<String> list = Arrays.asList(xzqhList.split(","));
        List<String> xz = new ArrayList<>();
        if (list.size() == 1) {
            if (list.get(0).length() == 6 && list.get(0).substring(4, 6).equals("00") && !list.get(0).substring(2, 6).equals("0000")) {
                xz.add(list.get(0).substring(0, 4));
            } else if (list.get(0).length() == 6 && list.get(0).substring(2, 6).equals("0000")) {
                xz.add(list.get(0).substring(0, 2));
            } else if (list.get(0).length() < 6 && list.get(0).equals("00")) {
            } else {
                xz.add(list.get(0));
            }
        } else {
            xz.addAll(list);
        }

        return xz;
    }

    public static String getXzqhSubString(String xzqh) {
        if (xzqh == null || "".equals(xzqh)) {
            return null;
        }

        if (xzqh.length() == 6 && xzqh.substring(4, 6).equals("00") && !xzqh.substring(2, 6).equals("0000")) {
            return xzqh.substring(0, 4);
        } else if (xzqh.length() == 6 && xzqh.substring(2, 6).equals("0000")) {
            return xzqh.substring(0, 2);
        }

        return xzqh;
    }
}
