package Project_java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class User {
    protected String fullName;
    protected String password;
    protected Date createdAt;
    protected static String ID;
    protected String email;
    protected Date dateOfBirth;
    protected String address;
    protected String phoneNumber;
    protected static List<User> registerList = new ArrayList<>();
    protected boolean isLoggedIn;

    public static String getID() {
        return ID;
    }

    public void setID(String ID) {
        User.ID = ID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    private void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your email:");
        String email = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        for (User user : registerList) {
            if (user.email.equals(email) && user.password.equals(password)) {
                user.isLoggedIn = true;
                System.out.println("Login successful!");
                return;
            }
        }

        System.out.println("Invalid email or password. Please try again.");
    }

    public static void register() {
        Scanner scanner = new Scanner(System.in);
        User newUser = new User();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("Enter your full name:");
        newUser.setFullName(scanner.nextLine());

        System.out.println("Enter your email:");
        newUser.setEmail(scanner.nextLine());

        System.out.println("Enter your password:");
        newUser.setPassword(scanner.nextLine());

        System.out.println("Enter your date of birth (YYYY-MM-DD):");
        String dob = scanner.nextLine();
        try {
            newUser.dateOfBirth = dateFormat.parse(dob);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
            return;
        }

        System.out.println("Enter your address:");
        newUser.setAddress(scanner.nextLine());

        System.out.println("Enter your phone number:");
        newUser.setPhoneNumber(scanner.nextLine());

        newUser.setCreatedAt(new Date());
        newUser.setLoggedIn(true);

        registerList.add(newUser);

        System.out.println("Registration successful!");
    }

    public static void logout() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your email:");
        String email = scanner.nextLine();

        for (User user : registerList) {
            if (user.email.equals(email) && user.isLoggedIn) {
                user.isLoggedIn = false;
                System.out.println("Logged out successfully!");
                return;
            }
        }

        System.out.println("User not found or already logged out.");
    }
}
