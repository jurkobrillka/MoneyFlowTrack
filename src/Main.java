
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

    public static boolean areItemsSaved = false;


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
                case 1 -> defItem.createAndAddItem(expenditures,categories);
                case 2 -> defItem.printExpenditures(expenditures);
                case 3 -> defItem.deleteTodayItem(expenditures);
                case 4 -> defItem.saveTodaysItems(TimeDateSingleton.timeDateSingleton().month,categories,expenditures);
                case 5 -> defBlock.creteAndAddCategory(categories);
                case 6 -> defBlock.printGraphicCats(categories);
                case 7 -> defBlock.deleteCategory(categories);
                case 0 -> endProgram();
                default -> System.out.println("You chose invalid value, please try again.");
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
        System.out.println("3: Delete today item");
        System.out.println("4: Write todays expenditures to file");
        System.out.println("5: Add category");
        System.out.println("6: See category");
        System.out.println("7: Delete category");
        System.out.println("0: End");
        System.out.println("\nYour choice: ");
    }

    public static void setupEnvironment() throws IOException {

        timeDateSingleton.cal.get(Calendar.YEAR);
        if (!defFileSetup.doFIlesExist()) {
            defFileSetup.createAllDirectories();
        }

        defBlock.readCathegoryFromList(categories);

    }


}
