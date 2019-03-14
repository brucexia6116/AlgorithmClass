
import java.util.Scanner;
public class test08 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str=in.nextLine();
        String [] list = str.split(" ");
        int len = list.length;
        int[] d = new int[len];
        for(int i=0;i<len;i++) {
            d[i]=Integer.parseInt(list[i]);
        }
        String str1=in.nextLine();
        String [] list1 = str1.split(" ");
        int len1 = list1.length;
        int[] d1 = new int[len1];
        for(int i=0;i<len1;i++) {
            d1[i]=Integer.parseInt(list1[i]);
        }
        int count=0;
        for(int i=0;i<len;i++){
            for(int j=0;j<len1;j++){
                if(d[i]<=d1[j]){
                    count+=1;
                    d1[j]=0;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
