package com.example.a8puzzleproblem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SearchResultActivity extends AppCompatActivity {


    TextView tvTitle, tvIsSolvable , tvActions, tvTotalCost
            , tvDepth , tvExpandedNodes , tvTotalTime , tvResult , tvProcessing;

    LinearLayout llResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        findViews();

        Bundle bundle=getIntent().getExtras();
        int selectedAlgorithm=bundle.getInt("searchAlgorithm");
        int selectedHeuristic=bundle.getInt("heuristic");
        startSearch(selectedAlgorithm , selectedHeuristic);



    }

    public void startSearch(int selectedAlgorithm , int selectedHeuristic)
    {
        Node initialNode=new Node(new State(MainActivity.initialNumbers) , 0 , 0 , 0 , null);

        switch (selectedAlgorithm)
        {
            case 1:
                //ucs
                ucs(initialNode);
                break;
            case 2:
                ids(initialNode);
                //ids
                break;
            case 3:
                //A*
                aStar(initialNode , selectedHeuristic);
                break;
            case 4:
                //IDA*
                break;
        }

    }

    public void aStar(Node initialNode , int h)
    {
        AStarSearch search=new AStarSearch(initialNode);
        Node result = null;

        if (!search.isSolvable())
        {
            tvProcessing.setText("Not Solvable");
            tvProcessing.setVisibility(View.VISIBLE);
            llResult.setVisibility(View.GONE);

        }
        else
        {

            //time
            long startTime=System.currentTimeMillis();

            //searching
            if (h==1)
            {
                result=search.search(1);
            }
            else if(h==2)
            {
                result=search.search(2);
            }

            String string="";
            string+=Time.timeDuration(startTime,System.currentTimeMillis());
            string+=" ms";
            tvTotalTime.setText(string);

            tvProcessing.setVisibility(View.GONE);
            llResult.setVisibility(View.VISIBLE);

            //set Result
            tvResult.setText("\n"+search.savePath(result, ""));
            if (h==1)
            {
                tvTitle.setText(tvTitle.getText().toString() +" A* Search (first heuristic function)");
            }
            else if (h==2)
            {
                tvTitle.setText(tvTitle.getText().toString() +" A* Search (second heuristic function)");
            }
            tvIsSolvable.setText("Yes");
            tvActions.setText(search.saveActions(search.setOfActions(result)));
            String s="";
            s+=search.totalCost(result);
            tvTotalCost.setText(s);
            s="";
            s+=result.getDepth();
            tvDepth.setText(s);
            s="";
            s+=search.numberOfExpandedNodes();
            tvExpandedNodes.setText(s);


        }
    }

    public void ids(Node initialNode)
    {
        IterativeDeepeningSearch search=new IterativeDeepeningSearch(initialNode);

        if (!search.isSolvable())
        {
            tvProcessing.setText("Not Solvable");
            tvProcessing.setVisibility(View.VISIBLE);
            llResult.setVisibility(View.GONE);
        }
        else
        {
            //time
            long startTime=System.currentTimeMillis();
            //searching
            Node result=search.search();

            String string="";
            string+=Time.timeDuration(startTime,System.currentTimeMillis());
            string+=" ms";
            tvTotalTime.setText(string);

            tvProcessing.setVisibility(View.GONE);
            llResult.setVisibility(View.VISIBLE);

            //set Result
            tvResult.setText("\n"+search.savePath(result, ""));
            tvTitle.setText(tvTitle.getText().toString() +" Iterative Deepening Search");
            tvIsSolvable.setText("Yes");
            tvActions.setText(search.saveActions(search.setOfActions(result)));
            String s="";
            s+=search.totalCost(result);
            tvTotalCost.setText(s);
            s="";
            s+=result.getDepth();
            tvDepth.setText(s);
            s="";
            s+=search.numberOfExpandedNodes();
            tvExpandedNodes.setText(s);


        }
    }

    @SuppressLint("SetTextI18n")
    public void ucs(Node initialNode)
    {
        UniformCostSearch search=new UniformCostSearch(initialNode);


        if (!search.isSolvable())
        {
            tvProcessing.setText("Not Solvable");
            tvProcessing.setVisibility(View.VISIBLE);
            llResult.setVisibility(View.GONE);
        }
        else
        {
            //time
            long startTime=System.currentTimeMillis();
            //searching
            Node result=search.search();

            String string="";
            string+=Time.timeDuration(startTime,System.currentTimeMillis());
            string+=" ms";
            tvTotalTime.setText(string);

            tvProcessing.setVisibility(View.GONE);
            llResult.setVisibility(View.VISIBLE);

            //set Result
            tvResult.setText("\n"+search.savePath(result, ""));
            tvTitle.setText(tvTitle.getText().toString() +" Uniform Cost Search");
            tvIsSolvable.setText("Yes");
            tvActions.setText(search.saveActions(search.setOfActions(result)));
            String s="";
            s+=search.totalCost(result);
            tvTotalCost.setText(s);
            s="";
            s+=result.getDepth();
            tvDepth.setText(s);
            s="";
            s+=search.numberOfExpandedNodes();
            tvExpandedNodes.setText(s);


        }

    }


    public void findViews()
    {
        tvTitle=findViewById(R.id.tvTitle);
        tvIsSolvable=findViewById(R.id.tvIsSolvable);
        tvActions=findViewById(R.id.tvActions);
        tvTotalCost=findViewById(R.id.tvTotalCost);
        tvDepth=findViewById(R.id.tvDepth);
        tvExpandedNodes=findViewById(R.id.tvExpandedNodes);
        tvTotalTime=findViewById(R.id.tvTotalTime);
        tvResult=findViewById(R.id.tvResult);
        tvProcessing=findViewById(R.id.tvProcessing);

        llResult=findViewById(R.id.llResult);
    }
}