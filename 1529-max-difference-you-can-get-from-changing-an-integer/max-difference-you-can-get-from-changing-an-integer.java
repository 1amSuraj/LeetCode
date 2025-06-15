class Solution {
    public int maxDiff(int num) {
        String s = Integer.toString(num);
        int n = s.length();
        String r = s;
        for(char ch : s.toCharArray()){
            if(ch!='9') {s=s.replace(ch,'9');
            break;}
        }
        int a = Integer.parseInt(s);
        if(r.charAt(0)!='1') r=r.replace(r.charAt(0),'1');
        else {
            for(int i = 1;i<r.length();i++){
                if(r.charAt(i)!='1' && r.charAt(i)!='0'){
                    r=r.replace(r.charAt(i),'0');
                    break;
                }
            }
        }

        int b= Integer.parseInt(r);
        System.out.println(a);
        System.out.println(b);
        return a-b;
        
    }

}