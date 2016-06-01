package com.lsj.smartpiano.module.search.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.module.search.bean.LogQuickSearch;

public class LogQuickSearchRow extends LinearLayout {
    Context mContext;
    LogQuickSearch mLog;

    public LogQuickSearchRow(Context context) {
        super(context);
        mContext = context;
        setup();
    }

    public LogQuickSearchRow(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        setup();
    }

    private void setup() {
        LayoutInflater inflater1 = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater1.inflate(R.layout.list_quick_search_row, this);
    }

    public void setLog(LogQuickSearch log) {
        mLog = log;
        TextView text = (TextView) findViewById(R.id.textView);
        text.setText(mLog.getName());

    }
}