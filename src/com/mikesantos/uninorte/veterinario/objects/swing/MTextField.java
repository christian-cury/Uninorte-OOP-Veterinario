package com.mikesantos.uninorte.veterinario.objects.swing;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JTextField;

public class MTextField extends JTextField{

	private static final long serialVersionUID = -7316637612728104771L;

	private transient StringBuilder password;
    protected char echoChar;
    protected boolean echoEnabled;
     
    public MTextField (){
        super ();
    }
     
    public MTextField (javax.swing.text.Document doc, String text, int columns){
        super (doc, text, columns);
    }
     
    public MTextField (int columns){
        super (columns);
    }
     
    public MTextField (String text){
        super (text);
    }
     
    public MTextField (String text, int columns){
        super (text, columns);
    }
     
    {
        password = new StringBuilder ();
        echoChar = '*';
        echoEnabled = false;
    }
     
    public void setEchoChar (char echoChar){
        this.echoChar = echoChar;
    }
 
    public void enableMasking (){
        echoEnabled = true;
 
        this.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                if (!echoEnabled)
                    return;
                 
                char c = e.getKeyChar();
                     
                if (c == (char) 22)//Test is copied, ie a lot of characters
                    System.exit(0);//TESTING
 
                if (c == '\n')//NewLine
                    return;
 
                if (c == (char)8) {//Backspace
                    try
                    {
                        password.deleteCharAt(password.length() - 1);
                        System.out.println(password);
                    }
                    catch (Exception ex) {}
                    return;
                }
 
                if (c != KeyEvent.CHAR_UNDEFINED && !e.isActionKey()){
                    password.append (c);
                    new Timer().schedule(new TimerTask() {
						
						@Override
						public void run() {
							StringBuilder dummy = new StringBuilder();
							for(int i = 0; i < password.length(); i++) {
								dummy.append(echoChar);
							}
							setText(dummy.toString());
							setCaretPosition(dummy.length());
						}
					}, 5);
                }
            }
        });
    }
     
//  @Override
//  public void copy (){
//      if (echoEnabled)
//          UIManager.getLookAndFeel().provideErrorFeedback(this);
//      else
//          super.copy();
//  }
//  
//  @Override
//  public void cut (){
//      if (echoEnabled)
//          UIManager.getLookAndFeel().provideErrorFeedback(this);
//      else
//          super.cut();
//  }
//  
//  @Override
//  public void paste (){
//      if (echoEnabled)
//          UIManager.getLookAndFeel().provideErrorFeedback(this);
//      else
//          super.paste();
//  }
     
    public void disableMasking (){
        echoEnabled = false;
        setText(password.toString());
        clearPassword();
    }
     
    public char[] getPassword (){
        char[] pw = new char[password.length()];
        for (int i = 0; i < pw.length; i++)
            pw[i] = password.charAt(i);
         
        return pw;
    }
     
    public void clearPassword (){
        for (int i = 0; i < password.length(); i++)
            password.setCharAt(i, '0');
         
        password = new StringBuilder ();
    }   
}
