class Solution {
    public String generateTag(String caption) {
        
        String[] s = caption.trim().split("\\s+");
        if(s.length<1) return "#";
        System.out.println(s.length);
        s[0]=s[0].toLowerCase();
        // if(s.length==1) return "#"+s[0];
        for(int i =1;i<s.length;i++){
            s[i]=s[i].toLowerCase();
            StringBuilder sb = new StringBuilder(s[i]);
            sb.setCharAt(0,Character.toUpperCase(sb.charAt(0)));
            s[i]=sb.toString();
        }
        
        String res = "#";
        for(int i =0;i<s.length;i++){
            res+=s[i];
        }
        if(res.length()>100) return res.substring(0,100);
        return res;
    }
}