package prabhakar.manish.broadcasts

import android.os.Bundle
import android.os.SystemClock
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UpTime : AppCompatActivity() {

    private lateinit var uptimeTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_up_time)


        uptimeTextView = findViewById(R.id.uptimeTextView)

        // Get and display uptime
        val uptime = getUptime()
        uptimeTextView.text = "Uptime: $uptime"
    }

    private fun getUptime(): String {
        val uptimeMillis = SystemClock.uptimeMillis()

        // Convert uptime from milliseconds to a readable format
        val seconds = (uptimeMillis / 1000) % 60
        val minutes = (uptimeMillis / (1000 * 60)) % 60
        val hours = (uptimeMillis / (1000 * 60 * 60)) % 24
        val days = uptimeMillis / (1000 * 60 * 60 * 24)

       // return "$days days, $hours hours, $minutes minutes, $seconds seconds"
        return uptimeMillis.toString()
    }
}