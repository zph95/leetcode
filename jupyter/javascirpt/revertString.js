/**
 * @param {string} s
 * @return {string}
 */
var reverseVowels = function(s) {

    let targetSet=new Set(["a","e","i","o","u","A","E","I","O","U"]);

    let i=0;
    let j=s.length;
    let ret=[];

    while(i<j){
        while(i<s.length&&!targetSet.has(s[i])){
            ret[i]=s[i];
            i++;
            
        }
        while(j>=0&&!targetSet.has(s[j])){
            ret[j]=s[j];
            j--;
        }
        ret[i]=s[j];
        ret[j]=s[i];
        i++;
        j--;
    }
    ret[i]=s[i];
    return ret.join("");
};

console.log(reverseVowels("hello"));