package kr.ninety.android.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kr.ninety.android.databinding.FragmentMainAlbumBinding

class MainAlbumFragment: Fragment() {

    private lateinit var binding: FragmentMainAlbumBinding

    companion object {
        fun newInstance() = MainAlbumFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainAlbumBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
