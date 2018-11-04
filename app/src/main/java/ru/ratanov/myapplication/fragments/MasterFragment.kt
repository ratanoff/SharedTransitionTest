package ru.ratanov.myapplication.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.transition.TransitionInflater
import kotlinx.android.synthetic.main.fragment_master.view.*
import ru.ratanov.myapplication.R
import ru.ratanov.myapplication.adpater.AnimalAdapter
import ru.ratanov.myapplication.adpater.AnimalItemClickListener
import ru.ratanov.myapplication.entity.generateAnimalItems


class MasterFragment : Fragment(), AnimalItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_master, container, false)
        view.recycler_view.layoutManager = GridLayoutManager(context, 2)
        view.recycler_view.adapter = AnimalAdapter(generateAnimalItems(inflater.context), this@MasterFragment)

        return view
    }


    override fun onAnimalItemClick(imageUrl: String, sharedImage: ImageView) {
        findNavController().navigate(
            R.id.action_masterFragment_to_detailFragment,
            bundleOf("extra_image_url" to imageUrl),
            null,
            FragmentNavigatorExtras(sharedImage to imageUrl)
        )
    }
}
