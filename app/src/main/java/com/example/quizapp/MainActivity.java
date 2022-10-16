package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView questionTV,questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<QuizModal> quizModalArrayList;
    Random random;
    int currentScore=0, questionAttempted=0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV=findViewById(R.id.idTVQuestionAttempted);
        option1Btn= findViewById(R.id.idBtnOption1);
        option2Btn= findViewById(R.id.idBtnOption2);
        option3Btn= findViewById(R.id.idBtnOption3);
        option4Btn= findViewById(R.id.idBtnOption4);
        quizModalArrayList= new ArrayList<>();
        random= new Random();
        getQuizQuestion(quizModalArrayList);
        currentPos= random.nextInt(quizModalArrayList.size());
        setDataToView(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option1Btn.getText().toString().trim())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizModalArrayList.size());
                setDataToView(currentPos);
            }
        });

        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizModalArrayList.size());
                setDataToView(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizModalArrayList.size());
                setDataToView(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizModalArrayList.size());
                setDataToView(currentPos);
            }
        });
    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog= new BottomSheetDialog(MainActivity.this);
        View bottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is \n"+ currentScore +"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionAttempted=0;
                currentPos=random.nextInt(quizModalArrayList.size());
                setDataToView(currentPos);
                currentScore=0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setDataToView(int currentPos){
        questionNumberTV.setText("Questions Attempted : "+ questionAttempted+ "/10");

        if(questionAttempted==10){
            showBottomSheet();
        }
        else{
            questionTV.setText(quizModalArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModalArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModalArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModalArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModalArrayList.get(currentPos).getOption4());
        }


    }

    private void getQuizQuestion(ArrayList<QuizModal> quizModalArrayList) {
        quizModalArrayList.add(new QuizModal("What is part of a database that holds only one type of information?", "Report", "Field", "Record", "File",  "Field"));
        quizModalArrayList.add(new QuizModal(".MOV extension refers usually to what kind of file?", "Image file", "Animation/movie file", "Audio file", "MS Office document",  "Animation/movie file"));
        quizModalArrayList.add(new QuizModal("In order of their distances from the Sun, which of the following planets lie between Mars and Uranus?", "Earth and Jupiter", "Jupiter and Saturn", "Saturn and Earth", "Saturn and Neptune",  "Jupiter and Saturn"));
        quizModalArrayList.add(new QuizModal("Which of the following is indicated by the colour of a star?", "Weight", "Distance", "Temperature", "Size",  "Temperature"));
        quizModalArrayList.add(new QuizModal("Milky Way Galaxy was first seen by", "Galileo", "Martin Schmidt", "Marconi", "Newton",  "Galileo"));
        quizModalArrayList.add(new QuizModal("Which of the following terms is not used in the field of physics?", "Latent heat", "Nuclear fusion", "Refractive index", "Stock value",  "Stock value"));
        quizModalArrayList.add(new QuizModal("Light year is a unit of", "Time", "Distance", "Light", "Intensity of light",  "Distance"));
        quizModalArrayList.add(new QuizModal("Which scientist discovered the radioactive element radium?", "Isaac Newton", "Albert Einstein", "Benjamin Franklin", "Marie Curie",  "Marie Curie"));
        quizModalArrayList.add(new QuizModal("What James Watt invented?", "Diving bell", "Steam boat", "Hot air balloon", "Rotary steam engine",  "Rotary steam engine"));
        quizModalArrayList.add(new QuizModal("Who is the father of Geometry?", "Aristotle", "Euclid", "Pythagoras", "Kepler",  "Euclid"));
        quizModalArrayList.add(new QuizModal("Who was known as Iron man of India?", "Govind Ballabh Pant", "Jawaharlal Nehru", "Subhash Chandra Bose", "Sardar Vallabhbhai Patel",  "Sardar Vallabhbhai Patel"));
        quizModalArrayList.add(new QuizModal("The Indian to beat the computers in mathematical wizardry is?", "Ramanujan", "Rina Panigrahi", "Raja Ramanna", "Shakunthala Devi",  "Shakunthala Devi"));
        quizModalArrayList.add(new QuizModal("Water vapour is:", "A gas", "A cloud droplet", "A rain drop", "A snowflake",  "A gas"));
        quizModalArrayList.add(new QuizModal("Economically the most important forests of India are?", "Tidal forest", "Thorn forest", "Evergreen forest", "Tropical deciduous forest",  "Tropical deciduous forest"));
        quizModalArrayList.add(new QuizModal("Atmospheric humidity is measured by?", "Psychrometer", "Anemometer", "Lysimeter", "Hydrometer",  "Psychrometer"));
        quizModalArrayList.add(new QuizModal("Which is the warmest layer of the atmosphere?", "Thermosphere", "Troposphere", "Stratosphere", "Mesosphere",  "Thermosphere"));
        quizModalArrayList.add(new QuizModal("Very small time intervals are accurately measure by?", "White dwarfs", "Quartz clocks", "Atomic clocks", "Pulsars",  "Atomic clocks"));
        quizModalArrayList.add(new QuizModal("One kilometer is equal to how many miles?", "0.84", "0.5", "1.6", "0.62",  "0.62"));
        quizModalArrayList.add(new QuizModal("One horse power is equal to?", "746 watts", "748 watts", "756 watts", "736 watts",  "746 watts"));
        quizModalArrayList.add(new QuizModal("Electric current is measure by:", "Commutator", "Anemometer", "Ammeter", "Voltmeter",  "Ammeter"));
        quizModalArrayList.add(new QuizModal("A chronometer measures:", "Colour contrast", "Sound waves", "Time", " Water waves",  "Time"));
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}