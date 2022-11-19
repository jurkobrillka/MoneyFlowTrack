import com.sun.jdi.Value;

import java.io.*;

public class BuffManager {

    private static BuffManager single_instance = null;

    public BufferedReader br;
    public BufferedWriter bw;

    public BufferedWriter bwForItems;


    private BuffManager() throws IOException {
        br = new BufferedReader(new FileReader("C:/TrackerFiles/Cathegory.txt"));
        bw = new BufferedWriter(new FileWriter("C:/TrackerFiles/Cathegory.txt",true));
    }

    private BuffManager(int month, int year, String nameOfFile) throws IOException {
        bwForItems = new BufferedWriter(new FileWriter("C:/TrackerFiles/"+Integer.toString(year)+"/"+ TimeDateSingleton.timeDateSingleton().monthsMap.get(month)+"/"+nameOfFile+".txt"));

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
    }


}
