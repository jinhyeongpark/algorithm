class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int v = toSeconds(video_len);
        int p = toSeconds(pos);
        int os = toSeconds(op_start);
        int oe = toSeconds(op_end);
        
        p = checkOpening(p, os, oe);
        
        for (String command : commands) {
            if (command.equals("next")) {
                p = Math.min(v, p + 10);
            }
            else {
                p = Math.max(0, p - 10);
            }
            p = checkOpening(p, os, oe);
        }
        return toMinutes(p);
    }
    
    private static int toSeconds(String stringTime) {
        String[] parts = stringTime.split(":");
        int m = Integer.parseInt(parts[0]);
        int s = Integer.parseInt(parts[1]);
        return m * 60 + s;
    }
    
    private static String toMinutes(int intTime) {
        int minutes = intTime / 60;
        int seconds = intTime % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
                
    private int checkOpening(int pos, int op_start, int op_end) {
        if (pos >= op_start && pos <= op_end) return op_end;
        else return pos;
    }
}