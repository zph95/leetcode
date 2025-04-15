# @nc app=nowcoder id=3a3573822a854710a259d89066aad695 topic=195 question=39436 lang=Bash
# 2025-03-15 13:25:24
# https://www.nowcoder.com/practice/3a3573822a854710a259d89066aad695?tpId=195&tqId=39436
# [SHELL27] nginx日志分析5-统计爬虫抓取404的次数

# @nc code=start

#!/bin/bash

# 统计百度爬虫抓取404的次数
grep 'www.baidu.com/search/spider' nowcoder.txt | grep ' 404 ' | wc -l

exit 0

# @nc code=end
