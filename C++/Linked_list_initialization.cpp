#include <iostream>
using namespace std;

class Node {
public:
	int Data;
	Node* nextNode;
	Node(int data) {
		Data = data;
		nextNode = NULL;
	}
};

Node* addNode(Node* head, int data) {
	if (head == NULL) {
		return new Node(data);
	}
	else
	{
		head->nextNode = addNode(head->nextNode, data);
		return head;
	}
}

int main() {
	Node* head = NULL;
	int arrayofnumber[5] = { 4,7,8,18,9 };
	for (int i = 0; i < 5; i++)
	{
		head = addNode(head, arrayofnumber[i]);
	}
	cout << "[";
	while (head != NULL) {
		cout << head->Data << ", ";
		head = head->nextNode;
	}
	cout << "\b\b]" << endl;
}