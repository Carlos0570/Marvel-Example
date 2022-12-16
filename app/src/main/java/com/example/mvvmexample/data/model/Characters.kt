package com.example.mvvmexample.data.model
import com.google.gson.annotations.SerializedName

data class Characters (

  @SerializedName("available"     ) var available     : Int?              = null,
  @SerializedName("collectionURI" ) var collectionURI : String?           = null,
  @SerializedName("items"         ) var items         : ArrayList<SuperHeroSource> = arrayListOf(),
  @SerializedName("returned"      ) var returned      : Int?              = null

)