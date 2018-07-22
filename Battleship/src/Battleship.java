import java.util.*;

/*
Codes:
1 = player ships (displayed on map)
2 = computer ships (not displayed on map)
3 = sunk ships (displayed on map)
4 = player misses (displayed on map)
5 = computer misses (not displayed on map)
6 = player and computer misses (displayed on map)

Computer does not shoot on 2, 3, 5, and 6.
 */

public class Battleship {
    public static void main(String[] args) {
        int playerShips = 5;
        int computerShips = 5;
        Scanner input = new Scanner(System.in);
        Random num = new Random();
        System.out.println("*** Welcome to Battleship game ****");
        System.out.println(" ");
        String[][] map = new String[10][10];
        printMap(map, playerShips, computerShips);
        playerShips(map, input);
        computerShips(map, num);
        printMap(map, playerShips, computerShips);
        while (playerShips > 0 || computerShips > 0) {
            int[] ships = battleTurns(map, input, playerShips, computerShips, num);
            playerShips = ships[0];
            computerShips = ships[1];
            printMap(map, playerShips, computerShips);
        }
        if (playerShips > computerShips) {
            System.out.println("Hooray! You win the battle!");
        } else {
            System.out.println("Sorry, the computer wins.");
        }
    }

    public static void printMap(String[][] map, int pShips, int cShips) {
        System.out.println("   0123456789");
        for (int row = 0; row < map.length; row++) {
            System.out.print(row + " |");
            for (int column = 0; column < map[row].length; column++) {
                if (map[row][column] == "1") { // printing ships for player
                    System.out.print("@");
                } else if (map[row][column] == "2") { // printing ships for computer
                    System.out.print(" ");
                } else if (map[row][column] == "3") { // printing for sunk ships
                    System.out.print("x");
                } else if (map[row][column] == "4" || map[row][column] == "6") { // printing for player misses
                    System.out.print("-");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("| " + row);
        }
        System.out.println("   0123456789");
        System.out.println("Your ships: " + pShips + " | Computer ships: " + cShips);
        System.out.println("----------------------------------------");
    }

    public static void playerShips(String[][] map, Scanner input) {
        System.out.println("Deploy your ships:");
        int ships = 0;
        while (ships < 5) {
            System.out.print("Enter X coordinate for ship " + (ships + 1) + ": ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for ship " + (ships + 1) + ": ");
            int y = input.nextInt();
            if (x < 0 || x > 9 || y < 0 || y > 9) {
                System.out.println("Invalid location outside of map.");
            } else if (map[x][y] == null) {
                map[x][y] = "1";
                ships++;
            } else {
                System.out.println("Invalid location, already occupied.");
            }
        }
        System.out.println("----------------------------------------");
    }

    public static void computerShips(String[][] map, Random num) {
        int ships = 0;
        System.out.println("Computer is deploying ships.");
        while (ships < 5) {
            int x = num.nextInt(10);
            int y = num.nextInt(10);
            if (map[x][y] == null) {
                map[x][y] = "2";
                ships++;
                System.out.println(ships + ". Ship DEPLOYED");
            }
        }
        System.out.println("----------------------------------------");
    }

    public static int[] battleTurns(String[][] map, Scanner input, int pShips, int cShips, Random num) {
        boolean playerTurn = true;
        boolean computerTurn = true;
        while (playerTurn) {
            System.out.println("YOUR TURN");
            System.out.print("Enter X coordinate: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate: ");
            int y = input.nextInt();
            if (x < 0 || x > 9 || y < 0 || y > 9) {
                System.out.println("Invalid location outside of map.");
            } else {
                playerTurn = false;
                if (map[x][y] == "1") {
                    map[x][y] = "3";
                    System.out.println("Oh no, you sunk your own ship :(");
                    pShips--;
                } else if (map[x][y] == "2") {
                    map[x][y] = "3";
                    System.out.println("Boom! You sunk the ship!");
                    cShips--;
                } else if (map[x][y] == "3") {
                    System.out.println("This ship already sank.");
                } else if (map[x][y] == "5") {
                    System.out.println("Sorry, you missed."); // case for when computer and player shoot same spot
                    map[x][y] = "6";
                } else {
                    System.out.println("Sorry, you missed.");
                    map[x][y] = "4";
                }
            }
        }
        while (computerTurn) {
            System.out.println("COMPUTER'S TURN");
            int x = num.nextInt(10);
            int y = num.nextInt(10);
            /*Don't let computer shoot own ships, shoot sunk ships, or shoot own previous misses*/
            if (map[x][y] != "2" || map[x][y] != "3" || map[x][y] != "5" || map[x][y] != "6") {
                computerTurn = false;
                if (map[x][y] == "1") {
                    map[x][y] = "3";
                    System.out.println("The computer sunk one of your ships!");
                    pShips--;
                } else if (map[x][y] == "4"){
                    System.out.println("The computer missed.");
                    map[x][y] = "6";
                } else {
                    System.out.println("The computer missed.");
                    map[x][y] = "5";
                }

            }
        }
        System.out.println("----------------------------------------");
        int[] ships = {pShips, cShips};
        return ships;
    }
}