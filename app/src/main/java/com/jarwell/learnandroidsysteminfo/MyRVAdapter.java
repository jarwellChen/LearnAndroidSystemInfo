package com.jarwell.learnandroidsysteminfo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jarwell on 2016/9/27.
 */

public class MyRVAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private LayoutInflater inflater;
    private Context mContext;
    private List<PMAppInfo> mDatas;


    /**
     * 用于设置监听的接口
     * */
    public interface OnItemListener{
        void onClickListener(View view,int pos);
        void onLongClickListener(View view,int pos);
    }

    //定义一个接口
    private OnItemListener onItemListener;

    //供外部是用的接口类
    public void setOnItemListener(OnItemListener onItemListener){
        this.onItemListener=onItemListener;
    }

    public MyRVAdapter(Context context, List<PMAppInfo> datas){
        mContext=context;
        mDatas=datas;
        inflater=LayoutInflater.from(context);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_layout,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return  myViewHolder;

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.mImageView.setImageDrawable(mDatas.get(position).getAppIcon());
        holder.mLabelTextView.setText(mDatas.get(position).getAppLabel());
        holder.mPkgNameTextView.setText(mDatas.get(position).getPkgName());
        if (onItemListener!=null){
            holder.ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=holder.getLayoutPosition();
                    onItemListener.onClickListener(holder.ll,position);
                }
            });

            holder.ll.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position=holder.getLayoutPosition();
                    onItemListener.onLongClickListener(holder.ll,position);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
class MyViewHolder extends RecyclerView.ViewHolder{
    LinearLayout ll;
    ImageView mImageView;
    TextView mLabelTextView,mPkgNameTextView;
    public MyViewHolder(View itemView) {
        super(itemView);
        mImageView=(ImageView)itemView.findViewById(R.id.iv);
        mLabelTextView=(TextView)itemView.findViewById(R.id.id_label);
        mPkgNameTextView=(TextView)itemView.findViewById(R.id.id_pkgname);
        ll= (LinearLayout) itemView.findViewById(R.id.id_linearlayoutitem);
    }
}