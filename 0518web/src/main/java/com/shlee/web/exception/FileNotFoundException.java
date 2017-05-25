package com.shlee.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FileNotFoundException extends Exception {

	// 파일이 없을 때의 예외 지정
	// 원래 클라이언트가 요청한 파일이 없으면 500 error 발생
	// 하지만 클라이언트가 요청한 파일이 없다는 것은 페이지가 없는 것처럼 인식 시켜주고 싶을 때도 있음

	// 개발자가 만든 예외인 FileNotFoundException이 발생되면
	// 404 NOT FOUND 를 할 수 있다.
	// 원래라면 없는 파일을 요청 했기 때문에 IOException - 500 ERROR가 응답된다.
	@Override
	public String getMessage() {
		return "You have requested an unexisting file";
	}
	

}
