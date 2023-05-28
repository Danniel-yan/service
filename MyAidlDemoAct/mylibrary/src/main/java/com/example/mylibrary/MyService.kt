package com.example.mylibrary

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService: Service() {
	override fun onBind(intent: Intent?): IBinder? {
		return mBinder
	}

	private var mBinder = object : IMyAidlInterface.Stub() {
		override fun basicTypes(
			anInt: Int,
			aLong: Long,
			aBoolean: Boolean,
			aFloat: Float,
			aDouble: Double,
			aString: String?
		) {
			TODO("Not yet implemented")
		}

		override fun addNumber(a: Int, b: Int): Int {
			Log.d("客户端发起请求a+b =",   (a + b).toString())
			return a + b;
		}

	}
}