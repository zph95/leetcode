# @nc app=nowcoder id=61b79ffe88964c7ab7b98ae16dd76492 topic=195 question=36220 lang=Bash
# 2025-03-13 11:12:20
# https://www.nowcoder.com/practice/61b79ffe88964c7ab7b98ae16dd76492?tpId=195&tqId=36220
# [SHELL10] 第二列是否有重复

# @nc code=start

#!/bin/bash

awk '
{
    word_count[$2]++
}
END {
    for (word in word_count) {
        if (word_count[word] > 1) {
            print word_count[word], word
        }
    }
}' nowcoder.txt | sort -k2,2nr -k1,1
exit 0

# @nc code=end
