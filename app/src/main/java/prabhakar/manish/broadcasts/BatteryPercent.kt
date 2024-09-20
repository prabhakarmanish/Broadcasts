package prabhakar.manish.broadcasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BatteryPercent : AppCompatActivity() {

    private lateinit var batteryTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_battery_percent)

        batteryTextView = findViewById(R.id.btv)
        val batteryReceiver = object : BroadcastReceiver()
        {
            override fun onReceive(context: Context?, intent: Intent?) {
                val level = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL,-1) ?: -1
                val scale = intent?.getIntExtra(BatteryManager.EXTRA_SCALE,-1) ?: -1

                // Calculate battery percentage
                if (level != -1 && scale != -1) {
                    val batteryPercent = (level * 100) / scale
                    // Update the TextView with the battery percentage
                  //  batteryTextView.text = "Battery: $batteryPercent%"
                   // batteryTextView.text = batteryPercent.toString()
                    batteryTextView.text = level.toString()

                    // Show a toast for testing purposes
                  //  Toast.makeText(context, "Battery Level: $batteryPercent%", Toast.LENGTH_SHORT).show()
                }
            }
        }
        registerReceiver(batteryReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))

    }
}