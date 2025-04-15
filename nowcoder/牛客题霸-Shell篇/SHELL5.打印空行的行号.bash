# @nc app=nowcoder id=030fc368e42e44b8b1f8985a8d6ad255 topic=195 question=36215 lang=Bash
# 2025-03-13 10:59:20
# https://www.nowcoder.com/practice/030fc368e42e44b8b1f8985a8d6ad255?tpId=195&tqId=36215
# [SHELL5] 打印空行的行号

# @nc code=start

#!/bin/bash

awk '{
    if ($0 == "") {
        print NR
    }
}' nowcoder.txt
exit 0

# @nc code=end
