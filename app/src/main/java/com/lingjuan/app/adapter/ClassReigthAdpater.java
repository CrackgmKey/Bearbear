package com.lingjuan.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.lingjuan.app.R;
import com.lingjuan.app.entity.SupclassLeft;

/**
 * Created by TaoHui on 2018/10/6.
 */

public class ClassReigthAdpater extends RecyclerView.Adapter<ClassReigthAdpater.ViewHodle> {
    private Context context;
    private int positionposition;
    private ScroPos scroPos;
    private List<SupclassLeft.GeneralClassifyBean> dataBeanList;

    public void setScroPos(ScroPos scroPos) {
        this.scroPos = scroPos;
    }

    public ClassReigthAdpater(Context context, List<SupclassLeft.GeneralClassifyBean> dataBeanList) {
        this.context = context;
        this.dataBeanList = dataBeanList;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setDataBeanList(List<SupclassLeft.GeneralClassifyBean> dataBeanList) {
        this.dataBeanList = dataBeanList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHodle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_class_ref, parent, false);
        return new ViewHodle(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodle holder, int position) {
        holder.namatitle.setText(String.valueOf(dataBeanList.get(positionposition).getData().get(position).getNext_name()));
        ClassCkAdpater classCkAdpater = new ClassCkAdpater(R.layout.item_classck,dataBeanList.get(positionposition).getData().get(position).getInfo());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,3){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        holder.recycleadd.setLayoutManager(gridLayoutManager);
        classCkAdpater.setContext(context);
        holder.recycleadd.setAdapter(classCkAdpater);
    }

    @Override
    public int getItemCount() {
        int size = 0;
        if(positionposition != 0){
            size = dataBeanList.get(positionposition).getData().size();
        }else if(dataBeanList.size() != 0){
            size = dataBeanList.get(0).getData().size();
        }
       // LogManage.d("我是适配器 我有：size()="+size);
        return size;
    }


    class ViewHodle extends RecyclerView.ViewHolder {
        @BindView(R.id.namatitle)
        TextView namatitle;
        @BindView(R.id.layout)
        LinearLayout layout;
        @BindView(R.id.recycleadd)
        RecyclerView recycleadd;
        public ViewHodle(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    public interface ScroPos{
        void succpos(int pos);
    }
}
