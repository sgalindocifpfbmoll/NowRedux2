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
import java.util.Random;

public class Now extends Activity {
    private Context context;
    private Boolean questionBoolean;
    private TextView question;
    private HashMap<String, Boolean> questions=new HashMap<String, Boolean>();

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        setQuestions();
        context = getApplicationContext();
        question = findViewById(R.id.text_question);
        nextRandomQuestion();
    }

    public void nextRandomQuestion(){
        Random generator = new Random();
        Object[] values = questions.values().toArray();
        Object[] keys = questions.keySet().toArray();
        generator.nextInt(questions.size());    // number
        Object randomValue = values[generator.nextInt(values.length)];
        Object randomKey = keys[generator.nextInt(values.length)];
        question.setText((String)randomKey);
        questionBoolean = (Boolean)randomValue;
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
        nextRandomQuestion();
    }
}