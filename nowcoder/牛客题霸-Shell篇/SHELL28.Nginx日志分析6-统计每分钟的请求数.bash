# @nc app=nowcoder id=9a37600d342c47ed9e9a0fd33c1c189e topic=195 question=39437 lang=Bash
# 2025-03-15 13:26:47
# https://www.nowcoder.com/practice/9a37600d342c47ed9e9a0fd33c1c189e?tpId=195&tqId=39437
# [SHELL28] Nginx日志分析6-统计每分钟的请求数

# @nc code=start

#!/bin/bash

awk '{print substr($4, 14, 5)}' nowcoder.txt | sort | uniq -c | sort -nr
exit 0

# @nc code=end
