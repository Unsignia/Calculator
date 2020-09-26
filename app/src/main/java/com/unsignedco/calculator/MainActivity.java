package com.unsignedco.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText screenTextView;
    TextView prevTextView;
    Spinner spinner;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screenTextView = findViewById(R.id.screenTextView);
        spinner = findViewById(R.id.itemSpinner);
        prevTextView = findViewById(R.id.prevTextView);
        floatingActionButton = findViewById(R.id.floatingActionButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void revealActivity(View v) {
        Bundle options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, v, "transition").toBundle();
        int revealX = (int) (v.getX() + v.getWidth() / 2);
        int revealY = (int) (v.getY() + v.getHeight() / 2);

        Intent intent = new Intent(this, SelectionActivity.class);

        intent.putExtra(SelectionActivity.EXTRA_CIRCULAR_REVEAL_X, revealX);
        intent.putExtra(SelectionActivity.EXTRA_CIRCULAR_REVEAL_Y, revealY);

        ActivityCompat.startActivity(this, intent, options);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        if (pos != 0) {
            String item = parent.getSelectedItem().toString();
            screenTextView.append(item);
            parent.setSelection(0);
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.num1:
                screenTextView.append("1");
                break;
            case R.id.num2:
                screenTextView.append("2");
                break;
            case R.id.num3:
                screenTextView.append("3");
                break;
            case R.id.num4:
                screenTextView.append("4");
                break;
            case R.id.num5:
                screenTextView.append("5");
                break;
            case R.id.num6:
                screenTextView.append("6");
                break;
            case R.id.num7:
                screenTextView.append("7");
                break;
            case R.id.num8:
                screenTextView.append("8");
                break;
            case R.id.num9:
                screenTextView.append("9");
                break;
            case R.id.ceBtn:
                screenTextView.setText("");
                break;
        }
    }

    public void deleteLast(View v) {
        int index = screenTextView.length() - 1;
        String text = screenTextView.getText().toString();

        screenTextView.setText(text.substring(0, index));
    }

    public void computeAns(View v) {
        String text = screenTextView.getText().toString();
        int length = text.length();
        char curr;

        prevTextView.setText(text);
        //TODO create solution to find value base on expression in screenTextView
        // LOGIC : operators cant be next to each other or at from or end
        // Use a while loop to move through each char to logic check

        //TODO check to see if can switch with for loop
        // Add possible symbols that could be used at front

//        if (text.charAt(0) != '0' && text.charAt(0) != '1' && text.charAt(0) != '2' &&
//                text.charAt(0) != '3' && text.charAt(0) != '4' && text.charAt(0) != '5' &&
//                text.charAt(0) != '6' && text.charAt(0) != '7' && text.charAt(0) != '8' &&
//                text.charAt(0) != '9')

        switch (text.charAt(0)) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                break;
            default:
                Snackbar.make(v, R.string.error_message, Snackbar.LENGTH_SHORT).setAction(R.string.reset, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        screenTextView.setText("");
                    }
                });
                return;
        }

        for (int i = 0; i < length; i++) {
            curr = text.charAt(i);
            if (curr == '+'){

            }
        }

    }

}

