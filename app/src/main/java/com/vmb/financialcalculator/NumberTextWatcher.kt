package com.vmb.financialcalculator

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import java.text.DecimalFormat
import java.text.ParseException

class NumberTextWatcher(editText: EditText) : TextWatcher {
    private val df: DecimalFormat
    private val dfnd: DecimalFormat
    private var hasFractionalPart: Boolean
    private val editText: EditText
    override fun afterTextChanged(s: Editable) {
        editText.removeTextChangedListener(this)
        try {
            val inilen: Int
            val endlen: Int
            inilen = editText.text.length
            val v = s.toString().replace(df.decimalFormatSymbols.groupingSeparator.toString(), "")
            val n = df.parse(v)
            val cp = editText.selectionStart
            if (hasFractionalPart) {
                editText.setText(df.format(n))
            } else {
                editText.setText(dfnd.format(n))
            }
            endlen = editText.text.length
            val sel = cp + (endlen - inilen)
            if (sel > 0 && sel <= editText.text.length) {
                editText.setSelection(sel)
            } else {
                editText.setSelection(editText.text.length - 1)
            }
        } catch (ignored: NumberFormatException) {
        } catch (ignored: ParseException) {
        }
        editText.addTextChangedListener(this)
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        hasFractionalPart = s.toString().contains(df.decimalFormatSymbols.decimalSeparator.toString())
    }

    companion object {
        private const val TAG = "NumberTextWatcher"
        fun GetStringInView(dataEditText: View): String {
            var data = (dataEditText as EditText).text.toString()
            if (data == "") {
                data = "0"
            }
            data = data.replace("\\s+".toRegex(), "")
            return data
        }
    }

    init {
        df = DecimalFormat("#,###.##")
        df.isDecimalSeparatorAlwaysShown = true
        dfnd = DecimalFormat("#,###")
        this.editText = editText
        hasFractionalPart = false
    }
}