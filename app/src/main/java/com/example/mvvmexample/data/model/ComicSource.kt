package com.example.mvvmexample.data.model
import com.google.gson.annotations.SerializedName

data class ComicSource (

  @SerializedName("resourceURI" ) var resourceURI : String? = null,
  @SerializedName("name"        ) var name        : String? = null

)