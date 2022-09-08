package cn;

import java.util.*;
import java.util.stream.Collector;

public class Code001Graph {
    public static void main(String[] args) {
        System.out.println("hello world!");
        SolutionBucketProblem solution = new Code001Graph().new SolutionBucketProblem();
        solution.bucketProblem();
        System.out.println(solution.result());
    }

    /**
     * 有两个水桶，一个装5升，一个装3升
     * 每次只能装一个水桶，必须装满，且水桶之间的水可以相互转移
     * 怎么利用两个水桶，得到4升的水
     */
    class SolutionBucketProblem {
        private int[] pre;
        private int end = -1;

        public void bucketProblem() {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[100];
            pre = new int[100];

            queue.add(0);
            visited[0] = true;

            while (!queue.isEmpty()) {
                int current = queue.remove();
                // todo 状态解压缩
                int a = current / 10, b = current % 10;

                // max a = 5; max b = 3;
                ArrayList<Integer> nexts = new ArrayList<>();
                nexts.add(5 * 10 + b); // a 倒满
                nexts.add(a * 10 + 3); // b 倒满
                nexts.add(0 * 10 + b); // a 倒空
                nexts.add(a * 10 + 0); // b 倒空
                int x = Math.min(a, 3 - b); // a 可以倒多少水到 b
                nexts.add((a - x) * 10 + (b + x));
                int y = Math.min(5 - a, b); // b 可以倒多少水到 a
                nexts.add((a + y) * 10 + (b - y));

                // todo next
                for (int next : nexts) {
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                        pre[next] = current;
                        if (next / 10 == 4 || next % 10 == 4) {
                            end = next;
                            return;
                        }
                    }
                }
            }
        }

        public Iterable<Integer> result() {
            ArrayList<Integer> result = new ArrayList<>();
            if (end == -1) {
                return result;
            }
            int cur = end;
            while (cur != 0) {
                result.add(cur);
                cur = pre[cur];
            }
            result.add(0);
            Collections.reverse(result);
            return result;
        }
    }
}
