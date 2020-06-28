package com.self.collection;

import lombok.ToString;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public void addFirst(Node<E> node){
        if(head==null){
            head = node;
            tail = node;
        }else{
            node.link = head;
            head = node;
        }
        size++;
    }

    public void addLast(Node<E> node){
        if(head==null){
            head = node;
            tail = node;
        }else{
            tail.link = node;
            tail = node;
        }
        size++;
    }

    public void add(Node<E> node, int k){
        Node<E> previous = getNode(k-1);
        Node<E> next = getNode(k);

        previous.link = node;
        node.link = next;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> temp = head;
        while(Objects.nonNull(temp)){
            sb.append(temp.data);

            if(Objects.nonNull(temp.link)){
                sb.append(", ");
            }
            temp = temp.link;
        }
        sb.append("]");
        return sb.toString();
    }

    public Node<E> getNode(int index){
        if(index>size-1){
            throw new ArrayIndexOutOfBoundsException(index);
        }else{
            int count = 0;
            Node result = head;
            while(count<index){
                result = result.link;
                count++;
            }
            return result;
        }
    }

    public Node<E> removeFirst(){
        Node<E> removedNode = head;
        head = head.link;
        size--;
        return removedNode;
    }

    public Node<E> removeLast(){
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<E> removedNode = tail;
        Node<E> previousTail = getNode(size-2);
        previousTail.link = null;
        tail = previousTail;
        size--;
        return removedNode;
    }

    public Node<E> remove(int k){
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }else if(k == size-1){
            return removeLast();
        }else{
            Node<E> removedNode = getNode(k);
            Node<E> previous = getNode(k-1);
            Node<E> next = getNode(k+1);

            previous.link = next;
            size--;
            return removedNode;
        }

    }

    private boolean isEmpty() {
        return head == null;
    }

    @ToString
    public static class Node<E>{
        public E data;
        public Node<E> link = null;
        public Node(E data) {
            this.data = data;
        }
    }

    @Test
    public void testSimple(){
        LinkedList<Integer> list = new LinkedList<>();

        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        list.addLast(node1);
        list.addLast(node2);
        list.addLast(node3);
        list.addLast(node4);

        assertEquals("[1, 2, 3, 4]", list.toString());


    }

    @Test
    public void testRegular(){
        LinkedList<Integer> list = new LinkedList<>();

        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);

        list.addLast(node1);
        list.addLast(node2);
        list.addLast(node3);
        list.addLast(node4);

        assertEquals(node3, list.getNode(2));

        Node<Integer> removedFirstNode = list.removeFirst();
        assertEquals(node1, removedFirstNode);

        Node<Integer> removedLastNode = list.removeLast();
        assertEquals(node4, removedLastNode);

        Node<Integer> list5 = new Node<>(5);
        list.add(list5, 1);
        assertEquals(list5, list.getNode(1));


        Node<Integer> removedK = list.remove(1);
        assertEquals(list5, removedK);

        System.out.println(list);
    }

    @Test
    public void testRemoveFirst(){
        LinkedList<Integer> list = new LinkedList<>();
        Node<Integer> node1 = new Node<>(1);

        list.addFirst(node1);
        list.removeFirst();

        assertEquals(0, list.size);
    }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetNodeArrayIndexOutOfBounds(){
        LinkedList<Integer> list =new LinkedList<>();
        Node<Integer> node1 = new Node<>(1);
        list.addLast(node1);

        list.getNode(10);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddNodeKArrayIndexOutOfBounds(){
        LinkedList<Integer> list =new LinkedList<>();
        Node<Integer> node1 = new Node<>(1);

        list.add(node1, 100);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveArrayIndexOutOfBounds(){
        LinkedList<Integer> list =new LinkedList<>();
        list.removeLast();
    }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveKArrayIndexOutOfBounds(){
        LinkedList<Integer> list =new LinkedList<>();
        list.remove(10);
    }
}
