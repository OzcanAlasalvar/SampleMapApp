package com.ozcanalasalvar.core.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BaseModel(
    @SerializedName("results")
    @Expose
    var results: List<Result>? = null,

    @SerializedName("status")
    @Expose
    var status: String? = null
)

data class Result(
    @SerializedName("geometry")
    @Expose
    var geometry: Geometry? = null,
    @SerializedName("icon")
    @Expose
    var icon: String? = null,
    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("opening_hours")
    @Expose
    var openingHours: OpeningHours? = null,
    @SerializedName("photos")
    @Expose
    var photos: List<Photo>? = null,
    @SerializedName("place_id")
    @Expose
    var placeId: String? = null,
    @SerializedName("reference")
    @Expose
    var reference: String? = null,
    @SerializedName("types")
    @Expose
    var types: List<String>? = null,
    @SerializedName("vicinity")
    @Expose
    var vicinity: String? = null
)


data class Geometry(
    @SerializedName("location")
    @Expose
    var location: Location? = null,
    @SerializedName("viewport")
    @Expose
    var viewport: Viewport? = null
)


data class Location(
    @SerializedName("lat")
    @Expose
    var lat: Float? = null,
    @SerializedName("lng")
    @Expose
    var lng: Float? = null
)


data class Northeast(
    @SerializedName("lat")
    @Expose
    var lat: Float? = null,
    @SerializedName("lng")
    @Expose
    var lng: Float? = null
)


data class OpeningHours(
    @SerializedName("open_now")
    @Expose
    var openNow: Boolean? = null
)


class Photo(
    @SerializedName("height")
    @Expose
    var height: Int? = null,
    @SerializedName("html_attributions")
    @Expose
    var htmlAttributions: List<String>? = null,
    @SerializedName("photo_reference")
    @Expose
    var photoReference: String? = null,
    @SerializedName("width")
    @Expose
    var width: Int? = null
)

data class PlusCode(
    @SerializedName("compound_code")
    @Expose
    var compoundCode: String? = null,
    @SerializedName("global_code")
    @Expose
    var globalCode: String? = null
)

class Southwest(
    @SerializedName("lat")
    @Expose
    var lat: Float? = null,
    @SerializedName("lng")
    @Expose
    var lng: Float? = null
)

class Viewport(
    @SerializedName("northeast")
    @Expose
    var northeast: Northeast? = null,
    @SerializedName("southwest")
    @Expose
    var southwest: Southwest? = null
)