package com.route.calculator_c36_offline;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    TextView player1Score, player2Score;
    ConstraintLayout root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        player1Score = findViewById(R.id.player1ScoreTv);
        player2Score = findViewById(R.id.player2ScoreTv);
        root = findViewById(R.id.rootLayout);
        intiliazeBoard();
    }

    int counter = 0;
    ArrayList<String> board ;

    public void intiliazeBoard() {
        board = new ArrayList<String>();
        for (int i = 0; i < 9; i++) {
            board.add("");
        }
    }
    public void onButtonClicked(View v) {
        Button clickedButton = (Button) v;
        if (!clickedButton.getText().toString().isEmpty()) return;
        String symbol = counter % 2 == 0 ? "O" : "X";
        clickedButton.setText(symbol);
        fillList(clickedButton.getId(), symbol);
        counter++;
        if(checkWinner(symbol)){
            if(symbol.equals("X")){
               int currentScore = new Integer(player2Score.getText().toString()) ;
              player2Score.setText(++currentScore+"");
            }else {
                int currentScore = new Integer(player1Score.getText().toString());
                player1Score.setText(++currentScore + "");
            }
            resetBoard();
        }

        if(counter == 9){
            resetBoard();
        }
    }

    private void resetBoard() {
        counter = 0;
        intiliazeBoard();
        for(int i = 0; i< root.getChildCount();i++){
            if(root.getChildAt(i) instanceof Button){
                ((Button) root.getChildAt(i)).setText("");
            }
        }
    }

    public boolean checkWinner(String symbol) {
        for (int i = 0; i < 9; i = i + 3) {
            if (board.get(i).equals(symbol) &&
                    board.get(i + 1).equals(symbol) &&
                    board.get(i + 2).equals(symbol)) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board.get(i).equals(symbol) &&
                    board.get(i + 3).equals(symbol) &&
                    board.get(i + 6).equals(symbol)) {
                return true;
            }
        }
        if (board.get(2).equals(symbol) &&
                board.get(4).equals(symbol) &&
                board.get(6).equals(symbol)) {
            return true;
        }
        return board.get(0).equals(symbol) &&
                board.get(4).equals(symbol) &&
                board.get(8).equals(symbol);
    }

    public void fillList(int id, String symbol) {
        if (id == R.id.button1) {
            board.set(0, symbol);
        } else if (id == R.id.button2) {
            board.set(1, symbol);
        } else if (id == R.id.button3) {
            board.set(2, symbol);
        } else if (id == R.id.button4) {
            board.set(3, symbol);
        } else if (id == R.id.button5) {
            board.set(4, symbol);
        } else if (id == R.id.button6) {
            board.set(5, symbol);
        } else if (id == R.id.button7) {
            board.set(6, symbol);
        } else if (id == R.id.button8) {
            board.set(7, symbol);
        } else if (id == R.id.button9) {
            board.set(8, symbol);
        }
    }
}