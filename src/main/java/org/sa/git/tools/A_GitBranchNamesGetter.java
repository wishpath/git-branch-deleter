package org.sa.git.tools;

import org.sa.util.CmdUtil;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class A_GitBranchNamesGetter {
  private List<String> branchNames = new ArrayList<>();
  private BufferedReader answerReader = CmdUtil.executeAndGetAnswerReader("git branch");
  private String branchName;


  public A_GitBranchNamesGetter() {
    while ((branchName = CmdUtil.readAnswerLine(answerReader)) != null) addToList(branchName);
  }

  private void addToList(String branchName) {
    branchName = branchName.trim();
    if (B_DateCalculator.isValidDate(branchName)) branchNames.add(branchName);
  }

  public List<String> getBranchNames() {
    return branchNames;
  }
}
