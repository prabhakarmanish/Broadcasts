package prabhakar.manish.broadcasts

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ModelName : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_model_name)

        // Get the device model name
        val modelName = getDeviceModel()

        // Display the device model name in a TextView
        val textView = findViewById<TextView>(R.id.deviceModelTextView)
        textView.text = "Device Model: $modelName"
    }

    private fun getDeviceModel(): String {
        // Returns the model name of the device (e.g., "Pixel 4", "Samsung Galaxy S21", etc.)
        return Build.MODEL ?: "Unknown Model"
    }
}
