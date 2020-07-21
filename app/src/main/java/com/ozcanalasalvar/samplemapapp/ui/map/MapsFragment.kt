package com.ozcanalasalvar.samplemapapp.ui.map

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.ozcanalasalvar.samplemapapp.R
import com.ozcanalasalvar.samplemapapp.base.BaseFragment
import com.ozcanalasalvar.samplemapapp.databinding.FragmentMapsBinding

class MapsFragment : BaseFragment<FragmentMapsBinding, MapsViewModel>(),
    GoogleMap.OnMarkerClickListener, MapNavigator {

    private lateinit var mMap: GoogleMap
    private lateinit var placeMarker: Marker

    override val mViewModel: MapsViewModel
        get() = ViewModelProviders.of(this).get(MapsViewModel::class.java)

    override fun getLayoutResId(): Int = R.layout.fragment_maps

    override fun init() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        mViewModel.getSharedPlace()
    }


    private val callback = OnMapReadyCallback { googleMap ->
        mMap = googleMap
        mMap.setOnMarkerClickListener(this)
        binding.navigator = this
        observePlaceLiveData()
    }


    private fun observePlaceLiveData() {
        mViewModel.sharedPlace.observe(this, Observer { place ->
            place?.let { data ->
                val sydney = LatLng(
                    data.geometry?.location?.lat!!.toDouble(),
                    data.geometry?.location?.lng!!.toDouble()
                )
                placeMarker =
                    mMap.addMarker(MarkerOptions().position(sydney).title(data.name))
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10.0f));

            }
        })
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        Navigation.findNavController(requireParentFragment().requireView())
            .navigate(MapsFragmentDirections.actionMapsFragmentToDetailFragment())
        return true
    }

    override fun onSearchClick() {
        Navigation.findNavController(requireParentFragment().requireView())
            .navigate(MapsFragmentDirections.actionMapsFragmentToSearchFragment())
    }

}