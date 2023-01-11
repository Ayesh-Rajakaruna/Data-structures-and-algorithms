import java.util.LinkedList;
import java.util.Queue;
class BinaryTree{
    static class Node{
        int ValueOfTheNode;
        Node LeftChild,RightChild;
        Node(int Data){
            ValueOfTheNode = Data;
            LeftChild = RightChild = null;
        }
    }
    public Void SearchRoot(Node Tree){
        Queue<Node> QueueOfValue = new LinkedList<>();;
        QueueOfValue.add(Tree);
        while (!QueueOfValue.isEmpty()){
            Node head = QueueOfValue.peek();
            if(head.LeftChild != null){
                QueueOfValue.add(head.LeftChild);
            }
            if(head.RightChild != null){
                QueueOfValue.add(head.RightChild);
            }
            System.out.print(head.ValueOfTheNode + " ");
            QueueOfValue.remove();
        }
        return null;
    }
    public Node AddDataForTree(Node Tree, int Data){
        if (Tree==null){
            Tree = new Node(Data);
        }
        else if (Tree.ValueOfTheNode > Data) {
            Tree.LeftChild = AddDataForTree(Tree.LeftChild, Data);
        }
        else{
            Tree.RightChild = AddDataForTree(Tree.RightChild, Data);
        }
        return Tree;
    }
}
public class Main {
    public static void main(String[] args) {
        int []ListOfInteger = {100, 175, 50, 40, 60, 80};
        BinaryTree.Node root = null;
        BinaryTree Tree = new BinaryTree();
        for (int Data: ListOfInteger) {
            root = Tree.AddDataForTree(root, Data);
        }
        Tree.SearchRoot(root);
    }
}