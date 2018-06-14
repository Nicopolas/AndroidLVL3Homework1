package com.zakharov.nicolay.androidlvl3homework1.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zakharov.nicolay.androidlvl3homework1.R;

public class mvpMainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    private Button btnCounter1;
    private Button btnCounter2;
    private Button btnCounter3;
    private Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCounter1 = (Button) findViewById(R.id.btnCounter1);
        btnCounter2 = (Button) findViewById(R.id.btnCounter2);
        btnCounter3 = (Button) findViewById(R.id.btnCounter3);
        Model.get().putButtonIdInModel(btnCounter1);
        Model.get().putButtonIdInModel(btnCounter2);
        Model.get().putButtonIdInModel(btnCounter3);
        btnCounter1.setOnClickListener(this);
        btnCounter2.setOnClickListener(this);
        btnCounter3.setOnClickListener(this);
        mPresenter = new Presenter(this);
    }

    @Override
    public void onClick(View view) {
        mPresenter.buttonClick(view.getId());
    }

    @Override
    public void setButtonText(int btnIndex, int value) {
        String buttonText = String.format(getString(R.string.part_button_text), String.valueOf(value));
        ((Button) findViewById(btnIndex)).setText(buttonText);
    }
}
