import java.util.Scanner;

public class test03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[] d = new int[m];
        for (int i = 0; i < d.length; i++) {
            d[i] = in.nextInt();
        }
        int count=0;
        for(int j=0,k=d.length-1;j<d.length&&k>j;j++,k--){
            if(d[j]==1&&d[k]==0){
                int temp=d[j];
                d[j]=d[k];
                d[k]=temp;
                count+=1;
            }else if(d[j]==1&&d[k]==1){
                k--;
            }else if(d[j]==0){
                j++;
            }
        }
        System.out.println(count);
    }
}
