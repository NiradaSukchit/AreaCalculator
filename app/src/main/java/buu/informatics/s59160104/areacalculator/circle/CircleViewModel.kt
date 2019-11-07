package buu.informatics.s59160104.areacalculator.circle

import androidx.lifecycle.ViewModel

class CircleViewModel: ViewModel() {
    var result = 0.00
    var ans = ""
    var text = ""

    fun onCalculate(ansResult:Double) {
        result = 3.14 * (ansResult * ansResult)
        ans = String.format("%.2f", result)

    }

     fun onMerge(textR:String) {
        text =  ("3.14 x " + textR + " x " + textR + " ")

    }

}