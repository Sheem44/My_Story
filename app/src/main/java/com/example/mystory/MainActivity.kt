package com.example.mystory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private var textviewEmail: TextView?= null
    private var drwerLayout: DrawerLayout?=null
    private var toolbar: Toolbar?= null
    private var navidtionView: NavigationView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)
        val email= intent.getStringExtra("email")//
        connectviews()
        textviewEmail?.text=email
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupDrawer()
        updateEmailInHeader(email!!)
    }

        private fun updateEmailInHeader(email:String){
            val headerView=navidtionView?.getHeaderView(0)
            val textViewEmail=headerView?.findViewById<TextView>(R.id.tvEmail)
            textViewEmail?.text=email
        }
    private fun setupDrawer(){
        val toggle = ActionBarDrawerToggle(this,drwerLayout,R.string.open,R.string.close)
        drwerLayout?.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                drwerLayout?.openDrawer(GravityCompat.START)
                true
            }else->{
                true
            }
        }
    }
    private fun connectviews(){
        textviewEmail= findViewById(R.id.textviewEmail)
        drwerLayout= findViewById(R.id.drawer)
        toolbar=findViewById(R.id.toolBar)
        navidtionView=findViewById(R.id.navview)
    }
}