package second;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;


class Tools {

    public static final Integer INDEX = 1;
    public static final Integer LEFT = -2;
    public static final Integer RIGHT = -1;

    /**
     * 随机数生成数组[1:100]
     *
     * @param arr
     * @param n
     */
    public static void randomArr(int arr[], int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100) + 1;
        }
    }

    /**
     * 将数组元素随机排列
     *
     * @param arr
     */
    public static void sort(int arr[]) {

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        int i = 0;
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            arr[i++] = it.next();
        }
    }

    /**
     * 快速排序算法
     *
     * @param p
     * @param r
     */
    public static void qSort(int arr[], int p, int r) {
        if (p < r) {
            int q = partiton(arr, p, r);
            qSort(arr, p, q - 1);
            qSort(arr, q + 1, r);
        }
    }

    private static int partiton(int arr[], int p, int r) {
        int i = p;
        int j = r + 1;
        int x = arr[p];
        while (true) {
            while (arr[++i] < x && i < r)
                ;
            while (arr[--j] > x)
                ;
            if (i >= j) {
                break;
            }
            Tools.swap(arr, i, j);
        }

        arr[p] = arr[j];
        arr[j] = x;

        return j;
    }

    /**
     * 交换数据
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 二分查找算法: 当搜索元素x不存在时，返回小于x的最大元素位置i和大于x的最小元素位置j.
     * 当搜索元素在数组中时，i和j相同，均为x在数组中的位置。
     *
     * @param arr
     */

    public static Map<Integer, Integer> binarySearch(int arr[], int x) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;

            if (x == arr[middle]) {
                map.put(INDEX, middle);
                return map;
            } else if (x > arr[middle]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        /**
         * 循环退出条件：start > end 没有找到x，返回小于x的最大元素位置LEFT和大于x的最小元素位置RIGHT
         */
        map.put(LEFT, end);
        map.put(RIGHT, start);
        return map;
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void syso(String msg, int arr[]) {
        System.out.println(msg);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

public class work3 {
    public static void main(String[] args) {
        int arr[] = new int[10];

        //随机生成数组
        Tools.randomArr(arr, arr.length);
        Tools.syso("随机生成的数组：", arr);

        System.out.println();
        //将数组随机排列
        Tools.sort(arr);
        Tools.syso("随机排列后的数组：", arr);

        //排序数组
        Tools.qSort(arr, 0, arr.length - 1);
        System.out.println();
        Tools.syso("排序后的数组：", arr);

        System.out.println();
        //查找元素x
        System.out.println("请输入要查找的数据：");
        int x = new Scanner(System.in).nextInt();

        Map<Integer, Integer> map = Tools.binarySearch(arr, x);

        if (map.size() > 1) {
            System.out.println("没有找到！！！");
            int left = map.get(Tools.LEFT);
            int right = map.get(Tools.RIGHT);
            System.out.println("小于" + x + "的最大元素位置：" + (left + 1) + "\n大于" + x + "的最小元素位置：" + (right + 1));
        } else
            System.out.println("您所查找元素" + x + "的位置是：" + map.get(Tools.INDEX));
    }
}


