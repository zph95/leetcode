# @nc app=nowcoder id=296c2785e64c46b7ae4c76bf190c2072 topic=195 question=39429 lang=Bash
# 2025-03-14 17:29:33
# https://www.nowcoder.com/practice/296c2785e64c46b7ae4c76bf190c2072?tpId=195&tqId=39429
# [SHELL20] 打印只有一个数字的行

# @nc code=start

#!/bin/bash

# Check if the input file exists
if [[ ! -f nowcoder.txt ]]; then
    echo "File nowcoder.txt not found!"
    exit 1
fi

# Read the file and print lines with only one number
while IFS= read -r line; do
    if [[ $line =~ ^[^0-9]*[0-9][^0-9]*$ ]]; then
        echo "$line"
    fi
done < nowcoder.txt
exit 0

# @nc code=end
