package Microsoft;

public class Wildcard_Matching {
    
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        int sIdx = 0, pIdx = 0;
        int starIdx = -1, sTmpIdx = -1;

        while (sIdx < sLen) {
            System.out.println("sChar: "+s.charAt(sIdx));
            System.out.println("pChar: "+p.charAt(pIdx));
          // If the pattern caracter = string character
          // or pattern character = '?'
          if (pIdx < pLen && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))){
            ++sIdx;
            ++pIdx;
          }
          // If pattern character = '*'
          else if (pIdx < pLen && p.charAt(pIdx) == '*') {
            // Check the situation
            // when '*' matches no characters
            starIdx = pIdx;
            sTmpIdx = sIdx;
            ++pIdx;
          }
          // If pattern character != string character
          // or pattern is used up
          // and there was no '*' character in pattern 
          else if (starIdx == -1) {
            return false;
          }
          // If pattern character != string character
          // or pattern is used up
          // and there was '*' character in pattern before
          else {
            // Backtrack: check the situation
            // when '*' matches one more character
            pIdx = starIdx + 1;
            sIdx = sTmpIdx + 1;
            sTmpIdx = sIdx;
          }
        }

        // The remaining characters in the pattern should all be '*' characters
        for(int i = pIdx; i < pLen; i++)
          if (p.charAt(i) != '*') return false;
        return true;
      }

    public static void main(String[] args) {
        Wildcard_Matching obj = new Wildcard_Matching();
        String s = "acdcc";
        String p = "a*cb";
        if(obj.isMatch(s, p)) {
            System.out.println("match");
        }
        else {
            System.out.println("No match");
        }
    }

}
