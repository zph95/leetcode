/**
 * @param {number[]} nums
 * @return {number}
 */

var findPeakElement = function(nums){

    let left = 0;
    let right=nums.length-1;
    nums[-1]=-Infinity;
    nums[right+1]=(-Infinity);

    return findMedian(nums, left, right);
}

var findMedian=function(nums, left, right){
    const tmp=Math.floor(left+(right-left)/2);
    console.log(nums[tmp-1]);
    console.log(nums[tmp+1]);
    if(nums[tmp]>nums[tmp-1]&&nums[tmp]>nums[tmp+1]){
        return tmp;
    }
    else{
        if(left==right){
            return -1;
        }
        if(nums[tmp]<nums[tmp-1]){
           let leftRet =  findMedian(nums, left, tmp-1);
           if(leftRet!=-1){
               return leftRet;
           }
        }
        if(nums[tmp]<nums[tmp+1]){
           let rightRet =  findMedian(nums, tmp+1, right);
           if(rightRet!=-1){
               return rightRet;
           }
        }
        return -1;
    }
}

let nums= [1,2,1,3,5,6,4];
nums=[0];

console.log(findPeakElement(nums));