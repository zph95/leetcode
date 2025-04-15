# @nc app=nowcoder id=f076c0a3c1274cbe9d615e0f3fd965f1 topic=195 question=39427 lang=Bash
# 2025-03-14 17:09:00
# https://www.nowcoder.com/practice/f076c0a3c1274cbe9d615e0f3fd965f1?tpId=195&tqId=39427
# [SHELL18] 域名进行计数排序处理

# @nc code=start

#!/bin/bash

# Check if the input file exists
if [[ ! -f nowcoder.txt ]]; then
    echo "File nowcoder.txt not found!"
    exit 1
fi

# Read domain names and count occurrences
declare -A domain_count

while IFS= read -r url; do
    domain=$(echo "$url" | awk -F[/:] '{print $4}')
    ((domain_count["$domain"]++))
done < nowcoder.txt

# Sort domains by count in descending order and print
for domain in "${!domain_count[@]}"; do
    echo "${domain_count[$domain]} $domain"
done | sort -rn | awk '{for(i=1;i<=NF;i++) printf $i (i==NF?"\n":" ");}'

exit 0

# @nc code=end
