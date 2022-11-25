import com.sun.jdi.Value;

import java.io.*;

public class BuffManager {

    private static BuffManager single_instance = null;

    public BufferedReader br;
    public BufferedWriter bw;

    public BufferedReader todaysItemReader;
    public BufferedWriter todaysItemWriter;

    public BufferedWriter bwForItems;


    private BuffManager() throws IOException {
        br = new BufferedReader(new FileReader("C:/TrackerFiles/Cathegory.txt"));
        bw = new BufferedWriter(new FileWriter("C:/TrackerFiles/Cathegory.txt",true));
        File todayFile = new File(getPathForTodayItem());
        todayFile.createNewFile();
        if (todayFile.exists()){
            System.out.println("BRUHBRUHBRUH");
        }
        else {
            System.out.println("JAk to ze to nefunguje more");
        }
        todaysItemReader = new BufferedReader(new FileReader(getPathForTodayItem()));
        todaysItemWriter = new BufferedWriter(new FileWriter(getPathForTodayItem(),true));


    }

    private BuffManager(int month, int year, String nameOfFile) throws IOException {
        bwForItems = new BufferedWriter(new FileWriter("C:/TrackerFiles/"+Integer.toString(year)+"/"+ TimeDateSingleton.timeDateSingleton().monthsMap.get(month)+"/"+nameOfFile+".txt"));

    }

    private String getPathForTodayItem(){
        String halflinkPath = "C:/TrackerFiles/" + TimeDateSingleton.timeDateSingleton().year + "/" + TimeDateSingleton.timeDateSingleton().monthsMap.get(TimeDateSingleton.timeDateSingleton().month) + "/";
        String nameOfFile = TimeDateSingleton.timeDateSingleton().day + "_"
                + TimeDateSingleton.timeDateSingleton().month + "_"
                + TimeDateSingleton.timeDateSingleton().year + ".txt";

        String fullPath = halflinkPath + nameOfFile;
        System.out.println(fullPath+" ----------------\n");
        return fullPath;
    }


    public static BuffManager BuffManager() throws IOException {
        // To ensure only one instance is created
        if (single_instance == null) {
            single_instance = new BuffManager();
        }
        return single_instance;
    }


    public static void closeBuffer() throws IOException {
        BuffManager().bw.close();
        BuffManager().br.close();
        BuffManager().todaysItemReader.close();
    }


}
