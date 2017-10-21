import java.util.LinkedList;
import java.util.List;

public class HelloWorld {
	public static void main(String args[]) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		List<Integer> curr = new LinkedList<>();

		helper(root, curr);

		for (int i = 0; i < curr.size(); i++) {
			System.out.println(curr.get(i));
		}

		return;
	}

	private static void helper(TreeNode root, List<Integer> curr) {

		if (root == null) return;

		curr.add(root.val);

		helper(root.left, curr);
		helper(root.right, curr);

		return;

	}



}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}
