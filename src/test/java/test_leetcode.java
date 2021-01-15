import java.util.HashMap;
import java.util.Map;

public class test_leetcode {

    /*
    * 无重复字符的最长子串，使用滑动窗口
    * ans 要存一个旧的，存一个新的，然后做比较，取最大的
    * 当遇到重复字符的时候，要从已经存储过的那个字符串的后面一位再重新算
    * */
    public static int noRepetitionMaxStr(String s){
        char srr[] = s.toCharArray();
        int ans = 0;
        int start = 0;
        HashMap<Character,Integer> map= new HashMap<Character,Integer>();

        if(s.length() == 0) return 0;
        for(int end = 0; end<srr.length;end++){
            if(map.containsKey(srr[end]))  {
                start = Math.max(map.get(srr[end])+1,start);

            }
            ans = Math.max(ans,end-start+1);
            map.put(srr[end],end);
        }
        System.out.println(map);
        System.out.println("最大无重复字符串："+ans);
        return ans;
    }

    public static String strReverse2(String str){
        if(str.length() == 1) return str;
        String ss = "";
        char[] newStr = str.toCharArray();

        System.out.println("反转前的字符串："+str);
        for(int i = newStr.length-1;i>=0;i--){
//            System.out.println(newStr[i]);
            ss+=newStr[i];

        }
        System.out.println("反转后的字符串："+ss);
        return ss;

    }

    public static String strReverse3(String str){
        if(str.length() == 1) return str;
        String ss = "";


        System.out.println("反转前的字符串："+str);
        for(int i=0;i<str.length();i++){
//          System.out.println(newStr[i]);
            ss = str.charAt(i)+ss;

        }
        System.out.println("反转后的字符串："+ss);
        return ss;

    }




    public static String  strReverse(String str){
        if(str.length() == 1) return str;
        System.out.println("反转前的字符串："+str);
        char newStr[] = str.toCharArray();
        char temp;
        int start=0;
        int end=newStr.length-1;
        String ss ="";
        while(start<end){
            temp = newStr[end];
            newStr[end] = newStr[start];
            newStr[start] = temp;
            start++;
            end--;

        }

        for(int i=0;i<newStr.length;i++){
//            System.out.println(newStr[i]);
            ss+=newStr[i];

        }
        System.out.println("反转后的字符串："+ss);


        return ss;

    }


    public static void main(String[]  args){
        System.out.println("hello world!");
        String str = "tmmzuxt";
//        noRepetitionMaxStr(str);
        strReverse3(str);

    }
}
