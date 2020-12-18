package com.example.biskviti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class registrationActivity2 : AppCompatActivity() {

    private lateinit var  inputEmail:EditText
    private lateinit var  inputPassword:EditText
    private lateinit var  registrationButton:Button
    private lateinit var  mAuth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration2)

        inputEmail=findViewById(R.id.signUpPasswordEditText)
        inputPassword=findViewById(R.id.editTextTextPassword)
        registrationButton=findViewById(R.id.signUpButton)
        mAuth= FirebaseAuth.getInstance()

        val email=inputEmail.text.toString()
        val password=inputPassword.text.toString()

        if (email.isEmpty()||password.isEmpty()){
            Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()

            }else{
                    Toast.makeText(this, "Error!!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
}