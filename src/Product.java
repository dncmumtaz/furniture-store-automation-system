import java.util.Scanner;

public abstract class Product {



    String model;
    String color;
    int numberOfItem;

    public int getNumberOfItem() {
        return numberOfItem;
    }

    public void setNumberOfItem(int numberOfItem) {
        this.numberOfItem = numberOfItem;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }


/*    public  Product(String model, String color) {
        this.model = model;
        this.color = color;
    }
*/
}