package buu.informatics.s59160104.areacalculator.rectangle


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59160104.areacalculator.R
import buu.informatics.s59160104.areacalculator.circle.CircleViewModel
//import buu.informatics.s59160104.areacalculator.triangle.RectangleFragmentDirections
import buu.informatics.s59160104.areacalculator.databinding.FragmentRectangleBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_rectangle.*
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class RectangleFragment : Fragment() {
    lateinit var textA: String
    lateinit var textB: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentRectangleBinding>(
            inflater,
            R.layout.fragment_rectangle, container, false
        )

        val viewModel = ViewModelProviders.of(this).get(RectangleViewModel::class.java)



        binding.buttonCalculate.setOnClickListener { view: View ->
            textA = binding.editTextA.text.toString()
            textB = binding.editTextB.text.toString()
            viewModel.onCalculate(textA.toDouble(),textB.toDouble())

            view.findNavController().navigate(RectangleFragmentDirections.actionRectangleFragmentToResultFragment(viewModel.ans,"rectangle"))
        }
        binding.buttonHistory.setOnClickListener { view: View ->
            view.findNavController().navigate(RectangleFragmentDirections.actionRectangleFragmentToHistoryFragment())
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
