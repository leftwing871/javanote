package javaexample;

import java.util.Calendar;

public class CalculateDate01 {
    public static void main(String[] args)
    {
        System.out.println(getDalcomStageCurrentDate(0));

    }

    public static int getDalcomStageCurrentDate(int offset) {

        Calendar calendar = Calendar.getInstance();


        calendar.setFirstDayOfWeek(1);
        calendar.add(Calendar.DATE, (7 * offset));
        int result = calendar.getWeekYear() * 100;

        System.out.println("result: " + result);
        int weekOfWear = calendar.get(Calendar.WEEK_OF_YEAR);
        System.out.println("weekOfWear: " + weekOfWear);
        System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("Calendar.SUNDAY: " + Calendar.SUNDAY);
        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY && calendar.get(Calendar.HOUR_OF_DAY) < 2)) {
            System.out.println("if enter : before " + weekOfWear);
            weekOfWear--;
            System.out.println("if enter : after " + weekOfWear);
        }
        result += weekOfWear;


        return result;
    }
}
