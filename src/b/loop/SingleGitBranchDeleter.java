package b.loop;

import e.decide.BranchDeleteDecider;
import util.DeleteUtil;
import util.ReaderUtil;

import java.io.BufferedReader;

public class SingleGitBranchDeleter {
  public SingleGitBranchDeleter(String branchName, String deleteUpToThisDate) {
    if (new BranchDeleteDecider().branchIsDeletablyOld(branchName, deleteUpToThisDate)) deleteLocalBranch(branchName);
  }

  public void deleteLocalBranch(String branchName) {
    Process deleteProcess = DeleteUtil.getDeleteProcess(branchName);
    BufferedReader reader = ReaderUtil.getProcessReader(deleteProcess);
    printDeletionConsoleOutput(reader);
  }

  private void printDeletionConsoleOutput(BufferedReader reader) {
    ReaderUtil.printReader(reader);
  }
}
