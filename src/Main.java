import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main {


    public static TimeDateSingleton timeDateSingleton = TimeDateSingleton.timeDateSingleton();

    static Scanner sc = new Scanner(System.in);


    public static ArrayList<Block> categories = new ArrayList<>();
    public static ArrayList<Item> expenditures = new ArrayList<>();
    public static Block defBlock;

    static {
        try {
            defBlock = new Block();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static final Item defItem = new Item();
    public static final FileSetup defFileSetup = new FileSetup();


    public static void main(String[] args) throws IOException {
        setupEnvironment();
        menu();

        FileSetup defFileSetup = new FileSetup();
        System.out.println(defFileSetup.doFIlesExist());


        int menuChoice = sc.nextInt();
        while (true) {
            switch (menuChoice) {
                case 1:
                    System.out.println("Men in work");
                    //add items
                    break;
                case 2:
                    System.out.println("Men in work");
                    //see today items
                    break;
                case 3:
                    defBlock.creteAndAddCategory(categories);
                    break;
                case 4:
                    defBlock.printGraphicCats(categories);
                    break;



                case 0:
                    endProgram();
                    break;
                default:
                    System.out.println("You chose invalid value, please try again.");
            }

            menu();
            menuChoice = sc.nextInt();

        }
    }


    public static void endProgram() throws IOException {
        BuffManager.closeBuffer();
        System.exit(0);
    }

    public static void menu() {
        System.out.println("Money Flow Tracker\nBy Juraj Brilla\n\n\nChoose from the menu:");
        System.out.println("1: Add item");
        System.out.println("2: See todays item");
        System.out.println("3: Add cathegory");
        System.out.println("4: See cathegory");
        System.out.println("0: End");
        System.out.println("\nYour choice: ");
    }

    public static void setupEnvironment() throws IOException {

        String s = timeDateSingleton.cal.get(Calendar.YEAR) + "." + timeDateSingleton.cal.get(Calendar.MONTH) + "." + TimeDateSingleton.timeDateSingleton().cal.get(Calendar.DATE);
        if (defFileSetup.doFIlesExist()) {
            //everything OK
        } else {
            defFileSetup.createAllDirectories();
        }

        defBlock.readCathegoryFromList(categories);

    }


}
