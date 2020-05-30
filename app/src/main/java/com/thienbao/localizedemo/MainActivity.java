package com.thienbao.localizedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.thienbao.localizedemo.utils.LocaleHelper;

public class MainActivity extends AppCompatActivity {
    TextView mCountry;
    Switch mSwitch;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCountry = findViewById(R.id.txtCountry);
        mSwitch = findViewById(R.id.switchLan);

        String language = LocaleHelper.getLanguage(getBaseContext());
        if (language.equals("vi")) {
            mSwitch.setChecked(true);
        } else {
            mSwitch.setChecked(false);
        }

        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Context context;
                Resources resources;
                if (b) {
                    context = LocaleHelper.setLocale(MainActivity.this, "vi");
                    resources = context.getResources();
                    mCountry.setText(resources.getText(R.string.country));
                    mSwitch.setText(resources.getText(R.string.switch_language));
                } else {
                    context = LocaleHelper.setLocale(MainActivity.this, "en");
                    resources = context.getResources();
                    mCountry.setText(resources.getText(R.string.country));
                    mSwitch.setText(resources.getText(R.string.switch_language));
                }
            }
        });
    }
}
