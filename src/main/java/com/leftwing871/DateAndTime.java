package com.leftwing871;

import java.util.Calendar;
import java.util.Date;

public class DateAndTime {

    public static void main(String[] args) {
        //1. Calendar를 Date로 변환
        Calendar cal = Calendar.getInstance();
        Date d = new Date(cal.getTimeInMillis());   //Date(long date)

        //2.Date를 Calendar로 변환
        Date dd = new Date();
        Calendar calcal = Calendar.getInstance();
        cal.setTime(dd);
    }

    //

}
