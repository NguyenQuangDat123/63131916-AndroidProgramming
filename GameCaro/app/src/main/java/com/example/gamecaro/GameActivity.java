package com.example.gamecaro;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    private static final int BOARD_SIZE = 10;
    private Button[][] buttons = new Button[BOARD_SIZE][BOARD_SIZE];
    private boolean playerXTurn = true; // true = X, false = O

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        try {
            GridLayout gameBoard = findViewById(R.id.gameBoard);
            gameBoard.setRowCount(BOARD_SIZE);
            gameBoard.setColumnCount(BOARD_SIZE);

            // Tạo bàn cờ caro
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    Button button = new Button(this);
                    button.setTextSize(18);
                    button.setBackgroundColor(0xFFD7CCC8);
                    button.setOnClickListener(new CellClickListener(i, j));

                    GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                    params.width = 100;
                    params.height = 100;
                    button.setLayoutParams(params);

                    gameBoard.addView(button);
                    buttons[i][j] = button;
                }
            }

            // Xử lý nút Menu
            Button menuButton = findViewById(R.id.menuButton);
            menuButton.setOnClickListener(v -> {
                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            });

            // Xử lý nút Chơi lại
            Button restartButton = findViewById(R.id.restartButton);
            restartButton.setOnClickListener(v -> resetBoard());

        } catch (Exception e) {
            Log.e("GameActivity", "Lỗi khi khởi tạo bàn cờ", e);
        }
    }

    // Xử lý sự kiện khi bấm vào ô bàn cờ
    private class CellClickListener implements View.OnClickListener {
        private int row, col;

        CellClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void onClick(View v) {
            try {
                Button button = (Button) v;
                if (button.getText().toString().equals("")) {
                    button.setText(playerXTurn ? "X" : "O");
                    button.setTextSize(24);
                    playerXTurn = !playerXTurn;

                    if (checkWin()) {
                        showWinDialog(playerXTurn ? "O" : "X");
                    }
                }
            } catch (Exception e) {
                Log.e("GameActivity", "Lỗi khi xử lý nước đi", e);
            }
        }
    }

    // Kiểm tra chiến thắng
    private boolean checkWin() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (!buttons[i][j].getText().toString().equals("") && checkFiveInRow(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Kiểm tra 5 dấu liên tiếp theo các hướng
    private boolean checkFiveInRow(int row, int col) {
        String symbol = buttons[row][col].getText().toString();
        return checkDirection(row, col, 1, 0, symbol) || // Ngang
                checkDirection(row, col, 0, 1, symbol) || // Dọc
                checkDirection(row, col, 1, 1, symbol) || // Chéo xuống
                checkDirection(row, col, 1, -1, symbol);  // Chéo lên
    }

    private boolean checkDirection(int row, int col, int dx, int dy, String symbol) {
        int count = 0;
        for (int i = -4; i <= 4; i++) {
            int r = row + i * dx, c = col + i * dy;
            if (r >= 0 && c >= 0 && r < BOARD_SIZE && c < BOARD_SIZE &&
                    buttons[r][c].getText().toString().equals(symbol)) {
                count++;
                if (count == 5) return true;
            } else count = 0;
        }
        return false;
    }

    private void showWinDialog(String winner) {
        Toast.makeText(this, "Người chơi " + winner + " chiến thắng!", Toast.LENGTH_LONG).show();
    }

    private void resetBoard() {
        for (Button[] row : buttons) {
            for (Button button : row) {
                button.setText("");
            }
        }
        playerXTurn = true;
    }
}
