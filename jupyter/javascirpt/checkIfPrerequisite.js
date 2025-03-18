/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @param {number[][]} queries
 * @return {boolean[]}
 */

var findPre = function( prerequisites, target, preMap){
    if(preMap.get(target)!=undefined){
        return  preMap.get(target);
    }
    else{
        let preSet = new Set();
        for(let j=0;j<prerequisites.length; j++){
            if(prerequisites[j][1]===target){
                preSet.add(prerequisites[j][0]);
                let findPreSet =  findPre(prerequisites, prerequisites[j][0], preMap );
                findPreSet.forEach(item=>preSet.add(item));
            }
        }
        preMap.set(target, preSet);
        return preSet;
    }
}



var checkIfPrerequisite = function(numCourses, prerequisites, queries) {

    let preMap=new Map();

    for(let i = 0;i<numCourses;i++){
        findPre( prerequisites, i,preMap );
    }
    let answers =[];
    for(let i = 0;i<queries.length;i++){
        if(preMap.get(queries[i][1]).has(queries[i][0])){
            answers.push(true);
        }
        else{
            answers.push(false);
        }
    }
    return answers;
};

const numCourses=2;
const prerequisites=[[1,0]];
const queries =[[0,1],[1,0]];

console.log(checkIfPrerequisite(numCourses, prerequisites, queries));

