import java.util.*;

public class Main {

    static Random rand = new Random();

    public static void main(String[] args) {

        // 1. Сумма отрицательных элементов A[20]
        int[] A20 = randomIntArray(20, -20, 20);
        int sumNegA20 = 0;
        for (int x : A20)
            if (x < 0) sumNegA20 += x;
        System.out.println("1) Сумма отрицательных A[20]: " + sumNegA20);

        // 2. Сумма положительных элементов B[15]
        int[] B15 = randomIntArray(15, -20, 20);
        int sumPosB15 = 0;
        for (int x : B15)
            if (x > 0) sumPosB15 += x;
        System.out.println("2) Сумма положительных B[15]: " + sumPosB15);

        // 3. Произведение отрицательных A[12] (вещественные)
        double[] A12 = randomDoubleArray(12, -10, 10);
        double prodNegA12 = 1;
        for (double x : A12)
            if (x < 0) prodNegA12 *= x;
        System.out.println("3) Произведение отрицательных A[12]: " + prodNegA12);

        // 4. Произведение положительных C[25]
        int[] C25 = randomIntArray(25, -10, 10);
        long prodPosC25 = 1;
        for (int x : C25)
            if (x > 0) prodPosC25 *= x;
        System.out.println("4) Произведение положительных C[25]: " + prodPosC25);

        // 5. Среднее арифметическое D[17]
        int[] D17 = randomIntArray(17, -10, 10);
        double avgD17 = Arrays.stream(D17).average().orElse(0);
        System.out.println("5) Среднее D[17]: " + avgD17);

        // 6. A[10][10] сумма отрицательных по строкам → B[10]
        int[][] A10x10 = randomIntMatrix(10, 10, -10, 10);
        int[] B10 = new int[10];
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                if (A10x10[i][j] < 0)
                    B10[i] += A10x10[i][j];
        System.out.println("6) Суммы отрицательных по строкам A[10][10]: " + Arrays.toString(B10));

        // 7. B[5][5] сумма положительных по строкам → A[5]
        int[][] B5x5 = randomIntMatrix(5, 5, -10, 10);
        int[] A5 = new int[5];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (B5x5[i][j] > 0)
                    A5[i] += B5x5[i][j];
        System.out.println("7) Суммы положительных по строкам B[5][5]: " + Arrays.toString(A5));

        // 8. A[12][6] произведение отрицательных по столбцам
        int[][] A12x6 = randomIntMatrix(12, 6, -5, 5);
        long[] prodCols = new long[6];
        Arrays.fill(prodCols, 1);
        for (int j = 0; j < 6; j++)
            for (int i = 0; i < 12; i++)
                if (A12x6[i][j] < 0)
                    prodCols[j] *= A12x6[i][j];
        System.out.println("8) Произведение отрицательных по столбцам: " + Arrays.toString(prodCols));

        // 9. C[5][5] произведение положительных главной диагонали
        int[][] C5x5 = randomIntMatrix(5, 5, -5, 5);
        long prodDiag = 1;
        for (int i = 0; i < 5; i++)
            if (C5x5[i][i] > 0)
                prodDiag *= C5x5[i][i];
        System.out.println("9) Произведение положительных главной диагонали: " + prodDiag);

        // 10. D[7][7] среднее главной диагонали
        int[][] D7x7 = randomIntMatrix(7, 7, -10, 10);
        double sumDiag = 0;
        for (int i = 0; i < 7; i++)
            sumDiag += D7x7[i][i];
        System.out.println("10) Среднее главной диагонали: " + sumDiag / 7);

        // 11. A(n=25) поменять max и min
        int[] A25 = randomIntArray(25, -50, 50);
        int minIndex = 0, maxIndex = 0;
        for (int i = 1; i < A25.length; i++) {
            if (A25[i] < A25[minIndex]) minIndex = i;
            if (A25[i] > A25[maxIndex]) maxIndex = i;
        }
        int temp = A25[minIndex];
        A25[minIndex] = A25[maxIndex];
        A25[maxIndex] = temp;
        System.out.println("11) После обмена min и max: " + Arrays.toString(A25));

        // 12. B(n=25) сортировка
        int[] B25 = randomIntArray(25, -50, 50);
        Arrays.sort(B25);
        System.out.println("12) Отсортированный B[25]: " + Arrays.toString(B25));

        // 13. C(n=20) среднее значение
        int[] C20 = randomIntArray(20, -20, 20);
        double avgC20 = Arrays.stream(C20).average().orElse(0);
        System.out.println("13) Среднее C[20]: " + avgC20);

        // 14. D(n=30) сумма чётных и нечётных
        int[] D30 = randomIntArray(30, -20, 20);
        int sumEven = 0, sumOdd = 0;
        for (int x : D30) {
            if (x % 2 == 0) sumEven += x;
            else sumOdd += x;
        }
        System.out.println("14) Сумма чётных: " + sumEven + ", нечётных: " + sumOdd);

        // 15. Таблица 3×5 случайных чисел < 10
        System.out.println("15) Таблица 3x5:");
        int[][] table = randomIntMatrix(3, 5, 0, 9);
        for (int[] row : table)
            System.out.println(Arrays.toString(row));

        // 16. maxX()
        System.out.println("16) Максимальный элемент массива D30: " + maxX(D30));

        // 17. Строки
        String s1 = "Hello ";
        String s2 = "World";
        String s3 = "Java";
        String s4 = "test";
        String s5 = "test";

        if (s4.equals(s5))
            System.out.println("17) Результат: " + s1 + s2);
        else
            System.out.println("17) Результат: " + s1 + s3);
    }

    static int maxX(int[] arr) {
        int max = arr[0];
        for (int x : arr)
            if (x > max) max = x;
        return max;
    }

    static int[] randomIntArray(int size, int min, int max) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = rand.nextInt(max - min + 1) + min;
        return arr;
    }

    static double[] randomDoubleArray(int size, double min, double max) {
        double[] arr = new double[size];
        for (int i = 0; i < size; i++)
            arr[i] = min + (max - min) * rand.nextDouble();
        return arr;
    }

    static int[][] randomIntMatrix(int rows, int cols, int min, int max) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(max - min + 1) + min;
        return matrix;
    }
}