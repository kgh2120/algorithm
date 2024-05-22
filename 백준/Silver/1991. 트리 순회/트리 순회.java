import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Node[] tree;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		int n = Integer.parseInt(br.readLine());
		tree = new Node[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String value = st.nextToken();

			Node node = new Node(value);
			tree[value.charAt(0) - 'A'] = node;

			String leftChild = st.nextToken();
			if (!leftChild.equals(".")) {
				node.leftChild = leftChild.charAt(0) - 'A';
			}
			String rightChild = st.nextToken();
			if (!rightChild.equals(".")) {
				node.rightChild = rightChild.charAt(0) - 'A';
			}
		}
        

        preOrderTraverse(0);
        sb.append("\n");
        inOrderTraverse(0);
        sb.append("\n");
        postOrderTraverse(0);
        sb.append("\n");

        System.out.println(sb);
	}

	private static void preOrderTraverse(int index) {
        if(index == -1)
            return;
        sb.append(tree[index].v);
        preOrderTraverse(tree[index].leftChild);
        preOrderTraverse(tree[index].rightChild);
	}


    private static void inOrderTraverse(int index) {
        if(index == -1)
            return;
        inOrderTraverse(tree[index].leftChild);
        sb.append(tree[index].v);
        inOrderTraverse(tree[index].rightChild);
    }
    private static void postOrderTraverse(int index) {
        if(index == -1)
            return;
        postOrderTraverse(tree[index].leftChild);
        postOrderTraverse(tree[index].rightChild);
        sb.append(tree[index].v);
    }
	static class Node {
		String v;
		int leftChild = -1;
		int rightChild = -1;

		public Node(String v) {
			this.v = v;
		}

        @Override
        public String toString() {
            return "Node{" +
                "v='" + v + '\'' +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
        }
    }

}