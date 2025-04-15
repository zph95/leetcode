# @nc app=nowcoder id=8b85768394304511b0eb887244e51872 topic=195 question=36213 lang=Bash
# 2025-03-13 10:54:14
# https://www.nowcoder.com/practice/8b85768394304511b0eb887244e51872?tpId=195&tqId=36213
# [SHELL3] 输出 0 到 500 中 7 的倍数

# @nc code=start

#!/bin/bash

for i in {0..500}
do
    if [ $((i % 7)) -eq 0 ]; then
        echo $i
    fi
done
exit 0

# @nc code=end
