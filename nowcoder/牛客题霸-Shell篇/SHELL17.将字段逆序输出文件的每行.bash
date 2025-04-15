# @nc app=nowcoder id=e33fff83fd384a21ba67f3104fb8d646 topic=195 question=39426 lang=Bash
# 2025-03-14 16:57:33
# https://www.nowcoder.com/practice/e33fff83fd384a21ba67f3104fb8d646?tpId=195&tqId=39426
# [SHELL17] 将字段逆序输出文件的每行

# @nc code=start

#!/bin/bash

# 读取文件并逆序输出每一行
while read -r line; do
    # 使用awk命令将每一行的字段逆序输出
    echo $line | awk -F: '{for(i=NF;i>1;i--) printf "%s:",$i; printf "%s\n",$1}'
done < nowcoder.txt

exit 0

# @nc code=end
