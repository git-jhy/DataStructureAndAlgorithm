package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _1491_Average_Salary_Excluding_the_Minimum_and_Maximum_Salary {

    /*Given an array of unique integers salary where salary[i] is the salary of the employee i.

    Return the average salary of employees excluding the minimum and maximum salary.

    Example 1:

    Input: salary = [4000,3000,1000,2000]
    Output: 2500.00000
    Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
    Average salary excluding minimum and maximum salary is (2000+3000)/2= 2500
    Example 2:

    Input: salary = [1000,2000,3000]
    Output: 2000.00000
    Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
    Average salary excluding minimum and maximum salary is (2000)/1= 2000
    Example 3:

    Input: salary = [6000,5000,4000,3000,2000,1000]
    Output: 3500.00000
    Example 4:

    Input: salary = [8000,9000,2000,3000,6000,1000]
    Output: 4750.00000


    Constraints:

            3 <= salary.length <= 100
            10^3 <= salary[i] <= 10^6
    salary[i] is unique.
    Answers within 10^-5 of the actual value will be accepted as correct.*/

    /**
     * 去掉最低工资和最高工资后的工资平均值
     * 思路：先排序，然后去掉头尾求和再求平均值
     * @param salary
     * @return
     */
    public double average(int[] salary) {
        Arrays.sort(salary);
        double sum = 0;
        for (int i=1;i<salary.length-1;i++){
            sum+=salary[i];
        }
        return sum/(salary.length-2);
    }

    public static void main(String[] args) {
        _1491_Average_Salary_Excluding_the_Minimum_and_Maximum_Salary test = new _1491_Average_Salary_Excluding_the_Minimum_and_Maximum_Salary();
        System.out.println(test.average(new int[]{4000,3000,1000,2000}));
        System.out.println(test.average(new int[]{1000,2000,3000}));
        System.out.println(test.average(new int[]{6000,5000,4000,3000,2000,1000}));
        System.out.println(test.average(new int[]{8000,9000,2000,3000,6000,1000}));
    }
}
