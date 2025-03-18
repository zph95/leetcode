/**
 * @param {number[][]} queens
 * @param {number[]} king
 * @return {number[][]}
 */
var queensAttacktheKing = function(queens, king){
    let retMap = {};
    
    for(let i = 0;i<queens.length;i++){
        
        const queen=queens[i];
        if(queen[0]==king[0]){
            if(queen[1]<king[1]){
                let beforeQueen = retMap.get(1);
                if(beforeQueen==undefined){
                    retMap.get(1, queen);
                }    
                else if(beforeQueen[1]<queen[1]){ 
                    retMap.get(1, queen);
                }
            }
            if(queen[1]>king[1]){
                let beforeQueen = retMap.get(2);
                if(beforeQueen==undefined){
                    retMap.get(2, queen);
                }    
                else if(beforeQueen[1]>queen[1]){ 
                    retMap.get(2, queen);
                }
            }
        }
        if(queen[1]==king[1]){
            if(queen[0]<king[0]){
                let beforeQueen = retMap.get(3);
                if(beforeQueen==undefined){
                    retMap.get(3, queen);
                }    
                else if(beforeQueen[0]<queen[0]){ 
                    retMap.get(3, queen);
                }
            }
            if(queen[0]>king[0]){
                let beforeQueen = retMap.get(4);
                if(beforeQueen==undefined){
                    retMap.get(4, queen);
                }    
                else if(beforeQueen[0]>queen[0]){ 
                    retMap.get(4, queen);
                }
            }
        }
        if((queen[0]-king[0]==(queen[1]-king[1]))){
            if(queen[0]<king[0]){
                let beforeQueen = retMap.get(5);
                if(beforeQueen==undefined){
                    retMap.get(5, queen);
                }    
                else if(beforeQueen[0]<queen[0]){ 
                    retMap.get(5, queen);
                }
            }
            if(queen[0]>king[0]){
                let beforeQueen = retMap.get(6);
                if(beforeQueen==undefined){
                    retMap.get(6, queen);
                }    
                else if(beforeQueen[0]>queen[0]){ 
                    retMap.get(6, queen);
                }
            }
        }
        if((queen[0]-king[0]==-(queen[1]-king[1]))){
            if(queen[0]<king[0]){
                let beforeQueen = retMap.get(7);
                if(beforeQueen==undefined){
                    retMap.get(7, queen);
                }    
                else if(beforeQueen[0]<queen[0]){ 
                    retMap.get(7, queen);
                }
            }
            if(queen[0]>king[0]){
                let beforeQueen = retMap.get(8);
                if(beforeQueen==undefined){
                    retMap.get(8, queen);
                }    
                else if(beforeQueen[0]>queen[0]){ 
                    retMap.get(8, queen);
                }
            }
        }
    }
    let ret =[];
    for(let i=0;i<8;i++){
        ret.push(retMap.get(i));
    }
    return ret;
}