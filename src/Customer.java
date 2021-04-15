import java.util.Scanner;

public class Customer extends Person{

//    private  Product product;

    String[] orders ;
    int orderNumber;


    String address;
    String telephone;
    public Customer(String id, String name, String surname, String password, String email)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        AutoAssignId();//to create and assign id
        //      this.product = product;
        this.orders = new String[20];
        this.orderNumber = 0;
        this.telephone = null;
        this.address = null;
    }

    public String[] getOrders() {
        return orders;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }



   /* public Product getProduct(){
        return product;
    }*/
    public void searchProduct(Company company, int branchIndex, String productName){
        company.getBranches().get(branchIndex).getStock();
        for (int i = 0; i <  company.getBranches().get(branchIndex).getStockIndex()+ 1; i++){
            if(company.getBranches().get(branchIndex).getStock()[i].getModel().equals(productName))
                System.out.println("this product is available and there is " + company.getBranches().get(branchIndex).getStock()[i].getNumberOfItem());
        }
    }

    public void showProductList(Company company, int branchIndex){
        int numOfStock = company.getBranches().get(branchIndex).getStockIndex();
        System.out.println("Products are:");
        for (int i = 0; i < numOfStock + 1; i++)
        {
            System.out.println(company.getBranches().get(branchIndex).getStock()[i].getModel() + " "
            + company.getBranches().get(branchIndex).getStock()[i].getColor() + " "
            + company.getBranches().get(branchIndex).getStock()[i].getNumberOfItem()
            );
        }
    }

    public void AddOrders(Product product){
        orderNumber++;
        //orders[orderNumber] = product.name;
    }

    public void ShowOrders(){
        //show orders
        for(int i = 0; i < orderNumber; i++){
            System.out.println(orders[i]);
        }
    }


    public void ShowProductStockBranch(Company company, String nameOfProduct){
        int numOfBranch = company.getBranchNumber();
        int i;
        boolean control = false;
        for ( i = 0; i < numOfBranch; i++)
        {
            int numOfStock = company.getBranches().get(i).getStockIndex();
            if(numOfStock == 0) continue;
            for(int j = 0 ; j < numOfStock +1 ; j++) {
                if (company.getBranches().get(i).getStock()[j].getModel().equals(nameOfProduct)) {
                   control = true;
                   break;
                }
            }
        }

        if(control){
            System.out.println("the product is available in " + company.getBranches().get(i).getName());
        }
        else
            System.out.println("the product is NOT available in " + company.getBranches().get(i).getName());

    }

    public  void setAddress(String address){
        this.address = address;
    }
    public  void setTelephone(String telephone){
        this.telephone = telephone;
    }

    public void OnlineShoping(Product product){
//        Scanner input = new Scanner(System.in);
 //       address = input.nextLine();
     //   System.out.println("enter adress ");
        //take adress and setadress
      //  System.out.println("enter telephone");
   //     telephone = input.nextLine();
        //take telephone and set telephone

        orders[orderNumber] = product.getModel().toString();
        orderNumber++;
        //make online shoping so call the addoder
    }

    public void  makeShoping(Product product){
        //todo update orderlist
        orders[orderNumber] = product.getModel().toString();
        orderNumber++;


    }


    public void menuu(Company company)
    {
        Scanner input4 = new Scanner(System.in);
        boolean exit = false;
        int permission;
        while (!exit) {
            System.out.println("Customer Menu");
            System.out.println("(1)Show the product list");
            System.out.println("(2)Products branchs ");
            System.out.println("(3)make shopping");
            System.out.println("(4)show orders");
            System.out.println("(0)exit");
            try {
                permission = input4.nextInt();
            } catch (Exception e) {
                System.out.println("\nYour choice must be an integer value !");
                input4.nextLine();
                permission = -1;
            }

            switch (permission) {


                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Please Try Again\n");
            }

        }
    }
    @Override
    public void menu(){}
}
