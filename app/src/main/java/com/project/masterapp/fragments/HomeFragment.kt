package com.project.masterapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.project.masterapp.HomeActivity
import com.project.masterapp.PlantModel
import com.project.masterapp.R
import com.project.masterapp.adapter.PlantAdapter
import com.project.masterapp.adapter.PlantItemDecoration

class HomeFragment( private val context: HomeActivity) : Fragment(
) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)

        //créer une liste qui va stocker ces plantes
        val plantlist = arrayListOf<PlantModel>()

        //enregistrer dans notre liste pissenlit
        plantlist.add(PlantModel("pissenlit", "belle plante", "https://unsplash.com/fr/photos/_6rR_iP06p4", false))
        plantlist.add(PlantModel("rose", "valentin", "https://unsplash.com/fr/photos/_FSA44MuXn4", false))
        plantlist.add(PlantModel("cactus", "ça pique", "https://unsplash.com/fr/photos/AeqlmVWtzFA", false))
        plantlist.add(PlantModel("tournesol", "soleil", "https://unsplash.com/fr/photos/2IzoIHBgYAo", false))

        val horizontalRecyclerView = view?.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView?.adapter = PlantAdapter(context, plantlist, R.layout.item_horizontal_plant)

        val verticalRecyclerView = view?.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView?.adapter = PlantAdapter(context, plantlist, R.layout.item_vertical_plant)
        verticalRecyclerView?.addItemDecoration(PlantItemDecoration())

        return view
    }
}