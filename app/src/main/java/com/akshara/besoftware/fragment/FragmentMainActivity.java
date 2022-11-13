package com.akshara.besoftware.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.akshara.besoftware.R;
import com.akshara.besoftware.fragment.addfragmentusingcode.FragmentCodeActivity;
import com.akshara.besoftware.fragment.addfragmentusingxml.FragmentXMLActivity;

public class FragmentMainActivity extends AppCompatActivity {

    private Button btnXML, btnCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);
        setToolbar();
        initVars();
        setClickListener();
    }

    private void setClickListener() {
        btnXML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragmentMainActivity.this, FragmentXMLActivity.class);
                startActivity(intent);
            }
        });

        btnCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragmentMainActivity.this, FragmentCodeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initVars() {
        btnXML = findViewById(R.id.btnAddFragmentUsingXML);
        btnCode = findViewById(R.id.btnAddFragmentUsingCode);

    }

    private void setToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Fragment Example");
        }
    }
}