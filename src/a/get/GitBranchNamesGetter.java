package a.get;

import d.validate.DateValidator;
import util.ReaderUtil;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class GitBranchNamesGetter {
  private List<String> branchNames = new ArrayList<>();
  private BufferedReader reader = ReaderUtil.getBranchNamesReader();
  private String branchName;


  public GitBranchNamesGetter() {
    while ((branchName = ReaderUtil.readLine(reader)) != null) addToList(branchName);
  }

  private void addToList(String branchName) {
    branchName = branchName.trim();
    if (DateValidator.isValidDate(branchName)) branchNames.add(branchName);
  }

  public List<String> getBranchNames() {
    return branchNames;
  }
}
