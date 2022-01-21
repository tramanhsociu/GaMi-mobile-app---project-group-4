package com.example.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.model.Sale;
import com.example.onboarding.R;
import java.util.ArrayList;
public class SaleAdapter extends BaseAdapter {

    Context context;
    int item_layout;
    ArrayList<Sale> sales;

    public SaleAdapter(Context context, int item_layout, ArrayList<Sale> sales) {
        this.context = context;
        this.item_layout = item_layout;
        this.sales = sales;
    }

    @Override
    public int getCount() {
        return sales.size();
    }

    @Override
    public Object getItem(int i) {
        return sales.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){

            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout,null);
            holder.imvThumb = view.findViewById(R.id.imvSaleitem);
            holder.txtName = view.findViewById(R.id.txtName);
            holder.txtContent = view.findViewById(R.id.txtContent);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }

        Sale s= sales.get(i);
        holder.imvThumb.setImageResource(s.getSaleThumb());
        holder.txtName.setText(s.getSaleName());
        holder.txtContent.setText(s.getSaleContent());
        return view;
    }

    public static class ViewHolder {
        ImageView imvThumb, showInfo;
        TextView txtName,txtContent;
    }
}
