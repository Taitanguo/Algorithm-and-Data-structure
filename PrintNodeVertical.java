class TreeNode{
	int data;
	TreeNode left, right;
	TreeNode(int item) {
        data = item;
        left = right = null;
    }
} 
class Values {
    int max, min;
}
public class PrintNodeVertical {
    static TreeNode root;
    Values val = new Values();
    public void findMinMax(TreeNode node, Values min, Values max, int hd) {
        if (node == null) 
	        return;
        if (hd < min.min) 
            min.min = hd;
        else if (hd > max.max) 
            max.max = hd;
        findMinMax(node.left, min, max, hd - 1);
        findMinMax(node.right, min, max, hd + 1);
    }
    public void printVerticalLine(TreeNode node, int line_no, int hd) {
        if (node == null) 
            return;
        if (hd == line_no) 
            System.out.print(node.data + " ");        
        printVerticalLine(node.left, line_no, hd - 1);
        printVerticalLine(node.right, line_no, hd + 1);
    }
    public void verticalOrder(TreeNode node) {
        findMinMax(node, val, val, 0);
        for (int line_no = val.min; line_no <= val.max; line_no++) {
            printVerticalLine(node, line_no, 0);
            System.out.println("");
        }
    }
}
