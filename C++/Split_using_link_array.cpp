#include <iostream>
#include <tuple>
using namespace std;

class Node {
public:
	string Head;
	Node* NextNode;
	Node(string head) {
		Head = head;
		NextNode = NULL;
	}
};

Node* AddNode(string world, Node* head) {
	if (head == NULL) {
		return new Node(world);
	}
	else {
		head->NextNode = AddNode(world, head->NextNode);
		return head;
	}

}

Node* split(string sentence, Node* head){
	string world = "";
	for (char letter : sentence) {
		if (letter == ' ') {
			head = AddNode(world, head);
			world = "";
		}
		else {
			world = world + letter;
		}
	}
	head = AddNode(world, head);
	return head;
}

int main() {
	string sentence = "I am ayesh wimantha rajakaruna";
	Node* head = NULL;
	head = split(sentence, head);
	cout << "[";
	while (head != NULL){
		cout << head->Head << ", ";
		head = head->NextNode;
	}
	cout << "\b\b]" << endl;
}