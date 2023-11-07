package com.farmfinal.app.modules.diary.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.farmfinal.app.R
import com.farmfinal.app.appcomponents.base.BaseActivity
import com.farmfinal.app.databinding.ActivityDiaryBinding
import com.farmfinal.app.modules.diary.`data`.model.DatesRowModel
import com.farmfinal.app.modules.diary.`data`.viewmodel.DiaryVM
import com.farmfinal.app.modules.list.ui.ListActivity
import com.farmfinal.app.modules.main.ui.MainActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class DiaryActivity : BaseActivity<ActivityDiaryBinding>(R.layout.activity_diary) {
  private val viewModel: DiaryVM by viewModels<DiaryVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val datesAdapter = DatesAdapter(viewModel.datesList.value?:mutableListOf())
    binding.recyclerDates.adapter = datesAdapter
    datesAdapter.setOnItemClickListener(
    object : DatesAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : DatesRowModel) {
        onClickRecyclerDates(view, position, item)
      }
    }
    )
    viewModel.datesList.observe(this) {
      datesAdapter.updateData(it)
    }
    binding.diaryVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.viewEllipseTwo.setOnClickListener {
      val destIntent = ListActivity.getIntent(this, null)
      startActivity(destIntent)
      this.overridePendingTransition(R.anim.left_to_right ,R.anim.left_to_right )
      finish()
    }
    binding.viewEllipseOne.setOnClickListener {
      val destIntent = MainActivity.getIntent(this, null)
      startActivity(destIntent)
      this.overridePendingTransition(R.anim.left_to_right ,R.anim.left_to_right )
      finish()
    }
  }

  fun onClickRecyclerDates(
    view: View,
    position: Int,
    item: DatesRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "DIARY_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, DiaryActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
