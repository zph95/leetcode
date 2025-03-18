/**
 * 链接：https://www.nowcoder.com/questionTerminal/ca181c1bcfec4049a743b8d0dd09912e?answerType=1&f=discussion
来源：牛客网
数组下标从0开始
如果 total 是奇数，则通过调用 findKthElement 找到第 Math.ceil(total/2) 个元素作为中位数；如果 total 是偶数，则找到第 total/2 和 total/2-1 个元素，并计算其平均值作为中位数返回。
 *
 * 
 * @param nums1 int整型一维数组 
 * @param nums2 int整型一维数组 
 * @param nums3 int整型一维数组 
 * @return double浮点型
 */
function findMedianSortedArrays( nums1 ,  nums2 ,  nums3 ) {
    let length1 =  nums1.length;
    let length2 =  nums2.length;
    let length3 =  nums3.length;
    let total = length1+length2+length3;
    if(total%2==0){
        let keyIndex1 =  total/2;
        let keyIndex2 = total/2-1;
        return (findKeyElement(nums1,nums2,nums3, keyIndex1)+findKeyElement(nums1,nums2,nums3, keyIndex2))/2.0
    }
    else {
        let keyIndex =  Math.floor(total/2);
        return findKeyElement(nums1,nums2,nums3, keyIndex);
    }
}

function findKeyElement(nums1, nums2, nums3, keyIndex){
    let i=0,j=0,k=0;
    nums1.push(Infinity);
    nums2.push(Infinity);
    nums3.push(Infinity);
    let keyElement1=nums1[i],keyElement2=nums2[j], keyElement3=nums3[k];
    while(i+j+k<keyIndex){
        if(nums1[i]<=nums2[j]&&nums1[i]<=nums3[k]&&i<nums1.length-1){
            i++;
            keyElement1=nums1[i];
        }
        else  if(nums2[j]<=nums1[i]&&nums2[j]<=nums3[k]&&j<nums2.length-1){
            j++;
            keyElement2=nums2[j];
        }
        else  if(nums3[k]<=nums1[i]&&nums3[k]<=nums2[j]&&k<nums3.length-1){
            k++;
            keyElement3=nums3[k];
        } 
    }
    return Math.min(keyElement1,keyElement2,keyElement3);
}

//[1, 3, 5],[2, 4],[6, 8]
//[1, 3, 5, 7, 9],[],[11, 13, 15, 17, 19]
nums1 = [1, 3, 5, 7, 9]
nums2 = []
nums3 = [11, 13, 15, 17, 19]

console.log(findMedianSortedArrays(nums1,nums2,nums3));