package com.qoobico.remindme.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qoobico.remindme.R;
import com.qoobico.remindme.adapter.TicketListAdapter;
import com.qoobico.remindme.dto.TicketDTO;

import java.util.List;

public class HistoryFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_history;

    private List<TicketDTO> data;

    private TicketListAdapter adapter;

    public static HistoryFragment getInstance(Context context, List<TicketDTO> data) {
        Bundle args = new Bundle();
        HistoryFragment fragment = new HistoryFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setData(data);
        fragment.setTitle(context.getString(R.string.tab_item_history));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycleView);
        rv.setLayoutManager(new LinearLayoutManager(context));

        adapter = new TicketListAdapter(data);
        rv.setAdapter(adapter);

        return view;
    }

    public void refreshList(List<TicketDTO> data) {
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setData(List<TicketDTO> data) {
        this.data = data;
    }
}
