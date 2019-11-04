package buu.informatics.s59160104.areacalculator


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160104.areacalculator.databinding.FragmentResultBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class ResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentResultBinding>(
            inflater,
            R.layout.fragment_result, container, false
        )

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_square, container, false)

        binding.buttonHistory.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_resultFragment_to_historyFragment)
        }
        binding.buttonHome.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_resultFragment_to_homeFragment)
        }

        Timber.i("Result Called")

        return binding.root
    }


}
