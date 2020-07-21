package com.ozcanalasalvar.samplemapapp.common

import android.os.Bundle
import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


@BindingAdapter("setAdapter")
fun bindRecyclerViewAdapter(
    recyclerView: RecyclerView,
    adapter: RecyclerView.Adapter<*>?
) {
    recyclerView.adapter = adapter
}


@BindingAdapter("setAdapter")
fun bindViewPagerAdapter(
    viewPager: ViewPager,
    adapter: FragmentPagerAdapter
) {
    viewPager.adapter = adapter
}


@BindingAdapter("layoutManager")
fun bindLayoutManager(recyclerView: RecyclerView, layoutManager: RecyclerView.LayoutManager) {
    recyclerView.setHasFixedSize(true)
    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
}


fun ImageView.downloadFromUrl(url: String?) {

    if (!TextUtils.isEmpty(url)) {

        Glide.with(context)
            .setDefaultRequestOptions(RequestOptions())
            .load(url)
            .into(this)
    }

}

@BindingAdapter("android:downloadUrl")
fun downloadImage(view: ImageView, url: String?) {
    if (!TextUtils.isEmpty(url)) {
        view.downloadFromUrl(url)
    }
}


@BindingAdapter("initMap")
fun initMap(mapView: MapView?, latLng: LatLng?) {
    if (mapView != null) {
        mapView.onCreate(Bundle())
        mapView.getMapAsync(OnMapReadyCallback { googleMap -> // Add a marker
            googleMap.addMarker(MarkerOptions().position(latLng!!).title("Marker in India"))
        })
    }
}
