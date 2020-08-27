package com.cy.algorithm.day4;

import java.util.*;

/**
 * Created by Yang on 2020/8/27.
 */
public class FindItinerary {

    /**
     * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。

     说明:

     如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
     所有的机场都用三个大写字母表示（机场代码）。
     假定所有机票至少存在一种合理的行程。
     示例 1:

     输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
     输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
     示例 2:

     输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
     解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。


     */

    public List<String> findItinerary(List<List<String>> tickets) {
        // 因为逆序插入，所以用链表
        List<String> ans = new LinkedList<>();
        if (tickets == null || tickets.size() == 0)
            return ans;
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> pair : tickets) {
            // 因为涉及删除操作，我们用链表
            List<String> nbr = graph.computeIfAbsent(pair.get(0), k -> new LinkedList<>());
            nbr.add(pair.get(1));
        }
        // 按目的顶点排序
        graph.values().forEach(x -> x.sort(String::compareTo));
        visit(graph, "JFK", ans);
        return ans;
    }
    // DFS方式遍历图，当走到不能走为止，再将节点加入到答案
    private void visit(Map<String, List<String>> graph, String src, List<String> ans) {
        List<String> nbr = graph.get(src);
        while (nbr != null && nbr.size() > 0) {
            String dest = nbr.remove(0);
            visit(graph, dest, ans);
        }
        ans.add(0, src); // 逆序插入
    }

    public static void main(String[] args) {
        /**
         * [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
         */
        List<List<String>> tickets = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("MUC");
        list1.add("LHR");
        tickets.add(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("JFK");
        list2.add("MUC");
        tickets.add(list2);
        List<String> list3 = new ArrayList<>();
        list3.add("SFO");
        list3.add("SJC");
        tickets.add(list3);
        List<String> list4 = new ArrayList<>();
        list4.add("LHR");
        list4.add("SFO");
        tickets.add(list4);
        FindItinerary f = new FindItinerary();
        f.findItinerary(tickets);
    }

}
