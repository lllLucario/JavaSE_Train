package arrayDemo;

public class CreatArray {
    //静态数组创建
    double[] socres = new double[] {99.5, 88.0, 75.5};
    int[] ages = new int[]  {12, 24, 36};
    String[] names = new String[] {"大黄","小王"};
    //简化版：
    //String[] names = {"大黄","小王"};

    //数组变量名中储存的是数组在内存中的地址；数组是引用类型

    //动态数组创建（初始化）
    int[] nums = new int [4];

    //动态与静态写法不能混用
    //int[] arrs = new int[3]{1, 2, 3, 4} --这样的写法是错误的
}
