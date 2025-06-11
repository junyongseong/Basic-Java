-- 도서들을 저장하는 테이블 생성해 보자!
-- 하나의 도서 정보(도서명, 도서고유 번호, 저자, 출판사, 가격,등록일...)

	CREATE TABLE book_t(
		b_idx BIGINT(4) AUTO_INCREMENT,
		title CHAR(50),
		author VARCHAR(50),
		press VARCHAR(50),
		price DECIMAL(9,1),
		CONSTRAINT book_t_pk PRIMARY KEY(b_idx)
	);

-- 테이블 수정( 컬럼추가)
--	등록일 컬럼을 추가한다.
--	등록일 컬럼을 press컬럼 뒤에 추가할 때 어떻게 해야하나?
	ALTER TABLE book_t
	ADD COLUMN reg_date DATE AFTER press;
    
-- 테이블 수정(컬럼의 자료형 변경)
-- 제목의 자료형 길이를 200으로 변경하고자 한다.
	ALTER TABLE book_t
	MODIFY title VARCHAR(200);
    
-- 테이블 수정(컬럼명 변경)
--	title 컬럼명을 subject로 변경하자!
	ALTER TABLE book_t
	RENAME COLUMN title to subject;
    
-- 테이블 수정(컬럼 삭제)
-- 출판사(press)정보는 삭제하자!
	ALTER TABLE book_t
	DROP COLUMN press;
    

    
    