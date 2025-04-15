# @nc app=nowcoder id=d0d81982176b4d5ebf032dbfb4a850d6 topic=195 question=39435 lang=Bash
# 2025-03-15 13:19:25
# https://www.nowcoder.com/practice/d0d81982176b4d5ebf032dbfb4a850d6?tpId=195&tqId=39435
# [SHELL26] Nginx日志分析4-查询某个IP的详细访问情况

# @nc code=start

#!/bin/bash

grep '192.168.1.22' nowcoder.txt | awk '{print $7}' | sort | uniq -c | sort -nr

exit 0

# @nc code=end
