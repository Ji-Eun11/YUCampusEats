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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weekly_menu, container, false)

        // RecyclerView 연결
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerWeeklyMenu)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val MenuList = listOf(
            // 6월 2일 월요일 - 학생회관 식당
            WeeklyMenu("6월2일 MON", "학생회관", "한식", "볶음김치삼겹덮밥&계후 5.5"),
            WeeklyMenu("6월2일 MON", "학생회관", "한식", "고추장목살갈비덮밥 5.5"),
            WeeklyMenu("6월2일 MON", "학생회관", "한식", "불맛지코바st치밥 5.2"),
            WeeklyMenu("6월2일 MON", "학생회관", "한식", "치킨마요덮밥 4.7"),
            WeeklyMenu("6월2일 MON", "학생회관", "스폐셜", "불닭볶음면&슬라이스치즈1장&소시지 5.9"),
            WeeklyMenu("6월2일 MON", "학생회관", "스폐셜", "뚝!부대찌개+라면사리&떡갈비&김 6.5"),
            WeeklyMenu("6월2일 MON", "학생회관", "돈가스&분식", "등심돈가스 5.7"),
            WeeklyMenu("6월2일 MON", "학생회관", "돈가스&분식", "매콤야끼돈가스 6.2"),
            WeeklyMenu("6월2일 MON", "학생회관", "돈가스&분식", "영대소바 5.5"),
            WeeklyMenu("6월2일 MON", "학생회관", "돈가스&분식", "영대소바&set돈가스 6.7"),
            WeeklyMenu("6월2일 MON", "학생회관", "천원의 아침밥", "볶음김치참치덮밥&핫도그&요구르트 1.0"),

            // 6월 4일 수요일 - 학생회관 식당
            WeeklyMenu("6월4일 WED", "학생회관", "한식", "비빔밥한상(비빔밥&계후&너비아니&된찌) 6.5"),
            WeeklyMenu("6월4일 WED", "학생회관", "한식", "숯불부타동덮밥 5.5"),
            WeeklyMenu("6월4일 WED", "학생회관", "한식", "눈꽃치즈닭갈비덮밥 5.2"),
            WeeklyMenu("6월4일 WED", "학생회관", "한식", "매콤돈가스마요덮밥 5.0"),
            WeeklyMenu("6월4일 WED", "학생회관", "스폐셜", "마라짜장면&교자만두&단무지 5.2"),
            WeeklyMenu("6월4일 WED", "학생회관", "스폐셜", "뚝!매콤돼지갈비찜&교자만두&김가루밥&콩나물무침 6.7"),
            WeeklyMenu("6월4일 WED", "학생회관", "돈가스&분식", "등심돈가스 5.7"),
            WeeklyMenu("6월4일 WED", "학생회관", "돈가스&분식", "영대소바 5.5"),
            WeeklyMenu("6월4일 WED", "학생회관", "돈가스&분식", "영대소바&set돈가스 6.7"),
            WeeklyMenu("6월4일 WED", "학생회관", "천원의 아침밥", "얼큰소고기국밥&떡갈비&도시락김 1.0"),

            // 6월 5일 목요일 - 학생회관
            WeeklyMenu("6월5일 THU", "학생회관", "한식", "낙삼새비빔밥&계후&된찌 6.7"),
            WeeklyMenu("6월5일 THU", "학생회관", "한식", "치킨가라아게커리덮밥 5.2"),
            WeeklyMenu("6월5일 THU", "학생회관", "한식", "고추장대패삼겹덮밥 5.2"),
            WeeklyMenu("6월5일 THU", "학생회관", "한식", "치킨마요덮밥 4.7"),
            WeeklyMenu("6월5일 THU", "학생회관", "스폐셜", "병천순대국밥&미니수육 6.5"),
            WeeklyMenu("6월5일 THU", "학생회관", "스폐셜", "해물칼국수&휴게소핫바 6.5"),
            WeeklyMenu("6월5일 THU", "학생회관", "돈가스&분식", "등심돈가스 5.7"),
            WeeklyMenu("6월5일 THU", "학생회관", "돈가스&분식", "영대소바 5.5"),
            WeeklyMenu("6월5일 THU", "학생회관", "돈가스&분식", "영대소바&set돈가스 6.7"),
            WeeklyMenu("6월5일 THU", "학생회관", "천원의 아침밥", "마라두부덮밥&군만두&과일쥬스 1.0"),

            // 6월 2일 월요일 - 인문계 교직원식당
            WeeklyMenu("6월2일 MON", "인문계 교직원식당", "점심", "황금순살찜닭(+납작당면), 잡곡밥, 맑은모듬어묵탕, 고구마고로케&케찹, 명엽채볶음, 참나물겉절이, 포기김치"),
            WeeklyMenu("6월2일 MON", "인문계 교직원식당", "저녁", "도토리묵사발, 잡곡밥, 불맛고추장제육, 느타리호박볶음, 김가루콩나물무침, 상추겉절이, 포기김치"),

            // 6월 4일 수요일 - 인문계 교직원식당
            WeeklyMenu("6월4일 WED", "인문계 교직원식당", "점심", "돈육소금구이, 잡곡밥, 근대된장국, 야채계란찜, 어묵고추장무침, 상추쌈&쌈장, 포기김치"),
            WeeklyMenu("6월4일 WED", "인문계 교직원식당", "저녁", "돈가스김치나베, 잡곡밥, 타코야끼3ps, 참깨D양배추샐러드, 꼬들단무지무침, 포기김치"),

            // 6월 5일 목요일 - 인문계 교직원식당
            WeeklyMenu("6월5일 THU", "인문계 교직원식당", "점심", "매콤삼겹덮밥(+계란후라이), 오이미역냉국, 오리엔탈D그린샐러드, 모둠수제피클, 요구르트, 포기김치"),
                    WeeklyMenu("6월5일 THU", "인문계 교직원식당", "저녁", "닭곰탕(+당면사리), 백미밥, 청양김치전, 감자간장조림, 오이고추&쌈장, 모듬야채겉절이, 깍두기")
        )

        val adapter = WeeklyMenuAdapter(MenuList)
        recyclerView.adapter = adapter

        return view
    }
}
