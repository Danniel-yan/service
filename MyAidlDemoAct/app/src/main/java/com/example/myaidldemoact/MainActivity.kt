package com.example.myaidldemoact

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mylibrary.IMyAidlInterface
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
	private var mService: IMyAidlInterface? = null

	var mConn: ServiceConnection = object : ServiceConnection {
		override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
			mService = IMyAidlInterface.Stub.asInterface(p1)
		}

		override fun onServiceDisconnected(p0: ComponentName?) {
			mService = null
		}

	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		initService()
//		tv_bind_service.tv_bind_service
		tv_bind_service.setOnClickListener {

			var m = mService?.addNumber(8, 7)
			Toast.makeText(this, "服务返回数据：" + m, Toast.LENGTH_LONG).show()
		}
	}

	private fun initService() {

		// Service Intent must be explicit
		// 从5.0之后 Service必须是显示声明，如果非要隐性调用，必须增加包名
		val intent = Intent()
		intent.action = "com.example.mylibrary.MyService"
		intent.setPackage(packageName)
		bindService(intent, mConn, BIND_AUTO_CREATE)
	}

	override fun onDestroy() {
		super.onDestroy()
		unbindService(mConn)
	}

}