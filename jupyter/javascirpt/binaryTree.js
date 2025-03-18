// Definition for a binary tree node.
function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}

var serialize =function(root){
    const nodes = [];
    const arr = [];
    if(root!=null){
        nodes.push(root);
        while(nodes.length!=0){
            let node = nodes.shift();
            arr.push(node.val);
            if(node.left!=null){
                nodes.push(node.left);
            }
            if(node.right!=null){
                nodes.push(node.right);
            }
        }
    }
    const str=arr.join(",");
    return str;
}


var deserialize = function(data){
    let root = null;
    let arr = data.split(","); 
    let nodes = [];
    if(data!=""){
        let val = arr.shift();;
        root = new TreeNode(val);
        nodes.push(root);
        while(nodes.length!=0){
        let node = nodes.shift();
        if(arr.length!=0){
            val = arr.shift();
            node.left = new TreeNode(val);
            nodes.push(node.left);
        }
        if(arr.length!=0){
            val = arr.shift();
            node.right = new TreeNode(val);
            nodes.push(node.right);
        }
        }
    }
    return root;

}

let sample = "1,null,2";
console.log(serialize(deserialize(sample)));