package com.example.mylibrary

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
	private var mService: IMyAidlInterface? = null

//	var mConn: ServiceConnection = object : ServiceConnection {
//		override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
//			mService = IMyAidlInterface.Stub.asInterface(p1)
//			mService?.addNumber(8, 7)
//		}
//
//		override fun onServiceDisconnected(p0: ComponentName?) {
//			mService = null
//		}
//
//	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		initService()
//		tv_bind_service.tv_bind_service
//		findViewById<TextView>(R.id.tv_bind_service).setOnClickListener {
//			Toast.makeText(this, "dianji", Toast.LENGTH_LONG).show()
//			var m = mService
//			mService?.addNumber(8, 7)
//
//		}
	}

	private fun initService() {
		val intent = Intent(this, MyService::class.java)
//		bindService(intent, mConn, Context.BIND_AUTO_CREATE)

	}

	override fun onDestroy() {
		super.onDestroy()
//		unbindService(mConn)
	}

}