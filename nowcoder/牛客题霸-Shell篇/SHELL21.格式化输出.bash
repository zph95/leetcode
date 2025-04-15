# @nc app=nowcoder id=d91a06bfaff443928065e611b14a0e95 topic=195 question=39430 lang=Bash
# 2025-03-14 17:35:11
# https://www.nowcoder.com/practice/d91a06bfaff443928065e611b14a0e95?tpId=195&tqId=39430
# [SHELL21] 格式化输出

# @nc code=start

# @nc code=start

# @nc code=start

#!/bin/bash

# Check if the input file exists
if [[ ! -f nowcoder.txt ]]; then
    echo "File nowcoder.txt not found!"
    exit 1
fi

# Read the file and format each line
while IFS= read -r line; do
    formatted_line=$(echo "$line" | sed ':a;s/\B[0-9]\{3\}\>/,&/;ta')
    echo "$formatted_line"
done < nowcoder.txt

exit 0

# @nc code=end

# @nc code=end
