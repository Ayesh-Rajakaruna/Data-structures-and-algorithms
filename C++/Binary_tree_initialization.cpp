#include <iostream>
using namespace std;

class Node {
public:
	int Data;
	Node* left;
	Node* right;
	Node(int data) {
		Data = data;
		left = NULL;
		right = NULL;
	}
};

Node* AddNode(Node* root, int Data) {
	if (root == NULL) {
		return new Node(Data);
	}
	else {
		if (root->Data > Data) {
			root->left = AddNode(root->left, Data);
		}
		else
		{
			root->right = AddNode(root->right, Data);
		}
		return root;
	}
}

int main() {
	Node* root = NULL;
	int treeNodeData[5] = { 50, 30, 70, 40, 100 };
	for (int i = 0; i < 5; i++)
	{
		root = AddNode(root, treeNodeData[i]);
	}
	cout << root->Data << endl; //Test the value
	
}