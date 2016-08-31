package com.example.santosh.healthmonitoringbygraph;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridLayout.Spec;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.Toast;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize basic code here
        //init graph view
        float[] sample = new float[]{1, 2, 5, 7, 6};
        String[] hlabel = new String[]{"X", "1","2","3"};
        String[] vlabel = new String[]{"Y", "10","20","30"};
        final boolean[] timerFlag = {false};
        final String MY_TAG = "debugging";

        final Patient p = new Patient(1, 11, "Momo", Patient.MALE, 10);
        final GraphView graph = new GraphView(this, sample, "Sample view", hlabel, vlabel, GraphView.BAR);

        int graphId = graph.generateViewId();
        graph.setBackgroundColor(Color.BLACK);

        final Handler timerHandler = new Handler();
        final Runnable timerRunnable = new Runnable() {
            @Override
            public void run() {
                timerFlag[0] = true;
                p.setPatientData(10);
                float f[] = p.getPatientData();
                Log.d(MY_TAG, "Chal chutiye");
                graph.setValues(f);
//                 Redraw the graph
                graph.invalidate();


//                Toast startToast = Toast.makeText(getBaseContext(), "Timer Up", Toast.LENGTH_LONG);
//                startToast.show();

                // Repost the run method in the queue so that it can be called again after 100 ms
                timerHandler.postDelayed(this, 1000);
            }
        };

        //baseLayout.addView(graph);
//        RelativeLayout.LayoutParams graphRules = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//        RelativeLayout.LayoutParams buttonRules = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//        RelativeLayout.LayoutParams buttonRulesForStop = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//
//        graphRules.addRule(RelativeLayout.ALIGN_BOTTOM);
//        buttonRules.addRule(RelativeLayout.ALIGN_PARENT_TOP);
//        buttonRulesForStop.addRule(RelativeLayout.CENTER_HORIZONTAL);
//        graph.setPadding(50, 50, 50, 50);



        Button start = new Button(this);
        Button stop = new Button(this);



        int startId, stopId;
        startId = start.generateViewId();
        stopId = stop.generateViewId();

        start.setText("Start");
        stop.setText("Stop");

        start.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Toast startToast = Toast.makeText(getApplicationContext(), "Start Pressed", Toast.LENGTH_LONG);
                //startToast.show();
                if (!timerFlag[0]) {
                    timerHandler.postDelayed(timerRunnable, 0);
                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Toast startToast = Toast.makeText(getApplicationContext(), "Stop Pressed", Toast.LENGTH_LONG);
                //startToast.show();
                timerHandler.removeCallbacks(timerRunnable);
            }
        });

        //adding all views to layout
        //RelativeLayout overallLayout = new RelativeLayout(this);

        Spec row1 = GridLayout.spec(0);
        Spec row2 = GridLayout.spec(1);


        Spec col0 = GridLayout.spec(0);
        Spec col1 = GridLayout.spec(1);


        GridLayout lowerPartLayout = new GridLayout(this);
        GridLayout.LayoutParams first = new GridLayout.LayoutParams(row2, col0);

        GridLayout.LayoutParams second = new GridLayout.LayoutParams(row1, col0);
        GridLayout.LayoutParams third = new GridLayout.LayoutParams(row1, col0);

//        baseLayout.setPadding(100, 100, 100, 100);
//        baseLayout.setGravity(20);R

        first.width = 1000;
        first.height = 1500;
        second.width = 300;
        second.height = 150;
        third.width = 300;
        third.height = 150;

        second.setGravity(Gravity.TOP);
        second.setGravity(Gravity.LEFT);
        third.setGravity(Gravity.TOP);
        third.setGravity(Gravity.RIGHT);

        lowerPartLayout.setBackgroundColor(Color.BLACK);
        lowerPartLayout.addView(graph,first);
        lowerPartLayout.addView(start, second);
        lowerPartLayout.addView(stop, third);
        setContentView(lowerPartLayout);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
