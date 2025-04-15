/**
 * @nc app=nowcoder id=a35ce98431874e3a820dbe4b2d0508b1 topic=37 question=21225 lang=Java
 * 2025-03-09 23:18:38
 * https://www.nowcoder.com/practice/a35ce98431874e3a820dbe4b2d0508b1?tpId=37&tqId=21225
 * [HJ2] 计算某字符出现次数
 */

/** @nc code=start */

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}

/** @nc code=end */
