package buu.informatics.s59160104.areacalculator


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160104.areacalculator.databinding.FragmentHistoryBinding
import buu.informatics.s59160104.areacalculator.databinding.FragmentResultBinding
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.fragment_result.*
import kotlinx.android.synthetic.main.fragment_result.text_result
import kotlinx.android.synthetic.main.fragment_history.text_equal as text_equal1
import kotlinx.android.synthetic.main.fragment_history.text_for_result as text_for_result1

/**
 * A simple [Fragment] subclass.
 */
class HistoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentHistoryBinding>(
            inflater,
            R.layout.fragment_history, container, false
        )

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_square, container, false)

        binding.buttonHome.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_historyFragment_to_homeFragment)
        }
        binding.buttonClear.setOnClickListener {
            onClear()
        }

        return binding.root
    }
    fun onClear() {
        text_for_result.text = null
        text_equal.text = null
        text_result.text = null
    }
}
