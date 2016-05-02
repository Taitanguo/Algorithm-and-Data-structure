

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (s == null) {
            return result;
        }

        ArrayList<String> path = new ArrayList<String>();
        helper(s, path, 0, result);

        return result;
    }

    private boolean isPalindrome(String s) {
        int beg = 0;
        int end = s.length() - 1;
        while (beg < end) {
            if (s.charAt(beg) != s.charAt(end)) {
                return false;
            }

            beg++;
            end--;
        }

        return true;
    }

    private void helper(String s, ArrayList<String> path, int pos,
            ArrayList<ArrayList<String>> result) {
        //结束条件 在pos到达最后一位的时候
        if (pos == s.length()) {
            result.add(new ArrayList<String>(path));
            return;
        }

        for (int i = pos + 1; i <= s.length(); i++) {
            String prefix = s.substring(pos, i);
            if (!isPalindrome(prefix)) {
                continue;
            }

            path.add(prefix);
            helper(s, path, i, result);//在最紧凑的到达最厚一层之后 开始倒退 退出最外层
            //除去原来最紧凑的解法 然后开始在寻找新的palindrome
            path.remove(path.size() - 1);
        }
    }
}
