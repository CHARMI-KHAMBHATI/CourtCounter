package com.example.android.courtcounter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
// variables for two teams
    public static int team_a=0;
    public static int team_b=0;


// functions for Team A
    // This function is called on clicking +3 of team  A
    public void addthreeA(View view){
        team_a=team_a+3;
        displayA(team_a);
        msg();

    }

    // This function is called on clicking +2 of team  A
    public void addtwoA(View view){
        team_a=team_a+2;
        displayA(team_a);
        msg();
    }

    // This function is called on clicking +1 of team  A
    public void addoneA(View view){
        team_a++;
        displayA(team_a);
        msg();
    }

    // displays score of team A
    private void displayA(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.score1);
        quantityTextView.setText("" + number);
    }

 // Functions for Team B
    // This function is called on clicking +3 of team  B
    public void addthreeB(View view){
        team_b=team_b+3;
        displayB(team_b);
        msg();

    }

    // This function is called on clicking +2 of team  B
    public void addtwoB(View view){
        team_b=team_b+2;
        displayB(team_b);
        msg();

    }

    // This function is called on clicking +1 of team  B
    public void addoneB(View view){
        team_b++;
        displayB(team_b);
        msg();

    }

    // This function displays score of team B
    private void displayB(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.score2);
        quantityTextView.setText("" + number);
    }


// Common functions
    // This function displays the winner
    private void msg() {
        TextView quantityTextView = (TextView) findViewById(R.id.winner);
        if(team_a>team_b){
            quantityTextView.setText("Team A is leading");
        }
        else
        if(team_b>team_a) {
            quantityTextView.setText("Team B is leading");
        }

        else
            quantityTextView.setText("Match at equal level......");
    }

    // on clicking reset button; reset scores to zero
    public void reset(View view){
        team_a=0;
        team_b=0;
        displayA(team_a);
        displayB(team_b);
        msg();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, "chk");
        intent.putExtra(Intent.EXTRA_SUBJECT, team_a);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}// End of class
