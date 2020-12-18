package com.example.biskviti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ResetActivity : AppCompatActivity() {
    private lateinit var inputEmail: EditText
    private lateinit var sendbutton:Button
    private lateinit var mAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset)

        mAuth= FirebaseAuth.getInstance()
        inputEmail=findViewById(R.id.resetEmailEditText)
        sendbutton=findViewById(R.id.sendEmailButton)

        sendbutton.setOnClickListener{
            val email=inputEmail.text.toString()
            if(email.isEmpty()){
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()
            }else{
                mAuth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    }else
                        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}