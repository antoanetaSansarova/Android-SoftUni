package androidcourse.softuni.bg.homework1.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidcourse.softuni.bg.homework1.R;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String LEFT_COUNT = "LEFT_COUNT";
    public static final String RIGHT_COUNT = "RIGHT_COUNT";
    public static final int DOUBLE_CLICK_COUNT = 2;
    public static final String COMPONENT_ID = "COMPONENT_ID";
    public static final String COMPONENT_NAME = "COMPONENT_NAME";
    public static final String TEXT_VIEW = "TEXT_VIEW";
    private static final String TAG = FirstActivity.class.getSimpleName();
    private int btnLeftCount = 0;
    private int btnRightCount = 0;
    private Button btnRight;
    private Button btnLeft;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private TextView tvBtnId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        btnLeft = (Button) findViewById(R.id.btn_left);
        btnRight = (Button) findViewById(R.id.btn_right);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        tvBtnId = (TextView)findViewById(R.id.tv_btnIds);

        if (savedInstanceState != null) {
            Log.d(TAG, "onCreate: state is saved");
            btnLeftCount = savedInstanceState.getInt(LEFT_COUNT);
            btnRightCount = savedInstanceState.getInt(RIGHT_COUNT);

            tvBtnId.setText(savedInstanceState.getString(TEXT_VIEW));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (btnRight != null) {
            btnRight.setText(String.valueOf(btnRightCount));
            btnRight.setOnClickListener(this);
        }

        if(btnLeft != null){
            btnLeft.setText(String.valueOf(btnLeftCount));
        }

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        tvBtnId.setOnClickListener(this);
    }

    //    implicit declaration
    public void onLeftButtonClicked(View view) {
        int btnId = view.getId();
        Log.d(TAG, "onLeftButtonClicked: left button is clicked");
        switch (btnId) {
            case R.id.btn_left: {
                btnLeft.setText(String.valueOf(++btnLeftCount));
                Log.d(TAG, "onLeftButtonClicked: btn left counter ->" + btnLeftCount);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(LEFT_COUNT, btnLeftCount);
        outState.putInt(RIGHT_COUNT, btnRightCount);
        outState.putString(TEXT_VIEW,tvBtnId.getText().toString());
        Log.d(TAG, "onSaveInstanceState: left->"+btnLeftCount+ " right->"+btnRightCount);
    }

//    explicit declaration
    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId){
            case R.id.btn_right:{

                Log.d(TAG, "onClick: right button is clicked");
                btnRight.setText(String.valueOf(++btnRightCount));
                Log.d(TAG, "onClick: btn right counter ->" + btnRightCount);
                break;
            }
            case R.id.btn1:{
                Log.d(TAG, "onClick: set btn1 id");
                changeText(btn1);

                break;
            }
            case R.id.btn2:{
                Log.d(TAG, "onClick: set btn2 id");
                changeText(btn2);

                break;
            }
            case R.id.btn3:{
                Log.d(TAG, "onClick: set btn3 id");
                changeText(btn3);
                break;
            }
            case R.id.tv_btnIds:{

                String componentId = "0";
                String componentName= "0";

                if(tvBtnId.getText().equals(String.valueOf(btn1.getId())) || tvBtnId.getText().equals(btn1.getText())){
                    componentId = String.valueOf(btn1.getId());
                    componentName = btn1.getText().toString();
                }else if(tvBtnId.getText().equals(String.valueOf(btn2.getId())) || tvBtnId.getText().equals(btn2.getText())){
                    componentId = String.valueOf(btn2.getId());
                    componentName = btn2.getText().toString();
                }else if(tvBtnId.getText().equals(String.valueOf(btn3.getId())) || tvBtnId.getText().equals(btn3.getText())){
                    componentId = String.valueOf(btn3.getId());
                    componentName = btn3.getText().toString();
                }

                Intent startSecondActivityIntent = new Intent(FirstActivity.this,SecondActivity.class);
                startSecondActivityIntent.putExtra(COMPONENT_ID,componentId);
                startSecondActivityIntent.putExtra(COMPONENT_NAME, componentName);
                startActivity(startSecondActivityIntent);
                break;
            }
        }
    }

    private void changeText(Button btn) {
        String strBtnId = String.valueOf(btn.getId());
        if (tvBtnId.getText().equals(strBtnId)){
            tvBtnId.setText(btn.getText());
        } else {
            tvBtnId.setText(strBtnId);
        }
    }
}
