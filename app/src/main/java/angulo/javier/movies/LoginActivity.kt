package angulo.javier.movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    lateinit var btn_login: Button
    lateinit var btn_signup: Button
    lateinit var tv_recovery: TextView
    lateinit var et_email: EditText
    lateinit var et_password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login = findViewById(R.id.btn_login)
        btn_signup = findViewById(R.id.btn_signup)
        tv_recovery = findViewById(R.id.tv_recovery)
        et_email = findViewById(R.id.et_email_login)
        et_password = findViewById(R.id.et_password_login)

        // Initialize Firebase Auth
        auth = Firebase.auth

        btn_login.setOnClickListener {
            var email: String = et_email.text.toString()
            var password: String = et_password.text.toString()

            if(!email.isNullOrEmpty() && !password.isNullOrEmpty()) {

                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            val user = auth.currentUser
                            var intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(
                                this,
                                "Incorrect credentials.",
                                Toast.LENGTH_SHORT,
                            ).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Ingresar datos", Toast.LENGTH_SHORT)
            }


        }

        btn_signup.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        tv_recovery.setOnClickListener {
            var intent = Intent(this, PasswordRecoveryActivity::class.java)
            startActivity(intent)
        }
    }
}