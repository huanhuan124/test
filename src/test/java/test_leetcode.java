import java.util.HashMap;
import java.util.Map;

/*
* 2021-01-15
* author:zenghuan
* */
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

    /*
      * 字符串反转，共3种方法
    * */
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

    /*
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * */
    public static int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer> map = new HashMap();
        for(int i =0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                System.out.println(map.get(target-nums[i])+","+i);
                return new int[]{map.get(target-nums[i]),i};


            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    /*打印数组*/
    public static void printArray(int[] nums) {
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }

    /*
    假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2**31,  2**31 − 1]。
    请根据这个假设，如果反转后整数溢出那么就返回 0。
    *最大的值与最小的值为：[−2^31, 2^31 − 1]， 即：[-2147483648, 2147483647]

    如果ans = ans * 10 + x % 10溢出，则 y>=214748364
    当y=214748364时，输入的值只能为：1463847412，此时不溢出
    即：ans > 214748364 || ans < -214748364 必定溢出
    *
    * */
    public static int  numReverse(int num){
        int ans = 0;
        while(num!=0){
            if(ans> 214748364|| ans<-214748364) {
                System.out.println("溢出了");
                return 0;
            }
            System.out.println("111");
            ans = ans*10+num%10;
            num = num/10;
        }
        System.out.println(ans);
        return ans;

    }




    public static void main(String[]  args){
        System.out.println("hello world!");
        String str = "tmmzuxt";
//      noRepetitionMaxStr(str);
        strReverse3(str);
        int nums[] = {2,7,9,0};
        int target = 16;
        printArray(twoSum(nums,target));
        System.out.println(numReverse(1463847413));

    }
}
