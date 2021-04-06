import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        //字符串转换成数组
        char newStr[] = str.toCharArray();
        int start=0;
        int end=newStr.length-1;
        String ss ="";
        while(start<end){
            char temp = newStr[end];
            newStr[end] = newStr[start];
            newStr[start] = temp;
            start++;
            end--;

        }
        //数组转换成字符串  return new String(newStr);
        System.out.println("反转后的字符串："+new String(newStr));
        return new String(newStr);

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
    /*
    * 找出数组中重复的数字，用的map 方法
    * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
    * [2, 3, 1, 0, 2, 5, 3]  ==>2
    * */
    public static int findRepeatNum(int[] nums){
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return nums[i];
            }
            map.put(nums[i],i);
        }
        return -1;

    }
    /*
     * 找出数组中重复的数字，用一个萝卜一个坑的方法
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * [2, 3, 1, 0, 2, 5, 3]  ==>2
     * */
    public static int findRepeatNum2(int[] nums){

        return -1;

    }








    /*
     * 给定一个二进制数组， 计算其中最大连续1的个数。
     * [1,1,0,1,1,1]   ==>3
     * */
    public static int findMaxConsecutiveOnes(int[] nums){
        int maxCount = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }else{
                maxCount = Math.max(maxCount,count);
                count = 0;
            }

        }
        return Math.max(maxCount,count);

    }
/*
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 */
    public static int fib(int n) {
        int f =0;
        if(n<0){
            return -1;
        }else if(n<2){
            return n;
        }else if(n>2){
            f=fib(n-1)+fib(n-2);
            System.out.println(f);
        }
        return f;
    }

/**
 * 求n以内的素数的个数  100以内的25个
 * 素数：大于1的自然数，只能被1和本身整除，比如2,3,5,7,11
 */
    public static int countPrimes(int n) {

        int count = 0;
        for(int i=2;i<n;i++){
            if(i==2) {
                System.out.print(i);
                count++;
                continue;
            }
            boolean flag = true;
            double s = Math.sqrt(i);
            for(int j=2;j<=s;j++){
                if(i%j==0){
                    flag = false;
                    break;

                }
            }

            if(flag) {
                System.out.print(i);
                count++;
            }
        }

        return count;
    }


    /**
     * 求n以内合数的个数  100以内的73个
     * 合数：大于1的整数，除了被1和本身整除外，还能被其他数整除。比如4,6,8,9,10,12,14,15,
     */
    public static int countComposite(int n) {
        int compositeCount = 0;
        int count = 0;
        for(int i=2;i<n;i++){

            if(i==2) {
                System.out.print("质数："+i);
                count++;
                continue;
            }
            boolean flag = true;
            for(int j=2;j<=Math.sqrt(i);j++){

                if(i%j==0){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                System.out.print("\t质数："+i);
                count++;
            }else{
                System.out.print("\t合数："+i);
                compositeCount++;
            }



        }
        System.out.println("\n"+count);
        System.out.println(compositeCount);

        return compositeCount;

    }




    /**
     * 排序
     * 冒泡排序
     * 比较相邻的元素，如果第2个比第1个大，交换他们，一次比较以后，最大数在右边，所以外面最多需要比较length-1次
     * 针对所有的元素，重复以上步骤，所以里面需要length-1-i次
     * 每轮询一次，把最大的放到最右边
     * 算法复杂度0(n~2)
     */
    public static void popSort(int[] nums){
        System.out.println("len:"+nums.length);
        for(int i = 0;i<nums.length-1;i++){
            for(int j =0;j<nums.length-1-i;j++){
                System.out.println("i:"+i+"j:"+j);
                if(nums[j+1] < nums[j]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;

                }

            }
        }



    }



    /**
     * 排序
     * 快速排序--双指针交换法    *
     *
     */

    public static void quickSortArray(int[] nums,int startIndex, int endIndex){
        if(startIndex > endIndex) return;
        int pivot = nums[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right){

            while(left<right && nums[right] >=pivot){
                right--;
            }
            while(left<right && nums[left] <=pivot){
                left++;
            }

            if(left<right){
                int p = nums[left];
                nums[left] = nums[right];
                nums[right] = p;
            }


        }
        int p = nums[left];
        nums[left] = nums[startIndex];
        nums[startIndex] = p;

        quickSortArray(nums,startIndex,left-1);
        quickSortArray(nums,left+1,endIndex);




    }

    public static void main(String[]  args){
        System.out.println("hello world!");
        String str = "tmmzuxt";
//      noRepetitionMaxStr(str);
        strReverse(str);
//        int nums[] = {2,7,9,0};
//        int target = 16;
//        printArray(twoSum(nums,target));
//        System.out.println(numReverse(1463847413));
//        int[] nums1 = {6, 36, 1, 0, 22, 33, 3};
//        System.out.println(findRepeatNum(nums1));

//        int[] binaryNums = {0,1,1,1,1,0,1,1,1};
//        System.out.println(findMaxConsecutiveOnes(binaryNums));

//        fib(5);
//        int[] quickNums ={0,8,7,5,6,0,10};
//        quickSort(quickNums,0,quickNums.length-1);
//        printArray(quickNums);

//        quickSortArray(quickNums,0,quickNums.length-1);
//        printArray(quickNums);

//        popSort(quickNums);
//        for(int i:quickNums){
//            System.out.println(i);
//        }

//        System.out.println("\n"+"质数的个数："+countPrimes(100));
//        System.out.println(countComposite(100));


    }
}
