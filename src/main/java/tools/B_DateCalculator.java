package tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class B_DateCalculator {

  private String deleteUpToThisDate;

  public B_DateCalculator(int daysToKeepBranches) {
    deleteUpToThisDate = LocalDate.now().minusDays(daysToKeepBranches).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    if (!isValidDate(deleteUpToThisDate)) throw new RuntimeException("DATE NOT VALID: " + deleteUpToThisDate);
  }

  public static boolean isValidDate(String date) {
    if (date == null || date.length() != 8) return false;
    try { LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE); return true;}
    catch (DateTimeParseException e) {return false;}
  }

  public String getDate() {
    return deleteUpToThisDate;
  }
}
