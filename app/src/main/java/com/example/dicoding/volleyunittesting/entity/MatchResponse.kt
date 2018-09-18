package com.example.dicoding.volleyunittesting.entity

import com.google.gson.annotations.SerializedName

data class MatchResponse(

	@field:SerializedName("events")
	val events: List<EventsItem>? = null
)