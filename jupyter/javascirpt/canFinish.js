/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */

var findPre = function(preSet, prerequisites, target){
   
    for(let j=0;j < prerequisites.length;j++){
        if(prerequisites[j][0]==target){
            if(preSet.has(prerequisites[j][1])){
                return false;
            }
            else{
                let newSet = new Set(Array.from(preSet));
                newSet.add(prerequisites[j][1]);
                console.log(preSet);
                let ret = findPre(newSet, prerequisites, prerequisites[j][1]);
                if(!ret){
                    return false;
                }
            }   
        }   
    }
    return true;
}


var canFinish = function(numCourses, prerequisites) {
    for(let i=0;i < numCourses; i++){
        let target  =  i;
        for(let j=0;j < prerequisites.length;j++){
            let preSet = new Set();
            if(prerequisites[j][0]==target){
                preSet.add(prerequisites[j][1]);
                let ret = findPre(preSet, prerequisites, prerequisites[j][1]);
                if(!ret){
                    return false;
                }
            }   
        }

    }
     return true;
};


const findOrder = (numCourses, prerequisites) => {
    const inDegree = new Array(numCourses).fill(0); // 入度数组
    const map = {};                                 // 邻接表
    for (let i = 0; i < prerequisites.length; i++) {
      inDegree[prerequisites[i][0]]++;              // 求课的初始入度值
      if (map[prerequisites[i][1]]) {               // 当前课已经存在于邻接表
        map[prerequisites[i][1]].push(prerequisites[i][0]); // 添加依赖它的后续课
      } else {                                      // 当前课不存在于邻接表
        map[prerequisites[i][1]] = [prerequisites[i][0]];
      }
    }
    const queue = [];
    for (let i = 0; i < inDegree.length; i++) { // 所有入度为0的课入列
      if (inDegree[i] == 0) queue.push(i);
    }
    let ret = []
    while (queue.length) {
      const selected = queue.shift();           // 当前选的课，出列
      ret.push(selected);                            
      const toEnQueue = map[selected];          // 获取这门课对应的后续课
      if (toEnQueue && toEnQueue.length) {      // 确实有后续课
        for (let i = 0; i < toEnQueue.length; i++) {
          inDegree[toEnQueue[i]]--;             // 依赖它的后续课的入度-1
          if (inDegree[toEnQueue[i]] == 0) {    // 如果因此减为0，入列
            queue.push(toEnQueue[i]);
          }
        }
      }
    }
    return ret;
  };

console.log(canFinish(7, [[1,0],[0,3],[0,2],[3,2],[2,5],[4,5],[5,6],[2,4]]));
