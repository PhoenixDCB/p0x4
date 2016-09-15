package com.glacial.p0x4.general;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by dacuesta on 15/9/16.
 */
public class UtilsRecyclerView {

    /**
     * Get the number of items
     * @param rv - RecyclerView
     * @return
     */
    public static int getItemCount(RecyclerView rv) {
        return rv.getLayoutManager().getItemCount();
    }

    /**
     * Get the ViewHolder given the position
     * @param rv - RecyclerView
     * @param i - Position
     * @return
     */
    public static RecyclerView.ViewHolder getViewHolder(RecyclerView rv, int i) {
        View v = rv.getLayoutManager().findViewByPosition(i);
        return rv.getChildViewHolder(v);
    }

}
