package com.qoobico.remindme.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.qoobico.remindme.dto.TicketDTO;
import com.qoobico.remindme.fragment.AbstractTabFragment;
import com.qoobico.remindme.fragment.HistoryFragment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractTabFragment> tabs;
    private Context context;

    private List<TicketDTO> data;

    private HistoryFragment historyFragment;

    public TabsFragmentAdapter(Context context, FragmentManager fm, List<TicketDTO> data) {
        super(fm);
        this.data = data;
        this.context = context;
        initTabsMap(context);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabsMap(Context context) {
        tabs = new HashMap<>();
        historyFragment = HistoryFragment.getInstance(context, data);
        tabs.put(0, historyFragment);

    }

    public void setData(List<TicketDTO> data) {
        this.data = data;
        historyFragment.refreshList(data);
    }
}
