package com.example.dtwal.expenses;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class AddExpenseActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    String name, category, date;
    EditText expenseName;
    EditText amount;
    Spinner spinner;
    Integer counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        expenseName = findViewById(R.id.expenseNameEdit);
        amount = findViewById(R.id.amountEdit);
        spinner = findViewById(R.id.spinner);


        //--- Set the default strings for dropdown menu ---

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.expenses_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        //--- end default strings ---


        //--- Configure buttons
        final Button addExpenseButton = findViewById(R.id.addExpenseButton);
        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (expenseName.getText().toString().isEmpty()) {
                    Toast.makeText(AddExpenseActivity.this, "Error: Missing name", Toast.LENGTH_SHORT).show();
                }

                if (amount.getText().toString().isEmpty()) {
                    Toast.makeText(AddExpenseActivity.this, "Error: Missing amount", Toast.LENGTH_SHORT).show();
                }

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");

                //Create new expense and send that expense to Firebase
                Expense expense = new Expense();
                expense.setName(expenseName.getText().toString());
                expense.setAmount(amount.getText().toString());
                expense.setCategory(spinner.getSelectedItem().toString());
                Date c = Calendar.getInstance().getTime();
                expense.setDate(c.toString());
                expense.setId(counter.toString());
                //mDatabase.child("expense").push();
                myRef.setValue(expense);


                if (!expenseName.getText().toString().isEmpty() && !amount.getText().toString().isEmpty()) {
                    finish();
                    counter++;
                }
            }
        });

        Button cancelButton = findViewById(R.id.cancelExpenseButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //--- end buttons

    }//end onCreate


}//end Activity
