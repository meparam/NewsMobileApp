package com.tvcnews.app.util.FontBinding;

import android.databinding.BindingAdapter;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Custom bindings for XML attributes using data binding.
 * (http://developer.android.com/tools/data-binding/guide.html)
 */
public class Bindings {

    @BindingAdapter({"bind:font"})
    public static void setFont(TextView textView, String fontName) {
        textView.setTypeface(FontCache.getInstance(textView.getContext()).get(fontName));
    }

    @BindingAdapter({"bind:font"})
    public static void setFont(EditText editTextView, String fontName) {
        editTextView.setTypeface(FontCache.getInstance(editTextView.getContext()).get(fontName));
    }
}
