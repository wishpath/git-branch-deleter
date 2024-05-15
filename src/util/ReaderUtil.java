package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderUtil {
  public static BufferedReader getBranchNamesReader() {
    Process process = null;
    try {
      process = Runtime.getRuntime().exec("git branch");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return new BufferedReader(new InputStreamReader(process.getInputStream()));
  }

  public static String readLine(BufferedReader reader) {
    try {
      return reader.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static BufferedReader getProcessReader(Process deleteProcess) {
    return new BufferedReader(new InputStreamReader(deleteProcess.getInputStream()));
  }

  public static void printReader(BufferedReader reader) {
    String line;
    while (true) {
      try { if (!((line = reader.readLine()) != null)) break;}
      catch (IOException e) {throw new RuntimeException(e);}
      System.out.println(line); // Output of the git branch -D command
    }
  }
}
