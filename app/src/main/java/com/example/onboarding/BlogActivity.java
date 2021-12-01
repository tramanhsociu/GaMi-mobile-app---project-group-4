package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.Adapter.BlogAdapter;
import com.example.model.Blog;

import java.util.ArrayList;

public class BlogActivity extends AppCompatActivity {
    TextView txtContent;
    ListView lvBlog;
    ArrayList<Blog> blog;
    BlogAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        linkViews();
        initData();
        initAdapter();
    }

    private void linkViews() {
        lvBlog=findViewById(R.id.lvBlog);
        txtContent=findViewById(R.id.txtContent);
    }

    private void initData() {
        blog=new ArrayList<>();
        blog.add(new Blog("Mũ là 1 item không thể thiếu cho các Boss mỗi khi đông về. Ngoài tác dụng giữ ấm thì 1 chiếc mũ thật cute sẽ giúp bé cưng của bạn trở nên đáng yêu hơn rất nhiều.",R.drawable.product1));
        blog.add(new Blog("Đệm trái chuối cho Corgi thêm đắm đuối",R.drawable.product2));
        blog.add(new Blog("MVòng cổ xinh xắn có chuông để cho các sen biết “boss” mình đang ở phương nào",R.drawable.product3));
        blog.add(new Blog("Chiếc balo thật “chiến” để mang “hoàng thượng” đi muôn nơi",R.drawable.product4));
    }

    private void initAdapter() {
        adapter=new BlogAdapter(BlogActivity.this,R.layout.item_blog,blog);
        lvBlog.setAdapter(adapter);
    }
}
