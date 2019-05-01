package com.epam.module_1;

import java.lang.reflect.Array;

public class CustomList<T> {

    private T[] baseArray ;
    private int baseLength;
    private int actuallFillSize = 0;
    public CustomList(int defaultLength) {
        Class<T> classType = (Class<T>) Object.class;
        baseArray = (T[]) Array.newInstance(classType, defaultLength);
        this.baseLength = defaultLength;
    }



    public void add(T value){
        baseArray[actuallFillSize] = value;
        actuallFillSize++;
        System.out.println(value+" successfully added to list");
    }
    
    
    public T accessByIndex(int index){
        T temp = null;
        if(index > actuallFillSize-1){
            System.out.println("Index is out of bunds");
        }else{
            temp = baseArray[index];
        }
        return temp;
    }

    public void removeByIndex(int index){
        if(index > actuallFillSize){
            System.out.println("index is out of bound");
        }else{
            for(int i = 0 ; i < actuallFillSize ; i++){
                if(i == index){
                    swapElement(i, baseArray);
                }
            }
        }
    }

    public int  size(){
        return actuallFillSize;
    }

    public void swapElement(int start, T[] baseArray){
        for(int i = start; i < (baseArray.length-start) ; i++ ){
            baseArray[i] = baseArray[i+1];
        }
        actuallFillSize--;
    }

    public void print(){
        for(int i = 0 ; i < actuallFillSize; i++){
            System.out.print(baseArray[i]+" ");
        }
    }



    public static void main(String[] args) {
        CustomList list = new CustomList(10);
        list.add(1);
        list.add(2);
        System.out.println();
        list.print();
        System.out.println();
        System.out.println("list size before delete : "+list.size());
        System.out.println("delete element by index 1: ");
        list.removeByIndex(1);
        System.out.println("after delete list size : "+list.size());
        System.out.println("after delete element by index 1 list size is");
        list.print();
        System.out.println();
        System.out.println("Element of index 2 is : "+list.accessByIndex(2));

    }

}
