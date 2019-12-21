package com.example.a20191221_04_pizzalistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a20191221_04_pizzalistapp.adapters.PizzaStoreAdapter
import com.example.a20191221_04_pizzalistapp.datas.PizzaStore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.pizza_store_list_item.*

class MainActivity : BaseActivity() {


    var pizzaStoreAdapter:PizzaStoreAdapter? = null
    var pizzaStoreList = ArrayList<PizzaStore>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setEvents()
        setValues()
    }

    override fun setEvents() {



    }

    override fun setValues() {
        addPizzaStores()

        pizzaStoreAdapter = PizzaStoreAdapter(mContext, R.layout.pizza_store_list_item, pizzaStoreList)
        pizzaStoreListView.adapter = pizzaStoreAdapter

    }

    fun addPizzaStores(){

        pizzaStoreList.add(PizzaStore("피자헛","010-1234-5678","https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg"))
        pizzaStoreList.add(PizzaStore("파파존스","101-1239-8513","http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800"))
        pizzaStoreList.add(PizzaStore("미스터피자","101-1239-8513","https://post-phinf.pstatic.net/MjAxODEyMDVfMzYg/MDAxNTQzOTYxOTA4NjM3.8gsStnhxz7eEc9zpt5nmSRZmI-Pzpl4NJvHYU-Dlgmcg.7Vpgk0lopJ5GoTav3CUDqmXi2-_67S5AXD0AGbbR6J4g.JPEG/IMG_1641.jpg?type=w1200"))
        pizzaStoreList.add(PizzaStore("도미노피자","101-1239-8513","https://pbs.twimg.com/profile_images/1098371010548555776/trCrCTDN_400x400.png"))

    }
}
