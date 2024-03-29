package buu.informatics.s59160104.areacalculator


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59160104.areacalculator.databinding.FragmentHomeBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,
            R.layout.fragment_home,container,false)


        binding.buttonSquare.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_squareFragment)
        }
        binding.buttonRectangle.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_rectangleFragment)
        }
        binding.buttonTriangle.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_triangleFragment)
        }
        binding.buttonCircle.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_circleFragment)
        }

        Timber.i("Home Called")

        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController())
                ||super.onOptionsItemSelected(item)
    }


}
