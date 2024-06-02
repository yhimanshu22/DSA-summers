#include <iostream>

struct Node
{
    int data;
    Node *next;

    // Constructor to initialize a new node
    Node(int data)
    {
        this->data = data;
        this->next = nullptr;
    }
};

struct LinkedList
{
    Node *head;

    // Constructor to initialize an empty list
    LinkedList()
    {
        head = nullptr;
    }

    // Function to convert an array to a linked list
    void arrayToList(int arr[], int size)
    {
        if (size == 0)
            return; // Check if the array is empty

        head = new Node(arr[0]); // Create the head node
        Node *current = head;

        for (int i = 1; i < size; ++i)
        {
            current->next = new Node(arr[i]); // Create a new node and link it
            current = current->next;          // Move to the next node
        }
    }

    // Function to print the list
    void printList()
    {
        Node *temp = head;
        while (temp != nullptr)
        {
            std::cout << temp->data << " -> ";
            temp = temp->next;
        }
        std::cout << "nullptr" << std::endl;
    }

    // Function to calculate the length of the list
    int length()
    {
        int count = 0;
        Node *current = head;
        while (current != nullptr)
        {
            count++;
            current = current->next;
        }
        return count;
    }

    // Destructor to free memory
    ~LinkedList()
    {
        Node *temp;
        while (head != nullptr)
        {
            temp = head;
            head = head->next;
            delete temp;
        }
    }
};

int main()
{
    LinkedList list;
    int arr[] = {1, 12, 3, 4, 5};
    int size = sizeof(arr) / sizeof(arr[0]);

    list.arrayToList(arr, size);

    std::cout << "Linked List: ";
    list.printList();
    std::cout << "Length of Linked List: " << list.length() << std::endl;

    return 0;
}
