# @nc app=nowcoder id=ad7b6dbfab2a4267a9991110c57aa64f topic=195 question=39425 lang=Bash
# 2025-03-14 16:51:31
# https://www.nowcoder.com/practice/ad7b6dbfab2a4267a9991110c57aa64f?tpId=195&tqId=39425
# [SHELL16] 判断输入的是否为IP地址

# @nc code=start

#!/bin/bash

# 定义一个函数来验证IP地址
is_valid_ip() {
    local ip=$1
    local IFS=.
    local -a octets=($ip)

    # 检查是否有4个八位字节
    if [ ${#octets[@]} -ne 4 ]; then
        return -1
    fi

    # 检查每个八位字节是否在0到255之间
    for octet in "${octets[@]}"; do
        if ! [[ $octet =~ ^[0-9]+$ ]] || [ $octet -lt 0 ] || [ $octet -gt 255 ]; then
            return 1
        fi
    done

    return 0
}

# 读取文件并检查每一行
while read -r line; do
    is_valid_ip "$line"
    result=$?
    if [ $result -eq 0 ]; then
        echo "yes"
    elif [ $result -eq 1 ]; then
        echo "no"
    else
        echo "error"
    fi
done < nowcoder.txt

exit 0

# @nc code=end
