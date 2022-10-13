package pt.ipt.dam.rollerdice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {

    //define the pointer to the imageView
    private lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //find button
        var rollDiceBT: Button = findViewById<Button>(R.id.btRollDice)
        rollDiceBT.setOnClickListener{
            //add a message to screen when you press the button
            Toast.makeText(this, "the button was pressed", Toast.LENGTH_SHORT).show()
            rollDice()
        }
        //'start' diceImage
        diceImage = findViewById<ImageView>(R.id.DiceImageView)
    }

    private fun rollDice() {
        //get the dice value
        var randomDiceValue = Random().nextInt(6) + 1
        //find the text view
        var resultText = findViewById<TextView>(R.id.resultTextView)
        //change the content of TextView
        resultText.text = randomDiceValue.toString()

        //define the face of dice to show on screen
        var drawableResource = when(randomDiceValue){
            1 -> {R.drawable.dice_1}
            2 -> {R.drawable.dice_2}
            3 -> {R.drawable.dice_3}
            4 -> {R.drawable.dice_4}
            5 -> {R.drawable.dice_5}
            6 -> {R.drawable.dice_6}
            else -> {R.drawable.empty_dice}
        }
        //assign the image to ImageView
        diceImage.setImageResource(drawableResource)
    }
}