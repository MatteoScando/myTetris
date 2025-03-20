import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.util.Random;

public class App{
    private static final int WIDTH = 10;
    private static final int HEIGHT = 20;
    private int[][] matrix;
    private int[][] tetramine = new int[2][4];
    private static String border = "▒▒";

    public void main(String[] args) throws Exception {
        System.out.print("\033\143");
        matrix = new int[HEIGHT][WIDTH];
        clearGrid();
        // placePiece();

        while (true) { 
            Thread.sleep(1000);
            // moveDown();
        }
    }

    private void placePiece() {
        for (int y = 0; y < tetramine.length; y++) {
            for (int x = 0; x < tetramine.length; x++) {
                matrix[y][x] = 1;
            }
        }
    }

    private void clearGrid() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                matrix[i][j] = ' ';
            }
        }
    }



    public void printMatrix() {
        System.out.print("\033\143");
        for (int y = 0; y < matrix; y++) {
            if (y == 0) {
                for (int i = 0; i < matrix[y].length + 2; i++) {
                    System.out.print(border);
                    if (i == matrix[y].length + 1) {
                        System.out.println();
                    }
                }
            }

            for (int x = 0; x < matrix[y].length; x++) {
                if (x == 0) {
                    System.out.print(border);
                }

                //TODO: fare qualcosa

                if (x == matrix[y].length - 1) {
                    System.out.print(border);
                }
            }

            System.out.println();

            if (y == matrix.length - 1) {
                for (int j = 0; j < matrix[y].length + 2; j++) {
                    System.out.print(border);
                }
            }
        }
    }
}