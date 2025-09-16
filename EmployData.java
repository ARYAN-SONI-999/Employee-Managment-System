import java.util.*;

class Employe {
    private static final String ANSI_CYAN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_GREEN = "\u001B[36m";
    private static final String ANSI_RED = "\u001B[31m";
    String emp_name;
    int emp_id;
    int emp_joining_year;
    double emp_salary;
    int designation;
    String emp_MobileNumber;
    String emp_designation;
    int emp_experience;
    String emp_aadhar_no;
    double emp_incremented_salary;

    Employe[] arr;
    int no_emp;
    static Scanner sc = new Scanner(System.in);

    void setdate() {
        System.out.print("Enter Number of Employees: ");
        no_emp = sc.nextInt();
        arr = new Employe[no_emp];

        for (int i = 0; i < no_emp; i++) {
            System.out.println("-----------------------------------------");
            System.out.println("Employee NO:" + (i + 1));
            System.out.println("-----------------------------------------");
            arr[i] = new Employe();
            sc.nextLine();
            System.out.print("Enter Name: ");
            arr[i].emp_name = sc.nextLine();

            System.out.print("Enter Joining Year: ");
            arr[i].emp_joining_year = sc.nextInt();
            while (arr[i].emp_joining_year < 2000 || arr[i].emp_joining_year > 2025) {
                System.out.print(ANSI_RED+"Enter Valid Joining Year(2000-2025): "+ ANSI_RESET);
                arr[i].emp_joining_year = sc.nextInt();
            }

            System.out.print("Enter Mobile Number: ");
            while (true) {
                arr[i].emp_MobileNumber = sc.next();
                if (arr[i].emp_MobileNumber.length() == 10 && arr[i].emp_MobileNumber.matches("\\d+")) {
                    break;
                } else {
                    System.out.print(ANSI_RED+"Enter a valid 10-digit Mobile Number: "+ ANSI_RESET);
                }
            }
			System.out.print("Enter Aadhar Number: ");
			while (true) {
                arr[i].emp_aadhar_no = sc.next();
                if (arr[i].emp_aadhar_no.length() == 12 ) {
                    break;
                } else {
                    System.out.print(ANSI_RED+"Enter a valid 12-digit Aadhar Number: "+ ANSI_RESET);
                }
            }
			
            
            System.out.print("Enter Employee Salary: ");
            arr[i].emp_salary = sc.nextDouble();

            while (true) {
			System.out.print("Enter Designation:\n1. Junior\n2. Executive\n3. Manager\n--> ");
            arr[i].designation = sc.nextInt();
			
			if(arr[i].designation>0 && arr[i].designation<=3)
			{
			
			if (arr[i].designation == 1) arr[i].emp_designation = "Junior";
            else if (arr[i].designation == 2) arr[i].emp_designation = "Executive";
            else if (arr[i].designation == 3) arr[i].emp_designation = "Manager";
			break;
			}

            }
         System.out.println("-----------------------------------------");
            }
    }

    void experience() {
        int currentYear = 2025;
        for (int i = 0; i < no_emp; i++) {
            arr[i].emp_experience = currentYear - arr[i].emp_joining_year;
        }
    }

    void generateid() {
        int count = 1;
        for (int i = 0; i < no_emp; i++) {
            arr[i].emp_id = count;
            count++;
        }
    }

    void appraisal() {
        for (int i = 0; i < no_emp; i++) {
            if (arr[i].designation == 1) {
                arr[i].emp_incremented_salary = arr[i].emp_salary * (arr[i].emp_experience <= 2 ? 1.1 : 1.2);
            } else if (arr[i].designation == 2) {
                arr[i].emp_incremented_salary = arr[i].emp_salary * (arr[i].emp_experience <= 1 ? 1.1 : 1.15) + (arr[i].emp_experience <= 1 ? 500 : 1000);
            } else if (arr[i].designation == 3) {
                arr[i].emp_incremented_salary = arr[i].emp_salary * (arr[i].emp_experience <= 10 ? 1.05 : 1.15) + (arr[i].emp_experience <= 10 ? 500 : 1000);
            }
        }
    }

    void printData() {
        experience();
        appraisal();
        generateid();
        for (int i = 0; i < no_emp; i++) {
            System.out.println("-----------------------------------------");
            System.out.println("Employee " + (i + 1));
            System.out.println("Name: " + arr[i].emp_name);
            System.out.println("ID: " + arr[i].emp_id);
            System.out.println("Aadhar Number: " + arr[i].emp_aadhar_no);
            System.out.println("Mobile Number: " + arr[i].emp_MobileNumber);
            System.out.println("Joining Year: " + arr[i].emp_joining_year + " year");
            System.out.println("Experience: " + arr[i].emp_experience + " year");
            System.out.println("Salary: " + arr[i].emp_salary);
            System.out.println("Designation: " + arr[i].emp_designation);
            System.out.println("Incremented Salary: " + arr[i].emp_incremented_salary);
            System.out.println("-----------------------------------------");
            }
    }

    void printData(int i) {
		 System.out.println("-----------------------------------------");
        System.out.println("Name: " + arr[i].emp_name);
        System.out.println("ID: " + arr[i].emp_id);
        System.out.println("Joining Year: " + arr[i].emp_joining_year+ " year");
        System.out.println("Mobile Number: " + arr[i].emp_MobileNumber);
        System.out.println("Aadhar Number: " + arr[i].emp_aadhar_no);
        System.out.println("Experience: " + arr[i].emp_experience);
        System.out.println("Salary: " + arr[i].emp_salary);
        System.out.println("Designation: " + arr[i].emp_designation);
        System.out.println("Incremented Salary: " + arr[i].emp_incremented_salary);
         System.out.println("-----------------------------------------");
           
    }

    void sortBySalary() {
		int count=0;
        for (int i = 0; i < no_emp - 1; i++) {
            for (int j = i + 1; j < no_emp; j++) {
                if (arr[i].emp_incremented_salary < arr[j].emp_incremented_salary) {
                    Employe temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
					count++;
                }
            }
        }
	printData();
    }

    void sortbyjoiningyear() {
		int count=0;
        for (int i = 0; i < no_emp - 1; i++) {
            for (int j = i + 1; j < no_emp; j++) {
                if (arr[i].emp_joining_year > arr[j].emp_joining_year) {
                    Employe temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
       printData();
	}

    void searchEmployee() {
        while (true) {
            System.out.print("Search by :\n1. Name\n2. ID\n--> ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: {
					int count=0;
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    for (int i = 0; i < no_emp; i++) {
                        if (arr[i].emp_name.equalsIgnoreCase(name)) {
                            printData(i);
							count++;
                            break;
                        }
                    }
				if(count==0)
				{
				System.out.println(ANSI_RED+"Enter a valid Detail"+ ANSI_RESET);
				}
                }
                return;
                case 2: {
					int count=0;
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    for (int i = 0; i < no_emp; i++) {
                        if (arr[i].emp_id == id) {
                            printData(i);
							count++;
                            break;
                        }
                    }
				if(count==0)
				{
				System.out.println(ANSI_RED+"Enter a valid Detail"+ ANSI_RESET);
				}
                }
                return;
                default: {
                    System.out.println(ANSI_RED+"Please enter a valid choice."+ ANSI_RESET);
                }
            }
        }
    }

    void editEmployee() {
        System.out.print("Enter Employee ID to Edit: ");
        int id = sc.nextInt();
        for (int i = 0; i < no_emp; i++) {
            if (arr[i].emp_id == id) {
                System.out.print("Edit :\n1. Salary\n2. Mobile Number\n3. Designation\n--> ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) { 
                    case 1:
                        System.out.print("Enter New Salary: ");
                        arr[i].emp_salary = sc.nextDouble();
                        break;
                    case 2:
                        System.out.print("Enter New Mobile Number: ");
                        while (true) {
						String a = sc.nextLine();
						if (a.length() == 10 ) {
					   arr[i].emp_MobileNumber=a; 
						break;
						} else {
                    System.out.print(ANSI_RED+"Enter a valid 10-digit Mobile Number: "+ ANSI_RESET);
                }
            }break;
                    case 3:
                        System.out.print("Enter New Designation (1. Junior, 2. Executive, 3. Manager): ");
                        arr[i].designation = sc.nextInt();
                        break;
                    default:
                        System.out.println(ANSI_RED+"Please enter a valid choice."+ ANSI_RESET);
                }
                return;
            }
        }
    }

    void removeEmployee() {
        System.out.print("Enter Employee ID to Remove: ");
        int id = sc.nextInt();
        for (int i = 0; i < no_emp; i++) {
            if (arr[i].emp_id == id) {
                arr[i] = arr[no_emp - 1];
                no_emp--;
                System.out.println("Employee Removed.");
                return;
            }
        }
        System.out.println(ANSI_RED+"Employee not found."+ANSI_RESET);
    }
}

class EmployData {
    // ANSI codes for color
    private static final String ANSI_CYAN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_GREEN = "\u001B[36m";
    private static final String ANSI_RED = "\u001B[31m";
    
    public static void main(String[] Args) {
        System.out.println(ANSI_CYAN + "***************************************************");
        System.out.println("----------EMPLOYEE DATA MANAGEMENT SYSTEM----------");
        System.out.println("***************************************************" + ANSI_RESET);

        Employe ob = new Employe();
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        while (b) {
            System.out.print("Enter Choice:"+ANSI_GREEN+"\n1. Enter Employee Data\n2. Display Employee Data\n3. Sort By Salary \n4. Search Employee\n5. Edit Employee Data\n6. Remove Employee Data\n7. Sort By Joining year\n8. Exit\n--> " + ANSI_RESET);
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    ob.setdate();
                    break;
                }
                case 2: {
                    ob.printData();
                    break;
                }
                case 3: {
                    ob.sortBySalary();
                    break;
                }
                case 4: {
                    ob.searchEmployee();
                    break;
                }
                case 5: {
                    ob.editEmployee();
                    break;
                }
                case 6: {
                    ob.removeEmployee();
                    break;
                }
				case 7: {
                    ob.sortbyjoiningyear();
                    break;
                }
                case 8: {
                    b = false;
                    System.out.println(ANSI_CYAN + "----Exit----" + ANSI_RESET);
                    break;
                }
                default: {
                    System.out.println(ANSI_RED+"Invalid Choice."+ ANSI_RESET);
                }
            }
        }
    }
}