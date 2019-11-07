package buu.informatics.s59160104.areacalculator.triangle

import androidx.lifecycle.ViewModel

class TriangleViewModel: ViewModel() {
    var result = 0.00
    var ans = ""

    fun onCalculate(textA: Double, textH: Double) {
        result = textA * textH * 0.5
        ans = String.format("%.2f", result)

    }
}

