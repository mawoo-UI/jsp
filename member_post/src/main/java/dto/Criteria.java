package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Criteria {
	private int page = 1; //처음 보여주는 페이지
	private int amount = 10; //게시물 갯수
	
}