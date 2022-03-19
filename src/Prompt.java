import java.util.Scanner;

public class Prompt {

    private final static String PROMPT = "cal> ";

    public void runPrompt() {
        Scanner sc = new Scanner(System.in);
        Calendar cal = new Calendar();
        String PROMPT = "cal > ";
        int month, year;

        while (true){

            System.out.println("보고싶은 연도를 입력하세요");
            System.out.print("YEAR > ");
            year = sc.nextInt();
            System.out.println("보고싶은 월을 입력하세요");
            System.out.print("MONTH > ");
            month = sc.nextInt();

            if (month == -1) {
                break;
            }

            if (1 <= month && 12 >= month) {
                cal.printCalendar(year, month);

            } else {
                System.out.println("다시 입력해주세요");
            }
        }
        sc.close();
        System.out.println("프로그램 종료");

    }

    public static void main(String[] args) {
        Prompt p = new Prompt();
        p.runPrompt();

    }
}
