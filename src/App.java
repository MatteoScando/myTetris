import java.util.Scanner;

public class App {
    public static void gestisciMatrice(int y, int x, int[][] matrix) {
        if (matrix[y][x] == 0) {
            System.out.print("  ");
        }else if(matrix[y][x] == 1){
            System.out.print("[]");
        }else{
            System.out.print("██");
        }   
    }
    
    public static void printMatrix(int[][] matrix, String border){
        for (int y = 0; y < matrix.length; y++) {
            if(y == 0){
                for (int i = 0; i < matrix[y].length + 2; i++) {
                    System.out.print(border);
                    if(i == matrix[y].length + 1){
                        System.out.println();
                    }
                }
            }   

            for (int x = 0; x < matrix[y].length; x++) {
                if (x==0){
                    System.out.print(border);
                }

                gestisciMatrice(y,x,matrix);

                if (x==matrix[x].length-1){
                    System.out.print(border);
                }
            }

            System.out.println();
            if(y == matrix.length-1){
                for (int j = 0; j < matrix[y].length + 2; j++) {
                    System.out.print(border);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.print("\033\143");
        Scanner scanner = new Scanner(System.in);
        
        int[][] matrix = new int[20][10];
        matrix[19][9] = 2;

        String border = "▒▒";

        int countMatrixInput = 0;
        while (true){
            System.out.print("\033\143");
            printMatrix(matrix, border);

            countMatrixInput++;
            System.out.println("Matrix stampato " + countMatrixInput + " volte");

            scanner.nextLine();
        }
    }


}