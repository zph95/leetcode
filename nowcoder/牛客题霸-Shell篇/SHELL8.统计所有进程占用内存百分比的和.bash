# @nc app=nowcoder id=fb24140bac154e5b99e44e0cee45dcaf topic=195 question=36218 lang=Bash
# 2025-03-13 11:07:16
# https://www.nowcoder.com/practice/fb24140bac154e5b99e44e0cee45dcaf?tpId=195&tqId=36218
# [SHELL8] 统计所有进程占用内存百分比的和

# @nc code=start

#!/bin/bash

awk '{
    sum += $4
} END {
    print sum
}' nowcoder.txt
exit 0

# @nc code=end
