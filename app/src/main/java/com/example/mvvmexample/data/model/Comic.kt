package com.example.mvvmexample.data.model
import com.google.gson.annotations.SerializedName

data class Comic (

  @SerializedName("id"                 ) var id                 : Int?                = null,
  @SerializedName("digitalId"          ) var digitalId          : Int?                = null,
  @SerializedName("title"              ) var title              : String?             = null,
  @SerializedName("issueNumber"        ) var issueNumber        : Int?                = null,
  @SerializedName("variantDescription" ) var variantDescription : String?             = null,
  @SerializedName("description"        ) var description        : String?             = null,
  @SerializedName("modified"           ) var modified           : String?             = null,
  @SerializedName("isbn"               ) var isbn               : String?             = null,
  @SerializedName("upc"                ) var upc                : String?             = null,
  @SerializedName("diamondCode"        ) var diamondCode        : String?             = null,
  @SerializedName("ean"                ) var ean                : String?             = null,
  @SerializedName("issn"               ) var issn               : String?             = null,
  @SerializedName("format"             ) var format             : String?             = null,
  @SerializedName("pageCount"          ) var pageCount          : Int?                = null,
  @SerializedName("textObjects"        ) var textObjects        : ArrayList<TextObject> = arrayListOf(),
  @SerializedName("resourceURI"        ) var resourceURI        : String?             = null,
  @SerializedName("urls"               ) var urls               : ArrayList<Urls>     = arrayListOf(),
  @SerializedName("series"             ) var series             : Series?             = Series(),
  @SerializedName("variants"           ) var variants           : ArrayList<Variants> = arrayListOf(),
  //@SerializedName("collections"        ) var collections        : ArrayList<String>   = arrayListOf(),
  @SerializedName("collectedIssues"    ) var collectedIssues    : ArrayList<CollectedIssues>   = arrayListOf(),
  @SerializedName("dates"              ) var dates              : ArrayList<Dates>    = arrayListOf(),
  @SerializedName("prices"             ) var prices             : ArrayList<Prices>   = arrayListOf(),
  @SerializedName("thumbnail"          ) var thumbnail          : Thumbnail?          = Thumbnail(),
  @SerializedName("images"             ) var images             : ArrayList<Image>    = arrayListOf(),
  @SerializedName("creators"           ) var creators           : Creators?           = Creators(),
  @SerializedName("characters"         ) var characters         : Characters?         = Characters(),
  @SerializedName("stories"            ) var stories            : Stories?            = Stories(),
  @SerializedName("events"             ) var events             : Events?             = Events()
){
  fun getFormattedURLImage() = "${thumbnail?.path?.replace("http", "https")}/portrait_xlarge.${thumbnail?.extension}"

  fun getFormattedURLLandscapeImage() = "${thumbnail?.path?.replace("http", "https")}/landscape_large.${thumbnail?.extension}"

}