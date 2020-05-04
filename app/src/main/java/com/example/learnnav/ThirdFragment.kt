package com.example.learnnav

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import com.example.learnnav.databinding.SecondFragmentBinding
import com.example.learnnav.databinding.ThirdFragmentBinding
import kotlinx.android.synthetic.main.second_fragment.*

class ThirdFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: ThirdFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.third_fragment, container, false
        )


        return binding.root
    }

}
