package second;
import java.util.Scanner;


public class work4 {
    // 定义棋盘的大小：2^k，需要的骨牌数是：(4^k-1)/3
    private static int BOARD_SIZE = 8;
    // 定义一个二维数组用来模拟棋盘
    private static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    // 定义一个全局变量，用来记录骨牌的编号
    private static int tile = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("棋盘的大小为：" + BOARD_SIZE);
        System.out.println("请输入特殊方格所在的行号：");
        int dr = scanner.nextInt();
        System.out.println("请输入特殊方格所在的列号：");
        int dc = scanner.nextInt();
        scanner.close();
        // 行号和列号与二位数组的下标相差 1
        chessBoard(0, 0, dr - 1, dc - 1, BOARD_SIZE);
        System.out.println("特殊方块在第 " + dr + " 行第 " + dc + "列，覆盖后的棋盘：");
        // 输出棋盘
        printBoard();
    }

    /**
     *
     * @param tr：棋盘左上角方格的行号
     * @param tc:棋盘左上角方格的列号
     * @param dr：特殊方格所在的行号
     * @param dc：特殊方格所在的列号
     * @param size：当前棋盘的大小
     */
    private static void chessBoard(int tr, int tc, int dr, int dc, int size) {
        /* 1、当前棋盘的大小是 1 就返回 */
        if (size == 1) {
            return;
        }
        int t = tile++;
        // 分割棋盘，棋盘大小减半
        int s = size / 2;

        /* 2、覆盖左上角子棋盘 */
        if (dr < tr + s && dc < tc + s) {
            // 特殊方格在此棋盘中
            chessBoard(tr, tc, dr, dc, s);
        } else {
            // 特殊方格不在此棋盘中，用 t 号骨牌覆盖右下角
            board[tr + s - 1][tc + s - 1] = t;
            // 覆盖其余方格
            chessBoard(tr, tc, tr + s - 1, tc + s - 1, s);
        }

        /* 3、覆盖右上角子棋盘 */
        if (dr < tr + s && dc >= tc + s) {
            // 特殊方格在此棋盘中
            chessBoard(tr, tc + s, dr, dc, s);
        } else {
            // 特殊方格不在此棋盘中，用 t 号骨牌覆盖左下角
            board[tr + s - 1][tc + s] = t;
            // 覆盖其余方格
            chessBoard(tr, tc + s, tr + s - 1, tc + s, s);
        }

        /* 4、覆盖左下角子棋盘 */
        if (dr >= tr + s && dc < tc + s) {
            // 特殊方格在此棋盘中
            chessBoard(tr + s, tc, dr, dc, s);
        } else {
            // 特殊方格不在此棋盘中，用 t 号骨牌覆盖右上角
            board[tr + s][tc + s - 1] = t;
            // 覆盖其余方格
            chessBoard(tr + s, tc, tr + s, tc + s - 1, s);
        }

        /* 5、覆盖左下角子棋盘 */
        if (dr >= tr + s && dc >= tc + s) {
            // 特殊方格在此棋盘中
            chessBoard(tr + s, tc + s, dr, dc, s);
        } else {
            // 特殊方格不在此棋盘中，用 t 号骨牌覆盖右上角
            board[tr + s][tc + s] = t;
            // 覆盖其余方格
            chessBoard(tr + s, tc + s, tr + s, tc + s, s);
        }
    }

    // 输出棋盘
    private static void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }
}
