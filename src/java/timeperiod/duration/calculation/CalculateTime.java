package timeperiod.duration.calculation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class CalculateTime {

    private byte day;
    private byte month;
    private int year;
    private int date;
    private String shTime;
    private String time;

    public void saveShortTime(long oldTimestamp) {
        String newTime;
        long newTimestamp = System.currentTimeMillis();
        long difference = (newTimestamp - oldTimestamp) / 1000;
        if (difference <= 60) {
            newTime = difference + "s";
        } else if (difference <= 3600) {
            newTime = (difference / 60) + "m";
        } else if (difference <= 86400) {
            newTime = (difference / 3600) + "h";
        } else if (difference <= 604800) {
            newTime = (difference / 86400) + "d";
        } else {
            newTime = (difference / 604800) + "w";
        }
        setTime(newTime);
    }

    public void saveDateTime(long timestamp) {
        Date preTime = new Date(timestamp);
        SimpleDateFormat set_day = new SimpleDateFormat("u");
        SimpleDateFormat set_month = new SimpleDateFormat("M");
        SimpleDateFormat set_date = new SimpleDateFormat("dd");
        SimpleDateFormat set_year = new SimpleDateFormat("yyyy");
        SimpleDateFormat set_time = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat set_shtime = new SimpleDateFormat("hh:mm a");
        setDay(Byte.parseByte(set_day.format(preTime)));
        setMonth(Byte.parseByte(set_month.format(preTime)));
        setDate(Integer.parseInt(set_date.format(preTime)));
        setYear(Integer.parseInt(set_year.format(preTime)));
        setShTime(set_shtime.format(preTime));
        setTime(set_time.format(preTime));
    }

    public void getCalendar(String m, String d, String y) {
        Pattern MonthPattern = Pattern.compile("^(0[1-9]|1[0-2])$");
        Pattern DatePattern = Pattern.compile("^(0[1-9]|1[0-9]|2[0-9]|3[0-1])$");
        Pattern YearPattern = Pattern.compile("^\\d{4}$");
        int mon = (m != null) && (MonthPattern.matcher(m).matches()) ? Byte.valueOf(m) : 0;
        int dat = (d != null) && (DatePattern.matcher(d).matches()) ? Byte.valueOf(d) : 0;
        int yea = (y != null) && (YearPattern.matcher(y).matches()) ? Integer.valueOf(y) : 0;

        int a[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int c;
        if (dat > a[mon]) {
            if (yea % 4 == 0) {
                c = 0;
            } else {
                c = 1;
            }
            if (yea % 100 == 0) {
                yea = yea / 100;
                if (yea % 4 == 0) {
                    c = 0;
                } else {
                    c = 1;
                }
                yea = yea * 100;
            }
            if (c == 0) {
                a[2] = 29;
            } else {
                a[2] = 28;
            }

            dat = dat - a[mon];
            if (mon > 0) {
                mon = mon + 1;
            }

            if (mon > 12) {
                yea = yea + 1;
                mon = 1;
            }
        }
        setDay((byte) dat);
        setMonth((byte) mon);
        setYear(yea);
    }

    public void setDay(byte day) {
        this.day = day;
    }

    public byte getDay() {
        return this.day;
    }

    public void setMonth(byte month) {
        this.month = month;
    }

    public byte getMonth() {
        return this.month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getDate() {
        return this.date;
    }

    public void setShTime(String shTime) {
        this.shTime = shTime;
    }

    public String getShTime() {
        return this.shTime;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return this.time;
    }
}
