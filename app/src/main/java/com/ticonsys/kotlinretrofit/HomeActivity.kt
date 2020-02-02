package com.ticonsys.kotlinretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ticonsys.kotlinretrofit.adapter.NoticeAdapter

import com.ticonsys.kotlinretrofit.model.NoticeModels
import com.ticonsys.kotlinretrofit.model.NoticeboardDataX

import com.ticonsys.kotlinretrofit.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    lateinit var recyclerview: RecyclerView

    var noticeList : MutableList<List<NoticeboardDataX>> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        recyclerview=findViewById(R.id.recyclerview)


        //  noticeList=ArrayList()
        // noticeAdaper=NoticeAdapters(noticeList,this)
        //  noticeAdaper= NoticeAdapters(noticeList,this)
//        noticeAdaper= NoticeAdapters(noticeList,this)
        //  noticeAdaper=
        recyclerview.adapter= NoticeAdapter( noticeList,applicationContext)
        recyclerview.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

       showData()
    }

    fun showData(){

        val call: Call<NoticeModels> = RetrofitClient.instance.getNoticeData("mizan");
        call.enqueue(object : Callback<NoticeModels> {
            override fun onFailure(call: Call<NoticeModels>, t: Throwable) {
                println("failed "+t.message)
            }

            override fun onResponse(
                call: Call<NoticeModels>,
                response: Response<NoticeModels>
            ) {
                for(item in response.body()!!.noticeboardData!!){
                    noticeList.addAll((listOf(response!!.body()!!.noticeboardData)))
                }

                //   val jsonResponse: NoticeModel? = response.body()
                //    var   data = List(Arrays.asList(jsonResponse.getAndroid()))
                //  adapter = DataAdapter(data)
                //   recyclerView.setAdapter(adapter)


                //    println("list "+noticeAdaper.noticeModelList)

                //  noticeList.addAll(listOf(response!!.body()!!.noticeboardData)!!)
                // .adapter.notifyDataSetChanged()
                //  println("response "+response.body()!!.noticeboardData.get(te).title)
                //  itemsList.toMutableList().add(item)

                //   noticeList.addAll(response!!.body()!!.noticeboardData[0]!!)
                recyclerview.adapter!!.notifyDataSetChanged()
                //  println("adapter size   "+noticeList.size)
            }
        })

    }
}
