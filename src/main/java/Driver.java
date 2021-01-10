import java.util.Scanner;

public class Driver {
    public static void main(String[] args){
        CommandLineInterface commandLineInterface = new CommandLineInterface();
        Scanner scanner = new Scanner(System.in);
        int noOfSnakes = scanner.nextInt();
        scanner.nextLine();
        while (noOfSnakes-->0)
            commandLineInterface.addSnake(scanner.nextLine());
        int noOfLadders = scanner.nextInt();
        scanner.nextLine();
        while (noOfLadders-->0)
            commandLineInterface.addLadder(scanner.nextLine());
        int noOfPlayers = scanner.nextInt();
        scanner.nextLine();
        while (noOfPlayers-->0)
            commandLineInterface.addPlayer(scanner.nextLine());
        commandLineInterface.play();
    }
}
