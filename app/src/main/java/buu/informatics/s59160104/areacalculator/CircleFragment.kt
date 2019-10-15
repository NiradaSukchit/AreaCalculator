package buu.informatics.s59160104.areacalculator


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160104.areacalculator.databinding.FragmentCircleBinding
import kotlinx.android.synthetic.main.fragment_circle.*

/**
 * A simple [Fragment] subclass.
 */
class CircleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCircleBinding>(
            inflater,
            R.layout.fragment_circle, container, false
        )

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_square, container, false)

        binding.buttonCalculate.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_circleFragment_to_resultFragment)
        }
        binding.buttonHistory.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_circleFragment_to_historyFragment)
        }
        binding.buttonReset.setOnClickListener {
            onReset()
        }

        return binding.root
    }

    private fun onReset() {

        editText_r.text = null
    }


}
