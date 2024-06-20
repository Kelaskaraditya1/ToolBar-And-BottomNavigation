package com.starkindustries.toolbarbottomnav
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
import com.starkindustries.toolbarbottomnav.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        try
        {
            supportActionBar?.title ="Toolbar"
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        catch (e:Exception)
        {
            Log.d("error","The error is: "+e.printStackTrace())
        }
        binding.bottomNav.setOnItemSelectedListener()
        {
            when(it.itemId)
            {
                R.id.home-> Toast.makeText(applicationContext, "Home Fragment", Toast.LENGTH_SHORT).show()
                R.id.students-> Toast.makeText(applicationContext, "Students Section Fragment", Toast.LENGTH_SHORT).show()
                R.id.profile-> Toast.makeText(applicationContext, "Profile Fragment", Toast.LENGTH_SHORT).show()
            }
            true
        }
//        binding.bottomNav.setOnNavigationItemSelectedListener(object:BottomNavigationView.OnNavigationItemSelectedListener{
//            override fun onNavigationItemSelected(menuIetm: MenuItem): Boolean {
//                when(menuIetm.itemId)
//                {
//                    R.id.home-> Toast.makeText(applicationContext, "Home Fragment", Toast.LENGTH_SHORT).show()
//                    R.id.students-> Toast.makeText(applicationContext, "Students Section Fragment", Toast.LENGTH_SHORT).show()
//                    R.id.profile-> Toast.makeText(applicationContext, "Profile Fragment", Toast.LENGTH_SHORT).show()
//                }
//                return true
//            }
//
//        })
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(applicationContext).inflate(R.menu.menufile,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id:Int = item.itemId
        when(id)
        {
            R.id.profile-> Toast.makeText(applicationContext, "Profile", Toast.LENGTH_SHORT).show()
            R.id.settings-> Toast.makeText(applicationContext, "Settings", Toast.LENGTH_SHORT).show()
            R.id.save-> Toast.makeText(applicationContext, "Save File", Toast.LENGTH_SHORT).show()
            R.id.delete-> Toast.makeText(applicationContext, "Delete Successfully", Toast.LENGTH_SHORT).show()
            R.id.logout-> Toast.makeText(applicationContext, "Logout", Toast.LENGTH_SHORT).show()
            android.R.id.home->{
                var exitDialog = AlertDialog.Builder(this)
                exitDialog.setIcon(R.drawable.exit)
                exitDialog.setTitle("Exit")
                exitDialog.setMessage("Are you sure, you want to exit?")
                exitDialog.setPositiveButton("Yes",object:DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        onBackPressed()
                    }
                })
                exitDialog.setNegativeButton("No",object :DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {

                    }

                })
                exitDialog.setNeutralButton("Cancel",object:DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {

                    }

                })
                exitDialog.setCancelable(false)
                exitDialog.show()
            }

        }
        return super.onOptionsItemSelected(item)
    }
}