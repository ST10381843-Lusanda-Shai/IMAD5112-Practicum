package vcmsa.ci.musicplaylistapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val appTitle : TextView = findViewById(R.id.appTitle)
        val addToPlaylist : Button = findViewById(R.id.addToPlaylist)
        val playlistScreen : Button = findViewById(R.id.playlistScreen)
        val exitBtn : Button = findViewById(R.id.exitBtn)
        val songTitle : EditText = findViewById(R.id.songTitle)
        val artistsName : EditText = findViewById(R.id.artistsName)
        val songRating : EditText = findViewById(R.id.songRating)
        val userComments : EditText =findViewById(R.id.userComments)

        addToPlaylist.setOnClickListener {

        }

        playlistScreen.setOnClickListener {
            val intent = Intent(this, PlaylistReviewScreen::class.java)
            startActivity(intent)
            finish()
        }

        exitBtn.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

    }
}