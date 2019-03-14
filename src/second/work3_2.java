package second;

import java.util.Arrays;
import java.util.Scanner;

public class work3_2 {
    public int Serach(int a[], int x, int left, int right) {
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (a[mid] == x) {
                //flag = 1;
                return mid;
            } else if (a[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 2, 3, 4, 5, 8, 9, 10, 15, 17, 25, 43, 57};
        System.out.println("待搜索数组：" + Arrays.toString(a));
        System.out.println("请输入要查找的数据：");
        int x = new Scanner(System.in).nextInt();
        int k = new work3_2().Serach(a, x, 0, a.length - 1);
        if (a[k] == x) {
            System.out.println("您所查找元素" + x + "的位置是：" + k);
        } else {
            if (a[k] > x) {
                System.out.println("比" + x + "大的最小元素的位置是：" + k);
                if ((k - 1) < 0) {
                    System.out.println("不存在比" + x + "小的元素了！！！");
                } else {
                    System.out.println("比" + x + "小的最大元素的位置是：" + (k - 1));
                }

            } else {
                if ((k + 1) > a.length - 1) {
                    System.out.println("不存在比" + x + "大的元素了！！！");
                } else {
                    System.out.println("比" + x + "大的最小元素的位置是：" + (k + 1));
                }
                System.out.println("比" + x + "小的最大元素的位置是：" + k);
            }
        }

    }
}
