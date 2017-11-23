package com.oumuv.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class DateUtils {
    
    public static SimpleDateFormat dateFormatV1 = new SimpleDateFormat("yyyyMMdd");
    
    public static SimpleDateFormat dateFormatV2 = new SimpleDateFormat("yyyy.MM.dd");
    
    public static SimpleDateFormat dateFormatV3 = new SimpleDateFormat("yyyy-MM-dd");
    
    public static SimpleDateFormat dateFormatV4 = new SimpleDateFormat("yyyy/MM/dd");
    
    public static SimpleDateFormat dateFormatV5 = new SimpleDateFormat("yyyy年MM月dd日");
    
    public static SimpleDateFormat dateFormatV6 = new SimpleDateFormat("yyyyMM");
    
    public static SimpleDateFormat dateTimeFormatV1 = new SimpleDateFormat("yyyyMMddHHmmss");
    
    public static SimpleDateFormat dateTimeFormatV2 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    
    public static SimpleDateFormat dateTimeFormatV3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public static SimpleDateFormat dateTimeFormatV4 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    public static SimpleDateFormat dateTimeFormatV5 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
    
    public static SimpleDateFormat dateTimeFormatV6 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    
    public static SimpleDateFormat yearMothFormatV1 = new SimpleDateFormat("yyyy年MM月");
    
    public static SimpleDateFormat yearMothFormatV2 = new SimpleDateFormat("yyyy.MM");
    
    public static SimpleDateFormat yearMothFormatV3 = new SimpleDateFormat("yyyy-MM");
    
    public static SimpleDateFormat yearMothFormatV4 = new SimpleDateFormat("yyyy/MM");
    
    /** 年月日时分 */
    public static SimpleDateFormat dateHourTimeFormatV1 = new SimpleDateFormat("yyyyMMddHHmm");

    public static SimpleDateFormat dateHourTimeFormatV2 = new SimpleDateFormat("yyyy.MM.dd.HH.mm");

    public static SimpleDateFormat dateHourTimeFormatV3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static SimpleDateFormat dateHourTimeFormatV4 = new SimpleDateFormat("yyyy/MM/dd HH:mm");

    public static SimpleDateFormat dateHourTimeFormatV5 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
    
    /**
     * 日期字符串加天
     * 
     * @param src 原日期字符串
     * @param f 格式 1:yyyyMMdd 2:yyyy.MM.dd 3:yyyy-MM-dd 4:yyyy/MM/dd 5:yyyy年MM月dd日
     * @param n 天数，可为负数
     * @return
     */
    public static String dateStrAddDate(String src, int f, int n) {
        SimpleDateFormat sdf = null;
        if (f == 1) {
            sdf = dateFormatV1;
        } else if (f == 2) {
            sdf = dateFormatV2;
        } else if (f == 3) {
            sdf = dateFormatV3;
        } else if (f == 4) {
            sdf = dateFormatV4;
        } else {
            throw new RuntimeException("参数错误");
        }
        Calendar ca = Calendar.getInstance();
        try {
            ca.setTime(sdf.parse(src));
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        ca.add(Calendar.DAY_OF_MONTH, n);
        return sdf.format(ca.getTime());
    }
    
    /**
     * 日期字符串加天
     * 
     * @param src 原日期字符串
     * @param f 格式 1:yyyyMMddHHmmss 2:yyyy.MM.dd HH:mm:ss 3:yyyy-MM-dd HH:mm:ss 4:yyyy/MM/dd HH:mm:ss 5:yyyy年MM月dd日
     *            HH时mm分ss秒
     *            格式 11:yyyyMMddHHmmss 12:yyyy.MM.dd HH:mm:ss 13:yyyy-MM-dd HH:mm:ss 14:yyyy/MM/dd HH:mm:ss
     *            15:yyyy年MM月dd日 HH时mm分ss秒
     *            
     *            格式 21:yyyy年MM月 22:yyyy.MM 23:yyyy-MM 24:yyyy/MM/dd
     * 
     *            格式 31:yyyyMMddHHmm 32:yyyy.MM.dd HH:mm 33:yyyy-MM-dd HH:mm
     *            34:yyyy/MM/dd HH:mm 35:yyyy年MM月dd日 HH时mm分
     * @param n 天数，可为负数
     * @return
     */
    public static String timeStrAddDate(String src, int f, int n) {
        SimpleDateFormat sdf = selectByDateformat(f);
        Calendar ca = Calendar.getInstance();
        try {
            ca.setTime(sdf.parse(src));
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        ca.add(Calendar.DAY_OF_MONTH, n);
        return sdf.format(ca.getTime());
    }
    
    /**
     * 获取当前日期的前后N个月
     * 
     * @param n 前N个月为负数，反之则为正数
     * @return
     */
    public static Date getDateAddMon(int n) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, n);
        Date needDate = c.getTime();
        return needDate;
    }
    
    /**
     * 获取当前日期的前后N个月
     * 
     * @param srcDate 源时间
     * 
     * @param n 前N个月为负数，反之则为正数
     * @return
     */
    public static Date getDateAddMon(Date srcDate, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(srcDate);
        c.add(Calendar.MONTH, n);
        Date needDate = c.getTime();
        return needDate;
    }
    
    public static Date getDateFirstSecond(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }
    
    public static Date getDateAddMonLastSecond(Date srcDate, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(srcDate);
        c.add(Calendar.MONTH, n);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        Date needDate = c.getTime();
        return needDate;
    }
    
    /**
     * 根据日期字符串转Date对象
     * 
     * @param src 源时间
     * 
     * @param f 格式 1:yyyyMMdd 2:yyyy.MM.dd 3:yyyy-MM-dd 4:yyyy/MM/dd 5:yyyy年MM月dd日
     * 
     *            格式 11:yyyyMMddHHmmss 12:yyyy.MM.dd HH:mm:ss 13:yyyy-MM-dd HH:mm:ss 14:yyyy/MM/dd HH:mm:ss
     *            15:yyyy年MM月dd日 HH时mm分ss秒
     *            
     *            格式 21:yyyy年MM月 22:yyyy.MM 23:yyyy-MM 24:yyyy/MM/dd
     * 
     *            格式 31:yyyyMMddHHmm 32:yyyy.MM.dd HH:mm 33:yyyy-MM-dd HH:mm
     *            34:yyyy/MM/dd HH:mm 35:yyyy年MM月dd日 HH时mm分
     * @return
     */
    public static Date parseStr2Date(String src, int fmt) {
        Date date = null;
        if (StringUtils.isEmpty(src)) {
            return date;
        }
        SimpleDateFormat sdf = selectByDateformat(fmt);
        try {
            date = sdf.parse(src);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    
    /**
     * 当前时间
     * 
     * @param f 格式 1:yyyyMMdd 2:yyyy.MM.dd 3:yyyy-MM-dd 4:yyyy/MM/dd 5:yyyy年MM月dd日
     * 
     *            格式 11:yyyyMMddHHmmss 12:yyyy.MM.dd HH:mm:ss 13:yyyy-MM-dd HH:mm:ss 14:yyyy/MM/dd HH:mm:ss
     *            15:yyyy年MM月dd日 HH时mm分ss秒
     *            
     *            格式 21:yyyy年MM月 22:yyyy.MM 23:yyyy-MM 24:yyyy/MM/dd
     * 
     *            格式 31:yyyyMMddHHmm 32:yyyy.MM.dd HH:mm 33:yyyy-MM-dd HH:mm
     *            34:yyyy/MM/dd HH:mm 35:yyyy年MM月dd日 HH时mm分
     * @return
     */
    public static String getTimeNow(int f) {
        return getDateTime(new Date(), f);
    }
    
    /**
     * 当前时间
     * 
     * @param f 格式 1:yyyyMMdd 2:yyyy.MM.dd 3:yyyy-MM-dd 4:yyyy/MM/dd 5:yyyy年MM月dd日
     * 
     *            格式 11:yyyyMMddHHmmss 12:yyyy.MM.dd HH:mm:ss 13:yyyy-MM-dd HH:mm:ss 14:yyyy/MM/dd HH:mm:ss
     *            15:yyyy年MM月dd日 HH时mm分ss秒
     *            
     *            格式 21:yyyy年MM月 22:yyyy.MM 23:yyyy-MM 24:yyyy/MM/dd
     * 
     *            格式 31:yyyyMMddHHmm 32:yyyy.MM.dd HH:mm 33:yyyy-MM-dd HH:mm
     *            34:yyyy/MM/dd HH:mm 35:yyyy年MM月dd日 HH时mm分
     * @return
     */
    public static String getDateTime(Date date, int f) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat sdf = selectByDateformat(f);
        return sdf.format(date);
    }
    
    private static SimpleDateFormat selectByDateformat(int fmt) {
        SimpleDateFormat sdf = null;
        switch (fmt) {
            case 1:
                sdf = dateFormatV1;
                break;
            case 2:
                sdf = dateFormatV2;
                break;
            case 3:
                sdf = dateFormatV3;
                break;
            case 4:
                sdf = dateFormatV4;
                break;
            case 5:
                sdf = dateFormatV5;
                break;
            case 6:
                sdf = dateFormatV6;
                break;
            case 11:
                sdf = dateTimeFormatV1;
                break;
            case 12:
                sdf = dateTimeFormatV2;
                break;
            case 13:
                sdf = dateTimeFormatV3;
                break;
            case 14:
                sdf = dateTimeFormatV4;
                break;
            case 15:
                sdf = dateTimeFormatV5;
                break;
            case 16:
                sdf = dateTimeFormatV6;
                break;
            case 21:
                sdf = yearMothFormatV1;
                break;
            case 22:
                sdf = yearMothFormatV2;
                break;
            case 23:
                sdf = yearMothFormatV3;
                break;
            case 24:
                sdf = yearMothFormatV4;
                break;
            case 31:
                sdf = dateHourTimeFormatV1;
                break;
            case 32:
                sdf = dateHourTimeFormatV2;
                break;
            case 33:
                sdf = dateHourTimeFormatV3;
                break;
            case 34:
                sdf = dateHourTimeFormatV4;
                break;
            case 35:
                sdf = dateHourTimeFormatV5;
                break;
            default:
                throw new RuntimeException("参数错误");
        }
        return sdf;
    }
    
    /**
     * 得到某月的第一天时刻
     */
    public static Date getMonthFirstDay(Date inputDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(inputDate);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
    
    /**
     * 得到某月的最后一天时刻
     */
    public static Date getMonthLastDay(Date inputDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(inputDate);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }
    
    public static List<Date> dayListOfWeek2(Date startDate, int[] day, int count, int hour) {
        GregorianCalendar refDay = new GregorianCalendar();
        refDay.setTime(startDate);
        refDay.add(GregorianCalendar.DATE, -1);
        refDay.set(GregorianCalendar.HOUR_OF_DAY, hour);
        refDay.set(GregorianCalendar.MINUTE, 0);
        refDay.set(GregorianCalendar.SECOND, 0);
        List<Date> dayList = new ArrayList<Date>();
        for (int i = 0; i <= count; i++) {
            refDay.set(GregorianCalendar.DAY_OF_WEEK, 1);
            if (i > 0)
                refDay.add(GregorianCalendar.WEEK_OF_YEAR, 1);
            Date rsDate = refDay.getTime();
            for (int d : day) {
                Date rs = org.apache.commons.lang.time.DateUtils.addDays(rsDate, d - 1);
                if (rs.after(startDate)) {
                    dayList.add(rs);
                    if (dayList.size() == count) {
                        return dayList;
                    }
                }
            }
        }
        return dayList;
    }
    
    public static List<Date> dateListOfMonth2(Date startDate, int[] date, int count, int hour) {
        GregorianCalendar refDay = new GregorianCalendar();
        refDay.setTime(startDate);
        refDay.add(GregorianCalendar.DATE, -1);
        startDate = refDay.getTime();
        
        refDay.set(GregorianCalendar.HOUR_OF_DAY, hour);
        refDay.set(GregorianCalendar.MINUTE, 0);
        refDay.set(GregorianCalendar.SECOND, 0);
        List<Date> dateList = new ArrayList<Date>();
        for (int i = 0; i <= count; i++) {
            refDay.set(GregorianCalendar.DATE, 1);
            if (i > 0)
                refDay.add(GregorianCalendar.MONTH, 1);
            Date rsDate = refDay.getTime();
            for (int d : date) {
                Date rs = org.apache.commons.lang.time.DateUtils.addDays(rsDate, d - 1);
                if (rs.after(startDate)) {
                    dateList.add(rs);
                    if (dateList.size() == count) {
                        return dateList;
                    }
                }
            }
        }
        return dateList;
    }
    
    /**
     * dayListOfWeek
     * 
     * @param day
     * @param count
     * @return
     */
    public static List<Date> dayListOfWeek(int[] day, int count, int hour) {
        GregorianCalendar refDay = new GregorianCalendar();
        refDay.set(GregorianCalendar.HOUR_OF_DAY, hour);
        refDay.set(GregorianCalendar.MINUTE, 0);
        refDay.set(GregorianCalendar.SECOND, 0);
        List<Date> dayList = new ArrayList<Date>();
        for (int i = 0; i <= count; i++) {
            refDay.set(GregorianCalendar.DAY_OF_WEEK, 1);
            if (i > 0)
                refDay.add(GregorianCalendar.WEEK_OF_YEAR, 1);
            Date rsDate = refDay.getTime();
            for (int d : day) {
                Date rs = org.apache.commons.lang.time.DateUtils.addDays(rsDate, d - 1);
                Date now = new Date();
                if (rs.after(now)) {
                    dayList.add(rs);
                    if (dayList.size() == count) {
                        return dayList;
                    }
                }
            }
        }
        return dayList;
    }
    
    /**
     * dateListOfMonth
     * 
     * @param date
     * @param count
     * @return
     */
    public static List<Date> dateListOfMonth(int[] date, int count, int hour) {
        GregorianCalendar refDay = new GregorianCalendar();
        refDay.set(GregorianCalendar.HOUR_OF_DAY, hour);
        refDay.set(GregorianCalendar.MINUTE, 0);
        refDay.set(GregorianCalendar.SECOND, 0);
        List<Date> dateList = new ArrayList<Date>();
        for (int i = 0; i <= count; i++) {
            refDay.set(GregorianCalendar.DATE, 1);
            if (i > 0)
                refDay.add(GregorianCalendar.MONTH, 1);
            Date rsDate = refDay.getTime();
            for (int d : date) {
                Date rs = org.apache.commons.lang.time.DateUtils.addDays(rsDate, d - 1);
                Date now = new Date();
                if (rs.after(now)) {
                    dateList.add(rs);
                    if (dateList.size() == count) {
                        return dateList;
                    }
                }
            }
        }
        return dateList;
    }
    
    /**
     * isBetween
     * 
     * @param start
     * @param end
     * @param date
     * @return
     */
    public static boolean isBetween(Date start, Date end, Date date) {
        GregorianCalendar dateDate = new GregorianCalendar();
        GregorianCalendar startDate = new GregorianCalendar();
        GregorianCalendar endDate = new GregorianCalendar();
        dateDate.setTime(date);
        startDate.setTime(start);
        endDate.setTime(end);
        
        // 如果开始日期和结束日期相同，则结束日期延后1天
        if (startDate.equals(endDate))
            endDate.add(GregorianCalendar.DATE, 1);
        
        if (dateDate.after(startDate) && dateDate.before(endDate)) {
            return true;
        }
        return false;
    }
    
    /**
     * 包括开始和结束日期
     * 
     * @param start
     * @param end
     * @param date
     * @return
     */
    public static boolean isBetween2(Date start, Date end, Date date) {
        GregorianCalendar dateDate = new GregorianCalendar();
        GregorianCalendar startDate = new GregorianCalendar();
        GregorianCalendar endDate = new GregorianCalendar();
        dateDate.setTime(date);
        startDate.setTime(start);
        endDate.setTime(end);
        
        startDate.add(GregorianCalendar.DATE, -1);
        endDate.add(GregorianCalendar.DATE, 1);
        
        if (dateDate.after(startDate) && dateDate.before(endDate)) {
            return true;
        }
        return false;
    }
    
    public static boolean isNotBetween(Date start, Date end, Date date) {
        return !isBetween2(start, end, date);
    }
    
    /**
     * createSendDateList
     * 
     * @param freg
     * @param days
     * @param dates
     * @param sendTime
     * @param count
     * @return
     */
    public static List<Date> createSendDateList(String freg, String days, String dates, String sendTime, int count) {
        List<Date> dayList = null;
        if (StringUtils.equalsIgnoreCase(freg, "T")) {
            dayList = DateUtils.dayListOfWeek(new int[] {1, 2, 3, 4, 5, 6, 7}, count, Integer.parseInt(sendTime));
        }
        if (StringUtils.equalsIgnoreCase(freg, "D")) {
            dayList = DateUtils.dayListOfWeek(new int[] {1, 2, 3, 4, 5, 6, 7}, count, Integer.parseInt(sendTime));
        }
        if (StringUtils.equalsIgnoreCase(freg, "W")) {
            dayList = DateUtils.dayListOfWeek(dateStringToArray(days, ","), count, Integer.parseInt(sendTime));
        }
        if (StringUtils.equalsIgnoreCase(freg, "M")) {
            dayList = DateUtils.dateListOfMonth(dateStringToArray(dates, ","), count, Integer.parseInt(sendTime));
        }
        return dayList;
    }
    
    public static List<Date> createSendDateList2(Date startDate, String freg, String days, String dates,
        String sendTime, int count) {
        List<Date> dayList = null;
        if (StringUtils.equalsIgnoreCase(freg, "T")) {
            dayList =
                DateUtils.dayListOfWeek2(startDate, new int[] {1, 2, 3, 4, 5, 6, 7}, count, Integer.parseInt(sendTime));
        }
        if (StringUtils.equalsIgnoreCase(freg, "D")) {
            dayList =
                DateUtils.dayListOfWeek2(startDate, new int[] {1, 2, 3, 4, 5, 6, 7}, count, Integer.parseInt(sendTime));
        }
        if (StringUtils.equalsIgnoreCase(freg, "W")) {
            dayList =
                DateUtils.dayListOfWeek2(startDate, dateStringToArray(days, ","), count, Integer.parseInt(sendTime));
        }
        if (StringUtils.equalsIgnoreCase(freg, "M")) {
            dayList =
                DateUtils.dateListOfMonth2(startDate, dateStringToArray(dates, ","), count, Integer.parseInt(sendTime));
        }
        return dayList;
    }
    
    /**
     * dateStringToArray
     * 
     * @param dates
     * @param seperator
     * @return
     */
    public static int[] dateStringToArray(String dates, String seperator) {
        String[] dateStringArray = StringUtils.split(dates, seperator);
        int[] dateIntArray = new int[dateStringArray.length];
        for (int i = 0; i < dateStringArray.length; i++) {
            dateIntArray[i] = Integer.parseInt(dateStringArray[i]);
        }
        return dateIntArray;
    }
    
    public String getDate() {
        Calendar dtDatetime = Calendar.getInstance();
        return getDate(dtDatetime);
    }
    
    // 获取日期
    public String getDate(Calendar dtDatetime) {
        String nYear = Integer.toString(dtDatetime.get(Calendar.YEAR));
        String nMonth = Integer.toString(dtDatetime.get(Calendar.MONTH) + 1);
        String nDay = Integer.toString(dtDatetime.get(Calendar.DAY_OF_MONTH));
        nMonth = fillZero(nMonth, 2);
        nDay = fillZero(nDay, 2);
        return nYear + "-" + nMonth + "-" + nDay;
    }
    
    /**
     * 当前日期的前后几个月的日期
     * 
     * @param mouth 月
     * @param day 日
     * @return
     */
    public static String addDate(int mouth, int day) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, mouth);
        cal.add(Calendar.DAY_OF_MONTH, day);
        String current = formatter.format(cal.getTime());
        return current;
    }
    
    // 返回某天是一周中的第几日，周日为0，周六为6
    public int getDay(String sDate) {
        int[] iArr = splitDate(sDate);
        iArr[0] = iArr[0] + 1900;
        Calendar dtDatetime = Calendar.getInstance();
        dtDatetime.set(iArr[0], iArr[1], iArr[2]);
        int nDay = dtDatetime.get(Calendar.DAY_OF_WEEK);
        return nDay - 1;
    }
    
    // 拆分日期
    public int[] splitDate(String sDate) {
        String[] sArr = sDate.split(" ");
        sArr = sArr[0].split("-");
        int[] iArr = new int[3];
        iArr[0] = Integer.parseInt(sArr[0]) - 1900;
        iArr[1] = Integer.parseInt(sArr[1]) - 1;
        iArr[2] = Integer.parseInt(sArr[2]);
        return iArr;
    }
    
    // 如果位数不够填充0
    public String fillZero(String sStr, int Len) {
        if (sStr.length() > Len)
            return sStr;
        else {
            String returnStr = sStr;
            for (int i = 0; i < Len - sStr.length(); i++) {
                returnStr = "0" + returnStr;
            }
            return returnStr;
        }
    }
    
    public String getNextDay(String strDate, int days) {
        try {
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
            Calendar dtDatetime = Calendar.getInstance();
            dtDatetime.setTime(date);
            dtDatetime.add(Calendar.DATE, days);
            return getDate(dtDatetime);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
    
    /**
     * 获得某个日期所在的一周的所有日期
     * 
     * @param date 起始日期
     */
    public String[] getAweeksDate(String date) {
        if (date.equals("")) {
            date = this.getDate();
        }
        String[] weeks = new String[7];
        int weekin = this.getDay(date);
        for (int i = 0; i < 7; i++) {
            weeks[i] = this.getNextDay(date, i - weekin);
        }
        return weeks;
    }
    
    /**
     * hh:mm:ss
     * 
     * @param dtDatetime
     * @return
     */
    public String getTime(Calendar dtDatetime) {
        String nHour = Integer.toString(dtDatetime.get(Calendar.HOUR_OF_DAY));
        String nMin = Integer.toString(dtDatetime.get(Calendar.MINUTE));
        String nSec = Integer.toString(dtDatetime.get(Calendar.SECOND));
        nHour = fillZero(nHour, 2);
        nMin = fillZero(nMin, 2);
        nSec = fillZero(nSec, 2);
        return nHour + ":" + nMin + ":" + nSec;
    }
    
    public String getTime(String sDate) {
        if (sDate == null || sDate.equals(""))
            return "";
        try {
            String[] sArr = sDate.split(" ");
            String time = sArr[1];
            sArr = time.split(":");
            return sArr[0] + ":" + sArr[1];
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    
    public int compareDate(String sDate1, String sDate2) {
        if (sDate1 == null || sDate1.equals(""))
            return 0;
        if (sDate2 == null || sDate2.equals(""))
            return 0;
        
        try {
            java.util.Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(sDate1);
            java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(sDate2);
            int nValue = date1.compareTo(date2);
            return nValue;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static String getTimeString(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String hour = String.valueOf(cal.get(Calendar.HOUR));
        String minute = String.valueOf(cal.get(Calendar.MINUTE));
        String second = String.valueOf(cal.get(Calendar.SECOND));
        StringBuffer sb = new StringBuffer();
        if (hour.length() == 1) {
            sb.append("0" + hour + ":");
        } else {
            sb.append(hour + ":");
        }
        if (minute.length() == 1) {
            sb.append("0" + minute + ":");
        } else {
            sb.append(minute + ":");
        }
        if (second.length() == 1) {
            sb.append("0" + second);
        } else {
            sb.append(second);
        }
        return sb.toString();
    }
    
    public static String getTimeToString(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String hour = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
        String minute = String.valueOf(cal.get(Calendar.MINUTE));
        String second = String.valueOf(cal.get(Calendar.SECOND));
        StringBuffer sb = new StringBuffer();
        if (hour.length() == 1) {
            sb.append("0" + hour + ":");
        } else {
            sb.append(hour + ":");
        }
        if (minute.length() == 1) {
            sb.append("0" + minute + ":");
        } else {
            sb.append(minute + ":");
        }
        if (second.length() == 1) {
            sb.append("0" + second);
        } else {
            sb.append(second);
        }
        return sb.toString();
    }
    
    public static Date joinDateAndHour(Date date, int hour) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(GregorianCalendar.HOUR_OF_DAY, hour);
        return cal.getTime();
    }
    
    public static Date getFirstDateOfThisYear() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(GregorianCalendar.MONTH, GregorianCalendar.JANUARY);
        cal.set(GregorianCalendar.DAY_OF_MONTH, 1);
        cal.set(GregorianCalendar.HOUR_OF_DAY, 0);
        cal.set(GregorianCalendar.MINUTE, 0);
        cal.set(GregorianCalendar.SECOND, 0);
        Date retDate = cal.getTime();
        return retDate;
    }
    
    public static Date getLastDateOfThisYear() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(GregorianCalendar.MONTH, GregorianCalendar.DECEMBER);
        cal.set(GregorianCalendar.DAY_OF_MONTH, 31);
        cal.set(GregorianCalendar.HOUR_OF_DAY, 24);
        cal.set(GregorianCalendar.MINUTE, 0);
        cal.set(GregorianCalendar.SECOND, 0);
        Date retDate = cal.getTime();
        return retDate;
    }
    
    /**
     * yyyyMMddHHmmss
     * 
     * @param dateString
     * @return
     */
    
    
    /**
     * yyyyMMddHHmmss
     * 
     * @param date
     * @return
     */
    public static String toString(String date, String pattern) {
        if (date == null) {
            return "";
        }
        if (pattern == null) {
            pattern = "yyyy-MM-dd";
        }
        
        String dateString = "";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date newDate = new Date();
        
        try {
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            newDate = sdf2.parse(date);
            
            dateString = sdf.format(newDate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dateString;
    }
    
    public String getDateForUniqueness() {
        String str = "";
        Calendar dtDatetime = Calendar.getInstance();
        String nYear = Integer.toString(dtDatetime.get(Calendar.YEAR));
        String nMonth = Integer.toString(dtDatetime.get(Calendar.MONTH) + 1);
        String nDay = Integer.toString(dtDatetime.get(Calendar.DAY_OF_MONTH));
        String nHour = Integer.toString(dtDatetime.get(Calendar.HOUR_OF_DAY));
        String nMin = Integer.toString(dtDatetime.get(Calendar.MINUTE));
        String nSec = Integer.toString(dtDatetime.get(Calendar.SECOND));
        String nMiSec = Integer.toString(dtDatetime.get(Calendar.MILLISECOND));
        nMonth = fillZero(nMonth, 2);
        nDay = fillZero(nDay, 2);
        nHour = fillZero(nHour, 2);
        nMin = fillZero(nMin, 2);
        nSec = fillZero(nSec, 2);
        str = nYear + nMonth + nDay + nHour + nMin + nSec + nMiSec;
        return str;
        
    }
    
    /**
     * 获取年龄
     * 
     * @param birthDay
     * @return
     */
    public static int getAge(Date birthDay) {
        int age = 0;
        if (birthDay == null) {
            return age;
        }
        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        age = yearNow - yearBirth > 0 ? yearNow - yearBirth : 0;
        return age;
    }
    
    /**
     * 
     * @Description: 获取当前时间字符串 ，输出格式： 2015-01-01 00:00:00
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public static String getCurDateString() {
        String s = "";
        java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        s = format1.format(new Date());
        return s;
    }
    
    /**
     * 计算两个日期之间相差的天数
     * 
     * @param smdate 较小的时间（计算服务天数：当天）
     * @param bdate 较大的时间 （计算服务天数：服务结束时间）
     * @return 相差天数
     * @throws ParseException
     */
    public static int getdays(Date smdate, Date bdate) throws ParseException {
        smdate = dateFormatV3.parse(dateFormatV3.format(smdate)); // 去除时分秒计算
        bdate = dateFormatV3.parse(dateFormatV3.format(bdate)); // 去除时分秒计算
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        
        return Integer.parseInt(String.valueOf(between_days));
    }
    
    /**
     * 判断日期是否同年同月
     * 
     * @param smdate 较小的时间（计算服务天数：当天）
     * @param bdate 较大的时间 （计算服务天数：服务结束时间）
     * @return 是与否
     */
    public static boolean isSameYearAndMonth(Date date1, Date date2) {
        boolean isSameYearMonth = false;
        if (null == date1 || null == date2) {
            return isSameYearMonth;
        }
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);// subYear==0,说明是同一年
        if (subYear == 0) {
            if (cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)) {// 说明是同一月
                isSameYearMonth = true;
            }
        }
        return isSameYearMonth;
    }
    
    /**
     * @param date1
     * 
     * @param date2
     * 
     * @return 相差月数(绝对值正数)
     */
    public static int getMonthSpace(Date date1, Date date2) {
        int result = 0;
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
        int subMonth = cal1.get(Calendar.MONTH) - cal2.get(Calendar.MONTH);
        result = Math.abs(subYear * 12 + subMonth);
        return result;
    }
    
    // 计算两个时间的月份差
    public static int getMonthSpace(String date1, String date2) {
        int result = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(sdf.parse(date1));
            c2.setTime(sdf.parse(date2));
            result = c2.get(Calendar.MONDAY) - c1.get(Calendar.MONTH);
            return result == 0 ? 0 : Math.abs(result);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    // 计算两个时间的小时差
    public static long getHourSpace(Date date1, Date date2) {
        try {
            long nd = 1000 * 24 * 60 * 60;
            long nh = 1000 * 60 * 60;
            long nm = 1000 * 60;
            // long ns = 1000;
            // 获得两个时间的毫秒时间差异
            long diff = date2.getTime() - date1.getTime();
            // 计算差多少天
            long day = diff / nd;
            // 计算差多少小时
            long hour = diff % nd / nh;
            // 计算差多少分钟
            long min = diff % nd % nh / nm;
            return day * 24 + hour;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    /**
     * @param args
     * @throws ParseException
     */
	public static void main(String[] args) throws ParseException {
		Date date=new Date();
		SimpleDateFormat s=new SimpleDateFormat("yyyy'年'MM'月'dd'日'");
		System.out.println(s.format(date));
		String str1=s.format(date);//当前的时间

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 90);//计算30天后的时间
		String str2=s.format(c.getTime());
		System.out.println("30天后的时间是："+str2);
 }
    
    /**
     * @Description: 比较两个日期的大小
     * @param date1
     * @param date2
     * @param f 格式 1:yyyyMMddHHmmss 2:yyyy.MM.dd HH:mm:ss 3:yyyy-MM-dd HH:mm:ss 4:yyyy/MM/dd HH:mm:ss 5:yyyy年MM月dd日
     *            HH时mm分ss秒
     *            格式 11:yyyyMMddHHmmss 12:yyyy.MM.dd HH:mm:ss 13:yyyy-MM-dd HH:mm:ss 14:yyyy/MM/dd HH:mm:ss
     *            15:yyyy年MM月dd日 HH时mm分ss秒
     *            
     *            格式 21:yyyy年MM月 22:yyyy.MM 23:yyyy-MM 24:yyyy/MM/dd
     * 
     *            格式 31:yyyyMMddHHmm 32:yyyy.MM.dd HH:mm 33:yyyy-MM-dd HH:mm
     *            34:yyyy/MM/dd HH:mm 35:yyyy年MM月dd日 HH时mm分
     *            
     * @return int 1:date1>date2; -1:date1<date2; 0 :date1=date2。
     */
    public static int compareDate(String date1, String date2, int f) {
        SimpleDateFormat sdf = selectByDateformat(f);
        try {
            Date dt1 = sdf.parse(date1);
            Date dt2 = sdf.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
    
    public static String getTimeTypeDes(String timeType) {
        String des = "";
        if ("AM".equals(timeType)) {
            des = "上午";
        } else if ("PM".equals(timeType)) {
            des = "下午";
        } else if ("NM".equals(timeType)) {
            des = "晚上";
        }
        return des;
    }
    
    public static String getTimeDealByType(String timeType) {
        String timeDeal = "";
        if ("AM".equals(timeType)) {
            timeDeal = "8:30~12:00";
        } else if ("PM".equals(timeType)) {
            timeDeal = "14:30~17:30";
        }
        return timeDeal;
    }
    
    public static String getDateWeekName(Date date) {
        String str = "周一";
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int i = cal.get(Calendar.DAY_OF_WEEK) - 1;
        switch (i) {
            case 0:
                str = "周日";
                break;
            case 1:
                str = "周一";
                break;
            case 2:
                str = "周二";
                break;
            case 3:
                str = "周三";
                break;
            case 4:
                str = "周四";
                break;
            case 5:
                str = "周五";
                break;
            case 6:
                str = "周六";
                break;
        
        }
        return str;
    }
    
    /**
     * @Description: 根据日期获取该月最后一天
     */
    public static String getLastDateTime(Date date) {
        String time = "";
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        time = sdf.format(c.getTime());
        return time;
    }
}
