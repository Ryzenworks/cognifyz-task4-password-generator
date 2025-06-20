package LevelOneTasks;

import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator  {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String[] decision = new String[4];
        String password = "";
        int passwordLength;
        System.out.println("--PasswordGenerator--");
        System.out.print("Enter the length of the Password: ");
        passwordLength = scanner.nextInt();
        if(passwordLength<4){
            throw new IllegalArgumentException("Password length should be more than 4 characters");
        }
        System.out.print("Include Numbers (Yes/No): ");
        decision[0] = scanner.next();
        System.out.print("Include Uppercase (Yes/No): ");
        decision[1] = scanner.next();
        System.out.print("Include Lowercase (Yes/No): ");
        decision[2] = scanner.next();
        System.out.print("Include Special characters (Yes/No): ");
        decision[3] = scanner.next();
        for(int i = 0; i<decision.length; i++){
            decision[i] = decision[i].toLowerCase();
        }
        while (password.length() < passwordLength){
            if(decision[0].equals("yes")) password = password + getNum(random);
            if(decision[1].equals("yes")) password = password + (char)(getUpperCase(random));
            if(decision[2].equals("yes")) password = password + (char)(getLowerCase(random));
            if(decision[3].equals("yes")) password = password + getSpecialCharacter(random);
        }
        for(int i = 0; i<passwordLength; i++){
            System.out.print(password.charAt(i));
        }
        scanner.close();
    }
    public static int getLowerCase(Random random){
        return (random.nextInt(26) + 97);
    }
    public static int getUpperCase(Random random){
        return (random.nextInt(26) + 65);
    }
    public static int getNum(Random random){
        return random.nextInt(10);
    }
    public static char getSpecialCharacter(Random random){
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:,.<>?/~";
        return specialCharacters.charAt(random.nextInt(specialCharacters.length()));
    }
}
