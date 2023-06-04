class Solution {
    public int compress(char[] chars) {
     if (chars.length == 1) return chars.length;
    int index = 0, newChar_start_at = 0,start = 0;
    while (start< chars.length) {
        int count = 0;
        char val = chars[newChar_start_at];
        for (;start < chars.length && chars[start] == val;count++,start++); 
        chars[index] = val;
        index++;
        if (count > 1) {
            for (char c : Integer.toString(count).toCharArray()) {
                chars[index] = c;
                index++;
            }
        }
        newChar_start_at = start;
    }
    return index;
    }
}