package buu.informatics.s59160104.areacalculator.triangle

import androidx.lifecycle.ViewModel

class TriangleViewModel: ViewModel() {
    var result = 0.00
    var ans = ""
    var text = ""


    fun onCalculate(textA: Double, textH: Double) {
        result = textA * textH * 0.5
        ans = String.format("%.2f", result)

    }

    fun onMerge(textA:String,textH:String) {
        text =  ("0.5 x " + textA + " x " + textH)

    }
}

