package com.project.factory.view.dept;

import com.project.factory.view.MainView;

public class AreaView {

	public static void areaView() {
		MainView.singnleLine();
		System.out.println("\t\t\t\t\t[행정구역 번호]");
		MainView.singnleLine();
		System.out.println();
		System.out.println("1. 서울특별시  2. 부산광역시  3. 대구광역시  4. 인천광역시  5. 광주광역시  6. 대전광역시 7. 울산광역시");
		System.out.println("8. 세종특별자치시 9. 경기도  10. 충청북도  11. 충청남도  12. 전라남도  13. 경상북도  14. 경상남도");
		System.out.println("15. 제주특별자치도  16. 강원특별자치도  17.전북특별자치도");
		System.out.println();
		MainView.singnleLine();
	}
}
