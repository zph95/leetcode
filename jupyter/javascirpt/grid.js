var checkValidGrid = function(grid) {
    if(grid[0][0]!=0){
        return false;
    }
    let gridMap = new Map();
    const n = grid.length;
    
    for( let i =0;i<grid.length;i++){
        for(let j=0;j<grid.length;j++){
            gridMap.set(grid[i][j], [i,j]);
        }
    }
    let ret= true;
    for(let pos=1; pos<n*n; pos++){
        const nowPos = gridMap.get(pos);
        const prePos = gridMap.get(pos-1);
        if(Math.abs(nowPos[0]-prePos[0])==2&&Math.abs(nowPos[1]-prePos[1])==1){
            ret = true;
        }
        else if(Math.abs(nowPos[0]-prePos[0])==1&&Math.abs(nowPos[1]-prePos[1])==2){
            ret = true;
        }
        else {
            ret =false;
            return ret;
        }
    }
    return ret;
};
let grid = [[0,3,6],[5,8,1],[2,7,4]];
console.log(checkValidGrid(grid));