package com.example.mycontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mycontact.Models.ContactModel;

public class ContactTakerActivity extends AppCompatActivity {

    EditText etname,etnumber;
    Button svbtn;
    ContactModel contactModel;
    String name,number;
    boolean isoldcontact = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_taker);

        etname = findViewById(R.id.etName);
        etnumber = findViewById(R.id.etNumber);
        svbtn = findViewById(R.id.savebtn);


        contactModel = new ContactModel();
        try {
            contactModel = (ContactModel) getIntent().getSerializableExtra("oldContact");
            etname.setText(contactModel.getContactName());
            etnumber.setText(contactModel.getContactNumber());
            isoldcontact = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



        svbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = etname.getText().toString();
                number = etnumber.getText().toString();

                if(!isoldcontact)
                {
                    contactModel = new ContactModel();

                }

                contactModel.setContactName(name);
                contactModel.setContactNumber(number);

                Intent intent = new Intent(ContactTakerActivity.this,MainActivity.class);
                intent.putExtra("newcontact",contactModel);
                setResult(RESULT_OK,intent);
                finish();

            }
        });
    }
}