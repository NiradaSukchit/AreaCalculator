package buu.informatics.s59160104.areacalculator.circle

import androidx.lifecycle.ViewModel

class CircleViewModel: ViewModel() {
    var result = 0.00
    var ans = ""

    fun onCalculate(ansResult:Double) {
        result = 3.14 * (ansResult * ansResult)
        ans = String.format("%.2f", result)

    }

}