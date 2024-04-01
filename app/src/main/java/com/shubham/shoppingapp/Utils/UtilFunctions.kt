package com.shubham.shoppingapp.Utils

import android.view.View
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.snackbar.Snackbar

class utilFunctions{
    companion object{
        @JvmStatic
        fun showSnackbar(view: View, message: String) {
            Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
        }

        @JvmStatic
        fun showProgress(pb: LinearProgressIndicator)
        {
            pb.visibility = View.VISIBLE
        }
        @JvmStatic
        fun hideProgres(pb: LinearProgressIndicator)
        {
            pb.visibility = View.GONE
        }
    }

}
