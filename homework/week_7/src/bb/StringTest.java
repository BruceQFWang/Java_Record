package bb;

public class StringTest {
public static void main(String[] args) {
  StringTest st = new StringTest();
   st.testString();
}
/*
* ����String�ĳ��÷���
*/
public void testString(){
  String str = "This is a test string!";
  System.out.println("\n���ڱ����Ե��ַ���Ϊ��"+str);
  System.out.println("\n����length()�����ַ����ĳ���Ϊ��");
  int length = str.length();
  System.out.println(String.valueOf(length));
  System.out.println("\n����equals(Object o)�ж��ַ��������Ƿ���ͬ�����ַ���\"test\"���бȽϵĽ��Ϊ��");
  boolean b = str.equals("test");
  System.out.println(b?"���":"�����");
  System.out.println("equalsIgnoreCase(Object o)�Ƚ�\"test\"��\"Test\"�ȽϵĽ��:");
  b = "test".equalsIgnoreCase("Test");
  System.out.println(b?"���":"�����");
  System.out.println("\ncharAt(int index)������ĳ��λ�õ��ַ�");
  char c = str.charAt(5);
  System.out.println("\n�����ַ�����5��λ�õ��ַ�Ϊ��"+String.valueOf(c)+".ע��������0��ʼ");
  System.out.println("\n��ȡ�Ӵ�������subString(int fromindex)��substring(int fromindex,int endindex)");
  System.out.println("��һ��������fromindex��ʼ���ڶ���������fromindex��ʼ��endindex�������Ӵ���������0��ʼ,����fromindex��������endindex��");
  String strSub = str.substring(3);
  System.out.println("str.substring(3)�Ľ��Ϊ��"+strSub);
  strSub = str.substring(3,6);
  System.out.println("str.substring(3,6)�Ľ��Ϊ��"+strSub);
  System.out.println("\nȥ���ַ���ǰ����ߺ���Ŀո񣬿���ʹ��trim()������");
  System.out.println("�ַ���\"100 01 \"ԭ���ĳ���Ϊ��"+"100 01 ".length()+"ʹ��trim()����֮��ĳ���Ϊ��"+"100 01 ".trim().length());
  printContent("\n\n�ж�һ���ַ����ַ����е�λ�ã�����ʹ��indexOf(int ch)��indexOf(int ch,int from)����" +
"��\n��������ڷ���0����һ���������ַ�����ͷ���ң��ڶ���������formΪ�ÿ�ʼ���ң�������λ��");
  int index = str.indexOf('s');
  printMethod("str.indexOf('s')");
  printResult(String.valueOf(index));
  index = str.indexOf('s',6);
  printMethod("\nstr.indexOf('s',6)");
  printResult(String.valueOf(index));
  printContent("\n\n�ж�һ���ַ����ַ����е�λ�ã�����ʹ��indexOf(String str)��indexOf(String str,int from)����" +
"��\n��������ڷ���0����һ���������ַ�����ͷ���ң��ڶ���������formΪ�ÿ�ʼ���ң�������λ��");
  index = str.indexOf("is");
  printMethod("str.indexOf(\"is\")");
  printResult(String.valueOf(index));
  index = str.indexOf("is",3);
  printMethod("\nstr.indexOf(\"is\",3)");
  printResult(String.valueOf(index));
  index = str.indexOf("is",7);
  printMethod("\nstr.indexOf(\"is\",7)");
  printResult(String.valueOf(index));
  printContent("\n��indexOf�������ƣ�����lastIndexOf�������÷�������ͬ����ͬ���ǿ�ʼ���ҵ�λ�ò�ͬ��һ����ǰ��һ���Ӻ�");
  printContent("\n�ж��ַ����Ƿ���ĳ���Ӵ�Ϊ��׺��ʹ��endsWith(String str)");
  b = str.endsWith("test");
  printMethod("str.endsWith(\"test\")");
  printResult(String.valueOf(b));
  b = str.endsWith("string!");
  printMethod("\nstr.endsWith(\"string!\")");
  printResult(String.valueOf(b));
  printContent("\n\n��endsWith�����������ƣ�startWith(String prefix)��" +
"\nstartWith(String prefix,int toffset)�����ж��Ƿ���ĳ���Ӵ�Ϊǰ׺");
  printContent("\n\n�滻�ַ����е��ַ���ʹ��replace(char oldChar,char newChar)����");
  String str2 = str.replace('s','S');
  printMethod("str.replace('s','S')");
  printResult(str2);
  printContent("\n\n�滻�ַ����еĵ�һ�γ��ֵ�ĳ���ִ���ʹ��replaceFirst(String oldStr,String newStr)����");
  str2 = str.replaceFirst("is","IS");
  printMethod("str.replaceFirst(\"is\",\"IS\")");
  printResult(str2);
  printContent("\n\n�滻�ַ����е����еĳ��ֵ�ĳ���ִ���ʹ��replaceAll(String oldStr,String newStr)����");
  str2 = str.replaceAll("is","IS");
  printMethod("str.replaceAll(\"is\",\"IS\")");
  printResult(str2);
  printContent("\n\n���Ը���ĳ���ض��ĸ�ʽ���ַ����ֳɶ���Ӵ���ʹ��split����," +
"\nʹ�õĲ����ַ���Ϊzhangsan-lisi-wangwu");
  str2 = "zhangsan-lisi-wangwu";
  String strSplit[] = str2.split("-");
  printMethod("str.split(\"-\")");
  for(int i=0;i<strSplit.length;i++)
     printResult(strSplit[i]+"");
  }
  /*
    * ��ʾע�͵�����
  */
  public void printContent(String str){
    System.out.println(str);
  }
  /*
    * ��ʾ����
  */
  public void printMethod(String str){
     System.out.print(str);
     for(int i=0;i<30-str.length();i++)
     System.out.print("");
  }
  /*
   * ��ʾ���
  */
  public void printResult(String str){
     System.out.print(str);
   }
}
