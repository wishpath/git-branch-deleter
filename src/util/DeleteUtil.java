package util;

import java.io.IOException;

public class DeleteUtil {
  public static Process getDeleteProcess(String branchName) {
    try {
      return Runtime.getRuntime().exec("git branch -D " + branchName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
