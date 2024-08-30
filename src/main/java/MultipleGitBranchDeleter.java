import org.sa.util.CmdUtil;
import tools.A_GitBranchNamesGetter;
import tools.B_DateCalculator;
import tools.C_BranchDeleteDecider;

import java.util.List;

public class MultipleGitBranchDeleter {

  private List<String> branchNames = new A_GitBranchNamesGetter().getBranchNames();
  private String deleteUpToThisDate;

  public void deleteOldBranches(int daysToKeepBranches) {
    deleteUpToThisDate = new B_DateCalculator(daysToKeepBranches).getDate();
    branchNames.forEach(this::deleteBranch);
  }

  private void deleteBranch(String branchName) {
    boolean shouldDelete = new C_BranchDeleteDecider().branchIsDeletablyOld(branchName, deleteUpToThisDate);
    if (!shouldDelete) return;
    CmdUtil.executeAndReadAnswer("git branch -D " + branchName);
  }
}
