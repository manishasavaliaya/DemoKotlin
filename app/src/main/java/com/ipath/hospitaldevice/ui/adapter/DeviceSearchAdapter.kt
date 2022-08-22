import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ipath.hospitaldevice.R

class DeviceSearchAdapter : RecyclerView.Adapter<DeviceSearchAdapter.ViewHolder>() {

    private val mContext: Context? = null
    private val mSearchDeviceList: ArrayList<String>? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_device_search, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position41: Int) {

        holder.tvDeviceSearch.setText(mSearchDeviceList!!.get(position41));
        holder.llDeviceSearch.setOnClickListener {

                    mOnItemClickListener!!.onItemClick(position41);

        }
    }



    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var   llDeviceSearch = itemView.findViewById<LinearLayout>(R.id.ll_device_search);
            var tvDeviceSearch = itemView.findViewById<TextView>(R.id.tv_device_search);

    }


    fun setOnItemClick(onItemClickListener:OnItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

     var mOnItemClickListener:OnItemClickListener?=null;

    interface OnItemClickListener{
      fun onItemClick(position:Int);
    }

    override fun getItemCount(): Int {
        return mSearchDeviceList!!.size
    }

}
