package membership;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import common.JDBConnect;
import jakarta.servlet.ServletContext;

public class MemberDAO extends JDBConnect {
//	public static void main(String[] args) {
//		MemberDAO md = new MemberDAO("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/musthave", "scott", "tiger");
//		MemberDTO member = md.getmeMemberDTO("musthave", "1234");
//		if(member!=null) System.out.println(member);
//	}
	public MemberDAO(String drv, String url, String id, String pw) {
		super(drv, url, id, pw);
	}
	public MemberDAO(ServletContext application) {
		super(application);
	}
	public MemberDTO getmeMemberDTO(String uid, String upass) {
		MemberDTO dto = null;
		String query = "select * from member where id=? and pass=?";
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			psmt = getCon().prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("Pass"));
				dto.setName(rs.getString("Name"));
				dto.setRegidate(rs.getString("Regidate"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return dto;
	}
}
