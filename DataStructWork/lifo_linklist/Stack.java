/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project004;

/**
 *
 * @author Jose Damian
 */
public class Stack {
    private LinkList theList;
    private int MAXSIZE;        // size of stack array 
    private Link[] stackArray; 
    private int top; 
    
    public Stack(){
        theList = new LinkList();
    }
    public Stack(int j){
        stackArray = new Link[j];
        top = -1;
    }
    public void push(String color, int code, String ada, String ads, String add){
        try{
        theList.insertFirst(color, code, ada, ads, add);
        }
        catch(Exception q){
            Link added = new Link(color, code, ada, ads, add);
            stackArray[++top] = added;
        }
        //System.out.println("pushed");
    }
    public void push(Link bak){
        try{
        theList.insertFirst(bak);
        
        }
        catch(Exception t){
        stackArray[++top]= bak;
        }
        //System.out.println("pushed");
    }
    public Link pop(){
        try{
        return theList.deleteFirst();
        }
        catch(Exception r){
            return stackArray[top--];
        }
    }
    public Link peek(){
        try{
        return theList.first;
        }
        catch(Exception m){
            return stackArray[top];
        }
    }
}
        