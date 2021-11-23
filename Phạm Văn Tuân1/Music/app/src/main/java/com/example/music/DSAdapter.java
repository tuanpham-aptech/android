package com.example.music;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DSAdapter  extends BaseAdapter {
    private List<Baihat> baihatList;
    private Context context;
    public DSAdapter(Context context,List<Baihat> baihats){
        this.baihatList=baihats;
        this.context=context;


    }
    @Override
    public int getCount() {
        return baihatList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public  class  ViewHodler{
        TextView txttenbaihat;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler viewHodler;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.dong_ds,null);
            viewHodler=new ViewHodler();
            viewHodler.txttenbaihat=convertView.findViewById(R.id.txttenbaihat);
            convertView.setTag(viewHodler);

        }else{
            viewHodler= (ViewHodler) convertView.getTag();
        }
        viewHodler.txttenbaihat.setText(baihatList.get(position).getTenbaihat());
        return convertView;
    }
}
