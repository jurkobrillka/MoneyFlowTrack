import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

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

    public static Item defItem = new Item();


    public static void main(String[] args) throws IOException {


        BuffManager buffManager = BuffManager.BuffManager();

        defBlock.addCategory(categories);//vytvorene funkcoiu create
        BuffManager.closeBuffer();






    }



}
