import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

    public static void main(String[] args) {
        Prompt p = new Prompt();
        p.runPrompt();

    }

    public void cmdCal(Scanner s, Calendar c) {

        int month, year;

        System.out.println("보고싶은 연도를 입력하세요");
        System.out.print("YEAR > ");
        year = s.nextInt();

        System.out.println("보고싶은 월을 입력하세요");
        System.out.print("MONTH > ");
        month = s.nextInt();

        if (1 <= month && 12 >= month) {
            c.printCalendar(year, month);

        } else {
            System.out.println("다시 입력해주세요");
        }
    }


    public void printMenu() {
        System.out.println("======================\n" +
                "메뉴를 입력하세요\n" +
                "1.일정등록\n" +
                "2.일정검색\n" +
                "3.달력보기\n" +
                "h.도움말\n" +
                "q.종료\n");
    }

    public void runPrompt() {

        Scanner sc = new Scanner(System.in);
        Calendar cal = new Calendar();
        String cmd;

        printMenu();

        boolean isLoop = true;
        while (isLoop) {
            System.out.println("명령 : 1, 2, 3, h, q");
            cmd = sc.next();

            switch (cmd) {
                case "1":
                    cmdRegister(sc, cal);
                    break;
                case "2":
                    cmdSearch(sc, cal);
                    break;
                case "3":
                    cmdCal(sc, cal);
                    break;
                case "h":
                    cmdHelp(sc, cal);
                    break;
                case "q":
                    isLoop = false;
                    break;
            }

        }

        sc.close();
        System.out.println("프로그램 종료");

    }

    private void cmdHelp(Scanner sc, Calendar cal) {
    }

    private void cmdSearch(Scanner sc, Calendar cal) {
        System.out.println("[일정 검색]");
        System.out.println("날짜를 입력해주세요 (yyy-MM-dd)");
        String searchDate = sc.next();

        String searchPlanText = null;
        try {
            searchPlanText = cal.searchPlan(searchDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(searchPlanText);

    }

    private void cmdRegister(Scanner sc, Calendar cal) {
        System.out.println("[새 일정 등록]");
        System.out.println("날짜를 입력해주세요 (yyy-MM-dd)");
        String registerDate = sc.next();
        String planText;
        StringBuilder text = new StringBuilder();
        System.out.println("일정을 입력해주세요 (일정 끝에 마침표로 끝내주세요");
        do {
            planText = sc.nextLine();
            text.append(planText).append(" ");
        } while (!planText.endsWith("."));

        try {
            cal.registerPlan(registerDate, planText);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
