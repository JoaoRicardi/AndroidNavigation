package com.example.learnnav

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CustomBottomSheet : BottomSheetDialogFragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v =  inflater.inflate(R.layout.bottom_sheet_fragment,container, false)

        return v
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog  = BottomSheetDialog(requireContext())

    companion object{
        val TAG = "bottom_sheet_custom"
    }


}