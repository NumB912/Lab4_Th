import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3_7_2.Book
import com.example.lab3_7_2.databinding.ItemBookBinding
class BookAdapter(private val itemList: List<Book>) :
        RecyclerView.Adapter<BookAdapter.BooKViewHolder>() {
        // ViewHolder class sử dụng ViewBinding
        class BooKViewHolder(val binding: ItemBookBinding) :
                RecyclerView.ViewHolder(binding.root)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
                BooKViewHolder {
                // Sử dụng ViewBinding để inflate layout
                val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent,
                        false)
                return BooKViewHolder(binding)
        }
        override fun onBindViewHolder(holder: BooKViewHolder, position: Int) {
                // Gán dữ liệu vào các thành phần UI
                val item = itemList[position]
                holder.binding.textViewTitle.text = item.title
                holder.binding.textViewAuthor.text = item.author
        }
        override fun getItemCount(): Int {
                return itemList.size
        }
}
