<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <%@ include file="../include/head.jsp"%>
  </head>
  <body>
    <!-- header nav start -->
    <c:import url="../include/nav.jsp" />
    <!-- header nav end -->

    <div class="lump"></div>

    <main class="board-view-main">
      <div class="board-view-container">
        <div class="board-view-header">
          <div>
            <h2>자유 게시판</h2>
          </div>
          <button class="board-view-list-btn btn btn-list">≡ 목록가기</button>
        </div>

        <div class="board-view-title">
          <h2>${board.boardTitle}</h2>
          <div>${board.boardDate}</div>
        </div>

        <div>
          <div class="board-view-content">${board.boardContent}</div>
        </div>
        <c:if test="${userDto.userId eq board.boardId}">
          <div class="board-view-condition-container">
            <span>
              <button type="button" class="btn board-view-modify-btn">
                수정
              </button>
            </span>
            <span>
              <button type="button" class="btn board-view-delete-btn">
                삭제
              </button>
            </span>
          </div>
        </c:if>
      </div>
    </main>
  </body>

  <!-- view -> list -->
  <form id="board-view-list" method="get" action="${root}/board/list">
    <input type="hidden" name="pgno" value="${pgno}" />
    <input type="hidden" name="search" value="${search}" />
    <input type="hidden" name="word" value="${word}" />
  </form>

  <!-- view -> modify -->
  <form id="board-view-modify" method="get" action="${root}/board/modify">
    <input type="hidden" name="boardNo" value="${board.boardNo}" />
    <input type="hidden" name="pgno" value="${pgno}" />
    <input type="hidden" name="search" value="${search}" />
    <input type="hidden" name="word" value="${word}" />
  </form>

  <!-- view -> delete -->
  <form id="board-view-delete" method="get" action="${root}/board/delete">
    <input type="hidden" name="boardNo" value="${board.boardNo}" />
  </form>

  <script>
    let boardListBtn = document.querySelector(".board-view-list-btn");
    boardListBtn.addEventListener("click", function () {
      document.getElementById("board-view-list").submit();
    });

    let boardListModifyBtn = document.querySelector(".board-view-modify-btn");
    boardListModifyBtn.addEventListener("click", function () {
      document.getElementById("board-view-modify").submit();
    });

    let boardListDeleteBtn = document.querySelector(".board-view-delete-btn");
    boardListDeleteBtn.addEventListener("click", function () {
      document.getElementById("board-view-delete").submit();
    });
  </script>
</html>
