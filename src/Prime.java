import java.util.Scanner;

public class Prime {
    //判断范围内共有多少质数
    public static void run() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input an integer:");
        int n = in.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++){
            if (isPrime(i)) {
                count++;
                //System.out.println(i);
            }
        }
        System.out.println(count);
    }

    public static boolean isPrime(int num) {
        int sqrt = (int)Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    //格式化输出练习
    public static void standardOutput() {
        String area, type, name, ceo, goods, unit;
        int money;
        Scanner in = new Scanner(System.in);
        System.out.println("请输入地名");
        area = in.nextLine();
        System.out.println("请输入公司类型");
        type = in.nextLine();
        System.out.println("请输入公司名");
        name = in.nextLine();
        System.out.println("请输入老板名字");
        ceo = in.nextLine();
        System.out.println("请输入金额");
        money = in.nextInt();
        in.nextLine();
        System.out.println("请输入商品");
        goods = in.nextLine();
        System.out.println("请输入单位");
        unit = in.nextLine();
        String line = "%s 最大%s %s 倒闭了，王八蛋老板%s 吃喝嫖赌，欠下了%d 个亿，带着他的小姨子跑了!我们没有办法，拿着%s 抵工资!原价都是一%s 多、两%s 多、三%s 多的%s ，现在全部只卖二十块，统统只要二十块!%s 王八蛋，你不是人!我们辛辛苦苦给你干了大半年，你不发工资，你还我血汗钱，还我血汗钱!%n";
        System.out.printf(line, area, type, name, ceo, money, goods, unit, unit, unit, goods, ceo);
    }
}
