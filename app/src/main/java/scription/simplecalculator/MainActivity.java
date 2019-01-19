package scription.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private double total;
    private String operand;
    private TextView displayBox;
    private boolean positive;
    private String currentValue;
    private boolean firstValue;
    private boolean end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        total = 0;
        operand = "";
        positive = true;
        displayBox = findViewById(R.id.resultBox);
        currentValue = "";
        firstValue = true;
        end = false;
    }

    public void addValue(View view) {
        if(end) {
            end = false;
            firstValue = true;
            total = 0;
        }
        Button b = (Button) view;
        String buttonText = b.getText().toString();
        currentValue += buttonText;
        displayBox.setText(currentValue);
    }

    public void setOperand(View view) {
        Button b = (Button) view;
        operand = b.getText().toString();
        if(end) {
            end = false;
        }
        else if(!currentValue.equals("") && !firstValue) {
            switch (operand) {
                case "+":
                    total += Double.valueOf(currentValue);
                    break;
                case "-":
                    total -= Double.valueOf(currentValue);
                    break;
                case "*":
                    total *= Double.valueOf(currentValue);
                    break;
                case "/":
                    total /= Double.valueOf(currentValue);
                    break;
            }
        } else {
            total += Double.valueOf(currentValue);
        }
        currentValue = "";
        positive = true;
        displayBox.setText(operand);
    }

    public void displayResult(View view) {
        switch (operand) {
            case "+":
                total += Double.valueOf(currentValue);
                break;
            case "-":
                total -= Double.valueOf(currentValue);
                break;
            case "*":
                total *= Double.valueOf(currentValue);
                break;
            case "/":
                total /= Double.valueOf(currentValue);
                break;
            default:
                if(currentValue.equals("")){
                    break;
                }
                total = Double.valueOf(currentValue);
        }
        displayBox.setText(Double.toString(total));
        currentValue = "";
        operand = "";
        positive = true;
        end = true;
    }

    public void changeSign(View view) {
        if(end) {
            currentValue = Double.toString(total);
            if(currentValue.charAt(0) == '-') {
                currentValue = currentValue.substring(1);
                displayBox.setText(currentValue);
            } else {
                currentValue = "-" + currentValue;
            }
            total = Double.valueOf(currentValue);
            displayBox.setText(currentValue);
        }
        else if(positive) {
            positive = false;
            currentValue = "-" + currentValue;
            displayBox.setText(currentValue);
        } else {
            positive = true;
            if(currentValue.charAt(0) == '-') {
                currentValue = currentValue.substring(1);
                displayBox.setText(currentValue);
            }
        }
    }

    public void clearPressed(View view) {
        total = 0;
        operand = "";
        positive = true;
        currentValue = "";
        displayBox.setText("0");
        firstValue = true;
        end = false;
    }

    public void backspace(View view) {
        if(!currentValue.equals("")) {
            int length = currentValue.length();
            currentValue = currentValue.substring(0,length - 1);
            displayBox.setText(currentValue);
        }
    }
}
