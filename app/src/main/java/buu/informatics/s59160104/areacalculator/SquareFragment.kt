package buu.informatics.s59160104.areacalculator


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160104.areacalculator.databinding.FragmentSquareBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_square.*

/**
 * A simple [Fragment] subclass.
 */
class SquareFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentSquareBinding>(inflater,
            R.layout.fragment_square,container,false)

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_square, container, false)

        binding.buttonHistory.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.squareFragment_to_historyFragment)
        }
        binding.buttonCalculate.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_squareFragment_to_resultFragment)
        }
        binding.buttonReset.setOnClickListener {
            onReset()
        }

        return binding.root

    }

    private fun onReset() {
        editText_a.text = null

        var snack = view?.let { Snackbar.make(it, "Reset Success", Snackbar.LENGTH_LONG) }
        snack?.show()
    }


}
