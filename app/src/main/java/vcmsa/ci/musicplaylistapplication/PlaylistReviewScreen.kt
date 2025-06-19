package vcmsa.ci.musicplaylistapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PlaylistReviewScreen : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_playlist_review_screen)

        val playlistReview: TextView = findViewById(R.id.playlistReview)
        val displayBtn: Button = findViewById(R.id.displayBtn)
        val avgBtn: Button = findViewById(R.id.avgBtn)
        val backBtn: Button = findViewById(R.id.backBtn)

        backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}