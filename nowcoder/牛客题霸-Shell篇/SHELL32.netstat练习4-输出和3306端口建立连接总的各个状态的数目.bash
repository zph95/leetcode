# @nc app=nowcoder id=5ce76fd1513d4eacae68ad3b2aca1fbb topic=195 question=39441 lang=Bash
# 2025-03-15 15:21:33
# https://www.nowcoder.com/practice/5ce76fd1513d4eacae68ad3b2aca1fbb?tpId=195&tqId=39441
# [SHELL32] netstat练习4-输出和3306端口建立连接总的各个状态的数目

# @nc code=start

#!/bin/bash
states=$(awk '$5 ~ /:3306$/ {print $6}' nowcoder.txt)

# 统计各个状态的数目
declare -A state_count
for state in $states; do
    ((state_count[$state]++))
done

# 输出总的IP数目和总的连接数目
total_ip=$(awk '$5 ~ /:3306$/ {print $5}' nowcoder.txt | cut -d: -f1 | sort | uniq | wc -l)
total_link=$(awk '$5 ~ /:3306$/ {print $5}' nowcoder.txt | wc -l)

echo "TOTAL_IP $total_ip"
# 输出各个状态的数目
for state in "${!state_count[@]}"; do
    echo "$state ${state_count[$state]}"
done


echo "TOTAL_LINK $total_link"
exit 0

# @nc code=end
