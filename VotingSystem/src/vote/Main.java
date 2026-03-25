package vote;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Simple Voting System ===");
        System.out.println("1. Vote");
        System.out.println("2. Show Results");
        System.out.print("Choose option: ");
        int choice = sc.nextInt();

        if(choice == 1) {
            Voting.vote();
        } else if(choice == 2) {
            Voting.showResults();
        } else {
            System.out.println("Invalid choice!");
        }

        sc.close();
    }
}