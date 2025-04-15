# @nc app=nowcoder id=e1846855de79495fbb017b8ddf6ba969 topic=195 question=39434 lang=Bash
# 2025-03-15 13:14:32
# https://www.nowcoder.com/practice/e1846855de79495fbb017b8ddf6ba969?tpId=195&tqId=39434
# [SHELL25] nginx日志分析3-统计访问3次以上的IP

# @nc code=start

#!/bin/bash

awk '{print $1}' nowcoder.txt | sort | uniq -c | sort -nr | awk '$1 >3 {print $1, $2}'

exit 0

# @nc code=end
