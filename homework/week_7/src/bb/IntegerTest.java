package bb;

public class IntegerTest {
    public static void main(String[] args) {
        System.out.println("Integer�еĳ���****************************");
        System.out.println("Integer�����ȡֵ��\t"+Integer.MAX_VALUE);
        System.out.println("Integer����Сȡֵ��\t"+Integer.MIN_VALUE);
        System.out.println("Integer�����λ����(�Զ����Ʋ�����ʽ��ʾ int ֵ��λ����)\t"+Integer.SIZE);
        System.out.println("Integer�����͵ģ�\t"+Integer.TYPE);

        System.out.println();
        System.out.println("*************Integer�з�����ʹ��*************");
        int i=12345;
        System.out.println("12345�Ķ����Ʊ�ʾ��\t"+Integer.toBinaryString(i));
        System.out.println("12345�Ķ����ƴ��С�1������������\t"+Integer.bitCount(i));
        /**
         * numberOfLeadingZeros���㷽��Ϊ��32(Integer.SIZE)-Integer.toBinaryString(12345).length()
         */
        System.out.println("12345�Ķ����ƴ��д���������������ġ�0������������\t"+Integer.numberOfLeadingZeros(i));
        System.out.println("12345�Ķ����ƴ��д����ұ����������ġ�0������������\t"+Integer.numberOfTrailingZeros(i));
        /**
         * Integer decode(String nm) 
         * ����һ��10���ƣ�8���ƣ�16�������κ�һ�ֽ��Ƶ��ַ�����
         * �÷������Խ�������ַ���ת��Ϊ10�������ֵ�Integer���Ͳ����ء�
         */
        System.out.println("8�İ˽���Ϊ010��ת��Ϊ10���ƣ�\t"+Integer.decode("010"));
        System.out.println("10��ʮ����Ϊ10��ת��Ϊ10���ƣ�\t"+Integer.decode("10"));
        System.out.println("16��ʮ������ Ϊ0X10��ת��Ϊ10���ƣ�\t"+Integer.decode("0X10"));
        System.out.println("1000��ת���������Ʋ����λ˳��\t"+Integer.reverse(i));
        System.out.println("1000��ת�����ֽڵ�˳��\t"+Integer.reverseBytes(i));
        /**
         * ��ȡ�������ţ�Ϊ������-1��������1���㷵��0
         */
        System.out.println("12345��ȡ��������Ϊ��\t"+Integer.signum(i));
        System.out.println("����12345��Integer����\t"+Integer.valueOf(i));
        System.out.println("Integer.valueOf�����ʹ��(12345��radix������)��\t"+Integer.valueOf("12345", 10));

        System.out.println();
        System.out.println("*************Integer����ķ���ʹ��*****************");
        Integer obj=new Integer(1000);
        System.out.println("1000ת��Ϊbyte���͵���Ϊ��\t"+obj.byteValue());
        System.out.println("Integer1000��Integer2000��С�Ƚϣ�\t"+obj.compareTo(new Integer(2000)));
        System.out.println("Integer2000��Integer1000��С�Ƚϣ�\t"+new Integer(2000).compareTo(obj));
        System.out.println("Integer1000ת��Ϊdouble���͵���Ϊ��\t"+obj.doubleValue());
        System.out.println("Integer1000��Integer2000��С�Ƚϣ�\t"+obj.equals(new Integer(2000)));
        System.out.println("Integer2000��Integer1000��С�Ƚϣ�\t"+new Integer(2000).equals(obj));
        System.out.println("Integer2000��Integer1000��С�Ƚϣ�\t"+new Integer(2000).equals(new Integer(2000)));
        System.out.println("Integer1000�Ĺ�ϣ�룺\t"+obj.hashCode());
        System.out.println("Integer1000��intֵ��\t"+obj.intValue());
        System.out.println("Integer1000��longֵ��\t"+obj.longValue());
        System.out.println("Integer1000��shortֵ��\t"+obj.shortValue());
        System.out.println("���ַ���1000����Ϊint���͵�����\t"+Integer.parseInt("1000"));
        /**
         * Integer.parseInt("1000", 2)
         * ���ص�һ��������(�ַ���)��2����(����2Ϊת���Ľ���)
         */
        System.out.println("����1000��2����"+Integer.parseInt("1000", 2));
        /**
         * ����ת��
         */
        System.out.println("1000ʮ����ת�ɶ�����"+Integer.toBinaryString(i));
        System.out.println("1000ʮ����ת�˽��ƣ�\t"+Integer.toOctalString(i));
        System.out.println("1000ʮ����תʮ�����ƣ�\t"+Integer.toHexString(i));
        System.out.println("ʮ������ת��ʮ����:\t"+Integer.valueOf("FFFF",16).toString());
        System.out.println("ʮ������ת�ɶ�����:\t"+Integer.toBinaryString(Integer.valueOf("FFFF",16)));
        System.out.println("ʮ������ת�ɰ˽���:\t"+Integer.toOctalString(Integer.valueOf("FFFF",16)));

        System.out.println("�˽���ת��ʮ����:\t"+Integer.valueOf("576",8).toString());
        System.out.println("�˽���ת�ɶ�����:\t"+Integer.toBinaryString(Integer.valueOf("23",8)));
        System.out.println("�˽���ת��ʮ������:\t"+Integer.toHexString(Integer.valueOf("23",8)));

        System.out.println("������תʮ����:\t"+Integer.valueOf("0101",2).toString());
        System.out.println("������ת�˽���:\t"+Integer.toOctalString(Integer.parseInt("0101", 2)));
        System.out.println("������תʮ������:\t"+Integer.toHexString(Integer.parseInt("0101", 2)));

        System.out.println();
        System.out.println("1000�Ķ�������ʽ����ߵ����һλ�Ҹ�λ����ȫ�����㣬��󷵻�int�͵Ľ��"+Integer.highestOneBit(i));

    }
}
