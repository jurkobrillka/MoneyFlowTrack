import java.util.ArrayList;

public class Item {
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


    public void addToExpenditures(ArrayList exp, Item item){
        exp.add(item);
    }

    public void printExpenditures(ArrayList<Item> exp){
        for(Item i:exp){
            System.out.println(i.block.getTitle()+", "+i.price+" EUR, "+i.important);
        }


    }



}
