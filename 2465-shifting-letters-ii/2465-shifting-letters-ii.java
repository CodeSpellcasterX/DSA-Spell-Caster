class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] arr = new int[s.length()];

        for(int[] shift: shifts) {
            int start = shift[0];
            int end = shift[1];
            int dir = shift[2];

            if(dir==1) {
                for(int i = start; i<=end; i++) {
                    arr[i] = arr[i] + 1;
                }
            } else {
                for(int i = start; i<=end; i++) {
                    arr[i] = arr[i] - 1;
                }
            }
        }
        StringBuilder string = new StringBuilder();
        for(int i=0;i<arr.length;i++) {
            string.append(circularAlphabetMapping(arr[i], s.charAt(i)));
        }

        return string.toString();
    }

    public static char circularAlphabetMapping(int value, char c) {
        value = value % 26;
        value = value < 0 ? value + 26 : value;
        return (char) ('a' + ((c - 'a' + value) % 26));
    }
}