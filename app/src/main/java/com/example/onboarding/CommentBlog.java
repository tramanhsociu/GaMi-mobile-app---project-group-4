package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.Adapter.CommentAdapter;
import com.example.database.BlogDatabase;

public class CommentBlog extends AppCompatActivity {
    EditText edtCmt;
    ImageView imvSendCmt;
    ListView lvCmt;
    BlogDatabase db;
    CommentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_blog);

        linkView();
        addEvent();
    }

    private void linkView() {
        edtCmt=findViewById(R.id.edtCmt);
        imvSendCmt=findViewById(R.id.imvSendCmt);
        lvCmt=findViewById(R.id.lvCmt);
    }

    private void addEvent() {
        imvSendCmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content;
                Integer image;

                content=edtCmt.getText().toString();
                image=R.drawable.ic_avatar;
                boolean flag=db.insertData(content,image);

            }
        });
    }
}