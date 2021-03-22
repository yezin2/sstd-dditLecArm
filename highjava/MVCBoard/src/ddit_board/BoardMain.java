package ddit_board;

import java.util.List;
import java.util.Scanner;

import ddit_board.service.BoardServiceImpl;
import ddit_board.service.IBoardService;
import ddit_board.vo.BoardVO;

public class BoardMain {
	private IBoardService boaService;
	
	public BoardMain() {
		boaService = new BoardServiceImpl();
	}
	
	private Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		BoardMain boaObj = new BoardMain();
		boaObj.start();
	}
	
	//메뉴 출력 메서드
	public void displayMenu() {
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
	}//diplayMenu
	
	//프로그램 시작 메서드
	public void start() {
		int choice;
		do {
			displayMenu();
			choice = scan.nextInt();
			switch (choice) {
				case 1:
					insertBoard();		//게시물 입력
					break;
				case 2:
					deleteBoard();		//게시물 삭제
					break;
				case 3:
					updateBoard();		//게시물 수정
					break;
				case 4:
					displayABoard();	//게시물 전체 출력
					break;
				case 5:
					searchBoard();		//게시물 검색
					break;
				case 6:
					System.out.println("***************작업 종료*****************");
					break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}//switch
		} while(choice!=6);//do-while
	}//start

	//게시물 검색 메서드
	private void searchBoard() {
		scan.nextLine();
		System.out.println();
		System.out.println("검색할 정보를 입력하세요.");
		System.out.print("게시물 번호 >> ");
		String boardNo = scan.nextLine();
		
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
		List<BoardVO> boardList = boaService.getSearchBoard(bv);
		
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		System.out.println(" 게시물 번호\t게시물 제목\t게시물 작성자\t게시물 내용\t게시일자");
		System.out.println("-----------------------------------------------------------------");
		
		for(BoardVO bv2 : boardList){
			System.out.println(bv2.getBoardNo() + "\t" + bv2.getBoardTit()
						+ "\t" + bv2.getBoardAut() + "\t" + bv2.getBoardCont()
						+ "\t" + bv2.getBoardDay());
		}
		
		System.out.println("-------------------------------------------");
		System.out.println("출력 작업 끝...");
			
	}

	//게시물 전체 출력 메서드
	private void displayABoard() {
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		System.out.println(" 게시물 번호\t게시물 제목\t게시물 작성자\t게시물 내용\t게시일자");
		System.out.println("-----------------------------------------------------------------");
		
		
		List<BoardVO> boardList = boaService.getAllBoardList();
		
		for(BoardVO bv : boardList) {
			System.out.println(bv.getBoardNo() 
					+ "\t" + bv.getBoardTit() + "\t"
					+ bv.getBoardAut() + "\t" + bv.getBoardCont() 
					+ "\t" + bv.getBoardDay());
		}
		
		System.out.println("---------------------------------------");
		System.out.println("출력 작업 끝...");
		
	}

	//게시물 수정 메서드
	private void updateBoard() {
		boolean chk = false;
		String boardNo = null;
		
		do {
			System.out.println();
			System.out.println("수정할 게시물 정보를 입력하세요.");
			System.out.print("게시물 번호 >> ");
			boardNo = scan.nextLine();
			
			chk =  boaService.checkBoard(boardNo);
			
			if(chk == false) {
				System.out.println("입력한 게시물 번호에 해당하는 " + boardNo + "가 없습니다.");
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
		bv.setBoardTit(boardTit);
		bv.setBoardAut(boardAut);
		bv.setBoardCont(boardCont);
		bv.setBoardNo(boardNo);
		
		int cnt = boaService.updateBoard(bv);
		
		if(cnt > 0) {
			System.out.println(boardNo + "회원정보 수정 작업 성공");
		}else {
			System.out.println(boardNo + "회원정보 수정 작업 실패!!!");
		}
		
	}

	//게시물 삭제 메서드
	private void deleteBoard() {
		System.out.println();
		System.out.println("삭제할 게시물 번호를 입력하세요.");
		System.out.print("게시물 번호 >> ");
		String boardNo = scan.nextLine();
		
		int cnt = boaService.deleteBoard(boardNo);
		
		if(cnt > 0) {
			System.out.println(boardNo + "회원정보 삭제 작업 성공");
		}else {
			System.out.println(boardNo + "회원정보 삭제 작업 실패!!!");
		}
		
	}

	//게시물 추가 메서드
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
		
		int cnt = boaService.insertBoard(bv);
	}
}
