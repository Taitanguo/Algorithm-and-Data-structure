public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        //special case
        if(s == null || s.length() == 0){
            return true;
        }


        int start = 0;
        int end = s.length() - 1 ;
        while(start < end){
    //update every start step
            while(start < s.length() && !isvalid(s.charAt(start))){
                start++;
            }

            if(start == s.length()){
                return true;  // if this string full of special character, this is a panlindrome
            }

            while(end >= 0 && !isvalid(s.charAt(end))){
                end--;
            }

    // main function
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                break;
            }else{
                start++;
                end--;
            }
        }
        return end <= start;
    }
    //check whether the character is a valid one
    private boolean isvalid(char c){
        if(Character.isLetter(c) || Character.isDigit(c)){
            return true;
        }
        return false;
    }
}

//recursive way
public static boolean isPalindrome(String word) {
  //Strip out non-alphanumeric characters from string
  String cleanWord = word.replaceAll("[^a-zA-Z0-9]","");
  //Check for palindrome quality recursively
  return checkPalindrome(cleanWord);
}
private static boolean checkPalindrome(String word) {
  if(word.length() < 2) { return true;  }
  char first  = word.charAt(0);
  char last   = word.charAt(word.length()-1);
  if(  first != last  ) { return false; }
  else { return checkPalindrome(word.substring(1,word.length()-1)); }
}