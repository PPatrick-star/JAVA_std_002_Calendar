public class Calendar {

    private final int[] DAYS_LIST = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final int[] LEAP_YEAR_DAYS_LIST = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public boolean isLeapYear(int year){
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
            return true;
        else
            return false;
    }

    public int getMonthMaxDay(int year, int month) {
        if (isLeapYear(year)){
            return LEAP_YEAR_DAYS_LIST[month];
        } else {
            return DAYS_LIST[month];
        }

    }

    public void printCalendar(int year,int month) {
        System.out.println("---------------------");
        System.out.printf("   <<%4d년 %2d월>> \n", year, month);

        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("---------------------");

        int weekDay = getWeekDay(year, month, 1);

        for (int i = 0; i < weekDay; i++){
            System.out.print("   ");
        }

        int maxDay = getMonthMaxDay(year, month);
        int countFirstWeekDay = 7- weekDay;
        int delim = (countFirstWeekDay < 7) ? countFirstWeekDay : 0;

        for (int i = 1; i <= countFirstWeekDay; i++){
            System.out.printf("%3d", i);
        }
        System.out.println();

        for (int i = countFirstWeekDay+1; i <= maxDay; i++) {
            System.out.printf("%3d", i);
            if(i % 7 == delim) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private int getWeekDay(int year, int month, int day) {
        int standardYear = 1970;
        final int STANDARD_WEEKDAY = 3;

        int count = 0;

        for (int i = standardYear; i < year; i ++) {
            int delta = isLeapYear(i) ? 366 : 365;
            count += delta;
        }

        for (int i = 1; i < month; i ++) {
            int delta = getMonthMaxDay(year, i);
            count += delta;
        }

        count += day;

        return (count + STANDARD_WEEKDAY) % 7;

    }
}
