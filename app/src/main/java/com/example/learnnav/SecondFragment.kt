package com.example.learnnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        val args = SecondFragmentArgs.fromBundle(arguments!!)
        userName = args.userName
        setHasOptionsMenu(true)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = SecondFragment()
    }
}
