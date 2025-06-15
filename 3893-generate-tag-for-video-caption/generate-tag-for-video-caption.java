// class Solution {
//     public String generateTag(String caption) {

//         String[] s = caption.trim().split("\\s+");
//         if(s.length<1) return "#";
//         System.out.println(s.length);
//         s[0]=s[0].toLowerCase();

//         for(int i =1;i<s.length;i++){
//             s[i]=s[i].toLowerCase();
//             StringBuilder sb = new StringBuilder(s[i]);
//             sb.setCharAt(0,Character.toUpperCase(sb.charAt(0)));
//             s[i]=sb.toString();
//         }

//         String res = "#";
//         for(int i =0;i<s.length;i++){
//             res+=s[i];
//         }
//         if(res.length()>100) return res.substring(0,100);
//         return res;
//     }
// }

class Solution {
    public String generateTag(String caption) {
        if (caption == null || caption.trim().isEmpty())
            return "#";

        String[] s = caption.trim().split("\\s+");
        StringBuilder res = new StringBuilder("#");

        // Append the first word in lowercase
        res.append(s[0].toLowerCase());

        // Capitalize first letter of remaining words and make rest lowercase
        for (int i = 1; i < s.length; i++) {
            // if (s[i].isEmpty())
            //     continue;
            String word = s[i].toLowerCase();
            res.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1));
        }

        return res.length() > 100 ? res.substring(0, 100) : res.toString();
    }
}