# @nc app=nowcoder id=7094b5f96e1a4c998ce01baf407beee6 topic=195 question=39443 lang=Bash
# 2025-03-15 15:34:50
# https://www.nowcoder.com/practice/7094b5f96e1a4c998ce01baf407beee6?tpId=195&tqId=39443
# [SHELL34] ps分析-统计VSZ,RSS各自总和

# @nc code=start

#!/bin/bash

log_file="nowcoder.txt"

# Extract VSZ and RSS columns, skip the header line, and calculate the sum
vsz_sum=$(awk 'NR>1 {sum+=$5} END {print sum/1024}' "$log_file")
rss_sum=$(awk 'NR>1 {sum+=$6} END {print sum/1024}' "$log_file")

# Print the results in the specified format
echo "MEM TOTAL"
echo "VSZ_SUM:${vsz_sum}M,RSS_SUM:${rss_sum}M"

exit 0

# @nc code=end
