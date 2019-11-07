package buu.informatics.s59160104.areacalculator.circle


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59160104.areacalculator.R
//import buu.informatics.s59160104.areacalculator.triangle.CircleFragmentDirections
import buu.informatics.s59160104.areacalculator.databinding.FragmentCircleBinding
import buu.informatics.s59160104.areacalculator.square.SquareViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_circle.*
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class CircleFragment : Fragment() {
    lateinit var ansResult: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCircleBinding>(
            inflater,
            R.layout.fragment_circle, container, false
        )

        val viewModel = ViewModelProviders.of(this).get(CircleViewModel::class.java)

        binding.buttonCalculate.setOnClickListener { view: View ->
            ansResult = binding.editTextR.text.toString()
            viewModel.onCalculate(ansResult.toDouble())
            viewModel.onMerge(ansResult)

            view.findNavController().navigate(CircleFragmentDirections.actionCircleFragmentToResultFragment(viewModel.ans,"circle",viewModel.text))
        }
        binding.buttonHistory.setOnClickListener { view: View ->
            view.findNavController().navigate(CircleFragmentDirections.actionCircleFragmentToHistoryFragment())
        }
        binding.buttonReset.setOnClickListener {
            onReset()
        }

        Timber.i("Circle Called")

        return binding.root
    }

    private fun onReset() {

        editText_r.text = null

        var snack = view?.let { Snackbar.make(it, "Reset Success", Snackbar.LENGTH_LONG) }
        snack?.show()

    }



}
