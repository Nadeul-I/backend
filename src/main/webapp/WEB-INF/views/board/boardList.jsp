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

    <main class="board-list-main">
      <div class="board-list-container">
        <div class="board-list-header">
          <div>
            <h2>자유 게시판</h2>
          </div>

          <form action="${root }/board/list" method="GET" class="board-list-form">
            <input type="hidden" name="pgno" value="${pgno}" />
            <select name="search" id="board-list-search-select" aria-label="검색조건">
              <option selected>검색조건</option>
              <option value="boardTitle">제목</option>
              <option value="boardId">작성자</option>
            </select>
            <div class="board-list-key-container">
              <input
                type="text"
                name="word"
                id="board-list-word"
                placeholder="검색어..."
              />
              <button id="board-list-search-btn"  type="submit">
                <img
                  id="board-list-img"
                  src="${root}/assets/img/search.png"
                  alt="search-img load fail"
                />
              </button>
            </div>
          </form>
        </div>

        <div class="board-list-sort">
          <a href="">최신순</a> <a href="">좋아요순</a>
        </div>

        <div class="board-list-list-container">
          <ul>
            <li>
              <div class="board-list-title">
                <div>제목</div>
                <div>이름</div>
                <div>조회수</div>
                <div>날짜</div>
              </div>
            </li>
            <c:forEach var="board" items="${boards}">
              <li>
                <div class="board-list-content" data-no="${board.boardNo}">
                  <div>${board.boardTitle}</div>
                  <div>${board.boardId}</div>
                  <div>${board.boardHit}</div>
                  <div>${board.boardDate}</div>
                </div>
              </li>
            </c:forEach>
          </ul>
        </div>

        <div class="board-list-write-container">
        <span>
          <button id="board-list-write-btn" class="btn btn-write"> 글쓰기</button>
        </span>
        </div>

        <div class="navigator">${navigation.navigator}</div>
      </div>
    </main>
    
    <form id="board-list-list" method="get" action="${root}/board/list">
      <input type="hidden" id="pgno" name="pgno" value="" />
      <input type="hidden" name="search" value="${search}" />
      <input type="hidden" name="word" value="${word}" />
    </form>

    <form id="board-list-view" method="get" action="${root}/board/view">
      <input type="hidden" name="pgno" value="${pgno}" />
      <input type="hidden" name="search" value="${search}" />
      <input type="hidden" name="word" value="${word}" />
      <input type="hidden" id="boardNo" name="boardNo" value="" />
    </form>

    <form id="board-list-write" method="get" action="${root}/board/write">
      <input type="hidden" name="pgno" value="${pgno}" />
      <input type="hidden" name="search" value="${search}" />
      <input type="hidden" name="word" value="${word}" />
    </form>


    <script>
      let titles = document.querySelectorAll(".board-list-content");
      titles.forEach(function (title) {
        title.addEventListener("click", function () {
          document.querySelector("#boardNo").value =
            this.getAttribute("data-no");
          document.querySelector("#board-list-view").submit();
        });
      });

      let boardWrite = document.getElementById("board-list-write-btn");
      boardWrite.addEventListener("click", function(){
        document.getElementById("board-list-write").submit();
      })   

      let paginationAnchors = document.querySelectorAll(".page-item");
      paginationAnchors.forEach(function(paginationAnchor){
        paginationAnchor.addEventListener("click", function(){
          document.querySelector("#pgno").value= this.getAttribute("data-pg");
          document.querySelector("#board-list-list").submit();
        })
      })
    </script>
  </body>
</html>
