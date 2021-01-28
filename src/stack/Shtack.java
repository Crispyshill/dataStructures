/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import java.util.EmptyStackException;

/**
 *
 * @author shill
 */
public class Shtack<E> implements StackInt<E> {
    Node<E> head = null;
    private int size = 0;
    private class Node<E>{
        E data;
        Node<E> next;
        public Node(E value, Node<E> next){
            this.data = value;
            this.next = next;
        }
    }
    @Override
    public E push(E data){
        head = new Node<E>(data, head);
        size++;
        return data;
    }
    public E pop(){
        if(empty()){
            throw new EmptyStackException();
        }
        else{
        E temp = head.data;
        head = head.next;
        size--;
        return temp;
        }
    }
    public E peek(){
        if(empty()){
            throw new EmptyStackException();
        }
        else{
            return head.data;
        }
    }
    public boolean empty(){
        return (size == 0);
    }
    
}
