package com.paranoid.mao.flowexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class ExampleFragment : Fragment() {

  companion object {
    private const val LAYOUT_KEY = "layout"

    fun create(@LayoutRes resId: Int): ExampleFragment {
      val fragment = ExampleFragment()
      val argument = bundleOf(
        LAYOUT_KEY to resId
      )
      fragment.arguments = argument
      return fragment
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val resId = arguments!!.getInt(LAYOUT_KEY)
    return inflater.inflate(resId, container, false)
  }
}
