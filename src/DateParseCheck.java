import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Locale;
import java.util.TimeZone;

public class DateParseCheck {
    public static void main(String[] args) {


            Instant initDate = null;
            try {
                    DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.ENGLISH);
                    dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
                    initDate = dateFormat.parse("23 Sep 2025 12:20").toInstant();
                System.out.println(initDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

    }
}
