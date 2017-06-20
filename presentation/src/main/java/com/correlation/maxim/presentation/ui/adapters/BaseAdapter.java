package com.correlation.maxim.presentation.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by Maxim Bircu on 6/19/17.
 */

public abstract class BaseAdapter<M,VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private final int layoutId;
    private final List<M> data = new ArrayList<>();
    private final PublishSubject<M> onClickSubject = PublishSubject.create();


    BaseAdapter(int layoutId) {
        this.layoutId = layoutId;
    }

    public abstract VH onCreateViewHolder(View view);
    public abstract void onBind(VH holder,M model);

    @Override
    public final VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return onCreateViewHolder(view);
    }

    @Override
    public final void onBindViewHolder(VH holder, int position) {
        final M item = getItem(position);
        onBind(holder, item);
        holder.itemView.setOnClickListener(view -> onClickSubject.onNext(item));
    }

    public Observable<M> getOnClickObservable(){
        return onClickSubject.asObservable();
    }

    public final  void add(M model){
        int itemCount = getItemCount();
        data.add(itemCount,model);
        notifyItemInserted(itemCount);
    }

    public final void addAll(List<M> models){
        int itemCount = getItemCount();
        data.addAll(itemCount,models);
        notifyItemRangeInserted(itemCount,models.size());
    }

    public final void remove(M model){
        int itemPosition = data.indexOf(model);
        data.remove(model);
        notifyItemRemoved(itemPosition);
    }

    public final void removeAll(){
        int itemCount = getItemCount();
        data.clear();
        notifyItemRangeRemoved(0,itemCount);
    }

    public final M getItem(int id){
        return data.get(id);
    }

    @Override
    public final int getItemCount() {
        return data.size();
    }
}

