package com.sevenmin.transnum;

import java.util.Scanner;

public class TransNum{
    public static void main(String agrs[]) throws Exception {
        System.out.println("请输入要转换的数字");
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        transNum(num);
    }



    private static void transNum(String num) throws Exception {
        //校验用户输入的是否为数字
        for (int i = 0; i < num.length() ; i++) {
            char c = num.charAt(i);
            if(c<48||c>59) throw new Exception("请输入数字");
        }
        //Money用于存放输入的金额数
        long Money=0;
        String Mon[]={"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
        String Mon1[]={"拾","佰","仟","万","拾万","百万","仟万","亿","拾亿","百亿","仟亿"};
        String transAfter[]=new String[30];//transAfter[]数组用于存放数字金额被转换后的数字
        //n用于测试您是否有金额转换
        int n=num.length();
        if(n==0)
            throw new Exception("请输入正确的数字");
            //将输入的金额转化成long型的数据
        else
        {
            Money=Long.parseLong(num);
        }
        //bitt用于存放第几个需转换的金额数字，
        int bitt=0,j,k=-1,i=0;
        //转换过程
        while(Money!=0)
        {
            bitt=(int)(Money%10L);
            //计算出每个数字对应的大写值
            for(j=0;j<Mon.length;j++)
            {
                if(j==bitt)break;
            }
            //将相应的值存入transAfter[]中
            if(k!=-1){transAfter[i]=Mon1[k];i++;}
            transAfter[i]=Mon[j];i++;
            Money=Money/10;
            k++;
            if(Money==0)
            {
                //输出转换后的金额
                System.out.print("您输入的金额为：");
                i--;
                for(;i>=0;i--)
                    System.out.print(transAfter[i]);
            }
        }
    }

}
