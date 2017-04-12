package com.example.a_hashimoto.threadmaster;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by a-hashimoto on 2017/04/04.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemViewHolder> {

    private final ArrayList<String> TITLE_ARRAY_LIST;
    private final ArrayList<String> CATCHPHRASE_ARRAY_LIST;
    private final ArrayList<Bitmap> THUMBNAIL_ARRAY_LIST;

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView TITLE_TEXT_VIEW;
        private final TextView CATCHPHRASE_TEXT_VIEW;
        private final ImageView IMAGE_VIEW;

        public ItemViewHolder(View v) {
            super(v);
            TITLE_TEXT_VIEW = (TextView) v.findViewById(R.id.title_text_view);
            CATCHPHRASE_TEXT_VIEW = (TextView) v.findViewById(R.id.description_text_view);
            IMAGE_VIEW = (ImageView) v.findViewById(R.id.image_view);
        }
    }

    public MyAdapter(
            ArrayList<String> TitleArrayList,
            ArrayList<String> CatchphraseArrayList,
            ArrayList<Bitmap> ThumnailArrayList) {
        this.TITLE_ARRAY_LIST = TitleArrayList;
        this.CATCHPHRASE_ARRAY_LIST = CatchphraseArrayList;
        this.THUMBNAIL_ARRAY_LIST = ThumnailArrayList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_low, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.TITLE_TEXT_VIEW.setText(TITLE_ARRAY_LIST.get(position));
        holder.TITLE_TEXT_VIEW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        holder.CATCHPHRASE_TEXT_VIEW.setText(CATCHPHRASE_ARRAY_LIST.get(position));
        holder.CATCHPHRASE_TEXT_VIEW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
//
        holder.IMAGE_VIEW.setImageBitmap(THUMBNAIL_ARRAY_LIST.get(position));
        holder.IMAGE_VIEW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return TITLE_ARRAY_LIST.size();
    }

}
