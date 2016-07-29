package com.juange.jgdatetime;

import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.Year;
import java.util.ArrayList;
import java.util.Arrays;

public class JGDateTime {

    private LocalDateTime localDateTime = null;

    public JGDateTime() {
        localDateTime = LocalDateTime.now();
    }

    public JGDateTime(int year, int month, int dayOfMonth, int hour, int minute) {
        this.localDateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
    }

    public int getHour() {
        return localDateTime.getHour();
    }

    public int getMinute() {
        return localDateTime.getMinute();
    }

    public int getDay() {
        return localDateTime.getDayOfMonth();
    }

    public int getMonth() {
        return localDateTime.getMonthValue();
    }

    public int getYear() {
        return localDateTime.getYear();
    }

    public int getDayOfYear() {
        return localDateTime.getDayOfYear();
    }

    public int getDayOfTheMonth() {
        return localDateTime.getDayOfMonth();
    }

    public int getLastDayOfMonth() {
        boolean leap = Year.isLeap(localDateTime.getYear());
        return localDateTime.getMonth().length(leap);
    }

    public boolean isLastDayOfMonth() {
        int lastDayOfMonth = getLastDayOfMonth();
        int dayOfMonth = localDateTime.getDayOfMonth();
        return lastDayOfMonth == dayOfMonth;
    }

    public boolean isWorkingDay() {
        String[] holidayList = { "1/1", "6/1", "25/3", "28/3", "24/6", "15/8", "12/10", "1/11", "6/12", "8/12",
                                 "26/12" };
        ArrayList<String> holidayArrayList = new ArrayList<>(Arrays.asList(holidayList));

        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            return false;
        }

        String dayMonth = localDateTime.getDayOfMonth() + "/" + localDateTime.getMonthValue();
        return !holidayArrayList.contains(dayMonth);
    }
}
