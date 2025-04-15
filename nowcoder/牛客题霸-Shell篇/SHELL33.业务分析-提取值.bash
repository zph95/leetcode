# @nc app=nowcoder id=f144e52a3e054426a4d265ff38399748 topic=195 question=39442 lang=Bash
# 2025-03-15 15:25:09
# https://www.nowcoder.com/practice/f144e52a3e054426a4d265ff38399748?tpId=195&tqId=39442
# [SHELL33] 业务分析-提取值

# @nc code=start

#!/bin/bash

log_file="nowcoder.txt"

server_version=$(grep "Server version" "$log_file" | awk -F: '{print $4}')
server_number=$(grep "Server number" "$log_file" | awk -F: '{print $4}')
os_name=$(grep "OS Name" "$log_file" | awk -F: '{print $4}' | awk -F, '{print $1}')
os_version=$(grep "OS Version" "$log_file" | awk -F: '{print $5}')

echo "serverVersion:$server_version"
echo "serverName:$server_number"
echo "osName:$os_name"
echo "osVersion:$os_version"

exit 0

# @nc code=end
