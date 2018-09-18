package com.example.dicoding.volleyunittesting.repository

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.dicoding.volleyunittesting.entity.MatchResponse
import com.google.gson.Gson
import org.json.JSONException

class MatchRepository(private val context: Context) {

    companion object {
        private val TAG = MatchRepository::class.java.canonicalName
    }

    fun getNextMatch(id: String, callback: MatchRepositoryCallback<MatchResponse?>) {
        val queue = Volley.newRequestQueue(context)
        val stringRequest = JsonObjectRequest(
                Request.Method.GET,
                "https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=$id",
                null,
                Response.Listener { it ->
                    try {
                        val response = Gson().fromJson(it.toString(), MatchResponse::class.java)
                        callback.onDataLoaded(response)
                    } catch (e: JSONException) {
                        Log.e(TAG, "Error Parsing : ", e)
                        callback.onDataError()
                    }
                },
                Response.ErrorListener { it ->
                    Log.e(TAG, "Request Error : ", it)
                    callback.onDataError()
                })

        queue.add(stringRequest)
    }
}