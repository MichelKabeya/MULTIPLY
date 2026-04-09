package za.ac.iie.multiplicationtableapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
// added a background image for the activity_multable.xml
// imported from : https://www.pinterest.com/pin/11047961581740064/
class multable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_multable)
// get the table number from the bundle
        val bundle: Bundle?= intent.extras
        val tablestring = bundle?.getString("tablenumber")
// convert the table number to integer
        var tableNumber = tablestring!!.toInt()
// display the heading so we can see the value in action
        var multiplytable=findViewById<TextView>(R.id.textreceiver)
// start with the header and add two new lines
        var tabledisplay : String = "$tableNumber x table\n\n"
// initiating the while to calculate until 20
        var counter = 1
        while ( counter <= 20) { // check the control  variable
            val answer = tableNumber * counter
            tabledisplay += "$tableNumber x $counter = ${answer}\n"
            counter++       // update the control variable
        }
        // display the final outcome of the process
        multiplytable.text= tabledisplay


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}