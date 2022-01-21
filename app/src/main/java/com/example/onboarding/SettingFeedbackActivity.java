package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.database.AccountDB;
import com.example.database.FeedbackAppDB;

public class SettingFeedbackActivity extends AppCompatActivity {
    RatingBar rtBar;
    FrameLayout btnFeedback;
    TextView txtresultRate;
    ImageView imvdoggo, imvBack, imvConfetti;
    String answerValue;
    Animation charanim, aniconfetti, btt;
    FeedbackAppDB DB = new FeedbackAppDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_feedback);
        linkViews();
        addEvents();

    }

    private void linkViews() {
        rtBar = findViewById(R.id.rtBar);
        btnFeedback = findViewById(R.id.btnFeedback);
        txtresultRate = findViewById(R.id.txtresultRate);
        imvdoggo = findViewById(R.id.imvdoggo);
        imvConfetti = findViewById(R.id.imvConfetti);
        imvBack = findViewById(R.id.imvBack);

    }

    private void addEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingFeedbackActivity.this, SettingActivity.class));
            }
        });
        btnFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent in = getIntent();
//                Bundle bundle = in.getExtras();
//                String email = bundle.getString("email");
//                String feedback = txtresultRate.getText().toString();
//                boolean insertData = DB.insertData(email, feedback);
//                if(insertData == true){
                    startActivity(new Intent(SettingFeedbackActivity.this, SettingActivity.class));
                    Toast.makeText(SettingFeedbackActivity.this, "Đánh giá của bạn đã lưu", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(SettingFeedbackActivity.this, "Đánh giá không được lưu thành công", Toast.LENGTH_SHORT).show();
//                }

            }
        });

        //load animation
        charanim = AnimationUtils.loadAnimation(this, R.anim.charanim);
        aniconfetti = AnimationUtils.loadAnimation(this, R.anim.aniconfetti);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);

        //give animate
        imvdoggo.startAnimation(charanim);
        imvConfetti.startAnimation(aniconfetti);
        btnFeedback.startAnimation(btt);

        //give condition
        rtBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                answerValue = String.valueOf((int) (rtBar.getRating()));
                if (answerValue.equals("1")) {
                    imvdoggo.setImageResource(R.drawable.ic_terrible);

                    imvdoggo.startAnimation(charanim);
                    imvConfetti.animate().alpha(0).setDuration(300).start();
                    btnFeedback.startAnimation(btt);

                    txtresultRate.setText("Rất tệ lun á");
                } else if (answerValue.equals("2")) {
                    imvdoggo.setImageResource(R.drawable.ic_bad);

                    imvdoggo.startAnimation(charanim);
                    imvConfetti.animate().alpha(0).setDuration(300).start();
                    btnFeedback.startAnimation(btt);

                    txtresultRate.setText("Hơi tồi");
                } else if (answerValue.equals("3")) {
                    imvdoggo.setImageResource(R.drawable.ic_okay);

                    imvdoggo.startAnimation(charanim);
                    imvConfetti.animate().alpha(0).setDuration(300).start();
                    btnFeedback.startAnimation(btt);

                    txtresultRate.setText("Cũng ổn");
                } else if (answerValue.equals("4")) {
                    imvdoggo.setImageResource(R.drawable.ic_good);

                    imvdoggo.startAnimation(charanim);
                    imvConfetti.animate().alpha(1).setDuration(300).start();
                    imvConfetti.startAnimation(aniconfetti);
                    btnFeedback.startAnimation(btt);

                    txtresultRate.setText("Tốt!!");
                } else if (answerValue.equals("5")) {
                    imvdoggo.setImageResource(R.drawable.ic_great);

                    imvdoggo.startAnimation(charanim);
                    imvConfetti.animate().alpha(1).setDuration(300).start();
                    imvConfetti.startAnimation(aniconfetti);
                    btnFeedback.startAnimation(btt);

                    txtresultRate.setText("Tuyệt vời GaMi ơi");
                } else {
                    Toast.makeText(SettingFeedbackActivity.this, "No Point", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}