/*
 * Created on 2005/1/20
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package tradevan.helpdesk;

import com.tradevan.taurus.xdao.SqlPredicate;
import com.tradevan.taurus.xdao.SqlWhere;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * @author Tear Chen
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class DateTimeUtil {

    /** Creates a new instance of SystemDateTime */
    private DateTimeUtil() {

    }

    public static final String[] WEEK_NAME = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };

    public static String getDate() {
        return getFormatDateTime("yyyyMMdd");
    }

    public static String getTime() {
        return getFormatDateTime("HHmmssSSS");
    }

    public static String getDateTime() {
        return getFormatDateTime("yyyyMMddHHmmssSSS");
    }
    
    public static String getDateTime(Timestamp time) {
        return getFormatDateTime("yyyyMMddHHmmssSSS", time);
    }

    public static String getFormatedDateTime() {
        return getFormatDateTime("yyyy/MM/dd HH:mm:ss SSS");
    }

    public static String getNormalDateTime() {
        return getFormatDateTime("yyyy/MM/dd HH:mm");
    }

    public static String getDateTimeBeMins(int minutes) {
        return getTimeStampBeMins("yyyyMMddHHmm", minutes);
    }

    public static String getDateTimeBeDays(int days) {
        return getTimeStampBeDays("yyyyMMdd", days);
    }

    public static String getFormatDateTime(String format) {
        // get date time stamp from system
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateTimeStamp = formatter.format(new Date());
        return dateTimeStamp;
    }
    
    public static String getFormatDateTime(String format, Timestamp time) {
        // get date time stamp from system
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateTimeStamp = formatter.format(time);
        return dateTimeStamp;
    }

    public static String getTimeStampBeMins(String format, int minutes) {
        // get date time stamp from system
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateTimeStamp = formatter.format(new Date((new Date()).getTime() - 1000 * 60L * minutes));
        return dateTimeStamp;
    }

    public static String getTimeStampBeDays(String format, int days) {
        // get date time stamp from system
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateTimeStamp = formatter.format(new Date((new Date()).getTime() - 1000 * 60 * 60 * 24L * days));
        return dateTimeStamp;
    }

    public static String getTimeStampAfDays(String format, int days) {
        // get date time stamp from system
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateTimeStamp = formatter.format(new Date((new Date()).getTime() + 1000 * 60 * 60 * 24L * days));
        return dateTimeStamp;
    }

    public static String subtractTime(String startDTS, String endDTS) {
        if (startDTS.length() != 17 || endDTS.length() != 17)
            return "ERROR";
        if (startDTS.equals(endDTS))
            return "0";
        int startYear = Integer.parseInt(startDTS.substring(0, 4));
        int startMonth = Integer.parseInt(startDTS.substring(4, 6)) - 1;
        int startDay = Integer.parseInt(startDTS.substring(6, 8));
        int startHour = Integer.parseInt(startDTS.substring(8, 10));
        int startMinute = Integer.parseInt(startDTS.substring(10, 12));
        int startSecond = Integer.parseInt(startDTS.substring(12, 14));
        // int startMilliSecond = Integer.parseInt(startDTS.substring(14,17));
        int endYear = Integer.parseInt(endDTS.substring(0, 4));
        int endMonth = Integer.parseInt(endDTS.substring(4, 6)) - 1;
        int endDay = Integer.parseInt(endDTS.substring(6, 8));
        int endHour = Integer.parseInt(endDTS.substring(8, 10));
        int endMinute = Integer.parseInt(endDTS.substring(10, 12));
        int endSecond = Integer.parseInt(endDTS.substring(12, 14));
        // int endMilliSecond = Integer.parseInt(endDTS.substring(14,17));
        Calendar cStart = Calendar.getInstance();
        Calendar cEnd = Calendar.getInstance();
        cStart.set(startYear, startMonth, startDay, startHour, startMinute, startSecond);
        cEnd.set(endYear, endMonth, endDay, endHour, endMinute, endSecond);
        Date start = cStart.getTime();
        Date end = cEnd.getTime();
        long subtractTime = (end.getTime() - start.getTime()) / 1000;
        return "" + subtractTime;
    }

    public static String getFirstDayofWeek(String queryDTS) {
        if (queryDTS.length() != 8)
            return "ERROR";
        int year = Integer.parseInt(queryDTS.substring(0, 4));
        int month = Integer.parseInt(queryDTS.substring(4, 6)) - 1;
        int day = Integer.parseInt(queryDTS.substring(6, 8));
        SimpleDateFormat formatter = new SimpleDateFormat("EEE");
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        Date today = c.getTime();
        String week = formatter.format(today);
        int substractDay = 0;
        for (int i = 0; i < WEEK_NAME.length; i++) {
            if (week.equals(WEEK_NAME[i])) {
                substractDay = i;
                break;
            }
        }
        if (substractDay == 0)
            return queryDTS;
        Date firstDayofWeek = new Date(today.getTime() - 1000 * 60 * 60 * 24L * substractDay);
        formatter = new SimpleDateFormat("yyyyMMdd");
        String dateStamp = formatter.format(firstDayofWeek);

        return dateStamp;
    }

    public static String[] getDateofWeek(String queryDTS) {
        String[] dateStampArray = { queryDTS, queryDTS, queryDTS, queryDTS, queryDTS, queryDTS, queryDTS };
        if (queryDTS.length() != 8)
            return null;
        int year = Integer.parseInt(queryDTS.substring(0, 4));
        int month = Integer.parseInt(queryDTS.substring(4, 6)) - 1;
        int day = Integer.parseInt(queryDTS.substring(6, 8));
        SimpleDateFormat formatter = new SimpleDateFormat("EEE");
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        Date today = c.getTime();
        String week = formatter.format(today);
        int substractDay = 0;
        for (int i = 0; i < WEEK_NAME.length; i++) {
            if (week.equals(WEEK_NAME[i])) {
                substractDay = i;
                break;
            }
        }
        formatter = new SimpleDateFormat("yyyyMMdd");
        for (int j = 0; j < WEEK_NAME.length; j++) {
            Date DayofWeek = new Date(today.getTime() - 1000 * 60 * 60 * 24L * (substractDay - j));
            String dateStamp = formatter.format(DayofWeek);
            dateStampArray[j] = dateStamp;
        }
        return dateStampArray;
    }

    // queryday與現在時間比較 是否超過days
    public static boolean overDays(String queryday, int days) {
        if (queryday == null || queryday.length() < 8)
            return true;
        int qtyYear = Integer.parseInt(queryday.substring(0, 4));
        int qtyMonth = Integer.parseInt(queryday.substring(4, 6)) - 1;
        int qtyDay = Integer.parseInt(queryday.substring(6, 8));
        Calendar qryDate = Calendar.getInstance();
        Calendar nowDate = Calendar.getInstance();
        qryDate.set(qtyYear, qtyMonth, qtyDay);
        Date query = qryDate.getTime();
        Date today = nowDate.getTime();
        if (today.getTime() - query.getTime() < 1000 * 60 * 60 * 24L * days)
            return false;
        return true;
    }

    // 判斷兩組時間間距 是否大於days天數
    public static boolean overDays(String querysday, String queryeday, int days) {
        if (querysday == null || querysday.length() < 8)
            return true;
        else
            querysday += "00000000000000000".substring(querysday.length());
        ;
        if (queryeday == null || queryeday.length() < 8)
            return true;
        else
            queryeday += "00000000240000000".substring(queryeday.length());
        ;
        if (Long.parseLong(subtractTime(querysday, queryeday)) <= 60 * 60 * 24L * days)
            return false;
        return true;
    }

    // 某時段time N天後 的時間
    public static String getTimeAfDays(String time, int days) {
        time += "00000000000000000".substring(time.length());
        ;
        int year = Integer.parseInt(time.substring(0, 4));
        int month = Integer.parseInt(time.substring(4, 6)) - 1;
        int day = Integer.parseInt(time.substring(6, 8));
        int hour = Integer.parseInt(time.substring(8, 10));
        int minute = Integer.parseInt(time.substring(10, 12));
        int second = Integer.parseInt(time.substring(12, 14));

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute, second);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateTimeStamp = formatter.format(new Date(calendar.getTime().getTime() + 1000 * 60 * 60 * 24L * days));
        return dateTimeStamp;
    }

    // 某時段time N天前 的時間
    public static String getTimeBeDays(String time, int days) {
        time += "00000000240000000".substring(time.length());
        ;
        int year = Integer.parseInt(time.substring(0, 4));
        int month = Integer.parseInt(time.substring(4, 6)) - 1;
        int day = Integer.parseInt(time.substring(6, 8));
        int hour = Integer.parseInt(time.substring(8, 10));
        int minute = Integer.parseInt(time.substring(10, 12));
        int second = Integer.parseInt(time.substring(12, 14));

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute, second);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateTimeStamp = formatter.format(new Date(calendar.getTime().getTime() - 1000 * 60 * 60 * 24L * days));
        return dateTimeStamp;
    }

    // 2007.12.25 若無帶入起始日期, 須以今天來算
    public static void putStartDTS(Map<String, Object> values, SqlWhere where, String field, String dbfield) {
        String dts_start = getStartDTS((String) values.get(field));
        if (dts_start != null && dts_start.length() != 0) {
            where.add(new SqlPredicate(dbfield, ">=", dts_start));
        }
    }

    // 2007.12.25 若無帶入結束日期, 須以今天來算
    public static void putEndDTS(Map<String, Object> values, SqlWhere where, String field, String dbfield) {
        String dts_end = getEndDTS((String) values.get(field));
        if (dts_end != null && dts_end.length() != 0) {
            where.add(new SqlPredicate(dbfield, "<=", dts_end));
        }
    }

    public static String getStartDTS(String dts) {
        if (dts == null || dts.length() < 8)
            return getDate();
        return dts;
    }

    public static String getEndDTS(String dts) {
        if (dts == null || dts.length() < 8)
            dts = getDate();
        dts += "99999999999999999".substring(dts.length());
        return dts;
    }

    public static String getEndDTStoDate(String dts) {
        if (dts == null || dts.length() < 8)
            dts = getDate();
        if (dts.length() == 8)
            dts += "235959";
        else if (dts.length() == 10)
            dts += "5959";
        else if (dts.length() == 12)
            dts += "59";
        return dts;
    }

    public static String formatStr2DTSToMin(String dts) {
        if (dts != null && dts.length() >= 12) {
            dts = dts.substring(4, 6) + "/" + dts.substring(6, 8) + " " + dts.substring(8, 10) + ":" + dts.substring(10, 12);
        }
        return dts;
    }

    public static String formatStr2DTS(String dts) {
        if (dts != null && dts.length() >= 14) {
            dts = dts.substring(4, 6) + "/" + dts.substring(6, 8) + " " + dts.substring(8, 10) + ":" + dts.substring(10, 12) + ":"
                    + dts.substring(12, 14);
        }
        return dts;
    }
    
    public static String formatStr3DTS(String dts) {
        if (dts != null && dts.length() >= 14) {
            dts = dts.substring(0, 4) + "-" + dts.substring(4, 6) + "-" + dts.substring(6, 8) 
                  + " " + dts.substring(8, 10) + ":" + dts.substring(10, 12) + ":" + dts.substring(12, 14);
        }
        return dts;
    }

    public static String formatStr2Date(String dts) {
        if (dts != null && dts.length() >= 8) {
            dts = dts.substring(4, 6) + "/" + dts.substring(6, 8);
        }
        return dts;
    }

    public static String getStrDate(String dts) {
        if (dts != null && dts.length() >= 8) {
            dts = dts.substring(0, 8);
        }
        return dts;
    }

    public static String formatLong2DTS(String dts) {
        try {

            SimpleDateFormat stringFormat = new SimpleDateFormat("yyyyMMddHHmmsssss");
            Date dtd = stringFormat.parse(dts);
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd HH:mm:ss");
            String fdt = formatter.format(dtd);
            return fdt;
        } catch (Exception e) {
        }
        return dts;
    }

    public static String formatStr2Min(String dts) {
        if (dts.length() >= 6) {
            dts = dts.substring(0, 2) + ":" + dts.substring(2, 4) + ":" + dts.substring(4, 6);
        }
        return dts;
    }

    public static String getCalenderStr(Date d) {
        // get date time stamp from system
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateTimeStamp = formatter.format(d);
        return dateTimeStamp;
    }




    
    

public static boolean diffTimeBigThanThreshold(long dts1, long dts2, long threadhold_min) {
    
    long diff = Math.abs(dts1 - dts2);
    if ((diff / 60000) > threadhold_min) {
        return true;
    }
    return false;
}

}
