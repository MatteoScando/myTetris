package others;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Tetris extends JFrame implements KeyListener {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 20;
    private char[][] grid;
    private int pieceRow = 0;
    private int pieceCol = 4;

    public Tetris() throws InterruptedException {
        setTitle("Tetris Console");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        setVisible(true);

        grid = new char[HEIGHT][WIDTH];
        clearGrid();
        placePiece();

        while (true) { 
            Thread.sleep(1000);
            moveDown();
        }
    }

    // Pulisce la griglia
    private void clearGrid() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    // Posiziona il pezzo nella griglia
    private void placePiece() {
        clearGrid();
        grid[pieceRow][pieceCol] = 'X'; // Pezzo di Tetris
    }

    // Stampa la griglia
    private void printGrid() {
        System.out.println("+----------+");
        for (int i = 0; i < HEIGHT; i++) {
            System.out.print("|");
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("+----------+");
    }

    // Movimento a sinistra
    public void moveLeft() {
        if (pieceCol > 0) {
            pieceCol--;
            placePiece();
            printGrid();
        }
    }

    // Movimento a destra
    public void moveRight() {
        if (pieceCol < WIDTH - 1) {
            pieceCol++;
            placePiece();
            printGrid();
        }
    }

    public void moveDown(){
        if (pieceRow < HEIGHT - 1){
            if(pieceRow + 1 == HEIGHT - 1){
                pieceRow ++;
                placePiece();
                printGrid();

            }else{
                pieceRow ++;
                placePiece();
                printGrid();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                moveRight();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) throws InterruptedException {
        new Tetris();
    }
}