package com.example.onboarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.Adapter.BlogAdapter;
import com.example.model.Blog;

import java.util.ArrayList;


public class BlogFragment extends Fragment{

    TextView txtContent;
    ListView lvBlog;
    ArrayList<Blog> blog;
    BlogAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_blog, container, false);

        lvBlog=view.findViewById(R.id.lvBlog);
        txtContent=view.findViewById(R.id.txtContent);
        initData();
        initAdapter();
        return view;
    }

    private void initData() {
        blog=new ArrayList<>();
        blog.add(new Blog("Mũ là 1 item không thể thiếu cho các Boss mỗi khi đông về. Ngoài tác dụng giữ ấm thì 1 chiếc mũ thật cute sẽ giúp bé cưng của bạn trở nên đáng yêu hơn rất nhiều.",R.drawable.product1));
        blog.add(new Blog("Đệm trái chuối cho Corgi thêm đắm đuối",R.drawable.product2));
        blog.add(new Blog("MVòng cổ xinh xắn có chuông để cho các sen biết “boss” mình đang ở phương nào",R.drawable.product3));
        blog.add(new Blog("Chiếc balo thật “chiến” để mang “hoàng thượng” đi muôn nơi",R.drawable.product4));
    }

    private void initAdapter() {
        adapter=new BlogAdapter(getContext(),R.layout.item_blog,blog);
        lvBlog.setAdapter(adapter);
    }
}