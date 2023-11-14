package Array;

public class twoDArray {

    public static int[][] getSubmatrix(int[][] matrix, int startRow, int endRow, int startCol, int endCol) {
        int subRows = endRow - startRow + 1;
        int subCols = endCol - startCol + 1;
        int[][] submatrix = new int[subRows][subCols];

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                submatrix[i - startRow][j - startCol] = matrix[i][j];
            }
        }

        return submatrix;
    }

    public static void operateOnBoundary(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;

        // Operate on top and bottom boundaries
        for (int i = 0; i < cols; i++) {
            // Top boundary
            // Your operation here

            // Bottom boundary
            // Your operation here
        }

        // Operate on left and right boundaries
        for (int i = 0; i < rows; i++) {
            // Left boundary
            // Your operation here

            // Right boundary
            // Your operation here
        }
    }

    public static boolean isSymmetric(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;

        if (rows != cols) {
            return false;  // Not a square matrix, cannot be symmetric
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i][j] != array[j][i]) {
                    return false;  // Not symmetric
                }
            }
        }

        return true;  // Symmetric
    }

    public static void applyMask(int[][] array, int mask) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] &= mask;  // Apply mask using bitwise AND
            }
        }
    }

    public static int[] transformTo1DArray(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int[] oneDArray = new int[rows * cols];

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                oneDArray[index++] = array[i][j];
            }
        }

        return oneDArray;
    }

    public static int[][] reshapeMatrix(int[][] matrix, int newRows, int newCols) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows * cols != newRows * newCols) {
            // Reshaping is not possible
            return matrix;
        }

        int[][] reshapedMatrix = new int[newRows][newCols];

        int[] flatArray = new int[rows * cols];
        int index = 0;

        // Flatten the original matrix
        for (int[] row : matrix) {
            for (int value : row) {
                flatArray[index++] = value;
            }
        }

        // Fill the reshaped matrix
        index = 0;
        for (int i = 0; i < newRows; i++) {
            for (int j = 0; j < newCols; j++) {
                reshapedMatrix[i][j] = flatArray[index++];
            }
        }

        return reshapedMatrix;
    }

    public static int[][] transformTo2DArray(int[] array, int numRows, int numCols) {
        int length = array.length;

        if (length % numCols != 0) {
            // Transformation is not possible
            return null;
        }

        int[][] twoDArray = new int[numRows][numCols];

        int index = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                twoDArray[i][j] = array[index++];
            }
        }

        return twoDArray;
    }

}
