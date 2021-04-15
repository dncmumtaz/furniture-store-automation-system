public class Main {

    public static void main(String[] args) {
        // write your code here
        Company company = new Company("LCW");

        company.addAdministrator(new Administrator("1", "admin1", "admin1surname", "1", "admin@lcw.com.tr", company));
        System.out.print("Admin created: name is : " + company.getAdministrators().get(0).getCompany().getAdministrators().get(0).getName() + " ");
        System.out.print("surname is " + company.getAdministrators().get(0).getCompany().getAdministrators().get(0).getSurname() + " ");
        System.out.print("email is " + company.getAdministrators().get(0).getCompany().getAdministrators().get(0).getEmail() + " ");
        System.out.print("pasword is " + company.getAdministrators().get(0).getCompany().getAdministrators().get(0).getPassword() + " ");
        System.out.print("ID is " +  company.getAdministrators().get(0).getCompany().getAdministrators().get(0).getId() + " ");



        company.Test();
     //   System.out.println(company.getBranches()[0].getStock()[0].getModel());
        System.out.println(company.getBranches().get(0).getBranchEmployees().get(0).getName() + " showed the stock");
        company.getBranches().get(0).getBranchEmployees().get(0).showStock();

        company.getBranches().get(0).getBranchEmployees().get(0).makeSales("MDesk1");

        System.out.println(company.getBranches().get(0).getBranchEmployees().get(0).getName() + " update the stock after customer shoping");
        company.getBranches().get(0).getBranchEmployees().get(0).showStock();

        company.getBranches().get(0).getCustomers().get(0).searchProduct( company, 0,"MTable1" );
        System.out.println(company.getBranches().get(0).getCustomers().get(0).getName() + " made a search ");
        company.getBranches().get(0).getCustomers().get(0).showProductList(company, 0);

        company.getBranches().get(0).getBranchEmployees().get(0).makeSales("MDesk1");

        System.out.println(company.getBranches().get(0).getBranchEmployees().get(0).getName() + " update the stock after customer shoping");
        company.getBranches().get(0).getBranchEmployees().get(0).showStock();

        System.out.println(company.getBranches().get(0).getCustomers().get(0).getName() + " made a search in " + company.getBranches().get(0).getName() + " for " + "MDesk1 ::");

        company.getBranches().get(0).getCustomers().get(0).ShowProductStockBranch(company, "MDesk1");

        System.out.println(company.getBranches().get(0).getCustomers().get(0).getName() + " made a search in " + company.getBranches().get(0).getName() + " for " + "MTable1 ::");

        company.getBranches().get(0).getCustomers().get(0).ShowProductStockBranch(company, "MTable1");

        System.out.println(company.getBranches().get(0).getCustomers().get(0).getName() + " made a search in " + company.getBranches().get(0).getName() + " for " + "MDeskxxxxx ::");

        company.getBranches().get(0).getCustomers().get(0).ShowProductStockBranch(company, "MDeskxxxxx");


        company.startTheSystem();

    }


}
