package buu.informatics.s59160104.areacalculator.square


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59160104.areacalculator.R
//import buu.informatics.s59160104.areacalculator.triangle.SquareFragmentDirections
import buu.informatics.s59160104.areacalculator.databinding.FragmentSquareBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_square.*
import timber.log.Timber
import kotlin.properties.Delegates

/**
 * A simple [Fragment] subclass.
 */
class SquareFragment : Fragment() {
    lateinit var ansResult: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentSquareBinding>(
            inflater,
            R.layout.fragment_square, container, false
        )
        val viewModel = ViewModelProviders.of(this).get(SquareViewModel::class.java)

        binding.buttonCalculate.setOnClickListener { view: View ->

            ansResult = binding.editTextA.text.toString()

            if (ansResult.length > 0) {
                viewModel.onCalculate(ansResult.toDouble())
                viewModel.onMerge(ansResult)

                view.findNavController()
                    .navigate(
                        SquareFragmentDirections.actionSquareFragmentToResultFragment(
                            viewModel.ans,
                            "square",
                            viewModel.text
                        )
                    )
            } else {
                var snack = view?.let { Snackbar.make(it, "Please enter the number of \"a\"", Snackbar.LENGTH_LONG) }
                snack?.show()

            }
        }
        binding.buttonReset.setOnClickListener {
            onReset()
        }

        Timber.i("Square Called")

        return binding.root
    }

    private fun onReset() {
        editText_a.text = null

        var snack = view?.let { Snackbar.make(it, "Reset Success", Snackbar.LENGTH_LONG) }
        snack?.show()
    }

}
