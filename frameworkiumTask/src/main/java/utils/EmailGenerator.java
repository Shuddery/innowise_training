package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmailGenerator {

    public static String generateEmail() {
        Date dateNow = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMHHmmssS");
        return "automation" + dateFormat.format(dateNow) + "@mailinator.com";
    }
}