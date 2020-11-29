package com.example.project_jones_zulfequar

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class MyViewModel(application: Application) : AndroidViewModel(application) {

    fun loadData(urlString: String): String {

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


    }

    fun getJason(jsonStr:String) : JSONObject {
            var json = JSONObject(jsonStr)
        return json
    }

}