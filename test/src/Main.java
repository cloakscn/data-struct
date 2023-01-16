import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    /**
     * 小组对象
     */
    static class Group {
        /**
         * constructor method
         * @param name     队伍名称
         * @param rate     获胜赔率
         * @param equals   平局赔率
         * @param deadline 金额上限
         */
        public Group(String name, Float rate, Float equals, int deadline) {
            this.name = name;
            this.rate = rate;
            this.equals = equals;
            this.result = new HashMap<>();
            this.moneyArray = new int[deadline];
            for (int i = 0; i < deadline; i++) {
                this.moneyArray[i] = i + 1;
            }
            this.getMoney();
        }

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private Float rate;

        public Float getRate() {
            return rate;
        }

        public void setRate(Float rate) {
            this.rate = rate;
        }

        private Float equals;

        public Float getEquals() {
            return equals;
        }

        public void setEquals(Float equals) {
            this.equals = equals;
        }

        private int[] moneyArray;

        public Map<String, Map<String, Float>> getResult() {
            return result;
        }

        public void setResult(Map<String, Map<String, Float>> result) {
            this.result = result;
        }

        private Map<String, Map<String, Float>> result;

        private void getMoney() {
            Map<String, Float> Y = new HashMap<>();
            Map<String, Float> E = new HashMap<>();
            for (int i : moneyArray) {
                for (int j : moneyArray) {
                    for (int k : moneyArray) {
                        Y.put(i + "-" + j + "-" + k, (i * (rate - 1) - (j + k)));
                        E.put(i + "-" + j + "-" + k, (j * (equals - 1) - (i + k)));
                    }
                }
            }
            result.put("Y", Y);
            result.put("E", E);
        }

        public void getResultY() {
            Map<String, Float> y = result.get("Y");
            int index = 0;
            for (Map.Entry<String, Float> entry : y.entrySet()) {
                if (entry.getValue() > 0) {
                    System.out.println(index++ + ":" + entry.getKey() + ":" + entry.getValue());
                }
            }
        }

        public void getResultE() {
            Map<String, Float> y = result.get("E");
            int index = 0;
            for (Map.Entry<String, Float> entry : y.entrySet()) {
                if (entry.getValue() > 0) {
                    System.out.println(index++ + ":" + entry.getKey() + ":" + entry.getValue());
                }
            }
        }

        @Override
        public String toString() {
            return "Group{" +
                    "name='" + name + '\'' +
                    ", rate=" + rate +
                    ", equals=" + equals +
                    ", result=" + result +
                    '}';
        }

    }

    public static void main(String[] args) {
        int baseline = 305;
        int threshold = -300;
        int baseMoney = 300 / 3;
        Group first = new Group("巴西", 1.26f, 4.70f, baseMoney);
        Group second = new Group("塞尔维亚", 7.5f, 4.70f, baseMoney);
        calculator(first, second, baseline, threshold);
    }

    private static void calculator(Group first, Group second, int baseline, int threshold) {

        Map<String, Map<String, Float>> firstResult = first.getResult();
        Map<String, Map<String, Float>> secondResult = second.getResult();

        Map<String, Float> firstY = firstResult.get("Y");
        Map<String, Float> e = firstResult.get("E");
        Map<String, Float> secondY = secondResult.get("Y");

        System.out.printf("%s: %.2f, %s: %.2f, 平: %.2f\n"
                , first.getName(), first.getRate()
                , second.getName(), second.getRate()
                , first.getEquals());
        for (Map.Entry<String, Float> entry : firstY.entrySet()) {
            String key = entry.getKey();
            String key1 = reverse(key);

            if (e.containsKey(key)
                    && secondY.containsKey(key1)
                    && entry.getValue() >= threshold
                    && e.get(key) >= threshold
                    && secondY.get(key1) >= threshold
                    && (((entry.getValue() >= baseline) && (e.get(key) >= baseline))
                    || ((e.get(key) >= baseline) && (secondY.get(key1) >= baseline))
                    || ((entry.getValue() >= baseline) && (secondY.get(key1) >= baseline))
            )
            ) {
                System.out.printf("%-10s%s:%.2f\t平:%.2f\t%s:%.2f\n", key
                        , first.getName(), entry.getValue()
                        , e.get(key)
                        , second.getName(), secondY.get(key1));
            }
        }
    }

    private static String reverse(String key) {
        String[] split = key.split("-");
        String temps;
        temps = split[0];
        split[0] = split[2];
        split[2] = temps;
        return String.join("-", split);
    }
}