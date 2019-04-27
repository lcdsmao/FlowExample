package com.paranoid.mao.flowexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val navigation = findViewById<BottomNavigationView>(R.id.navigation)
    navigation.setOnNavigationItemSelectedListener {
      navigate(it)
      true
    }
  }

  private fun navigate(menuItem: MenuItem) {
    val resId = when (menuItem.itemId) {
      R.id.linear -> R.layout.layout_linear_example
      R.id.constraint -> R.layout.layout_constraint_example
      R.id.flow -> R.layout.layout_flow_example
      else -> return
    }
    menuItem.isChecked = true
    val fragment = ExampleFragment.create(resId)
    supportFragmentManager.beginTransaction()
      .replace(R.id.fragment_container, fragment)
      .commit()
  }
}
