package basic_class.class05;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入： 参数1，正数数组costs 参数2，正数数组profits参数3，正数k 参数4，正数m
 * costs[i]表示i号项目的花费
 * profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
 * k表示你不能并行、只能串行的最多做k个项目
 * m表示你初始的资金
 * 说明：你每做完一个项目，马上获得的收益，可以支持你去做下一个项目。
 * 输出：你最后获得的最大钱数。
 */
public class Code_03_IPO {
    public static class Node{
        public int cost;
        public int profit;

        public Node(int cost, int profit){
            this.cost = cost;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "cost=" + cost +
                    ", profit=" + profit +
                    '}';
        }
    }

    // 小根堆中cost小的放前面
    public static class MinCostComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost - o2.cost;
        }
    }

    // 大根堆中profit大的放前面
    public static class MaxProfitComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.profit - o1.profit;
        }
    }

    public static int findMaximizedCapital(int[] costs, int[] profits, int k, int m){
        Node[] nodes = new Node[costs.length];
        for(int i=0; i<costs.length; i++){
            nodes[i] = new Node(costs[i], profits[i]);
        }
        PriorityQueue<Node> minCostQueue = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQueue = new PriorityQueue<>(new MaxProfitComparator());
        for(int i=0; i<nodes.length; i++)
            minCostQueue.add(nodes[i]);
        for(int i=0; i<k; i++){
            while (!minCostQueue.isEmpty() && minCostQueue.peek().cost <= m){
                maxProfitQueue.add(minCostQueue.poll());
            }
            if(maxProfitQueue.isEmpty())
                return m;
            m += maxProfitQueue.poll().profit;
        }
        return m;
    }

    public static void main(String[] args) {
        PriorityQueue<Node> minNodes = new PriorityQueue<>(new MinCostComparator());
        minNodes.add(new Node(1, 3));
        minNodes.add(new Node(2, 8));
        while(minNodes.size() > 0)
            System.out.println(minNodes.poll());

        System.out.println("=================================================");

        PriorityQueue<Node> maxNodes = new PriorityQueue<>(new MaxProfitComparator());
        maxNodes.add(new Node(1, 3));
        maxNodes.add(new Node(2, 8));
        while(maxNodes.size() > 0)
            System.out.println(maxNodes.poll());

    }


}
