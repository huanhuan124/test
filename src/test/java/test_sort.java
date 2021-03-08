import java.util.Arrays;
//快速排序
public class test_sort {

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大等于endIndex的时候
//        System.out.println("startindex:"+startIndex);
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        // 根据基准元素，分成两部分递归排序
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    public static int partition(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while( left != right) {
            //控制right指针比较并左移
            while(left<right && arr[right] > pivot){
                right--;
            }
            //控制right指针比较并右移
            while( left<right && arr[left] <= pivot) {
                left++;
            }
            //交换left和right指向的元素
            if(left<right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        //pivot和指针重合点交换
        int p = arr[left];
        arr[left] = arr[startIndex];
        arr[startIndex] = p;
        System.out.println("left:"+left+"startindex:"+startIndex);
        return left;
    }

    /*打印数组*/
    public static void printArray(int[] nums) {
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }

    public static int[] quickSort2(int[] nums,int L, int R){
        if (L>R) return nums;
        int pivot = nums[L];
        System.out.println("nums[L]:"+nums[L]);
        int left = L;
        int right = R;

//        int pivot = nums[left];

        System.out.println("pivot:"+pivot);
        System.out.println("left:"+left+"right:"+right);
        System.out.println("numsleft:"+nums[left]+"numsright:"+nums[right]);

        while(left != right){

            while(left < right && nums[right]>=pivot){
                System.out.println("11left:"+left+"right:"+right+"nums:"+nums[right]);
                right--;

            }

            while(left <  right && nums[left] <= pivot){
                System.out.println("22left:"+left+"right:"+right+"nums:"+nums[left]);
                left++;
            }
            if(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

            }



        }

//        int temp = pivot;
//        pivot = nums[left];
//        nums[left] = temp;

//        int temp = nums[left];
//        nums[left] = pivot;
//        pivot = temp;

        //注意：不能直接用nums[left] 和 pivot的值交换，那样的话
        int temp = nums[left];
        nums[left] = nums[L];
        nums[L] = temp;


        System.out.println("left:"+left+"right:"+right);
        System.out.println("pivot:"+pivot);
        System.out.println("numsleft:"+nums[left]+"numsright:"+nums[right]);
        System.out.println("nums[L]:"+nums[L]);
        System.out.println("此轮完毕");


//        quickSort2(nums,0,left-1);
//        quickSort2(nums,left+1,right);

        quickSort2(nums,L,left-1);
        quickSort2(nums,left+1,R);

        return nums;

    }



    public int[] sortArray(int[] nums) {
        int temp=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=1;j<nums.length-i;j++){
                if(nums[j]<nums[j-1]){
                    temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;

    }

    public static void main(String[] args) {
        int[] arr = new int[] {23,46,0,8,11,18};
//        quickSort(arr, 0, arr.length-1);
        quickSort2(arr, 0, arr.length-1);

        for(int i:arr){
            System.out.println(i);

        }
//        printArray(arr);
//        System.out.println(Arrays.toString(arr));
    }

}
