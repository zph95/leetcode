# @nc app=nowcoder id=908d030e676a4fac997a127bfe63da64 topic=195 question=39431 lang=Bash
# 2025-03-14 17:39:00
# https://www.nowcoder.com/practice/908d030e676a4fac997a127bfe63da64?tpId=195&tqId=39431
# [SHELL22] 处理文本

# @nc code=start

#!/bin/bash

# Check if the input file exists
if [[ ! -f nowcoder.txt ]]; then
    echo "File nowcoder.txt not found!"
    exit 1
fi

# Use awk to format the output
awk -F: '
{
    count[$1] = count[$1] "\n" $2
}
END {
    for (key in count) {
        printf "[" key "]" count[key] "\n" 
    }
}' nowcoder.txt
exit 0

# @nc code=end
