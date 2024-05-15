import b.loop.MultipleGitBranchDeleter;

public class Main {
  public static void main(String[] args) {
    new MultipleGitBranchDeleter().deleteOldBranches(60);
  }
}