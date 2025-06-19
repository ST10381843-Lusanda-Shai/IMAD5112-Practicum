package vcmsa.ci.musicplaylistapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import java.util.ArrayList
import kotlin.system.exitProcess

//ST10381843 Lusanda Shai
class MainActivity : AppCompatActivity() {

    //Initializing my private variables
    private val song = mutableListOf<String>()
    private val artist = mutableListOf<String>()
    private val rating = mutableListOf<String>()
    private val comments = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Initialized the values for my text view and buttons
        val appTitle : TextView = findViewById(R.id.appTitle)
        val addToPlaylist : Button = findViewById(R.id.addToPlaylist)
        val playlistScreen : Button = findViewById(R.id.playlistScreen)
        val exitBtn : Button = findViewById(R.id.exitBtn)
        val feedback : TextView = findViewById(R.id.feedback)

        //This function allows the user to enter the relevant info when it comes to their playlist
        addToPlaylist.setOnClickListener {
            addingPlaylistInfo()
        }

        //The button allows the user to go to the next screen but if they didnt add any info into their playlist they will be given a message
        playlistScreen.setOnClickListener {
            if (song.isNotEmpty()){
                val intent = Intent(this, PlaylistReviewScreen::class.java)
                intent.putStringArrayListExtra("song name", ArrayList(song))
                intent.putStringArrayListExtra("Artist name", ArrayList(artist))
                intent.putStringArrayListExtra("song rating", ArrayList(rating))
                intent.putStringArrayListExtra("user comment", ArrayList(comments))
                startActivity(intent)
            }
            else{
                feedback.text = "Your playlist is empty, please enter the relevant info first."
            }
        }

        //allows the user to exit the app
        exitBtn.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

    }

    //This function helps intergrate my main activity kotlin file and song_playlist xml file which will overlap once the user is ready to add their songs to the playlist
    private fun addingPlaylistInfo(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Add new info")
        
        val view = layoutInflater.inflate(R.layout.song_playlist_file, null)
        val songTitle: EditText = view.findViewById(R.id.songTitle)
        val artistsName: EditText = view.findViewById(R.id.artistsName)
        val songRating: EditText = view.findViewById(R.id.songRating)
        val userComments: EditText =view.findViewById(R.id.userComments)
        
        builder.setView(view)
        
        builder.setPositiveButton("Add") { dialog, _ ->
            val songTitle = songTitle.text.toString().trim()
            val artistsName = artistsName.text.toString().trim()
            val songRating = songRating.text.toString().trim()
            val userComments = userComments.text.toString().trim()
            if (songTitle.isEmpty() || artistsName.isEmpty() || songRating.isEmpty() || userComments.isEmpty()) {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Songs name, Artist's name, Songs Rating and Comments cannot be empty.",
                    Snackbar.LENGTH_SHORT
                ).show()
                return@setPositiveButton
            }

            song.add(songTitle)
            this.artist.add(artistsName)
            this.rating.add(songRating)
            this.comments.add(userComments)

            Snackbar.make(findViewById(android.R.id.content), "$songTitle$artistsName$songRating$userComments has been added.", Snackbar.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel"){ dialog, _->
            dialog.cancel()
        }

        builder.show()
    }
    
}