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
public class Link {
    public String colo;
    public int cod;
    public String ad1;
    public String ad2;
    public String ad3;
    protected Link next;
    
    public Link(){
        
    }
    
    public Link(String col, int j, String ada, String ads, String add){
        colo = col;
        cod = j;
        ad1 = ada;
        ad2 = ads;
        ad3 = add;
    }
    
    public void displayLink(){
        System.out.println("Room: " + colo);
    }
}
