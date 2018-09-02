package com.github.junyu.solution.leetCode.easy.greedy;

import java.util.HashMap;

public class _860_Lemonade_Change {

   /* At a lemonade stand, each lemonade costs $5.

    Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).

    Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  
    You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.

    Note that you don't have any change in hand at first.

    Return true if and only if you can provide every customer with correct change.



    Example 1:

    Input: [5,5,5,10,20]
    Output: true
    Explanation:
    From the first 3 customers, we collect three $5 bills in order.
    From the fourth customer, we collect a $10 bill and give back a $5.
    From the fifth customer, we give a $10 bill and a $5 bill.
    Since all customers got correct change, we output true.
    Example 2:

    Input: [5,5,10]
    Output: true
    Example 3:

    Input: [10,10]
    Output: false
    Example 4:

    Input: [5,5,10,10,20]
    Output: false
    Explanation:
    From the first two customers in order, we collect two $5 bills.
    For the next two customers in order, we collect a $10 bill and give back a $5 bill.
    For the last customer, we can't give change of $15 back because we only have two $10 bills.
    Since not every customer received correct change, the answer is false.


    Note:

            0 <= bills.length <= 10000
    bills[i] will be either 5, 10, or 20.*/

//    /**
//     * 柠檬水找零，买一杯水要5块，如果顾客给5块就不需要找零，如果给10块要找5块，给20就要找15块，商家开始手上没有任何钱，
//     * 问题求最后能不能找开所有顾客的钱。
//     * 使用hashMap保存现有的零头数量。
//     * 将情况分为3种情况，
//     * 支付5块，那么不需要找零，直接将5的数量+1
//     * 支付10块，那么需要判断map里是否有5块剩余，如果没有直接false，有的话5的数量-1，然后增加10的数量。
//     * 支付20块，有两种方式，一种是10+5的组合，另一种是5+5+5，如果剩余不够这个组合，返回false
//     *
//     *
//     * @param bills
//     * @return
//     */
//    public boolean lemonadeChange(int[] bills) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < bills.length; i++) {
//            if (bills[i] == 5) {
//                if (map.containsKey(5)) {
//                    map.put(5, map.get(5) + 1);
//                } else {
//                    map.put(5, 1);
//                }
//            } else if (bills[i] == 10) {
//                if (map.containsKey(5) && map.get(5) > 0) {
//                    map.put(5, map.get(5) - 1);
//                    if (map.containsKey(10)) {
//                        map.put(10, map.get(10) + 1);
//                    } else {
//                        map.put(10, 1);
//                    }
//                } else {
//                    return false;
//                }
//            } else {//20
//                //判断10 5 和 5 5 5
//                if (map.containsKey(10) && map.get(10) > 0) {
//                    if (map.containsKey(5) && map.get(5) > 0) {
//                        map.put(10, map.get(10) - 1);
//                        map.put(5, map.get(5) - 1);
//                    } else {
//                        return false;
//                    }
//                } else if (map.containsKey(5) && map.get(5) >= 3) {
//                    map.put(5, map.get(5) - 3);
//                } else {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }


    /**
     * solution2
     * 其实不需要使用map，通过定义两个变量fiveBill和tenBill保存手头的剩余数量就可以，减少了
     * map的查找。整个判断逻辑和solution1是一致的
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int fiveBill = 0;
        int tenBill = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveBill++;
            } else if (bills[i] == 10) {
                if (fiveBill > 0) {
                    fiveBill--;
                    tenBill++;
                } else {
                    return false;
                }
            } else {//20
                //判断10 5 和 5 5 5
                if (tenBill > 0) {
                    if (fiveBill > 0) {
                        fiveBill--;
                        tenBill--;
                    } else {
                        return false;
                    }
                } else if (fiveBill >= 3) {
                    fiveBill -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _860_Lemonade_Change().lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        System.out.println(new _860_Lemonade_Change().lemonadeChange(new int[]{5, 5, 10}));
        System.out.println(new _860_Lemonade_Change().lemonadeChange(new int[]{10, 10}));
        System.out.println(new _860_Lemonade_Change().lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    }

}
