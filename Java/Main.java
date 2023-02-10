import java.util.ArrayList;

class BinaryTree{
    static class Node{
        Node LeftChild,RightChild;
        int ValueOfTheNode;
        Node(int Data) {
            this.RightChild = null;
            this.LeftChild = null;
            this.ValueOfTheNode = Data;
        }
    }
    Node SetValue(Node Root, int Data){
        if (Root == null){
            Root = new Node(Data);
        }
        else {
            if(Root.ValueOfTheNode > Data){
                Root.LeftChild  = SetValue(Root.LeftChild, Data);
            }
            else{
                Root.RightChild = SetValue(Root.RightChild, Data);
            }
        }
        return Root;
    }
    ArrayList<Integer> GetPath(Node root, int Data){
        ArrayList<Integer> ListOfPath = new ArrayList();
        while (!(root.ValueOfTheNode == Data)){
            ListOfPath.add(root.ValueOfTheNode);
            if(Data < root.ValueOfTheNode){
                root = root.LeftChild;
            }
            else {
                root = root.RightChild;
            }
        }
        ListOfPath.add(Data);
        return ListOfPath;
    }
    int LowestCommonAncestor(ArrayList<Integer> Array1, ArrayList<Integer> Array2){
        int Count = 0;
        int Value = 0;
        while (Array1.get(Count)==Array2.get(Count)){
            Value = Array1.get(Count);
            Count ++;
        }
        return Value;
        }
}
public class Main{
    public static void main(String[] args) {
        int []ArrayOfValue = {50,25,40,100,200,10,30};
        BinaryTree.Node root = null;
        BinaryTree Three = new BinaryTree();
        for (int Value:ArrayOfValue) {
            root = Three.SetValue(root, Value);
        }
        ArrayList<Integer> path1 =  Three.GetPath(root, 30);
        ArrayList<Integer> path2 =  Three.GetPath(root, 10);
        System.out.println(Three.LowestCommonAncestor(path1,path2));
    }
}
