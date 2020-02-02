package com.ticonsys.kotlinretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ticonsys.kotlinretrofit.model.LoginResponse
import com.ticonsys.kotlinretrofit.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.activity.R.layout

class LoginActivity : AppCompatActivity() {
    lateinit var nameET: EditText
    lateinit var passwordET: EditText
    lateinit var  loginBtn: Button;
    var name=""
    var password=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
                nameET=findViewById(R.id.nameET);
        passwordET=findViewById(R.id.passwordET);
        loginBtn=findViewById(R.id.login)
        loginBtn.setOnClickListener({
            name=nameET.text.toString();
            password=passwordET.text.toString();
            userLogin(name,password)
        })


    }

    fun userLogin(name:String,password:String){

        Toast.makeText(this,name+password, Toast.LENGTH_SHORT).show();
        RetrofitClient.instance.userLogin(name, password)
            .enqueue(object: Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if(response.body()?.status==200){
                        println("response "+ response.body()!!.userData.email)

                        //   SharedPrefManager.getInstance(applicationContext).saveUser(response.body()?.user!!)

                        val intent = Intent(applicationContext, HomeActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                        startActivity(intent)


                    }else{
                        Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
                    }

                }
            })

    }
}
