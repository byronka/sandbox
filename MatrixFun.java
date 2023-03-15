public class MatrixFun {

    static char[][] example1 = new char[][] {
            {'.', '.', '.', '.', '.'},
            {'.', 'F', 'F', 'F', '.'},
            {'.', '.', 'F', '.', '.'},
            {'.', '.', 'F', '.', '.'},
            {'.', '.', '.', '.', '.'},
            {'.', '#', '.', '.', '.'},
            {'.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.'},
    };

    static char[][] example2 = new char[][] {
            {'.', '.', '.', '.', '.'},
            {'.', 'F', 'F', 'F', '.'},
            {'.', '.', 'F', '.', '.'},
            {'.', '.', 'F', '.', '.'},
            {'.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.'},
    };
    public static void main(String[] args) {

        char[][] input = example1;
        boolean canMoveDown = true;

        while(canMoveDown) {
            canMoveDown = canFigureMoveDown(input);
            if (canMoveDown) {
                input = moveDown(input);
                printout(input);
            }
            System.out.println();
        }

    }

    private static void printout(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] moveDown(char[][] matrix) {
        char[][] temporary = new char[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 'F') {
                    temporary[i][j] = '.';
                } else {
                    temporary[i][j] = matrix[i][j];
                }

            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 'F') {
                    temporary[i+1][j] = matrix[i][j];
                }
            }
        }
        return temporary;
    }

    private static boolean canFigureMoveDown(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 'F' && (i == matrix.length - 1 || matrix[i+1][j] == '#')) {
                    return false;
                }
            }
        }
        return true;
    }
}
