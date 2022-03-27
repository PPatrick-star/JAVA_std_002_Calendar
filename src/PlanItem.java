import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {
    public Date planDate;
    public String detail;
    public String peoples = "";

    public static Date getSearchDateFromString (String searchDate) {
        Date searchDate10 = null;

        try {
            searchDate10= new SimpleDateFormat("yyyy-MM-dd").parse(searchDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return searchDate10;
    }

    public PlanItem(String date, String detail) {
        this.planDate = getSearchDateFromString(date);
        this.detail = detail;

    }
    public void joinPeople (String name) {
        peoples += name + ",";
    }
    public Date getPlanDate() {
        return planDate;
    }

    public String saveString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = formatter.format(planDate);
        return stringDate + "," + "\"" + detail + "\"" + "\n";
    }
}
