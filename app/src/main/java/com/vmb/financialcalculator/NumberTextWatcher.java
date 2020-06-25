package com.vmb.financialcalculator;

import java.text.DecimalFormat;
import java.text.ParseException;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class NumberTextWatcher implements TextWatcher {

    private DecimalFormat df;
    private DecimalFormat dfnd;
    private boolean hasFractionalPart;

    private EditText editText;

    public NumberTextWatcher(EditText editText) {
        df = new DecimalFormat("#,###.##");
        df.setDecimalSeparatorAlwaysShown(true);
        dfnd = new DecimalFormat("#,###");
        this.editText = editText;
        hasFractionalPart = false;
    }

    @SuppressWarnings("unused")
    private static final String TAG = "NumberTextWatcher";

    @Override
    public void afterTextChanged(Editable s) {
        editText.removeTextChangedListener(this);

        try {
            int inilen, endlen;
            inilen = editText.getText().length();
            String v = s.toString().replace(String.valueOf(df.getDecimalFormatSymbols().getGroupingSeparator()), "");
            Number n = df.parse(v);
            int cp = editText.getSelectionStart();
            if (hasFractionalPart) {
                editText.setText(df.format(n));
            } else {
                editText.setText(dfnd.format(n));
            }
            endlen = editText.getText().length();
            int sel = (cp + (endlen - inilen));
            if (sel > 0 && sel <= editText.getText().length()) {
                editText.setSelection(sel);
            } else {
                editText.setSelection(editText.getText().length() - 1);
            }
        } catch (NumberFormatException | ParseException ignored) {
        }
        editText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        hasFractionalPart = s.toString().contains(String.valueOf(df.getDecimalFormatSymbols().getDecimalSeparator()));
    }

    public static String GetStringInView(View dataEditText){
        String data = ((EditText) dataEditText).getText().toString();
        if (data.equals("")){
            data = "0";
        }
        data = data.replaceAll("\\s+","");
        return data;
    }
}