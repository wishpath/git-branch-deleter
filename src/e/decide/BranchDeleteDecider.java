package e.decide;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BranchDeleteDecider {
  public boolean branchIsDeletablyOld(String branchName, String deleteUpToThisDate) {
    LocalDate branchDate = LocalDate.parse(branchName, DateTimeFormatter.BASIC_ISO_DATE);
    LocalDate deleteDate = LocalDate.parse(deleteUpToThisDate, DateTimeFormatter.BASIC_ISO_DATE);
    return branchDate.isBefore(deleteDate);
  }
}
