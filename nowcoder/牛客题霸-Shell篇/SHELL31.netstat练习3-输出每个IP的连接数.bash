# @nc app=nowcoder id=f601fc4f35b5453ba661531051b6ce69 topic=195 question=39440 lang=Bash
# 2025-03-15 15:16:19
# https://www.nowcoder.com/practice/f601fc4f35b5453ba661531051b6ce69?tpId=195&tqId=39440
# [SHELL31] netstat练习3-输出每个IP的连接数

# @nc code=start

#!/bin/bash

awk '$1 == "tcp" {print $5}' nowcoder.txt | cut -d: -f1 | sort | uniq -c | sort -nr |awk '{print $2, $1}'

exit 0

# @nc code=end
