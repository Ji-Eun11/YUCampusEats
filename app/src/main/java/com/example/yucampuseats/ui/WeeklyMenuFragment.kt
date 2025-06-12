package com.example.yucampuseats.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yucampuseats.R
import com.example.yucampuseats.adapter.WeeklyMenuAdapter
import com.example.yucampuseats.model.WeeklyMenu

class WeeklyMenuFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WeeklyMenuAdapter

    // 메뉴 데이터
    private val menuList = listOf(
        WeeklyMenu("2025-06-09", "학생회관 식당", "한식", "볶음 김치 삼겹 덮밥 & 계란후라이 5.5"),
        WeeklyMenu("2025-06-09", "학생회관 식당", "한식", "소고기 바질 덮밥 & 춘권 & 스리라차 소스 5.7"),
        WeeklyMenu("2025-06-09", "학생회관 식당", "한식", "불맛 지코바st 치밥 5.2"),
        WeeklyMenu("2025-06-09", "학생회관 식당", "한식", "치킨 마요 덮밥 4.7"),
        WeeklyMenu("2025-06-09", "학생회관 식당", "스폐셜", "삼겹살 비빔밥 5.5"),
        WeeklyMenu("2025-06-09", "학생회관 식당", "스폐셜", "뚝! 부대찌개+라면사리 & 떡갈비 & 김 6.7"),
        WeeklyMenu("2025-06-09", "학생회관 식당", "돈가스&분식", "등심 돈가스 5.7"),
        WeeklyMenu("2025-06-09", "학생회관 식당", "돈가스&분식", "영대 소바 5.5"),
        WeeklyMenu("2025-06-09", "학생회관 식당", "돈가스&분식", "영대 소바 & set 돈가스 6.7"),

        WeeklyMenu("2025-06-10", "학생회관 식당", "한식", "훈제 오리 부추 덮밥 5.5"),
        WeeklyMenu("2025-06-10", "학생회관 식당", "한식", "태국st 팟타이 덮밥 & 교자만두 5.7"),
        WeeklyMenu("2025-06-10", "학생회관 식당", "한식", "김치 제육 덮밥 & 계란후라이 5.2"),
        WeeklyMenu("2025-06-10", "학생회관 식당", "한식", "숯불 바베큐 마요 덮밥 4.9"),
        WeeklyMenu("2025-06-10", "학생회관 식당", "스폐셜", "매콤 로제 크림 우동 & 케이준 치킨 샐러드 6.5"),
        WeeklyMenu("2025-06-10", "학생회관 식당", "스폐셜", "뼈 없는 감자탕 & 치킨 너겟 5.5"),
        WeeklyMenu("2025-06-10", "학생회관 식당", "돈가스&분식", "등심 돈가스 5.7"),
        WeeklyMenu("2025-06-10", "학생회관 식당", "돈가스&분식", "영대 소바 5.5"),
        WeeklyMenu("2025-06-10", "학생회관 식당", "돈가스&분식", "영대 소바 & set 돈가스 6.7"),

        WeeklyMenu("2025-06-11", "학생회관 식당", "한식", "추억의 도시락 덮밥 & 계란후라이 & 소시지 5.2"),
        WeeklyMenu("2025-06-11", "학생회관 식당", "한식", "불향 목살 덮밥 5.2"),
        WeeklyMenu("2025-06-11", "학생회관 식당", "한식", "불향! 쭈꾸미 삼겹 덮밥 5.5"),
        WeeklyMenu("2025-06-11", "학생회관 식당", "한식", "날치알 새우튀김 마요 덮밥 5.0"),
        WeeklyMenu("2025-06-11", "학생회관 식당", "스폐셜", "불맛 야끼우동 & 교자만두 & 단무지 6.5"),
        WeeklyMenu("2025-06-11", "학생회관 식당", "스폐셜", "뚝! 삼겹 김치찌개 & 어묵볶음 & 김 6.2"),
        WeeklyMenu("2025-06-11", "학생회관 식당", "돈가스&분식", "등심 돈가스 5.7"),
        WeeklyMenu("2025-06-11", "학생회관 식당", "돈가스&분식", "영대 소바 5.5"),
        WeeklyMenu("2025-06-11", "학생회관 식당", "돈가스&분식", "영대 소바 & set 돈가스 6.7"),

        WeeklyMenu("2025-06-12", "학생회관 식당", "한식", "열무 비빔밥 & 계란후라이 & 떡갈비 & 된찌 6.5"),
        WeeklyMenu("2025-06-12", "학생회관 식당", "한식", "치킨 가라아게 카레 덮밥 5.2"),
        WeeklyMenu("2025-06-12", "학생회관 식당", "한식", "고추장 대패 삼겹 덮밥 5.2"),
        WeeklyMenu("2025-06-12", "학생회관 식당", "한식", "치킨 마요 덮밥 4.7"),
        WeeklyMenu("2025-06-12", "학생회관 식당", "스폐셜", "베이컨 김볶 & 소떡소떡 6.7"),
        WeeklyMenu("2025-06-12", "학생회관 식당", "스폐셜", "닭 칼국수 & 비빔 군만두 6.5"),
        WeeklyMenu("2025-06-12", "학생회관 식당", "돈가스&분식", "등심 돈가스 5.7"),
        WeeklyMenu("2025-06-12", "학생회관 식당", "돈가스&분식", "고구마 치즈 돈가스 6.7"),
        WeeklyMenu("2025-06-12", "학생회관 식당", "돈가스&분식", "영대 소바 5.5"),
        WeeklyMenu("2025-06-12", "학생회관 식당", "돈가스&분식", "영대 소바 & set 돈가스 6.7"),

        WeeklyMenu("2025-06-13", "학생회관 식당", "한식", "캠핑 삼겹구이 set & 랜덤반찬 1종 & 된찌 set 6.5"),
        WeeklyMenu("2025-06-13", "학생회관 식당", "한식", "사전 고기 짜장 덮밥 & 계란후라이 & 군만두 5.2"),
        WeeklyMenu("2025-06-13", "학생회관 식당", "한식", "눈꽃 치즈 고추장 제육 덮밥 5.2"),
        WeeklyMenu("2025-06-13", "학생회관 식당", "스폐셜", "뚝! 볼케이노 치밥+우동사리 & 밥 6.0"),
        WeeklyMenu("2025-06-13", "학생회관 식당", "스폐셜", "비빔 막국수 & 토핑 수육 6.0"),
        WeeklyMenu("2025-06-13", "학생회관 식당", "돈가스&분식", "등심 돈가스 5.7"),
        WeeklyMenu("2025-06-13", "학생회관 식당", "돈가스&분식", "영대 소바 5.5"),
        WeeklyMenu("2025-06-13", "학생회관 식당", "돈가스&분식", "영대 소바 & set 돈가스 6.7"),

        WeeklyMenu("2025-06-09", "인문계 교직원 식당", "점심", "뼈 없는 춘천 닭갈비, 잡곡밥, 들깨 미역국, 어니언링&케찹, 숙주나물무침, 열무 겉절이, 포기김치"),
        WeeklyMenu("2025-06-09", "인문계 교직원 식당", "저녁", "깍두기 볶음밥(+계란후라이), 맑은 어묵탕, 케이준 치킨 샐러드, 단무지, 포기김치, 타트 체리 음료"),

        WeeklyMenu("2025-06-10", "인문계 교직원 식당", "점심", "간장 제육 불고기, 잡곡밥, 감자 된장국, 두부양념조림, 미역줄기볶음, 상추쌈&쌈장, 포기김치"),
        WeeklyMenu("2025-06-10", "인문계 교직원 식당", "저녁", "묵으닞 들기름 막국수, 잡곡밥, 김치 두부 콩나물국, 미니 돈가스&케찹, 단호박 샐러드, 단배추 겉절이, 깍두기"),

        WeeklyMenu("2025-06-11", "인문계 교직원 식당", "점심", "목살 스테끼 덮밥(+계란후라이/생와사비), 가쓰오 우동 국물, 오리엔탈D 그린 샐러드, 모듬 수제 피클, 포기김치"),
        WeeklyMenu("2025-06-11", "인문계 교직원 식당", "저녁", "장각 삼계탕, 백미밥, 김치 메밀 전병, 상추 겉절이, 양파고추 간장지, 깍두기"),

        WeeklyMenu("2025-06-12", "인문계 교직원 식당", "점심", "고기 야끼 우동, 잡곡밥, 맑은 콩나물국, 탕수만두, 단무지, 포기김치, 요구르트"),
        WeeklyMenu("2025-06-12", "인문계 교직원 식당", "저녁", "의정부식 부대찌개, 잡곡밥, 고추장 제육 불고기, 감자 고로케&케찹, 취나물무침, 콩나물무침, 포기김치"),

        WeeklyMenu("2025-06-13", "인문계 교직원 식당", "점심", "통등심 돈가스 정식(+케마D 양배추 샐러드)(+마카로니/오이고추/쌈장), 유부미소장국, 기름 떡볶이, 락교, 산고추지, 포기김치"),
        WeeklyMenu("2025-06-13", "인문계 교직원 식당", "저녁", "오므라이스(+새우튀김), 미니 가쓰오 우동, 콘옥수수 샐러드, 모듬 수제 피클, 포기김치")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // fragment_weekly_menu.xml을 inflate함
        val view = inflater.inflate(R.layout.fragment_weekly_menu, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewWeeklyMenu)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = WeeklyMenuAdapter(menuList)
        recyclerView.adapter = adapter

        return view
    }
}