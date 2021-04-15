import java.util.Scanner;

public class Branch {

    private  String name;
    private KWArrayList <BranchEmployee> branchEmployees;
    private int branchEmployeeNumber;

    private  KWArrayList<Customer> customers;
    private int numberOfCustomer;

    private Product[] stock;
    private int stockIndex;

    public Branch(String name) {
        this.name = name;
        this.branchEmployees = new KWArrayList <BranchEmployee>();
        this.branchEmployeeNumber = 0;
        this.customers = new KWArrayList<Customer>();
        this.numberOfCustomer = 0;
        this.stock = new Product[20];
        this.stockIndex = 0;
    }

    public int getBranchEmployeeNumber() {
        return branchEmployeeNumber;
    }

    public void setBranchEmployeeNumber(int branchEmployeeNumber) {
        this.branchEmployeeNumber = branchEmployeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public KWArrayList<BranchEmployee> getBranchEmployees() {
        return branchEmployees;
    }

    public void setBranchEmployees(KWArrayList<BranchEmployee> branchEmployees) {
        this.branchEmployees = branchEmployees;
    }

    public KWArrayList<Customer> getCustomers() {
        return customers;
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }

    public void setNumberOfCustomer(int numberOfCustomer) {
        this.numberOfCustomer = numberOfCustomer;
    }

    public void setCustomers(KWArrayList<Customer> customers) {
        this.customers = customers;
    }

    public Product[] getStock() {
        return stock;
    }

    public int getStockIndex() {
        return stockIndex;
    }

    public void setStockIndex(int stockIndex) {
        this.stockIndex = stockIndex;
    }

    public void  showProductList(){
        for(int i = 0 ; i < stockIndex+1; i++) {
            System.out.println(stock[i].getModel() + " : " + stock[i].getNumberOfItem());
        }
    }



    public void addBranchEmployee(BranchEmployee branchEmployee){

        branchEmployees.set(branchEmployeeNumber, branchEmployee);
        branchEmployeeNumber++;
    }

    public  void chechStock(){
        boolean bool = false;
        for(int i = 0 ; i < stockIndex; i++){
            System.out.println(stock[i].getModel() + " : " + stock[i].getNumberOfItem());
            if(stock[i].numberOfItem <= 3){
                bool = true;
                System.out.println("there is only "+ stock[i].numberOfItem + " " + stock[i].getModel() + " model product");
                System.out.println("You should buy from this product: "+ stock[i].getModel() );
                Scanner input = new Scanner(System.in);
                int choice;
                while (true){
                    System.out.println("1) add product stock for this procuct ");
                    System.out.println("0) exit");
                    choice = input.nextInt();
                    if(choice == 1){
                        stock[i].setNumberOfItem(stock[i].getNumberOfItem() + 1);
                        System.out.println("you have "+  stock[i].getNumberOfItem()+ " " + stock[i].getModel() + " product" );
                    }
                    else if(choice == 0)
                        break;
                }

            }
        }
        if(bool == false) System.out.println( "In your stock, there is no missing  product");
    }


}
