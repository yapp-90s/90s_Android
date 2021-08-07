package kr.ninety.android.film

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kr.ninety.android.databinding.FragmentMainFlimBinding

class MainFilmFragment: Fragment() {

    private lateinit var binding: FragmentMainFlimBinding

    companion object {
        fun newInstance() = MainFilmFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainFlimBinding.inflate(inflater)
        return binding.root
    }
}
