package scription.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private float total = 0f;
    private char operand = ' ';
    private TextView displayBox = (TextView) findViewById(R.id.resultBox);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addValue(View view) {
        Button b = (Button) view;
        String buttonText = b.getText().toString();
        int value = Integer.valueOf(buttonText);
        switch(operand) {
            case '+':
                total += value;
            case '-':
                total -= value;
            case '*':
                total *= value;
            case '/':
                total /= value;
            default:
                total = value;
        }
        displayBox.setText(Float.toString(total));
    }

    public void setOperand(View view) {
        Button b = (Button) view;
        operand = b.getText().charAt(0);
        displayBox.setText(operand);
    }
}
