class Solution {
    public String solution(String s) {
        String[] strArr = s.split(" ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < strArr.length; i++) {
            int num = Integer.parseInt(strArr[i]);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        return min + " " + max;
    }
}