//
//  LinkedList.cpp
//  Linked List
//
//  Created by Emil Shirima on 10/1/15.
//  Copyright (c) 2015 Emil Shirima. All rights reserved.
//

#include "LinkedList.h"
Node::Node()
{
    data = 0;
    next = nullptr;
}

Node::Node(int info)
{
    data = info;
    next = nullptr;
}

LinkedList::LinkedList()
{
    head = nullptr;
}
//TODO: Confirm this implementation. I really doubt it
LinkedList::LinkedList(const LinkedList& actual)
{
    Node * temporaryHead, temporaryNode;
    
    temporaryHead = actual.head;
    
    while (temporaryHead != nullptr) {
        temporaryNode = *new Node(temporaryHead->data);
        temporaryHead = temporaryHead->next;
    }
}

LinkedList::~LinkedList()
{
    while (head != nullptr)
    {
        Node * temp = head;
        head = head->next;
        delete temp;
    }
}

LinkedList& LinkedList::operator=(LinkedList rhs)
{
    swap(rhs);
    return *this;
}

int LinkedList::length(LinkedList actual)
{
    int count = 0;
    Node * temp = actual.head;
    
    while (temp != nullptr)
    {
        ++count;
        temp = temp->next;
    }
    
    return count;
}

void LinkedList::swap(LinkedList & rhs)
{
    Node * temp = rhs.head;
    rhs.head = head;
    head = temp;
}

void LinkedList::insertInfront(int value)
{
    if (isEmpty())
    {
        head = new Node(value);
    }
    else
    {
        Node * temp = new Node(value);
        temp->next = head;
        head = temp;
    }
}

void LinkedList::insertBack(int value)
{
    if (isEmpty())
    {
        head = new Node(value);
    }
    else
    {
        Node * temp = head;
        
        while (temp->next != nullptr)
        {
            temp = temp->next;
        }
        
        temp->next = new Node(value);
    }
}

void LinkedList::deleteFromFront()
{
    if (!isEmpty())
    {
        Node * temp = head;
        head = head->next;
        delete temp;
    }
    else
    {
        std::cout << "It's the 21st century and we still cannot delete an empty list :(" << "\n";
    }
}

void LinkedList::deleteFromBack()
{
    if (!isEmpty())
    {
        // a single element in the Linked List
        if (head ->next == nullptr)
        {
            delete head;
            head = nullptr;
        }
        else
        {
            Node * temp = head->next;
            Node * previous = head;
            
            while (temp->next != nullptr)
            {
                previous = temp;
                temp = temp->next;
            }
            
            delete temp;
            previous->next = nullptr;
            
        }
    }
    else
    {
        std::cout << "Inspite of all the technology, we still cannot delete from an empty list :(";
    }
}

bool LinkedList::isEmpty()
{
    if (head == nullptr)
    {
        return true;
    }
    else
    {
        return false;
    }
}

void LinkedList::printContents()
{
    if(!isEmpty())
    {
        Node * temp = this->head;
        
        while (temp)
        {
            std::cout << temp->data << "\n";
            temp = temp->next;
        }
        
        std::cout << "\n";
    }
    else
    {
        std::cout << "Our current technology does not support printing an empty list :(";
    }
}

// Methods for Chapter 2 Question 01 from Cracking the Coding Interviews

// Using a HastSet, pretty much iterate through the list addign its contents to it.
// If identical item is found, remove it from the list
void LinkedList::findDuplicatesWithBuffer()
{
    if (isEmpty())
    {
        std::cout << "Can't find duplicates in an empty list using Buffer :(";
    }
    else
    {
        std::unordered_set<int> listContents;
        Node * current = head;
        
        while (current != nullptr)
        {
            auto search = listContents.find(current->data);
            
            if (search != listContents.end()) // the element was found
            {
                Node * temp = current;
                current = current->next;
                delete temp;
            }
            else
            {
                current = current -> next;
            }
        }
    }
}


void LinkedList::findDuplicatesWithoutBuffer()
{
    if (isEmpty())
    {
        std::cout << "Can't find duplicates in an empty list :(";
    }
    else
    {
        // three pointers because in worst case we have to delete from a random position in the linked list
        Node * current = head;
        Node * previous = current->next; // so as we can have access to the previous node just like a double linked list :)
        Node * nextElement = previous->next;
        
        while (current != nullptr)
        {
            if(current->next == nullptr) // at the end of the list
            {
                break;
            }
            
            while (nextElement != nullptr)
            {
                if (current->data == nextElement->data)
                {
                    Node * temp = nextElement;
                    nextElement = nextElement->next;
                    previous->next = temp->next;
                    delete temp;
                }
                
                nextElement = nextElement->next;
                previous = previous->next;
            }
            
            current = current->next;
            previous = current->next;
            
        }
    }
}