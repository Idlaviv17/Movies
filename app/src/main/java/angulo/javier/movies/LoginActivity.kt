package angulo.javier.movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    lateinit var btn_login: Button
    lateinit var btn_signup: Button
    lateinit var tv_recovery: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login = findViewById(R.id.btn_login)
        btn_signup = findViewById(R.id.btn_signup)
        tv_recovery = findViewById(R.id.tv_recovery)

        btn_login.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
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