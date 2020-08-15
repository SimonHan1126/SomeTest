package test;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

import java.text.ParseException;

/**
 * @author hanshihui
 */
public class Test {

    public static Date parseDate(String dateStr, String format) {
        try {
            return (Date) new SimpleDateFormat(format).parse(dateStr);
        }
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String formatDateByFormat(Date date, String format) {
        String result = "";
        if (date != null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                result = sdf.format(date);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static String formatDate(Date date, String style) {
        return formatDateByFormat(date, style);
    }

    public static String turnPreviousDate(String showDate, String format, int interDay) {
        // 日期减指定天数
        Calendar cal = Calendar.getInstance();
        Date tempDate_001 = parseDate(showDate, format);
        if (null == tempDate_001) {
            return null;
        }
        cal.setTime(tempDate_001);
        cal.add(Calendar.DAY_OF_MONTH, interDay);
        String next = formatDate(cal.getTime(), format);
        return next;
    }

    public static void main(String[] args) {
//        System.out.println(turnPreviousDate("2017-11-18","yyyy-mm-dd",-18));
//
//        int num1 = 23;
//        int num2 = 68;
//        double d = (double)num1 / (double)num2;
//        System.out.println("jaaa1111 " + d);
//        NumberFormat num = NumberFormat.getPercentInstance();
//        num.setMinimumFractionDigits(2);
//
//        System.out.println("jbbbb2222 " + num.format(d));
//
//
//        BigDecimal bigDecimal = new BigDecimal(123.00);
//        double resNumber = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//        System.out.println("111111111111111111 " + resNumber);
//
//        NumberFormat nf = NumberFormat.getNumberInstance();
//
//        // notice here
//
//        nf.setMaximumFractionDigits(2);
//        System.out.println("22222222222 " + nf.format(123.10));

        List<String> dateList = new ArrayList<>();
        dateList.add("20170912");
        dateList.add("20171012");
        dateList.add("20170812");
        dateList.add("20170927");
        dateList.add("20171128");
        dateList.add("20170324");
        Collections.sort(dateList,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if(o1.compareTo(o2) < 0){
                    return 1;
                }
                if(o1.compareTo(o2)> 0){
                    return -1;
                }
                if(o1.compareTo(o2) == 0){
                    return 0;
                }
                return 0;
            }
        });
        for(String s:dateList){
            System.out.println(s);
        }

        List<String> list = new ArrayList<>();
        list.add("lili");
        list.add("luck");
        list.add("7777");
//        Predicate<String> pred = name -> "lili".equals(name);
//        list.remove(pred);
        System.out.println(list);

        int a=5,b=7;
        int c= a+=2*3+b--;
        System.out.println("c=" + c);
    }

    @org.junit.Test
    public void test()
    {
    	String expectStrDate = formatDateByFormat(parseDate("20180128", "yyyyMMdd"),"yyyy-MM-dd");
    	assertEquals( "date " , "2018-01-28", expectStrDate);
    }
}
