package com.example.nowredux;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Now extends Activity {
    private Context context;
    private Boolean questionBoolean;
    private TextView question;
    private int questionNum=0;

    private LinkedHashMap<String, Boolean> questions=new LinkedHashMap<String, Boolean>();

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        setQuestions();
        context = getApplicationContext();
        question = findViewById(R.id.text_question);
        nextQuestion(0);
    }

    public void nextQuestion(int number){
        //CharSequence text = (CharSequence)getElementByIndex(questions, number);
        question.setText((CharSequence)(questions.keySet().toArray())[ number ] );
        questionBoolean = questions.get( (questions.values().toArray())[ number ] );
    }

    private void setQuestions(){
        questions.put("Is the earth flat?", false);
        questions.put("Is this built in java?", true);
        questions.put("Are you human?", true);
    }

    public void checkTrueFalse(View view) {
        Context context = getApplicationContext();
        String resourceName = view.getResources().getResourceName(view.getId());
        CharSequence text;
        CharSequence textTrue = "True. Great!";
        CharSequence textFalse = "False you bastard";
        if(resourceName.equals("button_False")){
            if(questionBoolean){
                text = textTrue;
            }else{
                text= textFalse;
            }
        }else{
            if(questionBoolean){
                text= textFalse;
            }else{
                text = textTrue;
            }
        }

        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        questionNum ++;
        nextQuestion(questionNum);
    }

    private Object getElementByIndex(LinkedHashMap map,int index){
        return map.get( (map.keySet().toArray())[ index ] );
    }
}