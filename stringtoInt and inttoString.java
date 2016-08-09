int stringToInt(String s){
    int r = 0;
    for(int i = 0; i < s.length(); ++i){
        if(i > 0){
            r *= 10;
        }

        r += s.charAt(i) - '0';
    }
    return r;
}

public static String intToString(int n){
    if(n == 0) return "0";
    StringBuilder sb = new StringBuilder();
    while(n > 0){
        int curr = n % 10;
        n = n / 10;
        sb.append(curr);
    }
    //copy the string from the first char
    String s = sb.substring(0);
    for(int i = s.length() - 1; i >= 0; i--){
        sb.append(s.charAt(i));
    }
    return sb.substring(0);
    //or you can use StringBuilder.reverse() instead of this loop
}