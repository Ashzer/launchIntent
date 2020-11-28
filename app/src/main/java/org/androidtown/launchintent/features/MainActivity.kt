package org.androidtown.launchintent.features

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.androidtown.launchintent.R

class MainActivity : AppCompatActivity() {

    private lateinit var mainListener : MainListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()

        val manager = getSystemService(Context.USB_SERVICE) as UsbManager
        val deviceList : HashMap<String, UsbDevice> = manager.deviceList
        var device = deviceList["deviceName"]
        if(device != null){
            aMain_device_tv.text = device.toString()
            aMain_status_iv.setImageDrawable(getDrawable(R.drawable.ic_activity_main_status_connected))
        }else{
            aMain_output_tv.text = null
            aMain_status_iv.setImageDrawable(getDrawable(R.drawable.ic_activity_main_status_disconnected))
        }

    }

    private fun initialize(){
        mainListener = MainListener(this)
        mainListener.initializeListeners()


    }

}