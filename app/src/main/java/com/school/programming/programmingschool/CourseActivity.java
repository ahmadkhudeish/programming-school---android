package com.school.programming.programmingschool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.TableRow;

public class CourseActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        //Enter Full Screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_course);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Course Content");

        //Access to Variable Types Stage Using Table Row
        TableRow typesRow = (TableRow) findViewById(R.id.variableTypesTblRow);
/*

        //Access to Intro Stage Using Table Row
        TableRow introRow = (TableRow) findViewById(R.id.introTblRow);
        introRow.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent myIntent = new Intent(CourseActivity.this, IntroStageActivity.class);
                CourseActivity.this.startActivity(myIntent);
            }
        });
        typesRow.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent myIntent = new Intent(CourseActivity.this, VariableTypesActivity.class);
                CourseActivity.this.startActivity(myIntent);
            }
        });


        //Access to Variable Declaration Stage Using Table Row
        TableRow declarationRow = (TableRow) findViewById(R.id.variableDeclarationTblRow);
        declarationRow.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent myIntent = new Intent(CourseActivity.this, VariableDeclarationActivity.class);
                CourseActivity.this.startActivity(myIntent);
            }
        });


        //Access to Variable Assignment Stage Using Table Row
        TableRow assignmentRow = (TableRow) findViewById(R.id.variableAssignmentTblRow);
        assignmentRow.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent myIntent = new Intent(CourseActivity.this, VariableAssignmentActivity.class);
                CourseActivity.this.startActivity(myIntent);
            }
        });


        //Access to Variable Reading Stage Using Table Row
        TableRow readingRow = (TableRow) findViewById(R.id.variableReadingTblRow);
        readingRow.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent myIntent = new Intent(CourseActivity.this, VariableReadingActivity.class);
                CourseActivity.this.startActivity(myIntent);
            }
        });
*/
        //Access to Variable Naming Conventions Stage Using Table Row
        TableRow namingConventionsRow = (TableRow) findViewById(R.id.variableNamingConventionsTblRow);
        namingConventionsRow.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent myIntent = new Intent(CourseActivity.this, TypesTabbedActivity.class);
                CourseActivity.this.startActivity(myIntent);
            }
        });


    }

}


