
public class Six {

    public static void main(String args[]) {
        Employee Kage = new Employee();
        Employee Leap = new Employee();
        Leap.Role = "Frontend Developer";
        Kage.Role = "Backend Developer";
        
    }
}

class General {

    int ID;
    String name;
    char gender;
    int age;
    General(){
        ID = 0001;
        name = "Unknown";
        gender = 'M';
        age = 18;
    }
};

class Employee extends General {

    String Role;
};

class Car extends General {

    double price;
    String date;
    double HP;
};

class BankAccount extends General {

    double money;
    double date;
    int PIN;
};

class Video extends General {

    String Author;
    String UploadDate;
    String VideoLength;
};
