public abstract class Person implements AutomationSystem{
    String id;
    String name;
    String surname;
    String email;
    String password;

    public String getId(){
        return id;
    }
    public  String getName(){
        return  name;
    }

    public  String getSurname(){
        return surname;
    }

    public  String getEmail(){
        return  email;
    }

    public  String getPassword(){
        return  password;
    }

    public void AutoAssignId(){

    }
    @Override
    public abstract void menu();
}

