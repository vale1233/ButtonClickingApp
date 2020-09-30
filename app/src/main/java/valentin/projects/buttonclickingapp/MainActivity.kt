package valentin.projects.buttonclickingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private const val TAG = "MainActivity"
private const val TEXT_CONTENTS = "TextContent"

class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.textView)
        textView?.text = ""
        textView?.movementMethod = ScrollingMovementMethod()
        userInput.setText("")

        button.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d(TAG, "onCreate: called")
                textView?.append(userInput.text)
                textView?.append("\n")
                userInput.text.clear()
            }
        })
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState: called")
        super.onRestoreInstanceState(savedInstanceState)
        val savedString = savedInstanceState?.getString(TEXT_CONTENTS, "")
        textView?.text = savedString
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState: called")
        super.onSaveInstanceState(outState)
        outState?.putString(TEXT_CONTENTS, textView?.text.toString())
    }

}