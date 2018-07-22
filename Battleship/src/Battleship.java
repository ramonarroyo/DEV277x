import java.util.*;

public class Battleship {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("*** Welcome to Battleship game ****");
        char[][] map = new char[10][10];
        createMap(map);
        printMap(map);
        playerShips(map, input);
        printMap(map);
    }

    public static void createMap(char[][] map){
        for (char[] row: map)
            Arrays.fill(row, ' ');
    }

    public static void printMap(char[][] map){
        System.out.println("");
        System.out.println("   0123456789");
        for (int row = 0; row < map.length; row++){
            System.out.print(row + " |");
            for (int column = 0; column < map[row].length; column++){
                System.out.print(map[row][column]);
            }
            System.out.println("| " + row);
        }
        System.out.println("   0123456789");
        System.out.println("");
    }

    public static void playerShips(char [][] map, Scanner input){
        System.out.println("Deploy your ships:");
        int ships = 0;
        while (ships < 5){
            System.out.print("Enter X coordinate for ship " + (ships + 1) + ": ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for ship " + (ships + 1) + ": ");
            int y = input.nextInt();
            if (x < 0 || x > 9 || y < 0 || y > 9){
                System.out.println("Invalid location outside of map.");
            } else if (map[x][y] == ' '){
                map[x][y] = '@';
                ships++;
            } else {
                System.out.println("Invalid location, already occupied.");
            }
        }
    }
}