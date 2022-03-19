import java.util.Scanner;

public class Sum {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int first, second;

        first = sc.nextInt();
        second = sc.nextInt();

        sc.close();

        System.out.printf("%d 와 %d 의 합은 %d 입니다" ,first , second, first + second);

    }
}
