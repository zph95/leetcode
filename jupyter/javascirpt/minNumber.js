
var minNumber =  function(nums1, nums2){

    let min0=Infinity;
    for(var i=0;i<nums1.length;i++){
        for(var j=0;j<nums2.length;j++){
            if(nums1[i]==nums2[j]){
                if(nums1[i]<min0){
                    min0=nums1[i];
                }
            }
        }
    }
    if(min0!=Infinity){
        return min0;
    }

    let min1= Math.min(...nums1);
    let min2 = Math.min(...nums2);
    if(min1<min2){
        return min1*10+min2;
    }
    else {
        return min2*10+min1;
    }

}

let nums1=[3,5,2,6];
let nums2=[3,1,7];

console.log(minNumber(nums1,nums2));