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
public class LinkList {
    protected Link first;
    
    public LinkList(){
        first = null;
    }
    
    public void insertFirst(String color, int code, String ada, String ads, String add){
        Link newLink = new Link(color, code, ada, ads, add);
        newLink.next = first;
        first = newLink;
    }
    public void insertFirst(Link comes){
        Link newLink = comes;
        newLink.next = first;
        first = newLink;
    }
    
    public Link deleteFirst(){
        Link temp = first;
        first = first.next;
        return temp;
    }
}
