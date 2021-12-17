package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private var editTextUserName:EditText?=null
    private var editTextPassword:EditText?=null
    private var loginButton: Button?=null
    private var checkboxView:CheckBox?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        connectViews()
        login()
     //   checkFields()
    }
    private fun connectViews(){
        editTextUserName=findViewById(R.id.etUserName)
        editTextPassword=findViewById(R.id.etPassword)
        loginButton=findViewById(R.id.loginbutton)
        checkboxView=findViewById(R.id.termscheckbox)
    }
    private fun login(){
        val arr:ArrayList<User> = ArrayList()
        arr.add(User("s@gmail.com","1"))
        arr.add(User("f@gmail.com","22"))
        arr.add(User("d@gmail.com","333"))
        arr.add(User("t@gmail.com","4444"))
        loginButton?.setOnClickListener{
            val username= editTextUserName?.text.toString()
            val password=editTextPassword?.text.toString()

            val user= User(username,password)
            for(userArray in arr){
                if (userArray.email == user.email && userArray.password == user.password){
                 //   Toast.makeText(this , "Welcome ${user.email}",Toast.LENGTH_LONG).show() ;break
                     finish()
                    val i= Intent(this,MainActivity::class.java)
                    i.putExtra("email", userArray.email)
                    startActivity(i) ;break
                }else{
                    Toast.makeText(this , "Email or password invalid",Toast.LENGTH_LONG).show()
                }
            }
        }

    }

    private fun checkFields(){
        loginButton?.setOnClickListener {
            if (editTextUserName?.text?.isEmpty() == true
            ) {
                //Toast.makeText(this, "Enter Your data", Toast.LENGTH_LONG).show()
                editTextUserName?.setError("Enter your Email")
            }else if (editTextPassword?.text?.isEmpty() == true ){
                editTextPassword?.setError("Enter password")
            }
        }
    }
}