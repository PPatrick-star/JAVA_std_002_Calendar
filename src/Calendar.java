import java.util.Scanner;

public class Calendar {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int month;

        System.out.println("보고싶은 월을 입력하세요");
        month = sc.nextInt();
        if (1<= month && 12 >= month){
            sc.close();

            int[] dateList = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            System.out.printf("%d 월의 일수는 %d 입니다", month, dateList[month - 1]);
        } else {
            System.out.println("다시 입력해주세요");
        }
    }
}
