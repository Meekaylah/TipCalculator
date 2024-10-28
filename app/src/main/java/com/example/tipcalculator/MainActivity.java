package com.example.tipcalculator;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    EditText editTextBillAmount;
    TextView textViewTipAmount;
    RadioButton radioButtonTipTen;
    RadioButton radioButtonTipFifteen;
    RadioButton radioButtonTipTwenty;
    RadioGroup rg;
    DecimalFormat df = new DecimalFormat("￡####.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextBillAmount = findViewById(R.id.editTextText);
        textViewTipAmount = findViewById(R.id.textView3);
        radioButtonTipTen = findViewById(R.id.radioButton);
        radioButtonTipFifteen = findViewById(R.id.radioButton2);
        radioButtonTipTwenty = findViewById(R.id.radioButton3);
        rg = findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(this);
    }

    public void onCheckedChanged(RadioGroup rg, int i) {
        if(editTextBillAmount.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Please enter the bill!", Toast.LENGTH_SHORT).show();
        } else {
            textViewTipAmount.setVisibility(TextView.VISIBLE);
            if(i == radioButtonTipTen.getId()) {
                textViewTipAmount.setText(df.format(Double.parseDouble
                        (editTextBillAmount.getText().toString()) * .10));
            } else if (i == radioButtonTipFifteen.getId()) {
                textViewTipAmount.setText(df.format(Double.parseDouble
                        (editTextBillAmount.getText().toString()) * .15));
            } else {
                textViewTipAmount.setText(df.format(Double.parseDouble
                        (editTextBillAmount.getText().toString()) * .20));
            }
        }
    }


}