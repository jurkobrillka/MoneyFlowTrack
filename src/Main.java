import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);


    public static ArrayList<Block> categories = new ArrayList<>();
    public static ArrayList<Item> expenditures = new ArrayList<>();


    public static void main(String[] args) {


        //object way
        Block defBlock = new Block();
        Item defItem = new Item();

        defBlock.addCategory(categories);                          //vytvorene funkcoiu create

        defBlock.printCats(categories);

        defItem.addToExpenditures(expenditures,new Item(categories.get(0),sc.nextInt(),sc.nextBoolean()));
        defItem.printExpenditures(expenditures);




    }



}
