
import java.util.Scanner;

public class test {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] d=new int[n];
        for (int i=0;i<d.length;i++){
            d[i]=in.nextInt();
        }
        for(int j=0;j<d.length;j++){
            for(int k=0;k<d.length;k++){
                if(d[j]>d[k]){
                    int temp=d[j];
                    d[j]=d[k];
                    d[k]=temp;
                }
            }
        }
        if(d.length%2==0){
//            System.out.println(d[d.length/2]);
//            System.out.println(d[(d.length/2)-1]);
            System.out.println((float)(d[d.length/2]+d[(d.length/2)-1])/2);
        }else {
            System.out.println(d[d.length/2]);
        }
    }
}
