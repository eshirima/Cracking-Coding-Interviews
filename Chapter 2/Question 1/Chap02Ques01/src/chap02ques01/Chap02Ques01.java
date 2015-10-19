/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap02ques01;

/**
 *
 * @author Bonaparte
 */
public class Chap02Ques01 {
    
    public class Node
    {
        Object data;
        Node next;
        
        Node(Object currentData,Node currentNode)
        {
            this.next = currentNode;
            this.data = currentData;
        }
    }
    
    public class LinkedList{
        
        Node head;
        
        public LinkedList()
        {
            this.head = null;
        }
        
        public void addFront(Object newData)
        {
            Node cache = this.head;
            this.head = new Node(newData, cache);
        }
        
        public void addRear(Object newData)
        {
            Node cache = head, current = null;
            
            while((current = cache.next) != null)
                cache = cache.next;
            
            cache.next = new Node(newData, null);
        }
        
        public Object getFront()
        {
            return this.head.data;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
