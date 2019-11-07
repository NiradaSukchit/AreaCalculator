package buu.informatics.s59160104.areacalculator.rectangle

import androidx.lifecycle.ViewModel
import java.math.BigDecimal
import java.math.RoundingMode

class RectangleViewModel: ViewModel(){
    var result = 0.00
    var ans = ""

    fun onCalculate(textA:Double, textB:Double) {
        result = textA * textB
        ans = String.format("%.2f", result)
    }

}
