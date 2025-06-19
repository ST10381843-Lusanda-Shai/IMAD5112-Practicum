package vcmsa.ci.musicplaylistapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//ST10381843 Lusanda Shai
class PlaylistReviewScreen : AppCompatActivity() {

    //Initializing my private variables
    private lateinit var song: ArrayList<String>
    private lateinit var artist: ArrayList<String>
    private lateinit var rating: ArrayList<String>
    private lateinit var comments: ArrayList<String>
    private lateinit var playlistReview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_playlist_review_screen)

        song = intent.getStringArrayListExtra("Songs Name")?: arrayListOf()
        artist = intent.getStringArrayListExtra("Artist's Name")?: arrayListOf()
        rating = intent.getStringArrayListExtra("Songs Rating")?: arrayListOf()
        comments = intent.getStringArrayListExtra("User Comments")?: arrayListOf()
        playlistReview = findViewById(R.id.playlistReview)

        //Initializing my values for nuttons
        val displayBtn: Button = findViewById(R.id.displayBtn)
        val avgBtn: Button = findViewById(R.id.avgBtn)
        val backBtn: Button = findViewById(R.id.backBtn)

        displayBtn.setOnClickListener {
            playlistDisplay()
        }

        //Allows the user to go back to the main scree
        backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    //This function was supposed to display the songs the user inputed and displayed on the playlistReview text view
    private fun playlistDisplay(){
        val stringBuilder = StringBuilder()
        if (song.isNotEmpty()){
            for (i in song.indices){
                stringBuilder.append("Song Name: ${song[i]}\n")
                stringBuilder.append("Artist Name: ${artist[i]}\n")
                stringBuilder.append("Song Rating: ${rating[i]}\n")
                stringBuilder.append("User Comments ${comments[i]}\n\n")
            }
        }else{
            playlistReview.text = "Playlist is empty."
        }
        playlistReview.text = stringBuilder.toString()
    }
}