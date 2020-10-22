package app.beautifulsentences;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnShowResult;
    TextView tvResult;
    ArrayList<String> listQuoations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        btnShowResult = findViewById(R.id.btnShowResult);
        tvResult      = findViewById(R.id.tvResult);
        listQuoations = new ArrayList<String>();
        listQuoations.add("I have learned more from my failures than from my success");
        listQuoations.add("Learn to be happy with what you have while you pursue all that you dream");
        listQuoations.add("Success is the ability to go from one failure to another with no loss of enthusiasm");
    }
    public void showQuotation(View v){
        if(v.getId() == R.id.btnShowResult){

            btnShowResult.setClickable(false);
            btnShowResult.setVisibility(View.INVISIBLE);


            CountDownTimer countDownTimer = new CountDownTimer(10000,2000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    Random randomGenerator = new Random();

                    tvResult.setTextSize(randomGenerator.nextInt(20)+20);

                    tvResult.setTextColor(Color.rgb(randomGenerator.nextInt(265),randomGenerator.nextInt(265),randomGenerator.nextInt(265)));
                    int number = randomGenerator.nextInt(3);
                    switch (number){
                        case 0: tvResult.setGravity(Gravity.CENTER); break;
                        case 1: tvResult.setGravity(Gravity.LEFT); break;
                        case 2: tvResult.setGravity(Gravity.RIGHT); break;

                    }
                    tvResult.setText(listQuoations.get(randomGenerator.nextInt(listQuoations.size())).toString());

                }

                @Override
                public void onFinish() {
                    showToast("onFinish");
                    btnShowResult.setClickable(true);
                    btnShowResult.setVisibility(View.VISIBLE);
                }
            };

            countDownTimer.start();
        }

    }
    private void showToast(String msg){
        Toast.makeText(this,msg, Toast.LENGTH_LONG).show();
    }
}