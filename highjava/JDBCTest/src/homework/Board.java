package homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import util.JDBCUtil;

public class Board {
	private static Scanner scan = new Scanner(System.in);
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	public static void main(String[] args) {
		Board newBoard = new Board();
		newBoard.start();
	}
	
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 게시물 등록");
		System.out.println("  2. 게시물 삭제");
		System.out.println("  3. 게시물 수정");
		System.out.println("  4. 전체 게시물 출력");
		System.out.println("  5. 게시물 검색");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("작업 선택 >> ");
	}
	
	public void start(){
		int choice;
		do{
			displayMenu(); //메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch(choice){
				case 1 :  // 자료 입력
					insertBoard();
					break;
				case 2 :  // 자료 삭제
					deleteBoard();
					break;
				case 3 :  // 자료 수정
					updateBoard();
					break;
				case 4 :  // 전체 자료 출력
					displayAll();
					break;
				case 5 :  // 자료 검색
					displayBoard();
					break;
				case 6 :  // 작업 끝
					System.out.println("작업을 마칩니다.");
					break;
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice!=6);
	}
	
	private void displayBoard() {
		System.out.println();
		System.out.println("검색할 게시물 번호를 입력하세요 >> ");
		String boardNo = scan.next();
		
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "select board_no, " + 
					"board_tit, " + 
					"board_aut, " + 
					"board_cont, " + 
					"board_day from board"
					+ " where board_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				rs = pstmt.executeQuery();
				System.out.println();
				System.out.println("================================================");
				System.out.println(" 게시물 번호\t게시물 제목\t게시물 작성자\t게시물 내용\t게시물 작성일");
				System.out.println("================================================");
				
				while(rs.next()) {
					String boardAut = rs.getString("board_aut");
					String boardTit = rs.getString("board_tit");
					String boardCont = rs.getString("board_cont");
					String boardDay = rs.getString("board_day");
					System.out.println(boardNo + "\t" + boardAut + "\t"
										+ boardTit + "\t" + boardCont + "\t"
										+ boardDay + "\t");
				}
				
				System.out.println("================================================");
				System.out.println("출력작업 끝...");
				System.out.println(boardNo + "번 게시물 검색 작업 성공");
			} else {
				System.out.println(boardNo + "번 게시물 검색결과 없음(또는 실패)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(boardNo + "게시물 검색 작업 실패!!");
		} finally {
			JDBCUtil.disConnect(con, stmt, pstmt, rs);
		}
		
	}

	//회원정보를 삭제하는 메서드(입력받은 ID를 이용하여 삭제함)
	private void deleteBoard() {
		
		System.out.println();
		System.out.println("삭제할 게시물 번호를 입력하세요 >> ");
		String boardNo = scan.next();
		
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "delete from board"
					+ " where board_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(boardNo + "번 게시물 삭제 작업 성공");
			} else {
				System.out.println(boardNo + "번 게시물 삭제 작업 실패!!!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(boardNo + "게시물 삭제 작업 실패!!");
		} finally {
			JDBCUtil.disConnect(con, stmt, pstmt, rs);
		}
	}

	//회원정보를 수정하는 메서드
	private void updateBoard() {
		boolean chk = true;
		String boardNo = null;
		
		do {
			System.out.println();
			System.out.println("수정할 게시물 번호를 입력하세요.");
			System.out.println("게시물 번호 >> ");
			boardNo = scan.next();
			
			chk = checkBoard(boardNo);
			
			if(chk == false) {
				System.out.println("게시물 번호 : " + boardNo + "인 게시물이 존재하지 않습니다.");
				System.out.println("다시 입력해 주세요.");
			}
		} while (chk == false);
		
		System.out.println("작성자 >> ");
		String boardAut = scan.next();

		System.out.println("게시물 제목 >> ");
		String boardTit = scan.next();
		
		scan.nextLine(); //입력버퍼 비우기
		System.out.println("게시물 내용 >> ");
		String boardCont = scan.nextLine();
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "update board"
					+ " set board_aut = ?"
					+ " ,board_tit = ?"
					+ " , board_cont = ?"
					+ " , board_day = sysdate"
					+ " where board_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardAut);
			pstmt.setString(2, boardTit);
			pstmt.setString(3, boardCont);
			pstmt.setString(4, boardNo);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(boardNo + "게시물 수정 작업 성공");
			} else {
				System.out.println(boardNo + "게시물 수정 작업 실패!!!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disConnect(con, stmt, pstmt, rs);
		}
	}

	
	//전체 회원을 출력하는 메서드
	private void displayAll() {
		System.out.println();
		System.out.println("================================================");
		System.out.println(" 게시물 번호\t게시물 제목\t게시물 작성자\t게시물 내용\t게시물 작성일");
		System.out.println("================================================");
		
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "select * from board";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String boardNo = rs.getString("board_no");
				String boardAut = rs.getString("board_aut");
				String boardTit = rs.getString("board_tit");
				String boardCont = rs.getString("board_cont");
				String boardDay = rs.getString("board_day");
				System.out.println(boardNo + "\t" + boardAut + "\t"
									+ boardTit + "\t" + boardCont + "\t" + boardDay + "\t");
			}
			System.out.println("================================================");
			System.out.println("출력작업 끝...");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disConnect(con, stmt, pstmt, rs);
		}
		
	}

	//회원을 추가하기 위한 메서드
	private void insertBoard() {
		try {
			con = JDBCUtil.getConnection();
			
			System.out.println();
			System.out.println("추가할 게시물 정보를 입력하세요.");
				
			
			System.out.println("게시물 작성자 >> ");
			String boardAut = scan.next();
			
			System.out.println("게시물 제목 >> ");
			String boardTit = scan.next();
			
			scan.nextLine(); //입력버퍼 비우기
			System.out.println("게시물 내용 >> ");
			String boardCont = scan.nextLine();
			
			String sql = "insert into board (board_no, board_aut, board_tit, board_cont, board_day)"
					+ " values (board_no_seq.nextval, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardAut);
			pstmt.setString(2, boardTit);
			pstmt.setString(3, boardCont);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(boardTit + "게시물 추가 작업 성공");
			} else {
				System.out.println(boardTit + "게시물 추가 작업 실패!!!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disConnect(con, stmt, pstmt, rs);
		}
	}
	
	/*
	 * 게시물 번호를 이용하여 회원이 있는지 알려주는 메서드
	 * @param boardNo
	 * @return 존재하면 true, 없으면 false
	 */
	private boolean checkBoard(String boardNo) {
		boolean chk = false;
		
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "select count(*) cnt from board where board_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			int cnt = 0;
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
			if(cnt > 0) {
				chk = true;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.disConnect(con, stmt, pstmt, rs);
		}
		return chk;
	}	
}