package com.example.euroconvert;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup myRadioGroup;
    private TextView conversionLabel;
    private EditText editTextText;
    private Button lButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        myRadioGroup = findViewById(R.id.myRadioGroup);
        conversionLabel = findViewById(R.id.conversionLabel);
        editTextText = findViewById(R.id.editTextText);
        lButton = findViewById(R.id.lButton);

        myRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioButton) {
                conversionLabel.setText("Enter the amount in dinars:");
            } else if (checkedId == R.id.radioButton2) {
                conversionLabel.setText("Enter the amount in euros:");
            }
        });

        lButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertAmount();
            }
        });
    }

    private void convertAmount() {
        double amount = Double.parseDouble(editTextText.getText().toString());
        double convertedAmount;
        String currencySymbol;

        if (myRadioGroup.getCheckedRadioButtonId() == R.id.radioButton) {
            convertedAmount = amount * 123.45;
            currencySymbol = "DA";
        } else {
            convertedAmount = amount * 0.85;
            currencySymbol = "$";
        }

        TextView resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText("Converted amount: " + convertedAmount);
    }
}
