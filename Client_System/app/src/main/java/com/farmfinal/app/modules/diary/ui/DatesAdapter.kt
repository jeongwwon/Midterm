package com.farmfinal.app.modules.diary.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.farmfinal.app.R
import com.farmfinal.app.databinding.RowDatesBinding
import com.farmfinal.app.modules.diary.`data`.model.DatesRowModel
import kotlin.Int
import kotlin.collections.List

class DatesAdapter(
  var list: List<DatesRowModel>
) : RecyclerView.Adapter<DatesAdapter.RowDatesVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowDatesVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_dates,parent,false)
    return RowDatesVH(view)
  }

  override fun onBindViewHolder(holder: RowDatesVH, position: Int) {
    val datesRowModel = DatesRowModel()
    // TODO uncomment following line after integration with data source
    // val datesRowModel = list[position]
    holder.binding.datesRowModel = datesRowModel
  }

  override fun getItemCount(): Int = 7
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<DatesRowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: DatesRowModel
    ) {
    }
  }

  inner class RowDatesVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowDatesBinding = RowDatesBinding.bind(itemView)
  }
}
