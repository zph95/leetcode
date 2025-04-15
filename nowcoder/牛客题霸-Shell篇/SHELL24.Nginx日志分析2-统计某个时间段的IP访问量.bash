# @nc app=nowcoder id=ddbdd73859fa4fd48bbae7dd2e55f4b9 topic=195 question=39433 lang=Bash
# 2025-03-15 12:50:35
# https://www.nowcoder.com/practice/ddbdd73859fa4fd48bbae7dd2e55f4b9?tpId=195&tqId=39433
# [SHELL24] Nginx日志分析2-统计某个时间段的IP访问量

# @nc code=start

#!/bin/bash

awk '$4 ~ /23\/Apr\/2020:2[0-3]/ {print $1}' nowcoder.txt | sort | uniq | wc -l

exit 0

# @nc code=end
