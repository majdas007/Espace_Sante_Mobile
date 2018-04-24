/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;

/**
 *
 * @author majd
 */
public class ForumUI {
    
       Form f;
   
    Button btnajout,btnaff;

    public ForumUI() {
        f = new Form("Forum Espace Sante");
        
        btnajout = new Button("Proposer Question");
        btnaff=new Button("Voir Les questions");
      
        f.add(btnajout);
        f.add(btnaff);
        
         btnajout.addActionListener((e)->{
        AddQuestion a=new AddQuestion();
        a.getF().show();
        });
        
        
         btnaff.addActionListener((e)->{
        QuestionUi a=new QuestionUi();
        a.getF().show();
        });
       
       
    }
       
     public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
     
    }

