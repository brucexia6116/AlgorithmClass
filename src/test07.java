import java.util.Scanner;
public class test07 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[] d = new int[m];
        for (int i = 0; i < d.length; i++) {
            d[i] = in.nextInt();
        }
        int n=in.nextInt();
        int index=-1;
        for(int i=0;i<d.length-1;i++){
            if(n==d[i]){
                index=i;
            }
        }
        System.out.println(index);
    }
}
