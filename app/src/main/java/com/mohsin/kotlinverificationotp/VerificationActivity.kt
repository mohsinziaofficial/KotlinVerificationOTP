package com.mohsin.kotlinverificationotp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.mohsin.kotlinverificationotp.databinding.ActivityVerificationBinding

class VerificationActivity : AppCompatActivity() {

    private var _binding : ActivityVerificationBinding? = null
    private val binding get() = _binding!!

    var auth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        if (auth!!.currentUser != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        supportActionBar?.hide()
        binding?.apply {
            editNumber.requestFocus()
            continueBtn.setOnClickListener {
                val intent = Intent(this@VerificationActivity, ActivityOTP::class.java)
                intent.putExtra("phoneNumber", editNumber.text.toString())
                startActivity(intent)
            }
        }
    }
}