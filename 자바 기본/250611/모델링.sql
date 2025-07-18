-- 예술품 (그림) 정보가 저장되는 테이블 작성
--	(제목, 작가, 유형, 가격, 제작년도, 등록일, 
	CREATE TABLE art_t( 
		art_idx BIGINT(6) AUTO_INCREMENT,
		subject VARCHAR(100) NOT NULL,
		author VARCHAR(50) NOT NULL,
		type VARCHAR(30),
		price DECIMAL(9,2),
		make_year VARCHAR(20),
		reg_date DATE,
		CONSTRAINT art_t_pk PRIMARY KEY(art_idx)
	);

-- 회원정보가 저장되는 테이블 작성
--	(회원명, 아이디, 비밀번호, 연락처, 주소, 등록일)
	CREATE TABLE member_t(
		m_idx BIGINT(6) AUTO_INCREMENT,
		m_name VARCHAR(50) NOT NULL,
		m_id VARCHAR(30) NOT NULL,
		m_pw VARCHAR(50) NOT NULL,
		m_phone VARCHAR(20) NOT NULL,
		m_addr VARCHAR(50),
		reg_date DATE,
		status INT(1) DEFAULT 0,
		etc1 VARCHAR(10),
		etc2 VARCHAR(10),
		CONSTRAINT member_t_pk PRIMARY KEY(m_idx)
	);

-- 판매정보를 저장하는 테이블 작성
--	(판매할 그림정보, 구매하는 회원정보, 판매일, 거래일, 상태)
	CREATE TABLE sales_t(
		s_idx BIGINT(6) AUTO_INCREMENT PRIMARY KEY,
		art_idx BIGINT(6) NOT NULL,
		m_idx BIGINT(6) NOT NULL,
		start_date DATE,
		sale_date DATE,
		status INT(1),
		CONSTRAINT sales_t_fk1 FOREIGN KEY(art_idx) REFERENCES art_t(art_idx),
		CONSTRAINT sales_t_fk2 FOREIGN KEY(m_idx) REFERENCES member_t(m_idx)
	);
