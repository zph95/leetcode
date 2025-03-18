
var repairCars = function(ranks, cars){
   
    let timeCost=new Array(ranks.length).fill(1);

    while(cars>0){
        let index=null;
        let minTime=Infinity;
        for(var i=0;i<ranks.length;i++){
            let tmp = timeCost[i]*timeCost[i]*ranks[i]
            if(tmp<minTime){
                minTime=tmp;
                index=i;
            }
        }
        timeCost[index]=timeCost[index]+1;
        cars--;
    }
    let maxTime=0;
    for(var i=0;i<ranks.length;i++){
        let tmp = (timeCost[i]-1)*(timeCost[i]-1)*ranks[i]
        if(tmp>maxTime){
            maxTime=tmp;
        }
    }
    return maxTime;
}

var repairCars = function(ranks, cars){
   

    let l=0;
    let r=ranks[0]*cars*cars;

    const check =(t)=>{
        let cnt=0;
        for(const x of ranks){
            cnt +=Math.floor(Math.sqrt(t/x));
        }
        return cnt>=cars
    }
    while (l<r){
        const m =Math.floor((l+r)/2);
        if(check(m)){
            r=m;
        }
        else {
            l=m+1;
        }
    } 
    return r;
}


let ranks=[4,2,3,1];
let cars=10;
console.log(repairCars(ranks, cars));