package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.FingerprintGestureController;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mydb;
    int count;

    char[] board = new char[]{'_', '_', '_','_','_','_','_','_','_'};
    int[] red = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[] green = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DatabaseHelper(this);

    }


    public void clicked(View view) {
        count++;
        Button temp;
        switch (view.getId()) {
            case R.id.col1:
                temp = (Button) findViewById(R.id.col1);
                mark(temp, 0);

                break;
            case R.id.col2:
                temp = (Button) findViewById(R.id.col2);
                mark(temp, 1);

                break;
            case R.id.col3:
                temp = (Button) findViewById(R.id.col3);
                mark(temp, 2);

                break;
            case R.id.col4:
                temp = (Button) findViewById(R.id.col4);
                mark(temp, 3);
                break;
            case R.id.col5:
                temp = (Button) findViewById(R.id.col5);
                mark(temp, 4);
                break;
            case R.id.col6:
                temp = (Button) findViewById(R.id.col6);
                mark(temp, 5);

                break;
            case R.id.col7:
                temp = (Button) findViewById(R.id.col7);
                mark(temp, 6);

                break;
            case R.id.col8:
                temp = (Button) findViewById(R.id.col8);
                mark(temp, 7);

                break;
            case R.id.col9:
                temp = (Button) findViewById(R.id.col9);
                mark(temp, 8);

                break;
            default:
                break;
        }

    }

    public void mark(Button temp, int i) {
        Button botbutton;
        if (count % 2 == 0) {
            temp.setBackgroundResource(R.drawable.cross);

            temp.setEnabled(false);

            red[i] = 1;
            board[i] = 'R';
            if (redWinner()) {
                Toast.makeText(getApplicationContext(), "Red is Winner", Toast.LENGTH_SHORT).show();
                temp = (Button) findViewById(R.id.reset);
                temp.performClick();

            }


        } else if (count % 2 != 0) {

            temp.setBackgroundResource(R.drawable.zero);
            temp.setEnabled(false);

            green[i] = 1;
            board[i] = 'G';
            if (greenWinner()) {
                Toast.makeText(getApplicationContext(), "Green is Winner", Toast.LENGTH_SHORT).show();
                temp = (Button) findViewById(R.id.reset);
                temp.performClick();

            } else
                botmove();
        } else if (count == 9) {
            Log.d("im here", "yobro");
            if (draw()) {
                Toast.makeText(getApplicationContext(), "match draw", Toast.LENGTH_SHORT).show();
                temp = (Button) findViewById(R.id.reset);
                temp.performClick();
            }
        } else {

        }

        //printarray();

    }

    public void reset(View view) {

        Button button;

        button = (Button) findViewById(R.id.col1);
        button.setBackgroundResource(android.R.color.transparent);
        button.setEnabled(true);

        button = (Button) findViewById(R.id.col2);
        button.setBackgroundResource(android.R.color.transparent);

        button.setEnabled(true);

        button = (Button) findViewById(R.id.col3);
        button.setBackgroundResource(android.R.color.transparent);

        button.setEnabled(true);

        button = (Button) findViewById(R.id.col4);
        button.setBackgroundResource(android.R.color.transparent);

        button.setEnabled(true);

        button = (Button) findViewById(R.id.col5);
        button.setBackgroundResource(android.R.color.transparent);

        button.setEnabled(true);

        button = (Button) findViewById(R.id.col6);
        button.setBackgroundResource(android.R.color.transparent);

        button.setEnabled(true);

        button = (Button) findViewById(R.id.col7);
        button.setBackgroundResource(android.R.color.transparent);

        button.setEnabled(true);

        button = (Button) findViewById(R.id.col8);
        button.setBackgroundResource(android.R.color.transparent);
        button.setEnabled(true);

        button = (Button) findViewById(R.id.col9);
        button.setBackgroundResource(android.R.color.transparent);

        button.setEnabled(true);

        count = 0;
        for (int i = 0; i < 9; i++) {
            board[i] = '_';
            red[i] = 0;
            green[i] = 0;
        }
    }

    public void printarray() {
        for (int i = 0; i < 9; i++) {
            Log.d("array empty" + i, Integer.toString(board[i]));


        }
        for (int i = 0; i < 9; i++) {
            Log.d("array red" + i, Integer.toString(red[i]));

        }
        for (int i = 0; i < 9; i++) {
            Log.d("array green" + i, Integer.toString(green[i]));

        }
        Log.d("count : ", Integer.toString(count));
    }

    public boolean redWinner() {
        if ((red[0] == 1 && red[1] == 1 && red[2] == 1) || (red[3] == 1 && red[4] == 1 && red[5] == 1) || (red[6] == 1 && red[7] == 1 && red[8] == 1) || (red[0] == 1 && red[4] == 1 && red[8] == 1) || (red[2] == 1 && red[4] == 1 && red[6] == 1) || (red[0] == 1 && red[3] == 1 && red[6] == 1) || (red[1] == 1 && red[4] == 1 && red[7] == 1) || (red[2] == 1 && red[5] == 1 && red[8] == 1)) {

            return true;

        } else return false;
    }

    public boolean greenWinner() {

        if ((green[0] == 1 && green[1] == 1 && green[2] == 1) || (green[3] == 1 && green[4] == 1 && green[5] == 1) || (green[6] == 1 && green[7] == 1 && green[8] == 1) || (green[0] == 1 && green[4] == 1 && green[8] == 1) || (green[2] == 1 && green[4] == 1 && green[6] == 1) || (green[0] == 1 && green[3] == 1 && green[6] == 1) || (green[1] == 1 && green[4] == 1 && green[7] == 1) || (green[2] == 1 && green[5] == 1 && green[8] == 1)) {

            return true;
        } else return false;
    }

    public boolean draw() {
        int flag = 0;
        for (int i = 0; i < 9; i++) {
            if (board[i] == '_') {
                flag++;
            }

        }
        if (flag > 0) {
            return false;
        } else return true;
    }


    public void botmove() {
        Button button;
        int i=bestMove(board);


        Log.d("value of i", Integer.toString(i));
        switch (i) {
            case 0:
                button = (Button) findViewById(R.id.col1);
                button.performClick();
                break;
            case 1:
                button = (Button) findViewById(R.id.col2);
                button.performClick();

                break;
            case 2:
                button = (Button) findViewById(R.id.col3);
                button.performClick();

                break;
            case 3:
                button = (Button) findViewById(R.id.col4);
                button.performClick();

                break;
            case 4:
                button = (Button) findViewById(R.id.col5);
                button.performClick();

                break;
            case 5:
                button = (Button) findViewById(R.id.col6);
                button.performClick();

                break;
            case 6:
                button = (Button) findViewById(R.id.col7);
                button.performClick();

                break;
            case 7:
                button = (Button) findViewById(R.id.col8);
                button.performClick();

                break;
            case 8:
                button = (Button) findViewById(R.id.col9);
                button.performClick();

                break;
        }


    }
    public int bestMove(char[] board) {
        int bestmove=5;
        int bestVal = -1000;
        for (int i = 0; i < 9; i++) {
            if (board[i] == '_') {
                board[i] = 'R';
                int moveVal = minmax(board,0,false);
                board[i] = '_';
                if (moveVal > bestVal) {
                    bestmove = i;
                    bestVal=moveVal;
                }
            }
        }
        return bestmove;
    }

    public int minmax(char[] board2,int depth,boolean isbot) {

        int score=evaluate(board2);
        if(score==10)
            return score;
        if(score==-10)
            return score;

        if(isbot){
            int best=-1000;
            for(int i=0;i<9;i++){
                if(board2[i]=='_'){
                    board2[i]='R';
                    best=max(best,minmax(board2,depth+1,false));
                    board2[i]='_';
                }
            }
            return best;
        }
        else{
            int best=1000;
            for(int i=0;i<9;i++){
                if(board2[i]=='_'){
                    board2[i]='G';
                    best=min(best,minmax(board2,depth+1,true));
                    board2[i]='_';
                }
            }
            return best;
        }



    }

    public int evaluate(char[] board3){
      //draw

        if(greenIsWinning(board3))
            return +10; //human is winner
        else if(redIsWinning(board3))
            return -10; //bot is winner
        return 0;

    }
    public  Boolean redIsWinning(char[] board)
    {
        if ((board[0] == 'R' && board[1] == 'R' && board[2] == 'R') || (board[3] == 'R' && board[4] == 'R' && board[5] == 'R') || (board[6] == 'R' && board[7] == 'R' && board[8] == 'R') || (board[0] == 'R' && board[3] == 'R' && board[6] == 'R') || (board[1] == 'R' && board[4] == 'R' && board[7] == 'R') || (board[2] == 'R' && board[5] == 'R' && board[8] == 'R') || (board[0] == 'R' && board[4] == 'R' && board[8] == 'R') || (board[4] == 'R' && board[6] == 'R' && board[2] == 'R'))
            return true;
        else
            return false;
    }
    public  Boolean greenIsWinning(char[] board)
    {
        if ((board[0] == 'G' && board[1] == 'G' && board[2] == 'G') || (board[3] == 'G' && board[4] == 'G' && board[5] == 'G') || (board[6] == 'G' && board[7] == 'G' && board[8] == 'G') || (board[0] == 'G' && board[3] == 'G' && board[6] == 'G') || (board[1] == 'G' && board[4] == 'G' && board[7] == 'G') || (board[2] == 'G' && board[5] == 'G' && board[8] == 'G') || (board[0] == 'G' && board[4] == 'G' && board[8] == 'G') || (board[4] == 'G' && board[6] == 'G' && board[2] == 'G'))
            return true;
        else
            return false;
    }
}
