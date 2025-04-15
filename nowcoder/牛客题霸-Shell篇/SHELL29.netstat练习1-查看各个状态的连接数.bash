# @nc app=nowcoder id=f46a302d14e04b149bb50670f255293a topic=195 question=39438 lang=Bash
# 2025-03-15 15:00:44
# https://www.nowcoder.com/practice/f46a302d14e04b149bb50670f255293a?tpId=195&tqId=39438
# [SHELL29] netstat练习1-查看各个状态的连接数

# @nc code=start

#!/bin/bash

# 使用 netstat 命令查看系统 TCP 连接状态，并统计各个状态的连接数
awk '/^tcp/ {print $6}' nowcoder.txt | sort | uniq -c | sort -nr| awk '{print $2,$1}'

exit 0

# @nc code=end
