package kr.or.ddit.board;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.vo.BoardVO;

	/*
		회원정보를 관리하는 프로그램을 작성하는데 
		아래의 메뉴를 모두 구현하시오. (CRUD기능 구현하기)
		(DB의 MYMEMBER테이블을 이용하여 작업한다.)
		
		* 게시물 삭제는 회원ID를 입력 받아서 삭제한다.
		
		예시메뉴)
		----------------------
			== 작업 선택 ==
			1. 게시물 입력			---> insert
			2. 게시물 삭제			---> delete
			3. 게시물 수정			---> update
			4. 전체 게시물 출력	---> select
			5. 작업 끝.
		----------------------
		 
		   
	// 회원관리 프로그램 테이블 생성 스크립트 
	create table board(
	    board_id varchar2(8) not null,  -- 회원ID
	    board_name varchar2(100) not null, -- 이름
	    board_tel varchar2(50) not null, -- 전화번호
	    board_addr varchar2(128),    -- 주소
	    CONSTRAINT MYMEMBER_PK PRIMARY KEY (board_id)
	);

	*/
	/**
	 * @author PC-17
	 *
	 */
	public class BoardMain {
		
		// 서비스객체 멤버변수 선언
		private IBoardService boardService;
		
		public BoardMain() {
			boardService = BoardServiceImpl.getInstance();
		}
		
		private Scanner scan = new Scanner(System.in); 
		
		/**
		 * 메뉴를 출력하는 메서드
		 */
		public void displayMenu(){
			System.out.println();
			System.out.println("----------------------");
			System.out.println("  === 작 업 선 택 ===");
			System.out.println("  1. 게시물 입력");
			System.out.println("  2. 게시물 삭제");
			System.out.println("  3. 게시물 수정");
			System.out.println("  4. 전체 게시물 출력");
			System.out.println("  5. 게시물 검색");
			System.out.println("  6. 작업 끝.");
			System.out.println("----------------------");
			System.out.print("원하는 작업 선택 >> ");
		}
		
		/**
		 * 프로그램 시작메서드
		 */
		public void start(){
			int choice;
			do{
				displayMenu(); //메뉴 출력
				choice = scan.nextInt(); // 메뉴번호 입력받기
				switch(choice){
					case 1 :  // 게시물 입력
						insertBoard();
						break;
					case 2 :  // 게시물 삭제
						deleteBoard();
						break;
					case 3 :  // 게시물 수정
						updateBoard();
						break;
					case 4 :  // 전체 게시물 출력
						displayAll();
						break;
					case 5 :  // 작업 끝
						searchBoard();
						break;
					case 6 :  // 작업 끝
						System.out.println("작업을 마칩니다.");
						break;
					default :
						System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
				}
			}while(choice!=6);
		}
		/**
		 * 게시물을 검색하는 메서드
		 */
		private void searchBoard() {
			/*
			 * 검색할 게시물 번호, 게시물 제목, 게시물 작성자, 게시물 내용, 게시일자등을 입력하면
			 * 입력한 정보만 사용하여 검색하는 기능을 구현하시오.
			 * 제목과 내용은 입력한 값이 포함만 되어도 검색되도록 한다.
			 * 입력을 하지 않을 게시물는 엔터키로 다음 입력으로 넘긴다.
			 */
			scan.nextLine();
			System.out.println();
			System.out.println("검색할 정보를 입력하세요.");
			System.out.print("게시물 번호 >> ");
			String boardNo = scan.nextLine().trim();//trim() : 의미없는 공백제거

			System.out.print("게시물 제목 >> ");
			String boardTit = scan.nextLine().trim();//trim() : 의미없는 공백제거
			
			System.out.print("게시물 작성자 >> ");
			String boardAut = scan.nextLine().trim();//trim() : 의미없는 공백제거

			System.out.print("게시물 내용 >> ");
			String boardCont = scan.nextLine().trim();//trim() : 의미없는 공백제거
			
			BoardVO bv = new BoardVO();
			bv.setBoardNo(boardNo);
			bv.setBoardTit(boardTit);
			bv.setBoardAut(boardAut);
			bv.setBoardCont(boardCont);
			
			//입력한 정보로 검색한 내용을 출력하는 부분
			List<BoardVO> boardList = boardService.getSearchBoard(bv);
			
			System.out.println();
			System.out.println("-------------------------------------------");
			System.out.println(" 게시물 번호 \t게시물 제목\t게시물 작성자\t게시물 내용\t게시일자");
			System.out.println("-------------------------------------------");
			
			for(BoardVO bv2 : boardList){
				System.out.println(bv2.getBoardNo() + "\t" + bv2.getBoardTit()
									+ "\t" + bv2.getBoardAut() + "\t" + bv2.getBoardCont()
									+ "\t" + bv2.getBoardDay());
			}
			
			System.out.println("-------------------------------------------");
			System.out.println("출력 작업 끝...");
			
		}

		/**
		 * 게시물을 삭제하는 메서드(입력받은 게시물 번호를 이용하여 삭제한다.)
		 */
		private void deleteBoard() {
			
			System.out.println();
			System.out.println("삭제할 게시물 번호를 입력하세요.");
			System.out.print("게시물 번호 >> ");

			String boardNo = scan.nextLine();
			
			
			int cnt = boardService.deleteBoard(boardNo);
			
			if(cnt > 0) {
				System.out.println(boardNo + "게시물 삭제 작업 성공");
			}else {
				System.out.println(boardNo + "게시물 삭제 작업 실패!!!");
			}
			
		}

		/**
		 * 게시물을 수정하는 메서드
		 */
		private void updateBoard() {
			
			boolean chk = false;
			String boardNo = null;
			
			do {
				System.out.println();
				System.out.println("수정할 게시물 정보를 입력하세요.");
				System.out.print("게시물 번호 >> ");
				boardNo = scan.nextLine();
				
				chk =  boardService.checkBoard(boardNo);
				
				if(chk == false) {
					System.out.println("게시물 번호가 " + boardNo + "인 게시물이 없습니다.");
					System.out.println("다시 입력해 주세요.");
				}
				
			}while(chk == false);
			
			System.out.print("게시물 제목 >> ");
			String boardTit = scan.next();
			
			System.out.print("게시물 작성자 >> ");
			String boardAut = scan.next();
			
			scan.nextLine(); // 입력버퍼 비우기
			System.out.print("게시물 내용 >> ");
			String boardCont = scan.nextLine();
			
			BoardVO bv = new BoardVO();
			bv.setBoardNo(boardNo);
			bv.setBoardTit(boardTit);
			bv.setBoardAut(boardAut);
			bv.setBoardCont(boardCont);
			
			int cnt = boardService.updateBoard(bv);
			
			if(cnt > 0) {
				System.out.println(boardNo + "게시물 수정 작업 성공");
			}else {
				System.out.println(boardNo + "게시물 수정 작업 실패!!!");
			}
		}

		/**
		 * 전체 게시물을 출력하는 메서드
		 */
		private void displayAll() {
			System.out.println();
			System.out.println("---------------------------------------");
			System.out.println(" 게시물 번호\t게시물 제목\t게시물 작성자\t게시물 내용\t게시일자");
			System.out.println("---------------------------------------");
			
			
			List<BoardVO> boardList = boardService.getAllBoardList();
			
			for(BoardVO bv : boardList) {
				System.out.println(bv.getBoardNo() + "\t" + bv.getBoardTit() 
				+ "\t" + bv.getBoardAut() + "\t" + bv.getBoardCont() + "\t" + bv.getBoardDay());
			}
			
			System.out.println("---------------------------------------");
			System.out.println("출력 작업 끝...");
		}

		/**
		 * 게시물을 추가하기 위한 메서드
		 */
		private void insertBoard() {
			
						
			System.out.print("게시물 제목 >> ");
			String boardTit = scan.next();
			
			System.out.print("게시물 작성자 >> ");
			String boardAut = scan.next();
			
			scan.nextLine(); // 입력버퍼 비우기
			System.out.print("게시물 내용 >> ");
			String boardCont = scan.nextLine();
			
			BoardVO bv = new BoardVO();
			bv.setBoardTit(boardTit);
			bv.setBoardAut(boardAut);
			bv.setBoardCont(boardCont);
			
			int cnt = boardService.insertBoard(bv);
			
		}
		

		public static void main(String[] args) {
			BoardMain boardObj = new BoardMain();
			boardObj.start();
		}

	}









