public class Calendar {

    private final int[] DAYS_LIST = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final int[] LEAP_YEAR_DAYS_LIST = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public boolean isLeapYear(int year){
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
            return true;
        else
            return false;
    }

    public int getMonthMaxDay(int year, int month) {
        if (isLeapYear(year)){
            return LEAP_YEAR_DAYS_LIST[month-1];
        } else {
            return DAYS_LIST[month-1];
        }

    }

    public void printCalendar(int year,int month, int weekDay) {
        System.out.println("---------------------");
        System.out.printf("   <<%4d년 %2d월>> \n", year, month);

        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("---------------------");

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
}
