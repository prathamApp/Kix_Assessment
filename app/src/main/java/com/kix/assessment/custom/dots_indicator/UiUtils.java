package com.kix.assessment.custom.dots_indicator;


import android.content.Context;
import android.util.TypedValue;

import com.kix.assessment.R;


public class UiUtils {
    public static int getThemePrimaryColor(final Context context) {
        final TypedValue value = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorPrimary, value, true);
        return value.data;
    }
}
