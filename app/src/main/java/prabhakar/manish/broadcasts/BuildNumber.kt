package prabhakar.manish.broadcasts

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BuildNumber : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_build_number)


        // Get the Android version (SDK version)
        val androidVersion = getAndroidVersion()

        // Display the Android version in a TextView
        val textView = findViewById<TextView>(R.id.androidVersionTextView)
        textView.text = "Android Version: $androidVersion"
    }

    private fun getAndroidVersion(): String {
        // Returns the version release (like 9.0, 10.0, 11, etc.)
        return Build.VERSION.RELEASE ?: "Unknown"
    }
}