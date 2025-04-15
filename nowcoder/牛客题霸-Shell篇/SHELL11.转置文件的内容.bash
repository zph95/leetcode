# @nc app=nowcoder id=2240cd809c8f4d80b3479d7c95bb1e2e topic=195 question=36221 lang=Bash
# 2025-03-13 11:16:06
# https://www.nowcoder.com/practice/2240cd809c8f4d80b3479d7c95bb1e2e?tpId=195&tqId=36221
# [SHELL11] 转置文件的内容

# @nc code=start

#!/bin/bash

awk '
{
    for (i = 1; i <= NF; i++) {
        if (NR == 1) {
            res[i] = $i
        } else {
            res[i] = res[i] " " $i
        }
    }
}
END {
    for (i = 1; i <= NF; i++) {
        print res[i]
    }
}' nowcoder.txt
exit 0

# @nc code=end
