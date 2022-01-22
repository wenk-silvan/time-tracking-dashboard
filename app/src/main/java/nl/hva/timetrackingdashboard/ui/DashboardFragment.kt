package nl.hva.timetrackingdashboard.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import nl.hva.timetrackingdashboard.R
import nl.hva.timetrackingdashboard.databinding.FragmentDashboardBinding
import nl.hva.timetrackingdashboard.models.Section
import nl.hva.timetrackingdashboard.viewModels.SectionsViewModel

class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SectionsViewModel by viewModels()
    private val sections: ArrayList<Section> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getSections()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeSections() {
        viewModel.sections.observe(viewLifecycleOwner) {
            sections.clear()
            sections.addAll(it)
//            recyclerViewAdapter.notifyDataSetChanged()
        }
    }
}