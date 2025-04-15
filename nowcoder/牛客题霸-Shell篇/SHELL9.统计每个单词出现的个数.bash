# @nc app=nowcoder id=ad921ccc0ba041ea93e9fb40bb0f2786 topic=195 question=36219 lang=Bash
# 2025-03-13 11:08:50
# https://www.nowcoder.com/practice/ad921ccc0ba041ea93e9fb40bb0f2786?tpId=195&tqId=36219
# [SHELL9] 统计每个单词出现的个数

# @nc code=start

#!/bin/bash

awk '
{
    for (i = 1; i <= NF; i++) {
        word_count[$i]++
    }
}
END {
    for (word in word_count) {
        print word, word_count[word]
    }
}' nowcoder.txt

# @nc code=end
