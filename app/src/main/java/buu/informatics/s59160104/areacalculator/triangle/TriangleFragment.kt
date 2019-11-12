package buu.informatics.s59160104.areacalculator.triangle


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59160104.areacalculator.R
import buu.informatics.s59160104.areacalculator.databinding.FragmentTriangleBinding
import buu.informatics.s59160104.areacalculator.rectangle.RectangleViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_triangle.*
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class TriangleFragment : Fragment() {

    lateinit var textA: String
    lateinit var textH: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTriangleBinding>(
            inflater,
            R.layout.fragment_triangle, container, false
        )

        val viewModel = ViewModelProviders.of(this).get(TriangleViewModel::class.java)


        binding.buttonCalculate.setOnClickListener { view: View ->

            textA = binding.editTextA.text.toString()
            textH = binding.editTextH.text.toString()

            if (textA.length > 0 && textH.length > 0) {

                viewModel.onCalculate(textA.toDouble(), textH.toDouble())
                viewModel.onMerge(textA, textH)

                view.findNavController().navigate(
                    TriangleFragmentDirections.actionTriangleFragmentToResultFragment(
                        viewModel.ans,
                        "triangle",
                        viewModel.text
                    )
                )
            } else {
                var snack = view?.let {
                    Snackbar.make(
                        it,
                        "Please enter the number of \"a\" or \"h\"",
                        Snackbar.LENGTH_LONG
                    )
                }
                snack?.show()
            }
        }

        binding.buttonReset.setOnClickListener {
            onReset()
        }

        Timber.i("Triangle Called")

        return binding.root
    }

    private fun onReset() {
        editText_h.text = null
        editText_a.text = null

        var snack = view?.let { Snackbar.make(it, "Reset Success", Snackbar.LENGTH_LONG) }
        snack?.show()
    }
}
