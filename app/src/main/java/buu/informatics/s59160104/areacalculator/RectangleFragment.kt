package buu.informatics.s59160104.areacalculator


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160104.areacalculator.databinding.FragmentRectangleBinding
import buu.informatics.s59160104.areacalculator.databinding.FragmentSquareBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_rectangle.*
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class RectangleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentRectangleBinding>(
            inflater,
            R.layout.fragment_rectangle, container, false
        )

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_square, container, false)

        binding.buttonCalculate.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_rectangleFragment_to_resultFragment)
        }
        binding.buttonHistory.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_rectangleFragment_to_historyFragment)
        }
        binding.buttonReset.setOnClickListener {
            onReset()
        }

        Timber.i("Rectangle Called")

        return binding.root
    }

    private fun onReset() {
        editText_a.text = null
        editText_b.text = null

        var snack = view?.let { Snackbar.make(it, "Reset Success", Snackbar.LENGTH_LONG) }
        snack?.show()
    }

}
