# @nc app=nowcoder id=2d2a124f98054292aef71b453e705ca9 topic=195 question=36222 lang=Bash
# 2025-03-13 11:18:43
# https://www.nowcoder.com/practice/2d2a124f98054292aef71b453e705ca9?tpId=195&tqId=36222
# [SHELL12] 打印每一行出现的数字个数

# @nc code=start

#!/bin/bash

awk '
{
    line_count = 0
    for (i = 1; i <= length($0); i++) {
        if (substr($0, i, 1) ~ /[1-5]/) {
            line_count++
            total_count++
        }
    }
    print "line"NR " number: " line_count
}
END {
    print "sum is " total_count
}' nowcoder.txt
exit 0

# @nc code=end
