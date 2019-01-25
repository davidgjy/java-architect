package com.genesis.utils.time;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TimeIntervalUtil {

    private final static long YEAR = 1000 * 60 * 60 * 24 * 365L;
    private final static long MONTH = 1000 * 60 * 60 * 24 * 30L;
    private final static long DAY = 1000 * 60 * 60 * 24L;
    private final static long HOUR = 1000 * 60 * 60L;
    private final static long MINUTE = 1000 * 60L;

    private static final String INTERVAL_YEAR = "INTERVAL_YEAR";
    private static final String INTERVAL_MONTH = "INTERVAL_MONTH";
    private static final String INTERVAL_DAY = "INTERVAL_DAY";
    private static final String INTERVAL_HOUR = "INTERVAL_HOUR";
    private static final String INTERVAL_MINUTE = "INTERVAL_MINUTE";
    private static final String INTERVAL_NOW = "INTERVAL_NOW";


    private static Map<String, String> getIntervalMapByLanguage(IntervalLanguage language) {
        Map<String, String> intervalMap = new HashMap<>(16);
        switch (language) {
            case CHN:
                intervalMap.put(INTERVAL_YEAR, "年前");
                intervalMap.put(INTERVAL_MONTH, "月前");
                intervalMap.put(INTERVAL_DAY, "天前");
                intervalMap.put(INTERVAL_HOUR, "小时前");
                intervalMap.put(INTERVAL_MINUTE, "分钟前");
                intervalMap.put(INTERVAL_NOW, "刚刚");
                break;
            default:
                intervalMap.put(INTERVAL_YEAR, "years ago");
                intervalMap.put(INTERVAL_MONTH, "months ago");
                intervalMap.put(INTERVAL_DAY, "days ago");
                intervalMap.put(INTERVAL_HOUR, "hours ago");
                intervalMap.put(INTERVAL_MINUTE, "minutes ago");
                intervalMap.put(INTERVAL_NOW, "just now");
                break;
        }

        return intervalMap;
    }

    /**
     * 字符串转换成日期
     *
     * @param str
     * @return date
     */
    private static Date strToDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 根据时间查询时间属于哪个时刻
     *
     * @param date
     * @return
     */
    public static String natureTime(Date date, IntervalLanguage language) {
        Map<String, String> intervalMap = getIntervalMapByLanguage(language);
        Date now = new Date();
        long between = now.getTime() - date.getTime();
        if (between > YEAR) {
            return ((between - YEAR) / YEAR + 1) + intervalMap.get(INTERVAL_YEAR);
        }
        if (between > MONTH) {
            return ((between - MONTH) / MONTH + 1) + intervalMap.get(INTERVAL_MONTH);
        }
        if (between > DAY) {
            return ((between - DAY) / DAY + 1) + intervalMap.get(INTERVAL_DAY);
        }
        if (between > HOUR) {
            return ((between - HOUR) / HOUR + 1) + intervalMap.get(INTERVAL_HOUR);
        }
        if (between > MINUTE) {
            return ((between - MINUTE) / MINUTE + 1) + intervalMap.get(INTERVAL_MINUTE);
        }
        return intervalMap.get(INTERVAL_NOW);
    }
}


