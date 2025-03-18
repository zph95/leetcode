/**
 * @param {number} money
 * @param {number} children
 * @return {number}
 */
var distMoney = function(money, children) {
    let div = Math.floor(money/8);
    let mod =  money%8;

    let i=0;
    for( ;div>=i;i++){
        let left = mod+8*i;
        let ret =  div-i;
        if(left >= (children-ret)){
            if(left==4&& (children-ret)==1){
                continue;
            }
            else{
                return ret;
            }
        }
    }
    return -1;
};

console.log(distMoney(20,3));