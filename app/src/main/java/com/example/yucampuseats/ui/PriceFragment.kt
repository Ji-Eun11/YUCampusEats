package com.example.yucampuseats.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.yucampuseats.databinding.FragmentPriceBinding

class PriceFragment : Fragment() {

    private var _binding: FragmentPriceBinding? = null
    private val binding get() = _binding!!

    // 식당별 메뉴와 가격을 저장할 임시 맵
    private val menuPriceMap = mutableMapOf<String, MutableMap<String, String>>(
        "학생회관 식당" to mutableMapOf(),
        "인문계 교직원 식당" to mutableMapOf(),
        "자연계 학생식당" to mutableMapOf()
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPriceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 식당 리스트 어댑터 설정
        val restaurantList = menuPriceMap.keys.toList()
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, restaurantList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerRestaurant.adapter = adapter

        // 메뉴 추가 버튼 클릭 시
        binding.btnAddMenuPrice.setOnClickListener {
            val restaurant = binding.spinnerRestaurant.selectedItem.toString()
            val menuName = binding.etMenuName.text.toString().trim()
            val menuPrice = binding.etMenuPrice.text.toString().trim()

            if (menuName.isEmpty() || menuPrice.isEmpty()) {
                Toast.makeText(requireContext(), "메뉴명과 가격을 입력하세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val menuMap = menuPriceMap[restaurant]
            if (menuMap != null) {
                menuMap[menuName] = menuPrice
                Toast.makeText(requireContext(), "메뉴가 저장되었습니다.", Toast.LENGTH_SHORT).show()
                binding.etMenuName.text.clear()
                binding.etMenuPrice.text.clear()
                updateMenuList(restaurant)
            }
        }

        // 식당 선택 시 메뉴 리스트 업데이트
        binding.spinnerRestaurant.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedRestaurant = restaurantList[position]
                updateMenuList(selectedRestaurant)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // 아무것도 선택되지 않았을 때는 아무 일도 하지 않음
            }
        }
    }

    private fun updateMenuList(restaurant: String) {
        val menuMap = menuPriceMap[restaurant]
        val menuPriceList = menuMap?.map { "${it.key} : ${it.value}원" } ?: listOf()
        binding.tvMenuPriceList.text = menuPriceList.joinToString("\n")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}