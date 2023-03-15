import java.util.ArrayDeque;
import java.util.Arrays;

public class GraphsTreesCode {

    public static void main(String[] args) {

//        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
//        var n1 = new Node(1); // 2^0 - 1 slot
//
//        var n2 = new Node(2);  // 2^1 - 2 slots
//        n1.left = n2;
//
//        var n3 = new Node(3); // 2^1 - 2 slots
//        n1.right = n3;
//
//        var n4 = new Node(4);  // 2^2 - 4 slots
//        n2.left = n4;
//
//        var n5 = new Node(5); // 2^2 - 4 slots
//        n2.right = n5;
//
//        var n6 = new Node(6);  // 2^2 - 4 slots
//        n3.left = n6;
//
//        var n7 = new Node(7);  // 2^2 - 4 slots
//        n3.right = n7;

        var n8 = new Node(8);
        var n9 = new Node(9);
        var n10 = new Node(10);
        var n11 = new Node(11);
        var n12 = new Node(12);
        var n13 = new Node(13);
        var n14 = new Node(14);
        var n15 = new Node(15);

        var n4 = new Node(4);
        n4.left = n8;
        n4.right = n9;

        var n5 = new Node(5);
        n5.left = n10;
        n5.right = n11;

        var n6 = new Node(6);
        n6.left = n12;
        n6.right = n13;

        var n7 = new Node(7);
        n7.left = n14;
        n7.right = n15;

        var n2 = new Node(2);
        n2.left = n4;
        n2.right = n5;

        var n3 = new Node(3);
        n3.left = n6;
        n3.right = n7;


        var n1 = new Node(1);
        n1.left = n2;
        n1.right = n3;

        System.out.println("pre");
        pre(n1);
        System.out.println("bfs");
        bfs(n1);
    }

    static class Node {
        public Node left;
        public Node right;
        public int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }


    public static void pre(Node n) {
        if (n == null) return;
        System.out.println(n.value);
        pre(n.left);
        pre(n.right);
    }

    public static void bfs(Node n) {
        if (n == null) return;
        ArrayDeque<Node> nodes = new ArrayDeque<>();
        nodes.add(n);

        while(! nodes.isEmpty()) {
            var currentN = nodes.remove();
            System.out.println(currentN.value);

            if (currentN.left != null) {
                nodes.add(currentN.left);
            }
            if (currentN.right != null) {
                nodes.add(currentN.right);
            }


        }

    }

}
