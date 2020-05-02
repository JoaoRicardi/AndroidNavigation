package com.example.learnnav

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.learnnav.databinding.SecondFragmentBinding
import kotlinx.android.synthetic.main.second_fragment.*

class SecondFragment : Fragment() {

    var userName: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewName.text = userName ?: "FAILED"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: SecondFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.second_fragment, container, false
        )

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share -> shareSucess()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.second_fragment_menu,menu)
        if(getShareIntent().resolveActivity(activity!!.packageManager) == null ){
            menu.findItem(R.id.share).setVisible(false)
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater?.inflate(R.menu.winner_menu, menu)
//        // check if the activity resolves
//        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
//            // hide the menu item if it doesn't resolve
//            menu?.findItem(R.id.share)?.setVisible(false)
//        }
//    }

    private fun getShareIntent(): Intent {
        val args = SecondFragmentArgs.fromBundle(arguments!!)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, args.userName)

        return shareIntent
    }

    private fun shareSucess(){
        startActivity(getShareIntent())
    }

    companion object {
        @JvmStatic
        fun newInstance() = SecondFragment()
    }
}
