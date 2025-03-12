import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class App {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 20;
    private char[][] grid;
    private int pieceRow = 0;
    private int pieceCol = 4;



    public static void matrixOptions(int y, int x, int[][] matrix){
        if (matrix[y][x] == 0) {
            System.out.print("  ");
        } else if (matrix[y][x] == 1) {
            System.out.print("[]");
        } else {
            System.out.print("██");
        }
    }

    public static void printMatrix(int[][] matrix, String border){
        System.out.print("\033\143");
        for (int y = 0; y < matrix.length; y++) {
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

                matrixOptions(y, x, matrix);

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

    public static void getNextPositionDown(int[][] matrix, int[][] position){
        for (int y = 0; y < position.length; y++) {
            for (int x = 0; x < position.length; x++) {
                if(matrix[y+1][x] == 1){
                    transformToBlock();
                }
            }
        }
    }

    public static void moveObject(int[][] matrix, String border){
        // Create a JFrame to capture key events
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setSize(200, 200);
        frame.setOpacity(0.0f);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                System.out.println("Tasto premuto: " + KeyEvent.getKeyText(keyCode));

                // Update the matrix based on key presses
                if (keyCode == KeyEvent.VK_UP) {
                    // Move up
                    // Update matrix accordingly
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    // Move down
                    // Update matrix accordingly
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    // Move left
                    // Update matrix accordingly
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    // Move right
                    // Update matrix accordingly
                }

                // Refresh the matrix display
                printMatrix(matrix, border);
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        frame.setVisible(true);
        frame.requestFocus();

        // Initial print of the matrix
        printMatrix(matrix, border);
    }

    public static void main(String[] args) throws Exception {
        System.out.print("\033\143");

        String border = "▒▒";
        int[][] matrix = new int[20][10];
        matrix[19][9] = 2;

        moveObject(matrix, border);
    }
}