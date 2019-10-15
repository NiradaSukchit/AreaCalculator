package buu.informatics.s59160104.areacalculator


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160104.areacalculator.databinding.FragmentRectangleBinding
import buu.informatics.s59160104.areacalculator.databinding.FragmentTriangleBinding
import kotlinx.android.synthetic.main.fragment_circle.*
import kotlinx.android.synthetic.main.fragment_rectangle.*
import kotlinx.android.synthetic.main.fragment_rectangle.text_a
import kotlinx.android.synthetic.main.fragment_triangle.*
import kotlinx.android.synthetic.main.fragment_rectangle.editText_a as editText_a1

/**
 * A simple [Fragment] subclass.
 */
class TriangleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTriangleBinding>(
            inflater,
            R.layout.fragment_triangle, container, false
        )

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_square, container, false)

        binding.buttonCalculate.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_triangleFragment_to_resultFragment)
        }
        binding.buttonHistory.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_triangleFragment_to_historyFragment)
        }

        binding.buttonReset.setOnClickListener {
            onReset()
        }

        return binding.root
    }

     private fun onReset() {
         editText_h.text = null
         editText_a.text = null
    }
}
