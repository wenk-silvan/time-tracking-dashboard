package nl.hva.timetrackingdashboard.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nl.hva.timetrackingdashboard.R
import nl.hva.timetrackingdashboard.databinding.ItemSectionBinding
import nl.hva.timetrackingdashboard.models.Section

class SectionsAdapter(private val sections: List<Section>) :
    RecyclerView.Adapter<SectionsAdapter.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemSectionBinding.bind(itemView)

        fun databind(section: Section) {
            binding.tvTitle.text = section.title
            binding.tvHours.text = "${section.timeframes?.weekly?.current}hrs"
            binding.tvTimeframe.text = "Last Week - ${section.timeframes?.weekly?.previous}hrs"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_section, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return sections.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(sections[position])
    }
}