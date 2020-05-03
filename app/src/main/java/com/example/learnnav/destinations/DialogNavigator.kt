package com.example.learnnav.destinations

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.example.learnnav.CustomDialog

@Navigator.Name("custom_dialog")
class DialogNavigator(private val manager: FragmentManager) : Navigator<DialogNavigator.Destination>() {

    override fun navigate(destination: Destination, args: Bundle?, navOptions: NavOptions?, navigatorExtras: Extras?): NavDestination? {
        val dialog = CustomDialog()
        dialog.show(manager, "dialog-fragment")
        return null
    }


    override fun createDestination(): Destination {
        return Destination(this)
    }


    override fun popBackStack(): Boolean {
        return false
    }


    class Destination(dialogNavigator: DialogNavigator) : NavDestination(dialogNavigator)

}