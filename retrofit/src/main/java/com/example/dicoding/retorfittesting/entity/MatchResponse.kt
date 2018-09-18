package com.example.dicoding.retorfittesting.entity

import com.google.gson.annotations.SerializedName

data class MatchResponse(

	@field:SerializedName("events")
	val events: List<EventsItem>? = null
)