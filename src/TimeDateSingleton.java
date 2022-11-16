import enums.Months;

import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TimeDateSingleton {




    //public Month month;
    //public int day;
    //public Year year;

    public static TimeDateSingleton single_instance = null;

    public Date date;
    public Calendar cal;

    public int year;
    public int month;
    public int day;

    public Map<Months, Integer> monthsMap = new HashMap<>();

    private TimeDateSingleton(){
        date = new Date();
        cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DATE);

        int index = 0;
        for (Months mon: Months.values()){
            monthsMap.put(mon,index);
            index++;
        }
    }

    public static TimeDateSingleton timeDateSingleton(){
        if(single_instance == null){
            single_instance = new TimeDateSingleton();
        }
        return single_instance;
    }

    public static void seeDate(){

        System.out.println(TimeDateSingleton.timeDateSingleton().cal.get(Calendar.DATE)+"."+TimeDateSingleton.timeDateSingleton().cal.get(Calendar.MONTH)+"."+TimeDateSingleton.timeDateSingleton().cal.get(Calendar.MONTH));
       }
}
