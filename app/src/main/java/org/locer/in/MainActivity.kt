package org.locer.`in`

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.locer.`in`.HomeFragmentDirections.Companion.actionHomeFragmentToSignupFragment
import org.locer.`in`.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val sharedPreferenceUtil by lazy { SharedPreferenceUtil(context = this) }
    private lateinit var boundLayout: ActivityMainBinding
    private lateinit var bottomNavView: BottomNavigationView
    private lateinit var appBarConfig: AppBarConfiguration
    private lateinit var navController: NavController
    private var actionMode: ActionMode? = null
    private val finishActionModeOnDestinationChanged =
        NavController.OnDestinationChangedListener { controller, destination, bundle -> actionMode?.finish() }
    private lateinit var toggle: ActionBarDrawerToggle

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: log check!")

        window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        boundLayout = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(boundLayout.myToolbar)

        toggle = ActionBarDrawerToggle(this, boundLayout.drawerLayout, boundLayout.myToolbar, R.string.open, R.string.close)
        boundLayout.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        boundLayout.navigationView.setNavigationItemSelectedListener(this)


        if (!sharedPreferenceUtil.showIntro()) {
            bottomNavView = boundLayout.mainBottomNavView
            navController = Navigation.findNavController(this, R.id.main_nav_host_fragment)
            navController.addOnDestinationChangedListener(finishActionModeOnDestinationChanged)
            appBarConfig = AppBarConfiguration(navController.graph)
            boundLayout.mainBottomNavView.setupWithNavController(navController)
        } else {
            handleIntro()
        }
        if (!sharedPreferenceUtil.isLoggedIn) {
            navigateToSignUp()
        }
    }

    private fun handleIntro() {
        val homeIntent = Intent(this, IntroActivity::class.java)
        startActivity(homeIntent)
        sharedPreferenceUtil.setIntroShown()
        finish()
    }

    private fun setUpNavMenus(navController: NavController) {
        boundLayout.mainBottomNavView.setupWithNavController(navController = navController)
    }

    private fun navigateToSignUp() {
        boundLayout.mainBottomNavView.visibility = View.GONE
        findNavController(R.id.main_nav_host_fragment).navigate(actionHomeFragmentToSignupFragment())
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.Item_1 -> Toast.makeText(this, "Selected", Toast.LENGTH_SHORT).show()
            R.id.Item_2 -> Toast.makeText(this, "Selected", Toast.LENGTH_SHORT).show()
            R.id.Item_3 -> Toast.makeText(this, "Selected", Toast.LENGTH_SHORT).show()
            R.id.settings -> Toast.makeText(this, "Selected", Toast.LENGTH_SHORT).show()
            R.id.help -> Toast.makeText(this, "Selected", Toast.LENGTH_SHORT).show()
            R.id.rate -> Toast.makeText(this, "Selected", Toast.LENGTH_SHORT).show()
            R.id.feedback -> Toast.makeText(this, "Selected", Toast.LENGTH_SHORT).show()
            R.id.logout -> Toast.makeText(this, "Selected", Toast.LENGTH_SHORT).show()
        }
        boundLayout.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return true
    }

    // don't remove the following code, it may be helpful in future that's why it is kept here
//    val intentForNextScreen: Intent
//        get() = if (sharedPreferenceUtil.showIntro())
//            Intent(this, IntroActivity::class.java)
//        else
//            Intent(this, MainActivity::class.java)

}
