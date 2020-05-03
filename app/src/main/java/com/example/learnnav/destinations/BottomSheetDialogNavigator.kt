package com.example.learnnav.destinations

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.example.learnnav.CustomBottomSheet


@Navigator.Name("custom_bottom_sheet")
class BottomSheetDialogNavigator(
    private val fragmentManager: FragmentManager
) : Navigator<BottomSheetDialogNavigator.Destination>()  {


    override fun navigate(destination: Destination, args: Bundle?, navOptions: NavOptions?, navigatorExtras: Extras?): NavDestination? {
        val dialog = CustomBottomSheet()
        dialog.show(fragmentManager,CustomBottomSheet.TAG)
        return null
    }

    override fun createDestination(): Destination {
        return Destination(this)
    }

    override fun popBackStack(): Boolean {
        return false
    }

    class Destination(bottomSheetDialogNavigator: BottomSheetDialogNavigator) : NavDestination(bottomSheetDialogNavigator)
}