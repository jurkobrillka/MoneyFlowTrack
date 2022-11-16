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

    public Map<Months, Integer> monthsMap = new HashMap<>();

    private TimeDateSingleton() {
        date = new Date();
        cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DATE);

        int index = 0;
        for (Months mon : Months.values()) {
            monthsMap.put(mon, index);
            index++;
        }
    }

    public static TimeDateSingleton timeDateSingleton() {
        if (single_instance == null) {
            single_instance = new TimeDateSingleton();
        }
        return single_instance;
    }


}
