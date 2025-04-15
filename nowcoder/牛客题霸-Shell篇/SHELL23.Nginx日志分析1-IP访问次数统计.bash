# @nc app=nowcoder id=3f2f45c74a1b415db17234f9cfd51469 topic=195 question=39432 lang=Bash
# 2025-03-14 18:03:35
# https://www.nowcoder.com/practice/3f2f45c74a1b415db17234f9cfd51469?tpId=195&tqId=39432
# [SHELL23] Nginx日志分析1-IP访问次数统计

# @nc code=start

#!/bin/bash

# Filter logs for the specific date and count IP access times
awk '$4 ~ /23\/Apr\/2020/ {print $1}' nowcoder.txt | sort | uniq -c | sort -nr | awk '{print $1, $2}'
exit 0

# @nc code=end
