/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.mycompany.myapp.Entite.Question;
import com.mycompany.myapp.Service.QuestionService;

/**
 *
 * @author majd
 */
public class AddQuestion {
    
    Form f;
    TextArea Contenu ;
    TextField subject ; 
    Button add ;
    
    public AddQuestion()
    {
        f = new Form("Propose Your Question");
        Contenu = new TextField();
        subject = new TextField();
        add = new Button("add Question");
        f.add(subject);
        f.add(Contenu);
        f.add(add);
        
        add.addActionListener((evt) -> {
           Question quest = new Question(subject.getText(),Contenu.getText()) ;
           QuestionService QuestionService =new QuestionService();
           QuestionService.addQuest(quest);
           
        });
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{ForumUI h=new ForumUI();
          h.getF().show();
          }); 
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
    
}
