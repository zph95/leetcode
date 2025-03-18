var kidsWithCandies = function(candies, extraCandies) {

    let ret=[];

    let maxNum = Math.max(...candies);

    for(let i=0;i<candies.length;i++){
        ret.push((candies[i]+extraCandies)>=maxNum);
    }
    return ret;

};

let candies=[2,3,5,1,3];
let extraCandies = 3;
console.log(kidsWithCandies(candies, extraCandies));