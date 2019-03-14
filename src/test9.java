import javax.xml.transform.Templates;
import java.util.Scanner;

public class test9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b=in.nextInt();
        int c=in.nextInt();
        if(a>b){
            if(b>c);
            else if(a<c){
                int temp=a;
                a=c;
                c= temp;

            }
        }
    }
}
