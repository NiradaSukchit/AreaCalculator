package buu.informatics.s59160104.areacalculator


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
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

        setHasOptionsMenu(true)


        return binding.root
    }

    // Creating our Share Intent
    private fun getShareIntent() : Intent {

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.result))
        return shareIntent
    }
    // Starting an Activity with our new Intent
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }


    // Showing the Share Menu Item Dynamically
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.share_menu, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu?.findItem(R.id.share)?.setVisible(false)
        }
    }

    // Sharing from the Menu
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }


}
