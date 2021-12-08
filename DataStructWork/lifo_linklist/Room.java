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
public class Room {
    public String color;
    public int code;
    public String adj1;
    public String adj2;
    public String adj3;
    protected Room next;
    public Room(String col, int i, String ada, String ads, String add){
        color = col;
        code = i;
        adj1 = ada;
        adj2 = ads;
        adj3 = add;
    }
    
    public String getColor(){
        return color;
    }
    public int getCode(){
        return code;
    }
    public String getAdj1(){
        return adj1;
    }
    public String getAdj2(){
        return adj2;
    }
    public String getAdj3(){
        return adj3;
    }
    
}
