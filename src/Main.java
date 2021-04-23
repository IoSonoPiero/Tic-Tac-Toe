import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // contains the coordinate of cell
        int coordinateX = 0;
        int coordinateY = 0;

        // allocate String array filled with spaces
        String[] grid = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
        char winner;
        boolean coordinateAcquired = false;
        boolean endGame = false;
        boolean haveWinner = false;
        char player = 'X';

        // contains the filled cells. When it's 9, the game is over.
        int cellsFilled = 0;

        do {
            // print the grid
            System.out.print("---------\n");
            for (int i = 0; i < grid.length; i += 3) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(grid[i + j] + " ");
                }
                System.out.println("|");
            }
            System.out.print("---------\n");

            // verify rows
            for (int i = 0; i < 9; i += 3) {
                String a = grid[i];
                String b = grid[i + 1];
                String c = grid[i + 2];

                if (a.equals(b) && b.equals(c) && !a.equals(" ")) {
                    endGame = true;
                    haveWinner = true;
                    winner = a.charAt(0);
                }
            }
            // exit from do while loop
            if (endGame) break;

            // verify columns
            for (int i = 0; i < 3; i++) {
                String a = grid[i];
                String b = grid[i + 3];
                String c = grid[i + 6];

                if (a.equals(b) && b.equals(c) && !a.equals(" ")) {
                    endGame = true;
                    haveWinner = true;
                    winner = a.charAt(0);
                }
                // exit from do while loop
                if (endGame) break;
            }

            // verify diagonal 1
            String a = grid[0];
            String b = grid[4];
            String c = grid[8];

            if (a.equals(b) && b.equals(c) && !a.equals(" ")) {
                endGame = true;
                haveWinner = true;
                winner = a.charAt(0);
            }
            // exit from do while loop
            if (endGame) break;

            // verify diagonal 2
            String d = grid[2];
            String e = grid[4];
            String f = grid[6];

            if (d.equals(e) && e.equals(f) && !d.equals(" ")) {
                endGame = true;
                haveWinner = true;
                winner = d.charAt(0);
            }
            // exit from do while loop
            if (endGame) break;

            // verify no more cells available
            cellsFilled = 0;
            for (String s : grid) {
                if (s.equals(" ")) {
                    endGame = false;
                    break;
                } else {
                    cellsFilled++;
                }
            }

            // if cells are 9, game is over
            if (cellsFilled == 9) endGame = true;

            // exit from do while loop
            if (endGame) break;

            do {
                // alternate player if coordinates are acquired
                if (coordinateAcquired) {
                    if (player == 'X') {
                        player = 'O';
                    } else {
                        player = 'X';
                    }
                }

                // acquire coordinates x and y
                System.out.print("Enter the coordinates: ");
                Scanner matrix = new Scanner(System.in);
                if (matrix.hasNextInt()) {
                    coordinateX = matrix.nextInt();
                } else {
                    System.out.println("You should enter numbers!");
                    continue;
                }

                if (matrix.hasNextInt()) {
                    coordinateY = matrix.nextInt();
                } else {
                    System.out.println("You should enter numbers!");
                    continue;
                }

                if (coordinateY > 3 || coordinateY < 1 || coordinateX > 3 || coordinateX < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                switch (coordinateX) {
                    case 1:
                        if (grid[-coordinateX + coordinateY].equals(" ")) {
                            grid[-coordinateX + coordinateY] = String.valueOf(player);
                            coordinateAcquired = true;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                            coordinateAcquired = false;
                            continue;
                        }
                        break;
                    case 2:
                        if (grid[coordinateX + coordinateY].equals(" ")) {
                            grid[coordinateX + coordinateY] = String.valueOf(player);
                            coordinateAcquired = true;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                            coordinateAcquired = false;
                            continue;
                        }
                        break;
                    case 3:
                        if (grid[coordinateX + coordinateY + 2].equals(" ")) {
                            grid[coordinateX + coordinateY + 2] = String.valueOf(player);
                            coordinateAcquired = true;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                            coordinateAcquired = false;
                            continue;
                        }
                        break;
                }
            } while (!coordinateAcquired);
        } while (!endGame);
        if (haveWinner) {
            System.out.println(player + " wins");
        } else {
            System.out.println("Draw");
        }
    }
}