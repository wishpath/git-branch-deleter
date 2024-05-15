package b.loop;

import a.get.GitBranchNamesGetter;
import d.validate.DateValidator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MultipleGitBranchDeleter {

  private List<String> branchNames = new GitBranchNamesGetter().getBranchNames();

  public void deleteOldBranches(int daysToKeepBranches) {
    String deleteUpToThisDate = LocalDate.now().minusDays(daysToKeepBranches).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    deleteOldBranches(deleteUpToThisDate);
  }
  public void deleteOldBranches(String deleteUpToThisDate) {
    if (!DateValidator.isValidDateAndPrint(deleteUpToThisDate)) return;
    for (String branchName : branchNames) new SingleGitBranchDeleter(branchName, deleteUpToThisDate);
  }
}
