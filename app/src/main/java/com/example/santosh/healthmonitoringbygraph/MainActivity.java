package com.example.santosh.healthmonitoringbygraph;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        float[] sample = new float[]{(float)0, (float)1, (float)2};
        String[] hlabel = new String[]{"X - Axis", "Second value?"};
        String[] vlabel = new String[]{"Y - Axis", "Second value?"};

        GraphView graph = new GraphView(this, sample, "Sample view", hlabel, vlabel, GraphView.LINE);
        //baseLayout.addView(graph);
//        changed here
        ViewGroup.LayoutParams graphRules = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        graph.setLayoutParams(graphRules);
//        graph.setId(1);

        RelativeLayout baseLayout = new RelativeLayout(this);
        baseLayout.addView(graph);

        setContentView(baseLayout);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
//        changed
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

    protected void buildUI(){
    //init graph view
    float[] sample = new float[]{(float)0, (float)1, (float)0, (float)-1};
    String[] hlabel = new String[]{"X - Axis", "Second value?"};
    String[] vlabel = new String[]{"Y - Axis", "Second value?"};

    GraphView graph = new GraphView(this, sample, "Sample view", hlabel, vlabel, GraphView.BAR);
    //baseLayout.addView(graph);
    ViewGroup.LayoutParams graphRules = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

    graph.setLayoutParams(graphRules);


    Button start = new Button(this);
    Button stop = new Button(this);

    start.setText("Start");
    stop.setText("Stop");

    start.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            Toast startToast = Toast.makeText(getApplicationContext(), "Start Pressed", Toast.LENGTH_LONG);
            startToast.show();
        }
    });
    stop.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            Toast startToast = Toast.makeText(getApplicationContext(), "Stop Pressed", Toast.LENGTH_LONG);
            startToast.show();
        }
    });

    //adding all views to layout
    RelativeLayout baseLayout = new RelativeLayout(this);
    baseLayout.addView(graph);
    baseLayout.addView(start, graphRules);
    baseLayout.addView(stop, graphRules);
    setContentView(baseLayout);

}
}
