package com.example.learnnav

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.learnnav.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )

        binding.btnActionId.setOnClickListener {
                Navigation.findNavController(it).navigate(HomeFragmentDirections.actionHomeFragmentToNavigateToFragment("Joao"))
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share -> startActivity(shareIntent())
            R.id.menuHome -> this.findNavController().navigate(R.id.action_homeFragment_to_thirdFragment)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.home_menu,menu)

    }

    private fun shareIntent(): Intent {
        return ShareCompat.IntentBuilder.from(activity!!)
            .setText("Texto  para compartilhar ").setType("text/plain")
            .intent
    }



}
