# @nc app=nowcoder id=0372acd5725d40669640fd25e9fb7b0f topic=195 question=36216 lang=Bash
# 2025-03-13 11:02:10
# https://www.nowcoder.com/practice/0372acd5725d40669640fd25e9fb7b0f?tpId=195&tqId=36216
# [SHELL6] 去掉空行

# @nc code=start

#!/bin/bash

awk '{
    if ($0 != "") {
        print $0
    }
}' nowcoder.txt
exit 0

# @nc code=end
