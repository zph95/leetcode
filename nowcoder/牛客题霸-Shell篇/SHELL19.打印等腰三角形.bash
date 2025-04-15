# @nc app=nowcoder id=1c55ca2b73a34e80bafd5978810dd8ea topic=195 question=39428 lang=Bash
# 2025-03-14 17:22:23
# https://www.nowcoder.com/practice/1c55ca2b73a34e80bafd5978810dd8ea?tpId=195&tqId=39428
# [SHELL19] 打印等腰三角形

# @nc code=start

#!/bin/bash

# 读取输入的数字
read n
total=$n
while [ $n -gt 0 ]; do
    # 打印空格
    for ((i=0; i<n-1; i++)); do
        echo -n " "
    done
    # 打印星号
    for ((i=n; i<=total; i++)); do
        echo -n "* "
    done
    echo
    n=$((n-1))
done
exit 0

# @nc code=end
