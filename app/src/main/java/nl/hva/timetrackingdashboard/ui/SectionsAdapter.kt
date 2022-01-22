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
    private var colorCounter: Int = 0
    private val colors: ArrayList<Int> = arrayListOf(
        R.color.orange,
        R.color.lightblue,
        R.color.pink,
        R.color.green,
        R.color.purple,
        R.color.yellow
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemSectionBinding.bind(itemView)

        fun databind(section: Section) {
            binding.tvTitle.text = section.title
            binding.tvHours.text = "${section.timeframes?.weekly?.current}hrs"
            binding.tvTimeframe.text = "Last Week - ${section.timeframes?.weekly?.previous}hrs"

            binding.mcvSection.setCardBackgroundColor(context.getColor(colors[colorCounter]))
            colorCounter = if (colorCounter >= colors.size - 1) 0 else colorCounter + 1
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