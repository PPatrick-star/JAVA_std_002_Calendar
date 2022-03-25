import java.util.Scanner;

public class Prompt {

    /*
    * @param week : 요일명
    * @return 0~6 sunday : 0 , saturday : 6
    * */
    public int parseDay(String weekDay) {
        if (weekDay.equals("SU")) return 0;
        else if(weekDay.equals("MO")) return 1;
        else if(weekDay.equals("TU")) return 2;
        else if(weekDay.equals("WE")) return 3;
        else if(weekDay.equals("TH")) return 4;
        else if(weekDay.equals("FR")) return 5;
        else if(weekDay.equals("SA")) return 6;
        else return 0;

    }

    public void runPrompt() {
        Scanner sc = new Scanner(System.in);
        Calendar cal = new Calendar();
        int month, year;
        String weekday = null;

        while (true){

            System.out.println("보고싶은 연도를 입력하세요");
            System.out.print("YEAR > ");
            year = sc.nextInt();
            if (year == -1) {
                break;
            }
            System.out.println("보고싶은 월을 입력하세요");
            System.out.print("MONTH > ");
            month = sc.nextInt();
            System.out.println("해당 월의 첫째날의 요일을 입력하세요");
            System.out.println("ex) SU MO TU WE TH FR SA");
            System.out.print("DATE > ");
            weekday = sc.next();

            int parseWeekDay = parseDay(weekday);


            if (1 <= month && 12 >= month) {
                cal.printCalendar(year, month, parseWeekDay);

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
