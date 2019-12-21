package com.example.a20191221_04_pizzalistapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.a20191221_04_pizzalistapp.datas.PizzaStore
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_pizza_store_profile.*
import java.util.jar.Manifest

class PizzaStoreProfileActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_store_profile)

        setEvents()
        setValues()
    }
    override fun setEvents() {
        val store = intent.getSerializableExtra("store") as PizzaStore
        storeCall.setOnClickListener {

            val listener = object : PermissionListener{
                override fun onPermissionGranted() {

                    val uri = Uri.parse("tel:${store.phoneNum}")
                    val intent = Intent(Intent.ACTION_CALL,uri)
                    startActivity(intent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {

                    Toast.makeText(mContext,"권한이 필요합니다.",Toast.LENGTH_SHORT).show()

                }

            }
            TedPermission.with(mContext)
                .setPermissionListener(listener)
                .setDeniedMessage("전화권한을 설정해야 합니다.")
                .setPermissions(android.Manifest.permission.CALL_PHONE)



        }

    }

    override fun setValues() {

        val store = intent.getSerializableExtra("store") as PizzaStore
        storeName.text = store.storeName
        storePhone.text = store.storeName

        Glide.with(mContext).load(store.logoUrl).into(storeImg)


    }
}
