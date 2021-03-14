package date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @ClassName DateTest
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/23 9:42
 * @Version 1.0
 */
public class DateTest {

    private final String timeFormat = "yyyy年MM月dd日 HH:mm:ss";

    @Test
    public void dateConstructor() {
        Date date = new Date();
        System.out.println("date = " + date);
        Date date1 = new Date(System.currentTimeMillis() + (1000 * 60 * 60));
        System.out.println("date1 = " + date1);
    }

    @Test
    public void getAndSetTime() {
        Date date = new Date();
        System.out.println("date.getTime() = " + date.getTime());
        date.setTime(0L);
        System.out.println("date.getTime() = " + date.getTime());
    }

    @Test
    public void simpleDateFormat() {
        //无参
        SimpleDateFormat sdf = new SimpleDateFormat();
        System.out.println("sdf.format(new Date()) = " + sdf.format(new Date()));
        //有参
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("simpleDateFormat.format(new Date()) = " + simpleDateFormat.format(new Date()));

        String date = "1998-04-24 10:05:54";
        //解析
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date parse = dateFormat.parse(date);
            System.out.println("parse = " + parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void simpleDateFormatParse() throws ParseException {
        String start = "2020年11月11日 0:0:0";
        String end = "2020年11月11日 0:10:0";
        String jia = "2020年11月11日 0:03:47";
        String pi = "2020年11月11日 0:10:11";
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
        long startTime = sdf.parse(start).getTime();
        long endTime = sdf.parse(end).getTime();
        long jiaTime = sdf.parse(jia).getTime();
        long piTime = sdf.parse(pi).getTime();
        if (jiaTime >= startTime && jiaTime <= endTime) {
            System.out.println("小贾同学参加上了秒杀活动");
        } else {
            System.out.println("小贾同学没有参加上秒杀活动");
        }
        System.out.println("------------------------");
        if (piTime >= startTime && piTime <= endTime) {
            System.out.println("小皮同学参加上了秒杀活动");
        } else {
            System.out.println("小皮同学没有参加上秒杀活动");
        }
    }

    @Test
    public void plusOneDay() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String timeStr = "1998年4月24日 18:5:35";
        Date date = simpleDateFormat.parse(timeStr);
        long time = date.getTime() + (1000 * 60 * 60 * 24);
        date.setTime(time);
        System.out.println("simpleDateFormat.format(date) = " + simpleDateFormat.format(date));
    }


    @Test
    public void localDateAndTimeAndDateTime() {
        System.out.println("LocalDate.now() = " + LocalDate.now());
        System.out.println("LocalTime.now() = " + LocalTime.now());
        System.out.println("LocalDateTime.now() = " + LocalDateTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timeFormat);
        LocalDateTime time = LocalDateTime.of(1998, 4, 24, 18, 55, 55);
        System.out.println("time = " + time);
        String format = time.format(formatter);
        System.out.println("format = " + format);
        System.out.println("time = " + time);
        System.out.println("----------------------------------------------------------------------");
        System.out.println("time.getYear() = " + time.getYear());
        System.out.println("time.getMonth() = " + time.getMonth());
        System.out.println("time.getMonthValue() = " + time.getMonthValue());
        System.out.println("time.getDayOfMonth() = " + time.getDayOfMonth());
        System.out.println("time.getDayOfWeek() = " + time.getDayOfWeek());
        System.out.println("time.getDayOfYear() = " + time.getDayOfYear());
        System.out.println("time.getHour() = " + time.getHour());
        System.out.println("time.getMinute() = " + time.getMinute());
        System.out.println("time.getSecond() = " + time.getSecond());
    }

    @Test
    public void localDateTimePlus() {
        LocalDateTime dt = LocalDateTime.of(2020, 5, 20, 13, 14, 20);
        System.out.println("dt.plusYears(10) = " + dt.plusYears(10));
        System.out.println("dt.plusMonths(8) = " + dt.plusMonths(8));
        System.out.println("dt.minusYears(10) = " + dt.minusYears(10));
        System.out.println("dt.minusMonths(8) = " + dt.minusMonths(8));
    }

    @Test
    public void localDateTimeWith() {
        LocalDateTime dt = LocalDateTime.of(2020, 5, 20, 13, 14, 20);
        LocalDateTime localDateTime = dt.withSecond(20).withNano(131400000);
        System.out.println("localDateTime = " + localDateTime);
    }

    @Test
    public void compareTime() {
        LocalDateTime before = LocalDateTime.of(2020, 5, 20, 13, 14, 20);
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now.isAfter(before) = " + now.isAfter(before));
        System.out.println("now.isBefore(before) = " + now.isBefore(before));
        System.out.println("now.isEqual(before) = " + now.isEqual(before));
    }

    @Test
    public void period() {
        Period between = Period.between(LocalDate.of(2020, 5, 20),
                LocalDate.of(2021, 6, 30));
        System.out.println("between = " + between);
    }

    @Test
    public void duration() {
        //可以传入LocalDateTime对象
        LocalDateTime dt1 = LocalDateTime.of(2020, 5, 20, 13, 14, 20);
        LocalDateTime dt2 = LocalDateTime.of(2011, 11, 11, 11, 11, 11);
        //Duration 必须传入带秒的日期对象 LocalDate就不行
        Duration between = Duration.between(dt1, dt2);
        System.out.println("between = " + between);
        System.out.println("between.toDays() = " + between.toDays());
        System.out.println("between.toDaysPart() = " + between.toDaysPart());
        System.out.println("between.toSeconds() = " + between.toSeconds());
        System.out.println("between.toSecondsPart() = " + between.toSecondsPart());

    }

    @Test
    public void testMethodName() {
        LocalDateTime of = LocalDateTime.of(2020, 11, 11, 11, 11, 11);
        System.out.println("of = " + of);
    }


}
