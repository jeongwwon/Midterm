package com.farmfinal.app.modules.list.data.model

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.farmfinal.app.R
import com.farmfinal.app.modules.network.ApiService
import com.farmfinal.app.modules.list.data.model.ListViewItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class ListViewAdapter(private val apiService: ApiService = ApiService.createDefault()) : BaseAdapter() {
    private val listViewItemList = ArrayList<ListViewItem>()

    override fun getCount(): Int {
        return listViewItemList.size
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    override fun getItem(position: Int): Any {
        return listViewItemList[position]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val context = parent.context

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (view == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.listview_item, parent, false)
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        val iconImageView = view!!.findViewById(R.id.imageView1) as ImageView
        val titleTextView = view.findViewById(R.id.textView1) as TextView
        val descTextView = view.findViewById(R.id.textView2) as TextView

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        val listViewItem = listViewItemList[position]

        // 아이템 내 각 위젯에 데이터 반영
        iconImageView.setImageDrawable(listViewItem.image)
        titleTextView.setText(listViewItem.published_date)
        descTextView.setText(listViewItem.text)

        return view
    }
    // Set the entire list of items

    fun addItem(icon: Drawable?, title: String, desc: String) {
        val item = ListViewItem(icon, title, desc)
        listViewItemList.add(item)
        notifyDataSetChanged()
    }

}
