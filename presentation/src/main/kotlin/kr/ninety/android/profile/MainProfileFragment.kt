package kr.ninety.android.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kr.ninety.android.databinding.FragmentMainProfileBinding

class MainProfileFragment : Fragment() {

    private lateinit var binding: FragmentMainProfileBinding

    companion object {
        fun newInstance() = MainProfileFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainProfileBinding.inflate(inflater)
        return binding.root
    }
}
