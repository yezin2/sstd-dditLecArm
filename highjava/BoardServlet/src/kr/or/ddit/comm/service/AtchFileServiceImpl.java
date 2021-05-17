package kr.or.ddit.comm.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.comm.dao.AtchFileDaoImpl;
import kr.or.ddit.comm.dao.IAtchFileDao;
import kr.or.ddit.board.vo.AtchFileVO;
import kr.or.ddit.util.FileUploadRequestWrapper;
import sun.security.jca.GetInstance;

public class AtchFileServiceImpl implements IAtchFileService{
	
	private static IAtchFileService fileService;
	private IAtchFileDao fileDao;
	
	private AtchFileServiceImpl() {
		fileDao = AtchFileDaoImpl.getInstance();
	}
	
	public static IAtchFileService getInstance() {
		if(fileService == null) {
			fileService = new AtchFileServiceImpl();
		}
		return fileService;
	}

	@Override
	public AtchFileVO saveAtchFile(FileItem item) throws Exception {
		File uploadDir = new File(FileUploadRequestWrapper.UPLOAD_DIRECTORY);
		if(!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		//파일명만 추출하기
		String orignFileName = new File(item.getName()).getName();
		
		long fileSize = item.getSize(); // 파일 사이즈 가져오기
		String storeFileName = "";
		String filePath = "";
		File storeFile = null;
		
		do {
			storeFileName = UUID.randomUUID().toString().replace("-", "");
			filePath = FileUploadRequestWrapper.UPLOAD_DIRECTORY + File.separator + storeFileName;
			storeFile = new File(filePath);
		} while (storeFile.exists());//파일명이 중복되지 않을때까지..
		
		// 확장자명 추출
		String fileExtension = orignFileName.lastIndexOf(".") < 0 ? "" 
				:orignFileName.substring(orignFileName.lastIndexOf(".")+1);
		
		item.write(storeFile); // 업로드 파일 저장
		
		// 파일 저장 서비스 호출
		AtchFileVO atchFileVO = new AtchFileVO();
		
		fileDao.insertAtchFile(atchFileVO);
		
		atchFileVO.setStreFileNm(storeFileName);
		atchFileVO.setFileSize(fileSize);
		atchFileVO.setOrignlFileNm(orignFileName);
		atchFileVO.setFileStreCours(filePath);
		atchFileVO.setFileExtsn(fileExtension);
		
		//파일 세부정보 저장
		fileDao.insertAtchFileDetail(atchFileVO);
		
		item.delete(); //임시 업로드 파일 삭제하기
		
		return atchFileVO;
	}

	@Override
	public AtchFileVO saveAtchFileList(Map<String, Object> fileItemMap) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AtchFileVO> getAtchFileList(AtchFileVO fileVO) throws SQLException {
		return fileDao.getAtchFileList(fileVO);
	}

	@Override
	public AtchFileVO getAtchFileDetail(AtchFileVO fileVO) throws SQLException {
		return fileDao.getAtchFileDetail(fileVO);
	}

}
