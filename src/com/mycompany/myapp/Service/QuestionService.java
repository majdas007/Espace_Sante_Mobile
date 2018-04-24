/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.Entite.Question;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author majd
 */
public class QuestionService {
    
    
  public ArrayList<Question> getListTask(String json) {

        ArrayList<Question> QuestionList = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(etudiants);
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("root");

            for (Map<String, Object> obj : list) {
                Question e = new Question();

                
           
                QuestionList.add(e);

            }

        } catch (IOException ex) {
        }
        System.out.println(QuestionList);
        return QuestionList;

    }
  
  ArrayList<Question> listQuestion = new ArrayList<>();
  
   public ArrayList<Question> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/EspaceSante/web/app_dev.php/apiquest");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                QuestionService ser = new QuestionService();
                listQuestion = ser.getListTask(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listQuestion;
    }
    
}
