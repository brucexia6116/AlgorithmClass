package greedy;

public class Greedy {
    public static int greedySelector(int[] s, int[] f, boolean[] a) {

        int n = s.length - 1;
        //安排第一个活动，标记为true
        a[1] = true;
        int j = 1;
        int count = 1;

        for (int i = 2; i <= n; i++) {
            //检验当前最早结束的活动的开始时间是否晚于前一个活动的结束结束时间
            if (s[i] >= f[j]) {
                //如果晚于，则表示两个活动相互兼容，将活动标记为true
                a[i] = true;
                j = i;
                //记已经安排活动的个数
                count++;
            } else {
                //与已安排活动不兼容，标记此活动未安排
                a[i] = false;
            }

        }
        return count;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //初始化数据s数组记录活动开始时间；f数组记录活动结束时间
        int[] s = {-1, 2, 2, 3, 4, 6, 7, 9, 10, 13};
        int[] f = {-1, 3, 4, 5, 7, 8, 11, 12, 15, 17};
        //声明一个boolean型数组
        boolean[] a = new boolean[s.length];

        int result = greedySelector(s, f, a);
        System.out.println("Result is: " + result);
        for (int i = 1; i <= s.length - 1; i++) {
            if (a[i]) {
                System.out.println("第" + i + "活动被选中，其开始时间为：" + s[i] + "，结束时间为：" + f[i]);
            }
        }

    }
}
