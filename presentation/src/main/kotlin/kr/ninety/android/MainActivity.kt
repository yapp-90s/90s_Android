package kr.ninety.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.activity.viewModels
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import kr.ninety.android.album.MainAlbumFragment
import kr.ninety.android.databinding.ActivityMainBinding
import kr.ninety.android.film.MainFilmFragment
import kr.ninety.android.profile.MainProfileFragment
import kr.ninety.android.util.DrawableResourceUtil

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
    }

    private fun initData() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener(this)
        addFragment(MainAlbumFragment.newInstance(), MainAlbumFragment::class.java.name)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.album -> {
                val tag = MainAlbumFragment::class.java.name
                supportFragmentManager.findFragmentByTag(tag)
                    ?.let {
                        showFragment(it)
                    } ?: addFragment(MainAlbumFragment.newInstance(), tag)
                return true
            }

            R.id.film -> {
                val tag = MainFilmFragment::class.java.name
                supportFragmentManager.findFragmentByTag(tag)
                    ?.let {
                        showFragment(it)
                    } ?: addFragment(MainFilmFragment.newInstance(), tag)
                return true
            }

            R.id.profile -> {
                val tag = MainProfileFragment::class.java.name
                supportFragmentManager.findFragmentByTag(tag)
                    ?.let {
                        showFragment(it)
                    } ?: addFragment(MainProfileFragment.newInstance(), tag)
                return true
            }
        }
        return false
    }

    private fun addFragment(target: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .hideFragments()
            .add(R.id.mainContainer, target, tag)
            .commitNow()
    }

    private fun showFragment(target: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .hideFragments()
            .show(target)
            .commit()
    }

    private fun removeFragment(target: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .remove(target)
            .commitAllowingStateLoss()
    }

    private fun FragmentTransaction.hideFragments(): FragmentTransaction {
        supportFragmentManager.fragments.forEach { hide(it) }
        return this
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        supportFragmentManager.fragments.forEach {
            if (it.isHidden) {
                removeFragment(it)
            }
        }
    }

//        /**
//         * Component Background Example
//         */
//        button.background = DrawableResourceUtil.gradientDrawable(
//            context = this,
//            backgroundColor = resources.getColor(R.color.orange, null),
//            cornerRadius = 8f
//        )
}
