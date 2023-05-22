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

    <main class="board-modify-main">
      <div class="board-modify-container">
        <div class="board-modify-header">
          <div>
            <h2>자유 게시판</h2>
          </div>
          <button class="board-modify-list-btn btn btn-list">≡목록가기</button>
        </div>

        <form action="${root}/board/modify" method="post">
          <input type="hidden" name="boardNo" value="${board.boardNo}" />
          <input type="hidden" name="pgno" value="${pgno}" />
          <input type="hidden" name="search" value="${search}" />
          <input type="hidden" name="word" value="${word}" />
          <div>
            <input
              name="boardTitle"
              class="board-modify-title"
              type="text"
              placeholder="제목을 입력해주세요."
              value="${board.boardTitle}"
            />
          </div>
          <div>
            <input
              name="boardContent"
              class="board-modify-content"
              type="text"
              placeholder="내용을 입력하세요"
              value="${board.boardContent}"
            />
          </div>

          <div class="board-modify-check-container">
            <span>
              <button type="submit" class="btn">수정</button>
            </span>
            <span>
              <button type="button" class="board-modify-cancle-btn btn">
                취소
              </button>
            </span>
          </div>
        </form>
      </div>
    </main>

    <form id="board-modify-view" method="get" action="${root}/board/view">
      <input type="hidden" name="boardNo" value="${board.boardNo}" />
      <input type="hidden" name="pgno" value="${pgno}" />
      <input type="hidden" name="search" value="${search}" />
      <input type="hidden" name="word" value="${word}" />
    </form>

    <script>
      let boardModifyLists = document.querySelectorAll(
        ".board-modify-list-btn, .board-modify-cancle-btn"
      );
      boardModifyLists.forEach(function (boardModifyList) {
        boardModifyList.addEventListener("click", function () {
          document.getElementById("board-modify-view").submit();
        });
      });
    </script>
  </body>
</html>
