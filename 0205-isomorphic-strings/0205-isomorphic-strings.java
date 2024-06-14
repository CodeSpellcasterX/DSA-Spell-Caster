class Solution {
    public boolean isIsomorphic(String s, String t) {
       if (s.length() != t.length())
        return false;
        Map index = new HashMap();
        for (Integer i=0; i<s.length(); ++i)
            if(index.put(t.charAt(i)+32, i)!=index.put(s.charAt(i), i))
                return false;
        return true;    
    }
    
}