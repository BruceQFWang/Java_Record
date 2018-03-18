package bb;

public class IntegerTest {
    public static void main(String[] args) {
        System.out.println("Integer中的常量****************************");
        System.out.println("Integer的最大取值：\t"+Integer.MAX_VALUE);
        System.out.println("Integer的最小取值：\t"+Integer.MIN_VALUE);
        System.out.println("Integer的最大位数：(以二进制补码形式表示 int 值的位数。)\t"+Integer.SIZE);
        System.out.println("Integer的类型的：\t"+Integer.TYPE);

        System.out.println();
        System.out.println("*************Integer中方法的使用*************");
        int i=12345;
        System.out.println("12345的二进制表示：\t"+Integer.toBinaryString(i));
        System.out.println("12345的二进制串中“1”的总数量：\t"+Integer.bitCount(i));
        /**
         * numberOfLeadingZeros计算方法为：32(Integer.SIZE)-Integer.toBinaryString(12345).length()
         */
        System.out.println("12345的二进制串中从最左边算起连续的“0”的总数量：\t"+Integer.numberOfLeadingZeros(i));
        System.out.println("12345的二进制串中从最右边算起连续的“0”的总数量：\t"+Integer.numberOfTrailingZeros(i));
        /**
         * Integer decode(String nm) 
         * 给定一个10进制，8进制，16进制中任何一种进制的字符串，
         * 该方法可以将传入的字符串转化为10进制数字的Integer类型并返回。
         */
        System.out.println("8的八进制为010，转换为10进制：\t"+Integer.decode("010"));
        System.out.println("10的十进制为10，转换为10进制：\t"+Integer.decode("10"));
        System.out.println("16的十六进制 为0X10，转换为10进制：\t"+Integer.decode("0X10"));
        System.out.println("1000反转整数二进制补码的位顺序：\t"+Integer.reverse(i));
        System.out.println("1000反转整数字节的顺序：\t"+Integer.reverseBytes(i));
        /**
         * 获取整数符号，为负返回-1，正返回1，零返回0
         */
        System.out.println("12345获取整数符号为：\t"+Integer.signum(i));
        System.out.println("创建12345的Integer对象：\t"+Integer.valueOf(i));
        System.out.println("Integer.valueOf对象的使用(12345的radix进制数)：\t"+Integer.valueOf("12345", 10));

        System.out.println();
        System.out.println("*************Integer对象的方法使用*****************");
        Integer obj=new Integer(1000);
        System.out.println("1000转换为byte类型的数为：\t"+obj.byteValue());
        System.out.println("Integer1000和Integer2000大小比较：\t"+obj.compareTo(new Integer(2000)));
        System.out.println("Integer2000和Integer1000大小比较：\t"+new Integer(2000).compareTo(obj));
        System.out.println("Integer1000转换为double类型的数为：\t"+obj.doubleValue());
        System.out.println("Integer1000和Integer2000大小比较：\t"+obj.equals(new Integer(2000)));
        System.out.println("Integer2000和Integer1000大小比较：\t"+new Integer(2000).equals(obj));
        System.out.println("Integer2000和Integer1000大小比较：\t"+new Integer(2000).equals(new Integer(2000)));
        System.out.println("Integer1000的哈希码：\t"+obj.hashCode());
        System.out.println("Integer1000的int值：\t"+obj.intValue());
        System.out.println("Integer1000的long值：\t"+obj.longValue());
        System.out.println("Integer1000的short值：\t"+obj.shortValue());
        System.out.println("将字符串1000解析为int类型的数：\t"+Integer.parseInt("1000"));
        /**
         * Integer.parseInt("1000", 2)
         * 返回第一个参数的(字符串)的2进制(参数2为转换的进制)
         */
        System.out.println("返回1000的2进制"+Integer.parseInt("1000", 2));
        /**
         * 进制转换
         */
        System.out.println("1000十进制转成二进制"+Integer.toBinaryString(i));
        System.out.println("1000十进制转八进制：\t"+Integer.toOctalString(i));
        System.out.println("1000十进制转十六进制：\t"+Integer.toHexString(i));
        System.out.println("十六进制转成十进制:\t"+Integer.valueOf("FFFF",16).toString());
        System.out.println("十六进制转成二进制:\t"+Integer.toBinaryString(Integer.valueOf("FFFF",16)));
        System.out.println("十六进制转成八进制:\t"+Integer.toOctalString(Integer.valueOf("FFFF",16)));

        System.out.println("八进制转成十进制:\t"+Integer.valueOf("576",8).toString());
        System.out.println("八进制转成二进制:\t"+Integer.toBinaryString(Integer.valueOf("23",8)));
        System.out.println("八进制转成十六进制:\t"+Integer.toHexString(Integer.valueOf("23",8)));

        System.out.println("二进制转十进制:\t"+Integer.valueOf("0101",2).toString());
        System.out.println("二进制转八进制:\t"+Integer.toOctalString(Integer.parseInt("0101", 2)));
        System.out.println("二进制转十六进制:\t"+Integer.toHexString(Integer.parseInt("0101", 2)));

        System.out.println();
        System.out.println("1000的二进制形式最左边的最高一位且高位后面全部补零，最后返回int型的结果"+Integer.highestOneBit(i));

    }
}
