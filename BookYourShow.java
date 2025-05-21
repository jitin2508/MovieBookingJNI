import java.util.Scanner;

public class BookYourShow {
    static {
        System.loadLibrary("BookYourShow"); // Load the JNI library
    }

    public native void handleExistingCustomer();
    public native void addNewCustomer();
    public native void addTheatre(String name, String location, String city, int capacity, String ownerName, int rows, int columns);
    public native void addShow(String theatreName, String movieName, int startHour, int startMinute, int endHour, int endMinute,
                               int day, int month, int year, String language, String cast, String rating, String overview, double price);
    public native void deleteTheatre(String theatreName);
    public native void deleteMovie(String movieName);
    public native void deleteShow(String theatreName, int startHour, int startMinute);
    public native void save();
    public native void start();

    public static void main(String[] args) {
        BookYourShow system = new BookYourShow();
        system.start();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to BookYourShow.Go ahead and grab tickets for your movies.");
            System.out.println("1. Login as a Customer");
            System.out.println("2. Login as an Admin");
            System.out.println("3. Signup");
            System.out.println("4. Exit");
            int command = getValidInt(scanner, "Enter your choice: ");

            if (command == 1) {
                system.handleExistingCustomer();
            } else if (command == 2) {
                System.out.print("Enter the secret key: ");
                String key = scanner.nextLine();
                if (!key.equals("123456")) continue;

                while (true) {
                    System.out.println("1. Add Theatre");
                    System.out.println("2. Add Show");
                    System.out.println("3. Delete Theatre");
                    System.out.println("4. Delete Movie");
                    System.out.println("5. Delete Show");
                    System.out.println("6. Log Out");

                    int adminCommand = getValidInt(scanner, "Enter your choice: ");

                    if (adminCommand == 1) {
                        System.out.print("Enter Theatre Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Location: ");
                        String location = scanner.nextLine();
                        System.out.print("Enter City: ");
                        String city = scanner.nextLine();
                        System.out.print("Enter Owner Name: ");
                        String ownerName = scanner.nextLine();

                        int rows, columns, capacity;
                        while (true) {
                            capacity = getValidInt(scanner, "Enter Capacity: ");
                            rows = getValidInt(scanner, "Enter Number of Rows: ");
                            columns = getValidInt(scanner, "Enter Number of Columns: ");
                            if (rows * columns != capacity) {
                                System.out.println("Rows and Columns don't match the capacity. Add correct capacity or change rows and columns.");
                            } else {
                                break;
                            }
                        }
                        System.out.println("Theatre added Succesfully.");
                        system.addTheatre(name, location, city, capacity, ownerName, rows, columns);
                    } else if (adminCommand == 2) {
                        System.out.print("Enter Theatre Name: ");
                        String theatreName = scanner.nextLine();
                        System.out.print("Enter Movie Name: ");
                        String movieName = scanner.nextLine();

                        int startHour = getValidInt(scanner, "Enter Start Time Hour (0-23): ", 0, 23);
                        int startMinute = getValidInt(scanner, "Enter Start Time Minute (0-59): ", 0, 59);

                        int endHour, endMinute;
                        while (true) {
                            endHour = getValidInt(scanner, "Enter End Time Hour (0-23): ", 0, 23);
                            endMinute = getValidInt(scanner, "Enter End Time Minute (0-59): ", 0, 59);
                            
                            int startTotalMinutes = startHour * 60 + startMinute;
                            int endTotalMinutes = endHour * 60 + endMinute;
                        
                            if (endTotalMinutes > startTotalMinutes || (endHour < startHour)) {
                                break;
                            } else {
                                System.out.println("End time must be after start time. Please re-enter.");
                            }
                        }
                        

                        int day = getValidInt(scanner, "Enter Date Day (1-31): ", 1, 31);
                        int month = getValidInt(scanner, "Enter Date Month (1-12): ", 1, 12);
                        int year = getValidInt(scanner, "Enter Date Year (e.g., 2024): ", 1900, 2100);

                        System.out.print("Enter Language: ");
                        String language = scanner.nextLine();
                        System.out.print("Enter Cast: ");
                        String cast = scanner.nextLine();

                        double price = getValidDouble(scanner, "Enter Price of a seat for the show: ");
                        System.out.print("Enter Rating: ");
                        String rating = scanner.nextLine();
                        System.out.print("Enter Overview: ");
                        String overview = scanner.nextLine();
                        system.addShow(theatreName, movieName, startHour, startMinute, endHour, endMinute, day, month, year,
                                language, cast, rating, overview, price);
                    
                    }
                    else if(adminCommand==3){
                        System.out.print("Enter Theatre Name: ");
                        String theatreName = scanner.nextLine();
                        system.deleteTheatre(theatreName);
                    }
                    else if(adminCommand==4){
                        System.out.print("Enter Movie Name: ");
                        String movieName = scanner.nextLine();
                        system.deleteMovie(movieName);
                    }
                    else if(adminCommand==5){
                        System.out.print("Enter Theatre Name: ");
                        String theatreName = scanner.nextLine();
                        System.out.print("Enter Start Time (Hour Minute): ");
                        int startHour=getValidInt(scanner, "Enter Start Time(Hour)");
                        int startMinute=getValidInt(scanner, "Enter Start Time(minute)");
                        system.deleteShow(theatreName,startHour,startMinute);
                    }
                     else if (adminCommand == 6) {
                        break;
                    }
                    else{
                        System.out.println("Invalid Command.Try Again");
                        continue;
                    }
                }
            }
            else if(command==3){
                system.addNewCustomer();
            }
             else if (command == 4) {
                system.save();
                break;
            }
            else{
                System.out.println("Invalid Command.Please try again");
            }
        }
        scanner.close();
    }

    private static int getValidInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
    }

    private static int getValidInt(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            int value = getValidInt(scanner, prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Input out of range (" + min + " - " + max + "). Try again.");
        }
    }

    private static double getValidDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid decimal number.");
            }
        }
    }
}