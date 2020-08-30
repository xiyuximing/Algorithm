package com.cy.algorithm.day7;

/**
 * Created by Yang on 2020/8/30.
 */
public class ReverseWords {

    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer(s.length());
        for (String ss : s.split(" ")) {
            sb.append(new StringBuffer(ss).reverse()).append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}
