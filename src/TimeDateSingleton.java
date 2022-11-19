import enums.Months;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TimeDateSingleton {


    public static TimeDateSingleton single_instance = null;

    public Date date;
    public Calendar cal;

    public int year;
    public int month;
    public int day;

    public Map<Integer, Months> monthsMap = new HashMap<>();
    public Map<Months, Integer> monthsMapNotSorted = new HashMap<>();
    //ugly code I am sorry


    private TimeDateSingleton() {
        date = new Date();
        cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DATE);

        int index = 0;
        for (Months mon : Months.values()) {
            monthsMap.put(index, mon);
            monthsMapNotSorted.put(mon,index);
            index++;
        }
    }

    public static TimeDateSingleton timeDateSingleton() {
        if (single_instance == null) {
            single_instance = new TimeDateSingleton();
        }
        return single_instance;
    }

    public int returnIndexMonth(){
        int index = 0;
        for (Months mon: Months.values()){

        }
        return index;
    }


}
