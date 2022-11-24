import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Item {
    Scanner sc = new Scanner(System.in);
    private Block block;
    private double price;
    private boolean important;


    public Item() {
    }

    public Item(Block block, double price, boolean important) {
        this.block = block;
        this.price = price;
        this.important = important;
    }

    public Scanner getSc() {
        return sc;
    }

    public Block getBlock() {
        return block;
    }

    public double getPrice() {
        return price;
    }

    public boolean isImportant() {
        return important;
    }

    public void createAndAddItem(ArrayList<Item> items, ArrayList<Block>categories){
        items.add(createItem(categories));
    }


    public Item createItem(ArrayList<Block> categories){
        boolean inLoop = true;
        int id = 0;
        while (inLoop){
            System.out.println("Set ID of category: ");
            id = sc.nextInt();
            if(id<categories.size()){
                inLoop=false;
            }
            else {
                System.out.println("You set the wrong number, try again");
            }

        }
        System.out.println("Set price: ");
        double price = sc.nextDouble();
        System.out.println("Is it important to survive? (1/0)");
        int importance = sc.nextInt();
        Item item = new Item(categories.get(id),price, importance == 1);

        return item;
    }

    public void saveTodaysItems(int month, ArrayList<Block> blocks, ArrayList<Item>expenditures) throws IOException {
        String halflinkPath = "C:/TrackerFiles/"+TimeDateSingleton.timeDateSingleton().year+"/"+TimeDateSingleton.timeDateSingleton().monthsMap.get(month)+"/";
        String nameOfFile = TimeDateSingleton.timeDateSingleton().day + "_"
                + TimeDateSingleton.timeDateSingleton().month + "_"
                + TimeDateSingleton.timeDateSingleton().year + ".txt";

        String fullPath = halflinkPath+nameOfFile;

        writeNewItems(fullPath,blocks,expenditures);

    }

    public void writeNewItems(String nameOfFile, ArrayList<Block> blocList, ArrayList<Item> todaysItems) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(nameOfFile));
        BufferedReader br = new BufferedReader(new FileReader(nameOfFile));

        ArrayList<Item> tmpItems = new ArrayList<>();
        String line = br.readLine();
        while (line != null){
            String[] words = line.split(";");
            Block toItemBlock = returnBlock(blocList,words[0]);
            Item iTmp = new Item(toItemBlock,Double.parseDouble(words[1]),Boolean.getBoolean(words[2]));
            tmpItems.add(iTmp);
            line = br.readLine();
        }
        br.close();

        //v liste tmpItems mame temy ktore uz su zapisane za dnesny den, lebo buffer maze ked otvori este raz, tak aby nezmazal tie stare ked idem pisat nove
        //k tmp listu pridam dnesne Items,
        //nasledne zapisem do filu este raz cele

        todaysItems.addAll(tmpItems);

        for (Item i: todaysItems){
            bw.write(i.block.getTitle()+";"+i.price+";"+i.important);
            bw.newLine();
        }
        bw.close();


    }

    public Block returnBlock(ArrayList<Block> blocList, String title) throws IOException {
        for (Block b:blocList){
            if (b.getTitle().equals(title) ){
                return b;
            }
        }
        return new Block();
    }

    public void deleteTodayItem(ArrayList<Item> itemsList){
        System.out.println("Set the price of item:");
        double toDeletePrice = sc.nextDouble();
        System.out.println("Set the Category of item:");
        String toDeleteCat = sc.nextLine();
        boolean isDeleted = false;

        for (Item i:itemsList){
            if (i.getPrice() == toDeletePrice && i.getBlock().equals(toDeleteCat)){
                itemsList.remove(i);
                isDeleted = true;
                break;
            }
        }

        if (isDeleted){
            System.out.println("Category with category "+toDeleteCat+" and price "+toDeletePrice+" is successfully deleted.");
        }
        else {
            System.out.println("There is no item with "+toDeleteCat+ " category and "+toDeletePrice+" price. Please try again.");
        }
    }


    public void printExpenditures(ArrayList<Item> exp){
        for(Item i:exp){
            System.out.println(i.block.getTitle()+", "+i.price+" EUR, "+i.important);
        }


    }



}
