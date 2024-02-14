package test;

public class Sample {
    public static void main(String[] args) {
      int matrixSize = 7;
/*        int spaces = matrixSize - 1;
        for (int i = 0; i < matrixSize; i++) {
            int counter = spaces;
            for (int j = 0; j < matrixSize; j++) {
                if(counter>0){
                    System.out.print(" ");
                    counter--;
                    continue;
                }
                System.out.print("*");
            }
            System.out.println();
            spaces--;
        }
        spaces = 1;
        for (int i = 0; i < matrixSize; i++) {
            int counter = 0;
            for (int j = 0; j < matrixSize; j++) {
                if(counter<spaces){
                    System.out.print(" ");
                    counter++;
                    continue;
                }
                System.out.print("*");
            }
            System.out.println();
            spaces++;
        }*/

        for (int i = matrixSize; i >= 1 ; i--) {
            for (int j = 1; j < i ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < matrixSize-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
