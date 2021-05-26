package com.example.radarpop.data.template.controleur

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.radarpop.R

class GhibliAdapter (private var dataSet:List<GhibliListResp>, var listener: ( (Int) -> Unit )? = null ) : RecyclerView.Adapter<GhibliAdapter.ViewHolder>() {


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView
        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.ghibli_name)
            imageView = view.findViewById(R.id.ghibli_img)
        }
    }

    fun updateList(list: List<GhibliListResp>){
        dataSet = list
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.ghibli_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val ghibli= dataSet[position]
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = ghibli.title
        viewHolder.itemView.setOnClickListener{
            listener?.invoke(position)
        }
        Glide
                .with(viewHolder.itemView.context)
                //File(app/src/main/res/drawable/totoro.png)
                .load("https://i.pinimg.com/originals/63/01/78/6301783183305a32d118bc19d422da86.jpg")
                .circleCrop()
                .into(viewHolder.imageView);
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}