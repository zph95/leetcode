# @nc app=nowcoder id=838a3acde92c4805a22ac73ca04e503b topic=195 question=36225 lang=Bash
# 2025-03-14 16:44:03
# https://www.nowcoder.com/practice/838a3acde92c4805a22ac73ca04e503b?tpId=195&tqId=36225
# [SHELL15] 去掉不需要的单词

# @nc code=start

#!/bin/bash

# 读取输入
while read line; do
    # 使用grep命令过滤掉含有B和b的单词
    filtered_line=$(echo $line | grep -oE '\b[^Bb ]+\b' | tr '\n' ' ')
    if [ -n "$filtered_line" ]; then
        echo $filtered_line
    fi
done

exit 0

# @nc code=end
