package MatrixMultip;

public class MatixTest {
    public static void main(String agrs[]) {
        int[] p = {10, 100, 5, 50, 30, 20, 60, 45, 50};
        int n = p.length;
        int[][] m = new int[n][n];
        int[][] s = new int[n][n];
        Matrix m1 = new Matrix();
        m1.matrixChain(p, m, s);
        System.out.println("该矩阵阶乘子问题数乘的次数:");
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m.length; j++) {
                if (i > j) {
                    System.out.print("----" + "\t");
                } else {
                    System.out.print(m[i][j] + "\t");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("该矩阵阶乘子问题数乘的次数:");
        for (int i = 1; i < s.length; i++) {
            for (int j = 1; j < s.length; j++) {
                if (i > j) {
                    System.out.print("-" + "\t");
                } else {
                    System.out.print(s[i][j] + "\t");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("该矩阵阶乘的最优解:");
        m1.TraceBack(s, 1, n - 1);
        m1.OptimalParens(s, 1, n - 1);
    }

}
