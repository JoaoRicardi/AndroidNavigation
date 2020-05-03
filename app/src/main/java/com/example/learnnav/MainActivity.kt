package com.example.learnnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.learnnav.databinding.ActivityMainBinding
import com.example.learnnav.destinations.BottomSheetDialogNavigator
import com.example.learnnav.destinations.DialogNavigator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        val dialogNavigator = DialogNavigator(myNavHostFragment.childFragmentManager)
        val bottomSheetDialogNavigator =  BottomSheetDialogNavigator(myNavHostFragment.childFragmentManager)


        myNavHostFragment.findNavController().navigatorProvider.addNavigator(dialogNavigator)
        myNavHostFragment.findNavController().navigatorProvider.addNavigator(bottomSheetDialogNavigator)

        val inflater = myNavHostFragment.findNavController().navInflater
        val graph = inflater.inflate(R.navigation.navigation)
        myNavHostFragment.findNavController().graph = graph


    }
}
