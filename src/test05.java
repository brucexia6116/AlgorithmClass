import java.util.Scanner;

public class test05 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        int M=in.nextInt();
        int[] d=new int[2*M];
        for(int i=0;i<d.length;i++){
            d[i]=in.nextInt();
//            System.out.print(d[i]+" ");
        }
        int count=0;
        for(int i=0;i<M;i++){
            int count1=0;
            for(int j=1;j<M-i;j++){
                if(d[i+1]==d[2*j]){
                    count1+=1;
                }
            }
            if(count1==N-1){
                count+=1;
            }
        }
        System.out.println(count);
    }
}
