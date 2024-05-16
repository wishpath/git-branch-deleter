package d.validate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator {
  public static boolean isValidDateAndPrint(String date) {
    if (!isValidDate(date)) {
      System.out.println("Provide valid date please! Was not valid: " + date);
      return false;
    }
    return true;
  }
  public static boolean isValidDate(String date) {
    if (date == null || date.length() != 8) return false;
    try { LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE); return true;}
    catch (DateTimeParseException e) {return false;}
  }
}
