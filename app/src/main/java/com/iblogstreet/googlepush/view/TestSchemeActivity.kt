package com.iblogstreet.googlepush.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.iblogstreet.googlepush.R
import com.iblogstreet.googlepush.util.RouteList

/**
 * @author junwang
 * @date 2021/1/12 3:19 PM
 */
@Route(path = RouteList.APP.TEST_SCHEME)
class TestSchemeActivity : AppCompatActivity() {
    private lateinit var tv_message: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_scheme)
        tv_message = findViewById(R.id.tv_message)

        tv_message.setText("${intent.getStringExtra("id")}")
    }

}