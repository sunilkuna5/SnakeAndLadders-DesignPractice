import java.util.Scanner;

public class Driver {
    public static void main(String[] args){
        CommandLineAdapter commandLineAdapter = new CommandLineAdapter();
        Scanner scanner = new Scanner(System.in);
        int noOfSnakes = scanner.nextInt();
        scanner.nextLine();
        while (noOfSnakes-->0)
            commandLineAdapter.addSnake(scanner.nextLine());
        int noOfLadders = scanner.nextInt();
        scanner.nextLine();
        while (noOfLadders-->0)
            commandLineAdapter.addLadder(scanner.nextLine());
        int noOfPlayers = scanner.nextInt();
        scanner.nextLine();
        while (noOfPlayers-->0)
            commandLineAdapter.addPlayer(scanner.nextLine());
        commandLineAdapter.play();
    }
}
