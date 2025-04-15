public class 数组中的最长山脉 {
    
    public int longestMountain(int[] arr) {
      
        int n = arr.length;
        if (n < 3) {
            return 0;
        }
        int res = 0;
        int mountainTop = 1;
        while(mountainTop < n - 1 ) {
            if(arr[mountainTop] > arr[mountainTop - 1] && arr[mountainTop] > arr[mountainTop + 1]) {
                int left = mountainTop - 1;
                int right = mountainTop + 1;
                while(left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }
                while(right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }
                res = Math.max(res, right - left + 1);
                mountainTop = right;
            } else {
                mountainTop++;
            }
        }
        return res;
        
    }

    public static void main(String[] args) {
        数组中的最长山脉 s = new 数组中的最长山脉();
        int[] A = {2,1,4,7,3,2,5};
        System.out.println(s.longestMountain(A));
    }
}
