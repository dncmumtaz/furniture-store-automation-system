import java.util.Scanner;

public class BranchEmployee extends CompanyPersonal{

    private Branch branch;


    public BranchEmployee(String id, String name, String surname, String password, String email, Branch branch ){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.branch = branch;
        AutoAssignId();//to create and assign id
    }




    public void  showStock(){
        for(int i = 0; i < branch.getBranchEmployeeNumber()-1; i++)
        {
            System.out.println(branch.getStock()[i].getModel()+ " "+ branch.getStock()[i].getColor()+ " " + branch.getStock()[i].getNumberOfItem());
        }
    }

    public  void checkStock(){

        for(int i = 0; i < branch.getBranchEmployeeNumber()-1; i++){
            if(branch.getStock()[1].getNumberOfItem() <= 3){
                sendInfoToAdmin();
                branch.getStock()[1].getModel();
            }
        }
    }

    public void sendInfoToAdmin(){
        System.out.println("This product should be buy: ");
    }

    public void addProduct(Product product){
            branch.getStock()[branch.getStockIndex()] = product;
            branch.setStockIndex(branch.getStockIndex() + 1);
    }

    public  void addProductt(Product product){
        product.getModel();
        System.out.println("product added");
    }

    public  void removeProduct(int index){
      //   Branch tempBranch = new Branch("temp");
      //   tempBranch = branch;

        for(int i = index; i < branch.getStockIndex()-1; i++ )
        {
            branch.getStock()[i] = branch.getStock()[i+1];
        }
        branch.getStock()[branch.getStockIndex()] = null;

     //   branch.getStock()[index] = null;
        branch.setStockIndex(branch.getStockIndex() -1 );
    }

    public void showCustomerInfo(int customerIndex){

        System.out.println(branch.getCustomers().get(customerIndex).getName());
        System.out.println(branch.getCustomers().get(customerIndex).getSurname());
        System.out.println(branch.getCustomers().get(customerIndex).getEmail());
        System.out.println(branch.getCustomers().get(customerIndex).getId());
        System.out.println(branch.getCustomers().get(customerIndex).getAddress());
        System.out.println(branch.getCustomers().get(customerIndex).getTelephone());
        System.out.println(branch.getCustomers().get(customerIndex).getOrders());

    }

    public void addOrderToCustomer(Product product){

        branch.getCustomers().get(0).orders[0] = product.toString();
    }
    public  void updateCustomerOrder(int customerIndex, Product product){

        int lastIndex = branch.getCustomers().get(customerIndex).orders.length +1;
        branch.getCustomers().get(customerIndex).orders[lastIndex] = product.toString();
    }

    public void addCustomer(Customer customer){
        int lastIndex = branch.getNumberOfCustomer();
        branch.getCustomers().set(lastIndex, customer);
        branch.setNumberOfCustomer(lastIndex + 1);
    }

    public void makeSales(String productModel){

        for(int i = 0; i < branch.getStockIndex() ; i++)
        {

            if(branch.getStock()[i].getModel().equals(productModel) ){
                branch.getStock()[i].setNumberOfItem(branch.getStock()[i].getNumberOfItem()- 1);
                break;
            }
        }

        System.out.println("The sale is successful");
    }

    public void updateCustomerShoppingList(Product product){
        branch.getCustomers().get(0).AddOrders(product);
    }

    @Override
    public void menu(){

        Scanner input4 = new Scanner(System.in);
        boolean exit = false;
        int permission;
        while (!exit){
            System.out.println("Branch Employee Menu");
            System.out.println("(1)Show the stock");
            System.out.println("(2)Product Number Control ");
            System.out.println("(3)Add Product");
            System.out.println("(4)Make Sell From Store");
            System.out.println("(5)Update Customer Shopping List ");
            System.out.println("(6)subscribe the new Customer ");
            System.out.println("(0) Exit");
            System.out.print("your options: ");
            try {
                permission = input4.nextInt();
            }catch (Exception e){
                System.out.println("\nYour choice must be an integer value !");
                input4.nextLine();
                permission = -1;
            }
            switch (permission) {
                case 1:
                    branch.getBranchEmployees().get(0).showStock();
                    break;
                case 2:
                    branch.getBranchEmployees().get(0).checkStock();
                    break;
                case 3:
                    addProduct(new OfficeChair("chair", "red", 4));
                    break;
                case 4:
                    makeSales("newProduct");
                    System.out.println();
                    break;
                case 5:
                    updateCustomerShoppingList(new OfficeChair("officeChair", "yellow", 2));
                    System.out.println();
                    break;
                case 6:
                    addCustomer(new Customer("5","ahmet","mahmut", "453","sdfsdf"));
                    System.out.println("Customer subcribed");
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Please Try Again\n");
            }
        }
    }

}

