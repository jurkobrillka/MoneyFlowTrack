import java.util.ArrayList;
import java.util.Scanner;

public class Block {

    Scanner sc = new Scanner(System.in);

    private String title;
    private String basicInfo;


    //defaultny konstruktor pre vytvorenie "prveho" blocku
    public Block() {
    }


    public Block(String title, String basicInfo) {
        this.title = title;
        this.basicInfo = basicInfo;
    }

    public String getTitle() {
        return title;
    }

    public String getBasicInfo() {
        return basicInfo;
    }

    public Block createBlock(){

        System.out.print("Set title: ");
        String title = sc.nextLine();
        System.out.print("Set basic info: ");
        String basicInfo = sc.nextLine();
        Block block = new Block(title,basicInfo);
        return block;
    }


    public void addCategory(ArrayList<Block> list){
        System.out.println("Set cathegory:\n1 - continoue\n0 - end");
        String input = sc.nextLine();
        int counter = 0;
        while(Integer.parseInt(input)!=0){
            System.out.println("Set cathegory: ");
            Block b = createBlock();
            list.add(b);
            counter++;
            System.out.println("Wanna continue? :");
            input = sc.nextLine();
        }
         //check if created succesfully
        if (counter == list.size()){
            System.out.println("Cathegories created succesfully, wanna see them? (1 - yes, 0 - no)");

            if (sc.nextInt() == 1){
                printCats(list);
            }
        }
        else {
            System.out.println("Cath created unsuccessfully");
        }
    }

    public void printCats(ArrayList<Block> list){
        int topSizeTitle = 0;
        int topSizeInfo = 0;
        for(Block b:list){
            if (b.getTitle().length() >= topSizeTitle){
                topSizeTitle = b.getTitle().length();
            }
            if (b.getBasicInfo().length() >= topSizeInfo){
                topSizeInfo = b.getBasicInfo().length();
            }
        }
        topSizeTitle+=2;
        topSizeInfo+=2;



        printRow(1,topSizeTitle,topSizeInfo,new Block());
        for(Block b:list){
            printRow(99,topSizeTitle,topSizeInfo,b);
            printRow(2,topSizeTitle,topSizeInfo,b);
        }

        printRow(3,topSizeTitle,topSizeInfo,new Block());
    }
     //1 upper, 2middle, 3 lower, other value
    public void printRow(int level, int topTitle, int topInfo, Block b){
        int rowLength = topTitle+topInfo+3;


        if (level == 1){
            char signs[] = {'┌','┬','┐','─'};
            callSpecialRow(rowLength,topTitle,signs);
        }
        else if(level == 2){
            char signs[] = {'├','┼','┤','─'};
            callSpecialRow(rowLength,topTitle,signs);
        }

        else if (level == 3){
            char signs[] = {'└','┴','┘','─'};
            callSpecialRow(rowLength,topTitle,signs);
        }
        else {
            int word1 = 0;
            int word2 = 0;

            for (int i = 0; i <rowLength ; i++) {
                if (i==0 || i==topTitle+1 || i==rowLength-1){
                    System.out.print("│");
                }
                else if((i==1 || i==topTitle || i==topTitle+2 || i==rowLength-2)){
                    System.out.print(" ");
                }
                else{
                    if (word1 == b.getTitle().length()){
                        //print word2
                        if (b.getBasicInfo().length() == word2){
                            System.out.print(" ");
                        }
                        else {
                            System.out.print(b.getBasicInfo().charAt(word2));
                            word2++;
                        }

                    }
                    else {
                        //print word1
                        System.out.print(b.getTitle().charAt(word1));
                        word1++;
                    }
                }

            }
            System.out.print("\n");

        }
    }

    public void callSpecialRow(int rowLength, int topTitle, char[]signs){
        for (int i = 0; i <rowLength ; i++) {
            if (i==0){
                System.out.print(signs[0]);
            }
            else if(i==topTitle+1){
                System.out.print(signs[1]);
            }
            else if (i == rowLength-1) {
                System.out.print(signs[2]);
            }
            else {
                System.out.print(signs[3]);
            }
        }
        System.out.print("\n");
    }
}



