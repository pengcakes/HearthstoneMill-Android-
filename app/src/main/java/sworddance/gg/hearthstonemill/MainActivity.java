package sworddance.gg.hearthstonemill;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    protected Button myButton;
    protected EditText edit_text1;
    protected EditText edit_text2;
    protected TextView text_ans;

    protected int first_dmg = 1;
    protected int num_of_d = 3;
    protected int ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = findViewById(R.id.button);
        edit_text1 = (EditText) findViewById(R.id.editText1);
        edit_text2 = (EditText) findViewById(R.id.editText2);
        text_ans = findViewById(R.id.answer);

        //toast
        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "toast", Toast.LENGTH_LONG).show();

                String fatigueCount = edit_text1.getText().toString();
                String fatigueDMG = edit_text2.getText().toString();
                Log.d("tag", "LOOK   " + fatigueDMG + "    "+ fatigueCount);
                first_dmg = Integer.parseInt(fatigueDMG);
                num_of_d = Integer.parseInt(fatigueCount);

                ans = findMill(first_dmg, num_of_d);
                String x = Integer.toString(ans);
                text_ans.setText(x);

            }
        });

        //clear textbox
        edit_text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_text1.setText("");

            }
        });

        edit_text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_text2.setText("");
            }
        });
    }


    protected static int findMill(int first_draw, int num_draw){
        int sum = 0;
        while(num_draw > 0){
            sum+= first_draw;
            first_draw++;
            num_draw--;
        }

        return sum;
    }




    
}
