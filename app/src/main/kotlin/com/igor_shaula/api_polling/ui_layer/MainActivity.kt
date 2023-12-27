package com.igor_shaula.api_polling.ui_layer

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.igor_shaula.api_polling.R
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread.setDefaultUncaughtExceptionHandler { thread, exception ->
            Timber.e("caught exception: $exception\n\ton thread $thread")
        }
    }

    fun createAlertDialogForProvidingWithStubData(): AlertDialog =
        AlertDialog.Builder(this)
            .setTitle("there is good stub data...")
            .setMessage("switch to using stub data?")
            .setPositiveButton("Positive") { thisDialog, _ ->
                thisDialog.cancel()
            }
            .setNegativeButton("Negative") { thisDialog, _ ->
                thisDialog.cancel()
            }
            .setOnDismissListener {
                Timber.v("AlertDialog is dismissed")
            }
            .setOnCancelListener {
                Timber.v("AlertDialog is cancelled")
            }
            .create()
}
