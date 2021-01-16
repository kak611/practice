class DeletionDistance {
	  static int deletionDistance(String str1, String str2) {
    int len1 = str1.length();
    int len2 = str2.length();
    
    int[][] dp = new int[len1 + 1][len2 + 1];
    
    // if str2 is empty, delete all chars
    for (int i = 1; i <= len1; i++) {
      dp[i][0] = dp[i-1][0] + 1;
    }
    
    // if str1 is empty, delete all chars
    for (int j = 1; j <= len2; j++) {
      dp[0][j] = dp[0][j-1] + 1;
    }
    
    for (int i = 1; i <= len1; i++) {
      for (int j = 1; j <= len2; j++) {
        // if chars matches then just carry fwd last min value
        if (str1.charAt(i-1) == str2.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1];
        } else {
          // if mismatch, then 1 + min of row-1 and col-1
          dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
        }
      }
    }
    
    return dp[len1][len2];
  }

  public static void main(String[] args) {
    int result = deletionDistance("ab", "ba");
    System.out.println("Result: " + result);
  }

}