package com.example.santosh.healthmonitoringbygraph;

import android.content.res.Resources;
import android.util.TypedValue;
/**
 * Created by mohseenmukaddam on 8/31/16.
 */
public class Converter {
    protected int dipToPx(int dip){
        Resources r = Resources.getSystem();
        return((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, r.getDisplayMetrics()));
    }
}
