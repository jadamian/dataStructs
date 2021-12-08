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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class Project004 extends JFrame implements ActionListener{

    private static int winxpos=0,winypos=0;      // place window here

  int t =0, y=0, z=0,x =0;
  private JButton shuffleButton,exitButton, newButton, back, dump, start, pop;
  private JTextField codeField;
  private JPanel northPanel;
  private MyPanel centerPanel;
  private static JFrame myFrame = null;

  ////////////              MAIN      ////////////////////////
    
    public static Room green;//
    public static Room pink;//
    public static Room brown;//
    public static Room blue;//
    public static Room red;//
    public static Room yellow;//
    public static Room gold;
    public static Room current;//
    public static Stack rooms;
    public static Stack second;
    public static int opt;
    public static void main(String[] args) {
      
        green = new Room("green", 111, "blue", "pink","brown");
        pink = new Room("pink", 111, "blue","green","brown");
        brown = new Room("brown",111,"green","pink","red");
        blue = new Room("blue",111,"yellow","pink","green");
        red = new Room("red", 111,"brown",null,"yellow");
        yellow = new Room("yellow", 111,"blue","gold",null);
        gold = new Room("gold", 111,"yellow",null,null);
        
        second = new Stack();
        
        System.out.println("select either stack or link list.");
        System.out.println("1 for link, 2 for array");
        Scanner scan = new Scanner(System.in);
        opt = scan.nextInt();
     Project004 tpo = new Project004();
  }

  ////////////            CONSTRUCTOR   /////////////////////
  public Project004 ()
  {
        myFrame = this;                 // need a static variable reference to a JFrame object
        northPanel = new JPanel();
        northPanel.setBackground(Color.white);
        
        
       northPanel.add(new JLabel("Enter Code: "));
       codeField = new JTextField("",5);
       northPanel.add(codeField);
        
        start = new JButton("New Start");
        northPanel.add(start);
        start.addActionListener(this);
        
        shuffleButton = new JButton("First Door");
        northPanel.add(shuffleButton);
        shuffleButton.addActionListener(this);
        newButton = new JButton("Second Door");
        northPanel.add(newButton);
        newButton.addActionListener(this);
        back = new JButton("Third Door");
        northPanel.add(back);
        back.addActionListener(this);
        
        pop = new JButton("Pop to last room.");
        northPanel.add(pop);
        pop.addActionListener(this);
        dump = new JButton("Dump");
        northPanel.add(dump);
        dump.addActionListener(this);
        
        exitButton = new JButton("Exit");
        northPanel.add(exitButton);
        exitButton.addActionListener(this);
        
        getContentPane().add("North",northPanel);

        centerPanel = new MyPanel();
        getContentPane().add("Center",centerPanel);

        //theDeck = new CardList(52);
        
        setSize(1000,700);
        setLocation(winxpos,winypos);

        setVisible(true);
   }


  ////////////   BUTTON CLICKS ///////////////////////////
  public void actionPerformed(ActionEvent e) {

      if (e.getSource()== exitButton) {
        dispose(); System.exit(0);
      }
      if (e.getSource()== start) {
        //restart
        
        if(opt ==1){
            rooms = new Stack();
        }
        if(opt ==2){
            rooms = new Stack(50);
        }
        current = green;
        rooms.push(green.color, green.code, green.adj1, green.adj2, green.adj3);
        t = 1;
        z=0;
        x=0;
        repaint();
      }
       if (e.getSource()== shuffleButton) {
        //left
           int cd=0;
        try{
           String theCode = codeField.getText();
           cd = Integer.parseInt(theCode);
        }
        catch(Exception l){
            System.out.println("no code in field.");
        }
           try{
            
            String newcolor = current.adj1;
           switch(newcolor){     
            case "green":
                    //System.out.println("yee");
                    if(cd == green.code){
                    if(z ==0){
                    rooms.push(green.color, green.code, green.adj1, green.adj2, green.adj3);
                    current = green;
                    t=1;
                    }
                    if(z == 1){
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        b = green.color;
                        if(!a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = green;
                        }
                        try{
                        Link t = rooms.peek();
                        //System.out.println("the t- "+ t.colo);
                        }
                        catch(Exception dos){
                        x=1;
                    }
                    }
                    }
                    else{
                        t=2;
                    }
                    
                break;
            case "pink":
                    //System.out.println("yee");
                    if(cd == pink.code){
                    if(z == 0){
                    rooms.push(pink.color, pink.code, pink.adj1, pink.adj2, pink.adj3);
                    current = pink;
                    t=1;
                    }
                    if(z == 1){
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        b = pink.color;
                        System.out.println("+"+ a);
                        System.out.println("-"+ b);
                        if(!a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = pink;
                        }
                    }
                    }
                    else{
                        t=2;
                    }
                break;
            case "brown":
                    if(cd == brown.code){
                    //System.out.println("yee");
                    if(z == 0){
                    rooms.push(brown.color, brown.code, brown.adj1, brown.adj2, brown.adj3);
                    current = brown;
                    t=1;
                    }
                    if(z == 1){
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        b = brown.color;
                        if(!a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = brown;
                        }
                    }
                    }
                    else{
                        t=2;
                    }
                break;
            case "blue":
                    //System.out.println("yee");
                    if(cd == blue.code){
                    if(z ==0){
                    rooms.push(blue.color, blue.code, blue.adj1, blue.adj2, blue.adj3);
                    current = blue;
                    t=1;
                    }
                    if(z == 1){
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        b = blue.color;
                        if(!a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = blue;
                        }
                    }
                    }
                    else{
                        t=2;
                    }
                break;
            case "red":
                    //System.out.println("yee");
                    if(cd == red.code){
                    if(z == 0){
                    rooms.push(red.color, red.code, red.adj1, red.adj2, red.adj3);
                    current = red;
                    t=1;
                    }
                    if(z == 1){
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        b = red.color;
                        if(!a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = red;
                        }
                    }
                    }
                    else{
                        t=2;
                    }
                break;
            case "yellow":
                    //System.out.println("yee");
                    if(cd == yellow.code){
                    if(z==0){
                    rooms.push(yellow.color, yellow.code, yellow.adj1, yellow.adj2, yellow.adj3);
                    current = yellow;
                    t=1;
                    }
                    if(z == 1){
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        //System.out.println("+ "+ a);
                        b = yellow.color;
                        //System.out.println("- "+ b);
                        if(!a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = yellow;
                        }
                    }
                    }
                    else{
                        t=2;
                    }
                break;
            case "gold":
                    //System.out.println("yee");
                    if(cd == gold.code){
                    if(z == 0){
                    //rooms.push(gold.color, gold.code, gold.adj1, gold.adj2, gold.adj3);
                    current = gold;
                    t=1;
                    z = 0;
                    }
                    if(z == 1){
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        b = gold.color;
                        if(!a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = gold;
                        }
                    }
                    }
                    else{
                        t=2;
                    }
                break;
            default:
                
                break;
                 }
           
           }
           catch(Exception p){
               System.out.println("not valid.");
           }
       
        if(current.color.equals(gold.color)){
            System.out.println("aquired treasure.");
            z=1;
        }
       
        repaint();
      }
       if (e.getSource()== newButton) {
        //right
           int cd=0;
        try{
           String theCode = codeField.getText();
           cd = Integer.parseInt(theCode);
        }
        catch(Exception l){
            System.out.println("no code in field.");
        }
           try{
            
            String newcolor = current.adj2;
           switch(newcolor){     
            case "green":
                    //System.out.println("yee");
                    if(cd == green.code){
                    if(z == 0){
                    rooms.push(green.color, green.code, green.adj1, green.adj2, green.adj3);
                    current = green;
                    t=1;
                    }
                    if(z == 1){
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        b = green.color;
                        if(!a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = green;
                        }
                        
                        try{
                        Link t = rooms.peek();
                        //System.out.println("the t- "+ t.colo);
                        }
                        catch(Exception dos){
                        x=1;
                    }
                    }
                    }
                    else{
                        t=2;
                    }
                    
                break;
            case "pink":
                    ///System.out.println("yee");
                    if(cd == pink.code){
                    if(z == 0){
                    rooms.push(pink.color, pink.code, pink.adj1, pink.adj2, pink.adj3);
                    current = pink;
                    t=1;
                    }
                    if(z == 1){
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        b = pink.color;
                        if( !a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = pink;
                        }
                    }
                    }
                    else{
                        t=2;
                    }
                break;
            case "brown":
                    if(cd == brown.code){
                    //System.out.println("yee");
                    if(z == 0){
                    rooms.push(brown.color, brown.code, brown.adj1, brown.adj2, brown.adj3);
                    current = brown;
                    t=1;
                    }
                    if(z == 1){
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        b = brown.color;
                        if(!a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = brown;
                        }
                    }
                    }
                    else{
                        t=2;
                    }
                break;
            case "blue":
                    //System.out.println("yee");
                    if(cd == blue.code){
                    if(z == 0){
                    rooms.push(blue.color, blue.code, blue.adj1, blue.adj2, blue.adj3);
                    current = blue;
                    t=1;
                    }
                    if(z == 1){
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        b = blue.color;
                        if(!a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = blue;
                        }
                    }
                    }
                    else{
                        t=2;
                    }
                break;
            case "red":
                    //System.out.println("yee");
                    if(cd == red.code){
                    if(z == 0){
                    rooms.push(red.color, red.code, red.adj1, red.adj2, red.adj3);
                    current = red;
                    t=1;
                    }
                    if(z == 1){
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        b = red.color;
                        if(!a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = red;
                        }
                    }
                    }
                    else{
                        t=2;
                    }
                break;
            case "yellow":
                    //System.out.println("yee");
                    if(cd == yellow.code){
                    if(z == 0){
                    rooms.push(yellow.color, yellow.code, yellow.adj1, yellow.adj2, yellow.adj3);
                    current = yellow;
                    t=1;
                    }
                    if(z == 1){
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        b = yellow.color;
                        if(!a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = yellow;
                        }
                    }
                    }
                    else{
                        t=2;
                    }
                break;
            case "gold":
                    //System.out.println("yee");
                    if(cd == gold.code){
                    if(z == 0){
                    //rooms.push(gold.color, gold.code, gold.adj1, gold.adj2, gold.adj3);
                    current = gold;
                    t=1;
                    z=0;
                    }
                    if(z == 1){
                        
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        b = gold.color;
                        if(!a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = gold;
                        }
                    }
                    }
                    else{
                        t=2;
                    }
                break;
            default:
                
                break;
                 }
           
        }
        catch(Exception m){
            System.out.println("not valid.");
        }
        if(current.color.equals(gold.color)){
            System.out.println("aquired treasure.");
            z=1;
        }
        
        
        repaint();
       }
       if (e.getSource()== back) {
           int cd=0;
        try{
           String theCode = codeField.getText();
           cd = Integer.parseInt(theCode);
        }
        catch(Exception l){
            System.out.println("no code in field.");
        }
           try{
            
            String newcolor = current.adj3;
           switch(newcolor){     
            case "green":
                    //System.out.println("yee");
                    if(cd == green.code){
                    if(z == 0){
                    rooms.push(green.color, green.code, green.adj1, green.adj2, green.adj3);
                    current = green;
                    t=1;
                    }
                    if(z == 1){
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        b = green.color;
                        if(!a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = green;
                        }
                        try{
                        Link  tt= rooms.peek();
                        //System.out.println("the t- "+ tt.colo);
                        }
                        catch(Exception dos){
                        x=1;
                    }
                    }
                    }
                    else{
                        t=2;
                    }
                    
                break;
            case "pink":
                    ///System.out.println("yee");
                    if(cd == pink.code){
                    if(z == 0){
                    rooms.push(pink.color, pink.code, pink.adj1, pink.adj2, pink.adj3);
                    current = pink;
                    t=1;
                    }
                    }
                    if(z == 1){
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        b = pink.color;
                        if(!a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = pink;
                        }
                    }
                    else{
                        t=2;
                    }
                break;
            case "brown":
                    if(cd == brown.code){
                    //System.out.println("yee");
                    if(z == 0){
                    rooms.push(brown.color, brown.code, brown.adj1, brown.adj2, brown.adj3);
                    current = brown;
                    t=1;
                    }
                    if(z == 1){
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        b = brown.color;
                        if(!a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = brown;
                        }
                    }
                    }
                    else{
                        t=2;
                    }
                break;
            case "blue":
                    //System.out.println("yee");
                    if(cd == blue.code){
                    if(z == 0){
                    rooms.push(blue.color, blue.code, blue.adj1, blue.adj2, blue.adj3);
                    current = blue;
                    t=1;
                    }
                    if(z == 1){
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        b = blue.color;
                        if(!a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = blue;
                        }
                    }
                    }
                    else{
                        t=2;
                    }
                break;
            case "red":
                    //System.out.println("yee");
                    if(cd == red.code){
                    if(z == 0){
                    rooms.push(red.color, red.code, red.adj1, red.adj2, red.adj3);
                    current = red;
                    t=1;
                    }
                    if(z == 1){
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        b = red.color;
                        if(!a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = red;
                        }
                    }
                    }
                    else{
                        t=2;
                    }
                break;
            case "yellow":
                    //System.out.println("yee");
                    if(cd == yellow.code){
                    if(z == 0){
                    rooms.push(yellow.color, yellow.code, yellow.adj1, yellow.adj2, yellow.adj3);
                    current = yellow;
                    t=1;
                    }
                    if(z == 1){
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        b = yellow.color;
                        if(!a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = yellow;
                        }
                    }
                    }
                    else{
                        t=2;
                    }
                break;
            case "gold":
                    //System.out.println("yee");
                    if(cd == gold.code){
                    if(z == 0){
                    //rooms.push(gold.color, gold.code, gold.adj1, gold.adj2, gold.adj3);
                    current = gold;
                    t=1;
                    z=0;
                    }
                    if(z == 1){
                        Link check = rooms.pop();
                        String a;
                        String b;
                        a = check.colo;
                        b = gold.color;
                        if( !a.equals(b)){
                            t=3;
                        }
                        if(a.equals(b)){
                            t=1;
                            current = gold;
                        }
                    }
                    }
                    else{
                        t=2;
                    }
                break;
            default:
                
                break;
                 }
           
        }
        catch(Exception q){
            System.out.println("not valid.");
        }
        if(current.color.equals(gold.color)){
            System.out.println("aquired treasure.");
            z=1;
        }
        
        repaint();
       }
       if(e.getSource() == pop){
           try{
               
                Link bac= rooms.pop();
                System.out.println("popping room "+ bac.colo);
                Link peeking = rooms.peek();
                Room top = new Room(peeking.colo, peeking.cod, peeking.ad1, peeking.ad2, peeking.ad3);
                current = top;
                t=1;
                repaint();
                
             }
             catch(Exception t){
                 System.out.println("No rooms to pop.");
                 conv();
                 rooms = new Stack();
                 repaint();
             }
       }
       if (e.getSource()== dump) {
           
           System.out.println("Dumping rooms...");
           int r=1;
                while(r !=0){
                    try{
                        Link bak = rooms.pop();
                        System.out.println("Room "+ bak.colo);
                        //color = bak.color;
                        second.push(bak);
                        ///System.out.println("pushing into second: "+ bak.color);
                        t=1;
                    }
                    catch(Exception d){
                        System.out.println("////////////");
                        int p =2;
                        while(p !=0){
                    try{
                        Link bak = second.pop();
                        //System.out.println("popping "+ bak.color);
                        rooms.push(bak);
                        //System.out.println("pushing into second: "+ bak.color);
                    }
                    catch(Exception x){
                        //System.out.println("Refilled stack.");
                        p =0;
                    }
                    }
                        r =0;
                    }
                    }
           
        
        repaint();
       }
  }
public void conv(){
    t=0;
}

// This routine will load an image into memory
//
public static Image load_picture(String fname)
{
        // Create a MediaTracker to inform us when the image has
        // been completely loaded.
        Image image;
        MediaTracker tracker = new MediaTracker(myFrame);


        // getImage() returns immediately.  The image is not
        // actually loaded until it is first used.  We use a
        // MediaTracker to make sure the image is loaded
        // before we try to display it.

        image = myFrame.getToolkit().getImage(fname);

        // Add the image to the MediaTracker so that we can wait
        // for it.
        tracker.addImage(image, 0);
        try { tracker.waitForID(0); }
        catch ( InterruptedException e) { System.err.println(e); }

        if (tracker.isErrorID(0)) { image=null;}
        return image;
}
// --------------   end of load_picture ---------------------------

class MyPanel extends JPanel {

 ////////////    PAINT   ////////////////////////////////
  public void paintComponent (Graphics g) {
    
    int xpos = 0, ypos = 0;
    Image im;
    if(t==0){
    im = Project004.load_picture("images/temp0.jpg");
    g.drawImage(im, -10, 0, this);
    }
    if(t ==1){
    im = Project004.load_picture("images/"+ current.color +".gif");
    g.drawImage(im, xpos, ypos, this);
    g.setColor(Color.white);
    g.fillRect(10, 10, 150, 70);
    g.setColor(Color.black);
    g.drawString("Pick a door: ", 25, 25);
    if(current.adj1 != null){
        g.drawString("Door 1: "+ current.adj1, 25, 40);
    }
    if(current.adj1 == null){
        g.drawString("There is no door 1.", 25, 40);
    }
    if(current.adj2 != null){
        g.drawString("Door 2: "+ current.adj2, 25, 55);
    }
    if(current.adj2 == null){
        g.drawString("There is no second door.", 25, 55);
    }
    if(current.adj3 != null){
        g.drawString("Door 3: " + current.adj3, 25, 70);
    }
    if(current.adj3 == null){
        g.drawString("There is no third door.", 25, 70);
    }
    if(x == 1){
        im = Project004.load_picture("images/win.gif");
        g.drawImage(im, 250, 250, this);
    }
  }
  if(t == 2){
      im = Project004.load_picture("images/death1.png");
      g.drawImage(im, -50, 0, this);
  }
  if(t == 3){
      im = Project004.load_picture("images/death1.png");
      g.drawImage(im, -50, 0, this);
      System.out.println("deeeeed");
  }
    
  }
}
    
}
