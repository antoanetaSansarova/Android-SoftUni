package androidcourse.softuni.bg.homework1.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import androidcourse.softuni.bg.homework1.R;

public class SecondActivity extends AppCompatActivity {

    private TextView tvResult;
    private String id;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvResult = (TextView)findViewById(R.id.tv_result);

        if (getIntent() != null){
            id = getIntent().getStringExtra(FirstActivity.COMPONENT_ID);
            name = getIntent().getStringExtra(FirstActivity.COMPONENT_NAME);
        }

        StringBuilder builder = new StringBuilder("Component name: ");
        builder.append(name)
                .append(", id: ")
                .append(id);

        tvResult.setText(builder);
    }
}
