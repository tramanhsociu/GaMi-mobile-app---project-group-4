package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.Adapter.CommentAdapter;
import com.example.model.Comment;

import java.util.ArrayList;

public class CommentBlog extends AppCompatActivity {
    EditText edtCmt;
    ImageView imvSendCmt;


    ListView lvCmt;
    CommentAdapter adapter;
    ArrayList<Comment> comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_blog);

        linkView();

        addEvent();
        initAdapter();
        initData();

    }

    private void linkView() {
        edtCmt=findViewById(R.id.edtCmt);
        imvSendCmt=findViewById(R.id.imvSendCmt);
        lvCmt=findViewById(R.id.lvCmt);
    }

    private void initData() {
        comment=new ArrayList<>();
        comment.add(new Comment("Rất xinh đẹp tuyệt vời","Trâm Anh"));
        comment.add(new Comment("Dùng thích lắm ạ","Thanh Vân"));
//        comment.add(new Comment("Sản phẩm rất tốt"));
//        comment.add(new Comment("Vượt ngoài mong đợi"));
        adapter=new CommentAdapter(CommentBlog.this,R.layout.item_cmt,comment);
        lvCmt.setAdapter(adapter);
    }

    private void addEvent() {
        imvSendCmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                comment=new ArrayList<>();
                comment.add(new Comment(edtCmt.getText().toString(),"Như Tuyết"));
                adapter=new CommentAdapter(CommentBlog.this,R.layout.item_cmt,comment);
                lvCmt.setAdapter(adapter);
            }
        });
    }

    private void initAdapter() {

    }



}