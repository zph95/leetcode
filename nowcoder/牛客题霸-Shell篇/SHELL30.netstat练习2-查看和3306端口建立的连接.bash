# @nc app=nowcoder id=534b95941ffb495b9ba57fbfc3cd723a topic=195 question=39439 lang=Bash
# 2025-03-15 15:05:04
# https://www.nowcoder.com/practice/534b95941ffb495b9ba57fbfc3cd723a?tpId=195&tqId=39439
# [SHELL30] netstat练习2-查看和3306端口建立的连接

# @nc code=start

#!/bin/bash

# 使用 netstat 命令查看和本机 3306 端口建立连接并且状态是 ESTABLISHED 的所有 IP
awk '$5 ~ /:3306$/ && $6 == "ESTABLISHED" {print $5}' nowcoder.txt | cut -d: -f1 | sort | uniq -c | sort -nr

exit 0

# @nc code=end
