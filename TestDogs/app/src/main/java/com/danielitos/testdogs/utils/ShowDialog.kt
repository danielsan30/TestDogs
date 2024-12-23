package com.danielitos.testdogs.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog

/**
 * Created by danielsanchez on 23/12/24
 */
class ShowDialog {

     fun showErrorDialog(context: Context, message: String) {
        AlertDialog.Builder(context)
            .setTitle("Error")
            .setMessage(message)
            .setPositiveButton("OK", null) .show() }
}