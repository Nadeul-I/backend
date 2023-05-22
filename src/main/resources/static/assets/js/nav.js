window.onscroll = function () {
  navScroll();
};

function navScroll() {
  const headerContainerElement =
    document.getElementsByClassName("header-container")[0];
  const headerAnchorElements = document.querySelectorAll(".header-container a");
  const headerSpanElements = document.querySelectorAll(".hamburger span");
  if (document.body.scrollTop > 40 || document.documentElement.scrollTop > 40) {
    console.dir(headerContainerElement);
    headerContainerElement.style.borderBottom = "1px solid rgb(255,255,255)";
    headerContainerElement.style.backgroundColor = "rgb(0, 0, 0)";

    console.dir(headerAnchorElements);
    for (const headerAnchorElement of headerAnchorElements) {
      headerAnchorElement.style.color = "rgb(255, 255, 255)";
    }

    for (const headerSpanElement of headerSpanElements) {
      headerSpanElement.style.backgroundColor = "rgb(255, 255, 255)";
    }
  } else {
    headerContainerElement.style.borderBottom = "1px solid rgb(0,0,0)";
    headerContainerElement.style.backgroundColor = "transparent";

    for (const headerAnchorElement of headerAnchorElements) {
      headerAnchorElement.style.color = "rgb(0,0,0)";
    }

    for (const headerSpanElement of headerSpanElements) {
      headerSpanElement.style.backgroundColor = "rgb(0, 0, 0)";
    }
  }
}
