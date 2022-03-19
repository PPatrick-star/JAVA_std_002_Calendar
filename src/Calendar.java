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

    public void printCalendar(int year,int month) {
        System.out.printf("   <<%4d년 %2d월>> \n", year, month);

        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("---------------------");


        int maxDay = getMonthMaxDay(year, month);
        for (int i = 1; i <= maxDay; i++) {
            System.out.printf("%3d", i);
            if(i % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
