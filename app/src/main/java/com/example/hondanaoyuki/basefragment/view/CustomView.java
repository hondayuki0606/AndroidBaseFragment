package com.example.basefragment.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class CustomView extends FrameLayout {

    private final Context context;
    private final AttributeSet attrs;

    public CustomView(Context context, AttributeSet attrs) {
            super(context, attrs);
        this.context = context;
        this.attrs = attrs;
    }
}
