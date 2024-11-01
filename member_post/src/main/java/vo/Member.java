package vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Member {
	private String id;	
	private String pw;
	private String name;
	private String email;
	private String roadAddr;
	private String detailAddr;
	private Date regdate;
}
