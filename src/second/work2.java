package second;


import java.util.Arrays;

/**
 * 三者取中法完成快速排序,算法思想：
 * 分别取数组首尾及最中间三个元素，并将其按有小到大的顺序依次调换位置，然后以中间位置元素为基准并将其与第一个元素交换位置，
 * 然后按快速排序法进行排序，将大于基准的元素置于其右边，小于基准的元素置于其左边
 */
class QuickSort3 {
    private int[] data;

    QuickSort3(int[] data) {
        this.data = data;
    }

    public void startSort(int low, int high) {
        if (low >= high) return;
        medianOfThree(low, high);
        int partition = Partition(low, high);//以第一个元素为基准元素，大于基准元素的在右边
        //小于基准元素的在左边
        startSort(low, partition - 1);
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
            while (begin < end && data[end] >= key)
                end--;
            data[begin] = data[end];//第一步
            while (begin < end && data[begin] <= key)
                begin++;
            data[end] = data[begin];//第二步
        }
        data[begin] = key;//基准元素居中，第三步
        return begin;
    }

    public void display() {
        System.out.print("[");
        for (int i = 0; i < data.length; i++)
            System.out.print(data[i] + ", ");
        System.out.println("]");
    }

    public void Swap(int n1, int n2) {
        int temp = data[n1];
        data[n1] = data[n2];
        data[n2] = temp;
    }

    /*
     * 三数取中，取首、尾、中，三个位置的元素依次比较大小，按从小到大排序，并将中间元素与第一个元素交换位置（选取中间元素为基准）
     * */
    public void medianOfThree(int begin, int end) {
        int mid = (end - begin) / 2 + begin;
        if (data[mid] > data[end]) {
            Swap(mid, end);
        }
        if (data[begin] > data[end]) {
            Swap(begin, end);
        }
        if (data[mid] > data[begin]) {
            Swap(mid, begin);
        }
    }
}

public class work2 {
    public static void main(String[] args) {
        int[] num = {4, 13, 6, 16, 8, 3, 18, 1, 10, 11, 19, 25, 15, 9, 14, 12, 5, 7, 2};
        System.out.println("待排序数组：" + Arrays.toString(num));
        QuickSort3 q = new QuickSort3(num);
        long start = System.nanoTime();
        q.startSort(0, num.length - 1);
        System.out.print("三者取中法排序后数组：");
        q.display();
        System.out.println("耗时：" + (System.nanoTime()-start)+"纳秒");
    }
}
