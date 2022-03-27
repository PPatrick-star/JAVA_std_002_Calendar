import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Calendar {

    private final int[] DAYS_LIST = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final int[] LEAP_YEAR_DAYS_LIST = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String SAVE_FILE = "calendar.dat";
    private final HashMap<Date, PlanItem> planMap;

    public Calendar() {
        planMap = new HashMap<Date, PlanItem>();
        File file = new File(SAVE_FILE);
        if ( !file.exists())
            return ;
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] words = line.split(",");
                String date = words[0];
                String detail = words[1].replaceAll("\"", "");
                PlanItem pi = new PlanItem(date, detail);
                planMap.put(pi.getPlanDate(), pi);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
     * @param : registerDate10 "2022-03-27"
     * @param : plain
     * @throws : ParseException
     * */
    public void registerPlan(String registerDate, String plan) {
        PlanItem pi = new PlanItem(registerDate, plan);
        planMap.put(pi.getPlanDate(), pi);

        File file = new File(SAVE_FILE);
        String item = pi.saveString();
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(item);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public PlanItem searchPlan(String searchDate) {
        Date searchDate10 = PlanItem.getSearchDateFromString(searchDate);
        return planMap.get(searchDate10);
    }

    public boolean isLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
            return true;
        else
            return false;
    }

    public int getMonthMaxDay(int year, int month) {
        if (isLeapYear(year)) {
            return LEAP_YEAR_DAYS_LIST[month];
        } else {
            return DAYS_LIST[month];
        }

    }

    public void printCalendar(int year, int month) {
        System.out.println("---------------------");
        System.out.printf("   <<%4d년 %2d월>> \n", year, month);

        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("---------------------");

        int weekDay = getWeekDay(year, month, 1);

        for (int i = 0; i < weekDay; i++) {
            System.out.print("   ");
        }

        int maxDay = getMonthMaxDay(year, month);
        int countFirstWeekDay = 7 - weekDay;
        int delim = (countFirstWeekDay < 7) ? countFirstWeekDay : 0;

        for (int i = 1; i <= countFirstWeekDay; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        for (int i = countFirstWeekDay + 1; i <= maxDay; i++) {
            System.out.printf("%3d", i);
            if (i % 7 == delim) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private int getWeekDay(int year, int month, int day) {
        int standardYear = 1970;
        final int STANDARD_WEEKDAY = 3;

        int count = 0;

        for (int i = standardYear; i < year; i++) {
            int delta = isLeapYear(i) ? 366 : 365;
            count += delta;
        }

        for (int i = 1; i < month; i++) {
            int delta = getMonthMaxDay(year, i);
            count += delta;
        }

        count += day;

        return (count + STANDARD_WEEKDAY) % 7;

    }

/*    public static void main(String [] args) throws ParseException {
        Calendar c = new Calendar();
        System.out.println(c.getWeekDay(1970, 1, 1) == 3);
        System.out.println(c.getWeekDay(1971, 1, 1) == 4);
        System.out.println(c.getWeekDay(1972, 1, 1) == 5);
        System.out.println(c.getWeekDay(1973, 1, 1) == 0);
        System.out.println(c.getWeekDay(1974, 1, 1) == 1);

        c.registerPlan("2022-03-27", "Watch movie");
        System.out.println(c.searchPlan("2022-03-27").equals("Watch movie"));
    }*/
}
