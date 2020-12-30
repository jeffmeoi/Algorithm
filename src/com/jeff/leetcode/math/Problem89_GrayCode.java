package com.jeff.leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class Problem89_GrayCode {


    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        int front = 1;
        for(int i = 0; i < n; i++) {
            for(int j = res.size() - 1; j >= 0; j--) {
                res.add(front+ res.get(j));
            }
            front <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem89_GrayCode problem89_grayCode = new Problem89_GrayCode();
        System.out.println(problem89_grayCode.grayCode(2));
        System.out.println(problem89_grayCode.grayCode(3));
        System.out.println(problem89_grayCode.grayCode(4));
    }
}
