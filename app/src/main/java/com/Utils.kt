package com

import android.content.Context
import android.widget.Toast

class Utils {

    fun showToast(context: Context){
        Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show()
    }
}