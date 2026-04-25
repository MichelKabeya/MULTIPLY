package za.ac.iie.multiplicationtableapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // added a background image for the activity_main.xml
    // imported from  https://www.pinterest.com/pin/304133781109571351/
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // added a button to display a short ( how to use message ) as a toast message
        // imported the background image from "@android:drawable/ic_dialog_info"
        val buttInfo=findViewById<Button>(R.id.buttInfo)
        buttInfo.setOnClickListener {
            Toast.makeText(this@MainActivity,
                "Enter the number in the the specified field below and " +
                        "click on the CALCULATE button to see the result",
                Toast.LENGTH_LONG ).show()
        }
        // added a variable to hold the multiplication button
        val buttoMul = findViewById<Button>(R.id.calcbtt)
        /* watched a video on YouTube of how to make the button corners rounded and
        modify the color from the code instead of the attributes
        from : https://youtu.be/zdy6X6t3BpQ
         */
        // added the variable to hold the user's input
        val numInput = findViewById<EditText>(R.id.editNumber)
        buttoMul.setOnClickListener {
            // create a variable to hold the explicit intent
            val intent = Intent(this, multable::class.java)
            intent.putExtra("tablenumber", numInput.text.toString())
            startActivity(intent)

        }

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets

        }
    }
}