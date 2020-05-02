package com.example.learnnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.learnnav.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )

        binding.btnActionId.setOnClickListener {
            if(editTextUserNameInputId.editableText.toString().isNotEmpty()){
                erroNavigationId.visibility = View.GONE
                Navigation.findNavController(it).navigate(HomeFragmentDirections.actionHomeFragmentToNavigateToFragment(editTextUserNameInputId.editableText.toString()))
            }else{
                erroNavigationId.visibility = View.VISIBLE
            }

        }
        setHasOptionsMenu(true)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
