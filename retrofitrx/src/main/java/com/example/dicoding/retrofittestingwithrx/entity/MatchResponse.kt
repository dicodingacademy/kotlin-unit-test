package com.example.dicoding.retrofittestingwithrx.entity

import com.example.dicoding.retrofittestingwithrx.entity.EventsItem
import com.google.gson.annotations.SerializedName

data class MatchResponse(

	@field:SerializedName("events")
	val events: List<EventsItem>? = null
)