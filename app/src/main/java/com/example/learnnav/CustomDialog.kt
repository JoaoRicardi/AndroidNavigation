package com.example.learnnav

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class CustomDialog : DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(context)
            .setTitle("Testando  12")
            .setMessage("OOOOO TESTE")
            .setPositiveButton("Ok") { dialog: DialogInterface?, which: Int -> println("ok clicked") }
            .show()
    }
}