package com.example.learnnav

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import com.example.learnnav.databinding.SecondFragmentBinding
import kotlinx.android.synthetic.main.second_fragment.*

class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: SecondFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.second_fragment, container, false
        )
        val args = SecondFragmentArgs.fromBundle(arguments!!)
        binding.textViewName.text  = args.name
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

    private fun getShareIntent(): Intent {
        val args = SecondFragmentArgs.fromBundle(arguments!!)
        return ShareCompat.IntentBuilder.from(activity!!)
            .setText(args.name).setType("text/plain")
            .intent
    }

    private fun shareSucess(){
        startActivity(getShareIntent())
    }

    companion object {
        @JvmStatic
        fun newInstance() = SecondFragment()
    }
}
