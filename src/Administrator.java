import java.util.Scanner;

public class Administrator extends  CompanyPersonal{
    private Company company;

    public Administrator(String id, String name, String surname, String password, String email, Company company ){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.company = company;
        AutoAssignId();//to create and assign id

    }

    public Company getCompany() {
        return company;
    }

    //branch process
    public void addBranch(Branch branch){
        company.addBranch(branch);
    }

    public void removeBranch(int index){
        company.removeBranch(index);
    }

    public void addBranchEmployee(int branchIndex, BranchEmployee branchEmployee){

        company.getBranches().get(branchIndex).addBranchEmployee(branchEmployee);
    }

    public void removeBranchEmployee(int branchIndex, int branchEmployeeIndex){

       // company.getBranches()[branchIndex].getBranchEmployees()[branchEmployeeIndex] = null;


        for(int i = branchEmployeeIndex-1; i <= company.getBranches().get(branchIndex).getBranchEmployeeNumber(); i++ ){
            if( i == company.getBranches().get(branchIndex).getBranchEmployeeNumber() ){
                company.getBranches().get(branchIndex).getBranchEmployees().set(i, null);
                break;
            }
            company.getBranches().get(branchIndex).getBranchEmployees().set(i, company.getBranches().get(branchIndex).getBranchEmployees().get(i + 1));
        }
        company.getBranches().get(branchIndex).setBranchEmployeeNumber(company.getBranches().get(branchIndex).getBranchEmployeeNumber()-1);

    }



    @Override
    public void menu() {
        Scanner input = new Scanner(System.in);
        int options;
        boolean exit = false;
        while (!exit) {
            System.out.println("Admin Panel");
            System.out.println("(1) Branch Operations");
            System.out.println("(2) Branch Employee Operations");
            System.out.println("(3) Check Stock");
            System.out.println("(4) Show product list");

 //          System.out.println("(5) Check product in branch ");
            System.out.println("(0) Exit from this menu");
            System.out.println("Options: ");
            options = input.nextInt();
            switch (options) {
                case 1:
                    System.out.println("(1) Add Branch");
                    System.out.println("(2) Remove Branch");
                    System.out.println("(0) Exit");
                    System.out.print("Choice: ");
                    options = input.nextInt();

                    if (options == 1) {
                        System.out.print("Please enter a name for the branch: ");
                        input.nextLine();
                        String name_branch = input.nextLine();
                        addBranch(new Branch(name_branch));
                    }
                    else if (options == 2 && company.getBranchNumber() > 0) {
                        System.out.println("Please choose a branch: \n");
                        for (int i = 0; i < company.getBranchNumber(); i++) {
                            System.out.println((i + 1) + ") " + company.getBranches().get(i).getName());
                        }
                        System.out.println("0) Cancel");
                        System.out.print("Index: ");
                        int index = input.nextInt();
                        if (index <= company.getBranchNumber() && index > 0) {
                            removeBranch((index - 1));
                        }
                    }
                    else if (options == 2 && company.getBranchNumber() <= 0) {
                        System.out.println("There is no branch !\n");
                    }
                    break;
                case 2:
                    if (company.getBranchNumber() > 0) {
                        System.out.println("Please choose a branch: ");
                        for (int i = 0; i < company.getBranchNumber(); i++) {
                            System.out.println((i + 1) + ") " + company.getBranches().get(i).getName());
                        }
                        System.out.println("0) Cancel");
                        System.out.print("Index: ");
                        int index = input.nextInt();
                        if (index > 0 && index <= company.getBranchNumber()) {

                            System.out.println("(1) Add Employee");
                            System.out.println("(2) Remove Employee");
                            System.out.println("(0) Exit");
                            System.out.print("Choice: ");
                            options = input.nextInt();
                            if (options == 1) {
                                System.out.print("ID of employee: ");
                                String id_employee = input.next();
                                System.out.print("Name of employee: ");
                                input.nextLine();
                                String name_employee = input.nextLine();
                                System.out.print("Surname of employee: ");
                                String surname_employee = input.nextLine();
                                System.out.print("Password of employee: ");
                                String password_employee = input.next();
                                System.out.print("email of employee: ");
                                String email_employee = input.next();
                                addBranchEmployee(index -1 , new BranchEmployee(id_employee, name_employee, surname_employee, password_employee, email_employee, company.getBranches().get(index - 1)));
                            }
                            else if (options == 2 && company.getBranches().get(index - 1).getBranchEmployeeNumber() > 0) { //????
                                System.out.println("Please choose a employee: \n");
                                for (int i = 0; i < company.getBranches().get(index - 1).getBranchEmployeeNumber(); i++)
                                {
                                    System.out.println((i + 1) + ") " + company.getBranches().get(index - 1).getBranchEmployees().get(i).getName());
                                }
                                System.out.println("0) Cancel");
                                System.out.print("Index: ");
                                int index_employee = input.nextInt();
                                if (index_employee > 0 && index_employee <= company.getBranches().get(index - 1).getBranchEmployeeNumber())
                                {
                                    removeBranchEmployee((index - 1), index_employee);
                                }
                            }
                            else
                            {
                                System.out.println("There is no employee !\n");
                            }
                        }
                        else
                        {
                            System.out.println("Please Try Again\n");
                        }
                    }
                    else {
                        System.out.println("There is no branch !\n");
                    }
                    break;
                case 3:
                    System.out.println("Please choose a branch: \n");
                    for (int i = 0; i < company.getBranchNumber(); i++) {
                        System.out.println((i + 1) + ") " + company.getBranches().get(i).getName());
                    }
                    System.out.println("0) Cancel");
                    System.out.print("Index: ");
                    int index2 = input.nextInt();
                    company.getBranches().get(index2-1).chechStock();
                    break;
                case 4:
                    System.out.println("Please choose a branch: \n");
                    for (int i = 0; i < company.getBranchNumber(); i++) {
                        System.out.println((i + 1) + ") " + company.getBranches().get(i).getName());
                    }
                    System.out.println("0) Cancel");
                    System.out.print("Index: ");
                    int index1 = input.nextInt();
                    company.getBranches().get(index1-1).showProductList();
                    break;
/*                case 5:
                    System.out.println("enter name of model that you want search");
                    System.out.print("name: ");
                    input.nextLine();
                    String name_model= input.nextLine();
                    company.chechProductInBranchs(name_model);

                    break;*/
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Please Try Again\n");

            }
        }
    }
}