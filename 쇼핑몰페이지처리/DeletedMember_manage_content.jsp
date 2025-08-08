<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>
  // JS에서 contextPath를 바로 쓰려고 선언해 놓음
  var contextPath = '${pageContext.request.contextPath}';
</script>
<!-- jQuery와 AJAX 스크립트 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%-- 검색 로직 유효성 검사 넣은 스크립트--%>
<script src="${pageContext.request.contextPath}/js/member_search.js"></script>
<%--비동기식 멤버 삭제 넣은 스크립트--%>
<script src="${pageContext.request.contextPath}/js/member_delete.js"></script>
<%--메모 눌렀을때 --%>
<script src="${pageContext.request.contextPath}/js/member_memo.js"></script>
<%--관리 눌렀을때--%>
<script src="${pageContext.request.contextPath}/js/member_edit.js"></script>
<%--모달창 css--%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/addUserModal.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/member_manage.css">
<%--모달창 js불러옴--%>
<script src="${pageContext.request.contextPath}/js/member_modal.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/member_manage.css">
<div class="member-main"> <!-- 전체를 감싸게 함 -->


  <%--  엔터키와 검색버튼 모두 AJAX처리함--%>
  <div class="member-toolbar">
    <%--  AJAX말고 동기식으로함 --%>
    <form id="searchForm" method="GET" action="${pageContext.request.contextPath}/Controller">
      <input type="hidden" name="type" value="deletedmembermanage" />
      <select name="searchType">
        <option value="mb_name" ${param.searchType == 'mb_name' ? 'selected' : ''}>이름</option>
        <option value="mb_id" ${param.searchType == 'mb_id' ? 'selected' : ''}>아이디</option>
        <option value="mb_email" ${param.searchType == 'mb_email' ? 'selected' : ''}>이메일</option>
        <option value="mb_rank" ${param.searchType == 'mb_rank' ? 'selected' : ''}>등급</option>
      </select>
      <input type="text" name="searchKeyword" value="${param.searchKeyword}" placeholder="검색어 입력..." />
      <button type="submit">검색</button>
    </form>

      <div class="btn-group">
        <a href="?type=deletedmembermanage&mb_status=all"
           class="btn ${param.mb_status eq 'all' or empty param.mb_status ? 'active' : ''}">
          전체 보기
        </a>

        <a href="?type=deletedmembermanage&mb_status=2"
           class="btn ${param.mb_status eq '2' ? 'active' : ''}">
          정지 회원 보기
        </a>

        <a href="?type=deletedmembermanage&mb_status=0"
           class="btn ${param.mb_status eq '0' ? 'active' : ''}">
          탈퇴 회원 보기
        </a>
      </div>
  </div>

  <!-- 회원 테이블 -->
  <div class="member-table-wrapper">
    <table class="member-table">
      <thead>
      <tr>
        <th>체크</th>
        <th>이름</th>
        <th>아이디</th>
        <th>이메일</th>
        <th>쇼핑등급</th>
        <th>생년월일</th>
        <th>가입일</th>
        <th>적립금</th>
        <th>누적 구매금액</th>
        <th>메모</th>
        <th>관리</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="vo" items="${memberlist}">
        <tr class="member-row"
          <%--   미리 데이터 값 넣어놓음--%>
            data-idx="${vo.mb_idx}"
            data-name="${vo.mb_name}"
            data-id="${vo.mb_id}"
            data-email="${vo.mb_email}"
            data-gender="${vo.mb_gender}"
            data-phone="${vo.mb_phone}"
            data-birth="${vo.mb_birth}"
            data-rank="${vo.mb_rank}"
            data-status="${vo.mb_status}"
            data-ban-reason="${vo.ban_reason}"
            data-ban-start="${vo.ban_start}"
            data-ban-end="${vo.ban_end}">

          <td><input type="checkbox" class="row-check" value="${vo.mb_idx}"/></td>
          <td>${vo.mb_name}</td>
          <td>${vo.mb_id}</td>
          <td>${vo.mb_email}</td>
          <td>
            <c:choose>
              <c:when test="${vo.mb_rank == 0}">브론즈</c:when>
              <c:when test="${vo.mb_rank == 1}">실버</c:when>
              <c:when test="${vo.mb_rank == 2}">골드</c:when>
              <c:otherwise>랭크 없음</c:otherwise>
            </c:choose>
          </td>
          <td>${vo.mb_birth}</td>
          <td>${vo.mb_reg_date}</td>
          <td>0</td>
          <td>0원</td>
          <td><i class="memo-icon">✎</i></td>
          <td><button class="edit-btn">...</button></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>
<div class="pagination-wrapper">
  <div class="pagination-container">
    <%--미리 페이지 계산--%>
<%--  mb_status값도 넘겨줘야 페이지를 넘길때 페이지가 이상해지지 않음--%>
    <c:set var="pageCountRaw" value="${(totalCount + pageSize - 1) / pageSize}" />
    <c:set var="pageCount" value="${fn:substringBefore(pageCountRaw, '.')}" />
      <ul class="pagination">
        <%-- 이전 페이지 이동 버튼 --%>
        <c:if test="${page > 1}">
          <li>
            <a href="?type=deletedmembermanage&page=${page - 1}&mb_status=${mb_status}
            &searchType=${param.searchType}&searchKeyword=${param.searchKeyword}">
              &lt; 이전
            </a>
          </li>
        </c:if>
<%--페이지 번호 출력 --%>
      <c:forEach var="i" begin="1" end="${pageCount}">
        <li class="${page == i ? 'active' : ''}">
          <a href="?type=deletedmembermanage&page=${i}&mb_status=${mb_status}
          &searchType=${param.searchType}&searchKeyword=${param.searchKeyword}">
              ${i}
          </a>
        </li>
      </c:forEach>

<%-- 다음 페이지 이동기능임--%>
      <c:if test="${page < pageCount}">
        <li>
          <a href="?type=deletedmembermanage&page=${page + 1}
          &mb_status=${mb_status}&searchType=${param.searchType}&searchKeyword=${param.searchKeyword}">
            다음 &gt;
          </a>
        </li>
      </c:if>
    </ul>
    <%--페이지 이동 기능--%>
    <form class="goto-form" method="get" action="">
      <input type="hidden" name="type" value="deletedmembermanage" />
      <input type="hidden" name="mb_status" value="${mb_status}" />
      <input type="hidden" name="searchType" value="${param.searchType}" />
      <input type="hidden" name="searchKeyword" value="${param.searchKeyword}" />

      <%--현재 페이지 보여줌--%>
      <input type="number" name="page" min="1" max="${pageCount}" value="${page}" />
      <span>/ <fmt:formatNumber value="${pageCount}" type="number" maxFractionDigits="0" /></span>
      <button type="submit">이동</button>
    </form>
  </div>
</div>

<!-- 회원 수정 모달 -->
<div id="editUserModal" class="modal" style="display: none;">
  <form id="editUserForm">
    <input type="hidden" name="mb_idx" id="edit_mb_idx" />

    이름: <input type="text" name="mb_name" id="edit_mb_name" readonly><br>
    아이디: <input type="text" name="mb_id" id="edit_mb_id" readonly><br>
    <span id="edit-id-check" style="display:none;"></span><br>

    성별:
    <select name="mb_gender" id="edit_mb_gender" disabled>
      <option value="M">남자</option>
      <option value="F">여자</option>
    </select><br>

    이메일: <input type="email" name="mb_email" id="edit_mb_email" readonly><br>
    <span id="edit-email-check" style="display:none;"></span><br>

    전화번호: <input type="text" name="mb_phone" id="edit_mb_phone" readonly><br>
    생년월일: <input type="date" name="mb_birth" id="edit_mb_birth" readonly><br>

    <!-- 관리자만 수정 가능한 항목 -->
    쇼핑등급:
    <select name="mb_rank" id="edit_mb_rank">
      <option value="0">브론즈</option>
      <option value="1">실버</option>
      <option value="2">골드</option>
    </select><br>
    상태:
    <select name="mb_status" id="edit_mb_status">
      <option value="1">정상</option>
      <option value="0">탈퇴</option>
      <option value="2">정지</option>
    </select><br>

    <%-- mb_status가 2일때--%>
    <div id="banSection" style="display: none;">
      정지 사유: <input type="text" name="ban_reason" id="ban_reason"><br>
      정지 시작일: <input type="date" name="ban_start" id="ban_start"><br>
      정지 종료일: <input type="date" name="ban_end" id="ban_end"><br>
    </div>

    <button type="button" onclick="submitEditMember()">저장</button>
    <button type="button" onclick="closeEditMemberModal()">닫기</button>
  </form>
</div>

<%--js및 css는 member_memo.js랑 addUserModal.css 사용함--%>
<!-- 메모 모달 (공통 1개만) -->
<div id="memoModal" class="memo-modal hidden">
  <textarea id="memoContent" placeholder="메모를 작성하세요..."></textarea>
  <div class="memo-actions">
    <button id="memoSaveBtn">저장</button>
    <button id="memoCloseBtn">닫기</button>
  </div>
</div>