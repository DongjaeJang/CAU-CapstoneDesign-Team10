package com.wdwy.ftp_connect.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wdwy.ftp_connect.R;

import java.util.ArrayList;

public class ListViewAdapterL extends BaseAdapter {
    private ImageView iconImageView;
    private TextView titleTextView;
    private TextView contentTextView;
    private String class_no2;

    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    public ListViewAdapterL() {

    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        titleTextView = (TextView) convertView.findViewById(R.id.title);
        iconImageView = (ImageView) convertView.findViewById(R.id.icon);
        contentTextView = (TextView) convertView.findViewById(R.id.content);

        ListViewItem listViewItem = listViewItemList.get(position);

        titleTextView.setText(listViewItem.getTitle());
        iconImageView.setImageResource(listViewItem.getIcon());
        contentTextView.setText(listViewItem.getContent());

        LinearLayout cmdArea = (LinearLayout)convertView.findViewById(R.id.cmdArea);
        cmdArea.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 여기에 intent 적용해서 강의 클래스 및 수강자 페이지로 넘기기
                Intent intent = new Intent(context, StudentClass.class);
                intent.putExtra("class_no2", listViewItem.getClass_no2());
                context.startActivity(intent);
//                Toast.makeText(v.getContext(), listViewItemList.get(pos).getContent(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addItem(String title, int icon, String content, String class_no2) {
        ListViewItem item = new ListViewItem();

        item.setTitle(title);
        item.setIcon(icon);
        item.setContent(content);
        item.setClass_no2(class_no2);

        listViewItemList.add(item);
    }
}
