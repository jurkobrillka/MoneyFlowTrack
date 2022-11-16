import enums.Months;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class FileSetup {

    public FileSetup() {
    }

    private File currentYear = new File("C:/TrackerFiles/" + TimeDateSingleton.timeDateSingleton().cal.get(Calendar.YEAR));
    private File nextYear = new File("C:/TrackerFiles/" + (TimeDateSingleton.timeDateSingleton().year + 1));


    public boolean doFIlesExist() {


        if (currentYear.exists() && nextYear.exists()) {
            for (int i = 0; i < 2; i++) {
                for (Months mon : Months.values()) {
                    File fMonth = new File("C:/TrackerFiles/" + (TimeDateSingleton.timeDateSingleton().year + i) + "/" + mon);
                    if (fMonth.exists()) {
                        //Month folder exist, continue
                    } else {
                        //month folder doesnt exist, return false and do reebot
                        System.out.println("File:" + "C:/TrackerFiles/" + (TimeDateSingleton.timeDateSingleton().year + i) + "/" + mon + " is missing, program needs to reboot");
                        return false;
                    }
                }
            }


            return true;

        } else {
            System.out.println("File: " + "C:/TrackerFiles/" + TimeDateSingleton.timeDateSingleton().cal.get(Calendar.YEAR)+ " is missing, program needs to reboot");
            return false;
        }

    }

    //create files for first time
    public void createAllDirectories() throws IOException {
        File mainFile = new File("C:/TrackerFiles");
        if (mainFile.exists()){
            //delete anyway
            deleteWholeDirectory(mainFile);
            createAllDirectories();
        }
        else {
            //nothing there, probably first configuration
            if (mainFile.mkdir() == true){
                //mainFile was created successfully, continue
                if (currentYear.mkdir() == true){
                    //creating months Files
                    createMonthsDirectories(0);
                }
                else {
                    System.out.println("Current year canot be created");
                }

                if (nextYear.mkdir() == true){
                    //creating months Files
                    createMonthsDirectories(1);
                }
                else {
                    System.out.println("Current year canot be created");
                }
            }
            else {
                System.out.println("Directory cannot be created.");
            }
        }
    }

    public void deleteWholeDirectory(File file){
        File[] list = file.listFiles();
        if(list != null){
            for(File tmp: list){
                deleteWholeDirectory(tmp);
            }
        }
        if (file.delete()) {
            //System.out.printf("Delete : %s%n", file);
        } else {
            //System.err.printf("Unable to delete file or directory : %s%n", file);
        }
    }

    public void createMonthsDirectories(int nextYear) throws IOException {

        boolean wholeCreation = true;
        for (Months mon : Months.values()) {
            File fMonth = new File("C:/TrackerFiles/" + (TimeDateSingleton.timeDateSingleton().year + nextYear) + "/" + mon);
            if (fMonth.mkdir() == true){
                //created successfully, continue
            }
            else {
                System.out.println("Folder cannot be created");
                wholeCreation = false;
            }
        }

        if (wholeCreation && nextYear==1){
            File cathFile = new File("C:/TrackerFiles/Cathegory.txt");
            if (cathFile.createNewFile()){
                System.out.println("Setup completed...");
            }
            else {
                System.out.println("Something happened, you might considered try again");
            }
        }


    }
}
