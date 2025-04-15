public class 十进制转36进制 {
    public String numToChar = "0123456789abcdefghijklmnopqrstuvwxyz";

    public String to36(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(numToChar.charAt(num % 36));
            num /= 36;
        }
        return sb.reverse().toString();
    
    }

    public static void main(String[] args) {
        十进制转36进制 s = new 十进制转36进制();
        System.out.println(s.to36(14));
    }
}
