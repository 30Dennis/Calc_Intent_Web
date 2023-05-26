package com.example.intent_calc_web

import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import android.Manifest
import android.content.Intent
import android.provider.MediaStore
import androidx.core.app.ActivityCompat



class IntentActivity : AppCompatActivity() {
    lateinit var ButtonSms: Button
    lateinit var ButtonCall: Button
    lateinit var ButtonCamera: Button
    lateinit var ButtonShare: Button
    lateinit var ButtonMpesa: Button
    lateinit var ButtonDial: Button
    lateinit var ButtonEmail: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        ButtonSms=findViewById(R.id.btn_sms)
        ButtonSms.setOnClickListener {
            val uri=Uri.parse("smsto: 0728923282")
            val intent= Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("Good afternoon", "How are you doing")
            startActivity(intent)
        }

        ButtonCall=findViewById(R.id.btn_call)
        ButtonCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"))

            if (ContextCompat.checkSelfPermission(
                    this@IntentActivity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@IntentActivity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }

        ButtonCamera=findViewById(R.id.btn_camera)
        ButtonCamera.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivityForResult(takePictureIntent, 1)
        }
        ButtonShare=findViewById(R.id.btn_share)
        ButtonShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            shareIntent.type = "text/plain"

            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

            startActivity(shareIntent)


        }

        ButtonMpesa=findViewById(R.id.btn_mpesa)
        ButtonMpesa.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")

            simToolKitLaunchIntent?.let { startActivity(it) }

        }

        ButtonDial=findViewById(R.id.btn_dial)
        ButtonDial.setOnClickListener {
            val phone = "+34666777888"

            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

            startActivity(intent)


        }

        ButtonEmail=findViewById(R.id.btn_email)
        ButtonEmail.setOnClickListener {

            val emailIntent =
            Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))

            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

            startActivity(Intent.createChooser(emailIntent, "Send email..."))

        }

    }
}