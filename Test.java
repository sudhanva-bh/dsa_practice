
class Test {

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
    }
}

class Solution {

    public static boolean isIsomorphic(String s, String t) {
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == 0) {
                map[s.charAt(i)] = t.charAt(i) + 1;
            } else if (map[s.charAt(i)] != t.charAt(i) + 1) {
                return false;
            }
        }
        return true;
    }
}
