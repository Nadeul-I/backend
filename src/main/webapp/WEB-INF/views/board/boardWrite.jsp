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

    <main class="board-write-main">
      <div class="board-write-container">
        <div class="board-write-header">
          <div>
            <h2>자유 게시판</h2>
          </div>
          <button class="board-write-list-btn btn btn-list">≡목록가기</button>
        </div>

        <form action="${root}/board/write" method="post">
          <input type="hidden" name="boardId" value="${userDto.userId}" />
          <div>
            <input
              name="boardTitle"
              class="board-write-title"
              type="text"
              placeholder="제목을 입력해주세요."
            />
          </div>
          <div>
            <input
              name="boardContent"
              class="board-write-content"
              type="text"
              placeholder="내용을 입력하세요"
            />
          </div>
          <div class="board-write-check-container">
            <span>
              <button type="submit" class="btn">확인</button>
            </span>
            <span>
              <button type="button" class="board-write-cancle-btn btn">취소</button>
            </span>
          </div>
        </form>
      </div>
    </main>

    <form id="board-write-list" method="get" action="${root}/board/list">
      <input type="hidden" name="pgno" value="${pgno}" />
      <input type="hidden" name="search" value="${search}" />
      <input type="hidden" name="word" value="${word}" />
    </form>

    <script>
      let boardWriteLists = document.querySelectorAll(".board-write-list-btn, .board-write-cancle-btn");
      boardWriteLists.forEach(function (boardWriteList) {
        boardWriteList.addEventListener("click", function () {
          document.getElementById("board-write-list").submit();
        });
      });
    </script>
  </body>
</html>
