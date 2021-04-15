import java.util.Scanner;

public class Company {

    private String name;
    private KWArrayList <Administrator> administrators ;
    private  int adminNumber;

    private LinkedList < Branch> branches;
    private int branchNumber;





    public Company(String name) {
        this.name = name;
        this.administrators  = new KWArrayList<Administrator>();
        this.branches = new LinkedList<Branch>(new Branch("new branch"));
        this.branchNumber = 0;
        this.adminNumber = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public KWArrayList<Administrator> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(KWArrayList<Administrator> administrators) {
        this.administrators = administrators;
    }

    public MyList<Branch> getBranches() {
        return branches;
    }

    public void setBranches(LinkedList<Branch> branches) {
        this.branches = branches;
    }

    public int getBranchNumber() {
        return branchNumber;
    }

    public void addBranch(Branch branch ){
        branches.add(branch);
        branchNumber++;
    }
    public void removeBranch(int num ){

     //   branches[num]  = null;
        int i = num +1 ;
        for ( i = num; i < branchNumber; i++){
            if(i == branchNumber-1){
                branches.set(i, null);
                break;
            }
            branches.set(i, branches.get(i+1) );
        }
        branchNumber--;

    }

    public void addAdministrator(Administrator administrator){
        administrators.add(administrator);
        this.adminNumber++;
    }

    public void chechProductInBranchs(String model){
        //System.out.println("jem ici");
        for (int i = 0; i < branchNumber; i++){
            //System.out.println("jem isi");
            for(int j = 0; j < branches.get(i).getStockIndex(); j++)
                if(model.equals(branches.get(i).getStock()[j].getModel())){
                    System.out.println(model + " is availible in" + branches.get(i).getName());
                }
        }
    }
    public void LoginScreen(){}

    public void startTheSystem() {
        Scanner input = new Scanner(System.in);
        int choice = 3;
        while(choice != 0){
            System.out.println("\nWelcome to Automation System");
            System.out.println(getName() + " Company");
            System.out.println("(1) Personal Login");
            System.out.println("(2) Customer Login");
            System.out.println("(0) Exit");
            System.out.print("Choice: ");
            try{
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println("\nYour choice must be an integer value !");
                input.nextLine();
            }
            if(choice == 1){
                PersonalLogin();
            }else if(choice == 2){
                custemerLogin();
            }else if(choice == 0){
                System.out.println("System is shutting down..");
            }else{
                System.out.println("\nPlease Try Again\n");
            }
        }
    }

    public void PersonalLogin(){
        boolean permisson = false;
        Scanner input = new Scanner(System.in);
        System.out.println("You are in Personel Page");

        while (!permisson)
        {
            System.out.println("Enter your ID");
            String personID = input.next();
            System.out.println("Enter your password");
            String personPassword  = input.next();


            for (int i = 0; i < adminNumber ; i++) {

              //  System.out.println(getAdministrators()[i].getId()+ "*****" + getAdministrators()[i].getPassword());
                if (personID.equals(getAdministrators().get(i).getId())  &&
                        personPassword.equals(getAdministrators().get(i).getPassword())  ){
                    System.out.println("Access Granted\n");
                    System.out.println("Welcome " + getAdministrators().get(i).getName());
                    administrators.get(i).menu();
                    permisson = true;
                    break;
                }
            }
            if (!permisson){
                for(int i = 0 ; i< branches.size(); i ++)
                {
                    if(branches.get(i) == null) continue;
                    for (int j = 0; j < branches.get(i).getBranchEmployeeNumber(); j++)
                    {
                        if (personID.compareTo(branches.get(i).getBranchEmployees().get(j).getId()) == 0 &&
                                personPassword.compareTo(branches.get(i).getBranchEmployees().get(j).getPassword()) == 0) {
                            System.out.println("Access Granted\n");
                            System.out.println("Welcome " + branches.get(i).getBranchEmployees().get(j).getName());
                            branches.get(i).getBranchEmployees().get(j).menu();
                            permisson = true;
                            break;
                        }
                    }
                }
            }

        }
    }

    public void custemerLogin(){
        boolean permisson = false;
        Scanner input = new Scanner(System.in);
        System.out.println("You are in Custormer Page");

        while (!permisson){
            System.out.println("Enter your ID");
            String personID = input.next();
            System.out.println("Enter your password");
            String personPassword  = input.next();

            for(int j = 0; j < branchNumber; j++){
                if(branches.get(j) == null ) continue;

                for (int i = 0; i < branches.get(j).getNumberOfCustomer(); i++){
                    System.out.println(branches.get(j).getCustomers().get(i).getId() + "------" + branches.get(j).getCustomers().get(i).getPassword());
                    if(personID.equals(branches.get(j).getCustomers().get(i).getId())  && personPassword.equals(branches.get(j).getCustomers().get(i).getPassword() )){
                        System.out.println("Access Granted\n");
                        System.out.println("Welcome " + branches.get(j).getCustomers().get(i).getName());

                        Scanner input4 = new Scanner(System.in);
                        boolean exit = false;
                        int permission1;
                        while (!exit) {
                            System.out.println("Customer Menu");
                            System.out.println("(1)Show the product list");
                            System.out.println("(2)Show Products branchs ");
                            System.out.println("(3)make shopping");
                            System.out.println("(4)show orders");
                            System.out.println("(0)exit");
                            try {
                                permission1 = input4.nextInt();
                            }
                            catch (Exception e) {
                                System.out.println("\nYour choice must be an integer value !");
                                input4.nextLine();
                                permission1 = -1;
                            }

                            switch (permission1) {
                                case 1:
                                    branches.get(0).showProductList();
                                    break;
                                case 2:
//                                    branches[0].getCustomers()[0].ShowProductStockBranch();
                                     break;
                                case 3:
                                    branches.get(0).getCustomers().get(0).makeShoping(new OfficeDesk("newmodel","black", 3));
                                    System.out.println("the product added");
                                    System.out.println();
                                    break;
                                case 4:
                                    branches.get(0).getCustomers().get(0).ShowOrders();
                                    System.out.println();
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

            }

        }

    }

    public void Test()
    {

        administrators.get(0).addBranch(new Branch("FirstBranch"));//.addBranch();
        System.out.println(" ");
        System.out.println( administrators.get(0).getName() + " added a branch which name is :  " + administrators.get(0).getCompany().getBranches().get(0).getName() );
        administrators.get(0).addBranch(new Branch("SecondBranch"));
        System.out.println( administrators.get(0).getName() + " added a branch which name is :  " + administrators.get(0).getCompany().getBranches().get(1).getName() );
        administrators.get(0).addBranch(new Branch("ThirdBranch"));
        System.out.println( administrators.get(0).getName() + " added a branch which name is :  " + administrators.get(0).getCompany().getBranches().get(2).getName() );
        administrators.get(0).addBranch(new Branch("FourdBranch"));
        System.out.println( administrators.get(0).getName() + " added a branch which name is :  " + administrators.get(0).getCompany().getBranches().get(3).getName() );
        //administrators[0].addBranchEmployee(new BranchEmployee());
        administrators.get(0).addBranchEmployee(0, new BranchEmployee("11","1stEmployeeName","1stEmployeeSurname","1", "emp111@xx.com", getBranches().get(0)));
        System.out.println( administrators.get(0).getName() + " added a branch employee which name is :" + administrators.get(0).getCompany().getBranches().get(0).getBranchEmployees().get(0).getName());
        administrators.get(0).addBranchEmployee(0, new BranchEmployee("102","2ndEmployeeName","2ndEmployeeSurname","emp112", "emp112@xx.com", getBranches().get(0)));
        System.out.println( administrators.get(0).getName() + " added a branch employee which name is :" + administrators.get(0).getCompany().getBranches().get(0).getBranchEmployees().get(1).getName());
        administrators.get(0).addBranchEmployee(0, new BranchEmployee("103","3rdEmployeeName","3rdEmployeeSurname","emp113", "emp113@xx.com", getBranches().get(0)));
        System.out.println( administrators.get(0).getName() + " added a branch employee which name is :" + administrators.get(0).getCompany().getBranches().get(0).getBranchEmployees().get(2).getName());
        branches.get(0).getBranchEmployees().get(0).addProduct(new MeetingDesk("MDesk1","red", 3) );
        System.out.println(branches.get(0).getBranchEmployees().get(0).getName() + " added a furniture which name is :" + branches.get(0).getStock()[0].getModel() + " the color is " + branches.get(0).getStock()[0].getColor()+ " and number is "+ branches.get(0).getStock()[0].getNumberOfItem() );
        branches.get(0).getBranchEmployees().get(0).addProduct(new MeetingTable("MTable1","purple", 3) );
        System.out.println(branches.get(0).getBranchEmployees().get(0).getName() + " added a furniture which name is :" + branches.get(0).getStock()[1].getModel() + " the color is " + branches.get(0).getStock()[1].getColor()+ " and number is "+ branches.get(0).getStock()[1].getNumberOfItem() );
        branches.get(0).getBranchEmployees().get(0).removeProduct(1);
        System.out.println(branches.get(0).getBranchEmployees().get(0).getName() + " removed a furniture: " + branches.get(0).getStock()[1].getModel() + " " + branches.get(0).getStock()[1].getColor()+ " 2" );
        branches.get(0).getBranchEmployees().get(0).addCustomer(new Customer("c1", "C1Name", "c1", "c1", "xx"));
        System.out.println(branches.get(0).getBranchEmployees().get(0).getName() + " added a customer which name is: " + branches.get(0).getCustomers().get(0).getName());



        branches.get(0).getCustomers().get(0).OnlineShoping(new OfficeChair("OChair1","red",1) );
        branches.get(0).getCustomers().get(0).OnlineShoping(new OfficeChair("OChair2","red",1) );
        System.out.println(branches.get(0).getCustomers().get(0).getName() + " made a online shop and the products is : " );
        branches.get(0).getCustomers().get(0).ShowOrders();


    }

}