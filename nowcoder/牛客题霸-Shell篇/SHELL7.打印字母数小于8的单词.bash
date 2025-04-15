# @nc app=nowcoder id=bd5b5d4b93a04226a81afbabf0be797d topic=195 question=36217 lang=Bash
# 2025-03-13 11:05:39
# https://www.nowcoder.com/practice/bd5b5d4b93a04226a81afbabf0be797d?tpId=195&tqId=36217
# [SHELL7] 打印字母数小于8的单词

# @nc code=start

#!/bin/bash

awk '{
    for (i = 1; i <= NF; i++) {
        if (length($i) < 8) {
            print $i
        }
    }
}' nowcoder.txt
exit 0

# @nc code=end
