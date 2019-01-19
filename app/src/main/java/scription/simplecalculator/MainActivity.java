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
    boolean alreadyDecimal;

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
        alreadyDecimal = false;
    }

    public void addValue(View view) {
        if(end) {
            end = false;
            firstValue = true;
            total = 0;
        }
        Button b = (Button) view;
        String buttonText = b.getText().toString();
        if(buttonText.equals(".") && alreadyDecimal) {
            return;
        }
        else if(buttonText.equals(".")) {
            alreadyDecimal = true;
        }
        currentValue += buttonText;
        displayBox.setText(currentValue);
    }

    public void setOperand(View view) {
        Button b = (Button) view;
        operand = b.getText().toString();
        if(end) {
            end = false;
        }
        else if((!currentValue.equals("") && !currentValue.equals(".")) && !firstValue) {
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
        } else if((!currentValue.equals("") && !currentValue.equals(".")) && firstValue) {
            total += Double.valueOf(currentValue);
            firstValue = false;
        } else {
            operand = "";
            return;
        }
        currentValue = "";
        positive = true;
        alreadyDecimal = false;
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
        alreadyDecimal = false;
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
        alreadyDecimal = false;
    }

    public void backspace(View view) {
        if(!currentValue.equals("") && !end) {
            int length = currentValue.length();
            currentValue = currentValue.substring(0,length - 1);
            displayBox.setText(currentValue);
        }
    }

    public void squareRoot(View view) {
        if(!currentValue.equals("") && !end) {
            double value = Double.valueOf(currentValue);
            value = Math.sqrt(value);
            currentValue = Double.toString(value);
            displayBox.setText(currentValue);

        }
        else if (end) {
            total = Math.sqrt(total);
            displayBox.setText(Double.toString(total));
        }
    }

    public void percent(View view) {
        if(!currentValue.equals("") && !end) {
            double percentage = Double.valueOf(currentValue);
            percentage = total * (percentage / 100);
            currentValue = Double.toString(percentage);
            displayBox.setText(currentValue);
        }
    }
}
