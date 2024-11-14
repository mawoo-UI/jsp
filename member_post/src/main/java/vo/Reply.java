package vo;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Reply {
	private Long rno;
	private String content;
	private Date regdate;
	private Date updatedate;
	private boolean hidden;
	private int likes;
	private String writer;
	private Long pno;
}
