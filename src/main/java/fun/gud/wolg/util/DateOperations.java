/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fun.gud.wolg.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.joda.time.Interval;
import org.joda.time.Period;

/**
 *
 * @author Danylo
 */
public class DateOperations {
    private String timestamp ;
    private String day ;
    private final SimpleDateFormat timestampFormatter ; 
    private final SimpleDateFormat dayFormatter ;

    public DateOperations() {
        timestampFormatter = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss");
        dayFormatter = new SimpleDateFormat("YYYY.MM.dd");
        timestamp = timestampFormatter.format(Calendar.getInstance().getTime());
        day = dayFormatter.format(Calendar.getInstance().getTime());
    }
    
    
    
    
    
    public  String delta(String start , String end ){
        try {
            Interval interval = new Interval(timestampFormatter.parse(start).getTime(),timestampFormatter.parse(end).getTime());
            Period p = interval.toPeriod();
            return Integer.toString(p.getHours())+":"+Integer.toString(p.getMinutes())+":"+Integer.toString(p.getSeconds());
        } catch (Exception e ){
            return "Error while calculating interval!";
        }
    }   

    public String getTimestamp() {
        timestamp = timestampFormatter.format(Calendar.getInstance().getTime());
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDay() {
        day = dayFormatter.format(Calendar.getInstance().getTime());
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

   

  
    
    
    
}
