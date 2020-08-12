package com.self.collection;

import org.junit.Test;

import java.util.Objects;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class DoubleLinkedList<E> {

    private DoubleNode<E> head;
    private DoubleNode<E> tail;
    private int size = 0;

    public void addFirst(DoubleNode<E> node){

        if(head==null){
            head = node;
            tail = node;
        }else{
            node.right = head;
            head.left = node;

            head = node;
        }
        size++;
    }

    public void addLast(DoubleNode<E> node){
        if(tail==null){
            head = node;
            tail = node;
        }else{
            node.left = tail;
            tail.right = node;

            tail = node;
        }
        size++;
    }

    /**
     * k번째 뒤에 add한다.
     * @param node
     * @param k
     */
    public void add(DoubleNode<E> node, int k){
        if(k==1){
            addFirst(node);
        }else if(k==size){
            addLast(node);
        }else{
            DoubleNode<E> previous = node(k);
            DoubleNode<E> next = previous.right;

            node.left = previous;
            node.right= next;

            previous.right = node;
            next.left = node;
            size++;
        }
    }

    public Optional<DoubleNode<E>> node(DoubleNode<E> node){
        DoubleNode<E> temp = head;
        for(int i=0;i<size; i++){
            if(temp.equals(node)){
                return Optional.of(temp);
            }else{
                temp = temp.right;
            }
        }
        return Optional.empty();
    }

    /**
     * k번째 node를 리턴한다.
     * @param k
     * @return
     */
    public DoubleNode<E> node(int k){
        if(size-1 < k){
            throw new ArrayIndexOutOfBoundsException();
        }else{
            DoubleNode<E> result = head;
            for(int i=1; i<k; i++){
                result = head.right;
            }
            return result;
        }
    }

    public DoubleNode<E> removeFirst(){
        DoubleNode<E> removed = head;
        if(head.right==null){
            head = null;
            tail = null;
        }else{
            head = head.right;
            head.left = null;
        }

        size--;
        return removed;
    }


    public DoubleNode<E> removeLast(){
        DoubleNode<E> removed = tail;
        if(tail.left==null){
            head = null;
            tail = null;
        }else{
            tail = tail.left;
            tail.right = null;
        }

        size--;
        return removed;
    }

    public DoubleNode<E> remove(int k){
        if(k==1){
            return removeFirst();
        }else if(k==size){
            return removeLast();
        }else{
            DoubleNode<E> previous = node(k);
            DoubleNode<E> next = previous.right;

            DoubleNode<E> removed = previous.right;

            previous.right = next;
            next.left = previous;

            size--;
            return removed;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoubleLinkedList)) return false;
        DoubleLinkedList<?> that = (DoubleLinkedList<?>) o;
        return size == that.size &&
                Objects.equals(head, that.head) &&
                Objects.equals(tail, that.tail);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        DoubleNode<E> temp = head;
        for(int i=0;i<size;i++){
            sb.append(temp.data);
            if(temp.right!=null){
                sb.append(", ");
            }
            temp = temp.right;
        }
        return sb.append("]").toString();
    }

    public static class DoubleNode<E>{
        E data;
        DoubleNode<E> left;
        DoubleNode<E> right;
        public DoubleNode(E data) {
            this.data = data;
        }
    }

    @Test
    public void test(){
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        DoubleNode<Integer> three = new DoubleNode<>(3);
        DoubleNode<Integer> four = new DoubleNode<>(4);
        DoubleNode<Integer> six = new DoubleNode<>(6);
        doubleLinkedList.addLast(three);
        doubleLinkedList.addLast(four);
        doubleLinkedList.addLast(six);



        print("3,4,6 삽입",doubleLinkedList);
        assertEquals("[3, 4, 6]", doubleLinkedList.toString());

        DoubleNode<Integer> five = new DoubleNode<>(5);
        doubleLinkedList.add(five, 2);  //2번째 뒤에 삽입

        print("2번째 뒤에 5 삽입",doubleLinkedList);
        assertEquals("[3, 4, 5, 6]", doubleLinkedList.toString());

        doubleLinkedList.removeFirst();
        print("첫번째 노드 삭제",doubleLinkedList);
        assertEquals("[4, 5, 6]", doubleLinkedList.toString());

        doubleLinkedList.removeLast();
        print("마지막 노드 삭제",doubleLinkedList);
        assertEquals("[4, 5]", doubleLinkedList.toString());


        doubleLinkedList.remove(2);
        print("2번째 노드 삭제",doubleLinkedList);
        assertEquals("[4]", doubleLinkedList.toString());
    }

    private void print(String print, DoubleLinkedList<Integer> doubleLinkedList) {
        System.out.println(String.format("============%s============", print));
        System.out.println(doubleLinkedList);
    }
}
