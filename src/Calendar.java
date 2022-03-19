import java.util.Scanner;

public class Calendar {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calendar cal = new Calendar();
        String PROMPT = "cal > ";
        int month, repeat;

        System.out.println("반복 횟수 입력");
        repeat = sc.nextInt();

        for (int i = 0; i < repeat; i++) {

            System.out.println("보고싶은 월을 입력하세요");
            month = sc.nextInt();

            if (1 <= month && 12 >= month) {
                System.out.print(PROMPT);
                System.out.printf("%d 월의 일수는 %d 입니다 \n", month, cal.getMonthDate(month));
            } else {
                System.out.println("다시 입력해주세요");
            }
        }
        sc.close();
        System.out.println("프로그램 종료");
    }

    private final int[] MONTH_DAYS_LIST = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int getMonthDate(int month) {
        return MONTH_DAYS_LIST[month-1];
    }
}
