package com.example.a8puzzleproblem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tile0 , tile1, tile2,tile3,tile4,tile5,tile6,tile7,tile8;
    public static ArrayList<Integer> initialNumbers;
    EditText etInitialStage;
    RadioGroup rgAlgorithm , rgHeuristic;
    Button btnApply , btnReset;

    LinearLayout llHeuristic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        initialNumbers=RandomNumbers.randomPuzzle();
        setInitialStage(initialNumbers);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etInitialStage.getText().toString().trim().equals(""))
                {
                    Toast.makeText(MainActivity.this, "fill the Area", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    changeInitialNumbers(etInitialStage.getText().toString().trim());
                    setInitialStage(initialNumbers);
                    etInitialStage.setText("");
                }
            }
        });

        radioGroupFunction();

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedAlgorithm=rgAlgorithm.getCheckedRadioButtonId();
                int selectedHeuristic=rgHeuristic.getCheckedRadioButtonId();

                if(selectedAlgorithm==-1 ||
                        (llHeuristic.getVisibility()==View.VISIBLE && selectedHeuristic==-1))
                {
                    Toast.makeText(MainActivity.this, "Check all the fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int heuristic=0;
                    switch (selectedHeuristic)
                    {
                        case R.id.rbFirstH:
                            heuristic=1;
                            break;
                        case R.id.rbSecondH:
                            heuristic=2;
                            break;
                    }
                    switch (selectedAlgorithm)
                    {
                        case R.id.rbUCS:
                            createIntent(0,1);
                            break;
                        case R.id.rbIDS:
                            createIntent(0,2);
                            break;
                        case R.id.rbAS:
                            createIntent(heuristic,3);
                            break;
                        case R.id.rbIDAS:
                            createIntent(heuristic,4);

                            break;
                    }
                }


            }
        });


    }

    public void createIntent(int heuristic , int searchAlgorithm)
    {
        Intent intent=new Intent(this , SearchResultActivity.class);
        intent.putExtra("heuristic" , heuristic);
        intent.putExtra("searchAlgorithm" , searchAlgorithm);
        startActivity(intent);
    }

    public void radioGroupFunction()
    {
//        rgHeuristic.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                switch (i)
//                {
//                    case R.id.rbFirstH:
//                        break;
//                    case R.id.rbSecondH:
//                        break;
//                }
//            }
//        });

        rgAlgorithm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i)
                {
                    case R.id.rbUCS:
                        if(llHeuristic.getVisibility()==View.VISIBLE)
                        {
                            llHeuristic.setVisibility(View.GONE);
                        }
                        break;
                    case R.id.rbIDS:
                        if(llHeuristic.getVisibility()==View.VISIBLE)
                        {
                            llHeuristic.setVisibility(View.GONE);
                        }
                        break;
                    case R.id.rbAS:
                        if(llHeuristic.getVisibility()==View.GONE)
                        {
                            llHeuristic.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Select a heuristic function",
                                    Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.rbIDAS:
                        if(llHeuristic.getVisibility()==View.GONE)
                        {
                            llHeuristic.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Select a heuristic function",
                                    Toast.LENGTH_SHORT).show();
                        }
                        break;

                }
            }
        });
    }



    public void changeInitialNumbers(String newNumbers)
    {
        for (int i = 0; i < initialNumbers.size(); i++) {
            initialNumbers.set(i , Integer.parseInt(String.valueOf(newNumbers.charAt(i))));
        }
    }



    public void findViews()
    {
        tile0=findViewById(R.id.tile0);
        tile1=findViewById(R.id.tile1);
        tile2=findViewById(R.id.tile2);
        tile3=findViewById(R.id.tile3);
        tile4=findViewById(R.id.tile4);
        tile5=findViewById(R.id.tile5);
        tile6=findViewById(R.id.tile6);
        tile7=findViewById(R.id.tile7);
        tile8=findViewById(R.id.tile8);

        etInitialStage=findViewById(R.id.etInitialStage);

        rgAlgorithm=findViewById(R.id.rgAlgorithm);
        rgHeuristic=findViewById(R.id.rgHeuristic);

        btnApply=findViewById(R.id.btnApply);
        btnReset=findViewById(R.id.btnReset);

        llHeuristic=findViewById(R.id.llHeuristic);

    }

    @SuppressLint("SetTextI18n")
    public void setInitialStage(ArrayList<Integer> numbers)
    {
        tile0.setText(numbers.get(0).toString());
        tile1.setText(numbers.get(1).toString());
        tile2.setText(numbers.get(2).toString());
        tile3.setText(numbers.get(3).toString());
        tile4.setText(numbers.get(4).toString());
        tile5.setText(numbers.get(5).toString());
        tile6.setText(numbers.get(6).toString());
        tile7.setText(numbers.get(7).toString());
        tile8.setText(numbers.get(8).toString());


    }


}