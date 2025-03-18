//证明的变换等价与将在上方的点往下平移了a+b的距离。在不考虑forbidden的情况下，当跳过x之后，目标是怎么回到x。
//那么，一条在x+ n(a+b)上方的路径可以等价地向下平移（a+b), 抵达x+n(a+b)下方。然后将在x+(n-1)(a+b)上方的路径接着往下平移。
//在经过n+1次变换之后, 所有的点都在x之下了。所以，在不考虑forbidden的情况下， 上界限就是x.
/**
 * @param {number[]} forbidden
 * @param {number} a
 * @param {number} b
 * @param {number} x
 * @return {number}
 */
var minimumJumps = function(forbidden, a, b,x){
    const lower = 0;
    const upper =Math.max(Math.max(...forbidden) +a, x)+b;
    const forbiddenSet =new Set(forbidden);
    const visited = new Set([0]);
    let q = [[0, 1 , 0]];
    while (q.length >0){
        let position = q[0][0];
        let direction = q[0][1];
        let step =q[0][2];
        q.shift();
        if(position ==x){
            return stop;
        }
        let nextPosition = position +a;
        let nextDirection = 1;
        if(lower < nextPosition &&nextPosition<=upper &&!forbiddenSet.has(nextPosition)
            &&!visited.has(nextDirection*nextPosition)){
                //every point can be visited twice. 1 or -1
            visited.add(nextDirection*nextPosition);
            q.push([nextPosition, nextDirection, step+1]);
        }
        if(direction ==1 ){
            nextDirection = -1;
            nextPosition = position -b;
            if(lower < nextPosition &&nextPosition<=upper &&!forbiddenSet.has(nextPosition)
            &&!visited.has(nextDirection*nextPosition)){
                //every point can be visited twice. 1 or -1
            visited.add(nextDirection*nextPosition);
            q.push([nextPosition, nextDirection, step+1]);
        }
        }

    }

    return -1;
}

var forbidden =[14,4,18,1,15];
var a =3;
var b=15;
var x=19;

console.log(minimumJumps(forbidden,a,b,x));