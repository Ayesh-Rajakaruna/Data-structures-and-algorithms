import java.util.*;
import java.util.Scanner;
class node{
    int Data;node left,right;
    void set_node(int data){
        this.Data = data;
    }
}
class TreeOperation{
    static int max_level = 0;
     node add_data(node root, int data) {
        if (root == null) {
            node new_node = new node();
            new_node.set_node(data);
            return new_node;
        } else if (root.Data > data) {
            root.left = add_data(root.left, data);
        } else {
            root.right = add_data(root.right, data);
        }
        return root;
    }
    void leftViewUtil(node root, int level)
    {
        if (root == null)
            return;
        if (max_level < level) {
            System.out.print(" " + root.Data);
            max_level = level;
        }
        leftViewUtil(root.left, level + 1);
        leftViewUtil(root.right, level + 1);
    }
}
public class Example{
    public static void main(String[] args) {
        int[] list_of_node_data = {50,30,70,65,15,150,45,200};
        node root = null;
        TreeOperation treeOperation = new TreeOperation();
        for (int data:list_of_node_data) {
            root = treeOperation.add_data(root,data);
        }
        treeOperation.leftViewUtil(root, 1);

    }
}