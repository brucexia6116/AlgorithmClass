package bestTree;

public class bestTree {
    public static void main(String[] args) {
        double[] b = {0, 0.15, 0.1, 0.05, 0.1, 0.2};//n=5,5个关键字的搜素概率，p0=0哨兵 概率p1到pn
        double[] a = {0.05, 0.1, 0.05, 0.05, 0.05, 0.1}; //叶子节点有n+1个，概率从q0到qn
        int n = b.length;
        System.out.println("输出根节点的辅助表");
        int[][] root = Optimal_BST(b, a, n - 1);
        int temp = root.length - 1;
        System.out.println("根：K" + root[1][5]);

        printOptimalBST(root, 1, 5, root[1][5]);
    }

    //计算最优二叉查找树的辅助表
    public static int[][] Optimal_BST(double[] p, double[] q, int n) {
        double[][] e = new double[n + 2][n + 2];//e[i][j]表示包含ki...kj的搜索概率
        double[][] w = new double[n + 2][n + 2];//w[i][j]表示 ki...kj的概率总和
        int[][] root = new int[n + 2][n + 2];

        //初始化叶子节点的值
        for (int i = 1; i <= n + 1; i++) {//叶子节点一共n+1个是从d0到dn
            e[i][i - 1] = q[i - 1];
            w[i][i - 1] = q[i - 1];
        }

        for (int l = 1; l <= n; l++) {//表示从k1到kl有l个关键字参与构造树，1<<l<<n

            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                e[i][j] = Double.MAX_VALUE;
                w[i][j] = w[i][j - 1] + p[j] + q[j];
                for (int r = i; r <= j; r++) {//关键字 ki...kj选r为根
                    double t = e[i][r - 1] + e[r + 1][j] + w[i][j];//代价值
                    if (t < e[i][j]) {
                        e[i][j] = t;
                        root[i][j] = r;
                    }
                }
            }
        }
        System.out.println("root");
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                System.out.print(root[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("输出当前的最小代价" + e[1][n]);
        return root;
    }

    //构建最优二叉搜索树
    public static void printOptimalBST(int[][] root, int i, int j, int r) {
        int rootChild = root[i][j];
        if (rootChild == r) {//
            System.out.println("K" + rootChild + "是根");
            printOptimalBST(root, i, rootChild - 1, rootChild);//构建左子树
            printOptimalBST(root, rootChild + 1, j, rootChild);//构建右子树
            return;
        }
        if (j < i - 1) return;
        else if (j == i - 1) {//只有一个虚拟键di-1
            if (j < r) {
                System.out.println("d" + j + "是K" + r + "的左孩子");
            } else {
                System.out.println("d" + j + "是K" + r + "的右孩子");
            }
            return;
        } else {//内部节点 关键字k
            if (rootChild < r) {//关键字kr的左孩子
                System.out.println("k" + j + "是K" + r + "的左孩子");
            } else {
                System.out.println("k" + j + "是K" + r + "的右孩子");
            }
        }
        printOptimalBST(root, i, rootChild - 1, rootChild);
        printOptimalBST(root, rootChild + 1, j, rootChild);
    }
}
