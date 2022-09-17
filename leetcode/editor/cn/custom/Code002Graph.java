package cn.custom;

import java.util.ArrayList;

public class Code002Graph {

    public static void main(String[] args) {
        System.out.println("hello world!");
        Code002Graph.SolutionWolfProblem solution = new Code002Graph().new SolutionWolfProblem();
        solution.wolfProblem();
        System.out.println(solution.result());
    }

    /**
     * 农夫需要把狼、羊、菜和自己运到河对岸去，
     * 只有农夫能划船，而且船比较小。除了农夫之外每次只能运一种东西。
     * 还有一个棘手的问题，就是如果没有农夫看着，羊会偷吃菜，狼会吃羊。
     * 请考虑一种方法，让农夫能够安全地安排这些东西和他自己过河。
     */
    class SolutionWolfProblem {


        public void wolfProblem() {
        }


        public Iterable<Integer> result() {
            ArrayList<Integer> result = new ArrayList<>();
            return result;
        }

    }
}
