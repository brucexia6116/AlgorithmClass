package second;

import java.util.Arrays;

/**
 * 固定取第一个元素为枢纽进行快速排序
 */

class QuickSort {
    private int[] data;

    QuickSort(int[] data) {
        this.data = data;
    }

    public void startSort(int low, int high) {
        if (low >= high) return;
        int partition = Partition(low, high);//以第一个元素为基准元素，大于基准元素的在右边
        //小于基准元素的在左边
        startSort(low, partition - 1);//分治法的体现
        startSort(partition + 1, high);
    }

    /*
     * 将数组分成两块，返回基准元素在数组中的位置
     * @param arr 待排序数组
     * @param low,high规定数组中的待排序数据块位置
     * */
    public int Partition(int low, int high) {
        int begin = low;
        int end = high;
        int key = data[low];//取该数组块的第一个元素作为基准元素
        while (begin < end) {
            while (begin < end && data[end] >= key) {
                end--;
            }
            data[begin] = data[end];//第一处，从后开始找到第一个小于key的元素，将这个元素放到begin位置（key已经复制了该位置原来的值，不用担心覆盖问题）
            while (begin < end && data[begin] <= key) {
                begin++;
            }
            data[end] = data[begin];//第二处，从前开始往后找到第一个大于key的元素，注意看好begin和end 的大小，将这个元素放到end位置
        }
        data[begin] = key;//基准元素居中，第三处，将复制的key即原先的data[begin]放到中间位置
        return begin;
    }

    public void display() {
        System.out.print("[");
        for (int i = 0; i < data.length; i++)
        {
            System.out.print(data[i] + ", ");
        }
        System.out.println("]");
    }

}

public class work2_2 {
    public static void main(String[] args) {
        int[] num = {4, 13, 6, 16, 8, 3, 18, 1, 10, 11, 19, 25, 15, 9, 14, 12, 5, 7, 2};
        System.out.println("待排序数组：" + Arrays.toString(num));
        QuickSort q = new QuickSort(num);
        long start = System.nanoTime();
        q.startSort(0, num.length - 1);
        System.out.print("取第一个元素为枢纽快速排序后：" );
        q.display();
        System.out.println("耗时：" + (System.nanoTime()-start)+"纳秒");
    }
}
