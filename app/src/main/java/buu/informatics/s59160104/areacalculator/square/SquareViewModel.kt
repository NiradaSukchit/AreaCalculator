package buu.informatics.s59160104.areacalculator.square

import androidx.lifecycle.ViewModel

class SquareViewModel:ViewModel(){
    var result = 0.00
    var ans = ""
    var text = ""


    fun onCalculate(ansResult:Double) {
        result = ansResult * ansResult
        ans = String.format("%.2f", result)

    }
    fun onMerge(textR:String) {
        text =  (textR + " x " + textR)

    }

}