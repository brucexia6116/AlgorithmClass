package second;

import java.util.Arrays;

public class work5 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = new int[]{11, 9, 7, 5, 3, 1, 12, 10, 8, 6, 4, 2};
        System.out.println("待排序数组：" + Arrays.toString(a));
        int[] tmp = new int[a.length];
        mergesort(a, 0, a.length - 1, tmp);
    }

    private static void mergearray(int[] array, int start, int middle, int end, int[] tmp) {
        int first = start;
        int second = middle + 1;
        int index = start;
        while ((first <= middle) && (second <= end)) {
            if (array[first] >= array[second])
                tmp[index++] = array[second++];
            else
                tmp[index++] = array[first++];
        }
        while (first <= middle)
            tmp[index++] = array[first++];
        while (second <= end)
            tmp[index++] = array[second++];
        for (first = start; first <= end; first++)
            array[first] = tmp[first];
        System.out.println("merge is " + Arrays.toString(array));
    }

    public static void mergesort(int[] array, int start, int end, int[] tmp) {
        if (start >= end)
            return;
        int middle = ((end + start) >> 1);
        mergesort(array, start, middle, tmp);// 递归划分左边的数组
        mergesort(array, middle + 1, end, tmp);// 递归划分右边的数组
        mergearray(array, start, middle, end, tmp);// 对有序的两个数组进行合并成一个有序的数组
    }

}
