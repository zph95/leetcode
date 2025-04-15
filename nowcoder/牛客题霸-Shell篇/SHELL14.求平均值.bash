# @nc app=nowcoder id=c44b98aeaf9942d3a61548bff306a7de topic=195 question=36224 lang=Bash
# 2025-03-14 16:41:00
# https://www.nowcoder.com/practice/c44b98aeaf9942d3a61548bff306a7de?tpId=195&tqId=36224
# [SHELL14] 求平均值

# @nc code=start

#!/bin/bash

# 读取数组长度
read N

sum=0

# 读取数组元素并计算总和
for (( i=0; i<N; i++ ))
do
    read num
    sum=$(($sum + $num))
done

# 计算平均值
average=$(echo "scale=3; $sum / $N" | bc)

# 输出平均值
echo $average

exit 0

# @nc code=end
