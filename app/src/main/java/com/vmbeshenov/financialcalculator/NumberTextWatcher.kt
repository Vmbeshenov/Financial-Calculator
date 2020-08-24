package com.vmbeshenov.financialcalculator

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import java.text.DecimalFormat
import java.text.ParseException

class NumberTextWatcher(editText: EditText) : TextWatcher {

    private val decimalFormatWithDot: DecimalFormat = DecimalFormat("#,###.##")
    private val decimalFormat: DecimalFormat = DecimalFormat("#,###")
    private var hasFractionalPart: Boolean
    private val editText: EditText

    override fun afterTextChanged(numberText: Editable) {
        editText.removeTextChangedListener(this)
        try {
            val initialLength: Int = editText.text.length
            val numberString = numberText.toString().replace(decimalFormatWithDot.decimalFormatSymbols.groupingSeparator.toString(), "")
            val finalNumber = decimalFormatWithDot.parse(numberString)
            val cp = editText.selectionStart
            if (hasFractionalPart) {
                editText.setText(decimalFormatWithDot.format(finalNumber))
            } else {
                editText.setText(decimalFormat.format(finalNumber))
            }
            val finalLength: Int = editText.text.length
            val sel = cp + (finalLength - initialLength)
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
        hasFractionalPart = s.toString().contains(decimalFormatWithDot.decimalFormatSymbols.decimalSeparator.toString())
    }

    companion object {
        private const val TAG = "NumberTextWatcher"
        fun getStringInView(dataEditText: View): String {
            var data = (dataEditText as EditText).text.toString()
            if (data == "") {
                data = "0"
            }
            data = data.replace("\\s+".toRegex(), "")
            return data
        }
    }

    init {
        decimalFormatWithDot.isDecimalSeparatorAlwaysShown = true
        this.editText = editText
        hasFractionalPart = false
    }
}