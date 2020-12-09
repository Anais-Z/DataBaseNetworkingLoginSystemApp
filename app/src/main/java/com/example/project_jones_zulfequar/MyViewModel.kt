package com.example.project_jones_zulfequar

import android.app.Application
import android.util.Log
import android.view.KeyEvent
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class MyViewModel(application: Application) : AndroidViewModel(application) {


   suspend fun loadData(urlString: String): String {

        var ins : InputStream? = null
        var result = ""
        try {
            var url = URL(urlString)
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            val response = conn.responseCode
            Log.d("response code", "${response}")
            ins = conn.inputStream

            result = ins.bufferedReader().use (BufferedReader :: readText)
            var json = getJason(result)
            Log.d("result", result)
        }catch (e : Exception){
            Log.d("TAG", e.toString())
        }
        return result
    }

    fun makeRequest(url: String){

        CoroutineScope(Dispatchers.IO).launch {
            var result = loadData(url)

            withContext(Dispatchers.Main){
                var json = getJason(result)
                var login = json.optString("login")

                Toast.makeText(getApplication(), login , Toast.LENGTH_LONG).show()
            }
        }

    }

    fun getJason(jsonStr:String) : JSONObject {
            var json = JSONObject(jsonStr)
        return json
    }

}