package com.example.learnnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.learnnav.databinding.SecondFragmentBinding

class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: SecondFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.second_fragment, container, false
        )

        setHasOptionsMenu(true)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = SecondFragment()
    }
}
